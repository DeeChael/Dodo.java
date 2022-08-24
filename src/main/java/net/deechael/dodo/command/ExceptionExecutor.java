package net.deechael.dodo.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.api.MessageContext;

public interface ExceptionExecutor {

    void execute(Member sender, MessageContext message, CommandSyntaxException exception);

}
