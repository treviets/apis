package net.cd.dto.kernal;

/**
 * Created by Vincent 01/12/2017.
 */
public class CdKChatGroupDto {
    private Integer id;
    private String reference;
    private Integer identifier;
    private String name;
    private String description;
    private CdKAssetDto icon;
    private CdKAssetDto background;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CdKAssetDto getIcon() {
        return icon;
    }

    public void setIcon(CdKAssetDto icon) {
        this.icon = icon;
    }

    public CdKAssetDto getBackground() {
        return background;
    }

    public void setBackground(CdKAssetDto background) {
        this.background = background;
    }
}
