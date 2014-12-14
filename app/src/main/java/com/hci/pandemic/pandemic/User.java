package com.hci.pandemic.pandemic;

/**
 * Created by andrewparrish on 12/2/14.
 */
public class User implements Comparable {
    private int _id;
    private String name;
    private String disease_name;
    private String image_location;
    private int score;

    public User(int _id, String name, String disease_name, String image_location){
        this._id = _id;
        this.name = name;
        this.disease_name = disease_name;
        this.image_location = image_location;
        this.score = 0;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String Name(){ return this.name; }

    public String DiseaseName() { return this.disease_name; }

    public int Score() { return this.score; }

    @Override
    public int compareTo(Object another) {
        if (!(another instanceof User))
            throw new ClassCastException("Not a user");
        else{
            int score =((User) another).score;
            return score - this.score;
        }
    }
}
