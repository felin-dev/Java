package MMORPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int heroesAvailable = Integer.parseInt(sc.nextLine());
        List<Hero> heroes = new ArrayList<>();
        int maxHP = 100;
        int maxMP = 200;
        while (heroesAvailable > 0) {
            String[] heroInfo = sc.nextLine().split("\\s+");
            String heroName = heroInfo[0];
            int heroHP = Integer.parseInt(heroInfo[1]);
            int heroMP = Integer.parseInt(heroInfo[2]);
            Hero hero = new Hero(heroName, heroHP, heroMP);
            heroes.add(hero);

            heroesAvailable--;
        }

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] actions = input.split("\\s+-+\\s+");
            String command = actions[0];
            switch (command) {
                case "CastSpell": {
                    String attackingHero = actions[1];
                    int manaNeeded = Integer.parseInt(actions[2]);
                    String spell = actions[3];
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(attackingHero)) {
                             int currentMana = hero.getMana();
                            if (currentMana > manaNeeded) {
                                int manaLeft = currentMana - manaNeeded;
                                hero.setMana(manaLeft);
                                System.out.printf("%s has successfully cast %s and now has %d MP!%n", attackingHero, spell, manaLeft);
                            } else {
                                System.out.printf("%s does not have enough MP to cast %s!%n", attackingHero, spell);
                            }
                        }
                    }
                    break;
                }
                case "TakeDamage": {
                    String attackedHero = actions[1];
                    int damage = Integer.parseInt(actions[2]);
                    String attackingHero = actions[3];
                    int heroesSize = heroes.size();
                    for (int i = 0; i < heroesSize; i++) {
                        Hero hero = heroes.get(i);
                        if (hero.getName().equals(attackedHero)) {
                            int currentHeroHP = hero.getHealth();
                            if (currentHeroHP > damage) {
                                int hpLeft = currentHeroHP - damage;
                                hero.setHealth(hpLeft);
                                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                        attackedHero, damage, attackingHero, hpLeft);
                            } else {
                                System.out.printf("%s has been killed by %s!%n", attackedHero, attackingHero);
                                heroes.remove(hero);
                                heroesSize--;
                                //i--;
                            }
                        }
                    }
                    break;
                }
                case "Recharge": {
                    String currentHero = actions[1];
                    int manaRecharging = Integer.parseInt(actions[2]);
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(currentHero)) {
                            int currentMana = hero.getMana();
                            int manaAfterRecharging = currentMana + manaRecharging;
                            if (manaAfterRecharging > maxMP) {
                                manaAfterRecharging = maxMP;
                            }
                            hero.setMana(manaAfterRecharging);
                            int manaRecharged = manaAfterRecharging - currentMana;
                            System.out.printf("%s recharged for %d MP!%n", currentHero, manaRecharged);
                        }
                    }
                    break;
                }
                case "Heal": {
                    String currentHero = actions[1];
                    int healing = Integer.parseInt(actions[2]);
                    for (Hero hero : heroes) {
                        if (hero.getName().equals(currentHero)) {
                            int currentHealth = hero.getHealth();
                            int hpAfterHealing = currentHealth + healing;
                            if (hpAfterHealing > maxHP) {
                                hpAfterHealing = maxHP;
                            }
                            hero.setHealth(hpAfterHealing);
                            int healedFor = hpAfterHealing - currentHealth;
                            System.out.printf("%s healed for %d HP!%n", currentHero, healedFor);
                        }
                    }
                    break;
                }
            }
            input = sc.nextLine();
        }

        sortHeroesByHealth(heroes);
        printHeroes(heroes);
    }

    private static void sortHeroesByHealth(List<Hero> heroes) {
        for (int i = 0; i < heroes.size() - 1; i++) {
            Hero currentHero = heroes.get(i);
            Hero nextHero = heroes.get(i + 1);
            if (currentHero.getHealth() > nextHero.getHealth()) {
                heroes.remove(currentHero);
                heroes.add(0, currentHero);
            }
        }
    }

    private static void printHeroes(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero.getName());
            System.out.printf("  HP: %d%n", hero.getHealth());
            System.out.printf("  MP: %d%n", hero.getMana());
        }
    }

    public static class Hero {
        private String name;
        private int health;
        private int mana;

        public Hero(String name, int health, int mana) {
            this.name = name;
            this.health = health;
            this.mana = mana;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getMana() {
            return mana;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }
    }
}