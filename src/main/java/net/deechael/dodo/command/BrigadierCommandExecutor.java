package net.deechael.dodo.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import net.deechael.dodo.api.MessageContext;

public final class BrigadierCommandExecutor implements CommandExecutor {

    private final LiteralCommandNode<MessageContext> commandNode;

    public BrigadierCommandExecutor(LiteralCommandNode<MessageContext> literalCommandNode) {
        this.commandNode = literalCommandNode;
    }

    @Override
    public LiteralCommandNode<MessageContext> brigadier(String name) {
        return commandNode;
    }

    public String getName() {
        return commandNode.getName();
    }

}
