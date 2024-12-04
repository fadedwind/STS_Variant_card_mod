package VCM.powers;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class Corruption_1_Power extends AbstractPower {
    public static final String POWER_ID = "Corruption_1";

    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);

    public static final String NAME = powerStrings.NAME;

    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public Corruption_1_Power(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "Corruption_1";
        this.owner = owner;
        this.description = DESCRIPTIONS[0];
        this.amount = -1;

        // 添加一大一小两张能力图
        String path128 = "ExampleModResources/img/powers/Corruption_1_84.png";
        String path48 = "ExampleModResources/img/powers/Corruption_1_32.png";
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
