package models;

public class Knight extends Character {

	public Knight() {
		hpMax += 25;
		hp = hpMax;
		attack += 5;
		speed += 5;
		typeClass = TypeClass.Knight;

	}

}
