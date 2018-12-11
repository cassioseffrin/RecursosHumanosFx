package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.Uteis;
import model.EmpregadoAssalariado;

public class Principal {

	public static void clrscr() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

	public static void main(String a[]) {
		clrscr();
		menuPrincipal();

	}

	private static void menuPrincipal() {
		System.out.println("Menu Principal");
		System.out.println("1 Cadastros");
		System.out.println("2 Listagens");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		System.out.println("Digite a OP: ");

		if (op == 1) {
			menuCadastros();
		} else if (op == 2) {
			menuListagens();
		}

	}

	private static void menuListagens() {
		clrscr();
		mostrarOpcoesEmpregados();
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		System.out.println("Digite a OP: ");
		if (op == 1) {
			listarEmpAssalariado();
		} else if (op == 2) {
			listarEmpComissionado();
		}

	}

	private static void listarEmpComissionado() {

	}

	private static void listarEmpAssalariado() {
		clrscr();
		System.out.println("listagem de empregados assalariados:");

		List<EmpregadoAssalariado> lstEmp = new ArrayList<>();
		try {
			lstEmp = Uteis.getListaEmpregadosAssalariados(EmpregadoAssalariado.ARQUIVO);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		System.out.println("Total de Registros: " + lstEmp.size());

		int count = 1;
		for (EmpregadoAssalariado ea : lstEmp) {
			System.out.printf("\nid %s : %s", count, ea);
			count++;
		}

	}

	private static void mostrarOpcoesEmpregados() {
		clrscr();
		System.out.println("Menu de cadastros");
		System.out.println("1. Empregado Assalariado");
		System.out.println("2. Empregado Comissionado");
		System.out.println("3. Empregado Base Comissionado");
		System.out.println("4. Voltar ao menu principal");

	}

	private static void menuCadastros() {
		mostrarOpcoesEmpregados();
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		System.out.println("Digite a OP: ");
		if (op == 1) {
			cadastrarEmpAssalariado();
		} else if (op == 2) {
			cadastrarEmpComissionado();
		}

	}

	private static void cadastrarEmpComissionado() {

	}

	private static void cadastrarEmpAssalariado() {
		clrscr();
		System.out.println("Cadastrando empregado assalariado:");
		System.out.println("Digite o nome:");
		Scanner scan = new Scanner(System.in);
		String nome = scan.nextLine();
		EmpregadoAssalariado empAssalariado = new EmpregadoAssalariado(1, nome, "Matei", "24985729", "Masculino",
				2400.00);

		try {
		 List<EmpregadoAssalariado> lst = Uteis.getListaEmpregadosAssalariados(empAssalariado.ARQUIVO );
			 Uteis.gravar(empAssalariado, lst, empAssalariado.ARQUIVO);
			

			menuPrincipal();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
