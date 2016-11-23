package br.com.caelum.livraria.log;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object executaLog(InvocationContext contexto) throws Exception {
		long inicio = System.currentTimeMillis();

		Object resultado = contexto.proceed();

		long fim = System.currentTimeMillis();

		String className = contexto.getTarget().getClass().getName();
		String methodName = contexto.getMethod().getName();
		System.out.println(
				className.substring(0, className.indexOf("$")) + "." + methodName + " : " + (fim - inicio) + "ms");

		return resultado;
	}

}
