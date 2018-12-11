package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.Uteis;

public class EmpregadoAssalariado extends Empregado implements Comparable<EmpregadoAssalariado> {

	public static final String ARQUIVO = "EMPREGADOASSALARIADO.CSV";

	private double salarioMensal;

	public EmpregadoAssalariado(Integer codigo, String nome, String sobreNome, String cpf, String sexo, double salarioMensal) {
		super(codigo, nome, sobreNome, cpf, sexo);
		this.salarioMensal = salarioMensal;
	}

    public EmpregadoAssalariado() {

    }



	@Override
	public double getGanhos() {
		return getSalarioMensal();
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	@Override
	public String toString() {
		// return "Nome: " + getNome() + " Sobrenome: " + getSobreNome() + "
		// Cpf: " + getCpf() + " Salario: "
		// + getGanhos();
		return toCSV();
	}

	public String toCSV() {
		return getNome() + ";" + getSobreNome() + ";" + getCpf() + ";" + getSexo() + ";" + getSalarioMensal() + "\n";
	}

	@Override
	public void gravar() throws FileNotFoundException, IOException {
		try {
			List<EmpregadoAssalariado> lstE = Uteis.getListaEmpregadosAssalariados(ARQUIVO);
			for (EmpregadoAssalariado empreAssa : lstE) {
				if (empreAssa.equals(getCpf())) {
					System.out.println("Opa, o CPF do empregado jah existe!");
					return;
				}
			}
		} catch (Exception e) {
			System.out.printf("\nOpa, O arquivo %s nao existe!", ARQUIVO);
		}
		File arquivo = new File(ARQUIVO);
		FileOutputStream fos = new FileOutputStream(arquivo, true);
		fos.write(this.toCSV().getBytes());
		fos.close();
		System.out.println("Funcionario salvo!!!");
	}



	@Override
	public int compareTo(EmpregadoAssalariado o) {
		if (this.getSalarioMensal() > o.getSalarioMensal()){
			return 1;
		}else if  (this.getSalarioMensal() < o.getSalarioMensal()){
			return -1;
		}else{
			return 0;
		}
	}

}
