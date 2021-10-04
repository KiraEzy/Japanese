package scm.cswong274.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    Button btn_katagana,btn_zuk;
    int HiraKata = 1;
    int CZA = 1;
    private static final String TAG = "MyActivity";
    private static final int KATA = 2, HIRA = 1, AU = 3,ZUK = 2, NORMAL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        btn_katagana = findViewById(R.id.btnswitch1);
        btn_zuk = findViewById(R.id.btnswitch2);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new HiraganaFragment()).commit();
        btn_katagana.setOnClickListener(this);
        btn_zuk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){

            case (R.id.btnswitch1):

                if (HiraKata==HIRA){HiraKata = KATA;}
                else if (HiraKata==KATA){HiraKata = HIRA;}
                SwapFragment();
                break;

            case (R.id.btnswitch2):
                if(CZA == NORMAL)
                {CZA = ZUK;}
                else if (CZA == ZUK)
                {CZA=NORMAL;}
                SwapFragment();

                break;
        }

        fragmentTransaction = fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
        Log.i(TAG, "Fragment Changed");
        Log.i(TAG, "Button Pressed");
    }

    public void SwapFragment(){
        switch (CZA){
            case (NORMAL):
                Log.i(TAG, "NORMAL");
                if (HiraKata == HIRA) {
                    fragment = new HiraganaFragment();
                    Log.i(TAG, "HIRA");
                    btn_katagana.setText("HIRA");
                }
                else if (HiraKata == KATA) {
                    fragment = new KataganaFragment();
                    Log.i(TAG, "KATA");
                    btn_katagana.setText("KATA");
                }
                btn_zuk.setText("NORMAL");
                break;

            case (ZUK):
                Log.i(TAG, "DAKUTEN");
                if (HiraKata == HIRA) {
                    fragment = new HiraganaZukFragment();
                    Log.i(TAG, "HIRA");
                    btn_katagana.setText("HIRA");

                }
                else if (HiraKata == KATA) {
                    fragment = new KataganaZukFragment();
                    Log.i(TAG, "KATA");
                    btn_katagana.setText("KATA");
                }
                btn_zuk.setText("DAKUTEN");
                break;
        }
        Log.i(TAG, "HiraKata = " + HiraKata + "CZA = " + CZA);
    }
}