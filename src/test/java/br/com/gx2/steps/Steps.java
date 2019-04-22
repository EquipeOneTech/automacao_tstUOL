package br.com.gx2.steps;



import br.com.gx2.funcoes.OSValidator;
import br.com.gx2.funcoes.PrintScreen;
import br.com.gx2.funcoes.Wait;
import cucumber.api.Scenario;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt .Então;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {
    WebDriver driver;
    WebDriverWait waitDriver;
    Scenario cenario;
    WebDriverWait longWaitDriver;
    Actions acao;
    Wait wait;
    PrintScreen print;

    @Before
    public void inicioTeste(Scenario scenario){
        this.cenario = scenario;
        OSValidator.definindoDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new Wait(driver, 10000);
        acao = new Actions(driver);
        print = new PrintScreen(this.cenario, driver);
        waitDriver = new WebDriverWait(driver, 10);

    }

    @Dado("^que estou no site uol \"([^\"]*)\"$")
    public void queEstouNoSiteUol(String site){
        driver.get(site);
    }

    @Quando("^eu colocar o mouse sobre o menu \"([^\"]*)\"$")
    public void euColocarOMouseSobreOMenu(String xpath) throws InterruptedException {
        WebElement itMenu = wait.getElementByXpath(xpath); // Não precisava ser o wait aqui, pagina inicial
        acao.moveToElement(itMenu).perform();
        Thread.sleep(1000); // Somente para validar na hora da execução Lembrar de retirar ao homologar o script
        print.capturarTela();
    }

    @Quando("^clicar com o mouse sobre o link \"([^\"]*)\"$")
    public void clicarComOMouseSobreOLink(String xpath) throws InterruptedException {
        WebElement itMenu = wait.getElementByXpath(xpath);
        itMenu.click();
        print.capturarTela();
    }

    @Então ("^deve ser exibida tela com o texto \"([^\"]*)\" no campo \"([^\"]*)\"  #xpath$")
    public void deveSerExibidaTelaComOTextoNoCampoXpath(String conteudo, String xpath) throws Throwable {
        WebElement lblTexto = wait.getElementByXpath(xpath);
        print.capturarTela();
    }

    @Quando("^eu clicar no menu \"([^\"]*)\"  #xpath$")
    public void euClicarNoMenuXpath(String xpath) throws InterruptedException {
        WebElement itMenu = wait.getElementByXpath(xpath);
        itMenu.click();
        print.capturarTela();
    }

    @Quando("^clicar com o mouse sobre o link \"([^\"]*)\"  #xpath$")
    public void clicarComOMouseSobreOLinkXpath(String xpath) throws InterruptedException {
       WebElement itMenu = wait.getElementByXpath(xpath);
       itMenu.click();
       print.capturarTela();
    }

    @Quando("^eu clicar no item \"([^\"]*)\" #xpath$")
    public void euClicarNoItemXpath(String xpath) throws InterruptedException {
        WebElement itMenu = wait.getElementByXpath(xpath);
        itMenu.click();
        print.capturarTela();
    }

    @Então("^deve ser exibida a tela com texto \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void deveSerExibidaATelaComTextoNoCampo(String valor, String xpath) throws InterruptedException {
       WebElement lblTexto = wait.getElementByXpath(xpath);
       Assert.assertEquals("Valor nao encontrado em tela.", valor, lblTexto.getText());
       print.capturarTela();
    }


    @After
    public void finalTeste(){
        driver.close();
    }


}
