package net.cd.dto.trace;

import net.cd.dto.kernal.CdKMemberDto;
import net.cd.jpa.entity.trace.CdTVerificationEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdTVerificationDto {

    @NotNull
    private Integer id;
    private CdKMemberDto member;
    private String code;
    private CdTVerificationEntity.Channel channel = CdTVerificationEntity.Channel.SMS;
    private CdTVerificationEntity.Type type = CdTVerificationEntity.Type.REG;
    private Integer ttl;
    private Integer verified = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdKMemberDto getMember() {
        return member;
    }

    public void setMember(CdKMemberDto member) {
        this.member = member;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CdTVerificationEntity.Channel getChannel() {
        return channel;
    }

    public void setChannel(CdTVerificationEntity.Channel channel) {
        this.channel = channel;
    }

    public CdTVerificationEntity.Type getType() {
        return type;
    }

    public void setType(CdTVerificationEntity.Type type) {
        this.type = type;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }
}
