package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Empregado {
	
	
	private Integer codigo;
	private String nome;
	private String sobreNome;
	private String cpf;
	public String sexo;

	public Empregado() {
	}
 
	

	public Empregado(Integer codigo, String nome, String sobreNome, String cpf, String sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.sexo = sexo;
	}
	
	@Override
	public boolean equals (Object obj){
		if (getCpf().equals(((Empregado) obj).getCpf() )){
			return true;
		}else{
			return false;
		}
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
        
        

	@Override
	public String toString() {
		return "Nome: " + getNome() + " Sobrenome: " + getSobreNome() + " Cpf: " + getCpf();
	}
	
	public abstract double getGanhos();
	
	
	public abstract void gravar() throws FileNotFoundException,IOException;
	
	public abstract String toCSV() ;
	

	

}