package creational_Desing_pattern.Prototype;

public class Client {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId("1");
        employee1.setName("abc");
        employee1.setRollNo("123");
        System.out.println("employee1 hashcode: " + employee1.hashCode());
        Employee copyEmployee = employee1.clone();
        System.out.println("copy employee hashcode: " + copyEmployee.hashCode());
    }
}
