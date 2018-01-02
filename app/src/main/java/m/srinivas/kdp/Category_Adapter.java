package m.srinivas.kdp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srinivas on 02/01/18.
 */

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.Holder> {
    private List<Category> categories;
    private List<Category> categories_filter;
    private int rowLayout;
    public Context context;

    public Category_Adapter(List<Category> categories, int rowLayout, Context context) {
        this.categories = categories;
        this.categories_filter = categories;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new Holder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.catergory_tv.setText(categories.get(position).getCategory_name());
        holder.category_image.setImageDrawable(context.getDrawable(categories.get(position).getCategor_image()));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView catergory_tv;
        ImageView category_image;
        public Holder(View itemView) {
            super(itemView);
            catergory_tv = (TextView) itemView.findViewById(R.id.catergory_tv);
            category_image = (ImageView) itemView.findViewById(R.id.category_image);
        }
    }

    public void filter(String charText) {

        charText = charText.toUpperCase();
        //  Toast.makeText(context,charText.toString(),Toast.LENGTH_SHORT).show();
        // dealerses.clear();
        if (charText.length() == 0) {
            categories = categories_filter;
        } else {
            ArrayList<Category> filteredList = new ArrayList<>();
            for (Category androidVersion : categories) {
                //  Toast.makeText(context.getApplicationContext(),androidVersion.getOutlet_name(),Toast.LENGTH_SHORT).show();
                if (androidVersion.getCategory_name().contains(charText)) {
                    filteredList.add(androidVersion);
                }
            }
            categories = filteredList;
        }
        notifyDataSetChanged();
    }
}
