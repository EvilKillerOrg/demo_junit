package com.ek.demo.test1.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * TestSuite 测试组件,一次测试多个单元测试类 
 */
@RunWith(Suite.class) //标识是一个Suite的类
@SuiteClasses({ TestA.class, TestB.class }) //包含哪些测试组件
public class TestSuite {

}
