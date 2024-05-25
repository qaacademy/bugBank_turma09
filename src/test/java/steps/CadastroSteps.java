package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class CadastroSteps {

    WebDriver driver;
    CadastroPage cadastroPage;

    @Dado("que eu esteja na pagina de cadastro")
    public void queEuEstejaNaPaginaDeCadastro() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/");
        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
    }

    @Quando("eu preencha o campo email:{string}")
    public void euPreenchaOCampoEmail(String email) {
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, email);
    }

    @Entao("valido que a mensagem: {string} foi exibida")
    public void validoQueAMensagemFoiExibida(String mensagem) {
        cadastroPage.validarMensagemDeErroEmail(mensagem);
    }
}
