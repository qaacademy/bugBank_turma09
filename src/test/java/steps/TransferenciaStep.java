package steps;

import io.cucumber.datatable.DataTable;
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
import page.TransferenciaPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TransferenciaStep {
    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    TransferenciaPage transferenciaPage;
    HomePage homePage;

    String conta2;
    String digito2;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        homePage = new HomePage(driver);
        driver.get("http://localhost:3000/");
    }

    @Dado("fazer login no bugbank com email:{string} e a senha: {string}")
    public void queEuEstejaLogadoNoBugbankComEmailEASenha(String email, String senha) {
        loginPage.fazerLogin(email, senha);

    }

    @Quando("clicar no botao transferencia")
    public void clicarNoBotaoTransferir() {
        homePage.clicarPorXpath(homePage.btnTransferencia);
    }

    @E("clicar em transferir")
    public void clicarEmTransferir() {
        transferenciaPage.clicarPorXpath(transferenciaPage.btnTransferir);
    }

    @Entao("validar se a transferencia foi feita com sucesso.")
    public void validarSeATransferenciaFoiFeitaComSucesso() {
        transferenciaPage.validarTransferenciaSucesso();
    }

    @Dado("que possua duas contas cadastradas com os dados")
    public void quePossuaDuasContasCadastradasComOsDados(DataTable table) {
        List<Map<String, String>> listaDeContas = table.asMaps(String.class, String.class);
        System.out.println(listaDeContas.get(0).get("email"));
        cadastroPage.cadastrarNovaConta(listaDeContas.get(2).get("email"), listaDeContas.get(0).get("nome"), listaDeContas.get(0).get("senha"));
        cadastroPage.cadastrarNovaContaSemSaldo(listaDeContas.get(0).get("email_2"), listaDeContas.get(0).get("nome_2"), listaDeContas.get(0).get("senha_2"));
        conta2 = cadastroPage.conta;
        digito2 = cadastroPage.digito;
    }

    @E("preencher os dados da transferencia com valor: {string} e descrição: {string}")
    public void preencherOsDadosDaTransferenciaComValorEDescrição(String valor, String descricao) {
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoNumeroDaConta, conta2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDigitoConta, digito2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoValor, valor);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDescricao, descricao);
    }
}
