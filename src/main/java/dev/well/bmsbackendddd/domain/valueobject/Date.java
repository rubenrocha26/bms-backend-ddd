package dev.well.bmsbackendddd.domain.valueobject;

import dev.well.bmsbackendddd.ddd.ValueObject;

import java.time.LocalDate;

public class Date implements ValueObject {
    private final LocalDate _date;

    public Date (LocalDate _date) {
        this._date = _date;
    }

    @Override
    public String toString () {return this._date.toString();}
}
