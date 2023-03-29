package com.example.demo.UnitTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.example.demo.model.User;
import com.example.demo.model.Course;
import com.example.demo.model.Plan;
import com.example.demo.model.School;
import com.example.demo.model.UserType;

public class UsuarioAssinaturaTeste {

	@Test
	public void deveLiberarAcessoAoUsuario() {
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", UserType.ASSINANTE, 23.90);	
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		
		// Execução
		escolaOnline.adicionarPlano(planoBasico);
		joao.adicionarSaldo(30);
		joao.assinarPlano(planoBasico);
		
		// Resultados
		assertEquals(UserType.ASSINANTE,joao.getTipo());
	}
	
	@Test
	public void deveExibirCursosDaCategoriaDeAssinatura() {
		School escolaOnline = new School("Escola de Programação do Deaque");
		
		Plan planoBasico = new Plan("Plano básico de programação", UserType.ASSINANTE, 23.90);
		Plan planoPremium = new Plan("Plano premium de programação", UserType.ASSINANTE_PREMIUM, 54.90);
		
		Course cursoPython = new Course("Python: do básico ao avançado", "Curso de python...");
		Course cursoJavascript = new Course("Javascript: do básico ao avançado", "Curso de javascript...");
		Course cursoNodeJS = new Course("NodeJS avançado com Streams e Promises", "Curso de NodeJS...");
		
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		
		planoBasico.adicionarCurso(cursoPython);
		planoBasico.adicionarCurso(cursoJavascript);
		planoPremium.adicionarCurso(cursoNodeJS);
				
		escolaOnline.adicionarPlano(planoBasico);
		joao.adicionarSaldo(30.0);
		joao.assinarPlano(planoBasico);
		
		String[] nomeCursosJoao = {cursoPython.getNome(),cursoJavascript.getNome()};
		
		assertArrayEquals(nomeCursosJoao, joao.getCatalogoCursos());		
	}
	
}
