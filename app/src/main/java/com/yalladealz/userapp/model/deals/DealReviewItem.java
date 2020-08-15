package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class DealReviewItem {

    @SerializedName("review_id")
    private int reviewId;

    @SerializedName("User")
    private User user;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("rate")
    private int rate;

    @SerializedName("total_review")
    private String totalReview;

    @SerializedName("review_comment")
    private String reviewComment;

    @SerializedName("deal_id")
    private int dealId;

    @SerializedName("Deal")
    private Deal deal;

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setTotalReview(String totalReview) {
        this.totalReview = totalReview;
    }

    public String getTotalReview() {
        return totalReview;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Deal getDeal() {
        return deal;
    }

    @Override
    public String toString() {
        return
                "DealReviewItem{" +
                        "review_id = '" + reviewId + '\'' +
                        ",user = '" + user + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",rate = '" + rate + '\'' +
                        ",total_review = '" + totalReview + '\'' +
                        ",review_comment = '" + reviewComment + '\'' +
                        ",deal_id = '" + dealId + '\'' +
                        ",deal = '" + deal + '\'' +
                        "}";
    }
}