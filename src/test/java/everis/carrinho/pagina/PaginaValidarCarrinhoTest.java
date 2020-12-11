package everis.carrinho.pagina;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import everis.carrinho.utilitarios.BaseSelenium;

public class PaginaValidarCarrinhoTest extends BaseSelenium {

	@FindBy(className = "login")
	private WebElement login;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement senha;

	@FindBy(id = "SubmitLogin")
	private WebElement botaoLogin;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement menuDresses;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement botaoPrimeiroProduto;

	@FindBy(name = "Submit")
	private WebElement botaoAdicionarAoCarrinho;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement checkout;

	@FindBy(id = "total_product")
	private WebElement valorCompra;

	@FindBy(id = "total_shipping")
	private WebElement valorEntrega;

	private DecimalFormat format;

	public PaginaValidarCarrinhoTest() {
		PageFactory.initElements(getDriver(), this);
		format = new DecimalFormat("'$'0.##");
		format.setParseBigDecimal(true);
	}

	public void clicarIniciarLogin() {
		login.click();
	}

	public void inserirEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void inserirSenha(String senha) {
		this.senha.clear();
		this.senha.sendKeys(senha);
	}

	public void clicarLogar() {
		botaoLogin.click();
	}

	public void clicarMenuVestido() {
		menuDresses.click();
	}

	public void selecionarOPrimeiroProduto() {
		botaoPrimeiroProduto.click();
	}

	public void adicionarAoCarrinho() {
		botaoAdicionarAoCarrinho.click();
	}

	public void continuarCheckout() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		WebElement resultdo = wait.until(ExpectedConditions.visibilityOf(checkout));
		resultdo.click();
	}

	public BigDecimal obterValorFrete() {
		try {
			return (BigDecimal) format.parse(valorEntrega.getText());
		} catch (ParseException e) {
			throw new RuntimeException("Valor Inválido");
		}
	}

	public BigDecimal obterValorCompra() {
		try {
			return (BigDecimal) format.parse(valorCompra.getText());
		} catch (ParseException e) {
			throw new RuntimeException("Valor Inválido");
		}
	}

}
