package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class vbr {
    @SerializedName("resolutions")
    ArrayList<String> resolutions;
    @SerializedName("label_name")
    ArrayList<String> resolutions_name;

    public ArrayList<String> getResolutions_name() {
        return resolutions_name;
    }

    public void setResolutions_name(ArrayList<String> resolutions_name) {
        this.resolutions_name = resolutions_name;
    }

    public ArrayList<String> getResolutions() {
        return resolutions;
    }

    public void setResolutions(ArrayList<String> resolutions) {
        this.resolutions = resolutions;
    }
}
