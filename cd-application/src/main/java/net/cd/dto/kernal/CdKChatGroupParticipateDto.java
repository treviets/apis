package net.cd.dto.kernal;

/**
 * Created by Vincent 01/12/2017.
 */
public class CdKChatGroupParticipateDto {
    private Integer id;
    private CdKChatGroupDto chatgroup;
    private CdKMemberDto participate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdKChatGroupDto getChatgroup() {
        return chatgroup;
    }

    public void setChatgroup(CdKChatGroupDto chatgroup) {
        this.chatgroup = chatgroup;
    }

    public CdKMemberDto getParticipate() {
        return participate;
    }

    public void setParticipate(CdKMemberDto participate) {
        this.participate = participate;
    }
}
