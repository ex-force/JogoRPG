package models;

public interface IBattleSystem {
    int calculesDamage(Character attacker, Character defender);
    void applyDamage(int damage, Character character);
    int calculesExp(int damage);
    void applyExp(int exp, Character character);
    Character getFirstAttacker(Character characterOne, Character characterTwo);
    void levelUp(Character character);
}
