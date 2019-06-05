package Rain.Spells;

public class Spell {
    private String spellName;
    private String level;
    private String school;
    private String castTime;
    private String range;
    private String components;
    private String duration;
    private String description;
    private String higherLevelsDescription;

    public void Spell() {
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHigherLevelsDescription() {
        return higherLevelsDescription;
    }

    public void setHigherLevelsDescription(String higherLevelsDescription) {
        this.higherLevelsDescription = higherLevelsDescription;
    }
}
