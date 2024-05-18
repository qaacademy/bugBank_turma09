package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;


public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    HomePage homePage;


    @Dado("que eu esteja logado no bugbank com email:{string} e a senha: {string}")
    public void queEuEstejaLogadoNoBugbankComEmailEASenha(String email, String senha) {
           loginPage.fazerLogin(email, senha);

    }

    @Quando("carregar a homepage")
    public void carregarAHomepage() {
        loginPage.validarLogin();
    }

    @Entao("validar se o saldo é igual: {string}")
    public void validarSeOSaldoEIgual(String valor) {
        homePage.validarSaldo("Saldo em conta R$ "+valor);
    }

    @Dado("que eu possua cadastrado no bugbak o email: {string}, nome: {string} e a senha: {string}")
    public void queEuPossuaCadastradoNoBugbakOEmailNomeEASenha(String email, String nome, String senha) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        homePage = new HomePage(driver);
        driver.get("http://localhost:3000/#");

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, email);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, nome);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, senha);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, senha);
        cadastroPage.clicarToogleSaldo();
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarSeContaFoiCriadaComSucesso();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);
    }


}
