package com.example.x.trading.jpa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class PhoneNumber implements Serializable {

    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private final String number;

    protected PhoneNumber(){
        this.number = null;
    }

    @JsonCreator
    public PhoneNumber(String number) {
        this.number = number;
    }

    public static PhoneNumber from(String number){
        return new PhoneNumber(number);
    }

}
