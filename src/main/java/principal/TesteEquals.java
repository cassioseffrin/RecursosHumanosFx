package principal;

import model.EmpregadoAssalariado;

public class TesteEquals {
	
	
	public static void main(String a[]){
		EmpregadoAssalariado e1 = new EmpregadoAssalariado(1, "Jose", "Matei", "123", "Masculino",
				2400.00);
		EmpregadoAssalariado e2 = new EmpregadoAssalariado(2, "Fernada", "Souza", "1223", "Feminino",
				2400.00);
		
		System.out.println("e1 eh igual a e2 : " + e1.equals(e2)  );
	}

}
