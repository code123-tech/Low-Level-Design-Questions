package creational_Desing_pattern.Singleton.MultiThreadingEnvironment;

import creational_Desing_pattern.Singleton.DBConnectionWithMultiThreading;
import creational_Desing_pattern.Singleton.DBConnectionWithoutMultiThreading;

public class ThreadClass4 extends Thread{
    public DBConnectionWithMultiThreading dbConnectionWithMultiThreading;

    public void run(){
        dbConnectionWithMultiThreading = DBConnectionWithMultiThreading.getInstance();
        System.out.println("First object: " + dbConnectionWithMultiThreading.hashCode());
    }
}
