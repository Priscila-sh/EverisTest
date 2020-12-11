package everis.carrinho;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import everis.carrinho.pagina.PaginaValidarCarrinhoTest;
import everis.carrinho.utilitarios.BaseSelenium;

public class ValidarCarrinhoTest extends BaseSelenium {

	PaginaValidarCarrinhoTest validar = new PaginaValidarCarrinhoTest();
	private String email = "email@email.email";
	private String senha = "tester123";

	@Test
	public void comprarProduto() {
		validar.clicarIniciarLogin();
		validar.inserirEmail(email);
		validar.inserirSenha(senha);
		validar.clicarLogar();
		validar.clicarMenuVestido();
		validar.selecionarOPrimeiroProduto();
		validar.adicionarAoCarrinho();
		validar.continuarCheckout();
		BigDecimal totalProdutos = validar.obterValorCompra().add(validar.obterValorFrete());
		assertEquals(BigDecimal.valueOf(28), totalProdutos);
	}

}
