package models;

public class BattleSystem implements IBattleSystem {
    private IDice dice;

    public BattleSystem(IDice dice){
        this.dice = dice;
    }

    @Override
    public int calculesDamage(Character attacker, Character defender) {
        int atk = attacker.getAttack() * dice.rollDice();
        int def = defender.getDefense() * dice.rollDice();
        int damage = atk - def;
        if(damage < 0){
            damage = 0;
        }
        if(damage > defender.getHp()){
            damage = defender.getHp();
        }

        return damage;
    }

    @Override
    public void applyDamage(int damage, Character character) {
        character.setHp(character.getHp() - damage);
    }

    @Override
    public int calculesExp(int damage) {
        return damage / 2;
    }

    @Override
    public void applyExp(int exp, Character character) {
        int newExp = character.getExp() + exp;
        if(newExp >= 10){
            character.setExp(0);
            levelUp(character);
        }
        else{
            character.setExp(newExp);
        }
    }

    @Override
    public int[] getOrderAttack(Character characterOne, Character characterTwo) {
        IDice diceOne = new Dice(1, characterOne.getSpeed());
        IDice diceTwo = new Dice(1, characterTwo.getSpeed());

        int resultOne;
        int resultTwo;

        do{
            resultOne = diceOne.rollDice();
            resultTwo = diceTwo.rollDice();
        }while (resultOne == resultTwo);

        int[] orderAttack = new int[2];

        if(resultOne > resultTwo){
            orderAttack[0] = 0;
            orderAttack[1] = 1;
            return orderAttack;
        }
        else{
            orderAttack[0] = 1;
            orderAttack[1] = 0;
            return orderAttack;
        }
    }

    @Override
    public void levelUp(Character character) {
        character.setLevel(character.getLevel() + 1);
        character.setHpMax(character.getHpMax() + 10);
        character.setAttack(character.getAttack() + 5);
        character.setDefense(character.getDefense() + 2);
        character.setSpeed(character.getSpeed() + 2);

        GameSystem.showMessage(character.getTypeClass().toString() + " level up."
            +" Hp: " + character.getHpMax()
            +" | Atack: " + character.getAttack()
            +" | Defense: " + character.getDefense()
            +" | Speed: " + character.getSpeed());
    }
}