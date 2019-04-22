package br.com.gx2.funcoes;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class PrintScreen {
    private WebDriver driver;
    private Scenario scenario;

    public PrintScreen(Scenario scenario, WebDriver d) {
        this.driver = d;
        this.scenario = scenario;
    }

    public void capturarTela() throws InterruptedException {
        Thread.sleep(2000);
        this.scenario.embed(capturar(), "image/png");
    }

    public byte[] capturar(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        TakesScreenshot ts = (TakesScreenshot)driver;
        byte[] source = ts.getScreenshotAs(OutputType.BYTES);

        return source;
    }
}
