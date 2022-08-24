package net.deechael.dodo.event.member;

import lombok.Getter;
import net.deechael.dodo.api.Member;
import net.deechael.dodo.event.Event;
import net.deechael.dodo.types.EventType;

public class MemberLeaveEvent extends Event {

    @Getter
    private Member member;
    @Getter
    private String islandId;
    @Getter
    private String dodoId;
    @Getter
    private LeaveType leaveType;
    @Getter
    private String operator;
    @Getter
    private String modifyTime;

    public MemberLeaveEvent(String id,
                            long timestamp,
                            Member member,
                            String islandId,
                            String dodoId,
                            LeaveType leaveType,
                            String operator,
                            String modifyTime) {
        super(id, EventType.MEMBER_LEAVE, timestamp);
        this.member = member;
        this.islandId = islandId;
        this.dodoId = dodoId;
        this.leaveType = leaveType;
        this.operator = operator;
        this.modifyTime = modifyTime;
    }

    public static enum LeaveType {
        SELF, KICKED;
    }

}
