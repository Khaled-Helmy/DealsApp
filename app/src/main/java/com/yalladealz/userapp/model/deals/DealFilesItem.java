package com.yalladealz.userapp.model.deals;

import com.google.gson.annotations.SerializedName;

public class DealFilesItem {

    @SerializedName("file_type")
    private String fileType;

    @SerializedName("file_name")
    private String fileName;

    @SerializedName("deal_id")
    private int dealId;

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getDealId() {
        return dealId;
    }

    @Override
    public String toString() {
        return
                "DealFilesItem{" +
                        "file_type = '" + fileType + '\'' +
                        ",file_name = '" + fileName + '\'' +
                        ",deal_id = '" + dealId + '\'' +
                        "}";
    }
}