package net.deechael.dodo.api;

import net.deechael.dodo.types.ChannelType;

public interface Channel {

    String getId();

    String getName();

    ChannelType getType();

    boolean isDefault();

    String getGroupId();

    String getGroupName();

    void setName(String name);

    void remove();

}
