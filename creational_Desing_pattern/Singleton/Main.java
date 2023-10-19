package creational_Desing_pattern.Singleton;

import creational_Desing_pattern.Singleton.MultiThreadingEnvironment.ThreadClass1;
import creational_Desing_pattern.Singleton.MultiThreadingEnvironment.ThreadClass2;
import creational_Desing_pattern.Singleton.MultiThreadingEnvironment.ThreadClass3;
import creational_Desing_pattern.Singleton.MultiThreadingEnvironment.ThreadClass4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. In below case, it will always create one instance of the class.
         *   Comment it, and execute the second case.
         */
        /*
        DBConnectionWithoutMultiThreading dbConnectionWithoutMultiThreading = DBConnectionWithoutMultiThreading.getInstance();
        System.out.println(dbConnectionWithoutMultiThreading.hashCode());
        System.out.println(dbConnectionWithoutMultiThreading.hashCode());
        */

        /**
         * 2. When two threads are trying to access at same time, you will once get two object hashCode different
         * which indicates that Singleton pattern is breaking.
         */
        System.out.println("---- Singleton with no multi threading safety ------");
        ThreadClass1 threadClass1 = new ThreadClass1();
        ThreadClass2 threadClass2 = new ThreadClass2();
        threadClass1.start();
        threadClass2.start();

        Thread.sleep(2000);
        System.out.println("---- Singleton with multi threading safety ------");
        /**
         * Here we have used synchronized keyword in DBConnectionWithMultiThreading method.
         * which ensures that even more than 2 threads execute the code at same time, at a time only one will be allowed
         * to enter into synchronized block.
         */

        ThreadClass3 threadClass3 = new ThreadClass3();
        ThreadClass4 threadClass4 = new ThreadClass4();
        threadClass3.start();
        threadClass4.start();
    }
}
