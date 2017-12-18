package net.cd.dto.lookup;

import net.cd.jpa.entity.lookup.CdLTemplateMessageEntity;

/**
 * Created by Vincent 01/12/2017
 */
public class CdLTemplateMessageDto {

    private Integer id;
    private CdLL10NDto l10N;
    private CdLL10NDto header;
    private CdLTemplateMessageEntity.EntityTypes entity;
    private CdLTemplateMessageEntity.ChannelTypes channel;
    private CdLTemplateMessageEntity.ActionTypes action;
    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdLL10NDto getL10N() {
        return l10N;
    }

    public void setL10N(CdLL10NDto l10N) {
        this.l10N = l10N;
    }

    public CdLL10NDto getHeader() {
        return header;
    }

    public void setHeader(CdLL10NDto header) {
        this.header = header;
    }

    public CdLTemplateMessageEntity.EntityTypes getEntity() {
        return entity;
    }

    public void setEntity(CdLTemplateMessageEntity.EntityTypes entity) {
        this.entity = entity;
    }

    public CdLTemplateMessageEntity.ChannelTypes getChannel() {
        return channel;
    }

    public void setChannel(CdLTemplateMessageEntity.ChannelTypes channel) {
        this.channel = channel;
    }

    public CdLTemplateMessageEntity.ActionTypes getAction() {
        return action;
    }

    public void setAction(CdLTemplateMessageEntity.ActionTypes action) {
        this.action = action;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
