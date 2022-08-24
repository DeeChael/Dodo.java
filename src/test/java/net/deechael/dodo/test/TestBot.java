package net.deechael.dodo.test;

import net.deechael.dodo.api.Bot;
import net.deechael.dodo.configuration.Configuration;
import net.deechael.dodo.configuration.file.YamlConfiguration;
import net.deechael.dodo.event.EventHandler;
import net.deechael.dodo.event.Listener;
import net.deechael.dodo.event.channel.ChannelMessageEvent;
import net.deechael.dodo.event.channel.MessageReactionEvent;
import net.deechael.dodo.impl.DodoBot;

import java.io.File;

public class TestBot implements Listener {

    @EventHandler
    public void onMessage(ChannelMessageEvent event) {
        event.getMember().getRoles().forEach(role -> System.out.println(role.getName()));
    }

    @EventHandler
    public void onReaction(MessageReactionEvent event) {
        System.out.println("REACTION");
    }

    public static void main(String[] args) {
        Configuration configuration = YamlConfiguration.loadConfiguration(new File("test-config.yml"));
        Bot bot = new DodoBot(configuration.getInt("client-id"), configuration.getString("token"));
        bot.addEventListener(new TestBot());
        //bot.runAfter(() -> {
        //    System.out.println(bot.getClient().uploadImage(new File("test.png")));
        //});
        bot.start();
    }

}
