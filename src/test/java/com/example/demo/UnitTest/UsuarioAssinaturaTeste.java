package com.example.demo.UnitTest;

import static org.junit.Assert.assertEquals;

import com.example.demo.model.User;
import com.example.demo.model.UserType;

public class UsuarioAssinaturaTeste {

	@Test
	public void deveLiberarAcessoAoUsuario() {
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", UserType.ASSINANTE, 23.90);	
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		
		// Execução
		escolaOnline.adicionaPlano(planoBasico);
		joao.adicionarSaldo(30);
		joao.assinaPlano(planoBasico);
		
		// Resultados
		assertEquals(UserType.ASSINANTE,joao.getTipo());
	}
	
}
