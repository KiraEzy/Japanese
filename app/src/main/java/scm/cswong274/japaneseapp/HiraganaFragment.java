package scm.cswong274.japaneseapp;;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HiraganaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HiraganaFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AlertDialog.Builder diaBuilder;
    private AlertDialog dialog;
    DrawingActivity drawingActivity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button[][] buttons = new  Button[10][5];
    TextToSpeech mTTs;
    View v;
    public HiraganaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HiraganaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HiraganaFragment newInstance(String param1, String param2) {
        HiraganaFragment fragment = new HiraganaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_hiragana, container, false);

        mTTs = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int lang = mTTs.setLanguage(Locale.JAPANESE);
                    mTTs.setSpeechRate(1.0f);
                    if (lang == TextToSpeech.LANG_MISSING_DATA){
                        Log.e("TextToSpeech", "MissingSpeechData");
                    }
                }
                else {
                    Log.e("TextToSpeech", "FailToInitialize");

                }
            }
        }, "com.google.android.tts");
        // Inflate the layout for this fragment [y,x]
        buttons[0][0] = v.findViewById(R.id.nBtnA);
        buttons[0][1] = v.findViewById(R.id.nBtnI);
        buttons[0][2] = v.findViewById(R.id.nBtnU);
        buttons[0][3] = v.findViewById(R.id.nBtnE);
        buttons[0][4] = v.findViewById(R.id.nBtnO);

        buttons[1][0] = v.findViewById(R.id.nBtnKa);
        buttons[1][1] = v.findViewById(R.id.nBtnKi);
        buttons[1][2] = v.findViewById(R.id.nBtnKu);
        buttons[1][3] = v.findViewById(R.id.nBtnKe);
        buttons[1][4] = v.findViewById(R.id.nBtnKo);

        buttons[2][0] = v.findViewById(R.id.nBtnSa);
        buttons[2][1] = v.findViewById(R.id.nBtnSi);
        buttons[2][2] = v.findViewById(R.id.nBtnSu);
        buttons[2][3] = v.findViewById(R.id.nBtnSe);
        buttons[2][4] = v.findViewById(R.id.nBtnSo);

        buttons[3][0] = v.findViewById(R.id.nBtnTa);
        buttons[3][1] = v.findViewById(R.id.nBtnTi);
        buttons[3][2] = v.findViewById(R.id.nBtnTu);
        buttons[3][3] = v.findViewById(R.id.nBtnTe);
        buttons[3][4] = v.findViewById(R.id.nBtnTo);

        buttons[4][0] = v.findViewById(R.id.nBtnNa);
        buttons[4][1] = v.findViewById(R.id.nBtnNi);
        buttons[4][2] = v.findViewById(R.id.nBtnNu);
        buttons[4][3] = v.findViewById(R.id.nBtnNe);
        buttons[4][4] = v.findViewById(R.id.nBtnNo);

        buttons[5][0] = v.findViewById(R.id.nBtnHa);
        buttons[5][1] = v.findViewById(R.id.nBtnHi);
        buttons[5][2] = v.findViewById(R.id.nBtnHu);
        buttons[5][3] = v.findViewById(R.id.nBtnHe);
        buttons[5][4] = v.findViewById(R.id.nBtnHo);

        buttons[6][0] = v.findViewById(R.id.nBtnMa);
        buttons[6][1] = v.findViewById(R.id.nBtnMi);
        buttons[6][2] = v.findViewById(R.id.nBtnMu);
        buttons[6][3] = v.findViewById(R.id.nBtnMe);
        buttons[6][4] = v.findViewById(R.id.nBtnMo);

        buttons[7][0] = v.findViewById(R.id.nBtnYa);
        buttons[7][1] = v.findViewById(R.id.nBtnYi);
        buttons[7][2] = v.findViewById(R.id.nBtnYu);
        buttons[7][3] = v.findViewById(R.id.nBtnYe);
        buttons[7][4] = v.findViewById(R.id.nBtnYo);

        buttons[8][0] = v.findViewById(R.id.nBtnRa);
        buttons[8][1] = v.findViewById(R.id.nBtnRi);
        buttons[8][2] = v.findViewById(R.id.nBtnRu);
        buttons[8][3] = v.findViewById(R.id.nBtnRe);
        buttons[8][4] = v.findViewById(R.id.nBtnRo);

        buttons[9][0] = v.findViewById(R.id.nBtnWa);
        buttons[9][1] = v.findViewById(R.id.nBtnWi);
        buttons[9][2] = v.findViewById(R.id.nBtnWu);
        buttons[9][3] = v.findViewById(R.id.nBtnWe);
        buttons[9][4] = v.findViewById(R.id.nBtnWo);
        for (int i=0;i<buttons.length;i++)//y Size
        {
            for (int k=0;k<buttons[i].length;k++)//x size
            {
                buttons[i][k].setOnClickListener(this);
                buttons[i][k].setOnLongClickListener(this);
                //Log.i( "Button Setup", String.valueOf(buttons[i][k].getId()));
            }
        }
        return v;
    }

    @Override
    public void onClick(View view) {
        //mTTs.speak("Tester え",TextToSpeech.QUEUE_ADD,null);
        if (view.getId() == R.id.Clear){
            clear();
        }
        Log.i("btnID", String.valueOf(view.getId()));
        for (int i=0;i<buttons.length;i++)//y Size
        {
            for (int k=0;k<buttons[i].length;k++)//x size
            {
                if (view.getId() == buttons[i][k].getId()){
                    mTTs.speak(buttons[i][k].getText().toString(),TextToSpeech.QUEUE_ADD,null);
                    Log.i("btnID", "Speak " + buttons[i][k].getText().toString());
                }
            }
        }
    }
    /* * Code modified from function createNewContactDialog(), found at:
    https://www.youtube.com/watch?v=4GYKOzgQDWI&ab_channel=CodingMark*/
    void createDialog(String text){
        diaBuilder = new AlertDialog.Builder(this.getContext());
        View popUp = getLayoutInflater().inflate(R.layout.activity_drawing,null);
        diaBuilder.setView(popUp);
        drawingActivity = popUp.findViewById(R.id.drawingActivity3);
        TextView txt = popUp.findViewById(R.id.txtWord);
        Button btnClear = popUp.findViewById(R.id.Clear);
        btnClear.setOnClickListener(this);
        txt.setText(text);
        dialog = diaBuilder.create();
        dialog.show();//Code tweaked from

    }

    @Override
    public boolean onLongClick(View view) {
        Log.i("btnID", String.valueOf(view.getId()));
        for (int i=0;i<buttons.length;i++)//y Size
        {
            for (int k=0;k<buttons[i].length;k++)//x size
            {
                if (view.getId() == buttons[i][k].getId()){
                    createDialog((String) buttons[i][k].getText());
                }
            }
        }
        return false;
    }
    void clear(){
        Log.e("Clear", "onClick: " );
        drawingActivity.clear();
    }
}