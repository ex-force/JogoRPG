package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    IBattleSystem battleSystem;
    List<Battle> battles;
    Player playerOne;
    Player playerTwo;

    public Game() {
        battleSystem = new BattleSystem(new Dice(1, 20));
        battles = new ArrayList<Battle>();
    }
    
    public void startGame(){
        generatePlayers();
        
        mainMenu();
    }

    private void mainMenu() {
        boolean playing = true;

        while(playing){
            GameSystem.showMessage("\n----------Main menu----------");
            GameSystem.showMessage("1 - New battle");
            GameSystem.showMessage("2 - Exit game");

            int option = GameSystem.readInt();

            switch(option){
                case 1:
                    goToBattle();
                    break;
                case 2:
                    GameSystem.showMessage("\nGAME OVER");
                    playing = false;
                    break;
                default:
                    GameSystem.showMessage("\nOption invalid.");
                    break;
            }
        }
    }

    private void generatePlayers() {
        List<TypeClass> listClasses = new ArrayList<TypeClass>();
        listClasses.add(TypeClass.Dragon);
        listClasses.add(TypeClass.Knight);

        CharactersFactory charactersFactory = new CharactersFactory(listClasses);

        GameSystem.showMessage("\nEnter the name of the player one:");
        String namePlayerOne = GameSystem.readString();
        List<Character> charactersPlayerOne = charactersFactory.getCharacters();
        playerOne = new Player(namePlayerOne, charactersPlayerOne);
        

        GameSystem.showMessage("\nEnter the name of the player two:");
        String namePlayerTwo = GameSystem.readString();
        List<Character> charactersPlayerTwo = charactersFactory.getCharacters();
        playerTwo = new Player(namePlayerTwo, charactersPlayerTwo);
    }

    private void goToBattle() {
        Battle battle = new Battle(battleSystem);

        boolean battleEnded = false;

        while(!battleEnded){

            GameSystem.showMessage("\n----------New battle----------");
            if(battle.getCharacterOne() == null){
                GameSystem.showMessage("1 - Select character one (none)");
            }
            else{
                GameSystem.showMessage("1 - Select character one ("+battle.getCharacterOne().getTypeClass().toString()+")");
            }
            if(battle.getCharacterTwo() == null){
                GameSystem.showMessage("2 - Select character two (none)");
            }
            else{
                GameSystem.showMessage("1 - Select character one ("+battle.getCharacterTwo().getTypeClass().toString()+")");
            }
            GameSystem.showMessage("3 - Start battle");
            GameSystem.showMessage("4 - Back to the main menu");
            
            int option = GameSystem.readInt();
            switch(option){
                case 1:
                    try {
                        battle.selectCharacterOne(playerOne.getCharacters());
                    } catch (Exception e) {
                        GameSystem.showMessage("\n" + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        battle.selectCharacterTwo(playerTwo.getCharacters());
                    } catch (Exception e) {
                        GameSystem.showMessage("\n" + e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        battle.startBattle();
                        battleEnded = true;
                    }
                    catch(Exception e){
                        GameSystem.showMessage("\n" + e.getMessage());
                    }
                    break;
                case 4:
                    battleEnded = true;
                    break;
                default:
                    GameSystem.showMessage("\nOption invalid");
                    break;
            }
        }

        battles.add(battle);
    }
}