import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Documentacao {

    private WebDriver driver;

    public Documentacao (WebDriver driver){
        this.driver = driver;
   }

   public void cadastrarDocumentacao (String nomePropriedade, String area, String tipoDocumento){

       //WebElement txtNomePropriedade = driver.findElement(By.name("documento.nome"));
       WebElement txtNomePropriedade = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.documentacao.bloco_form > div:nth-child(4) > input"));
       //WebElement txtArea = driver.findElement(By.name("documento.area"));
       WebElement txtArea = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.documentacao.bloco_form > div:nth-child(5) > input"));

       WebElement combo = driver.findElement(By.name("documento.tipoDocumento"));
       Select comboUF = new Select(combo);
       comboUF.selectByVisibleText(tipoDocumento);

       txtNomePropriedade.sendKeys(nomePropriedade);
       //Float areaReal = Float.parseFloat(area);
       txtArea.sendKeys(area);

       JavascriptExecutor executor = (JavascriptExecutor) driver;

       //String dominio = new String ("\"" + "//*[@id=" + "\\\"" + cpf + "\\" + "\"]\"");
       //String dominio = new String ("\"" + "//*[@id=" + cpf + "\"]\"");

       //WebElement adicionarDominio = driver.findElement(By.xpath(dominio));
       //WebElement adicionarDominio = driver.findElement(By.xpath("//*[@id=\"079.390.476-55\"]"));
       //WebElement adicionarDominio = driver.findElement(By.xpath(String.format("//*[@id=\"[%s]\"]", cpf)));
       //adicionarDominio.click();
       //---WebElement adicionarDominio = driver.findElement(By.id("079.390.476-55"));
       //WebElement adicionarDominio = driver.findElement(By.id(cpf));
       //executor.executeScript("arguments[0].click();", adicionarDominio);

//       try {
//           Thread.sleep(3000);
//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       }

       WebElement adicionarDominio = driver.findElement(By.name("documento.proprietarios[]"));
       executor.executeScript("arguments[0].click();", adicionarDominio);

       WebElement adicionarTodos = driver.findElement(By.xpath("//*[@id=\"todos_proprietario_documento\"]"));
       //adicionarTodos.click();
       executor.executeScript("arguments[0].click();", adicionarTodos);


       WebElement botaoAdicionar = driver.findElement(By.xpath("//*[@id=\"form_imovel_rural\"]/div[1]/div[5]/div[22]/button[1]"));
       //botaoAdicionar.click();
       executor.executeScript("arguments[0].click();", botaoAdicionar);
   }

}
