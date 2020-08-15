package com.yalladealz.userapp.remote;

import android.util.Log;

import com.google.gson.JsonObject;
import com.yalladealz.userapp.model.CashCollection;
import com.yalladealz.userapp.model.History.HistoryResponse;
import com.yalladealz.userapp.model.Payment.AmanResponse;
import com.yalladealz.userapp.model.Payment.CardResponse;
import com.yalladealz.userapp.model.Payment.CashCollectionResponse;
import com.yalladealz.userapp.model.Payment.FawryRequest;
import com.yalladealz.userapp.model.Payment.FawryResponse;
import com.yalladealz.userapp.model.Payment.FawryStatusResponse;
import com.yalladealz.userapp.model.Payment.OrderResponse;
import com.yalladealz.userapp.model.Payment.PaymentKeyResponse;
import com.yalladealz.userapp.model.Payment.TokenResponse;
import com.yalladealz.userapp.model.Payment.VisaRequest;
import com.yalladealz.userapp.model.Payment.VisaResponse;
import com.yalladealz.userapp.model.Payment.WalletResponse;
import com.yalladealz.userapp.model.responses.Address;
import com.yalladealz.userapp.model.responses.BestDealsResponse;
import com.yalladealz.userapp.model.responses.BestReviewsResponse;
import com.yalladealz.userapp.model.responses.BranchDealsResponse;
import com.yalladealz.userapp.model.responses.BranchLocationResponse;
import com.yalladealz.userapp.model.responses.CategoriesResponse;
import com.yalladealz.userapp.model.responses.CategoryDealsResponse;
import com.yalladealz.userapp.model.responses.CouponResponse;
import com.yalladealz.userapp.model.responses.DealResponse;
import com.yalladealz.userapp.model.responses.LoginResponse;
import com.yalladealz.userapp.model.responses.LowBranchDealResponse;
import com.yalladealz.userapp.model.responses.MobileVerificationResponse;
import com.yalladealz.userapp.model.responses.NewDealsResponse;
import com.yalladealz.userapp.model.responses.PhotoResponse;
import com.yalladealz.userapp.model.responses.SginUpUserInfo;
import com.yalladealz.userapp.model.responses.UserAddressesResponse;
import com.yalladealz.userapp.model.responses.UserInfo;
import com.yalladealz.userapp.model.responses.check.CheckAddAddress;
import com.yalladealz.userapp.model.responses.check.CheckDeleteAddress;
import com.yalladealz.userapp.model.responses.check.CheckEditAddress;
import com.yalladealz.userapp.model.search.SearchResponse;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("api/user/login")
    Call<LoginResponse> loginFlied(@Body SginUpUserInfo info);


    @Headers("Content-Type: application/json")
    @POST("api/user/signup")
    Call<LoginResponse> register(@Body SginUpUserInfo info);


    @Headers("Content-Type: application/json")
    @POST("api/user/forgotPassword")
    Call<LoginResponse> forgetPassword(
            @Body SginUpUserInfo info);

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("api/user/login")
    Call<LoginResponse> loginMobile(
            @Field("mobile") String mobile,
            @Field("password") String password);




    @Multipart
    @POST("/update")
    Call<PhotoResponse> updatePhoto(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password);




    @POST("webapi/?username=PDYDKE99&password=0TtG8bQAma&language=1&sender=YallaDealz")
    Call<MobileVerificationResponse> verify(@Query("mobile") Long mobile,
                                            @Query("message") String message);

    @POST("/edit-profile")
    Call<LoginResponse> updateUser(
            @Body UserInfo info);

    @GET("/addresses")
    Call<UserAddressesResponse> getAddresses(
            @Query("user_id") Long id,
            @Query("hash") String hash
    );

    @POST("/address")
    Call<CheckAddAddress> addAddress(
            @Body Address address);

    @PUT("/address")
    Call<CheckEditAddress> editAddress(
            @Body Address address);

    @DELETE("/address")
    Call<CheckDeleteAddress> deleteAddress(
            @Query("user_id") Long user_id,
            @Query("hash") String hash,
            @Query("address_id") Long address_id
    );

    @GET("/my-deals")
    Call<HistoryResponse> getHistory(
            @Query("user_id") Long id,
            @Query("hash") String hash
    );

    @GET("/best-deals")
    Call<BestDealsResponse> getBestDeals(
            @Query("page") int page);

    @GET("/best-reviews")
    Call<BestReviewsResponse> getBestReviews(
            @Query("page") int page);

    @GET("/new-deals")
    Call<NewDealsResponse> getNewsDeals(
            @Query("page") int page);

    @GET("/categories")
    Call<CategoriesResponse> getCategories();

    @GET("/category")
    Call<CategoryDealsResponse> getCategoryDeals(
            @Query("category_id") String category_id,
            @Query("page") int page);

    @GET("/sub-categories")
    Call<CategoriesResponse> getSubCategories(
            @Query("category_id") String category_id);

    //locations array (no category)
    @GET("/branches/locations")
    Call<BranchLocationResponse> getBranches(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("distance") int distance);

    //deals-short for current model
    //deals for more info
    // TODO: 30/09/19 test
    @GET("/branches/{id}/deals-short")
    Call<BranchDealsResponse> getBranchDeals(
            @Path("id") String id);

    //
    @GET("/branches/locations/deals/low")
    Call<LowBranchDealResponse> getLowestBranch(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("distance") int distance);

    @GET("/search")
    Call<SearchResponse> search(@Query("category_id")
                                        String id,
                                @Query("deal_name")
                                        String query,
                                @Query("page")
                                        int page,
                                @Query("sort") String sort,
                                @Query("types") String types,
                                @Query("price") String price);

    @GET("/deal")
    Call<DealResponse> getDeal(@Query("deal_id")
                                       int deal_id,
                               @Query("option_id") int option_id);


    @FormUrlEncoded
    @POST("/user-addresses")
    Call<UserAddressesResponse> getUserAddresses(
            @Field("user_id") String user_id,
            @Field("hash") String hash);

    @POST("/cash-on-delivery")
    Call<CashCollectionResponse> useCashCollection(
            @Body CashCollection collection);

    @Headers("Content-Type: application/json")
    @POST("/api/auth/tokens")
    Call<TokenResponse> getVisaToken(
            @Body JsonObject key);

    @Headers("Content-Type: application/json")
    @POST("/api/ecommerce/orders")
    Call<OrderResponse> registerPaymentOrder(@Body JsonObject order);

    @Headers("Content-Type: application/json")
    @POST("/api/acceptance/payment_keys")
    Call<PaymentKeyResponse> getPaymentKey(@Body JsonObject details);

    @Headers("Content-Type: application/json")
    @POST("/api/acceptance/payments/pay")
    Call<AmanResponse> payWithAman(@Body JsonObject data);

    @Headers("Content-Type: application/json")
    @POST("/api/acceptance/payments/pay")
    Call<CashCollectionResponse> payWithCashCollection(@Body JsonObject data);

    @Headers("Content-Type: application/json")
    @POST("/api/acceptance/payments/pay")
    Call<WalletResponse> payWithWallet(@Body JsonObject data);

    @GET("/coupons")
    Call<CouponResponse> getCoupons(@Query("user_id") String user_id,
                                    @Query("hash") String hash,
                                    @Query("deal_id") String deal_id);


	@Headers("Content-Type: application/json")
	@POST("payments/charge")
	Call<FawryResponse> payWithFawry(@Body FawryRequest fawryRequest);

    @Headers("Content-Type: application/json")
    @POST("payments/charge")
    Call<CardResponse> payWithVisa(@Body FawryRequest fawryRequest);

	@GET("payments/status")
    Call<FawryStatusResponse> getFawryStatus(@QueryMap(encoded = true) String merchantCode,
                                             @Query("merchantRefNumber") String merchantRefNum,
                                             @Query("signature") String signature);

	@Headers("Content-Type: application/json")
	@POST("cards/cardToken")
    Call<VisaResponse> getVisaToken(@Body VisaRequest visaRequest);

	@GET("payments/merchatCallbakPage")
    Call<ResponseBody> getFawryCallback(@Query("MerchantRefNo") String merchantRef,
                                        @Query("FawryRefNo") String fawryRef,
                                        @Query("OrderStatus") String orderStatus,
                                        @Query("Amount") String amount,
                                        @Query("MessageSignature") String signature);
}