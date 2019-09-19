package com.something;

import java.util.ArrayList;
import java.util.Random;

public class SaleGame {


	private static final int MAP_HEIGHT = 10;
	private static final int MAP_WIDTH= 10;
	private Home[][] town;
	private ArrayList<Salesman> salesmen;
	private ArrayList<Salesman> converted;
	private Random random;

	public void initateGame() {
		random = new Random();
		town = new Home[MAP_WIDTH][MAP_HEIGHT];

		for (int x = 0; x < MAP_WIDTH; x++) {
			for (int y = 0; y < MAP_HEIGHT; y++) {
				town[x][y] = new Home();
			}
		}

		salesmen = new ArrayList();
		salesmen.add(new Salesman(1, 0,0));

	}


	public int startGame() {

		int turns = 0;

		do {
			moveSalesmen();
			turns++;
		} while (salesmen.size() <= (MAP_HEIGHT * MAP_WIDTH));

		return turns;
	}


	public void moveSalesmen() {
		converted = new ArrayList<Salesman>();
		for (Salesman salesman : salesmen) {
			move(salesman);
			knockDoor(salesman);
		}
		salesmen.addAll(converted);
	}

	private void knockDoor(Salesman salesman) {
		Home home = town[salesman.getX()][salesman.getY()];
		if(home.knock()){
			home.convertPerson();
			converted.add(new Salesman(salesmen.size() + 1 + converted.size(), salesman.getX(), salesman.getY()));
		}
	}

	private void move(Salesman salesman) {

		int x;
		int y;

		do {
			int direction = random.nextInt(4);
			x = salesman.getX();
			y = salesman.getY();

			switch (direction) {
			case 0:
				y++;
				break;
			case 1:
				x++;
				break;
			case 2:
				y--;
				break;
			case 3:
				x--;
				break;
			}
		} while (x < 0 || x >= MAP_WIDTH || y < 0 || y >= MAP_HEIGHT);

		salesman.setX(x);
		salesman.setY(y);

	}

	private boolean ValidateX(int x) {
		return x >= 0 && x < MAP_WIDTH;
	}

	private boolean ValidateY(int y) {
		return y >= 0 && y < MAP_HEIGHT;
	}


}
