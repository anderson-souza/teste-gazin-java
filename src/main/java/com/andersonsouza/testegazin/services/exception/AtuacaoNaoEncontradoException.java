package com.andersonsouza.testegazin.services.exception;

public class AtuacaoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872922218673185518L;

	public AtuacaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AtuacaoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public AtuacaoNaoEncontradoException() {
		super("Atuacão não pôde ser encontrado");
	}

}
