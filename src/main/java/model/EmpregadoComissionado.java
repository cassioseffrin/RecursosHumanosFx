package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EmpregadoComissionado extends Empregado {

	public static final String ARQUIVO = "EMPREGADOCOMISSIONADO.CSV";

    private double vendasBrutas;
    private double porcentagemComissao;
    
  
	public EmpregadoComissionado(Integer codigo, String nome, String sobreNome, String cpf, String sexo, double vendasBrutas, double porcentagemComissao) {
		super( codigo, nome, sobreNome, cpf, sexo);
		this.vendasBrutas = vendasBrutas;
		this.porcentagemComissao = porcentagemComissao;
	}
	
	
	@Override
	public double getGanhos() {
		return getVendasBrutas() * getPorcentagemComissao() / 100;
	}

	public double getVendasBrutas() {
		return vendasBrutas;
	}

	public void setVendasBrutas(double vendasBrutas) {
		this.vendasBrutas = vendasBrutas;
	}

	public double getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao(double porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}
	
	
@Override
public String toString() {
	return "Nome: " + getNome() + " Sobrenome: " + getSobreNome() + " Cpf: " + getCpf() + "Ganhos: " + getGanhos();
}


@Override
public void gravar() throws FileNotFoundException, IOException {
 
	
}


@Override
public String toCSV() {
	// TODO Auto-generated method stub
	return null;
}
	

}
