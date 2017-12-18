package net.cd.dto.kernal;

import java.sql.Timestamp;

/**
 * Created by Vincent on 01/12/2017.
 */
public class CdKChatAttributeDto {
    private Integer id;
    private CdKMemberDto member;
    private String k;
    private String v;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

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

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }
}
