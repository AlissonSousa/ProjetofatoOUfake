package com.sld.projetofatooufake;

public class QuestionLibrary {

    private String mQuestions [] = {
            "Tudo bem compartilhar objetos, tipo o celular, pois o novo coronavírus não se transmite dessa forma.",
            "Não preciso me preocupar em higienizar as compras do mercado, afinal, eu mesmo peguei da prateleira com as mãos limpas.",
            "Em caso de sintomas gripais e estando em locais públicos, o mais indicado a se fazer é cobrir a boca com o antebraço ou o cotovelo ao espirrar e/ou tossir.",
            "Se me sinto bem e tomo todos os cuidados, tudo bem abraçar e beijar as pessoas com quem moro.",
            "Os sintomas mais comuns da COVID-19 são: febre, tosse, cansaço, dor de cabeça e alteração do olfato.",
            "Mesmo uma pessoa sem sintomas da COVID-19 pode contaminar outras.",
            "Usando máscara não é possível ser infectado.",
            "A vacina da gripe não protege contra a COVID-19.",
            "A COVID-19 não deixa sequelas.",
            "O vírus pode ficar ativo em objetivos e superficies."
    };


    private String mChoices [][] = {
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"},
            {"Fato", "Fake"}
    };

    private String mCorrectAnswers[] = {"Fake", "Fake", "Fake", "Fato", "Fato", "Fato", "Fake", "Fato", "Fake", "Fato"};

    int flag=0;





    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public int getLength(){
        return mQuestions.length;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}
