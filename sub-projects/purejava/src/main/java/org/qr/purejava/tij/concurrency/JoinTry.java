package org.qr.purejava.tij.concurrency;

public class JoinTry {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.start();
    }
}



class Parent extends Thread {

    public void run() {
        Child child = new Child();
        child.start();

        doSomething();  // ===============

        try {
            child.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void doSomething() {
        System.out.println(getName() +" Parent running 5s ...");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() +" Parent running 5s ...END ");
    }
}

class Child extends Thread {

    public void run() {
        doSome();
    }

    public void doSome() {
        System.out.println(getName() + " Child running 7s ...");
        try {
            sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " Child running 7s ...END");
    }
}
