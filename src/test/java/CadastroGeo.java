import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroGeo {

    private WebDriver driver;

    public CadastroGeo (WebDriver driver){
        this.driver = driver;
    }

    public Geo novoGeo(){
        return new Geo(driver);
    }

    public void clickAba(){

        WebElement aba = driver.findElement(By.cssSelector("#navs > li.geo.navs-links"));
        aba.click();
    }
}
