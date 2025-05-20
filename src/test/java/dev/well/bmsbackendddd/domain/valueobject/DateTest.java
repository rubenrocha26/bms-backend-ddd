package dev.well.bmsbackendddd.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void shouldCreateDate(){
        //arrange
        LocalDate localDate = LocalDate.now();
        //act
        Date date = new Date(localDate);
        //assert
        assertNotNull(date);
    }

    @Test
    void nullDateThrowsException(){
        //arrange
        //act + assert
        assertThrows(IllegalArgumentException.class,() -> new Date(null));
    }

    @Test
    void shouldReturnDateToString(){
        //arrange
        LocalDate localDate = LocalDate.now();
        Date date = new Date(localDate);
        //act
        String dateToString = date.toString();
        //assert
        assertNotNull(dateToString);
        assertEquals("2025-05-20", dateToString);
        System.out.println(dateToString);
    }

}