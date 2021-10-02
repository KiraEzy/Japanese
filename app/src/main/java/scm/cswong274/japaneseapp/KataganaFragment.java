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
 * Use the {@link KataganaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KataganaFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button[][] buttons = new Button[10][5];
    TextToSpeech mTTs;
    private AlertDialog.Builder diaBuilder;
    private AlertDialog dialog;
    DrawingActivity drawingActivity;
    public KataganaFragment() {
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
    public static KataganaFragment newInstance(String param1, String param2) {
        KataganaFragment fragment = new KataganaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_katagana, container, false);
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
        buttons[0][0] = v.findViewById(R.id.btnA);
        buttons[0][1] = v.findViewById(R.id.btnI);
        buttons[0][2] = v.findViewById(R.id.btnU);
        buttons[0][3] = v.findViewById(R.id.btnE);
        buttons[0][4] = v.findViewById(R.id.btnO);

        buttons[1][0] = v.findViewById(R.id.btnKa);
        buttons[1][1] = v.findViewById(R.id.btnKi);
        buttons[1][2] = v.findViewById(R.id.btnKu);
        buttons[1][3] = v.findViewById(R.id.btnKe);
        buttons[1][4] = v.findViewById(R.id.btnKo);

        buttons[2][0] = v.findViewById(R.id.btnSa);
        buttons[2][1] = v.findViewById(R.id.btnSi);
        buttons[2][2] = v.findViewById(R.id.btnSu);
        buttons[2][3] = v.findViewById(R.id.btnSe);
        buttons[2][4] = v.findViewById(R.id.btnSo);

        buttons[3][0] = v.findViewById(R.id.btnTa);
        buttons[3][1] = v.findViewById(R.id.btnTi);
        buttons[3][2] = v.findViewById(R.id.btnTu);
        buttons[3][3] = v.findViewById(R.id.btnTe);
        buttons[3][4] = v.findViewById(R.id.btnTo);

        buttons[4][0] = v.findViewById(R.id.btnNa);
        buttons[4][1] = v.findViewById(R.id.btnNi);
        buttons[4][2] = v.findViewById(R.id.btnNu);
        buttons[4][3] = v.findViewById(R.id.btnNe);
        buttons[4][4] = v.findViewById(R.id.btnNo);

        buttons[5][0] = v.findViewById(R.id.btnHa);
        buttons[5][1] = v.findViewById(R.id.btnHi);
        buttons[5][2] = v.findViewById(R.id.btnHu);
        buttons[5][3] = v.findViewById(R.id.btnHe);
        buttons[5][4] = v.findViewById(R.id.btnHo);

        buttons[6][0] = v.findViewById(R.id.btnMa);
        buttons[6][1] = v.findViewById(R.id.btnMi);
        buttons[6][2] = v.findViewById(R.id.btnMu);
        buttons[6][3] = v.findViewById(R.id.btnMe);
        buttons[6][4] = v.findViewById(R.id.btnMo);

        buttons[7][0] = v.findViewById(R.id.btnYa);
        buttons[7][1] = v.findViewById(R.id.btnYi);
        buttons[7][2] = v.findViewById(R.id.btnYu);
        buttons[7][3] = v.findViewById(R.id.btnYe);
        buttons[7][4] = v.findViewById(R.id.btnYo);

        buttons[8][0] = v.findViewById(R.id.btnRa);
        buttons[8][1] = v.findViewById(R.id.btnRi);
        buttons[8][2] = v.findViewById(R.id.btnRu);
        buttons[8][3] = v.findViewById(R.id.btnRe);
        buttons[8][4] = v.findViewById(R.id.btnRo);

        buttons[9][0] = v.findViewById(R.id.btnWa);
        buttons[9][1] = v.findViewById(R.id.btnWi);
        buttons[9][2] = v.findViewById(R.id.btnWu);
        buttons[9][3] = v.findViewById(R.id.btnWe);
        buttons[9][4] = v.findViewById(R.id.btnWo);
        for (int i = 0; i < buttons.length; i++)//y Size
        {
            for (int k = 0; k < buttons[i].length; k++)//x size
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
        if (view.getId() == R.id.Clear){
            clear();
        }
        //mTTs.speak("Tester え",TextToSpeech.QUEUE_ADD,null);
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