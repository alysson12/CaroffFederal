import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroInformacoes {

    private WebDriver driver;

    public CadastroInformacoes (WebDriver driver){
        this.driver = driver;
    }

    public Informacoes novoInformacoes (){
        return new Informacoes(driver);
    }

    public void clickAba(){

        WebElement aba = driver.findElement(By.cssSelector("#navs > li.informacoes.navs-links.rigth-edge"));
        aba.click();
    }
}
