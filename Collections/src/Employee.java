/**
 * @author Alpha
 * Defines employees
 */
public class Employee {

    private String name,role;
    private boolean seniority,parkingSpace;
    private int yearsInCompany;

    public Employee(String name, int yearsInCompany, String role) {
        setName(name);
        setYearsInCompany(yearsInCompany);
        setRole(role);
    }

    /**
     * Method that helps in getting info from Employees
     * @return
     */
    @Override
    public String toString() {
        return '\n'+"Employee{" +
                "name='" + name + '\'' +
                ", yearsInCompany='" + yearsInCompany + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    public void setYearsInCompany(int yearsInCompany) {
        this.yearsInCompany = yearsInCompany;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(boolean parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public boolean isSeniority() {
        return seniority;
    }

    public void setSeniority(boolean seniority) {
        this.seniority = seniority;
    }


}
