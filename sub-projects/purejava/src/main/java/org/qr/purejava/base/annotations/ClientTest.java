package org.qr.purejava.base.annotations;


/**
 * Caller
 * https://www.baeldung.com/java-custom-annotation
 */
public class ClientTest {

    public static void main(String[] args) {
        Person personOne = new Person();
        personOne.setFirstName("Jory");
        personOne.setLastName("Qiao");
        personOne.setAddress("Pudong direction, Jinxiu Road");
        personOne.setAge("37");


        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String toJson = converter.convertToJson(personOne);

        System.out.println(toJson);


    }
}
