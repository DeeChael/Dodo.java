package net.deechael.dodo.command.brigadier;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.deechael.dodo.content.StringContent;

import java.util.Arrays;
import java.util.Collection;

public class ChatArgumentType implements ArgumentType<StringContent> {

    private static final Collection<String> EXAMPLES = Arrays.asList("Hello worlds!", "foo", "Aaa");

    private ChatArgumentType() {
    }

    public static String getChat(final CommandContext<?> context, final String name) {
        return context.getArgument(name, StringContent.class).get();
    }

    public static ChatArgumentType chat() {
        return new ChatArgumentType();
    }

    @Override
    public StringContent parse(StringReader reader) throws CommandSyntaxException {
        StringContent message = new StringContent(reader.getString().substring(reader.getCursor(), reader.getTotalLength()));
        reader.setCursor(reader.getTotalLength());
        return message;
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }

}
