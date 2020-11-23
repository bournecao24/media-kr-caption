package com.kr.caption.designmode.jiketime.jike19Chapter;


/**
 * 只需要在框架预留的扩展点，也就是 TestCase 类中的 doTest() 抽象函数中，填充具体的测试代码就可以实现之前的功能了，完全不需要写负责执行流程的 main() 函数
 */
public class UserServiceTestV2 extends TestCase {
    // 注册操作还可以通过配置的方式来实现，不需要程序员显示调用 register()
    static {
        JunitApplication.register(new UserServiceTestV2());
    }

    @Override
    public Boolean doTest() {

        return null;
    }
}