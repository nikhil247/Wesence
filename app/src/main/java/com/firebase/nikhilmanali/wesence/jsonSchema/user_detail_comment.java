package com.firebase.nikhilmanali.wesence.jsonSchema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Manali on 7/30/2018.
 */

public class user_detail_comment {


// This contains the users details who commented on the post.

    @SerializedName("name")
    @Expose
    private name_detail_comment name;

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getVideoUrlComment() {
        return videoUrl;
    }

    public void setVideoUrlComment(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }



    public name_detail_comment getNameComment() {
        return name;
    }

    public void setNameComment(name_detail_comment name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
