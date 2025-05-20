package dev.well.bmsbackendddd.domain.valueobject;

import dev.well.bmsbackendddd.ddd.ValueObject;

import java.time.LocalDate;

public class Date implements ValueObject {
    private final LocalDate _date;

    public Date (LocalDate date) {
        if (date == null) {throw new IllegalArgumentException("Date cannot be null");}
        this._date = date;
    }

    @Override
    public String toString () {return this._date.toString();}
}
