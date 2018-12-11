package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Empregado;
import model.EmpregadoAssalariado;
import model.EmpregadoComissionado;

public class Uteis {

	private static Scanner scan;

	public static <T, E> void gravar(T empregado, List<E> lstE, String nomeArquivo) 
			throws IOException {
		try {
			for (E emp : lstE) {
				if (emp.equals(((Empregado) empregado).getCpf())) {
					System.out.println("Opa, o CPF do empregado jah existe!");
					return;
				}
			}
		} catch (Exception e) {
			System.out.printf("\nOpa, O arquivo %s nao existe!", nomeArquivo);
		}

		File arquivo = new File(nomeArquivo);
		FileOutputStream fos = new FileOutputStream(arquivo, true);
		fos.write(empregado.toString().getBytes());
		fos.close();
		System.out.println("Funcionario salvo!!!");
	}

	public static List<EmpregadoAssalariado> getListaEmpregadosAssalariados(String ARQUIVO)
			throws FileNotFoundException {
		File arquivo = new File(ARQUIVO);
		FileInputStream fis = new FileInputStream(arquivo);
		scan = new Scanner(fis);
		String linha = "";
		List<EmpregadoAssalariado> lstEmp = new ArrayList<>();
		while (scan.hasNext()) {
			linha = scan.nextLine();
			String arr[] = linha.split(";");
                        
			EmpregadoAssalariado e = new EmpregadoAssalariado(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4],
					Double.parseDouble(arr[5]));
                        
			lstEmp.add(e);
		}
		return lstEmp;
	}

	public static List<EmpregadoComissionado> getListaEmpregadosComissionados(String ARQUIVO)
			throws FileNotFoundException {
		File arquivo = new File(ARQUIVO);
		FileInputStream fis = new FileInputStream(arquivo);
		scan = new Scanner(fis);
		String linha = "";
		List<EmpregadoComissionado> lstEmp = new ArrayList<>();
		while (scan.hasNext()) {
			linha = scan.nextLine();
			String arr[] = linha.split(";");
			EmpregadoComissionado e = new EmpregadoComissionado(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4],
					Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
			lstEmp.add(e);
		}
		return lstEmp;
	}

	 

}
