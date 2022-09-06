package com.gcstudios.entities;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.AStar;
import com.gcstudios.world.Vector2i;
import com.gcstudios.world.World;




public class Enemy extends Entity{
	
	public boolean right = true,left = false;
	
	public int vida = 50;
	
	public int right_dir = 1, left_dir= -1;
	
	public int dir = 1;	
	
	private int framesAnimation = 0;
	private int maxFrame        = 15;
	private int maxSprites      = 2;
	private int curSprites      = 0;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		path = AStar.findPath(Game.world,new Vector2i(World.xInitial,World.yInitial),new Vector2i(World.xFinal,World.yFinal));
	}
	
	public void tick() {
		
		followPath(path);
		if(x >= Game.WIDTH) {
			//Perdemos vida aqui!
			Game.vida-= Entity.rand.nextDouble();                       
			Game.entities.remove(this);
			return;
		}
		
	
		if(vida <= 0)
		{
			Game.entities.remove(this);
			Game.dinheiro++;
			return;
		}
	}
	

	public void render(Graphics g) {
		framesAnimation++;
		if(framesAnimation == maxFrame) {
			curSprites++;
			framesAnimation = 0;
				if(curSprites == maxSprites) {
					curSprites = 0;
				}
		}
			if(dir == right_dir) {
				
				sprite = Entity.ENEMY1_Right[curSprites];
				
			}else if(dir == left_dir) {
			
				sprite = Entity.ENEMY1_Left[curSprites];
			}
		super.render(g);	
		

		g.setColor(Color.red);
		g.fillRect((int)x,(int) (y-4),20,6);
		
		g.setColor(Color.green);
		g.fillRect((int)x,(int) (y-4),(int)((vida/30) *20),6);
	}

}















	
	
	    /*	if(World.isFree((int)(x+speed),(int)y)) {
			x+=speed;
		}else if(World.isFree((int)x,(int)(y+speed))) {
			y+=speed;
		}else if(World.isFree((int)x,(int)(y-speed))) {
			y-=speed;
			
			
		}
		
		*
	
	public void render(Graphics g) {
		
	}
		*
		*/
		
	
