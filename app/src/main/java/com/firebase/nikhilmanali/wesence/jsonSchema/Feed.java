package com.firebase.nikhilmanali.wesence.jsonSchema;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed {

    // Getting feed from the API
    // Used Notation
   // Available parameters from Feed list

    @SerializedName("comments") // comment list
    @Expose
    private List<Comment> comments = null;

    @SerializedName("name") // name of the user which contain the First ,Last and full name
    @Expose
    private String name;

    @SerializedName("meta")  // It contains the meta data : number of page, number of reaction and number of comments
    @Expose
    private Meta meta;


    @SerializedName("user") // User details
    @Expose
    private User user;



    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    // Not used notation

   /* @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("unfamedBy")
    @Expose
    private Object unfamedBy;
    @SerializedName("unfameReason")
    @Expose
    private String unfameReason;
    @SerializedName("wallOfFamedBy")
    @Expose
    private String wallOfFamedBy;
    @SerializedName("wallOfFameReason")
    @Expose
    private String wallOfFameReason;
    @SerializedName("wallOfFame")
    @Expose
    private Boolean wallOfFame;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    @SerializedName("sillyVideo")
    @Expose
    private Boolean sillyVideo;
    @SerializedName("views")
    @Expose
    private List<View> views = null;
    @SerializedName("reactions")
    @Expose
    private Reactions reactions;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    @SerializedName("challenge")
    @Expose
    private Challenge challenge;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("coverImageType")
    @Expose
    private String coverImageType;
    @SerializedName("coverImageUrl")
    @Expose
    private String coverImageUrl;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("itemType")
    @Expose
    private String itemType;
*/

}