package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import models.*;

public class BattleSystemTests {
    @Test
    public void damageCannotExceedOpponentsHp(){
        models.Character attacker = new Dragon();
        models.Character defender = new Knight();

        attacker.setAttack(200);

        defender.setDefense(0);
        defender.setHp(100);

        int expected = 100;

        BattleSystem battleSystem = new BattleSystem(new Dice(1,1));

        assertEquals(expected, battleSystem.calculesDamage(attacker, defender));
    }

    @Test
    public void damageCannotBeLessThanZero(){
        models.Character attacker = new Dragon();
        models.Character defender = new Knight();

        attacker.setAttack(100);

        defender.setDefense(200);

        int expected = 0;

        BattleSystem battleSystem = new BattleSystem(new Dice(1,1));

        assertEquals(expected, battleSystem.calculesDamage(attacker, defender));
    }

    @Test
    public void gaining10OrMoreExpIncreasesTheLevel(){
        models.Character character = new Dragon();

        character.setLevel(10);

        int expected = 11;

        BattleSystem battleSystem = new BattleSystem(new Dice(1,1));

        battleSystem.applyExp(15, character);

        assertEquals(expected, character.getLevel());
    }
}