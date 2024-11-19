package examplemod.modcore;

import basemod.interfaces.*;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import basemod.BaseMod;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import examplemod.cards.Strike;


@SpireInitializer // 加载mod的注解
public class ExampleMod implements
EditCardsSubscriber{
    // 构造方法
    public ExampleMod() {
        BaseMod.subscribe(this); // 告诉basemod你要
    }

    // 注解需要调用的方法，必须写
    public static void initialize() {
        new ExampleMod();
    }

    // 当basemod开始注册mod卡牌时，便会调用这个函数
    @Override
    public void receiveEditCards() {
        // TODO 这里写添加你卡牌的代码
        BaseMod.addCard(new Strike());
    }
}
