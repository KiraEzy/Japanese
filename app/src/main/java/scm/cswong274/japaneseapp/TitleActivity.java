package scm.cswong274.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_gojuon,btn_practice,btn_Convertion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        btn_gojuon = findViewById(R.id.btnGojuon);
        btn_Convertion = findViewById(R.id.btnConvertion);

        btn_gojuon.setOnClickListener(this);
        btn_Convertion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case(R.id.btnGojuon):
                intent = new Intent(TitleActivity.this, MainActivity.class);
                break;
            case(R.id.btnConvertion):
                intent = new Intent(TitleActivity.this, ConvertionActivity.class);
                break;
        }

        startActivity(intent);
    }
}