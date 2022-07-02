import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	@Test
	public void deveInteragirComCadastro() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file://" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
       
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Ewerton");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Martins");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
		.selectByVisibleText("Mestrado");
		 
		new Select(driver.findElement(By.id("elementosForm:esportes")))
		.selectByVisibleText("Karate");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Estudando e treinando teste automatizados com Selenium Webdriver");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Ewerton"));		
		Assert.assertEquals("Sobrenome: Martins", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Frango ", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: mestrado ", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Karate ", driver.findElement(By.id("descEsportes")).getText());
    }
}
