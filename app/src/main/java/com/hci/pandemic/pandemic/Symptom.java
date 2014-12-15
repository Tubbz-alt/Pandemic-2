package com.hci.pandemic.pandemic;

/**
 * Created by Tuxedo on 12/15/14.
 */
public class Symptom {

    int _id;
    String name;
    int level;
    String description;
    int contagiousness;
    int lethality;
    int points_to_unlock;

    // java bean compatibility
    public Symptom() {
    }

    public Symptom(int _id) {
        this._id = _id;
    }

    public Symptom(int _id, String name, String description,  int level, int contagiousness, int lethality, int points_to_unlock) {
        this._id = _id;
        this.name = name;
        this.level = level;
        this.description = description;
        this.contagiousness = contagiousness;
        this.lethality = lethality;
        this.points_to_unlock = points_to_unlock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getContagiousness() {
        return contagiousness;
    }

    public void setContagiousness(int contagiousness) {
        this.contagiousness = contagiousness;
    }

    public int getLethality() {
        return lethality;
    }

    public void setLethality(int lethality) {
        this.lethality = lethality;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPoints_to_unlock() {
        return points_to_unlock;
    }

    public void setPoints_to_unlock(int points_to_unlock) {
        this.points_to_unlock = points_to_unlock;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", description='" + description + '\'' +
                ", contagiousness=" + contagiousness +
                ", lethality=" + lethality +
                ", points_to_unlock=" + points_to_unlock +
                '}';
    }
}
