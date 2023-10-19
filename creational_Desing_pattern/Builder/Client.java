package creational_Desing_pattern.Builder;

public class Client {
    public static void main(String[] args) {
        House sharmaJiKaHouse = House.builder()
                                .withName("Sharma Niwas")
                                .withNumberOfWindows(2)
                                .withMaterial("JK Cement")
                                .build();

        House vermaJiKaHouse = House.builder()
                                .withName("Verma Niwas")
                                .withNumberOfWindows(5)
                                .withMaterial("Ambuja Cement")
                                .build();
        System.out.println(sharmaJiKaHouse);
        System.out.println(vermaJiKaHouse);
    }
}
