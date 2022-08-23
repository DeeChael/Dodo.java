package net.deechael.dodo.api;

import net.deechael.dodo.content.Content;

public interface PublicMessage extends Message {

    void reply(Content content, boolean quote, boolean isTemp);

}
