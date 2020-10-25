package FinalExam04apr2020;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> heroes = new LinkedHashMap<>();
        int numberOfHeroes = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroData = sc.nextLine().split("\\s+");
            String hero = heroData[0];
            int heroHP = Integer.parseInt(heroData[1]);
            int heroMP = Integer.parseInt(heroData[2]);
            heroes.putIfAbsent(hero, new ArrayList<>());
            heroes.get(hero).add(heroHP);
            heroes.get(hero).add(heroMP);
        }

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] commands = input.split(" - ");
            String command = commands[0];
            switch (command) {
                case "CastSpell": {
                    String hero = commands[1];
                    int manaNeeded = Integer.parseInt(commands[2]);
                    String spell = commands[3];
                    if (heroes.containsKey(hero)) {
                        if (heroes.get(hero).get(1) >= manaNeeded) {
                            int currentMana = heroes.get(hero).remove(1);
                            int remainingMP = currentMana - manaNeeded;
                            heroes.get(hero).add(remainingMP);
                            System.out.println(String.format("%s has successfully cast %s and now has %d MP!",
                                    hero, spell, remainingMP));
                        } else {
                            System.out.println(String.format("%s does not have enough MP to cast %s!",
                                    hero, spell));
                        }
                    }
                }
                    break;
                case "TakeDamage": {
                    String hero = commands[1];
                    int damageTaken = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    int currentHP = heroes.get(hero).get(0);
                    int hpLeft = currentHP - damageTaken;
                    if (hpLeft > 0) {
                        heroes.get(hero).set(0, hpLeft);
                        System.out.println(String.format("%s was hit for %d HP by %s and now has %d HP left!",
                                hero, damageTaken, attacker, hpLeft));
                    } else {
                        heroes.remove(hero);
                        System.out.println(String.format("%s has been killed by %s!", hero, attacker));
                    }
                }
                    break;
                case "Recharge": {
                    String hero = commands[1];
                    int rechargedFor = Integer.parseInt(commands[2]);
                    int currentMP = heroes.get(hero).get(1);
                    int manaAfterRecharge = currentMP + rechargedFor;
                    if (manaAfterRecharge > 200) {
                        manaAfterRecharge = 200;
                    }
                    heroes.get(hero).set(1, manaAfterRecharge);
                    rechargedFor = manaAfterRecharge - currentMP;

                    System.out.println(String.format("%s recharged for %d MP!", hero, rechargedFor));
                }
                    break;
                case "Heal": {
                    String hero = commands[1];
                    int healing = Integer.parseInt(commands[2]);
                    int currentHealth = heroes.get(hero).get(0);
                    int healthAfterHealing = currentHealth + healing;
                    if (healthAfterHealing > 100) {
                        healthAfterHealing = 100;
                    }
                    heroes.get(hero).set(0, healthAfterHealing);
                    int healedFor = healthAfterHealing - currentHealth;
                    System.out.println(String.format("%s healed for %d HP!", hero, healedFor));
                }
                    break;
                default: throw new IllegalArgumentException("Error!");
            }

            input = sc.nextLine();
        }

        heroes
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    int res = Integer.compare(h2.getValue().get(0), h1.getValue().get(0));
                    if (res == 0) {
                        res = h1.getKey().compareTo(h2.getKey());
                    }
                    return res;
                })
                .forEach(h -> System.out.println(String.format("%s%n  HP: %d%n  MP: %d", h.getKey(), h.getValue().get(0), h.getValue().get(1))));
    }
}