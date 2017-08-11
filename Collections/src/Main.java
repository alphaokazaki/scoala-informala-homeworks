/**
 * @author Alpha
 */
public class Main {
    public static void main(String[] args){
        //Creating a new company
        Company company = new Company();
        //Creating a new CompanyManager
        CompanyManager companyManager = new CompanyManager();

        //Adding Employees
        companyManager.addEmployee("Valentin Cristea",0,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andras Szathmari",2,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andrei Lazurca",5,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Ioana Coman",1,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("William Oanta",6,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Emanuel Pruker",3,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andrei Hegedus",8,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Turian Ovidiu",7,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Sebastian Presecan",15,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);

        System.out.println('\n'+"Company Employees List"+'\n'+company.employees);
        companyManager.sortAListBySeniority(company.employees);
        System.out.println('\n'+"Company Employees List Sorted By Seniority"+'\n'+company.employees);
        System.out.println('\n'+"Company Employees Without Parking Space List"+'\n'+company.withoutParkingSpace);
        System.out.println('\n'+"Company Employees Juniors List"+'\n'+company.juniors);
        System.out.println('\n'+"Company Employees Managers List"+'\n'+company.managers);
    }
}
