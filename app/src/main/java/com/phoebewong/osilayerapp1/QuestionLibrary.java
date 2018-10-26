package com.phoebewong.osilayerapp1;

public class QuestionLibrary {

    //this is the library that holds all the questions and answers
    //this is read by the Quiz class to decide which answers are right and wrong

    private String mQuestions[] = {
            "Parameter that is normally achieved through a trailer added to end of frame is __________" ,
            "Application layer provides basis for __________",
            "Segmentation and reassembly is responsibility of __________",
            "Layer that are used to deal with mechanical and electrical specifications are __________ ",
            "Network layer is responsible for the __________ " ,
            "Routers operate at which layer of the OSI model? __________",
            "Bits are packaged into frames at which layer of the OSI model?",
            "The layers of the OSI model, from the top down, are:  __________",
            "Which of the following are transport layer protocols?",

    };

    private String mChoices [][] = {
            {"Access Control", "Flow Control","Error Control","Physical Addressing"},
            {"Email Services", "Frame Division", "File Making", "None of the Above"},
            {"7th Layer", "6th Layer", "5th Layer", "4th Layer"},
            {"Physical Layer", "Data Link Layer", "Network Layer", "Transport Layer"},
            {"Node to node communication", "Source to destination", "Hop to hop communication", "Both b and C"},
            {"Physical", "Transport", "Network", "Session"},
            {"Data Link", "Transport", "Physical", "Presentation"},
            {"Application, Presentation, Session, Transport, Network, Data Link, Physical", "Session, Presentation, Data Transport, MAC, Network, Physical","Physical, Data Link, Network, Transport, Session, Presentation, Application","Presentation, Application, Session, Network, Transport, Data Link, Physical"},
            {"IP", "FTAM","TCP AND UDP", "TFTP"}
    };

    private String mCorrectAnswers[] = {
            "Error Control",
            "Email Services",
            "4th Layer",
            "Physical Layer",
            "Source to destination",
            "Network",
            "Data Link",
            "Application, Presentation, Session, Transport, Network, Data Link, Physical",
            "TCP AND UDP"

    };

    //this is also where the Quiz class will get the question and choices from

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public void setmQuestions(String[] mQuestions) {
        this.mQuestions = mQuestions;
    }

    public void setmChoices(String[][] mChoices) {
        this.mChoices = mChoices;
    }

    public void setmCorrectAnswers(String[] mCorrectAnswers) {
        this.mCorrectAnswers = mCorrectAnswers;
    }

    public String[] getmQuestions(){
        return  mQuestions;
    }
    public String[][] getmChoices() {
        return mChoices;
    }

    public String[] getmCorrectAnswers(){
        return mCorrectAnswers;
    }

}

