package com.example.quizapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView tv_score,tv_question;
    RadioGroup radioGroup;
    RadioButton option01,option02,option03,option04;
    AppCompatButton btn_check;

    // Create Quis list for question and answer.
    List <quis> quizList;
    int index=0;
    String giverAnswer;

    int radioId=0, score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_score=findViewById(R.id.tv_score);
        tv_question=findViewById(R.id.tv_question);
        radioGroup=findViewById(R.id.radioGroup);
        option01=findViewById(R.id.option01);
        option02=findViewById(R.id.option02);
        option03=findViewById(R.id.option03);
        option04=findViewById(R.id.option04);
        btn_check=findViewById(R.id.btn_check);





        quizList = new ArrayList<>();

        quizList.add(new quis(
                "what is your name",
                "abul",
                "haza",
                "gaza",
                "hok maula",
                "haza"
        ));
        quizList.add(new quis(
                "what is your favourite ",
                "abul",
                "haza",
                "gaza",
                "hok maula",
                "gaza"
        )  );
        quizList.add(new quis(
                "what is your abul",
                "abul",
                "haza",
                "gaza",
                "hok maula",
                "haza"
        ) );

        quizList.add(new quis(
                "what is your car",
                "audi",
                "bmw",
                "ford",
                "maula",
                "audi"
        )  );


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int radioBtnId) {

                radioId=radioBtnId;

                RadioButton checkButtoon =findViewById(radioBtnId);

                giverAnswer=checkButtoon.getText().toString().trim();

            }
        });


        setupQuizTOView(index);

        btn_check.setOnClickListener(v -> {

            if (radioId ==0){

                Toast.makeText(this, "select a option", Toast.LENGTH_SHORT).show();
            }else {

                checkRightAnswer();
            }



        });


    }

    private void checkRightAnswer() {

        if (quizList.get(index).getRightAnswer().equals(giverAnswer)){


            Toast.makeText(this, "Right answer", Toast.LENGTH_SHORT).show();

            index++;
            score++;
            tv_score.setText("Score: "+score);


            if(quizList.size()-1 >index){
                setupQuizTOView(index);

            }


            }else {

            Toast.makeText(this, "wrong answer", Toast.LENGTH_SHORT).show();

            index++;
            score--;
            tv_score.setText("Score: "+score);
            setupQuizTOView(index);
        }
    }

    private void setupQuizTOView(int index) {

        tv_question.setText(quizList.get(index).getQuestion());
        option01.setText(quizList.get(index).getAnswer01());
        option02.setText(quizList.get(index).getAnswer02());
        option03.setText(quizList.get(index).getAnswer03());
        option04.setText(quizList.get(index).getAnswer04());

        option01.setChecked(false);
        option02.setChecked(false);
        option03.setChecked(false);
        option04.setChecked(false);





    }
}