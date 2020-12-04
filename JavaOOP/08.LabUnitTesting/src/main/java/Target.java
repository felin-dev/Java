package rpg_lab;

import java.util.Random;

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    boolean isDead();

    int giveExperience();

    Weapon dropWeapon(Random random);
}
