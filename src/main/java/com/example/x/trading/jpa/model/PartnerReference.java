package com.example.x.trading.jpa.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;

@Value
@Embeddable
@EqualsAndHashCode(of = {"reference"})
public class PartnerReference implements Serializable {

    private final String reference;

    private final Type type;

    protected PartnerReference(){
        this.type = null;
        this.reference = null;
    }

    public PartnerReference(String id, String type) {
        this.type = Type.valueOf(type);
        StringBuilder builder = new StringBuilder();
        builder.append(type);
        builder.append("://");
        builder.append(id);

        this.reference = builder.toString();
    }

    public PartnerReference(String id, Type type) {
        this.type = type;
        StringBuilder builder = new StringBuilder();
        builder.append(type.name());
        builder.append("://");
        builder.append(id);

        this.reference = builder.toString();
    }

    public enum Type {
        MARKETER, INFLUENCER, EMPLOYEE
    }

}
