package com.developer.paginglibrary.model;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.developer.paginglibrary.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer,ItemModel>
{
    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;
    private static final String SITE_NAME = "stackoverflow";
    private static final String ORDER = "order";
    private static final String SORT = "sort";


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ItemModel> callback) {
        RetrofitClient.getInstance().getApi().getAnswers(FIRST_PAGE,PAGE_SIZE,SITE_NAME, "desc", "activity").enqueue(new Callback<StackApiResponse>() {
            @Override
            public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                if(response.isSuccessful() && response.body()!=null)
                {
                    callback.onResult(response.body().getItems(),null,FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<StackApiResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemModel> callback) {
        RetrofitClient.getInstance().getApi().getAnswers(params.key,PAGE_SIZE,SITE_NAME, "desc", "activity")
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if(response.isSuccessful() && response.body()!=null)
                        {
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getItems(),key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemModel> callback) {
        RetrofitClient.getInstance().getApi().getAnswers(params.key,PAGE_SIZE,SITE_NAME, "desc", "activity")
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if(response.isSuccessful() && response.body()!=null)
                        {
                            Integer key = response.body().getHasMore() ? params.key + 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {

                    }
                });
    }
}
