package com.example.crud.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveResponse {

    private boolean status;
    private String errorCode;
    private String errorMsg;
}
