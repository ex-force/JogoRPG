package models;

public class Turn {

    private IBattleSystem battleSystem;
    private Character characterOne;
    private Character characterTwo;


    public Turn(Character characterOne, Character characterTwo, IBattleSystem battleSystem){
        this.battleSystem = battleSystem;
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
    }

    private void attack(Character attacker, Character defender){
        if(attacker.getHp() == 0) return;

        GameSystem.showMessage("\nIt's the turn of the "+ attacker.getTypeClass().toString());
        GameSystem.showMessage("----------Options----------");
        GameSystem.showMessage("1 - Attack");
        boolean optionIsvalid = false;

        while (!optionIsvalid) {
            int option = GameSystem.readInt();

            if (option == 1) {
                int damage = battleSystem.calculesDamage(attacker, defender);
                battleSystem.applyDamage(damage, defender);
                int exp = battleSystem.calculesExp(damage);
                
                if(damage > 0){
                    GameSystem.showMessage
                    ("\n"+attacker.getTypeClass().toString()+ " attacked "+defender.getTypeClass().toString() +" with " + damage + " damage and won " + exp + " exp.");
                }
                else{
                    GameSystem.showMessage("\n"+defender.getTypeClass().toString() + " defended the attack.");
                }

                battleSystem.applyExp(exp, attacker);
                
                optionIsvalid = true;
            }else{
                GameSystem.showMessage("Invalid option. Choose again");
            }
        }
        
    }

    public void startTurn() {
        int[] orderAttack =  battleSystem.getOrderAttack(characterOne, characterTwo);
        
        for (int i = 0; i < orderAttack.length; i++) {
            if (orderAttack[i] == 0) {
                attack(characterOne, characterTwo);
            }
            if (orderAttack[i] == 1) {
                attack(characterTwo, characterOne);
            }
        }

    }

}