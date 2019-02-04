package org.world.gameobjects.tiles;

import java.util.ArrayList;

import org.GameContainer;
import org.resources.ImageResource;
import org.world.gameobjects.GameObject;
import org.world.gameobjects.SolidObject;

public class Tile 
{


	public static final ImageResource bomb = new ImageResource("entities/bomb/bomb0.png");
	public static final ImageResource error = new ImageResource("res/noTexture.png");
	
	public static ArrayList<ImageResource> grassImages = new ArrayList<>();
	public static ArrayList<ImageResource> dirtImages = new ArrayList<>();
	public static ArrayList<ImageResource> treeImages = new ArrayList<>();
	public static ArrayList<ImageResource> flowerImages = new ArrayList<>();
	public static ArrayList<ImageResource> bushImages = new ArrayList<>();
	
	
	public static final int TREE_HEIGHT = 128;
	public static final int TREE_WIDTH = 64;
	public static final int FLOWER_DIMENSION = 64; 
	public static final int GRASS_DIMENSION = 64;
	public static final int DIRT_DIMENSION = 64;
	public static final int BUSH_DIMENSION = 64;
	//objList.add(new GameObject(Integer.parseInt(values[0]) * GameContainer.tileSize, Integer.parseInt(values[1]) * GameContainer.tileSize,
	//Tile.TREE_WIDTH, Tile.TREE_HEIGHT, Tile.tree0));
	public static void loadGrass() {
		grassImages.add(new ImageResource("world/tiles/grass1.png"));
		grassImages.add(new ImageResource("world/tiles/grass2.png"));
		grassImages.add(new ImageResource("world/tiles/grass3.png"));
		grassImages.add(new ImageResource("world/tiles/grass4.png"));
	}
	
	public static void loadDirt() {
		dirtImages.add(new ImageResource("world/tiles/dirt0.png"));
		dirtImages.add(new ImageResource("world/tiles/dirt1.png"));
		dirtImages.add(new ImageResource("world/tiles/dirt2.png"));
		dirtImages.add(new ImageResource("world/tiles/dirt3.png"));
		dirtImages.add(new ImageResource("world/tiles/dirt4.png"));
	}
	
	public static void loadTree() {
		treeImages.add(new ImageResource("world/assets/tree.png"));
		treeImages.add(new ImageResource("world/assets/tree2.png"));
		treeImages.add(new ImageResource("world/assets/tree3.png"));
	}
	public static void loadBush() {
		bushImages.add(new ImageResource("world/assets/bush.png"));
		bushImages.add(new ImageResource("world/assets/bush2.png"));
	}
	
	public static void loadFlower() {
		flowerImages.add(new ImageResource("world/assets/flower1.png"));
		flowerImages.add(new ImageResource("world/assets/flower2.png"));
		flowerImages.add(new ImageResource("world/assets/flower3.png"));
		flowerImages.add(new ImageResource("world/assets/flower4.png"));
		flowerImages.add(new ImageResource("world/assets/flower5.png"));
		flowerImages.add(new ImageResource("world/assets/flower6.png"));
	}
	
	public static void loadAssets() {
		loadGrass();
		loadDirt();
		loadTree();
		loadBush();
		loadFlower();
	}
	
	public static GameObject createGrass(int x, int y, int index, boolean isSolidObject) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, GRASS_DIMENSION, GRASS_DIMENSION, grassImages.get(index));
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, GRASS_DIMENSION, GRASS_DIMENSION, grassImages.get(index));
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, GRASS_DIMENSION, GRASS_DIMENSION, error);
		}
	}
	
	public static GameObject createDirt(int x, int y, int index, boolean isSolidObject) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, DIRT_DIMENSION, DIRT_DIMENSION, dirtImages.get(index));
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, DIRT_DIMENSION, DIRT_DIMENSION, dirtImages.get(index));
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, DIRT_DIMENSION, DIRT_DIMENSION, error);
		}
	}
	public static GameObject createTree(int x, int y, int index, boolean isSolidObject) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, TREE_WIDTH, TREE_HEIGHT, treeImages.get(index));
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, TREE_WIDTH, TREE_HEIGHT, treeImages.get(index));
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, TREE_WIDTH, TREE_HEIGHT, error);
		}
	}
	public static GameObject createBush(int x, int y, int index, boolean isSolidObject) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, BUSH_DIMENSION, BUSH_DIMENSION, bushImages.get(index));
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, BUSH_DIMENSION, BUSH_DIMENSION, bushImages.get(index));
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, BUSH_DIMENSION, BUSH_DIMENSION, error);
		}
	}
	
	public static GameObject createFlower(int x, int y, int index, boolean isSolidObject) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, FLOWER_DIMENSION, FLOWER_DIMENSION, flowerImages.get(index));
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, FLOWER_DIMENSION, FLOWER_DIMENSION, flowerImages.get(index));
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, FLOWER_DIMENSION, FLOWER_DIMENSION, error);
		}
	}
	/**
		For creating your own object
	 */
	public static GameObject createObject(int x, int y, int width, int height, boolean isSolidObject, ImageResource image) {
		try {
			if(isSolidObject) {
				return new SolidObject(x * GameContainer.tileSize,y * GameContainer.tileSize, width, height, image);
			}else {
				return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, width, height, image);
			}
		}catch(Exception e) {
			return new GameObject(x * GameContainer.tileSize,y * GameContainer.tileSize, width, height, error);
		}
	}
	
	
}
