package examplemod.cards.red;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


import basemod.abstracts.CustomCard;


public class Corruption_1 extends CustomCard {
    public static final String ID = "ExampleMod:Corruption?";
    private static final String NAME = "腐化?";
    private static final String IMG_PATH ="ExampleModResources/img/cards/Corruption_1.png";
    private static final String DESCRIPTION = "你的技能牌被消耗时会进入弃牌堆。你的技能牌在打出时被消耗。";
    private static final CardType TYPE = CardType.POWER;
    private static final CardColor COLOR = CardColor.RED;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public Corruption_1() {
        // 为了命名规范修改了变量名。这些参数具体的作用见下方
        super(ID, NAME, IMG_PATH, 3, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(2);
        }
    }

    /**
     * 当卡牌被使用时，调用这个方法。
     *
     * @param p 你的玩家实体类。
     * @param m 指向的怪物类。（无指向时为null，包括攻击所有敌人时）
     */
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageType.NORMAL)));
    }

}
