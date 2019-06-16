package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class meta_data {
    @SerializedName("seo_title")
    String seo_title;
    @SerializedName("status")
    ArrayList<String> meta_tags;
    @SerializedName("meta_keywords")
    ArrayList<String> meta_keywords;
    @SerializedName("meta_description")
    String meta_description;


    public meta_data(String seo_title, ArrayList<String> meta_tags, ArrayList<String> meta_keywords, String meta_description) {
        this.seo_title = seo_title;
        this.meta_tags = meta_tags;
        this.meta_keywords = meta_keywords;
        this.meta_description = meta_description;
    }

    public String getSeo_title() {
        return seo_title;
    }

    public void setSeo_title(String seo_title) {
        this.seo_title = seo_title;
    }

    public ArrayList<String> getMeta_tags() {
        return meta_tags;
    }

    public void setMeta_tags(ArrayList<String> meta_tags) {
        this.meta_tags = meta_tags;
    }

    public ArrayList<String> getMeta_keywords() {
        return meta_keywords;
    }

    public void setMeta_keywords(ArrayList<String> meta_keywords) {
        this.meta_keywords = meta_keywords;
    }

    public String getMeta_description() {
        return meta_description;
    }

    public void setMeta_description(String meta_description) {
        this.meta_description = meta_description;
    }
}