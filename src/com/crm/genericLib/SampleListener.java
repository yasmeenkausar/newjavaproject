package com.crm.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * 
 * @author Yasmeen
 *
 */

public class SampleListener implements ITestListener {
	/**
	 * This method takes the screenShot when a test script fails
	 */
	@Override
	public void onTestFailure(ITestResult t)
	{
		String failedTestName= t.getMethod().getMethodName();
		System.out.println("Test fail=="+failedTestName);
		EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.driver);
		
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
				File destFile=new File("./ScreenShot/"+failedTestName+".png");
				
				try {
					FileUtils.copyFile(srcFile,destFile);
				}
				catch (IOException e)
				{
					
				}

	
		

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	}

