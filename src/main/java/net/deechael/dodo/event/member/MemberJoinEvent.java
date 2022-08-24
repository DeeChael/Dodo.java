package net.deechael.dodo.event.member;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class MemberJoinEvent extends Event {

    @Getter
    private Member member;
    @Getter
    private String islandId;
    @Getter
    private String dodoId;
    @Getter
    private String modifyTime;

    public MemberJoinEvent(String id, long timestamp, Member member, String islandId, String dodoId, String modifyTime) {
        super(id, EventType.MEMBER_JOIN, timestamp);
        this.member = member;
        this.islandId = islandId;
        this.dodoId = dodoId;
        this.modifyTime = modifyTime;
    }

}
