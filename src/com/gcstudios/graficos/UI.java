package com.gcstudios.graficos;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import com.gcstudios.main.Game;

public class UI {

	public static BufferedImage Heart = Game.spritesheet.getSprite(	0, 20, 8, 8);
	
	public void render(Graphics g) {
		for(int i = 0 ; i < (int)(Game.vida); i++) {
			g.drawImage(Heart, 30 + (i*39),30,36,36,null);
		}
		g.setFont(new Font("arial",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString("$ " +Game.dinheiro, (Game.WIDTH * Game.SCALE) - 80, 30);
	}
	
}
