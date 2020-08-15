package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentProfile {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user")
    @Expose
    private PaymentUser user;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("profile_type")
    @Expose
    private String profileType;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("company_emails")
    @Expose
    private List<String> companyEmails = null;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("email_notification")
    @Expose
    private boolean emailNotification;
    @SerializedName("order_retrieval_endpoint")
    @Expose
    private Object orderRetrievalEndpoint;
    @SerializedName("delivery_update_endpoint")
    @Expose
    private Object deliveryUpdateEndpoint;
    @SerializedName("failed_attempts")
    @Expose
    private int failedAttempts;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("custom_export_columns")
    @Expose
    private List<Object> customExportColumns = null;
    @SerializedName("awb_banner")
    @Expose
    private Object awbBanner;
    @SerializedName("email_banner")
    @Expose
    private String emailBanner;
    @SerializedName("delivery_status_callback")
    @Expose
    private String deliveryStatusCallback;
    @SerializedName("merchant_external_link")
    @Expose
    private String merchantExternalLink;
    @SerializedName("is_live")
    @Expose
    private boolean isLive;
    @SerializedName("is_new_standalone_url")
    @Expose
    private boolean isNewStandaloneUrl;
    @SerializedName("sales_owner")
    @Expose
    private int salesOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentUser getUser() {
        return user;
    }

    public void setUser(PaymentUser user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getCompanyEmails() {
        return companyEmails;
    }

    public void setCompanyEmails(List<String> companyEmails) {
        this.companyEmails = companyEmails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public boolean getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Object getOrderRetrievalEndpoint() {
        return orderRetrievalEndpoint;
    }

    public void setOrderRetrievalEndpoint(Object orderRetrievalEndpoint) {
        this.orderRetrievalEndpoint = orderRetrievalEndpoint;
    }

    public Object getDeliveryUpdateEndpoint() {
        return deliveryUpdateEndpoint;
    }

    public void setDeliveryUpdateEndpoint(Object deliveryUpdateEndpoint) {
        this.deliveryUpdateEndpoint = deliveryUpdateEndpoint;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public List<Object> getCustomExportColumns() {
        return customExportColumns;
    }

    public void setCustomExportColumns(List<Object> customExportColumns) {
        this.customExportColumns = customExportColumns;
    }

    public Object getAwbBanner() {
        return awbBanner;
    }

    public void setAwbBanner(Object awbBanner) {
        this.awbBanner = awbBanner;
    }

    public String getEmailBanner() {
        return emailBanner;
    }

    public void setEmailBanner(String emailBanner) {
        this.emailBanner = emailBanner;
    }

    public String getDeliveryStatusCallback() {
        return deliveryStatusCallback;
    }

    public void setDeliveryStatusCallback(String deliveryStatusCallback) {
        this.deliveryStatusCallback = deliveryStatusCallback;
    }

    public String getMerchantExternalLink() {
        return merchantExternalLink;
    }

    public void setMerchantExternalLink(String merchantExternalLink) {
        this.merchantExternalLink = merchantExternalLink;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public boolean getIsNewStandaloneUrl() {
        return isNewStandaloneUrl;
    }

    public void setIsNewStandaloneUrl(boolean isNewStandaloneUrl) {
        this.isNewStandaloneUrl = isNewStandaloneUrl;
    }

    public int getSalesOwner() {
        return salesOwner;
    }

    public void setSalesOwner(int salesOwner) {
        this.salesOwner = salesOwner;
    }

}
