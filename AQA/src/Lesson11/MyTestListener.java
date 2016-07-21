package Lesson11;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyTestListener implements ITestListener{
    private int m_count = 0;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getTestClass().getName() + " started.....");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log(iTestResult.getName() + "--Test method success\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        log(iTestResult.getName() + "--Test method failed\n");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log(iTestResult.getName() + "--Test method skipped\n");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}
