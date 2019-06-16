package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class content_manager {
    @SerializedName("title")
    String title;
    @SerializedName("media_manager_id")
    String media_manager_id;
    @SerializedName("is_free")
    Boolean is_free;
    @SerializedName("_id")
    String _id;
    @SerializedName("display_order")
    int display_order;
    @SerializedName("schedule_date_time")
    String schedule_date_time;
    @SerializedName("short_desciption")
    String short_desciption;
    @SerializedName("srt")
    ArrayList<objec> srt;
    @SerializedName("video_transcode_profiles")
    VideoTranscodeProfiles videoTranscodeProfiles;

    public VideoTranscodeProfiles getVideoTranscodeProfiles() {
        return videoTranscodeProfiles;
    }

    public void setVideoTranscodeProfiles(VideoTranscodeProfiles videoTranscodeProfiles) {
        this.videoTranscodeProfiles = videoTranscodeProfiles;
    }

    private boolean expanded=false;

    public content_manager(String title, String media_manager_id, Boolean is_free, String _id, int display_order, String schedule_date_time, String short_desciption, ArrayList<objec> srt) {
        this.title = title;
        this.media_manager_id = media_manager_id;
        this.is_free = is_free;
        this._id = _id;
        this.display_order = display_order;
        this.schedule_date_time = schedule_date_time;
        this.short_desciption = short_desciption;
        this.srt = srt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_manager_id() {
        return media_manager_id;
    }

    public void setMedia_manager_id(String media_manager_id) {
        this.media_manager_id = media_manager_id;
    }

    public Boolean getIs_free() {
        return is_free;
    }

    public void setIs_free(Boolean is_free) {
        this.is_free = is_free;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(int display_order) {
        this.display_order = display_order;
    }

    public String getSchedule_date_time() {
        return schedule_date_time;
    }

    public void setSchedule_date_time(String schedule_date_time) {
        this.schedule_date_time = schedule_date_time;
    }

    public String getShort_desciption() {
        return short_desciption;
    }

    public void setShort_desciption(String short_desciption) {
        this.short_desciption = short_desciption;
    }

    public ArrayList<objec> getSrt() {
        return srt;
    }

    public void setSrt(ArrayList<objec> srt) {
        this.srt = srt;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}