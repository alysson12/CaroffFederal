import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Cadastrante {

    private WebDriver driver;

    public Cadastrante (WebDriver driver) {
        this.driver = driver;
    }

    public void cadastrarCadastrante (String cpf, String data, String nome, String nomeMae, int representante){

        //Busca aos elementos da página
        WebElement txtCpf = driver.findElement(By.name("cadastrante.cpf"));
        txtCpf.sendKeys(cpf);

        WebElement txtData = driver.findElement(By.name("cadastrante.dataNascimento"));
        WebElement txtNome = driver.findElement(By.name("cadastrante.nome"));
        WebElement txtNomeMae = driver.findElement(By.name("cadastrante.nomeMae"));

        if (representante == 1){
            driver.findElement(By.id("representante_proprietario")).click();
        }
        else if (representante == 2){
            driver.findElement(By.id("representante_cadastrante")).click();
        }
        else if (representante == 3){
            driver.findElement(By.id("representante_pessoaJuridicaOrgao")).click();
        }

        txtNome.clear();
        txtNomeMae.clear();

        //Preenchimento dos dados nas caixas de diálogo
        txtData.sendKeys(data);
        txtNome.sendKeys(nome);
        txtNomeMae.sendKeys(nomeMae);


        //Submissão dos dados
//        txtCpf.submit();
//        txtData.submit();
//        txtNome.submit();
//        txtNomeMae.submit();


    }
}
