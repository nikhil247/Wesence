package com.firebase.nikhilmanali.wesence.jsonSchema;

/**
 * Created by Nikhil Manali on 7/30/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {


// Calling the comment section in the feeds from the API

    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("user")
    @Expose
    private user_detail_comment user;


    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public user_detail_comment getUserComment() {
        return user;
    }

    public void setUserComment(user_detail_comment user) {
        this.user = user;
    }

}