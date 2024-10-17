package tech.ada.rflima.b3testesexercicios.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.ada.rflima.b3testesexercicios.entity.Produto;

public class CarrinhoServiceTest {

    //TDD - Test Driven Development
    // RED -> GREEN -> REFACTOR

    @Test
    void deveConseguirAdicionarProdutosNoCarrinho() {
        CarrinhoService service = new CarrinhoService();
        Produto produto = new Produto("Celular", 1000d);

        service.adicionarProdutoAoCarrinho(produto);

        Assertions.assertEquals(1, service.listarProdutosCarrinho().size());
        Assertions.assertEquals("Celular", service.listarProdutosCarrinho().get(0).getNome());
    }

    @Test
    void deveConseguirRemoverProdutosNoCarrinho() {
        CarrinhoService service = new CarrinhoService();
        Produto produto = new Produto("Livro", 50d);
        service.adicionarProdutoAoCarrinho(produto);



        service.removerProdutoCarrinho(produto);

        Assertions.assertEquals(0, service.listarProdutosCarrinho().size());
    }

    @Test
    void deveConseguirCalcularOValorTotalDoCarrinho() {
        CarrinhoService carrinhoService = new CarrinhoService();
        Produto produto1 = new Produto("Celular", 500d);
        Produto produto2 = new Produto("Airfryer", 500d);
        carrinhoService.adicionarProdutoAoCarrinho(produto1);
        carrinhoService.adicionarProdutoAoCarrinho(produto2);

        Double valorTotal = carrinhoService.calcularValorTotal();

        Assertions.assertEquals(1000d, valorTotal);
    }

    @Test
    void deveAtualizarValorTotalAposODesconto() {
        CarrinhoService service = new CarrinhoService();
        Produto produto = new Produto("PC GAMER", 10000d);
        service.adicionarProdutoAoCarrinho(produto);

        service.aplicarDesconto(10d);

        Assertions.assertEquals(9000, service.calcularValorTotal());
    }

}
