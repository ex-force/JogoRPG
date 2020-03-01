package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import models.*;

public class BattleTests {
    @Test(expected = Exception.class)
    public void itIsNotPossibleToChooseACharacterWithAListOfZeroCharacters() throws Exception{
        IDice dice = new Dice(1,20);
        BattleSystem battleSystem = new BattleSystem(dice);
        Battle battle = new Battle(battleSystem);

        List<models.Character> characters = new ArrayList<models.Character>();
        battle.selectCharacterOne(characters);
    }

    @Test(expected = Exception.class)
    public void itIsNotPossibleToStartABattleWithoutSelectingTheCharacters() throws Exception {
        IDice dice = new Dice(1,20);
        BattleSystem battleSystem = new BattleSystem(dice);
        Battle battle = new Battle(battleSystem);
        
        battle.startBattle();
    }
}