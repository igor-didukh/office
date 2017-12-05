package com.company.office.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ActType implements EnumClass<String> {

    sendFile("file"),
    sendMessage("message");

    private String id;

    ActType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ActType fromId(String id) {
        for (ActType at : ActType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}