package design_patterns.home_made_jUnit;

public class Main {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
      //  TestClass testClass = new TestClass();
      //  testRunner.runAllTest(testClass);
       // testRunner.runAllTestForClass(TestClass.class);
        testRunner.runAllTestsForClassByName("design_patterns.home_made_jUnit.TestClass");

    }
}
