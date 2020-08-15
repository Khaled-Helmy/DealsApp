package com.yalladealz.userapp.data.datasourceFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yalladealz.userapp.data.datasources.ProductCategoryDataSource;
import com.yalladealz.userapp.model.deals.Deal;

public class ProductCategoryDataSourceFactory extends DataSource.Factory<Integer, Deal> {

    private String category_id;
    private MutableLiveData<ProductCategoryDataSource> productCategoryDataSourceMutableLiveData = new MutableLiveData<>();

    public ProductCategoryDataSourceFactory(String category_id) {
        this.category_id = category_id;
    }

    @NonNull
    @Override
    public DataSource<Integer, Deal> create() {
        ProductCategoryDataSource productCategoryDataSource = new ProductCategoryDataSource(category_id);
        productCategoryDataSourceMutableLiveData.postValue(productCategoryDataSource);
        return productCategoryDataSource;
    }

    public LiveData<ProductCategoryDataSource> getProductCategoryDataSource() {
        return productCategoryDataSourceMutableLiveData;
    }
}
