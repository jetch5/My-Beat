package org.launchcode.MyBeat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// spring boot flag that you want to story this class in
// a database - every field/property within the class
// will be stored in the database unless you specify otherwise.
// name & description stored in a table associated with this class
@Entity
public class Story {

    // create the primary key
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Must describe your story!")
    private String description;

    //private StoryType type;

    public Story(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Story() { }

    // no setter because ID should not be able to be changed
    // outside of this class
    public int getId() {
        return id;
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
}
