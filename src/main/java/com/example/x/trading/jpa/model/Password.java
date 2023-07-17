package com.example.x.trading.jpa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

@Value
@Embeddable
@EqualsAndHashCode(of = {"password"})
public class Password implements Serializable {

    private final String password;

    protected Password(){
        this.password = null;
    }

    @JsonCreator
    public Password(String password){
        if(!isValid(password)){
            throw new IllegalArgumentException("Password should be minimum 8 characters");
        }

        this.password = password;
    }

    public static Password from(String password){
        return new Password(password);
    }

    private static boolean isValid(String password) {
        return password.length()>7;
    }

}

