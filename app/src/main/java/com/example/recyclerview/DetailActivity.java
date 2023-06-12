package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        ItemModel item = (ItemModel) bundle.get("object_item");

        ImageView img_item_details = findViewById(R.id.img_layout_details);
        img_item_details.setImageResource(item.getResourceID());

        TextView tv_item_details = findViewById(R.id.tv_details_item);
        tv_item_details.setText(item.getName());

        TextView tv_details_price = findViewById(R.id.tv_details_price);
        tv_details_price.setText(item.getPrice());
    }
}