package com.example.crud.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchListResponse {

    private Integer totalCount;
    private List<RainActivityListVo> dataList;
}

