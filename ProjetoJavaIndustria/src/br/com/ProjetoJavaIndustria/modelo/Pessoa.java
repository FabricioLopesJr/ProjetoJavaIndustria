package br.com.ProjetoJavaIndustria.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa { //Parte 1
	
	String nome;
	LocalDate dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public LocalDate receberData(String data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataF = LocalDate.parse(data, formato);
		return dataF;
	}
	
	public String formatarData(LocalDate dataNascimento) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = this.dataNascimento.format(formato);
		return dataFormatada;
	} 
	
}
		


