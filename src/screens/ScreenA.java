package screens;

import java.util.ArrayList;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;
import model.Bullet;
import model.Enemy;



	public class ScreenA extends BaseScreen{

		//Los objetos sobre el escenario
		private Avatar avatar;
		private ArrayList<Bullet> bullets;
		private ArrayList<Enemy> enemies;
		
		public ScreenA(Canvas canvas) {
			super(canvas);
			avatar = new Avatar(canvas);
			bullets = new ArrayList<Bullet>();
			enemies = new ArrayList<Enemy>();
			enemies.add(new Enemy(canvas, 500, 200));
		}

		@Override
		public void paint() {
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			
			avatar.paint();
			
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).paint();
				
				if(bullets.get(i).getX() > canvas.getWidth()) {
					bullets.remove(i);
					i--;
				}
			}
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).paint();
			}
			for (int i = 0; i < enemies.size(); i++) {
				for (int j = 0; j < bullets.size(); j++) {
					Enemy e = enemies.get(i);
					Bullet b = bullets.get(j);
					
					double D = Math.sqrt(Math.pow(b.getX(), 2)+
							Math.pow(b.getY(), 2));
					
					if(D<= 10) {
						enemies.remove(i);
						bullets.remove(j);
						return;
					}
				}
			}
			
		}

		@Override
		public void onClick(MouseEvent e) {
			MainWindow.SCREEN = (MainWindow.SCREEN + 1) % 2;
		}

		@Override
		public void onKey(KeyEvent e) {
			if(e.getCode().equals(KeyCode.A)) {
				avatar.moveXBy(-10);
			}else if(e.getCode().equals(KeyCode.W)) {
				avatar.moveYBy(-10);
			}else if(e.getCode().equals(KeyCode.S)) {
				avatar.moveYBy(10);
			}else if(e.getCode().equals(KeyCode.D)) {
				avatar.moveXBy(10);
			}else if(e.getCode().equals(KeyCode.SPACE)) {
				bullets.add(new Bullet(canvas, avatar.getX(), avatar.getY()));
			}
			
		}

	}


