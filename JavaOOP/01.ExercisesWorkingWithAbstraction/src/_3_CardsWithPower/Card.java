package _3_CardsWithPower;

public class Card {
    private final RankPowers rankPowers;
    private final SuitPowers suitPowers;
    private final int cardPower;

    public Card(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
        this.cardPower = rankPowers.getPower() + suitPowers.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rankPowers, this.suitPowers, this.cardPower);
    }
}
