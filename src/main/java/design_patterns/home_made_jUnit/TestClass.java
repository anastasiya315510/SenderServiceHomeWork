package design_patterns.home_made_jUnit;

public class TestClass {
    public void init(){
        System.out.println("Hello init class");
    }
    @MyTest
    public void simpleTest(){
        System.out.println(22222222);
    }
    public void test1(){
        System.out.println("111111");
    }
}
