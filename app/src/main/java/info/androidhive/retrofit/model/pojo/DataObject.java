package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataObject {

    @SerializedName("_id")
    String _id;
    @SerializedName("meta_data")
    meta_data meta_data;
    @SerializedName("content_manager")
    ArrayList<content_manager> content_manager;
    @SerializedName("trailers_teaser")
    ArrayList<trailers_teaser> trailers_teaser;

    public ArrayList<info.androidhive.retrofit.model.pojo.trailers_teaser> getTrailers_teaser() {
        return trailers_teaser;
    }

    public void setTrailers_teaser(ArrayList<info.androidhive.retrofit.model.pojo.trailers_teaser> trailers_teaser) {
        this.trailers_teaser = trailers_teaser;
    }

    @SerializedName("base_url")
    String base_url;
    @SerializedName("people_base_url")
    String people_base_url;
    @SerializedName("video_url")
    String video_url;
    @SerializedName("content_name")
    String content_name;
    @SerializedName("long_description")
    String long_description;
    @SerializedName("genre")
    ArrayList<genre> genrearray;
    @SerializedName("released_year")
    String released_year;
    @SerializedName("duration")
    String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleased_year() {
        return released_year;
    }

    public void setReleased_year(String released_year) {
        this.released_year = released_year;
    }

    public ArrayList<genre> getGenrearray() {
        return genrearray;
    }

    public void setGenrearray(ArrayList<genre> genrearray) {
        this.genrearray = genrearray;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getContent_name() {
        return content_name;
    }

    public void setContent_name(String content_name) {
        this.content_name = content_name;
    }


    public DataObject(String _id,meta_data meta_data, ArrayList<content_manager> content_manager, String base_url, String people_base_url, String video_url) {
        this._id = _id;
        this.meta_data = meta_data;
        this.content_manager = content_manager;
        this.base_url = base_url;
        this.people_base_url = people_base_url;
        this.video_url = video_url;
    }

    public DataObject() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public meta_data getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(meta_data meta_data) {
        this.meta_data = meta_data;
    }

    public ArrayList<content_manager> getContent_manager() {
        return content_manager;
    }

    public void setContent_manager(ArrayList<content_manager> content_manager) {
        this.content_manager = content_manager;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getPeople_base_url() {
        return people_base_url;
    }

    public void setPeople_base_url(String people_base_url) {
        this.people_base_url = people_base_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}





