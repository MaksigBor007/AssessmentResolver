package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        CommonMethod.takeScreenshot("passed" + result.getName());
    }
}