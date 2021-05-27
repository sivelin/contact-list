package com.fhnw.swa.contact;


import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest{

    @Test
    public void testSerialization() {
        Contact vet = new Contact((long) 1,
                "Hans","Muster","Hansli",
                "Musterstrasse","+41795328453",
                "mail@mail.ch","Musterstadt",1234);

        Contact other = (Contact) SerializationUtils.deserialize(SerializationUtils.serialize(vet));
        assertEquals(other.getFirstname(),vet.getFirstname());
        assertEquals(other.getLastname(),vet.getLastname());
        assertEquals(other.getNickname(),vet.getNickname());
        assertEquals(other.getStreet(),vet.getStreet());
        assertEquals(other.getNumber(),vet.getNumber());
        assertEquals(other.getEmail(),vet.getEmail());
        assertEquals(other.getTown(),vet.getTown());
        assertEquals(other.getId(),vet.getId());
    }

    @Test
    public void whenDerivedExceptionThrown_thenAssertionSucceds() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Contact vet = new Contact(null,
                    "Hans","Muster","Hansli",
                    "Musterstrasse","+41795328453",
                    "mail@mail.ch","Musterstadt",1234);
        });

        String expectedMessage = "id is marked non-null but is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}