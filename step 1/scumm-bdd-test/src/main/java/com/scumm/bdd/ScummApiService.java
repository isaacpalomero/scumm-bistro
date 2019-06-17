package com.scumm.bdd;

import com.scumm.bdd.contracts.api.Category;
import com.scumm.bdd.contracts.api.Dish;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ScummApiService {

    @GET("category")
    Call<List<Category>> listCategory();

    @GET("category/{id}")
    Call<Category> getCategory(@Path("id") String id);

    @POST("category")
    Call<Category> createCategory(@Body Category category);

    @POST("dish")
    Call<Dish> createDish(@Body Dish plato);

    @GET("dish/{id}")
    Call<Dish> getDish(@Path("id") String id);
}

