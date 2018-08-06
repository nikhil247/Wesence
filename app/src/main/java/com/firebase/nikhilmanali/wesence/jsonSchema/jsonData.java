package com.firebase.nikhilmanali.wesence.jsonSchema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Manali on 8/1/2018.
 */

public class jsonData {

    // Getting the JSON object from the API

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")  // Data of the API
    @Expose
    private Data data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
