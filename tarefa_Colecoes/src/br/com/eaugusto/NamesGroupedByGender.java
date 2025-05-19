package br.com.eaugusto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NamesGroupedByGender {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Digite o nomes e gêneros separados por hífen (-) e vírgula (,).");
		System.out.println("Ex: Maria-F, John-M");
		
		String answer = s.nextLine();
		String[] everyone = answer.split(",");

		s.close();
		
		int i = 0;
		
		for (i = 0; i < everyone.length; i++) {
		    everyone[i] = everyone[i].trim();
		}
		
		Map<String, String> nameSeparatedFromGender = new TreeMap<>();
		
		for(String entry : everyone) {
			String[] nameAndGender = entry.split("-");
			if (nameAndGender.length == 2) {
				String name = nameAndGender[0].trim();
				String gender = nameAndGender[1].trim();
				nameSeparatedFromGender.put(name, gender);
			}
		}
		
		Map<String, String> females = new TreeMap<>();
		Map<String, String> males = new TreeMap<>();
		Map<String, String> otherGenders = new TreeMap<>();
		
		nameSeparatedFromGender.forEach((key, value) -> {
			if (value.equalsIgnoreCase("F")) {
				females.put(key, value);
			} else if (value.equalsIgnoreCase("M")) {
				males.put(key, value);
			} else {
				otherGenders.put(key, value);
			}
		});
		
		System.out.println(" ");
		
		System.out.println("Mulheres: ");
		int index = 0;
		for(String name : females.keySet()) {
			if (index != 0) {
				System.out.print(", ");
			}
			System.out.print(name);
			index++;
		}
		
		System.out.println(" ");
		
		System.out.println("Homens: ");
		index = 0;
		for(String name : males.keySet()) {
			if (index != 0) {
				System.out.print(", ");
			}
			System.out.print(name);
			index++;
		}

		System.out.println(" ");
		
		System.out.println("Outros Gêneros: ");
		
		String last = ((TreeMap<String, String>) otherGenders).lastKey();
		
		otherGenders.forEach((key, value) -> {
			if (!key.equals(last)) {
				System.out.print(key + " - " + value + ", ");
			} else {
				System.out.print(key + " - " + value);
			}
		});
	}
}
