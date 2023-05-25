package com.tau.test.Steps;


import com.tau.poom.PageLoginCadastro;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Steps {

    private WebDriver driver;

    private PageLoginCadastro pageLoginCadastro;


    @Given("quero acessar o portal url {string}")
    public void queroAcessarOPortalUrl(String url) throws IOException {
        System.setProperty("webdriver.chrome.driver","src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        pageLoginCadastro = new PageLoginCadastro(driver);
        pageLoginCadastro.getScreenShot(driver,"You enter the portal");

    }

    @When("Valide o registro dos campos vazios de {string} e {string} de {string}")
    public void valideORegistroDosCamposVaziosDeNameEEmailDePassword(String name, String email, String password  ) throws InterruptedException, IOException {
        pageLoginCadastro = new PageLoginCadastro(driver);
        pageLoginCadastro.completeFields(name,email,password);
        pageLoginCadastro.getScreenShot(driver,"The registration of two users is shown in the display of the delete button");

        if(pageLoginCadastro.validate()){
            pageLoginCadastro.completeFields(name,email,password);
            pageLoginCadastro.validate();
        }else{
            System.out.println("No");
        }
    }

    @Then("para validar que não permite cadastro com campos vazios")
    public void paraValidarQueNãoPermiteCadastroComCamposVazios() throws InterruptedException {
        pageLoginCadastro = new PageLoginCadastro(driver);
        System.out.println(pageLoginCadastro.validateMessage());
        pageLoginCadastro.validate();

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
