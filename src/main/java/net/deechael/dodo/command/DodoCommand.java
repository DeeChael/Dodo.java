package net.deechael.dodo.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class DodoCommand {

    private final String name;

    private final List<String> aliases = new ArrayList<>();
    private final List<String> prefixes = new ArrayList<>();

    private CommandExecutor executor;

    private String regex = null;

    private final boolean mergeRest = false;

    public DodoCommand(String name) {
        this.name = name;
        this.prefixes.add("/");
    }

    public List<String> getAliases() {
        return aliases;
    }

    public List<String> getPrefixes() {
        return prefixes;
    }

    public DodoCommand setAliases(String... aliases) {
        this.aliases.clear();
        this.aliases.addAll(Arrays.asList(aliases));
        return this;
    }

    public DodoCommand setAliases(Collection<String> aliases) {
        this.aliases.clear();
        this.aliases.addAll(aliases);
        return this;
    }

    public DodoCommand setPrefixes(String... prefixes) {
        this.prefixes.clear();
        this.prefixes.addAll(Arrays.asList(prefixes));
        return this;
    }

    public DodoCommand setPrefixes(Collection<String> prefixes) {
        this.prefixes.clear();
        this.prefixes.addAll(prefixes);
        return this;
    }

    public DodoCommand setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    public DodoCommand setExecutor(CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

}
