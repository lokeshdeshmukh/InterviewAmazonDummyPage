package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

public class trailers_teaser {


    @SerializedName("title")
    String title;
    @SerializedName("short_desciption")
    String shortDescription;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
