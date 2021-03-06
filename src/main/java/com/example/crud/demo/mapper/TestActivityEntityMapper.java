package com.example.crud.demo.mapper;

import com.example.crud.demo.entity.TestActivityEntity;
import com.example.crud.demo.entity.TestActivityEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestActivityEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int countByExample(TestActivityEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int deleteByExample(TestActivityEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int insert(TestActivityEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int insertSelective(TestActivityEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    List<TestActivityEntity> selectByExample(TestActivityEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    TestActivityEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TestActivityEntity record, @Param("example") TestActivityEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TestActivityEntity record, @Param("example") TestActivityEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TestActivityEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testactivity
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TestActivityEntity record);
}