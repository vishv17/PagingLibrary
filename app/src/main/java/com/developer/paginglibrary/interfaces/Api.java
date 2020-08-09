package com.developer.paginglibrary.interfaces;

import com.developer.paginglibrary.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api
{
    @GET("answers")
    Call<StackApiResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int pageSize,
            @Query("site") String site, @Query("order") String order, @Query("sort") String sort);
}
