package scm.cswong274.japaneseapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HiraganaZukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HiraganaZukFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AlertDialog.Builder diaBuilder;
    private AlertDialog dialog;
    TextToSpeech mTTs;
    DrawingActivity drawingActivity;
    // TODO: Rename and change types of parameters
    Button[][] buttons = new  Button[5][5];
    public HiraganaZukFragment() {
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
    public static HiraganaZukFragment newInstance(String param1, String param2) {
        HiraganaZukFragment fragment = new HiraganaZukFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hiragana_zuk, container, false);
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
        buttons[0][0] = v.findViewById(R.id.nBtnGa);
        buttons[0][1] = v.findViewById(R.id.nBtnGi);
        buttons[0][2] = v.findViewById(R.id.nBtnGu);
        buttons[0][3] = v.findViewById(R.id.nBtnGe);
        buttons[0][4] = v.findViewById(R.id.nBtnGo);

        buttons[1][0] = v.findViewById(R.id.nBtnZa);
        buttons[1][1] = v.findViewById(R.id.nBtnZi);
        buttons[1][2] = v.findViewById(R.id.nBtnZu);
        buttons[1][3] = v.findViewById(R.id.nBtnZe);
        buttons[1][4] = v.findViewById(R.id.nBtnZo);

        buttons[2][0] = v.findViewById(R.id.nBtnDa);
        buttons[2][1] = v.findViewById(R.id.nBtnDi);
        buttons[2][2] = v.findViewById(R.id.nBtnDu);
        buttons[2][3] = v.findViewById(R.id.nBtnDe);
        buttons[2][4] = v.findViewById(R.id.nBtnDo);

        buttons[3][0] = v.findViewById(R.id.nBtnBa);
        buttons[3][1] = v.findViewById(R.id.nBtnBi);
        buttons[3][2] = v.findViewById(R.id.nBtnBu);
        buttons[3][3] = v.findViewById(R.id.nBtnBe);
        buttons[3][4] = v.findViewById(R.id.nBtnBo);

        buttons[4][0] = v.findViewById(R.id.nBtnPa);
        buttons[4][1] = v.findViewById(R.id.nBtnPi);
        buttons[4][2] = v.findViewById(R.id.nBtnPu);
        buttons[4][3] = v.findViewById(R.id.nBtnPe);
        buttons[4][4] = v.findViewById(R.id.nBtnPo);
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
                    mTTs.speak(buttons[i][k].getText().toString(), TextToSpeech.QUEUE_ADD,null);
                    Log.i("btnID", "Speak " + buttons[i][k].getText().toString());
                }
            }
        }
    }
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
    }void clear(){
        Log.e("Clear", "onClick: " );
        drawingActivity.clear();
    }
}