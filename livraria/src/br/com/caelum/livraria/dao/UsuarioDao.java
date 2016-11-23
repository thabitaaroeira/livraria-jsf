package br.com.caelum.livraria.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.tx.Transacional;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@Transacional
	public boolean existe(Usuario usuario) {
		TypedQuery<Usuario> query = em.createQuery(
				" select u from Usuario u " + " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		Usuario resultado = null;
		try {
			resultado = query.getSingleResult();

		} catch (NoResultException ex) {
			return resultado != null;
		}

		return resultado != null;
	}

}
