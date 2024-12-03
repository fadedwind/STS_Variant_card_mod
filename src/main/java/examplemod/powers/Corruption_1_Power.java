package examplemod.powers;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class Corruption_1_Power extends AbstractPower {
    public static final String POWER_ID = "Corruption_1";

    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("Corruption");

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public Corruption_1_Power(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "Corruption_1";
        this.owner = owner;
        this.amount = -1;
        this.description = DESCRIPTIONS[0];
        loadRegion("corruption_1");
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[1];
    }

    public void onCardDraw(AbstractCard card) {
        if (card.type == AbstractCard.CardType.SKILL)
            card.setCostForTurn(-9);
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.SKILL) {
            flash();
        }
    }
}
