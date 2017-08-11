package main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Alpha
 * Class - Students Management, manages all students, adds or deletes them by ID
 */
public class StudentsManagement {
    private static final Logger LOGGER=Logger.getLogger("studentsManagementLogger");

    /**
     * Method adds students in repository if values are valid, else catch expression and print last line
     */
    public void addStudent(List<Student> list,String firstName, String lastName, String dateOfBirth, char gender, String id){
       try {
           if (nameValidation(firstName) && nameValidation(lastName) && ageValidation(dateOfBirth) && genderValidation(gender)&&idValidation(id))
               list.add(new Student(firstName, lastName, dateOfBirth, gender, id));
       }catch (IllegalArgumentException e){
           StackTraceElement[] elements = e.getStackTrace();
           System.err.println(elements[elements.length-1]);
       }
    }

    /**
     * Method deletes student by ID and prints list with remaining students
     */
    public void deleteStudent(List<Student> list,String id){
        Object o = new Object();

        for(Student student : list){
            if(student.getId().equals(id))
                o=student;
        }
        if (list.remove(o)){
            list.remove(o);
            System.out.println("University Students List after deleting main.Student with ID: "+id+" "+
                    list.toString());
        }
        else
            System.out.println("In this University there isn't any Student main.Student with ID: "+id);
        System.out.println("======================================================================================");

    }

    /**
     * Method verifies the name
     * @param name : Students' name
     * @return true if name is not empty
     */
    public boolean nameValidation(String name){
        if (name.equals("")) {
            LOGGER.info("empty name ");
            throw new IllegalArgumentException("empty name");
        }else
        return true;
    }

    /**
     * Method verifies age
     * @param dateOfBirth : birthdate of a student
     * @return true if birthdate is between 1900 and current year -18
     */
    public boolean ageValidation(String dateOfBirth){
        if (dateOfBirth.equals("")){
            LOGGER.info("invalid age ");
            throw new IllegalArgumentException("invalid age");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");//convert string to Local Date
        LocalDate birthDay = LocalDate.parse(dateOfBirth, formatter);
        Period period = Period.between(birthDay, LocalDate.now());
        if(birthDay.getYear()<1990||period.getYears()<=18){
            LOGGER.info("invalid age ");
            throw new IllegalArgumentException("invalid age");
        }
        return true;
    }

    /**
     * Method verifies gender
     * @param gender : student gender
     * @return true if gender is M or F
     */
    public boolean genderValidation(char gender){
        if (gender!='m'&&gender!='M'&&gender!='f'&&gender!='F') {
            LOGGER.info("invalid gender ");
            throw new IllegalArgumentException("invalid gender");
        }
            return true;
    }

    /**
     * Method verifies ID
     * @param id : Student ID
     * @return true if the id is not empty
     */
    public boolean idValidation(String id){
        if (id.equals("")){
            LOGGER.info("empty id ");
            throw new IllegalArgumentException("empty id");
        }
        return true;
    }

}
