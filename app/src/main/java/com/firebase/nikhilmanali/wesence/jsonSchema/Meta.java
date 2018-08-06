package com.firebase.nikhilmanali.wesence.jsonSchema;

/**
 * Created by Nikhil Manali on 7/30/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    // Contains comment count , views count and rection count parameters.


    @SerializedName("commentCount")
    @Expose
    private Integer commentCount;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("reactionCount")
    @Expose
    private Integer reactionCount;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getReactionCount() {
        return reactionCount;
    }

    public void setReactionCount(Integer reactionCount) {
        this.reactionCount = reactionCount;
    }
}
