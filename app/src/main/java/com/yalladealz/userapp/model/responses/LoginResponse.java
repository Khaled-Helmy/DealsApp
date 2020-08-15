
package com.yalladealz.userapp.model.responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("error")
    private Long mError;

    @SerializedName("login")
    private Boolean mLogin;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("user_info")
    private UserInfo mUserInfo;

    @SerializedName("sginUpUserInfo")
    private SginUpUserInfo sginUpUserInfo;

    public SginUpUserInfo getSginUpUserInfo() {
        return sginUpUserInfo;
    }

    public void setSginUpUserInfo(SginUpUserInfo sginUpUserInfo) {
        this.sginUpUserInfo = sginUpUserInfo;
    }



    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }


    public Boolean getLogin() { return mLogin; }

    public void setLogin(Boolean login) {
        mLogin = login;
    }


    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

       public class SginUpUserInfo{
           @SerializedName("firstName")
           private String FirstName;

           @SerializedName("lastName")
           private String LastName;

           @SerializedName("password")
           private String password;

           @SerializedName("phone")
           private String Mobile;

           @SerializedName("email")
           private String Email;

           @SerializedName("Massage")
           private String Massage;

           public String getMassage() {
               return Massage;
           }

           public void setMassage(String massage) {
               Massage = massage;
           }



           public String getEmail() {
               return Email;
           }

           public void setEmail(String email) {
               Email = email;
           }

           public String getFirstName() {
               return FirstName;
           }

           public void setFirstName(String firstName) {
               FirstName = firstName;
           }

           public String getLastName() {
               return LastName;
           }

           public void setLastName(String lastName) {
               LastName = lastName;
           }

           public String getMobile() {
               return Mobile;
           }

           public void setMobile(String mobile) {
               Mobile = mobile;
           }

           public String getPassword() {
               return password;
           }

           public void setPassword(String password) {
               this.password = password;
           }

    }

    public class UserInfo {

        @SerializedName("app_hash")
        private String mAppHash;
        @SerializedName("created_at")
        private String mCreatedAt;
        @SerializedName("date_of_birth")
        private String mDateOfBirth;
        @SerializedName("email")
        private String mEmail;
        @SerializedName("email_active")
        private String mEmailActive;
        @SerializedName("email_active_code")
        private String mEmailActiveCode;
        @SerializedName("first_name")
        private String mFirstName;
        @SerializedName("gender")
        private String mGender;
        @SerializedName("is_affiliate")
        private String mIsAffiliate;
        @SerializedName("last_name")
        private String mLastName;
        @SerializedName("mobile")
        private String mMobile;
        @SerializedName("mobile_active")
        private String mMobileActive;
        @SerializedName("mobile_active_code")
        private String mMobileActiveCode;
        @SerializedName("rest_password_code")
        private String mRestPasswordCode;
        @SerializedName("status")
        private String mStatus;
        @SerializedName("updated_at")
        private String mUpdatedAt;
        @SerializedName("UserAddress")
        private Object mUserAddress;
        @SerializedName("user_id")
        private Long mUserId;
        @SerializedName("UserLog")
        private Object mUserLog;
        @SerializedName("wallet_amount")
        private String mWalletAmount;



        @SerializedName("password")
        private int mpassword;


        public int getMpassword() {
            return mpassword;
        }

        public void setMpassword(int mpassword) {
            this.mpassword = mpassword;
        }

        public String getAppHash() {
            return mAppHash;
        }

        public void setAppHash(String appHash) {
            mAppHash = appHash;
        }

        public String getCreatedAt() {
            return mCreatedAt;
        }

        public void setCreatedAt(String createdAt) {
            mCreatedAt = createdAt;
        }

        public String getDateOfBirth() {
            return mDateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            mDateOfBirth = dateOfBirth;
        }

        public String getEmail() {
            return mEmail;
        }

        public void setEmail(String email) {
            mEmail = email;
        }

        public String getEmailActive() {
            return mEmailActive;
        }

        public void setEmailActive(String emailActive) {
            mEmailActive = emailActive;
        }

        public String getEmailActiveCode() {
            return mEmailActiveCode;
        }

        public void setEmailActiveCode(String emailActiveCode) {
            mEmailActiveCode = emailActiveCode;
        }

        public String getFirstName() {
            return mFirstName;
        }

        public void setFirstName(String firstName) {
            mFirstName = firstName;
        }

        public String getGender() {
            return mGender;
        }

        public void setGender(String gender) {
            mGender = gender;
        }

        public String getIsAffiliate() {
            return mIsAffiliate;
        }

        public void setIsAffiliate(String isAffiliate) {
            mIsAffiliate = isAffiliate;
        }

        public String getLastName() {
            return mLastName;
        }

        public void setLastName(String lastName) {
            mLastName = lastName;
        }

        public String getMobile() {
            return mMobile;
        }

        public void setMobile(String mobile) {
            mMobile = mobile;
        }

        public String getMobileActive() {
            return mMobileActive;
        }

        public void setMobileActive(String mobileActive) {
            mMobileActive = mobileActive;
        }

        public String getMobileActiveCode() {
            return mMobileActiveCode;
        }

        public void setMobileActiveCode(String mobileActiveCode) {
            mMobileActiveCode = mobileActiveCode;
        }

        public String getRestPasswordCode() {
            return mRestPasswordCode;
        }

        public void setRestPasswordCode(String restPasswordCode) {
            mRestPasswordCode = restPasswordCode;
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

        public Object getUserAddress() {
            return mUserAddress;
        }

        public void setUserAddress(Object userAddress) {
            mUserAddress = userAddress;
        }

        public Long getUserId() {
            return mUserId;
        }

        public void setUserId(Long userId) {
            mUserId = userId;
        }

        public Object getUserLog() {
            return mUserLog;
        }

        public void setUserLog(Object userLog) {
            mUserLog = userLog;
        }

        public String getWalletAmount() {
            return mWalletAmount;
        }

        public void setWalletAmount(String walletAmount) {
            mWalletAmount = walletAmount;
        }

    }
}


