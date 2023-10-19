package creational_Desing_pattern.Singleton;

public class DBConnectionWithMultiThreading {
    private Integer port = 3456;
    private String host = "random";

    private static DBConnectionWithMultiThreading dbConnectionWithoutMultiThreading;
    // step 1
    private DBConnectionWithMultiThreading(){}

    // step 2
    public static DBConnectionWithMultiThreading getInstance(){
        if(dbConnectionWithoutMultiThreading == null){
            synchronized (DBConnectionWithoutMultiThreading.class){
                if(dbConnectionWithoutMultiThreading == null){
                    dbConnectionWithoutMultiThreading = new DBConnectionWithMultiThreading();
                }
            }
        }
        return dbConnectionWithoutMultiThreading;
    }
}
