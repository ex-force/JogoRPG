package models;

import java.util.List;

public interface IBattleSystem {
    int calculesDamage(Character attacker, Character defender);
    void applyDamage(int damage, Character character);
    int calculesExp(int damage);
    void applyExp(int exp, Character character);
    int[] getOrderAttack(Character characterOne, Character characterTwo);
    void levelUp(Character character);
}
