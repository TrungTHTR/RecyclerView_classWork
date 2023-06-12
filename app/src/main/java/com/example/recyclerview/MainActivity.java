package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.item_interface.IClickItemListListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvItem;
    private ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvItem = findViewById(R.id.rcv_item);


        LinearLayoutManager linearLayoutManage = new LinearLayoutManager(this,RecyclerView.VERTICAL,false );
        rcvItem.setLayoutManager(linearLayoutManage);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);

        itemAdapter = new ItemAdapter(getListItem(), new IClickItemListListener() {
            @Override
            public void onClickItem(ItemModel item) {
                onClickGotoDetail(item);
            }
        });

        rcvItem.setAdapter(itemAdapter);
    }

    private List<ItemModel> getListItem() {
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel(R.drawable.banshee_norn, "Gundam RG banshee Norn","69.99$"));
        list.add(new ItemModel(R.drawable.sinanju, "Gundam MG Sinanju OVA","74.61$"));
        list.add(new ItemModel(R.drawable.unicorn, "Gundam MG Phenex P-Bandai","169.38$"));
        list.add(new ItemModel(R.drawable.unicorn, "Gundam RG Unicorn","71.86$"));

        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void onClickGotoDetail(ItemModel item){
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_item",item);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}