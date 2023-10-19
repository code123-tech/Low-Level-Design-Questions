package creational_Desing_pattern.Singleton.MultiThreadingEnvironment;

import creational_Desing_pattern.Singleton.DBConnectionWithoutMultiThreading;

public class ThreadClass2 extends Thread{
    public DBConnectionWithoutMultiThreading dbConnectionWithoutMultiThreading;

    public void run(){
        dbConnectionWithoutMultiThreading = DBConnectionWithoutMultiThreading.getInstance();
        System.out.println("Second object: " + dbConnectionWithoutMultiThreading.hashCode());
    }

}
