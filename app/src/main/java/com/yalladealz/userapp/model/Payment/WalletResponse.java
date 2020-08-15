package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WalletResponse {

    private String detail;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("pending")
    @Expose
    private boolean pending;
    @SerializedName("amount_cents")
    @Expose
    private int amountCents;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("is_auth")
    @Expose
    private boolean isAuth;
    @SerializedName("is_capture")
    @Expose
    private boolean isCapture;
    @SerializedName("is_standalone_payment")
    @Expose
    private boolean isStandalonePayment;
    @SerializedName("is_voided")
    @Expose
    private boolean isVoided;
    @SerializedName("is_refunded")
    @Expose
    private boolean isRefunded;
    @SerializedName("is_3d_secure")
    @Expose
    private boolean is3dSecure;
    @SerializedName("integration_id")
    @Expose
    private int integrationId;
    @SerializedName("profile_id")
    @Expose
    private int profileId;
    @SerializedName("has_parent_transaction")
    @Expose
    private boolean hasParentTransaction;
    @SerializedName("order")
    @Expose
    private OrderResponse order;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("transaction_processed_callback_responses")
    @Expose
    private List<Object> transactionProcessedCallbackResponses = null;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("source_data")
    @Expose
    private WalletResponseSource sourceData;
    @SerializedName("api_source")
    @Expose
    private String apiSource;
    @SerializedName("is_void")
    @Expose
    private boolean isVoid;
    @SerializedName("is_refund")
    @Expose
    private boolean isRefund;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("payment_key_claims")
    @Expose
    private PaymentKeyClaims paymentKeyClaims;
    @SerializedName("error_occured")
    @Expose
    private boolean errorOccured;
    @SerializedName("is_live")
    @Expose
    private boolean isLive;
    @SerializedName("other_endpoint_reference")
    @Expose
    private Object otherEndpointReference;
    @SerializedName("refunded_amount_cents")
    @Expose
    private int refundedAmountCents;
    @SerializedName("source_id")
    @Expose
    private int sourceId;
    @SerializedName("is_captured")
    @Expose
    private boolean isCaptured;
    @SerializedName("captured_amount")
    @Expose
    private int capturedAmount;
    @SerializedName("merchant_staff_tag")
    @Expose
    private Object merchantStaffTag;
    @SerializedName("owner")
    @Expose
    private int owner;
    @SerializedName("parent_transaction")
    @Expose
    private Object parentTransaction;
    @SerializedName("redirect_url")
    @Expose
    private String redirectUrl;
    @SerializedName("iframe_redirection_url")
    @Expose
    private String iframeRedirectionUrl;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public int getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(int amountCents) {
        this.amountCents = amountCents;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(boolean isAuth) {
        this.isAuth = isAuth;
    }

    public boolean getIsCapture() {
        return isCapture;
    }

    public void setIsCapture(boolean isCapture) {
        this.isCapture = isCapture;
    }

    public boolean getIsStandalonePayment() {
        return isStandalonePayment;
    }

    public void setIsStandalonePayment(boolean isStandalonePayment) {
        this.isStandalonePayment = isStandalonePayment;
    }

    public boolean getIsVoided() {
        return isVoided;
    }

    public void setIsVoided(boolean isVoided) {
        this.isVoided = isVoided;
    }

    public boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    public boolean getIs3dSecure() {
        return is3dSecure;
    }

    public void setIs3dSecure(boolean is3dSecure) {
        this.is3dSecure = is3dSecure;
    }

    public Integer getIntegrationId() {
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

    public boolean getHasParentTransaction() {
        return hasParentTransaction;
    }

    public void setHasParentTransaction(boolean hasParentTransaction) {
        this.hasParentTransaction = hasParentTransaction;
    }

    public OrderResponse getOrder() {
        return order;
    }

    public void setOrder(OrderResponse order) {
        this.order = order;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Object> getTransactionProcessedCallbackResponses() {
        return transactionProcessedCallbackResponses;
    }

    public void setTransactionProcessedCallbackResponses(List<Object> transactionProcessedCallbackResponses) {
        this.transactionProcessedCallbackResponses = transactionProcessedCallbackResponses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public WalletResponseSource getSourceData() {
        return sourceData;
    }

    public void setSourceData(WalletResponseSource sourceData) {
        this.sourceData = sourceData;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public boolean getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(boolean isVoid) {
        this.isVoid = isVoid;
    }

    public boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(boolean isRefund) {
        this.isRefund = isRefund;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public PaymentKeyClaims getPaymentKeyClaims() {
        return paymentKeyClaims;
    }

    public void setPaymentKeyClaims(PaymentKeyClaims paymentKeyClaims) {
        this.paymentKeyClaims = paymentKeyClaims;
    }

    public boolean getErrorOccured() {
        return errorOccured;
    }

    public void setErrorOccured(boolean errorOccured) {
        this.errorOccured = errorOccured;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public Object getOtherEndpointReference() {
        return otherEndpointReference;
    }

    public void setOtherEndpointReference(Object otherEndpointReference) {
        this.otherEndpointReference = otherEndpointReference;
    }

    public int getRefundedAmountCents() {
        return refundedAmountCents;
    }

    public void setRefundedAmountCents(int refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public boolean getIsCaptured() {
        return isCaptured;
    }

    public void setIsCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public int getCapturedAmount() {
        return capturedAmount;
    }

    public void setCapturedAmount(int capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Object getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(Object parentTransaction) {
        this.parentTransaction = parentTransaction;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getIframeRedirectionUrl() {
        return iframeRedirectionUrl;
    }

    public void setIframeRedirectionUrl(String iframeRedirectionUrl) {
        this.iframeRedirectionUrl = iframeRedirectionUrl;
    }

    class Data {

        @SerializedName("wallet_issuer")
        @Expose
        private String walletIssuer;
        @SerializedName("mer_txn_ref")
        @Expose
        private String merTxnRef;
        @SerializedName("redirect_url")
        @Expose
        private String redirectUrl;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("txn_response_code")
        @Expose
        private String txnResponseCode;
        @SerializedName("order_info")
        @Expose
        private String orderInfo;
        @SerializedName("wallet_msisdn")
        @Expose
        private String walletMsisdn;
        @SerializedName("amount")
        @Expose
        private Integer amount;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("gateway_integration_pk")
        @Expose
        private Integer gatewayIntegrationPk;
        @SerializedName("klass")
        @Expose
        private String klass;
        @SerializedName("uig_txn_id")
        @Expose
        private String uigTxnId;
        @SerializedName("mpg_txn_id")
        @Expose
        private String mpgTxnId;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getWalletIssuer() {
            return walletIssuer;
        }

        public void setWalletIssuer(String walletIssuer) {
            this.walletIssuer = walletIssuer;
        }

        public String getMerTxnRef() {
            return merTxnRef;
        }

        public void setMerTxnRef(String merTxnRef) {
            this.merTxnRef = merTxnRef;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTxnResponseCode() {
            return txnResponseCode;
        }

        public void setTxnResponseCode(String txnResponseCode) {
            this.txnResponseCode = txnResponseCode;
        }

        public String getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(String orderInfo) {
            this.orderInfo = orderInfo;
        }

        public String getWalletMsisdn() {
            return walletMsisdn;
        }

        public void setWalletMsisdn(String walletMsisdn) {
            this.walletMsisdn = walletMsisdn;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getGatewayIntegrationPk() {
            return gatewayIntegrationPk;
        }

        public void setGatewayIntegrationPk(Integer gatewayIntegrationPk) {
            this.gatewayIntegrationPk = gatewayIntegrationPk;
        }

        public String getKlass() {
            return klass;
        }

        public void setKlass(String klass) {
            this.klass = klass;
        }

        public String getUigTxnId() {
            return uigTxnId;
        }

        public void setUigTxnId(String uigTxnId) {
            this.uigTxnId = uigTxnId;
        }

        public String getMpgTxnId() {
            return mpgTxnId;
        }

        public void setMpgTxnId(String mpgTxnId) {
            this.mpgTxnId = mpgTxnId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    class PaymentKeyClaims{

        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("billing_data")
        @Expose
        private BuildingData buildingData;
        @SerializedName("exp")
        @Expose
        private Integer exp;
        @SerializedName("integration_id")
        @Expose
        private Integer integrationId;
        @SerializedName("order_id")
        @Expose
        private Integer orderId;
        @SerializedName("pmk_ip")
        @Expose
        private String pmkIp;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("lock_order_when_paid")
        @Expose
        private Boolean lockOrderWhenPaid;
        @SerializedName("amount_cents")
        @Expose
        private Integer amountCents;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public BuildingData getBuildingData() {
            return buildingData;
        }

        public void setBillingData(BuildingData billingData) {
            this.buildingData = billingData;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public int getIntegrationId() {
            return integrationId;
        }

        public void setIntegrationId(int integrationId) {
            this.integrationId = integrationId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public String getPmkIp() {
            return pmkIp;
        }

        public void setPmkIp(String pmkIp) {
            this.pmkIp = pmkIp;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public boolean getLockOrderWhenPaid() {
            return lockOrderWhenPaid;
        }

        public void setLockOrderWhenPaid(boolean lockOrderWhenPaid) {
            this.lockOrderWhenPaid = lockOrderWhenPaid;
        }

        public Integer getAmountCents() {
            return amountCents;
        }

        public void setAmountCents(Integer amountCents) {
            this.amountCents = amountCents;
        }

    }
}
