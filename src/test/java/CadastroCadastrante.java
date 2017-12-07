import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.String;


public class CadastroCadastrante {

    private WebDriver driver;

    public CadastroCadastrante(WebDriver driver){
        this.driver = driver;
    }

    public void visita(){
        driver.get("http://localhost:3000/agriculturaFamiliarIndividual.html");
    }

    public Cadastrante novoCadastrante(){
        //driver.findElement(By.className("cadastrante navs-links")).click();
        return new Cadastrante(driver);
    }

    public void clickAba (){

        //Clique no botão proximo
        //WebElement proximo = driver.findElement(By.cssSelector("#form_imovel_rural > div.clear > button.avancar"));
        //WebElement proximo = driver.findElement(By.cssSelector("button #button.avancar"));
        //WebElement proximo = driver.findElement(By.cssSelector("button[type='button']"));
        //#form_imovel_rural > div.clear > button.avancar

        //Clique na aba
        //#navs > li.imovel.navs-links
        WebElement aba = driver.findElement(By.cssSelector("#navs > li.cadastrante.navs-links.left-edge"));
        aba.click();
    }

//    public boolean existeCadastrante(String nome, String nomeMae){
//        //return driver.getPageSource().contains(nome) && driver.getPageSource().contains(nomeMae);
//        WebElement txtConfere = driver.findElement(By.name("cadastrante.nome"));
//       // WebElement txtConfereNovo = driver.findElement(By.className("campo")).getText());
//        String txt = txtConfere.getText();
//        //String txtNovo = txtConfereNovo.getText();
//
//        //String teste = driver.findElement(By.name("cadastrante.nome")).getText();
//        if (txt == nome){//usar o compare (string)
//            return true;
//        }
//        //driver.findElement(By.id("cadastrante.nome")).getAttribute(nome);
//        //driver.findElement(By.id("cadastrante.dataNascimento")).getAttribute(nomeMae);
//        //WebElement element = driver.findElement(By.ByTagName("cadastrante.nome"));
//
//
//        return false;
//    }
}
