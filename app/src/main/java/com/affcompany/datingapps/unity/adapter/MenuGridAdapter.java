package com.affcompany.datingapps.unity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.affcompany.datingapps.unity.ui.CarLisenceTestActivity;
import com.affcompany.datingapps.unity.ui.ConstellationActivity;
import com.affcompany.datingapps.unity.ui.SearchActivity;
import com.bumptech.glide.Glide;
import com.affcompany.datingapps.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuGridAdapter extends RecyclerView.Adapter<MenuGridAdapter.MenuViewHolder> {

    private Context mContext;
    private List<String> menuNameList = new ArrayList<>();
    private Integer[] menuItems = {R.drawable.ic_menu_dream, R.drawable.ic_constellation_menu,
            R.drawable.ic_question_car_menu, R.drawable.ic_home_joke_default, R.drawable.ic_book_menu,
            R.drawable.ic_post_code, R.drawable.ic_weather_menu};

    public MenuGridAdapter(Context mContext) {
        this.mContext = mContext;
        menuNameList = Arrays.asList(mContext.getResources().getStringArray(R.array.menu_name).clone());
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_menu_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(menuItems[position])
                .into(holder.imageLogo);

        holder.menuName.setText(menuNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return menuNameList.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageLogo;
        private TextView menuName;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLogo = itemView.findViewById(R.id.image_logo);
            menuName = itemView.findViewById(R.id.menu_name);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                Intent intent = new Intent();
                if (position == 0) {
                    intent.setClass(itemView.getContext(), SearchActivity.class);
                    intent.putExtra("title", menuNameList.get(getAdapterPosition()));
                } else if (position == 1) {
                    intent.setClass(itemView.getContext(), ConstellationActivity.class);
                } else if (position == 2) {
                    intent.setClass(itemView.getContext(), CarLisenceTestActivity.class);
                }
                intent.putExtra("title", menuNameList.get(getAdapterPosition()));
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
