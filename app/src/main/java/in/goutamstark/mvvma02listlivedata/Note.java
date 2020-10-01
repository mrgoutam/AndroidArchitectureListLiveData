package in.goutamstark.mvvma02listlivedata;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
/*
-This is a Room annotation. At compile time it will create all necessary code to create a sqlite table for
this object.
- This is basically a table that is why we are providing table name
 */
@Entity(tableName = "note_table")
public class Note {

    /*
    - id, title, description and priority are the basically column names
    - id is the primary key to this table which is auto generated
     */

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
