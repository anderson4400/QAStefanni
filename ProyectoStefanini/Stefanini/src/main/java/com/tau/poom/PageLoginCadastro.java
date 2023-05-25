package com.tau.poom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageLoginCadastro extends BaseConfiguration{

    private WebDriver driver;
    public PageLoginCadastro(WebDriver driver) {
        super(driver);
    }

    By inputUser = By.xpath("//*[@id='name']");
    By inputEmail = By.xpath("//*[@id='email']");
    By inputPassword = By.xpath("//*[@id='password']");
    By btnLogin = By.xpath("//*[@id='register']");
    By txtMessageName = By.xpath("//*[@id='root']/div/div/div[2]/form/div[1]/p");
    By txtMessageEmail = By.xpath("//*[@id='root']/div/div/div[2]/form/div[2]/p");
    By txtMessagePassword = By.xpath("//*[@id='root']/div/div/div[2]/form/div[3]/p");
    By txtMessageNameComplet = By.xpath("//*[@id='root']/div/div/div[2]/form/div[1]/p");
    By txtMessageEmailIvalide = By.xpath("//*[@id='root']/div/div/div[2]/form/div[2]/p");
    By txtMessagePasswordMenor =By.xpath("//*[@id='root']/div/div/div[2]/form/div[3]/p");
    By btnDeleted = By.xpath("//*[@id='removeUser1']");
    By litstxt = By.xpath("//*[@id='tdUserId2']");


    public  void startLogin(String url) throws IOException {
        openBrowser(url);
    }

    public void completeFields(String name, String email, String password){
        try {
            tyPe(name, inputUser);
            tyPe(email, inputEmail);
            tyPe(password, inputPassword);
            clic(btnLogin);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public String validateMessage(){
        String valor = null;
        try{
        if(isElementPresent(txtMessageName)){
            valor = getText(txtMessageName);
            getScreenShot(driver,"The required field message is displayed in the name field");
        }else if(isElementPresent(txtMessageEmail)){
            valor =getText(txtMessageEmail);
            getScreenShot(driver,"The required field message is displayed in the email field");
        }else if (isElementPresent(txtMessagePassword)){
            valor =getText(txtMessagePassword);
            getScreenShot(driver,"Required field message is displayed in key field");
        }else if (isElementPresent(txtMessageNameComplet)){
            valor =getText(txtMessageNameComplet);
            getScreenShot(driver,"The name field message is displayed to enter a valid name");
        }else if(isElementPresent(txtMessageEmailIvalide)){
            valor = getText(txtMessageEmailIvalide);
            getScreenShot(driver,"The email field message is displayed to enter a valid email");
        }else if (isElementPresent(txtMessagePasswordMenor)){
            valor = getText(txtMessagePasswordMenor);
            getScreenShot(driver,"The key field message of entering a key greater than 8 is displayed");

        }
        }catch (Exception e){
            e.getMessage();
        }
        return valor;
    }

    public boolean validate() throws InterruptedException {
        boolean f = false;
        try {

            Thread.sleep(1000);
            if (isElementPresent(btnDeleted)) {
                getScreenShot(driver," I registered correctly");
                f = true;
                if (isElementPresent(litstxt)) {
                    clic(btnDeleted);
                    getScreenShot(driver,"The user was deleted correctly");
                }
            } else {
                getScreenShot(driver,"The item is not available");
            }
        }catch (Exception e){
            e.getMessage();
        }
        return  f;
    }
}
