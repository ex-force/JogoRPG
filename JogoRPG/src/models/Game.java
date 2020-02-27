package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    IBattleSystem battleSystem;
    List<Battle> battles;
    Player playerOne;
    Player playerTwo;

    public Game() {
	IDice dice = new Dice(1, 20);
        battleSystem = new BattleSystem(dice);
        battles = new ArrayList<Battle>();
    }
    
    public void startGame(){
        generatePlayers();
        
        mainMenu();
    }

    private void mainMenu() {
        boolean playing = true;

        while(playing){
            GameSystem.showMessage("----------Menu principal----------");
            GameSystem.showMessage("1 - Batalhar");
            GameSystem.showMessage("2 - Sair");

            int option = GameSystem.readInt();

            switch(option){
                case 1:
                    goToBattle();
                    break;
                case 2:
                    GameSystem.showMessage("GAME OVER");
                    playing = false;
                    break;
                default:
                    GameSystem.showMessage("Selecione uma opção válida.");
                    break;
            }
        }
    }

    private void generatePlayers() {
        CharactersFactory charactersFactory = new CharactersFactory();

        GameSystem.showMessage("Digite o nome do primeiro jogador:");
        String namePlayerOne = GameSystem.readString();
        List<Character> charactersPlayerOne = charactersFactory.getCharacters();
        playerOne = new Player(namePlayerOne, charactersPlayerOne);
        

        GameSystem.showMessage("Digite o nome do segundo jogador:");
        String namePlayerTwo = GameSystem.readString();
        List<Character> charactersPlayerTwo = charactersFactory.getCharacters();
        playerTwo = new Player(namePlayerTwo, charactersPlayerTwo);
    }

    private void goToBattle() {
        Battle battle = new Battle(battleSystem);

        battle.selectCharacterOne(playerOne.getCharacters());
        
        battle.selectCharacterTwo(playerTwo.getCharacters());

        battle.startBattle();

        battles.add(battle);
    }
}