package tests.base;

import org.testng.*;

/**
 *  This program is not for Commercial purpose, Demo Skills Only
 * @author Dawid Janik github.com/dsyou
 */
public class TestListener extends BaseTest implements ITestListener,IInvokedMethodListener {

    public String methodName;


    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

        System.out.println("***** Error "+result.getName()+" test has failed *****");
        testName = methodName;
        System.out.println("Name #### " + testName);
    }


    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        methodName=method.getTestMethod().getMethodName();
        System.out.println("Method Name " + methodName);
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
