package net.deechael.dodo.test;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.deechael.dodo.api.Bot;
import net.deechael.dodo.api.MessageContext;
import net.deechael.dodo.command.BrigadierCommandExecutor;
import net.deechael.dodo.command.DodoCommand;
import net.deechael.dodo.configuration.Configuration;
import net.deechael.dodo.configuration.file.YamlConfiguration;
import net.deechael.dodo.content.CardMessage;
import net.deechael.dodo.content.card.Card;
import net.deechael.dodo.content.card.Header;
import net.deechael.dodo.content.card.ListSelector;
import net.deechael.dodo.content.card.Section;
import net.deechael.dodo.event.EventHandler;
import net.deechael.dodo.event.Listener;
import net.deechael.dodo.event.channel.CardMessageListSubmitEvent;
import net.deechael.dodo.impl.DodoBot;
import net.deechael.dodo.types.card.CardThemeType;

import java.io.File;
import java.util.List;

public class CardMessageTest implements Listener {

    @EventHandler
    public void onSubmit(CardMessageListSubmitEvent event) {
        List<String> selected = event.get();
        selected.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Configuration configuration = YamlConfiguration.loadConfiguration(new File("test-config.yml"));
        Bot bot = new DodoBot(configuration.getInt("client-id"), configuration.getString("token"));
        bot.addEventListener(new CardMessageTest());
        DodoCommand command = new DodoCommand(new BrigadierCommandExecutor(LiteralArgumentBuilder.<MessageContext>literal("card")
                .executes(context -> {
                    MessageContext messageContext = context.getSource();
                    Card card = new Card();
                    card.setTheme(CardThemeType.BLUE);
                    card.append(new Header("Card title here"));
                    card.append(new Section("这是一个卡片测试消息"));
                    ListSelector listSelector = new ListSelector(1, 1);
                    listSelector.setPlaceholder("Choose a programming language");
                    listSelector.append(new ListSelector.Element("Java"));
                    listSelector.append(new ListSelector.Element("C++"));
                    listSelector.append(new ListSelector.Element("C#"));
                    listSelector.append(new ListSelector.Element("Kotlin"));
                    listSelector.append(new ListSelector.Element("Python"));
                    card.append(listSelector);
                    CardMessage message = new CardMessage(card);
                    messageContext.reply(message);
                    return 1;
                })
                .build()));
        command.setRegex("(.|/|。)(card|cd|卡片)");
        bot.registerCommand(command);
        bot.start();
    }

}
