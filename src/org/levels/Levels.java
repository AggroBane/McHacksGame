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
		Tile.loadAssets();
		int numGrass = Tile.grassImages.size();
		int numTree = Tile.treeImages.size();
		int numFlower = Tile.flowerImages.size();
		int numDirt = Tile.dirtImages.size();
		File file = new File(PATH + filename + extension);
		BufferedReader reader = null;
		ArrayList<GameObject> objList = new ArrayList<GameObject>();

		if(file.exists()) 
		{
			Random random = new Random();

			reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) 
			{

				String[] values = line.split(",");
				
				int errorNum = 999;
				switch(values[2]) {
				case "grass":
					objList.add(Tile.createGrass(Integer.parseInt(values[0]), Integer.parseInt(values[1]), random.nextInt(numGrass), true));
					break;
				case "tree":
					objList.add(Tile.createTree(Integer.parseInt(values[0]), Integer.parseInt(values[1]), random.nextInt(numTree), false));
					break;
				case "flower":
					objList.add(Tile.createFlower(Integer.parseInt(values[0]), Integer.parseInt(values[1]), random.nextInt(numFlower), false));
					break;
				case "dirt":
					objList.add(Tile.createDirt(Integer.parseInt(values[0]), Integer.parseInt(values[1]), random.nextInt(numDirt), true));
					break;
				case "bomb":
					objList.add(new SolidObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize, Tile.FLOWER_DIMENSION, Tile.FLOWER_DIMENSION, Tile.bomb));
					break;
				default:
					objList.add(Tile.createDirt(Integer.parseInt(values[0]), Integer.parseInt(values[1]), errorNum, false));
				}
			}


		}
		return objList;
	}
}
