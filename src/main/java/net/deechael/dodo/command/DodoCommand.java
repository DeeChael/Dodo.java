package net.deechael.dodo.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class DodoCommand {

    private final String name;

    private final List<String> aliases = new ArrayList<>();
    private final List<String> prefixes = new ArrayList<>();

    private final CommandExecutor executor;

    private final ExceptionExecutor exceptionExecutor = null;

    private String regex = null;

    private final boolean mergeRest = false;

    public DodoCommand(BrigadierCommandExecutor executor) {
        this.name = executor.getName();
        this.prefixes.add("/");
        this.executor = executor;
    }

    public DodoCommand(String name, SimpleCommandExecutor executor) {
        this.name = name;
        this.prefixes.add("/");
        this.executor = executor;
    }

    public String getName() {
        return name;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public ExceptionExecutor getExceptionExecutor() {
        return exceptionExecutor;
    }

    public String getRegex() {
        return regex;
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

}
