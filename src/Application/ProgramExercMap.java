package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramExercMap {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("===========MAP - PROBLEMA A SER SOLUCIONADO===============================");
		System.out.println();
		
		System.out.println("Na contagem de votos de uma elei��o, s�o gerados v�rios registros");
		System.out.println("de vota��o contendo o nome do candidato e a quantidade de votos	(formato .csv) que ele"); 
		System.out.println("obteve em uma urna de vota��o. Voc� deve fazer um programa para ler os registros de"); 
		System.out.println("vota��o a partir de um arquivo, e da� gerar um relat�rio consolidado com os totais de"); 
		System.out.println("cada candidato.");
		System.out.println(); 
		
		System.out.println("Colocar no diret�rio o arquivo a ser tratado: ");
		System.out.print("Entre com caminho do arquivo: ");
		String path = sc.nextLine();
		
		//path = "C:\\Temp\\votosurnas.txt";
		
		Map<String, Integer> urna = new LinkedHashMap<>(); 
		Integer contagem;
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		
			String line = br.readLine();
			while (line != null) {
			
				String[] fields = line.split(",");
				String username = fields[0];
				Integer votos =  Integer.parseInt(fields[1]); 								
				
				if (urna.containsKey(username)) { 
					contagem = urna.get(username); 
					contagem += votos;					
				}
				else {
					contagem = votos; 					
				}
				urna.put(username, contagem);					
								
				line = br.readLine();
				
			}	
			
			System.out.println();
			System.out.println("====TOTALIZADORES=======");
			
			for (String key : urna.keySet()) {
				System.out.println(key + ": " + urna.get(key));
			} 
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}

}
