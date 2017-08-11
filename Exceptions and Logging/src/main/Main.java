package main;

/**
 * @author Alpha
 */
public class Main {
    public static void main(String[] args) {
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();

        //Exception test

        sm.addStudent(um.list,"Valentin","Cristea","1998-Jan-06",'m',"1000");
        sm.addStudent(um.list,"Ioana","Coman","1993-Sep-22",'M',"1");
        sm.addStudent(um.list,"Andras","Szathmari","1997-May-07",'n',"1004");
        sm.addStudent(um.list,"Emanuel","Pruker","1982-Jul-23",'M',"1003");
        sm.addStudent(um.list,"","Stefan","1997-Nov-28",'M',"1002");
        sm.addStudent(um.list,"Alexandru","Sebestian","1998-Jan-15",'M',"1006");
        sm.addStudent(um.list,"","","1000-Jan-25",'n',"");


        if (um.list.size()==0)
            System.out.println("In this University there isn't any main.Student");
        else
            System.out.println("University Students List: "+um.list.toString());
        System.out.println("======================================================================================");
        sm.deleteStudent(um.list,"1000");
        um.listStudentsWithAge(24);
        um.listStudentsByLastName();

    }
}
