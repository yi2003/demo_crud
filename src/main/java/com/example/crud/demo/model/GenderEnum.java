package com.example.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum GenderEnum {

    Man(0,"男"),
    Woman(1,"女");

    private int code;
    private String message;


    GenderEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Map<Integer, GenderEnum> maps = new HashMap<>();


    static {
        for (GenderEnum enumInfo : GenderEnum.values()) {
            maps.put(enumInfo.getCode(), enumInfo);
        }
    }

    public static GenderEnum findByCode(int code) {
        GenderEnum enumInfo = maps.get(code);
        if (enumInfo == null) {
            throw new IllegalArgumentException("GenderEnum not found" + code);
        }
        return enumInfo;
    }

    @JsonValue
    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
