package models;

public class  Character {

	protected int hp;
	protected int hpMax;
	protected int attack;
	protected int defense;
	protected int level;
	protected int exp;
	
	protected TypeClass typeClass;
	
	public Character() {
		hpMax = 50;
		level = 1;
		hp = hpMax;
		attack = 5;
		defense = 5;
		speed = 5;
	}
	public int speed;
	
	public TypeClass getTypeClass(){
		return typeClass;
	}

	public void setHpMax(int hpMax){
		this.hpMax = hpMax;
	}

	public int getHpMax(){
		return hpMax;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
