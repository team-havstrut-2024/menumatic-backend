package com.havstrut.menumatic.request;

import java.util.List;


public class CreateUserRequest {

    private String planName;
    private List<Recipe> recipes;

        // Constructor, getters, and setters

    public class Recipe {
        private String name;
        private int portion;
        private long id;

        // Constructor, getters, and setters


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPortion() {
            return portion;
        }

        public void setPortion(int portion) {
            this.portion = portion;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "planName='" + planName + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
