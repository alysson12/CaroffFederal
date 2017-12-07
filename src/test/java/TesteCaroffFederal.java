import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteCaroffFederal {

    //private ChromeDriver driver;
    private FirefoxDriver driver;
    private CadastroCadastrante cadastrante;
    private CadastroImovel imovel;
    private CadastroDominio dominio;
    private CadastroDocumentacao documentacao;
    private CadastroGeo geo;
    private CadastroInformacoes informacoes;


    @Before
    public void inicializa(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barba\\Documents\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\barba\\Documents\\Selenium\\chromedriver.exe");
        //this.driver = new ChromeDriver();
        this.driver = new FirefoxDriver();
        this.cadastrante = new CadastroCadastrante(driver);
        this.imovel = new CadastroImovel(driver);
        this.dominio = new CadastroDominio(driver);
        this.documentacao = new CadastroDocumentacao(driver);
        this.geo = new CadastroGeo(driver);
        this.informacoes = new CadastroInformacoes(driver);

    }


    @Test
    public void testeCaroff() throws InterruptedException {


        for (int i=41; i<42; i++) {

//            String cpf = "40566043807";
//            String dataNasc = "01121993";
//            String nome = "Fernanda Costa";
//            String nomeMae = "Pi Costa";

            String cpf = "61138584053";
            String dataNasc = "15011991";
            String nome = "Alysson Pereira";
            String nomeMae = "Pi Pereira";

            String nomeImovel = "Teste " + i;
            String cep = "37200-000";
            String acesso = "Acesso via estrada de terra";
            String endereco = "Rua Antonieta";
            String numero = "1250";
            String bairro = "Centro";
            String email = "fernanda.lemaf@gmail.com";
            String uf = "Rio Grande do Sul";
            String municipio = "Segredo";

            String estadoCivil = "Solteiro(a)";

            //String area = "100";
            String tipoDocumento = "Escritura";
            String arquivoQGIS = new String("C:\\Users\\barba\\Documents\\teste_selenium\\imovel_teste.shp");


            //----------------------REPRESENTANTE----------------------//
            //Representante
            //1 - Não possuo representante
            //2 - Possuo representante, e ele é o cadastrante
            //3 - Possuo representante, mas ele não é o cadastrante
            //---------------------------------------------------------//

            //-----------------------CADASTRANTE-----------------------//
            cadastrante.visita();
            cadastrante.clickAba();
            cadastrante.novoCadastrante().cadastrarCadastrante(cpf, dataNasc, nome, nomeMae, 2);
            //---------------------------------------------------------//

            //--------------------------IMOVEL-------------------------//
            imovel.clickAba();
            imovel.novoImovel().cadastrarImovel(nomeImovel, cep, acesso, endereco, numero, bairro,
                    email, uf, municipio);
            //---------------------------------------------------------//

            //---------------------------GEO---------------------------//
            //String arquivoQGIS = new String("C:" + File.separator + "Users" + File.separator + "barba" + File.separator + "Documents" + File.separator + "TESTES" + File.separator + "Rio Grande do Sul" + File.separator + "teste_selenium.shp");

            geo.clickAba();
            String areaImovel = geo.novoGeo().cadastrarGeo(arquivoQGIS);
            //---------------------------------------------------------//

            //-------------------------DOMINIO-------------------------//
            dominio.clickAba();
            dominio.novoDominio().cadastrarDominio(cpf, estadoCivil);
            //---------------------------------------------------------//

            //----------------------DOCUMENTACAO----------------------//
            documentacao.clickAba();
            documentacao.novaDocumentacao().cadastrarDocumentacao(nomeImovel, areaImovel, tipoDocumento);
            //---------------------------------------------------------//

            //-----------------------INFORMAÇÕES-----------------------//
            informacoes.clickAba();
            informacoes.novoInformacoes().cadastrarInformacoes();
            //---------------------------------------------------------//


            //Não estou conseguindo puxar o valor do campo
            //Assert.assertTrue(cadastrante.existeCadastrante("Alysson Pereira", "Mãe Pereira"));
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @After
    public void finaliza(){
        driver.close();
        //driver.quit();
    }


}
