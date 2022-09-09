package net.deechael.dodo.api;

public interface VoiceChannel extends Channel {

    void mute(Member member);

    void kick(Member member);

    void microphoneOn(Member member);

    void microphoneOff(Member member);

    void move(Member member);

}
