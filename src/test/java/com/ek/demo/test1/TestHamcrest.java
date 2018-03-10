package com.ek.demo.test1;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class TestHamcrest {

  /* 首先需要静态导入import static org.hamcrest.Matchers.*;(hamcrest-all包中) 
   * allOf();-满足所有条件
   * greaterThan();-大于
   * lessThan();-小于
   * endsWith();-字符串以什么结尾
   * */
  @Test
  public void testHamcrest() {
    // 判断50是否大于20, greaterThan(),大于
    assertThat(50, greaterThan(20));
    // 判断50是否大于20并且不小于60
    assertThat(50, allOf(greaterThan(20), lessThan(60)));
    // 判断某个字符串是否以另一个字符串结尾
    assertThat("abc.txt", endsWith("txt"));
  }

}
