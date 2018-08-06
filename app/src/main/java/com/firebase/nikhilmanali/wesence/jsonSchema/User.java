package com.firebase.nikhilmanali.wesence.jsonSchema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikhil Manali on 7/30/2018.
 */

public class User {


    // Contains userDetails and available parameters.

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("center")
    @Expose
    private String center;
    @SerializedName("batch")
    @Expose
    private String batch;
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("active")
    @Expose
    private Boolean active;

    @SerializedName("mentor")
    @Expose
    private Boolean mentor;
    @SerializedName("follows")
    @Expose
    private List<String> follows = null;

    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("onBoarded")
    @Expose
    private Boolean onBoarded;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



}
