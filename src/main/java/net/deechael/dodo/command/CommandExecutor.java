package net.deechael.dodo.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.deechael.dodo.api.MessageContext;

public interface CommandExecutor {

    LiteralCommandNode<MessageContext> brigadier(String name);

}
