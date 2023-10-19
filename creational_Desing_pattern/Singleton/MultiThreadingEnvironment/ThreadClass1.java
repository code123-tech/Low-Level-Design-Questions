package creational_Desing_pattern.Singleton.MultiThreadingEnvironment;

import creational_Desing_pattern.Singleton.DBConnectionWithoutMultiThreading;

public class ThreadClass1 extends Thread{
    public DBConnectionWithoutMultiThreading dbConnectionWithoutMultiThreading;

    public void run(){
        dbConnectionWithoutMultiThreading = DBConnectionWithoutMultiThreading.getInstance();
        System.out.println("First object: " + dbConnectionWithoutMultiThreading.hashCode());
    }
}
