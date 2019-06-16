package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

public class genre {
    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
