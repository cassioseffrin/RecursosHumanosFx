package colecoes;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExemploColecao {

	private static void procuraElemento(String chave, List<String> lst) {
		int resultado = 0;
		Collections.sort(lst);
		System.out.printf("\nProcurando por: %s\n", chave);
		resultado = Collections.binarySearch(lst, chave);
		if (resultado >= 0)
			System.out.printf("Elemento (%s) encontrado %d vezes\n", chave, resultado);
		else
			System.out.printf("Elemento (%s) Nao Encontrado \n", chave);
	}

	private static <T, E> void procuraElementoInt(Integer chave, List<Integer> lst) {
		int resultado = 0;
		Collections.sort(lst);
		System.out.printf("\nProcurando por: %s\n", chave);
		resultado = Collections.binarySearch(lst, chave);
		if (resultado >= 0)
			System.out.printf("Elemento (%s) encontrado \n", chave, resultado);
		else
			System.out.printf("Elemento (%s) Nao foi encontrado \n", chave);
	}

	public static <E> void embaralharImprimir(List<E> lst) {
		Collections.shuffle(lst);
		int count = 1;
		for (E elem : lst) {
			System.out.printf("\nTipo<%s> %s: %s", elem.getClass().getSimpleName(), count, elem);
			count++;
		}
	}

	public static void exemploFila() {
		List<String> nomes = new ArrayList<>();
		nomes.add("Joao");
		nomes.add("Maria");
		nomes.add("Jose");
		nomes.add("Alceu");
		nomes.add("Victor");
		Collections.shuffle(nomes);
		Queue<String> fila = new LinkedList<>();
		for (String nome : nomes) {
			fila.add(nome);
		}
		while (!fila.isEmpty()) {
			System.out.println("elem: " + fila.poll());
		}

	}

	public static void main(String a[]) throws FileNotFoundException {

		Integer inteirosArray[] = { 34, 22, 1, 1, 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> lstInteiros = Arrays.asList(inteirosArray);
		embaralharImprimir(lstInteiros);
		procuraElementoInt(4, lstInteiros);

		String array[] = { "Joao", "Maria", "Jose", "Joao", "Gabriela", "Jonatas" };
		List<String> lstNomes = Arrays.asList(array);
		embaralharImprimir(lstNomes);
		procuraElemento("Joao", lstNomes);

		exemploFila();

	}
}
