package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.item_interface.IClickItemListListener;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewholder>{


    private List<ItemModel> sListItemModel;
    private IClickItemListListener iClickItemListListener;

    public ItemAdapter(List<ItemModel> sListItem, IClickItemListListener listener){
        this.sListItemModel = sListItem;
        this.iClickItemListListener = listener;
    }


    @NonNull
    @Override
    public ItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new ItemViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewholder holder, int position) {
            final ItemModel iTem = sListItemModel.get(position);
            if(iTem == null){
                return;
            }
            holder.imageItem.setImageResource(iTem.getResourceID());
            holder.tvName.setText(iTem.getName());
            holder.tvPrice.setText(iTem.getPrice());
            //bắt sự kiện Onclick
            holder.layoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickItemListListener.onClickItem(iTem);
                }
            });
    }


    @Override
    public int getItemCount() {
        if(sListItemModel !=null){
            return sListItemModel.size();
        }
        return 0;
    }

    public class ItemViewholder extends RecyclerView.ViewHolder{
    private ImageView imageItem;
    private TextView tvName;
    private TextView tvPrice;
    private RelativeLayout layoutItem;

        public ItemViewholder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imageItem = itemView.findViewById(R.id.img_user);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
