package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public String elementoSaldo = "//p[@id='textBalance']";
    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validarSaldo(String valorEsperado) {
        String atual = driver.findElement(By.xpath(elementoSaldo)).getText();
        Assert.assertEquals(valorEsperado, atual);
    }
}
