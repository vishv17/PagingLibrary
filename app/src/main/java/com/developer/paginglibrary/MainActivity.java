package com.developer.paginglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.developer.paginglibrary.adapter.ItemAdapter;
import com.developer.paginglibrary.api.RetrofitClient;
import com.developer.paginglibrary.model.ItemModel;
import com.developer.paginglibrary.model.ItemViewModel;
import com.developer.paginglibrary.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final ItemAdapter itemAdapter = new ItemAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ItemModel>>() {
            @Override
            public void onChanged(PagedList<ItemModel> itemModels) {
                itemAdapter.submitList(itemModels);
            }
        });
        recyclerView.setAdapter(itemAdapter);
    }
}