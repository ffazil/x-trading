package com.example.x.trading.jpa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Embeddable
public class PersonName implements Serializable {

    private final String name;

    protected PersonName() {
        this.name = null;
    }

    @JsonCreator
    public PersonName(String name) {
        this.name = name;
    }

    public static PersonName of(String name){
        return new PersonName(name);
    }

}
