package br.com.eaugusto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ListOfNames {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite os nomes separados por vírgula");
		
		String answer = s.nextLine();
		String[] names = answer.split(",");
		
		s.close();
		
		System.out.println("Todos os nomes (Não Ordenados): ");
		
		int i = 0;
		
		for (i = 0; i < names.length; i++) {
		    names[i] = names[i].trim();
		}
		
		for(i = 0; i < names.length; i++) {
			if (i != 0) {
				System.out.print(", " + names[i]);
			} else {
				System.out.print(names[i]);
			}
		}
		
		System.out.println(" ");
		
		Map<String, Integer> namesMap = new TreeMap<>();
		
		for(i = 0; i < names.length; i++) {
			namesMap.put(names[i], i);
		}
		
		System.out.println("Todos os nomes (Ordenados): ");
		
		String last = ((TreeMap<String, Integer>) namesMap).lastKey();
		
		namesMap.forEach((key, value) -> {
			if (!key.equals(last)) {
				System.out.print(key + ", ");
			} else {
				System.out.print(key);
			}
		});
	}
}
