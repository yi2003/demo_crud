package com.example.crud.demo.repository;

import com.example.crud.demo.entity.TestActivityEntity;
import com.example.crud.demo.entity.TestActivityEntityExample;
import com.example.crud.demo.mapper.TestActivityEntityMapper;
import com.example.crud.demo.model.RainActivityListVo;
import com.example.crud.demo.model.SearchListRequest;
import com.example.crud.demo.model.SearchListResponse;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class TestActivityRespository{

    @Resource
    private TestActivityEntityMapper  acMapper;

    public SearchListResponse getActivityList(SearchListRequest request){

        SearchListResponse resp = new SearchListResponse();

        TestActivityEntityExample example = new TestActivityEntityExample();
        TestActivityEntityExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(request.getActivityName())){
           criteria.andActivityNameLike(request.getActivityName());
        }

        int totalCount =acMapper.countByExample(example);

        Integer pageIndex = request.getPageIndex() <=0? 1: request.getPageIndex();
        request.setPageIndex(pageIndex);
        example.setOrderByClause(String.format("id desc limit %s,%s", request.getSkip(), request.getPageSize()));
        List<TestActivityEntity> entityList = acMapper.selectByExample(example);

        if(totalCount>0){
            Long totalRainSeconds = entityList.stream().map(c->c.getRainSeconds()).reduce((a,b)->a+b).get();
            List<RainActivityListVo> voList= entityList.stream().map((c) ->(RainActivityListVo)BuildVo(c)).collect(Collectors.toList());
            resp.setTotalCount(totalCount);
            resp.setDataList(voList);
            return resp;
        }
        else{
            resp.setTotalCount(0);
        }
        return  resp;

    }

    private  RainActivityListVo  BuildVo(TestActivityEntity c) {
        RainActivityListVo vo= new RainActivityListVo();
        vo.setId(c.getId());
        vo.setActivityId(Integer.parseInt(c.getActivityId()));
        vo.setActivityName(c.getActivityName());
        vo.setRainSeconds(c.getRainSeconds());
        vo.setStartTime(format(c.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        vo.setEndTime(format(c.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        return vo;
    }

    public static String format(Date datetime, String pattern) {
        if (datetime == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(datetime);
        }
    }


    public RainActivityListVo getActivityById(Integer activityId) {
        TestActivityEntity entity = acMapper.selectByPrimaryKey(activityId);
        return this.BuildVo(entity);

    }

    public TestActivityEntity getActivityEntityById(Integer activityId) {
        TestActivityEntity entity = acMapper.selectByPrimaryKey(activityId);
        return entity;

    }

    public void update(TestActivityEntity entity) {
        this.acMapper.updateByPrimaryKey(entity);
    }

    public void insert(TestActivityEntity entity) {
        this.acMapper.insert(entity);
    }


//    private List<RainActivityListVo> BuildVoList(TestActivityEntity entity) {
//        return null;
//    }
}
