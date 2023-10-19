package creational_Desing_pattern.Builder;

public class HouseBuilder {
    private House house;
    HouseBuilder(){
        house = new House();
    }
    public HouseBuilder withName(String name){
        house.setName(name);
        return this;
    }

    public HouseBuilder withNumberOfWindows(Integer numberOfWindows){
        house.setNumberOfWindows(numberOfWindows);
        return this;
    }

    public HouseBuilder withMaterial(String material){
        house.setMaterial(material);
        return this;
    }

    public House build(){
        return house;
    }
}
