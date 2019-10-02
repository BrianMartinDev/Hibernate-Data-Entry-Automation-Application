package com.tableEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Brian Martin
 */
@Entity
@Table(name = "main_characters")
public class Character {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "house")
    private String house;

    @Column(name = "traits")
    private String traits;

    @Column(name = "friends_with")
    private String friends_with;

    /***
     *
     * @param name name constructor
     * @param house house constructor
     * @param traits trait constructor
     * @param friends_with friend constructor
     */
    public Character(String name, String house, String traits, String friends_with) {
        this.name = name;
        this.house = house;
        this.traits = traits;
        this.friends_with = friends_with;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public String getFriends_with() {
        return friends_with;
    }

    public void setFriends_with(String friends_with) {
        this.friends_with = friends_with;
    }

    /***
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", house='" + house + '\'' +
                ", traits='" + traits + '\'' +
                ", friends_with='" + friends_with + '\'' +
                '}';
    }
}
