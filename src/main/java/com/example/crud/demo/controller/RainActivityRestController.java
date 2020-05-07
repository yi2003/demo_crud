package com.example.crud.demo.controller;

import com.example.crud.demo.entity.TestActivityEntity;
import com.example.crud.demo.model.*;
import com.example.crud.demo.repository.TestActivityRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/api/rain")
public class RainActivityRestController {

    @Autowired
    private TestActivityRespository activityRespository;


    public static Date  parseDate(String dateStr, SimpleDateFormat format) throws ParseException {
        return format.parse(dateStr);
    }

    public static String format(Date datetime, String pattern) {
        if (datetime == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(datetime);
        }
    }

    @RequestMapping(value = "/searchList")
    public SearchListResponse searchList(SearchListRequest request){

        SearchListResponse resp = activityRespository.getActivityList(request);
        return resp;
    }

    @RequestMapping(value = "/genderlist")
    public List<GenderInfo> queryGenderList(){
        Map<Integer,GenderEnum>  maps= GenderEnum.maps;

        List<GenderInfo> result = new ArrayList<>();

        for(Integer key : maps.keySet()){
            GenderInfo info =new GenderInfo();
            info.setGenderText(GenderEnum.findByCode(key).getMessage());
            info.setGenderValue(key);

            result.add(info);
        }
        return  result;
    }

    @RequestMapping(value = "/add")
    public RainActivityListVo add() {
        RainActivityListVo vo = new RainActivityListVo();
        String activityTimeHour = format(new Date(), "yyyy-MM-dd HH:mm:ss");
        vo.setActivityTimeHour(activityTimeHour);
      //  vo.
        //vo.
        vo.setRainSeconds(20L);
        vo.setStatus(1);

        return vo;
    }


    @RequestMapping(value = "/edit")
    public RainActivityListVo edit(EditRequest request) {
       return activityRespository.getActivityById(request.getId());
    }


    @RequestMapping(value = "/save")
    public SaveResponse save(RainActivityListVo vo) throws ParseException {
        SaveResponse res = new SaveResponse();
        if(StringUtils.isEmpty(vo.getActivityName())){
            res.setErrorCode("001");
            res.setErrorMsg("activity name is required");
            res.setStatus(false);
            return res;
        }
        else{

            if(0<vo.getId()){
            //if(vo.getId()>0){

                TestActivityEntity entity = activityRespository.getActivityEntityById(vo.getId());

                entity.setActivityId(vo.getActivityId().toString());
                entity.setActivityName(vo.getActivityName());
                entity.setStartTime(parseDate(vo.getStartTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
                entity.setEndTime(parseDate(vo.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));

                activityRespository.update(entity);
            }
            else{
                TestActivityEntity entity = new TestActivityEntity();
                entity.setActivityId(vo.getActivityId().toString());
                entity.setActivityName(vo.getActivityName());
                entity.setStartTime(parseDate(vo.getStartTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
                entity.setEndTime(parseDate(vo.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
                entity.setRainSeconds(vo.getRainSeconds());

                activityRespository.insert(entity);
            }

        }

        res.setStatus(true);

        return res;
    }
}
