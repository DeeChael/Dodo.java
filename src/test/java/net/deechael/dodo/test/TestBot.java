package net.deechael.dodo.test;

import net.deechael.dodo.api.*;
import net.deechael.dodo.configuration.Configuration;
import net.deechael.dodo.configuration.file.YamlConfiguration;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.content.TextMessage;
import net.deechael.dodo.event.EventHandler;
import net.deechael.dodo.event.Listener;
import net.deechael.dodo.event.channel.ChannelMessageEvent;
import net.deechael.dodo.event.channel.MessageReactionEvent;
import net.deechael.dodo.impl.DodoBot;
import net.deechael.dodo.types.MessageType;

import java.io.File;

public class TestBot implements Listener /* 继承监听器 */{

    @EventHandler // 该Annotation表示下面的方法是一个监听器方法
    public void onMessage(ChannelMessageEvent event /* 这里只能有一个参数，并且是一个Event */) {
        MessageContext context = event.getContext(); // 获取消息的上下文信息
        Island island = context.getIsland(); // 获取消息发送的群组
        Channel channel = context.getChannel(); // 获取消息发送的频道
        Member member = event.getMember(); // 获取发送消息的用户
        Message bodyContent = event.getBody(); // 获取消息的内容
        if (bodyContent.getType() == MessageType.TEXT) { // 如果是纯文本内容
            String content = bodyContent.get().getAsJsonObject().get("content").getAsString(); // 通过Gson库获得消息的纯文本内容
            context.reply(new TextMessage("你发送了：" + content)); // 回复用户一个纯文本内容
        }
    }

    @EventHandler
    public void onReaction(MessageReactionEvent event) {
        // 当机器人发送的消息被添加了回应时触发
    }

    public static void main(String[] args) {
        // 打开配置文件里面
        Configuration configuration = YamlConfiguration.loadConfiguration(new File("test-config.yml"));
        // 创建一个Bot对象，第一个参数为clientId，第二个参数为token
        Bot bot = new DodoBot(configuration.getInt("client-id"), configuration.getString("token"));
        // 注册事件监听器
        bot.addEventListener(new TestBot());
        // 添加任务，会在成功连接websocket以后运行
        /*
        bot.runAfter(() -> {
            // 将本地图片“test.png”上传至渡渡的服务器
            String url = bot.getClient().uploadImage(new File("test.png"));
            // 输出图片的url
            System.out.println(url);
        });
         */
        // 启动机器人
        bot.start();
    }

}