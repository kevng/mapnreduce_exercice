package project_pivot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class mapReduce_pivot {

	// Création d'un fichier CSV avec des données test
	static String csvFile = "C:/Users/KEVINGermain/Downloads/Hadoop/test_Pivot.csv";
	static String ligne = "";
	static String separateurCsv = ";";
	static String [] test;
	// Création du HashMap avec le concept des keys/values
	static HashMap<Integer, String> newmap = new HashMap<Integer, String>();
	static String[] testMap = new String[9];
	static String[] finalTab = new String[9];
	static int o=0;
	
	public static void main (String[] args) {
		int i = 0;
		try (BufferedReader br = new BufferedReader (new FileReader(csvFile))){
			@SuppressWarnings("unchecked")
			ArrayList <String[]> tabMap = new ArrayList<>();
			while ((ligne = br.readLine()) != null) {
				HashMap<Integer, String>  toReduce = new HashMap<Integer, String>();
				finalTab = map(i,ligne.toString());
				i++;
			}
			for (String values: finalTab){
				// Retranscription des valeurs dans le CSV
				System.out.println(values);
			}
			System.out.print(finalTab[0]);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	// Fonction Map
	static String[] map (int key, String values){
		String [] tableauMap = ligne.split(separateurCsv);
		finalTab = reduce(o, tableauMap);
		
		return finalTab;
		
	}
	
	// Fonction Reduce
	static String[] reduce (int o, String [] tableauMap) {
		for (String maps : tableauMap) {
			if (testMap[o] != null) {
				testMap[o] =  testMap[o] + ';' + maps;
			}else {
				testMap[o] =  maps;
			}
			o++;
		}o=0;
		return testMap;
	}
}