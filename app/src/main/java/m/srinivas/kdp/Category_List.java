package m.srinivas.kdp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Category_List extends Activity implements View.OnClickListener {
    RecyclerView category_recyler;
    ArrayList<Category> categories;
    Category_Adapter category_adapter;
    SearchView category_search;
    RelativeLayout category_header_search, category_header;
    ImageView search_image, back_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category__list);
        category_recyler = (RecyclerView) findViewById(R.id.category_recyler);
        category_search = (SearchView) findViewById(R.id.category_search);
        category_header = (RelativeLayout) findViewById(R.id.category_header);
        category_header_search = (RelativeLayout) findViewById(R.id.category_header_search);
        back_image = (ImageView) findViewById(R.id.back_image);
        search_image = (ImageView) findViewById(R.id.search_image);
        back_image.setOnClickListener(this);
        search_image.setOnClickListener(this);
        categories = new ArrayList<Category>();
        categories.add(new Category("1", "Books", R.drawable.book));
        categories.add(new Category("1", "Clothing", R.drawable.clothing));
        categories.add(new Category("1", "Furniture", R.drawable.furniture));
        categories.add(new Category("1", "Foot Wear ", R.drawable.footwear));
        categories.add(new Category("1", "Jewellery", R.drawable.book));
        categories.add(new Category("1", "Books", R.drawable.book));
        categories.add(new Category("1", "Clothing", R.drawable.clothing));
        categories.add(new Category("1", "Furniture", R.drawable.furniture));
        categories.add(new Category("1", "Foot Wear ", R.drawable.footwear));
        categories.add(new Category("1", "Jewellery", R.drawable.book));
        categories.add(new Category("1", "Books", R.drawable.book));
        categories.add(new Category("1", "Clothing", R.drawable.clothing));
        categories.add(new Category("1", "Furniture", R.drawable.furniture));
        categories.add(new Category("1", "Foot Wear ", R.drawable.footwear));
        categories.add(new Category("1", "Jewellery", R.drawable.book));
        categories.add(new Category("1", "Books", R.drawable.book));
        categories.add(new Category("1", "Clothing", R.drawable.clothing));
        categories.add(new Category("1", "Furniture", R.drawable.furniture));
        categories.add(new Category("1", "Foot Wear ", R.drawable.footwear));
        categories.add(new Category("1", "Jewellery", R.drawable.book));

        category_recyler.setLayoutManager(new LinearLayoutManager(this));
        category_recyler.setHasFixedSize(true);
        category_recyler.setItemViewCacheSize(20);
        category_recyler.setDrawingCacheEnabled(true);
        category_recyler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        category_adapter = new Category_Adapter(categories, R.layout.category, getApplicationContext());
        category_recyler.setAdapter(category_adapter);
        category_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                category_adapter.filter(newText.toString());

                return false;

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_image:
                category_header.setVisibility(View.GONE);
                category_header_search.setVisibility(View.VISIBLE);
                category_search.setFocusable(true);
                category_search.setFocusableInTouchMode(true);
                category_search.onActionViewExpanded();
                 break;
            case R.id.back_image:
                category_header.setVisibility(View.VISIBLE);
                category_header_search.setVisibility(View.GONE);
                break;
        }
    }

}
