package core;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class MyLogListener implements ITestListener{
    private int m_count = 0;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' PASSED");
        log(".........");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' FAILED");
        log("Class: " + iTestResult.getTestClass());
        log("Priority of method: " + iTestResult.getMethod().getPriority());
        log("Methods depended upon: " + Arrays.toString(iTestResult.getMethod().getMethodsDependedUpon()));
        log(".........");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' SKIPPED");
        log("Class :" + iTestResult.getTestClass());
        log("Priority of method: " + iTestResult.getMethod().getPriority());
        log("Methods depended upon: " + Arrays.toString(iTestResult.getMethod().getMethodsDependedUpon()));
        log(".........");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log(iTestContext.getName() + " started.......\n");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log("\nTest results");
        log("Failed tests: " + iTestContext.getFailedTests().size());
        log("Skipped tests: " + iTestContext.getSkippedTests().size());
    }

    private void log(String string) {
        System.out.println(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}
