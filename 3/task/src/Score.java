public class Score {

    public static final int  Number_of_subjects = 5;

    int id;//出席番号
    String name;//氏名
    int[] subjects = {0,0,0,0,0};//点数([0]:国語,[1]:数学,[2]:理科,[3]:社会,[4]:英語)

    int getId(){return id;}//idを返します
    void setId(int value){id = value;}//idに引数のvalueを代入します
    String getName(){return name;}//nameを返します
    void setName(String value){name = value;}//nameに引数のvalueを代入します

    int getJapanese(){
        return subjects[0];
    }//subjects[0]を返します
    int getMethmatics(){
        return subjects[1];
    }//subjects[1]を返します
    int getScience(){
        return subjects[2];
    }//subjects[2]を返します
    int getSocialStudies(){
        return subjects[3];
    }//subjects[3]を返します
    int getEnglish(){
        return subjects[4];
    }//subjects[4]を返します

    void setJapanese(int value){
        subjects[0] = value;
    }//subjects[0]に引数のvalueを代入します
    void setMathmatics(int value){
        subjects[1] = value;
    }//subjects[1]に引数のvalueを代入します
    void setScience(int value){
        subjects[2] = value;
    }//subjects[2]に引数のvalueを代入します
    void setSocialStudies(int value){
        subjects[3] = value;
    }//subjects[3]に引数のvalueを代入します
    void setEnglish(int value){
        subjects[4] = value;
    }//subjects[4]に引数のvalueを代入します

    int getTotal(){
        int total=0;
        for (int i=0; i<Number_of_subjects; i++){
            total += subjects[i];
        }
        return total;
    }//subjects[0]〜subjects[4]の合計を算出して返します

    double getAverage(){
        double average=0;
        int i=0;
        for (; i<Number_of_subjects; i++){
            average += subjects[i];
        }
        average /= 1.0*i;
        return average;
    }//合計 / 教科数を算出して返します

    int getHighScore(){
        int highscore=0;
        for (int i=0; i<5; i++) {
            if (highscore < subjects[i]){
                highscore = subjects[i];
            }
        }
        return highscore;
    }//5教科のうち最高得点を返します。

    String getHighScoreSubject(){
        String highscoresubject = null;
        int highscore = getHighScore();
        for (int i=0; i<5; i++) {
           if (highscore == subjects[i]){
               if (highscoresubject == null) {
                   switch (i) {
                       case 0:
                           highscoresubject = "国語";
                           break;
                       case 1:
                           highscoresubject = "数学";
                           break;
                       case 2:
                           highscoresubject = "理科";
                           break;
                       case 3:
                           highscoresubject = "社会";
                           break;
                       case 4:
                           highscoresubject = "英語";
                           break;
                   }
               } else {
                   switch (i) {
                       case 0:
                           break;
                       case 1:
                           highscoresubject += ",数学";
                           break;
                       case 2:
                           highscoresubject += ",理科";
                           break;
                       case 3:
                           highscoresubject += ",社会";
                           break;
                       case 4:
                           highscoresubject += ",英語";
                           break;
                   }
               }
           }
        }
        return highscoresubject;
    }//5教科のうち最高得点だった科目名を返します。

    int getLowScore(){
        int lowscore=100;
        for (int i=0; i<5; i++) {
            if (lowscore > subjects[i]){
                lowscore = subjects[i];
            }
        }
        return lowscore;
    }//5教科のうち最低得点を返します。

    String getLowScoreSubject() {
        String lowscoresubject = null;
        int lowscore = getLowScore();
        for (int i = 0; i < 5; i++) {
            if (lowscore == subjects[i]) {
                if (lowscoresubject == null) {
                    switch (i) {
                        case 0:
                            lowscoresubject = "国語";
                            break;
                        case 1:
                            lowscoresubject = "数学";
                            break;
                        case 2:
                            lowscoresubject = "理科";
                            break;
                        case 3:
                            lowscoresubject = "社会";
                            break;
                        case 4:
                            lowscoresubject = "英語";
                            break;
                    }
                } else {
                    switch (i) {
                        case 0:
                            break;
                        case 1:
                            lowscoresubject += ",数学";
                            break;
                        case 2:
                            lowscoresubject += ",理科";
                            break;
                        case 3:
                            lowscoresubject += ",社会";
                            break;
                        case 4:
                            lowscoresubject += ",英語";
                            break;
                    }
                }
            }
        }
        return lowscoresubject;
    }//5教科のうち最低得点だった科目名を返します。

        void printInfo () {

            System.out.println(getId()+" "+getName()+" 国語" + getJapanese() + "点、数学" + getMethmatics() + "点、理科" + getScience() + "点、社会" + getSocialStudies() + "点、英語" + getEnglish() + "点　合計" + getTotal() + "点　平均" + getAverage() + "点　得意科目 " + getHighScoreSubject() + ":" + getHighScore() + "点　苦手科目 " + getLowScoreSubject() + ":" + getLowScore() + "点");
        }//標準出力に情報出力してください。


    }