package br.com.ProjetoJavaIndustria.modelo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{ // Parte 2

	String funcao;
	BigDecimal salario;
	
	public Funcionario (String nome, String data, double salario, String funcao) {
		super.nome = nome;
		super.dataNascimento = super.receberData(data);
		this.salario = BigDecimal.valueOf(salario);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public String FormatoSalario(BigDecimal salario) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,###.00", simbolos);
        String numeroFormatado = formato.format(salario);
        return numeroFormatado;
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.nome + " | Data Nascimento: " + super.formatarData(super.dataNascimento) + " | Salário: " + this.FormatoSalario(this.salario) + " | Função: " + this.funcao;
	}
	
	@Override
	public int compareTo(Funcionario outroFuncionario) {
		return this.nome.compareTo(outroFuncionario.nome);
	}
	
}

