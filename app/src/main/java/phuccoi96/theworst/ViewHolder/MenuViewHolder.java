package phuccoi96.theworst.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import phuccoi96.theworst.Interface.ItemClickListener;
import phuccoi96.theworst.R;

/**
 * Created by USER on 1/14/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;
    public MenuViewHolder(View itemView) {
        super(itemView);
        //////////////////////////ko chac R androidideal
        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
<<<<<<< HEAD

=======
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
