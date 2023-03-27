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

	//BDD - Raul
	@Test
	public void deveNaoRealizarAssinaturaCasoSaldoInsuficiente(){
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", UserType.ASSINANTE, 200);	
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		UserType atualTipoUsuario = joao.getTipo();

		// Execução
		escolaOnline.adicionaPlano(planoBasico);
		joao.adicionarSaldo(30);
		
		String mensagemRetorno = joao.assinaPlano(planoBasico);
		
		// Resultados
		assertEquals(atualTipoUsuario, joao.getTipo());
		assertEquals("Usuário não tem saldo suficiente para assinatura do plano.", mensagemRetorno);
		assertEquals(30, joao.getSaldo());
	}
	
	//BDD - Ferraz

	@Test
	public void deveBloquearCasoSejaTentativaDuplicada() {

		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", UserType.ASSINANTE, 23.90);	
		User ze = new User("Zezin", "ze@ze.com", "senha123");
		joao.adicionarSaldo(50);
		double saldoAtualUsuario = joao.getSaldo();
		String mensagemRetorno = "";
		
		// Execução
		escolaOnline.adicionaPlano(planoBasico);
		mensagemRetorno = joao.assinaPlano(planoBasico);
		
		escolaOnline.adicionaPlano(planoBasico);
		mensagemRetorno = joao.assinaPlano(planoBasico);

		// Resultados
		assertEquals("Usuário já pagou o boleto desde mês, favor aguardar a proxima parcela.", mensagemRetorno);
		assertEquals(saldoAtualUsuario - planoBasico.Valor, joao.getSaldo());
	}
}
