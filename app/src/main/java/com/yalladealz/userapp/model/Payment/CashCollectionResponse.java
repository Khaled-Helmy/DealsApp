package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CashCollectionResponse {

    private String detail;

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pending")
    @Expose
    private String pending;
    @SerializedName("amount_cents")
    @Expose
    private int amountCents;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("is_auth")
    @Expose
    private String isAuth;
    @SerializedName("is_capture")
    @Expose
    private String isCapture;
    @SerializedName("is_standalone_payment")
    @Expose
    private String isStandalonePayment;
    @SerializedName("is_voided")
    @Expose
    private String isVoided;
    @SerializedName("is_refunded")
    @Expose
    private String isRefunded;
    @SerializedName("is_3d_secure")
    @Expose
    private String is3dSecure;
    @SerializedName("integration_id")
    @Expose
    private int integrationId;
    @SerializedName("profile_id")
    @Expose
    private int profileId;
    @SerializedName("has_parent_transaction")
    @Expose
    private String hasParentTransaction;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("api_source")
    @Expose
    private String apiSource;
    @SerializedName("is_void")
    @Expose
    private String isVoid;
    @SerializedName("is_refund")
    @Expose
    private String isRefund;
    @SerializedName("error_occured")
    @Expose
    private String errorOccured;
    @SerializedName("refunded_amount_cents")
    @Expose
    private int refundedAmountCents;
    @SerializedName("captured_amount")
    @Expose
    private int capturedAmount;
    @SerializedName("merchant_staff_tag")
    @Expose
    private String merchantStaffTag;
    @SerializedName("owner")
    @Expose
    private int owner;
    @SerializedName("parent_transaction")
    @Expose
    private String parentTransaction;
    @SerializedName("data.message")
    @Expose
    private String dataMessage;
    @SerializedName("source_data.type")
    @Expose
    private String sourceDataType;
    @SerializedName("source_data.pan")
    @Expose
    private String sourceDataPan;
    @SerializedName("source_data.sub_type")
    @Expose
    private String sourceDataSubType;
    @SerializedName("hmac")
    @Expose
    private String hmac;
    @SerializedName("merchant_order_id")
    @Expose
    private String merchantOrderId;
    @SerializedName("use_redirection")
    @Expose
    private String useRedirection;
    @SerializedName("redirection_url")
    @Expose
    private String redirectionUrl;
    @SerializedName("merchant_response")
    @Expose
    private String merchantResponse;
    @SerializedName("bypass_step_six")
    @Expose
    private boolean bypassStepSix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public int getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(int amountCents) {
        this.amountCents = amountCents;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    public String getIsCapture() {
        return isCapture;
    }

    public void setIsCapture(String isCapture) {
        this.isCapture = isCapture;
    }

    public String getIsStandalonePayment() {
        return isStandalonePayment;
    }

    public void setIsStandalonePayment(String isStandalonePayment) {
        this.isStandalonePayment = isStandalonePayment;
    }

    public String getIsVoided() {
        return isVoided;
    }

    public void setIsVoided(String isVoided) {
        this.isVoided = isVoided;
    }

    public String getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(String isRefunded) {
        this.isRefunded = isRefunded;
    }

    public String getIs3dSecure() {
        return is3dSecure;
    }

    public void setIs3dSecure(String is3dSecure) {
        this.is3dSecure = is3dSecure;
    }

    public int getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(int integrationId) {
        this.integrationId = integrationId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getHasParentTransaction() {
        return hasParentTransaction;
    }

    public void setHasParentTransaction(String hasParentTransaction) {
        this.hasParentTransaction = hasParentTransaction;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public String getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(String isVoid) {
        this.isVoid = isVoid;
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    public String getErrorOccured() {
        return errorOccured;
    }

    public void setErrorOccured(String errorOccured) {
        this.errorOccured = errorOccured;
    }

    public int getRefundedAmountCents() {
        return refundedAmountCents;
    }

    public void setRefundedAmountCents(int refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
    }

    public int getCapturedAmount() {
        return capturedAmount;
    }

    public void setCapturedAmount(int capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    public String getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(String merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(String parentTransaction) {
        this.parentTransaction = parentTransaction;
    }

    public String getDataMessage() {
        return dataMessage;
    }

    public void setDataMessage(String dataMessage) {
        this.dataMessage = dataMessage;
    }

    public String getSourceDataType() {
        return sourceDataType;
    }

    public void setSourceDataType(String sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    public String getSourceDataPan() {
        return sourceDataPan;
    }

    public void setSourceDataPan(String sourceDataPan) {
        this.sourceDataPan = sourceDataPan;
    }

    public String getSourceDataSubType() {
        return sourceDataSubType;
    }

    public void setSourceDataSubType(String sourceDataSubType) {
        this.sourceDataSubType = sourceDataSubType;
    }

    public String getHmac() {
        return hmac;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getUseRedirection() {
        return useRedirection;
    }

    public void setUseRedirection(String useRedirection) {
        this.useRedirection = useRedirection;
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public void setRedirectionUrl(String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
    }

    public String getMerchantResponse() {
        return merchantResponse;
    }

    public void setMerchantResponse(String merchantResponse) {
        this.merchantResponse = merchantResponse;
    }

    public boolean getBypassStepSix() {
        return bypassStepSix;
    }

    public void setBypassStepSix(boolean bypassStepSix) {
        this.bypassStepSix = bypassStepSix;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
