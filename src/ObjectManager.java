import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Random random;
	int score;

	int getScore() {
		return score;
	}

	void draw(Graphics g) {
		r.draw(g);
		for (Alien a : aliens) {
			a.draw(g);
		}
		for (Projectile p : projectiles) {
			p.draw(g);
		}
	}

	void update() {
		for (Alien a : aliens) {
			a.update();
			if (a.y < 0 || a.y > LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		for (Projectile p : projectiles) {
			p.update();
			if (p.y < 0 || p.y > LeagueInvaders.HEIGHT) {
				p.isActive = false;
			}
		}
		r.update();
		checkCollision();
		purgeObjects();
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (r.collisionBox.intersects(aliens.get(i).collisionBox)) {
				r.isActive = false;
				aliens.get(i).isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(j).isActive = false;
					aliens.get(i).isActive = false;
					score++;
				}
			}
		}

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(aliens.get(i));
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(projectiles.get(i));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
