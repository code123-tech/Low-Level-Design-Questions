package creational_Desing_pattern.factory;

public class FactoryDesingPattern {
    public static void main(String[] args) {
        OS object = new Android();
        object.spec();

        /**
         * In the above code, creation of object of Android class.
         * we are exposing the client that with which classes we are working.
         * So, to avoid that, creating an another class OSFactory which will return object of any class as per provided input by user.
         */
        OSFactory osFactory = new OSFactory();
        OS androidObject = osFactory.getInstance("windows");
        androidObject.spec();
    }
}
