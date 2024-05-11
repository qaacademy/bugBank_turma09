package scenarios;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.LoginPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/#");

    }

    @Test
    public void testeLogin(){

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, "flavio.goncalvesdias@gmail.com");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, "Flavio");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, "QAACADEMY");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "QAACADEMY");
        cadastroPage.clicarPorXpath(cadastroPage.campoContaComSaldoToogle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarSeContaFoiCriadaComSucesso();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);

        loginPage.preencherCampo(loginPage.campoEmail, "flavio.goncalvesdias@gmail.com");
        loginPage.preencherCampo(loginPage.campoSenha, "QAACADEMY");
        loginPage.clicarPorXpath(loginPage.btnAcessar);
        loginPage.validarLogin();


    }
}
