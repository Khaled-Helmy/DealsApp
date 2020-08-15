
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class AdminData {

    @SerializedName("admin_id")
    private Long mAdminId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("full_name")
    private String mFullName;
    @SerializedName("image")
    private String mImage;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("permissions[]")
    private Object mPermissions;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("user_name")
    private String mUserName;

    public Long getAdminId() {
        return mAdminId;
    }

    public void setAdminId(Long adminId) {
        mAdminId = adminId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public Object getPermissions() {
        return mPermissions;
    }

    public void setPermissions(Object permissions) {
        mPermissions = permissions;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

}
