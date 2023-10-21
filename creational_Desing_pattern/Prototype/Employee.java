package creational_Desing_pattern.Prototype;

public class Employee implements IPrototype {
    private String id;
    private String name;
    private String rollNo;
    public Employee(){

    }
    public Employee(Employee target){
        if(target != null){
            this.setId(target.getId());
            this.setName(target.getName());
            this.setRollNo(target.getRollNo());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public Employee clone() {
        return new Employee(this);
    }
}
