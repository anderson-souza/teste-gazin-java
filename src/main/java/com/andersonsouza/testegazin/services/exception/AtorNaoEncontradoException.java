package com.andersonsouza.testegazin.services.exception;

public class AtorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872922218673185518L;

	public AtorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AtorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public AtorNaoEncontradoException() {
		super("Produtor não pôde ser encontrado");
	}

}
