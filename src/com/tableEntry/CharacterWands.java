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
public class CharacterWands {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * @param name name constructor
     */
    public CharacterWands(String name) {

        this.name = name;
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

    @Override
    public String toString() {
        return "CharacterWands{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
