package com.ek.demo.test1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ek.demo.test1.Calcuate;

/**
 * Assert
 * 异常对象expected
 * 简单的性能测试 timeout
 */
public class TestCalcuate {

  private Calcuate cal;

  @Before
  public void setUp() {
    cal = new Calcuate();
  }

  @Test
  public void testAdd() {
    int rel = cal.add(12, 22);
    // 第一个参数: 错误提示信息
    // 第二个参数: 期望的值
    // 第三个参数: 实际的值
    Assert.assertEquals("加法有问题", rel, 34);
  }

  @Test
  public void testMinus() {
    int rel = cal.minus(23, 22);
    Assert.assertEquals("减法有问题", rel, 1);
  }

  @Test
  public void testMul() {
    int rel = cal.mul(2, 9);
    Assert.assertEquals("乘法有问题", rel, 18);
  }

  // 表示这个测试应该抛出ArithmeticException,如果这里不抛出就报异常
  @Test(expected = ArithmeticException.class)
  public void testDivide() {
    int rel = cal.divide(4, 0);
    Assert.assertEquals("除法有问题", rel, 2);
  }

  // 表示这个方法应该在300毫秒内执行结束,才算是正确的
  @Test(timeout = 300)
  public void testTime() throws InterruptedException {
    Thread.sleep(200);
  }

}
