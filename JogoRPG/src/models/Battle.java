package models;

import java.util.List;

public class Battle {
    private Character characterOne;
    private Character characterTwo;

    private IBattleSystem battleSystem;

    private List<Turn> turns;

    public Battle(IBattleSystem battleSystem) {
        this.battleSystem = battleSystem;
    }

    private Character selectCharacter(List<Character> characters){
        for (int i = 0; i < characters.size() ; i++) {
            GameSystem.showMessage((i+1)+ " - " + characters.get(i).getTypeClass().toString());
        }
        
        do{
            
            int indexCharacter = GameSystem.readInt() - 1;

            if (indexCharacter >= 0 && indexCharacter < characters.size()) {
                return characters.get(indexCharacter);
            }else{
                GameSystem.showMessage("Your choice is invalid!");
            }
        }while (true);
    }

    public void selectCharacterOne(List<Character> characters){
        if (characters.size() > 0) {
            GameSystem.showMessage("Player one choose your character ");
            
            characterOne = selectCharacter(characters);
            GameSystem.showMessage("Character one is "+ characterOne.getTypeClass().toString());

        }else{
            GameSystem.showMessage("Player One don't have characters");
        }

    }

    public void selectCharacterTwo(List<Character> characters){
        if (characters.size() > 0) {
            GameSystem.showMessage("Player two choose your character ");
           
            characterTwo = selectCharacter(characters);
            GameSystem.showMessage("Character two is "+ characterTwo.getTypeClass().toString());
       
        }else{
            GameSystem.showMessage("Player One don't have characters");
        }
    }

    public void startBattle(){
        if (characterOne != null && characterTwo != null){
            while (characterOne.getHp() > 0 && characterTwo.getHp() > 0) {
                Turn turn = new Turn(characterOne, characterTwo, battleSystem);

                turn.startTurn();

                turns.add(turn);
            }

            if (characterOne.getHp() == 0 && characterTwo.getHp() > 0) {
                GameSystem.showMessage("Player two wins");
            }
            if (characterOne.getHp() > 0 && characterTwo.getHp() == 0) {
                GameSystem.showMessage("Player one wins");
            }

        }else{
            if (characterOne == null){
                GameSystem.showMessage("Please choose character one");
            }else{
                GameSystem.showMessage("Please choose character two");
            }

        }
    }
}
