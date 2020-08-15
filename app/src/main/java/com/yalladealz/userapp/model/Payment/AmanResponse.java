package com.yalladealz.userapp.model.Payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmanResponse {

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
    private SourceData sourceData;
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
    private AmanData data;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("payment_key_claims")
    @Expose
    private PaymentKeyClaims paymentKeyClaims;
    @SerializedName("error_occured")
    @Expose
    private Boolean errorOccured;
    @SerializedName("is_live")
    @Expose
    private Boolean isLive;
    @SerializedName("other_endpoint_reference")
    @Expose
    private Object otherEndpointReference;
    @SerializedName("refunded_amount_cents")
    @Expose
    private Integer refundedAmountCents;
    @SerializedName("source_id")
    @Expose
    private Integer sourceId;
    @SerializedName("is_captured")
    @Expose
    private Boolean isCaptured;
    @SerializedName("captured_amount")
    @Expose
    private Integer capturedAmount;
    @SerializedName("merchant_staff_tag")
    @Expose
    private Object merchantStaffTag;
    @SerializedName("owner")
    @Expose
    private Integer owner;
    @SerializedName("parent_transaction")
    @Expose
    private Object parentTransaction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Integer getAmountCents() {
        return amountCents;
    }

    public void setAmountCents(Integer amountCents) {
        this.amountCents = amountCents;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public Boolean getIsCapture() {
        return isCapture;
    }

    public void setIsCapture(Boolean isCapture) {
        this.isCapture = isCapture;
    }

    public Boolean getIsStandalonePayment() {
        return isStandalonePayment;
    }

    public void setIsStandalonePayment(Boolean isStandalonePayment) {
        this.isStandalonePayment = isStandalonePayment;
    }

    public Boolean getIsVoided() {
        return isVoided;
    }

    public void setIsVoided(Boolean isVoided) {
        this.isVoided = isVoided;
    }

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    public Boolean getIs3dSecure() {
        return is3dSecure;
    }

    public void setIs3dSecure(Boolean is3dSecure) {
        this.is3dSecure = is3dSecure;
    }

    public Integer getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(Integer integrationId) {
        this.integrationId = integrationId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Boolean getHasParentTransaction() {
        return hasParentTransaction;
    }

    public void setHasParentTransaction(Boolean hasParentTransaction) {
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

    public SourceData getSourceData() {
        return sourceData;
    }

    public void setSourceData(SourceData sourceData) {
        this.sourceData = sourceData;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public Boolean getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(Boolean isVoid) {
        this.isVoid = isVoid;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public AmanData getData() {
        return data;
    }

    public void setData(AmanData data) {
        this.data = data;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public PaymentKeyClaims getPaymentKeyClaims() {
        return paymentKeyClaims;
    }

    public void setPaymentKeyClaims(PaymentKeyClaims paymentKeyClaims) {
        this.paymentKeyClaims = paymentKeyClaims;
    }

    public Boolean getErrorOccured() {
        return errorOccured;
    }

    public void setErrorOccured(Boolean errorOccured) {
        this.errorOccured = errorOccured;
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public Object getOtherEndpointReference() {
        return otherEndpointReference;
    }

    public void setOtherEndpointReference(Object otherEndpointReference) {
        this.otherEndpointReference = otherEndpointReference;
    }

    public Integer getRefundedAmountCents() {
        return refundedAmountCents;
    }

    public void setRefundedAmountCents(Integer refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Boolean getIsCaptured() {
        return isCaptured;
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public Integer getCapturedAmount() {
        return capturedAmount;
    }

    public void setCapturedAmount(Integer capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    public Object getMerchantStaffTag() {
        return merchantStaffTag;
    }

    public void setMerchantStaffTag(Object merchantStaffTag) {
        this.merchantStaffTag = merchantStaffTag;
    }

    public Integer getOwner() {
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    class SourceData {

        private String sub_type;
        private String type;
        private String pan;

        public String getSub_type() {
            return sub_type;
        }

        public void setSub_type(String sub_type) {
            this.sub_type = sub_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPan() {
            return pan;
        }

        public void setPan(String pan) {
            this.pan = pan;
        }
    }

    public class AmanData {
        @SerializedName("rrn")
        @Expose
        private Object rrn;
        @SerializedName("biller")
        @Expose
        private Object biller;
        @SerializedName("txn_response_code")
        @Expose
        private String txnResponseCode;
        @SerializedName("paid_through")
        @Expose
        private String paidThrough;
        @SerializedName("due_amount")
        @Expose
        private Integer dueAmount;
        @SerializedName("amount")
        @Expose
        private Object amount;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("gateway_integration_pk")
        @Expose
        private Integer gatewayIntegrationPk;
        @SerializedName("agg_terminal")
        @Expose
        private Object aggTerminal;
        @SerializedName("ref")
        @Expose
        private Object ref;
        @SerializedName("klass")
        @Expose
        private String klass;
        @SerializedName("from_user")
        @Expose
        private Object fromUser;
        @SerializedName("bill_reference")
        @Expose
        private int billReference;

        public Object getRrn() {
            return rrn;
        }

        public void setRrn(Object rrn) {
            this.rrn = rrn;
        }

        public Object getBiller() {
            return biller;
        }

        public void setBiller(Object biller) {
            this.biller = biller;
        }

        public String getTxnResponseCode() {
            return txnResponseCode;
        }

        public void setTxnResponseCode(String txnResponseCode) {
            this.txnResponseCode = txnResponseCode;
        }

        public String getPaidThrough() {
            return paidThrough;
        }

        public void setPaidThrough(String paidThrough) {
            this.paidThrough = paidThrough;
        }

        public Integer getDueAmount() {
            return dueAmount;
        }

        public void setDueAmount(Integer dueAmount) {
            this.dueAmount = dueAmount;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getGatewayIntegrationPk() {
            return gatewayIntegrationPk;
        }

        public void setGatewayIntegrationPk(Integer gatewayIntegrationPk) {
            this.gatewayIntegrationPk = gatewayIntegrationPk;
        }

        public Object getAggTerminal() {
            return aggTerminal;
        }

        public void setAggTerminal(Object aggTerminal) {
            this.aggTerminal = aggTerminal;
        }

        public Object getRef() {
            return ref;
        }

        public void setRef(Object ref) {
            this.ref = ref;
        }

        public String getKlass() {
            return klass;
        }

        public void setKlass(String klass) {
            this.klass = klass;
        }

        public Object getFromUser() {
            return fromUser;
        }

        public void setFromUser(Object fromUser) {
            this.fromUser = fromUser;
        }

        public int getBillReference() {
            return billReference;
        }

        public void setBillReference(int billReference) {
            this.billReference = billReference;
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

        public void setBuildingData(BuildingData buildingData) {
            this.buildingData = buildingData;
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

        public void setOrderId(int orderId) {
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

        public int getAmountCents() {
            return amountCents;
        }

        public void setAmountCents(int amountCents) {
            this.amountCents = amountCents;
        }

    }

}
