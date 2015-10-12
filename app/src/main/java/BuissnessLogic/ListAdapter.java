package BuissnessLogic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Views.CashDispenseDialog;
import vendingexample.zipcar.com.vendingmachine.R;


/**
 * Created by rob2cool on 9/9/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements  View.OnClickListener{

    public ArrayList<ItemType> mItemTypes;
    Context context;
    HandleItemChange  itemChange;


    public ListAdapter(ArrayList<ItemType> mItemTypes, Context context) {
        this.mItemTypes = mItemTypes;
        this.context = context;
        itemChange = (HandleItemChange) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_grid_item,
                parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String name = mItemTypes.get(position).getmItemName();
            holder.ItemImage.setImageResource(mItemTypes.get(position).getmItemImage());
        holder.ItemName.setText(mItemTypes.get(position).getmItemName());
        holder.ItemStock.setText(""+mItemTypes.get(position).getmItemPrice());
       // holder.ItemPrice.setText(""+mItemTypes.get(position).getmItemPrice());
        holder.ItemStockLimit.setText(""+mItemTypes.get(position).getmItemCount());
        holder.ItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemTypes.get(position).getmItemPrice()<= Cash.getInstance().getmCashAmount()){
                    Cash.getInstance().PayUp(mItemTypes.get(position).getmItemPrice());
                    mItemTypes.get(position).removeItem();
                    holder.ItemStockLimit.setText(""+mItemTypes.get(position).getmItemCount());
                    itemChange.DispenceChange(Cash.getInstance().getmCashAmount());


                }else {
                    Toast.makeText(context, "Current Amount not enough", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemTypes.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ItemImage;
        TextView  ItemName;
        TextView  ItemStock;
        TextView  ItemPrice;
        TextView  ItemStockLimit;


        public ViewHolder(View itemView) {
            super(itemView);
            ItemImage = (ImageView) itemView.findViewById(R.id.item_img);
            ItemName = (TextView) itemView.findViewById(R.id.item_name);
            ItemStock = (TextView) itemView.findViewById(R.id.stock);
            ItemStockLimit= (TextView) itemView.findViewById(R.id.stocklimit);


        }
    }
    
}
