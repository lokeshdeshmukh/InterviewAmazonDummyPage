package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;

public class objec {
    @SerializedName("_id")
    String _id;
    @SerializedName("set_url")
    String srt_url;

    public objec(String _id, String srt_url) {
        this._id = _id;
        this.srt_url = srt_url;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSrt_url() {
        return srt_url;
    }

    public void setSrt_url(String srt_url) {
        this.srt_url = srt_url;
    }
}
