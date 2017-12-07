import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class Dominio {

    private WebDriver driver;

    public Dominio (WebDriver driver){
        this.driver = driver;
    }

    public void cadastrarDominio (String cpf, String estadoCivil){

        WebElement txtCpf = driver.findElement(By.name("proprietario.cpfCnpj"));

        txtCpf.sendKeys(cpf);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement combo = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.dominio.bloco_form > div.campos_preencher > div:nth-child(7) > select"));
//        Select comboEstadoCivil = new Select(combo);
//        comboEstadoCivil.selectByVisibleText(estadoCivil);

        //WebElement botaoAdicionar = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.dominio.bloco_form > div.botoes > button.adicionar.ng-binding"));
        WebElement botaoAdicionar = driver.findElement(By.xpath("//*[@id=\"form_imovel_rural\"]/div[1]/div[4]/div[5]/button[1]"));
        //botaoAdicionar.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", botaoAdicionar);

    }
}
