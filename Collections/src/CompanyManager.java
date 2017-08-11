import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alpha
 * Class -  Company Manager, helps with managing the company
 */
public class CompanyManager {
    /**
     * Method adds Employees to the company
     * @param name : name of the employee
     * @param yearsInCompany : years worked for the company
     * @param role : employee's role
     * @param employees : list containing employees
     * @param withoutParkingSpace : list containing employees without parking space
     * @param managers : list containing managers
     * @param juniors : list containing juniors
     */
    public void addEmployee(String name, int yearsInCompany, String role, List employees, List withoutParkingSpace, List managers, List juniors) {
        Employee employee= new Employee(name,yearsInCompany,role);
        employees.add(employee);

        //Seniority true, gets parking space, if employee worked > 2 years in the company
        if (employee.getYearsInCompany() > 2) {
            employee.setSeniority(true);
            employee.setParkingSpace(true);
        }

        //employees without parking space go into their category
        if(employee.isParkingSpace()==false) {
            withoutParkingSpace.add(employee);
        }
        //employees with the manager role added to managers list
        if(employee.getRole().equals("manager"))
            managers.add(employee);
        //employees with the junior role added to juniors list
        if(employee.getRole().equals("junior"))
            juniors.add(employee);

    }

    /**
     * Method sorts by seniority
     * @param list : sorted by seniority
     */
    public void sortAListBySeniority (List list){
        Collections.sort(list,new SeniorityComparator());
    }

    /**
     * Comparator that sorts by seniority
     */
    static class SeniorityComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1,Employee o2) {
            if(o1.getYearsInCompany()==o2.getYearsInCompany())
                return 0;
            if(o1.getYearsInCompany()<o2.getYearsInCompany())
                return 1;
            return -1;
        }
    }
}
