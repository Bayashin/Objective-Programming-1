package jp.ac.ait.k21099;

import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.IStudentsSorter;

import java.util.*;

public class StudentsSorter implements IStudentsSorter {

    List<IStudent> student ;

    @Override
    public List<IStudent> getStudents() {
        return student;
    }

    @Override
    public void setStudents(List<IStudent> students) {
        this.student = students;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedAsc() {
        List<IStudent> li = new ArrayList<>(student);
        li.sort(Comparator.comparingInt(IStudent::getTotalCreditsEarned));
        return li;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedDsc() {
        List<IStudent> li = new ArrayList<>(student);
        li.sort((IStudent num1, IStudent num2) -> num2.getTotalCreditsEarned() - num1.getTotalCreditsEarned());
        return li;
    }
}
