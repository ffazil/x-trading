package com.example.x.trading.jpa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.Serializable;

@Value
@Embeddable
@EqualsAndHashCode(of = {"address"})
public class Email implements Serializable {

    private final String address;

    private Email() {
        this.address = null;
    }

    @JsonCreator
    public Email(String address) {
        if (!isValid(address)) throw new IllegalArgumentException(String.format("Invalid email address: %s", address));

        this.address = address;
    }

    private static boolean isValid(String address) {
        return EmailValidator.getInstance().isValid(address);
    }

    public static Email from(String address) {
        return new Email(address);
    }
}
