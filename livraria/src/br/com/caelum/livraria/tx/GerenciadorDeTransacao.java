package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object executaTx(InvocationContext contexto) throws Exception {
		// abre transacao
		System.out.println("abrindo tx");
		manager.getTransaction().begin();

		// chama os daos
		Object resultado = contexto.proceed();

		// commita a transacao
		manager.getTransaction().commit();
		System.out.println("fechando tx");

		return resultado;
	}

}
