package com.example.crud.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.print.DocFlavor;

@Getter
@Setter
public class SearchListRequest {

    private Integer pageIndex;
    private Integer pageSize;

    private String activityName;
    private String StartDate;
    private String EndDate;

    public int getSkip() {
        return (this.pageIndex - 1) * this.pageSize;
    }
}
