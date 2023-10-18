package creational_Desing_pattern.Builder;

public class House {
    private String name;
    private Integer numberOfWindows;
    private String material;

    private House(){}

    public static class HouseBuilder{
        private House house;
        HouseBuilder(){
            house = new House();
        }

        public HouseBuilder withName(String name){
            house.name = name;
            return this;
        }

        public HouseBuilder withNumberOfWindows(Integer numberOfWindows){
            house.numberOfWindows = numberOfWindows;
            return this;
        }
        public HouseBuilder withMaterial(String material){
            house.material = material;
            return this;
        }

        public House build(){
            return house;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfWindows() {
        return numberOfWindows;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", numberOfWindows=" + numberOfWindows +
                ", material='" + material + '\'' +
                '}';
    }
}
