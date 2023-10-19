package creational_Desing_pattern.Builder;

public class House {
    private String name;
    private Integer numberOfWindows;
    private String material;

    public House(){}
    public static HouseBuilder builder(){
        return new HouseBuilder();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfWindows(Integer numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public void setMaterial(String material) {
        this.material = material;
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
