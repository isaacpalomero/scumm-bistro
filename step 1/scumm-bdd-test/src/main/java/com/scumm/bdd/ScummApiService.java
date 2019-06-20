package com.scumm.bdd;

import com.scumm.bdd.contracts.api.Category;
import com.scumm.bdd.contracts.api.Dish;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ScummApiService {

    @GET("category")
    Call<List<Category>> listCategory();

    @GET("category/{id}")
    Call<Category> getCategory(@Path("id") String id);

    @POST("category")
    Call<Category> createCategory(@Body Category category);

    @PUT("category/{id}")
    Call<Category> updateCategory(@Path("id") String id, @Body Category category);

    @DELETE("category/{id}")
    Call<Category> deleteCategory(@Path("id") String id);

    @POST("dish")
    Call<Dish> createDish(@Body Dish plato);

    @GET("dish/{id}")
    Call<Dish> getDish(@Path("id") String id);

    @PUT("dish/{id}")
    Call<Dish> updateDish(@Path("id") String id, @Body Dish plato);
}

