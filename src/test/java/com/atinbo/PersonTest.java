package com.atinbo;

import com.atinbo.model.PersonProtos;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;


public class PersonTest {

    @Test
    public void testNew() throws InvalidProtocolBufferException {
        PersonProtos.Person.Builder personBdr = PersonProtos.Person.newBuilder();

        personBdr.setName("breggor");
        personBdr.setEmail("breggor@atinbo.com");
        personBdr.setAge(30);

        PersonProtos.Person person = personBdr.build();
        System.out.println("before: \n" + person);

        System.out.println("===Person Byte:");
        for (byte b : person.toByteArray()) {
            System.out.print(b);
        }
        System.out.println("\n================");

        byte[] byteArray = person.toByteArray();
        PersonProtos.Person parse = PersonProtos.Person.parseFrom(byteArray);
        System.out.println("after id:" + parse.getId());
        System.out.println("after name:" + parse.getName());
        System.out.println("after email:" + parse.getEmail());
        System.out.println("after age:" + parse.getAge());

    }
}