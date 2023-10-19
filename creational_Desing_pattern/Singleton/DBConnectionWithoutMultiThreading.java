package creational_Desing_pattern.Singleton;

public class DBConnectionWithoutMultiThreading {
    private Integer port = 3456;
    private String host = "random";

    private static DBConnectionWithoutMultiThreading dbConnectionWithoutMultiThreading;
    // step 1
    private DBConnectionWithoutMultiThreading(){}

    // step 2
    public static DBConnectionWithoutMultiThreading getInstance(){
        if(dbConnectionWithoutMultiThreading == null){
            dbConnectionWithoutMultiThreading = new DBConnectionWithoutMultiThreading();
        }
        return dbConnectionWithoutMultiThreading;
    }
}
