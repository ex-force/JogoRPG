package models;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private Character characterOne;
    private Character characterTwo;

    private IBattleSystem battleSystem;

    private List<Turn> turns;

    public Battle(IBattleSystem battleSystem) {
        turns = new ArrayList<Turn>();
        this.battleSystem = battleSystem;
    }

    public Character getCharacterOne(){
        return characterOne;
    }

    public Character getCharacterTwo(){
        return characterTwo;
    }

    private Character selectCharacter(List<Character> characters){
        for (int i = 0; i < characters.size() ; i++) {
            GameSystem.showMessage((i+1)+ " - " + characters.get(i).getTypeClass().toString()
            +" Level: " + characters.get(i).getLevel()
            +" | Hp: " + characters.get(i).getHp()
            +" | Atack: " + characters.get(i).getAttack()
            +" | Defense: " + characters.get(i).getDefense()
            +" | Speed: " + characters.get(i).getSpeed());
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

    public void selectCharacterOne(List<Character> characters) throws Exception {
        if(characters == null || characters.size() == 0) throw new Exception("There are no characters to choose.");
        
        GameSystem.showMessage("\nPlayer one choose your character ");
            
        characterOne = selectCharacter(characters);
        GameSystem.showMessage("Character one is "+ characterOne.getTypeClass().toString());

    }

    public void selectCharacterTwo(List<Character> characters) throws Exception {
        if(characters == null || characters.size() == 0) throw new Exception("There are no characters to choose.");
        
        GameSystem.showMessage("\nPlayer two choose your character ");
            
        characterTwo = selectCharacter(characters);
        GameSystem.showMessage("Character two is "+ characterTwo.getTypeClass().toString());
    }

    public void startBattle() throws Exception{
        if (characterOne != null && characterTwo != null){
            GameSystem.showMessage("\nBATTLE STARTED");
            while (characterOne.getHp() > 0 && characterTwo.getHp() > 0) {
                Turn turn = new Turn(characterOne, characterTwo, battleSystem);

                turn.startTurn();

                turns.add(turn);
            }

            if (characterOne.getHp() == 0 && characterTwo.getHp() > 0) {
                GameSystem.showMessage("\nPLAYER TWO WINS");
            }
            if (characterOne.getHp() > 0 && characterTwo.getHp() == 0) {
                GameSystem.showMessage("\nPLAYER ONE WINS");
            }

            characterOne.setHp(characterOne.getHpMax());
            characterOne = null;
            characterTwo.setHp(characterTwo.getHpMax());
            characterTwo = null;

        }else{
            throw new Exception("Characters were not selected");
        }
    }
}
