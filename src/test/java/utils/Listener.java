package utils;

import tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();

        if (webDriver != null) {
            String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("target/screenshots/" + fileName);
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
