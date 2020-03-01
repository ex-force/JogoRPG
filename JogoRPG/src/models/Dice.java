package models;

import java.util.Random;

public class Dice implements IDice{
	private int min;
	private int max;

	public Dice(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int rollDice() {

		var diferenca = max - min;

		int resultado = min + new Random().nextInt(diferenca + 1);

		return resultado;
	}

}
