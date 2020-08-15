
package com.yalladealz.userapp.model.Payment;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FawryRequest {

    @SerializedName("merchantCode")
    @Expose
    private String merchantCode;
    @SerializedName("merchantRefNum")
    @Expose
    private String merchantRefNum;
    @SerializedName("customerProfileId")
    @Expose
    private String customerProfileId;
    @SerializedName("customerMobile")
    @Expose
    private String customerMobile;
    @SerializedName("customerEmail")
    @Expose
    private String customerEmail;
    @SerializedName("paymentMethod")
    @Expose
    private String paymentMethod;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("paymentExpiry")
    @Expose
    private String paymentExpiry;
    @SerializedName("chargeItems")
    @Expose
    private List<ChargeItem> chargeItems = null;
    @SerializedName("signature")
    @Expose
    private String signature;
    @SerializedName("cardToken")
    @Expose
    private String cardToken;

    public FawryRequest() {
    }

    /**
     * @param merchantCode
     * @param merchantRefNum
     * @param customerProfileId
     * @param customerMobile
     * @param customerEmail
     * @param paymentMethod
     * @param amount
     * @param currencyCode
     * @param description
     * @param paymentExpiry
     * @param chargeItems
     * @param signature
     */
    public FawryRequest(String merchantCode, String merchantRefNum, String customerProfileId, String customerMobile, String customerEmail, String paymentMethod, String amount, String currencyCode, String description, String paymentExpiry, List<ChargeItem> chargeItems, String cardToken, String signature) {
        this.merchantCode = merchantCode;
        this.merchantRefNum = merchantRefNum;
        this.customerProfileId = customerProfileId;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.description = description;
        this.paymentExpiry = paymentExpiry;
        this.chargeItems = chargeItems;
        this.signature = signature;
        this.cardToken = cardToken;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantRefNum() {
        return merchantRefNum;
    }

    public void setMerchantRefNum(String merchantRefNum) {
        this.merchantRefNum = merchantRefNum;
    }

    public String getCustomerProfileId() {
        return customerProfileId;
    }

    public void setCustomerProfileId(String customerProfileId) {
        this.customerProfileId = customerProfileId;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentExpiry() {
        return paymentExpiry;
    }

    public void setPaymentExpiry(String paymentExpiry) {
        this.paymentExpiry = paymentExpiry;
    }

    public List<ChargeItem> getChargeItems() {
        return chargeItems;
    }

    public void setChargeItems(List<ChargeItem> chargeItems) {
        this.chargeItems = chargeItems;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }
}
