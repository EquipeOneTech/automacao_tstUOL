package br.com.gx2.funcoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriverWait wait;

    /**Métoodo construtor*/
    public Wait(WebDriver driver, long timeOutInSecunds){
        this.wait = new WebDriverWait(driver, timeOutInSecunds);
    }

    /**
     * Métodos auxiliares Wait.
     **/

    public WebElement getElementById(String id){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public WebElement getElementByXpath(String xpath){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public WebElement getElementByPartialLink(String parcialLink){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(parcialLink)));
    }

    public WebElement getElementBylLink(String Link){
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Link)));
    }

}
