package testes.sistema.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAutomatizadoLogin {

	private WebDriver driver;
	
	@Before
	public void ConstroiCenario(){
		driver = null;
		System.setProperty("webdriver.chrome.driver", "C:/Users/Samuel"
				+ "/Eclipse/Libs/selennium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/viewmaster/");
	}
	
	@After
	public void FechaCenario() {
		driver.close();
	}
	
	@Test
	public void TestaLoginInvalido(){

		WebElement login = driver.findElement(By.id("login"));
		WebElement senha = driver.findElement(By.id("pass"));
		WebElement botaoSalvar = driver.findElement(By.id("entrar"));
				
		login.sendKeys("xyzxyzxyz"); 
		senha.sendKeys("xyzxyzxyz");
		botaoSalvar.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
		
		boolean achouNome = driver.getPageSource().contains("Os parametros informados estão incorretos!"); 
		assertTrue(achouNome); 
	}
	
	@Test
	public void TestaLoginValido(){

		WebElement login = driver.findElement(By.id("login"));
		WebElement senha = driver.findElement(By.id("pass"));
		WebElement botaoSalvar = driver.findElement(By.id("entrar"));
				
		login.sendKeys("samito"); 
		senha.sendKeys("123");
		botaoSalvar.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
		
		boolean achouNome = driver.getPageSource().contains("lalala sucesso"); 
		assertTrue(achouNome); 
	}
	
	@Test
	public void TestaFecharPopupPeloBotaoFechar(){

		WebElement login = driver.findElement(By.id("login"));
		WebElement senha = driver.findElement(By.id("pass"));
		WebElement botaoSalvar = driver.findElement(By.id("entrar"));
		WebElement botaoFecharModal = driver.findElement(By.id("botaoFecharModal"));
		WebElement modal = driver.findElement(By.id("modal"));
				
		login.sendKeys("xyzxyzxyz"); 
		senha.sendKeys("xyzxyzxyz");
		botaoSalvar.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
	    botaoFecharModal.click();
	    
	    wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal")));
	
	    boolean fechouModal = modal.isDisplayed(); 
		assertFalse(fechouModal); 
	}
	
	@Test
	public void TestaFecharPopupPeloBotaoClose(){

		WebElement login = driver.findElement(By.id("login"));
		WebElement senha = driver.findElement(By.id("pass"));
		WebElement botaoSalvar = driver.findElement(By.id("entrar"));
		WebElement botaoCloseModal = driver.findElement(By.id("botaoCloseModal"));
		WebElement modal = driver.findElement(By.id("modal"));
				
		login.sendKeys("xyzxyzxyz"); 
		senha.sendKeys("xyzxyzxyz");
		botaoSalvar.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
	    botaoCloseModal.click();
	    
	    wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal")));
	
	    boolean fechouModal = modal.isDisplayed(); 
		assertFalse(fechouModal); 
	}
}
