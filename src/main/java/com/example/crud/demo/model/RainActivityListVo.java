package com.example.crud.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RainActivityListVo {

    private String[] checkedGender;
    private String[] fileUploadUrls;

    private Integer id;

    public int status;
    /**
     * 活动Id
     */
    private Integer activityId;

    /**
     * 抽奖活动名称
     */
    private String activityName;


    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;



    /**
     * 活动时间
     */
    private String activityTimeHour;


    /**
     * 持续时间
     */
    private Long rainSeconds;


}
