package _3_PlayersAndMonsters;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 23);
        System.out.println(hero);

        Knight knight = new Knight("Knight", 19);
        System.out.println(knight);

        DarkKnight darkKnight = new DarkKnight("DarkKnight", 21);
        System.out.println(darkKnight);

        BladeKnight bladeKnight = new BladeKnight("BladeKnight", 24);
        System.out.println(bladeKnight);

        Wizard wizard = new Wizard("Wizard", 13);
        System.out.println(wizard);

        DarkWizard darkWizard = new DarkWizard("DarkWizard", 19);
        System.out.println(darkWizard);

        SoulMaster soulMaster = new SoulMaster("SoulMaster", 27);
        System.out.println(soulMaster);

        Elf elf = new Elf("Elf", 157);
        System.out.println(elf);

        MuseElf museElf = new MuseElf("MuseElf", 284);
        System.out.println(museElf);
    }
}
