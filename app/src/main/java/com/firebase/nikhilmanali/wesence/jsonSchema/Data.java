package com.firebase.nikhilmanali.wesence.jsonSchema;

/**
 * Created by Nikhil Manali on 7/30/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("feed")   // Getting the feed list
    @Expose
    private List<Feed> feed = null;

    @SerializedName("page") // Number of the current page
    @Expose
    private Integer page;

    @SerializedName("hasMore") // If there are more page or not
    @Expose
    private Boolean hasMore;

    public List<Feed> getFeed() {
        return feed;
    }

    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }



}