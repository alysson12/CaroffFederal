import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Geo {

    private WebDriver driver;

    public Geo (WebDriver driver){
        this.driver = driver;
    }

    public static void aguardarAlteracaoValor(final WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(new ExpectedCondition<Boolean> () {
            public Boolean apply(WebDriver driver) {
                String value = element.getText();

                if(!value.equals("")) {
                    return true;
                }
                return false;
            }
        });
    }


    public String cadastrarGeo (String arquivo){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        //Clique na opção de Área do Imóvel
        WebElement areaImovel = driver.findElement(By.cssSelector("#controlePassos > ul > li.areaImovel.habilitado > a"));
        areaImovel.click();

        //Clique na opção de importar shape para área do imóvel
        WebElement importar_menu = driver.findElement(By.cssSelector("#controlesDesenho > ul > li.quadroImportacao.habilitado > a"));
        executor.executeScript("arguments[0].click();", importar_menu);
        //importar_menu.click(); caso para o chrome

        //Importação do arquivo SHP
        WebElement importar_file = driver.findElement(By.cssSelector("#importacao_input > button > input[type='file']"));
        try {
            importar_file.sendKeys(arquivo);
        } catch (Exception ex) {
            System.out.println(ex + ex.getMessage());
        }

        //Clique no quadro de MF
        WebElement quadroMF = driver.findElement(By.xpath("//*[@id=\"controlesNavInfo\"]/ul/li[8]/a"));
        executor.executeScript("arguments[0].click();", quadroMF);

        //Aguardando cálculo do valor da área do imóvel
        WebElement areaImovelGeo = driver.findElement(By.xpath("//*[@id=\"quadroModuloFiscal\"]/table/tbody/tr[1]/td"));
        aguardarAlteracaoValor (areaImovelGeo, driver);

        //Retorno do valor da área do imóvel
        return areaImovelGeo.getText();

    }

}
