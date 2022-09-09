package net.deechael.dodo.types;

public enum Status {


    OFF(0),
    ON(1);

    private final int code;

    Status(int status) {
        this.code = status;
    }

    public int getCode() {
        return code;
    }

    public static Status of(int code) {
        if (code == 1) {
            return ON;
        }
        return OFF;
    }

}
