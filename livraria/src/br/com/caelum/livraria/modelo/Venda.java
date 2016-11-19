package br.com.caelum.livraria.modelo;

public class Venda {

	private Livro livro;
	private Integer quantidade;

	public Livro getLivro() {
		return livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Venda() {
	}

	public Venda(Livro livro, Integer quantidade) {
		this.livro = livro;
		this.quantidade = quantidade;
	}

}
