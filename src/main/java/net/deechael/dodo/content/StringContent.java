package net.deechael.dodo.content;

public class StringContent implements Content {

    private final String content;

    public StringContent(String content) {
        this.content = content;
    }

    @Override
    public String get() {
        return this.content;
    }

}
