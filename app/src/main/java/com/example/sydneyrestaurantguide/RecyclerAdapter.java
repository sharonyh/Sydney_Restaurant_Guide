package com.example.sydneyrestaurantguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RestaurantVH> {

    private static final String TAG = "RecyclerAdapter";
    List<Restaurant> restaurantList;

    public RecyclerAdapter(List<Restaurant> restaurantList){this.restaurantList = restaurantList;}

    @NonNull
    @Override
    public RestaurantVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new RestaurantVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantVH holder, int position){

        //set restaurant information for each new instance of Restaurant
        Restaurant restaurant = restaurantList.get(position);
        holder.nameTextView.setText(restaurant.getName());
        holder.cuisineTextView.setText(restaurant.getCuisine());
        holder.ratingTextView.setText(restaurant.getRating());
        holder.locationTextView.setText(restaurant.getLocation());

        boolean isExpanded = restaurantList.get(position).isExpanded();
        //if expanded, the view should be visible; if not expanded, the view should be gone
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE: View.GONE);
    }

    @Override
    public int getItemCount(){return restaurantList.size();}

    class RestaurantVH extends RecyclerView.ViewHolder{
        private static final String TAG = "RestaurantVH";

        TextView nameTextView, cuisineTextView, ratingTextView, locationTextView;
        ConstraintLayout expandableLayout;

        public RestaurantVH(@NonNull final View itemView){
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            cuisineTextView = itemView.findViewById(R.id.cuisineTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            nameTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                //expand on click
                public void onClick(View view){
                    Restaurant restaurant = restaurantList.get(getAdapterPosition());
                    //set expanded to inverted property of restaurant.isExpanded()
                    restaurant.setExpanded(!restaurant.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}


