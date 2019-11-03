package com.andersonsouza.testegazin.services.exception;

public class DiretorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872922218673185518L;

	public DiretorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public DiretorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public DiretorNaoEncontradoException() {
		super("Diretor não pôde ser encontrado");
	}

}
