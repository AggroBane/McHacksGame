package org.levels;
import java.io.*;
import java.nio.file.Files;

public class Levels {
		static String extension = ".txt";
		static String PATH = "src\\org\\levels\\textfiles\\level";
		public static void createLevel(int level) throws IOException {
			String filename = PATH + level + extension;
			File file = new File(filename);
			if(file.exists()) {
				return;
			}else {
				System.out.println(file.createNewFile());
				
			}
			
			Writer fileWriter = new FileWriter("filename");
			fileWriter.write("asdasd");
			fileWriter.close();
			
		}
		
		public static void main(String[]args) throws IOException {
			createLevel(1);
		}
}
