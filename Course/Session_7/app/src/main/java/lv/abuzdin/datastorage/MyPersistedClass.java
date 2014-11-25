package lv.abuzdin.datastorage;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "MyPersistedClass")
public class MyPersistedClass extends Model {

    @Column(name = "type")
    private int value;

    @Column(name = "description")
    private String description;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
