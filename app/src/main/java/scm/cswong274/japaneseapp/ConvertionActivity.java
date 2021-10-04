package scm.cswong274.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ConvertionActivity extends AppCompatActivity implements View.OnClickListener {
    public String[] hiraganaWord = new  String[71];
    public String[] kataganaWord = new  String[71];
    TextView Question, Score, txt_currentQuestion,txt_allQuestion;
    String answer;
    int correctAns;
    int score = 0;
    int baseInterval = 100;
    int combo;
    int currentQuestion = 0;
    int allQuestion = 10;
    Button[] answers = new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion);
        Question = findViewById(R.id.QuestionConversion);
        txt_currentQuestion = findViewById(R.id.txtCurrentQuestion);
        txt_allQuestion = findViewById(R.id.txtMaxQuestion);
        Score = findViewById(R.id.txtScore);
        answers[0] = findViewById(R.id.btnChoice1);
        answers[1] = findViewById(R.id.btnChoice2);
        answers[2] = findViewById(R.id.btnChoice3);
        answers[3] = findViewById(R.id.btnChoice4);
        Score.setText(String.valueOf(score));
        txt_currentQuestion.setText(String.valueOf(allQuestion));
        for (int i = 0; i<answers.length;i++){
            answers[i].setOnClickListener(this);
            answers[i].setBackgroundColor(Color.BLUE);
        }
        hiraganaWord[0] = "あ";
        hiraganaWord[1] = "い";
        hiraganaWord[2] = "う";
        hiraganaWord[3] = "え";
        hiraganaWord[4] = "お";
        hiraganaWord[5] = "か";
        hiraganaWord[6] = "き";
        hiraganaWord[7] = "く";
        hiraganaWord[8] = "け";
        hiraganaWord[9] = "こ";
        hiraganaWord[10] = "さ";
        hiraganaWord[11] = "し";
        hiraganaWord[12] = "す";
        hiraganaWord[13] = "せ";
        hiraganaWord[14] = "そ";
        hiraganaWord[15] = "た";
        hiraganaWord[16] = "ち";
        hiraganaWord[17] = "つ";
        hiraganaWord[18] = "て";
        hiraganaWord[19] = "と";
        hiraganaWord[20] = "な";
        hiraganaWord[21] = "に";
        hiraganaWord[22] = "ぬ";
        hiraganaWord[23] = "ね";
        hiraganaWord[24] = "の";
        hiraganaWord[25] = "は";
        hiraganaWord[26] = "ひ";
        hiraganaWord[27] = "ふ";
        hiraganaWord[28] = "へ";
        hiraganaWord[29] = "ほ";
        hiraganaWord[30] = "ま";
        hiraganaWord[31] = "み";
        hiraganaWord[32] = "む";
        hiraganaWord[33] = "め";
        hiraganaWord[34] = "も";
        hiraganaWord[35] = "や";
        hiraganaWord[36] = "ゆ";
        hiraganaWord[37] = "よ";
        hiraganaWord[38] = "ら";
        hiraganaWord[39] = "り";
        hiraganaWord[40] = "る";
        hiraganaWord[41] = "れ";
        hiraganaWord[42] = "ろ";
        hiraganaWord[43] = "わ";
        hiraganaWord[44] = "を";
        hiraganaWord[45] = "ん";
        hiraganaWord[46] = "が";
        hiraganaWord[47] = "ぎ";
        hiraganaWord[48] = "ぐ";
        hiraganaWord[49] = "げ";
        hiraganaWord[50] = "ご";
        hiraganaWord[51] = "ざ";
        hiraganaWord[52] = "じ";
        hiraganaWord[53] = "ず";
        hiraganaWord[54] = "ぜ";
        hiraganaWord[55] = "ぞ";
        hiraganaWord[56] = "だ";
        hiraganaWord[57] = "ぢ";
        hiraganaWord[58] = "づ";
        hiraganaWord[59] = "で";
        hiraganaWord[60] = "ど";
        hiraganaWord[61] = "ば";
        hiraganaWord[62] = "び";
        hiraganaWord[63] = "ぶ";
        hiraganaWord[64] = "べ";
        hiraganaWord[65] = "ぼ";
        hiraganaWord[66] = "ぱ";
        hiraganaWord[67] = "ぴ";
        hiraganaWord[68] = "ぷ";
        hiraganaWord[69] = "ぺ";
        hiraganaWord[70] = "ぽ";

        kataganaWord[0] = "ア";
        kataganaWord[1] = "イ";
        kataganaWord[2] = "ウ";
        kataganaWord[3] = "エ";
        kataganaWord[4] = "オ";
        kataganaWord[5] = "カ";
        kataganaWord[6] = "キ";
        kataganaWord[7] = "ク";
        kataganaWord[8] = "ケ";
        kataganaWord[9] = "コ";
        kataganaWord[10] = "サ";
        kataganaWord[11] = "シ";
        kataganaWord[12] = "ス";
        kataganaWord[13] = "セ";
        kataganaWord[14] = "ソ";
        kataganaWord[15] = "タ";
        kataganaWord[16] = "チ";
        kataganaWord[17] = "ツ";
        kataganaWord[18] = "テ";
        kataganaWord[19] = "ト";
        kataganaWord[20] = "ナ";
        kataganaWord[21] = "ニ";
        kataganaWord[22] = "ヌ";
        kataganaWord[23] = "ネ";
        kataganaWord[24] = "ノ";
        kataganaWord[25] = "ハ";
        kataganaWord[26] = "ヒ";
        kataganaWord[27] = "フ";
        kataganaWord[28] = "ヘ";
        kataganaWord[29] = "ホ";
        kataganaWord[30] = "マ";
        kataganaWord[31] = "ミ";
        kataganaWord[32] = "ム";
        kataganaWord[33] = "メ";
        kataganaWord[34] = "モ";
        kataganaWord[35] = "ヤ";
        kataganaWord[36] = "ユ";
        kataganaWord[37] = "ヨ";
        kataganaWord[38] = "ラ";
        kataganaWord[39] = "リ";
        kataganaWord[40] = "ル";
        kataganaWord[41] = "レ";
        kataganaWord[42] = "ロ";
        kataganaWord[43] = "ワ";
        kataganaWord[44] = "ヲ";
        kataganaWord[45] = "ン";
        kataganaWord[46] = "ガ";
        kataganaWord[47] = "ギ";
        kataganaWord[48] = "グ";
        kataganaWord[49] = "ゲ";
        kataganaWord[50] = "ゴ";
        kataganaWord[51] = "ザ";
        kataganaWord[52] = "ジ";
        kataganaWord[53] = "ズ";
        kataganaWord[54] = "ゼ";
        kataganaWord[55] = "ゾ";
        kataganaWord[56] = "ダ";
        kataganaWord[57] = "ヂ";
        kataganaWord[58] = "ヅ";
        kataganaWord[59] = "デ";
        kataganaWord[60] = "ド";
        kataganaWord[61] = "バ";
        kataganaWord[62] = "ビ";
        kataganaWord[63] = "ブ";
        kataganaWord[64] = "ベ";
        kataganaWord[65] = "ボ";
        kataganaWord[66] = "パ";
        kataganaWord[67] = "ピ";
        kataganaWord[68] = "プ";
        kataganaWord[69] = "ペ";
        kataganaWord[70] = "ポ";

        generateText();
    }

    public void generateText(){
        if (currentQuestion<allQuestion){
            currentQuestion++;
            Log.e("Question", "Increment 1");
            txt_currentQuestion.setText(String.valueOf(currentQuestion) + "/" +String.valueOf(allQuestion));
        }
        else{
            completion();
        }
        for (int i=0;i<answers.length;i++){
            answers[i].setBackgroundColor(Color.parseColor("#252525") );
        }
        float rand = new Random().nextFloat();
        int randInt = new Random().nextInt(70);

        boolean KATA = false;
        if (rand > 0.5f){
            KATA = true;
        }
        if (KATA){
            Question.setText(kataganaWord[randInt]);
            answer = kataganaWord[randInt];
        }
        else {
            Question.setText(hiraganaWord[randInt]);
            answer = hiraganaWord[randInt];
        }

        correctAns = new Random().nextInt(4);
        Log.e(String.valueOf(correctAns),String.valueOf(correctAns));
        if (KATA){
            answers[correctAns].setText(hiraganaWord[randInt]);
        }
        else {
            answers[correctAns].setText(kataganaWord[randInt]);
        }

        for (int i=0;i < answers.length;i++){
            if (i!=correctAns){
                float rand2 = new Random().nextFloat();
                int randInt2 = new Random().nextInt(70);
                if (rand2 > 0.5){
                    answers[i].setText(kataganaWord[randInt2]);
                }
                else {
                    answers[i].setText(hiraganaWord[randInt2]);
                }
            }
        }
    }

    void completion() {
        Intent newActivity = new Intent(ConvertionActivity.this, ConversionResultActivity.class);
        newActivity.putExtra("Score",String.valueOf(score));
        startActivity(newActivity);
        //newActivity.putExtra();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.btnChoice1):
                if (correctAns == 0)
                {
                    correctAns();
                }
                else {
                    WrongAns();
                    answers[0].setBackgroundColor(Color.parseColor("#A32E02") );
                }
                break;
            case(R.id.btnChoice2):
                if (correctAns == 1)
                {
                    correctAns();
                }
                else {
                    WrongAns();
                    answers[1].setBackgroundColor(Color.parseColor("#A32E02") );
                }
                break;
            case(R.id.btnChoice3):
                if (correctAns == 2)
                {
                    correctAns();
                }
                else {
                    WrongAns();
                    answers[2].setBackgroundColor(Color.parseColor("#A32E02") );
                }
                break;
            case(R.id.btnChoice4):
                if (correctAns == 3)
                {
                    correctAns();
                }
                else {
                    WrongAns();
                    answers[3].setBackgroundColor(Color.parseColor("#A32E02") );
                }
                break;
        }
    }

    void correctAns(){
        generateText();
        combo++;
        score += (baseInterval*combo);
        Score.setText(String.valueOf(score));
    }
    void WrongAns(){
        combo = 0;
    }
}