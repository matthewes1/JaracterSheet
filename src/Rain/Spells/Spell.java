package Rain.Spells;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Spell object. Used to store the information of a spell with homebrew in mind
 */
@XmlRootElement
public class Spell {
    private String spellName;
    private String level;
    private String school;
    private String castTime;
    private String range;
    private String components;
    private String duration;
    private String description;

    public void Spell() {
    }

    @XmlElement
    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    @XmlElement
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @XmlElement
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @XmlElement
    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    @XmlElement
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @XmlElement
    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    @XmlElement
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}