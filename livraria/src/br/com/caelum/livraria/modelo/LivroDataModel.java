package br.com.caelum.livraria.modelo;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDao;

public class LivroDataModel extends LazyDataModel<Livro> {

	private static final long serialVersionUID = 1L;

	private LivroDao dao;

	public LivroDataModel(LivroDao livroDao) {
		this.dao = livroDao;
		super.setRowCount(dao.quantidadeDeElementos());
	}

	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao,
			Map<String, Object> filtros) {
		String coluna = "titulo";
		String valor = (String) filtros.get(coluna);
		return dao.listaTodosPaginada(inicio, quantidade, coluna, valor);
	}

}
