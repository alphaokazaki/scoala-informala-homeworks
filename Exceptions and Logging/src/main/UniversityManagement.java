package main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alpha
 */
public class UniversityManagement {
    public List<Student> list = new ArrayList<Student>();//student repository

    /**
     * Method lists all students withing a range of ages, calculate the age of students using Local Date , Data Time Formatter and Period, then print.
     */
    public void listStudentsWithAge(int age){
        boolean ok=false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");// convert String to Local Date
        LocalDate today = LocalDate.now();
        for(Student student : list){
            LocalDate birthDay=LocalDate.parse(student.getDateOfBirth(), formatter);
            Period period = Period.between(birthDay, today);
            if (period.getYears()==age&&!ok){
                System.out.println("University Students List of students aged: "+age);
                ok=true;
            }
            if (period.getYears()==age){
                System.out.println(student.toString());}
        }
        if (!ok)
            System.out.println("In this University there is no main.Student aged: "+age);

        System.out.println("======================================================================================");

    }

    /**
     * Name comparator, sort lists by name
     */
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }

    /**
     * Method sorts and lists by last name, using the Name comparator above.
     */
    public void listStudentsByLastName(){
        if (list.size()==0)
            System.out.println("In this University there is no main.Student");
        else {
            System.out.print("University Students List sorted by Last Name: ");
            Collections.sort(list, new NameComparator());
            System.out.println(list.toString());
        }
        System.out.println("======================================================================================");

    }
}
