package jp.ac.ait.k21099;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.StudentBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student extends StudentBase implements IStudent {

    public Student (String studentId, String name, List<Grade> grades){
        this.setStudentId(studentId);
        this.setName(name);
        this.setGrades(grades);
    }

    @Override
    public List<Grade> getGradesSortByRatingDsc() {

        List<Grade> li = new ArrayList<>();
        char ch = ' ';

        for (int i =0; i<6; i++){
            List<Grade> tmp = new ArrayList<>();
            switch (i) {
                case 0 -> ch = 'S';
                case 1 -> ch = 'A';
                case 2 -> ch = 'B';
                case 3 -> ch = 'C';
                case 4 -> ch = 'F';
                case 5 -> ch = 'Q';
            }

            tmp.addAll(getGradesFilterByRating(ch));
            tmp.sort(Comparator.comparing(Grade::getSubject));
            li.addAll(tmp);
        }

        return li;
    }

    @Override
    public List<Grade> getGradesFilterByRating(char rating) {
        List<Grade> li = new ArrayList<>();
        for (Grade g : getGrades()){
            if (Objects.equals(g.getMyRating(),rating)){
                li.add(g);
            }
        }
        return li;
    }

    @Override
    public List<Grade> getGradesFilterByCreditsEarned() {
        List<Grade> li = new ArrayList<>();
        for (Grade g : getGrades()){
            if (!Objects.equals(g.getMyRating(), 'F') && !Objects.equals(g.getMyRating(), 'Q')){
                li.add(g);
            }
        }
        return li;
    }

    @Override
    public int getTotalCreditsEarned() {
        int credit = 0;
        for (Grade g : getGrades()){
            if (!Objects.equals(g.getMyRating(),'F') && !Objects.equals(g.getMyRating(), 'Q')){
                credit += g.getMyCredit();
            }
        }
        return credit;
    }
}
