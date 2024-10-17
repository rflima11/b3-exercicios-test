package tech.ada.rflima.b3testesexercicios.service;

import tech.ada.rflima.b3testesexercicios.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {

    private List<Produto> produtos = new ArrayList<>();
    private double desconto;

    public void adicionarProdutoAoCarrinho(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutosCarrinho() {
        return produtos;
    }

    public void removerProdutoCarrinho(Produto produto) {
        produtos.remove(produto);
    }

    public Double calcularValorTotal() {
        Double valorTotal = 0d;

        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }

        return valorTotal - (valorTotal * (desconto / 100));
    }

    public void aplicarDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
