package com.andersonsouza.testegazin.services.exception;

public class FilmeNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872922218673185518L;

	public FilmeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public FilmeNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public FilmeNaoEncontradoException() {
		super("Filme não pôde ser encontrado");
	}

}
