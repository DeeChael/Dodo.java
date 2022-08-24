package net.deechael.dodo.api;

public interface Role {

    String getIslandId();

    String getId();

    String getName();

    String getColor();

    int getPosition();

    String getPermission();

    void setName(String name);

    void setColor(String color);

    void setPosition(int position);

    void setPermission(String permission);

    void remove();

}
