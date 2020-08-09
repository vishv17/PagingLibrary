package com.developer.paginglibrary.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StackApiResponse implements Serializable
{
    List<ItemModel> items;
    @SerializedName("has_more")
    Boolean hasMore;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
