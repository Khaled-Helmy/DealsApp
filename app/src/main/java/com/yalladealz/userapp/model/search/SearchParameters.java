package com.yalladealz.userapp.model.search;

public class SearchParameters {

    private String category_id, deal_name, sort, types, price;

    public SearchParameters(String category_id, String deal_name, String sort, String types, String price) {
        this.category_id = category_id;
        this.deal_name = deal_name;
        this.sort = sort;
        this.types = types;
        this.price = price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDeal_name() {
        return deal_name;
    }

    public void setDeal_name(String deal_name) {
        this.deal_name = deal_name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchParameters{" +
                "category_id='" + category_id + '\'' +
                ", deal_name='" + deal_name + '\'' +
                ", sort='" + sort + '\'' +
                ", types='" + types + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
