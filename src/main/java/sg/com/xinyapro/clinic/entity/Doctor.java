package sg.com.xinyapro.clinic.entity;

public class Doctor {

    private String name;

    private String dep;

    public Doctor() {
    }

    public Doctor(String name, String department) {
        this.name = name;
        this.dep = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dep;
    }

    public void setDepartment(String department) {
        this.dep = department;
    }
}
