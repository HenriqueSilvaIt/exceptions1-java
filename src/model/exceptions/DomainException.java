package model.exceptions;

public class DomainException extends RuntimeException {
	
	// Id de versão da classe Exceptiom que é serializable
	private static final long serialVersionUID = 1L;
	
	// Construtrores
	
	public DomainException(String msg) {
		super(msg); // repassando a mensagem dessa classe para puxar para classe principal
	}
	
}
