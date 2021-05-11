package com.fullteaching.selenium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)
public class SeleniumTest {
	WebDriver driver;
	
	public SeleniumTest() {}
	
	@BeforeClass
	public static void configuraDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pedro\\Documents\\qualidade-teste\\geckodriver.exe");
	}
	
	@Before
	public void init() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		driver = new FirefoxDriver(cap);
        driver.get("https://localhost:5000");
	}

	@Test
	@Order(1)
	public void testDocumentReady() {
		WebElement webElement = driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/div[1]/div[1]/div/h1"));

		assertNotNull(webElement);
		driver.close();
	}

	@Test
	@Order(2)
	public void testSignUp() {		
		WebElement signUpLink = driver.findElement(By.id("signUpButton"));
		signUpLink.click();
		
		WebElement signUpModal = driver.findElement(By.id("login-modal"));
		assertNotNull(signUpModal);
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("mellopedro@gmail.com");
		WebElement inputName = driver.findElement(By.id("nickName"));
		inputName.sendKeys("aluno");
		WebElement inputPass = driver.findElement(By.id("password"));
		inputPass.sendKeys("Pedro123456");
		WebElement inputConfirmPass = driver.findElement(By.id("confirmPassword"));
		inputConfirmPass.sendKeys("Pedro123456");
		
		WebElement iframe = driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/login-modal/div/div[1]/div/form/div[5]/div/re-captcha/div/div/div/iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();
		
		WebElement signUpButtom = new WebDriverWait(driver, 2000).until(ExpectedConditions.presenceOfElementLocated(By.id("sign-up-btn")));
		signUpButtom.click();

		WebElement waitElement = new WebDriverWait(driver, 2000).until(ExpectedConditions.presenceOfElementLocated(By.id("course-list")));
		assertNotNull(waitElement);
		
		driver.close();
	}

	@Test
	@Order(3)
	public void testLogin() {		
		WebElement loginModal = driver.findElement(By.xpath("/html/body/app/div/header/navbar/div/nav/div/ul/li[2]/a"));
		loginModal.click();

		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("mellopedro@id.uff.br");
		
		WebElement inputPass = driver.findElement(By.id("password"));
		inputPass.sendKeys("Pedro123456");
		
		WebElement loginButtom = driver.findElement(By.id("log-in-btn"));
		loginButtom.submit();
		
		WebElement waitElement = new WebDriverWait(driver, 2000).until(ExpectedConditions.presenceOfElementLocated(By.id("course-list")));
		assertNotNull(waitElement);
		
		driver.close();
	}
	

}