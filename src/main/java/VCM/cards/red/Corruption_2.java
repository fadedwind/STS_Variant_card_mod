package VCM.cards.red;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

import basemod.abstracts.CustomCard;

import VCM.powers.Corruption_1_Power;

public class Corruption_2 extends CustomCard {
    public static final String ID = "ExampleMod:Corruption!";
    private static final String NAME = "腐化!";
    private static final String IMG_PATH ="ExampleModResources/img/cards/red/power/Corruption_2.png";
    private static final String DESCRIPTION = "你的攻击牌和技能牌费用变为0，且打出被消耗。每回合永久失去1点最大生命。";
    private static final CardType TYPE = CardType.POWER;
    private static final CardColor COLOR = CardColor.RED;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;

    public Corruption_2() {
        // 为了命名规范修改了变量名。这些参数具体的作用见下方
        super(ID, NAME, IMG_PATH, 4, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = 4;
        this.magicNumber = this.baseMagicNumber;
    }
    /**
     * 当卡牌被使用时，调用这个方法。
     *
     * @param p 你的玩家实体类。
     * @param m 指向的怪物类。（无指向时为null，包括攻击所有敌人时）
     */
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.BLACK, p.hb.cX, p.hb.cY), 0.33F));
        addToBot((AbstractGameAction)new SFXAction("ATTACK_FIRE"));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.PURPLE, p.hb.cX, p.hb.cY), 0.33F));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new VerticalAuraEffect(Color.CYAN, p.hb.cX, p.hb.cY), 0.0F));
        addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new BorderLongFlashEffect(Color.MAGENTA), 0.0F, true));

        boolean powerExists = false;
        for (AbstractPower pow : p.powers) {
            if (pow.ID.equals("Corruption")) {
                powerExists = true;

                break;
            }
        }
        if (!powerExists) {
            addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Corruption_1_Power((AbstractCreature)p)));
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(3);
        }
    }

    public AbstractCard makeCopy() {
        return new Corruption_2();
    }

}

