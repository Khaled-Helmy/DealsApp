
package com.yalladealz.userapp.model.History;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HistoryResponse {

    @SerializedName("deal")
    private List<Deal> mDeal;
    @SerializedName("error")
    private Long mError;

    public List<Deal> getDeal() {
        return mDeal;
    }

    public void setDeal(List<Deal> deal) {
        mDeal = deal;
    }

    public Long getError() {
        return mError;
    }

    public void setError(Long error) {
        mError = error;
    }

}
