package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class TowerController extends Entity{
	
	public boolean isPressed = false;
	public int xTarget,yTarget;

	public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick(){
		if(isPressed){
			isPressed = false;
			boolean liberado = true;
			//Vamos criar uma torre no mapa!
			int xx = (xTarget/16) * 16;
			int yy = (yTarget/16) * 16;
			Player player = new Player(xx,yy,16,16,0,Game.spritesheet.getSprite(16,16,16,16));
			for(int i = 0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if(e instanceof Player) {
					if(Entity.isColidding(e, player)) {
						liberado = false;
						System.out.println("Existe uma torre ai amigo!");
					}
				}
			}
			
			 if(World.isFree(xx, yy)) {
				 liberado = false;
				 System.out.println("Local ocupada pelo mapa! Cuidado!");
			 }
			
			if(liberado) {
				if(Game.dinheiro >= 2) {
				Game.entities.add(player);
				Game.dinheiro-=2;
				}else {
					System.out.println("Sem dinheiro para construir torre!");
				}
			}
			
		}
		if(Game.vida <= 0)
		{
			//Game Over!
			System.exit(1);
		}
	}

}
