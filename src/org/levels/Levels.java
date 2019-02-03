package org.levels;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import org.GameContainer;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.SolidObject;
import org.world.gameobjects.tiles.Tile;



public class Levels {
	
		static  String extension = ".txt";
		static String PATH = "src\\org\\levels\\textfiles\\";
		
		
		public static String createLevelFile(int level) throws IOException 
		{
			String filename = PATH + "level" + level + extension;
			File file = new File(filename);
			
			if(!file.exists()) 
			{
				file.createNewFile();
			}
				
			
			return filename;
		}
		
		public static void appendToFile(String filename, int x, int y, String tileType) throws IOException 
		{
			BufferedWriter output;
			output = new BufferedWriter(new FileWriter(filename, true));
			output.newLine();
			output.append(x + "," + y + "," + tileType);
		
			output.close();
		}
		
		public static ArrayList<GameObject> createObjectFromFile(String filename) throws IOException 
		{
			File file = new File(PATH + filename + extension);
			BufferedReader reader = null;
			ArrayList<GameObject> objList = new ArrayList<GameObject>();
			
			if(file.exists()) 
			{
				Random random = new Random();
				
				int lineCount = 0;
				reader = new BufferedReader(new FileReader(file));
				String line;
				while((line = reader.readLine()) != null) 
				{
	
					String[] values = line.split(",");

					//ADD EVERY BLOCK HERE
					if(values[2].equals("grass"))
					{
						objList.add(new SolidObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, GameContainer.tileSize, GameContainer.tileSize, Tile.grass1));
					}
					else if(values[2].equals("tree"))
					{
						switch (random.nextInt(3)) {
							case 0:
								objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.TREE_WIDTH, Tile.TREE_HEIGHT, Tile.tree0));
								break;
							case 1:
								objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.TREE_WIDTH, Tile.TREE_HEIGHT, Tile.tree1));
								break;
							case 2:
								objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.TREE_WIDTH, Tile.TREE_HEIGHT, Tile.tree2));
								break;
						}}
					
					else if(values[2].equals("flower"))
					{
						switch (random.nextInt(6)) {
						case 0:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower0));
							break;
						case 1:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower1));
							break;
						case 2:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower2));
							break;
						case 3:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower3));
							break;
						case 4:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower4));
							break;
						case 5:
							objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.flower5));
							break;
						}

				}
			
			
		}
				
		}
			return objList;
		}
}
