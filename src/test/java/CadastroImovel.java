import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroImovel {
    private WebDriver driver;

    public CadastroImovel(WebDriver driver){
        this.driver = driver;
    }

    public void visitaImovel(){
        driver.get("http://localhost:3000/agriculturaFamiliarIndividual.html");
    }

    public Imovel novoImovel() {
        //driver.findElement(By.className("imovel navs-links")).click();
        return new Imovel(driver);
    }

    public void clickAba (){
        WebElement aba = driver.findElement(By.cssSelector("#navs > li.imovel.navs-links"));
        aba.click();
    }

}
