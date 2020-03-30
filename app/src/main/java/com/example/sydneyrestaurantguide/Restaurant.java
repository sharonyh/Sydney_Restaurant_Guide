package com.example.sydneyrestaurantguide;

public class Restaurant {

    private String name;
    private String rating;
    private String cuisine;
    private String location;
    private boolean expanded;

    public boolean isExpanded(){
        return expanded;
    }

    public void setExpanded(boolean expanded){
        this.expanded = expanded;
    }

    public Restaurant(String name, String rating, String cuisine, String location){
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
        this.location = location;
        //list items will default to not being expanded
        this.expanded = false;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getCuisine(){
        return cuisine;
    }

    public void setCuisine(String cuisine){
        this.cuisine = cuisine;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", location='" + location + '\'' +
//                ", expanded=" + expanded +
                '}';
    }
}

