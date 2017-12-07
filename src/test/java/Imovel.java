import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Imovel {

    private WebDriver driver;

    public Imovel (WebDriver driver){
        this.driver = driver;
    }

    public void cadastrarImovel (String nome, String cep, String acesso, String endereco, String numero, String bairro, String email, String UF, String municipio){

        WebElement txtNome = driver.findElement(By.name("imovel.nome"));
        WebElement txtCep = driver.findElement(By.name("imovel.cep"));
        WebElement txtAreaAcesso = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.imovel.bloco_form > div.campo.gigante.relative.sem_altura > textarea"));
        WebElement txtEndereco = driver.findElement(By.name("imovel.endereco.logradouro"));
        WebElement txtNumero = driver.findElement(By.name("imovel.endereco.numero"));
        WebElement txtBairro = driver.findElement(By.name("imovel.endereco.bairro"));
        WebElement txtCepLogradouro = driver.findElement(By.name("imovel.endereco.cep"));
        WebElement txtEmail = driver.findElement(By.name("imovel.endereco.email"));

        txtNome.sendKeys(nome);
        txtCep.sendKeys(cep);
        txtAreaAcesso.sendKeys(acesso);
        txtEndereco.sendKeys(endereco);
        txtNumero.sendKeys(numero);
        txtBairro.sendKeys(bairro);
        txtCepLogradouro.sendKeys(cep);
        txtEmail.sendKeys(email);

        //selecao de estado
        WebElement combo = driver.findElement(By.id("imovel.uf"));
        Select comboUF = new Select(combo);
        comboUF.selectByVisibleText(UF);
        combo = driver.findElement (By.id ("imovel.endereco.uf"));
        Select comboEnderecoUF = new Select(combo);
        comboEnderecoUF.selectByVisibleText(UF);

        WebElement combo2 = driver.findElement(By.id("imovel.municipio"));
        Select comboMunicipio = new Select(combo2);
        comboMunicipio.selectByVisibleText(municipio);

        WebElement botaoOK = driver.findElement(By.cssSelector("#winBox > div.buttons > button"));
        botaoOK.click();

        WebElement combo3 = driver.findElement(By.id ("imovel.endereco.municipio"));
        Select comboMunicipio2 = new Select(combo3);
        comboMunicipio2.selectByVisibleText(municipio);
    }

//    public void proximaPagina (){
//        WebElement proximo = driver.findElement(By.cssSelector("#button avancar"));
//        proximo.click();
//    }

}
