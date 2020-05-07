package com.example.crud.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void test3() {
		List<Student> students = new ArrayList<Student>() {
			{
				add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
				add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
				add(new Student(20162001, "仲谋", 19, 3, "土木工程", "浙江大学"));
				add(new Student(20162001, "仲谋", 25, 3, "土木工程", "浙江大学"));
				add(new Student(20162001, "仲谋", 28, 3, "土木工程", "浙江大学"));
				add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
				add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
				add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
				add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
				add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
				add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
				add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
				add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
			}
		};

		//获取计算机科学专业学生的年龄总和
		int totalAge = students.stream().filter(c->c.getMajor().equals("计算机科学")).map(t->t.getAge()).reduce((c,t)->c+t).get();
		System.out.println(totalAge);


		Logger logger = LoggerFactory.getLogger(getClass());

		logger.trace("this is a trace log");
		logger.debug("this is a debug log");
		logger.info("this is a info log");
	}

}
