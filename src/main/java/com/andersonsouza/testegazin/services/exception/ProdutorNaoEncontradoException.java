package com.andersonsouza.testegazin.services.exception;

public class ProdutorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872922218673185518L;

	public ProdutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ProdutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public ProdutorNaoEncontradoException() {
		super("Produtor não pôde ser encontrado");
	}

}
