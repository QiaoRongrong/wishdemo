package org.qr.purejava.tij.concurrency.shareingresourses;//: concurrency/SyncObject.java
// Synchronizing on another object.

/**
 * not a good case.
 * cannot occur on java8
 */

class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();

        new Thread(() -> dualSynch.f()).start();

        dualSynch.g();
    }
}

/* Output: (Sample)
g()
f()
g()
f()
g()
f()
g()
f()
g()
f()
*///:~
