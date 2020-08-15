
package com.yalladealz.userapp.model.History;

import com.google.gson.annotations.SerializedName;

public class DealFile {

    @SerializedName("deal_id")
    private Long mDealId;
    @SerializedName("file_name")
    private String mFileName;
    @SerializedName("file_type")
    private String mFileType;

    public Long getDealId() {
        return mDealId;
    }

    public void setDealId(Long dealId) {
        mDealId = dealId;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public String getFileType() {
        return mFileType;
    }

    public void setFileType(String fileType) {
        mFileType = fileType;
    }

}
