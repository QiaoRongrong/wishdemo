package org.qr.purejava.base;

import lombok.Data;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * https://stackoverflow.com/questions/910374/why-does-java-have-transient-fields
 * The transient keyword in Java is used to indicate
 * that a field should not be part of the serialization (which means saved, like to a file) process.
 */
public class TransientTry {

    public static void main(String args[]) throws Exception {
        NameStore nameStore = new NameStore("Steve", "Middle","Jobs");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("nameStore"));
        // writing to object
        outputStream.writeObject(nameStore);
        outputStream.close();

        // reading from object
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("nameStore"));
        NameStore nameStore1 = (NameStore)inputStream.readObject();
        System.out.println(nameStore1);

        System.out.println("Origin name store object is: " + nameStore);
    }
}


class NameStore implements Serializable{
    private String firstName;
    private transient String middleName;
    private String lastName;

    public NameStore (String fName, String mName, String lName){
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer(40);
        sb.append("First Name : ");
        sb.append(this.firstName);
        sb.append(" Middle Name : ");
        sb.append(this.middleName);
        sb.append(" Last Name : ");
        sb.append(this.lastName);
        return sb.toString();
    }
}


