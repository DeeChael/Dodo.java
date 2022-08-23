package net.deechael.dodo.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.deechael.dodo.api.Message;

public interface CommandExecutor {

    LiteralCommandNode<Message> brigadier(String name);

}
