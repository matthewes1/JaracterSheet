package Rain.Spells;

import java.io.Serializable;

public class Spell implements Serializable {
    private static final long serialVersionUID = 4123412365L;
    private boolean verbal = false;
    private boolean somatic = false;
    private boolean material = false;
    private boolean prepared;
    private int lvl;
    private int school;
    private String name;
    private String spellClass;
    private String customSchool;
    private String castTime;
    private String range;
    private String duration;
    private String desc;
    private String higherLvl;

    public Spell(boolean verbal, boolean somatic, boolean material, int lvl, int school, String name, String spellClass, String customSchool, String castTime, String range, String duration, String desc, String higherLvl) {
        this.verbal = verbal;
        this.somatic = somatic;
        this.material = material;
        this.lvl = lvl;
        this.school = school;
        this.name = name;
        this.spellClass = spellClass;
        this.customSchool = customSchool;
        this.castTime = castTime;
        this.range = range;
        this.duration = duration;
        this.desc = desc;
        this.higherLvl = higherLvl;
    }

    public boolean isVerbal() {
        return this.verbal;
    }

    public void setVerbal(boolean verbal) {
        this.verbal = verbal;
    }

    public boolean isSomatic() {
        return this.somatic;
    }

    public void setSomatic(boolean somatic) {
        this.somatic = somatic;
    }

    public boolean isMaterial() {
        return this.material;
    }

    public void setMaterial(boolean material) {
        this.material = material;
    }

    public int getLvl() {
        return this.lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getSchool() {
        return this.school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomSchool() {
        return this.customSchool;
    }

    public void setCustomSchool(String customSchool) {
        this.customSchool = customSchool;
    }

    public String getCastTime() {
        return this.castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHigherLvl() {
        return this.higherLvl;
    }

    public void setHigherLvl(String higherLvl) {
        this.higherLvl = higherLvl;
    }

    public String getSpellClass() {
        return this.spellClass;
    }

    public void setSpellClass(String spellClass) {
        this.spellClass = spellClass;
    }

    public boolean isPrepared() {
        return this.prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }
}
