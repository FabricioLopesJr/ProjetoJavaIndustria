package br.com.ProjetoJavaIndustria.Teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.ProjetoJavaIndustria.modelo.*;

public class TestePrincipal { // Parte 3

	public static void main(String[] args) {
		
		//parte 3.1

		Funcionario Maria = new Funcionario("Maria", "18/10/2000", 2009.44, "Operador");
		Funcionario Joao = new Funcionario("João", "12/05/1990", 2284.38, "Operador");
		Funcionario Caio = new Funcionario("Caio", "02/05/1961", 9836.14, "Coordenador");
		Funcionario Miguel = new Funcionario("Miguel", "14/10/1988", 19119.88, "Diretor");
		Funcionario Alice = new Funcionario("Alice", "05/01/1995", 2234.68, "Recepcionista");
		Funcionario Heitor = new Funcionario("Heitor", "19/11/1999", 1582.72, "Operador");
		Funcionario Arthur = new Funcionario("Arthur", "31/03/1993", 4071.84, "Contador");
		Funcionario Laura = new Funcionario("Laura", "08/07/1994", 3017.45, "Gerente");
		Funcionario Heloisa = new Funcionario("Heloísa", "24/05/2003", 1606.85, "Eletricista");
		Funcionario Helena = new Funcionario("Helena", "02/09/1996", 2799.93, "Gerente");

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		listaFuncionarios.add(Maria);
		listaFuncionarios.add(Joao);
		listaFuncionarios.add(Caio);
		listaFuncionarios.add(Miguel);
		listaFuncionarios.add(Alice);
		listaFuncionarios.add(Heitor);
		listaFuncionarios.add(Arthur);
		listaFuncionarios.add(Laura);
		listaFuncionarios.add(Heloisa);
		listaFuncionarios.add(Helena);
		
		//Parte 3.2
		
		listaFuncionarios.remove(Joao);
		System.out.println("Funcionário João removido\n");
		
		// Parte 3.3
		
		System.out.println("Imprimindo Todos os funcionários: \n");

		listaFuncionarios.forEach((Funcionario) -> System.out.println(Funcionario));

		// Parte 3.4

		System.out.println("\nImprimindo Todos os funcionários com Reajuste salarial de 10%: \n");

		BigDecimal aumento = new BigDecimal(0.10);

		listaFuncionarios.forEach((Funcionario) -> {

			BigDecimal valorAcrescentar = Funcionario.getSalario().multiply(aumento);
			BigDecimal novoSalario = Funcionario.getSalario().add(valorAcrescentar);
			Funcionario.setSalario(novoSalario);
			System.out.println(Funcionario);

		});

		// Parte 3.5 e Parte 3.6

		System.out.println("\nImprimindo Todos os funcionários agrupados por função: \n");

		Map<String, List<Funcionario>> agrupFuncao = new HashMap<>();

		for (Funcionario funcionario : listaFuncionarios) {
			String funcao = funcionario.getFuncao();
			if (!agrupFuncao.containsKey(funcao)) {
				agrupFuncao.put(funcao, new ArrayList<>());
			}
			agrupFuncao.get(funcao).add(funcionario);
		}

		for (Map.Entry<String, List<Funcionario>> entry : agrupFuncao.entrySet()) {
			String funcao = entry.getKey();
			List<Funcionario> funcionariosPorFuncao = entry.getValue();
			System.out.println("\nFunção: " + funcao);
			System.out.println("\nFuncionários: " + funcionariosPorFuncao);
			System.out.println();
		}

		// Parte 3.8

		listaFuncionarios.forEach((Funcionario) -> {
			int mes = Funcionario.getDataNascimento().getMonthValue();

			if (mes > 9) {
				System.out.println(Funcionario);
			}
		});

		// Parte 3.9

		String nomeMaisVelho = "";

		int maiorIdade = 0; // Assumindo a primeira idade como a maior

		for (Funcionario funcionario : listaFuncionarios) {
			String nomeF = funcionario.getNome();
			int idade = LocalDate.now().getYear() - funcionario.getDataNascimento().getYear();
			if (idade > maiorIdade) {
				maiorIdade = idade;
				nomeMaisVelho = nomeF;
			}
		}

		System.out.println("\nImprimindo o  funcionário mais velho: \n");
		System.out.println("Nome: " + nomeMaisVelho + " Idade: " + maiorIdade);

		// Parte 3.10
		
		System.out.println("\nImprimindo Todos os funcionários em ordem alfabética: \n");
		
		Comparator<Funcionario> comp = (Funcionario a, Funcionario b) -> {
			String nomeA = a.getNome();
			String nomeB = b.getNome();
			return nomeA.compareTo(nomeB);
        };
        
        listaFuncionarios.sort(comp);
        
        listaFuncionarios.forEach( (Funcionario) -> System.out.println(Funcionario));
        
        // Parte 3.11
        
        BigDecimal somaTotal = BigDecimal.ZERO;
        BigDecimal salarioFunc = BigDecimal.ZERO;
        String somaSalario = "";
        
        System.out.println("\nImprimindo soma total do salarios dos funcionários: \n");

        for (Funcionario funcionario : listaFuncionarios) {
        	salarioFunc = funcionario.getSalario();
            somaTotal = somaTotal.add(salarioFunc);
            somaSalario = funcionario.FormatoSalario(somaTotal);
        }
        
        System.out.println("Soma dos Salários: " + somaSalario);
        
        // Parte 3.12
        
        System.out.println("\nImprimindo quantidade de salario mínimo dos Funcionários: \n");
        
        BigDecimal salarioMinimo = new BigDecimal(1212.00);

        for (Funcionario funcionario : listaFuncionarios) {
            BigDecimal salariosMinimos = BigDecimal.ZERO;
            if (salarioMinimo.compareTo(BigDecimal.ZERO) > 0) {
                salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            }
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos");
        }
        
	}
}
