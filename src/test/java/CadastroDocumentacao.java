import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroDocumentacao {

    private WebDriver driver;

    public CadastroDocumentacao (WebDriver driver){
        this.driver = driver;
    }

    public Documentacao novaDocumentacao(){
        return new Documentacao(driver);
    }

    public void clickAba(){

        WebElement aba = driver.findElement(By.cssSelector("#navs > li.documentacao.navs-links"));
        aba.click();
    }
}
