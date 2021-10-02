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
 * Use the {@link KataganaZukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KataganaZukFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button[][] buttons = new  Button[5][5];
    private AlertDialog.Builder diaBuilder;
    private AlertDialog dialog;
    DrawingActivity drawingActivity;
    TextToSpeech mTTs;
    public KataganaZukFragment() {
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
    public static KataganaZukFragment newInstance(String param1, String param2) {
        KataganaZukFragment fragment = new KataganaZukFragment();
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
        View v = inflater.inflate(R.layout.fragment_katagana_zuk, container, false);
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
        buttons[0][0] = v.findViewById(R.id.btnGa);
        buttons[0][1] = v.findViewById(R.id.btnGi);
        buttons[0][2] = v.findViewById(R.id.btnGu);
        buttons[0][3] = v.findViewById(R.id.btnGe);
        buttons[0][4] = v.findViewById(R.id.btnGo);

        buttons[1][0] = v.findViewById(R.id.btnZa);
        buttons[1][1] = v.findViewById(R.id.btnZi);
        buttons[1][2] = v.findViewById(R.id.btnZu);
        buttons[1][3] = v.findViewById(R.id.btnZe);
        buttons[1][4] = v.findViewById(R.id.btnZo);

        buttons[2][0] = v.findViewById(R.id.btnDa);
        buttons[2][1] = v.findViewById(R.id.btnDi);
        buttons[2][2] = v.findViewById(R.id.btnDu);
        buttons[2][3] = v.findViewById(R.id.btnDe);
        buttons[2][4] = v.findViewById(R.id.btnDo);

        buttons[3][0] = v.findViewById(R.id.btnBa);
        buttons[3][1] = v.findViewById(R.id.btnBi);
        buttons[3][2] = v.findViewById(R.id.btnBu);
        buttons[3][3] = v.findViewById(R.id.btnBe);
        buttons[3][4] = v.findViewById(R.id.btnBo);

        buttons[4][0] = v.findViewById(R.id.btnPa);
        buttons[4][1] = v.findViewById(R.id.btnPi);
        buttons[4][2] = v.findViewById(R.id.btnPu);
        buttons[4][3] = v.findViewById(R.id.btnPe);
        buttons[4][4] = v.findViewById(R.id.btnPo);
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