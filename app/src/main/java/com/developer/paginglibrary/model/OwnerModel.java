package com.developer.paginglibrary.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OwnerModel implements Serializable {
    @SerializedName("link")
    private String link;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("accept_rate")
    private int acceptRate;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("reputation")
    private int reputation;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(int acceptRate) {
        this.acceptRate = acceptRate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
