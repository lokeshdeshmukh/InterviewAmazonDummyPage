package info.androidhive.retrofit.model.pojo;

import com.google.gson.annotations.SerializedName;


public class EpisodesResponse {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("data")
    private DataObject data;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;

    public EpisodesResponse(Boolean status, DataObject data, int statusCode, String message) {
        this.status = status;
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
