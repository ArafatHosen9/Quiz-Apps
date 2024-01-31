package com.example.quizapps;

public class quis {

    private  String question, answer01, answer02, answer03,answer04,rightAnswer;


    public quis(String question, String answer01, String answer02, String answer03, String answer04, String rightAnswer) {
        this.question = question;
        this.answer01 = answer01;
        this.answer02 = answer02;
        this.answer03 = answer03;
        this.answer04 = answer04;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer01() {
        return answer01;
    }

    public String getAnswer02() {
        return answer02;
    }

    public String getAnswer03() {
        return answer03;
    }

    public String getAnswer04() {
        return answer04;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
