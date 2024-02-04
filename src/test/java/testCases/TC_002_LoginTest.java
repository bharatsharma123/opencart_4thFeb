package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void verify_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{	
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();		
			hp.clickLogin();
			
			
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email")); // valid email, get it from properties file
			lp.setPassword(p.getProperty("password")); // valid password, get it from properties file
			lp.clickLogin();
			
			
			//MyAccountPage
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();
			if(targetpage==true)
			{
				logger.info("Login test passed......");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("test case failed");
				Assert.fail();
			}
			
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}


