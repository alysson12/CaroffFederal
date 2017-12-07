import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroDominio {

    private WebDriver driver;

    public CadastroDominio (WebDriver driver){
        this.driver = driver;
    }

    public Dominio novoDominio(){
        return new Dominio(driver);
    }

    public void clickAba(){

        Boolean disponibilidadeDominio = new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated (By.xpath ("/html/body/div[6]")));

        WebElement aba = driver.findElement(By.cssSelector("#navs > li.dominio.navs-links"));
        aba.click();
    }

}
