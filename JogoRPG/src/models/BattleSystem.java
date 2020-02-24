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
        if(newExp > 10){
            character.setExp(0);
            levelUp(character);
        }
        else{
            character.setExp(newExp);
        }
    }

    @Override
    public Character getFirstAttacker(Character characterOne, Character characterTwo) {
        IDice diceOne = new Dice(1, characterOne.getSpeed());
        IDice diceTwo = new Dice(1, characterTwo.getSpeed());

        int resultOne;
        int resultTwo;

        do{
            resultOne = diceOne.rollDice;
            resultTwo = diceTwo.rollDice;
        }while (resultOne == resultTwo);

        if(resultOne > resultTwo){
            return characterOne;
        }
        else{
            return characterTwo;
        }
    }

    @Override
    public void levelUp(Character character) {
        character.setHp(character.getHp() + 10);
        character.setAttack(character.getAttack() + 5);
        character.setDefense(character.getDefense() + 2);
        character.setSpeed(character.getSpeed() + 2);
    }
}