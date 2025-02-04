package creational_Desing_pattern.AbstractFactory.OSTypeFactory;

public class Linux implements OS{
    @Override
    public void spec() {
        System.out.println("Linux Specifications....");
    }
}
