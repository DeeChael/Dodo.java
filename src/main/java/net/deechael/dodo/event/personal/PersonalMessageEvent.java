package net.deechael.dodo.event.personal;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.content.Message;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;
import net.deechael.dodo.types.MessageType;
import net.deechael.dodo.types.UserSexType;

public class PersonalMessageEvent extends Event {

    @Getter
    private String dodoId;
    @Getter
    private String nickname;
    @Getter
    private String avatarUrl;
    @Getter
    private UserSexType sex;
    @Getter
    private String messageId;
    @Getter
    private Member member;
    @Getter
    private MessageType messageType;
    @Getter
    private Message body;

    public PersonalMessageEvent(String id,
                                long timestamp,
                                String dodoId,
                                String nickname,
                                String avatarUrl,
                                UserSexType sex,
                                String messageId,
                                MessageType messageType,
                                Message body) {
        super(id, EventType.PERSONAL_MESSAGE, timestamp);
        this.dodoId = dodoId;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.sex = sex;
        this.messageId = messageId;
        this.messageType = messageType;
        this.body = body;
    }

}
