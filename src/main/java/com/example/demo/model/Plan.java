package com.example.demo.model;

public class Plan {
	private String nome;
	private Course[] cursos = new Course[0];
	private UserType nivel_acesso;
	private double preco;
	
	public Plan(String nome, UserType nivel_acesso, double preco) {
        this.nome = nome;
        this.nivel_acesso = nivel_acesso;
        this.preco = preco;
    }
	
	public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Course[] getCursos() {
        return cursos;
    }
    
    public void setCursos(Course[] cursos) {
        this.cursos = cursos;
    }
    
    public Double getValor() {
    	return this.preco;
    }
    
    public void adicionarCurso(Course curso) {
        // verifica se a lista de cursos já foi inicializada
        if (cursos == null) {
            cursos = new Course[1];
            cursos[0] = curso;
        } else {
            // cria um array temporário com o tamanho atual + 1
            Course[] novoArray = new Course[cursos.length + 1];
            
            // copia os cursos existentes para o novo array
            for (int i = 0; i < cursos.length; i++) {
                novoArray[i] = cursos[i];
            }
            
            // adiciona o novo curso ao final do novo array
            novoArray[novoArray.length - 1] = curso;
            
            // substitui a lista antiga pela nova
            cursos = novoArray;
        }
        }
    
    public void removerCurso(Course curso) {
		if (cursos != null) {
			Course[] novoArray = new Course[cursos.length - 1];
			
			int j = 0;
			for (int i = 0; i < cursos.length; i++) {
			    if (!cursos[i].equals(curso)) {
			        novoArray[j] = cursos[i];
			        j++;
			    }
			}
			
			cursos = novoArray;
		}
    }
}
