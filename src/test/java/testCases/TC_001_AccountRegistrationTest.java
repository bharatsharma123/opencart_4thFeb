package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
		
	
	@Test(groups= {"regresion","master"})
	public void verify_account_Registration()
	{
		
		logger.info("*******Staring TC_001_AccountRegistrationTest*********");
		try 
		{
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		hp.clickRegister();
		logger.info("clicked on registration link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		logger.info("firstname set");
		
		regpage.setLastName(randomeString().toUpperCase());
		logger.info("lastname set");
		
		regpage.setEmail(randomeString()+"@mailinator.com");
		logger.info("email set");
		
		regpage.setTelephone(randomeNumber());	
		logger.info("telephone set");
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		logger.info("passwords set");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		
		}
		catch(Exception e)
		{
			logger.error("***test failed***");
			Assert.fail();
		
		}
		logger.info("**************finished test case****************");
	
	}
	

}
