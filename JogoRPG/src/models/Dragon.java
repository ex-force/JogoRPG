package models;

public class Dragon extends Character {

	public Dragon() {
		hpMax += 50;
		hp = hpMax;
		defense += 5;
		typeClass = TypeClass.Dragon;

	}

}
