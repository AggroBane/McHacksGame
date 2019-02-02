package org.levels;
import java.io.*;


public class Levels {
	
		static  String extension = ".txt";
		static String PATH = "src\\org\\levels\\textfiles\\";
		
		public static String createLevelFile(int level) throws IOException {
			String filename = PATH + "level" + level + extension;
			File file = new File(filename);
			
			if(!file.exists()) {
				file.createNewFile();
			}
				
			
			return filename;
		}
		
		public static void appendToFile(String filename, int x, int y, String tileType) throws IOException {
			BufferedWriter output;
			output = new BufferedWriter(new FileWriter(filename, true));
			output.newLine();
			output.append(x + "," + y + "," + tileType);
		
			output.close();
		}
		
		public static void readFile(String filename) throws IOException {
			File file = new File(PATH + filename + extension);
			BufferedReader reader = null;
			
			if(file.exists()) {
				System.out.println("FILE EXIST");
				reader = new BufferedReader(new FileReader(file));
				String line;
				while((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
			
		}
		
		
		
}
