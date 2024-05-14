CREATE TABLE api_limit (
 interval TIMESTAMP(10) NOT NULL,
 counter_limit INT
);

ALTER TABLE api_limit ADD CONSTRAINT PK_api_limit PRIMARY KEY (interval);


CREATE TABLE recipe (
 recipe_id INT NOT NULL,
 name_of_recipe VARCHAR(500) NOT NULL,
 portions INT NOT NULL
);

ALTER TABLE recipe ADD CONSTRAINT PK_recipe PRIMARY KEY (recipe_id);


CREATE TABLE registered_user (
 user_id VARCHAR(500) NOT NULL
);

ALTER TABLE registered_user ADD CONSTRAINT PK_registered_user PRIMARY KEY (user_id);


CREATE TABLE favorite_dish (
 user_id VARCHAR(500) NOT NULL,
 recipe_id INT NOT NULL
);

ALTER TABLE favorite_dish ADD CONSTRAINT PK_favorite_dish PRIMARY KEY (user_id,recipe_id);


CREATE TABLE food_preference (
 preference VARCHAR(500) NOT NULL,
 user_id VARCHAR(500) NOT NULL
);

ALTER TABLE food_preference ADD CONSTRAINT PK_food_preference PRIMARY KEY (preference,user_id);


CREATE TABLE kitchen_equipment (
 user_id VARCHAR(500) NOT NULL,
 utility VARCHAR(500) NOT NULL
);

ALTER TABLE kitchen_equipment ADD CONSTRAINT PK_kitchen_equipment PRIMARY KEY (user_id,utility);


CREATE TABLE mealplan (
 mealplan_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
 time_of_mealplan TIMESTAMP(6) NOT NULL,
 name_of_mealplan VARCHAR(500) NOT NULL,
 user_id VARCHAR(500) NOT NULL
);

ALTER TABLE mealplan ADD CONSTRAINT PK_mealplan PRIMARY KEY (mealplan_id);


CREATE TABLE recipe_mealplan (
 recipe_id INT NOT NULL,
 mealplan_id INT NOT NULL
);

ALTER TABLE recipe_mealplan ADD CONSTRAINT PK_recipe_mealplan PRIMARY KEY (recipe_id,mealplan_id);


CREATE TABLE excluded_ingredient (
 mealplan_id INT NOT NULL,
 name_of_excluded_ingredient VARCHAR(500) NOT NULL
);

ALTER TABLE excluded_ingredient ADD CONSTRAINT PK_excluded_ingredient PRIMARY KEY (mealplan_id,name_of_excluded_ingredient);


ALTER TABLE favorite_dish ADD CONSTRAINT FK_favorite_dish_0 FOREIGN KEY (user_id) REFERENCES registered_user (user_id) ON DELETE CASCADE;
ALTER TABLE favorite_dish ADD CONSTRAINT FK_favorite_dish_1 FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id) ON DELETE CASCADE;


ALTER TABLE food_preference ADD CONSTRAINT FK_food_preference_0 FOREIGN KEY (user_id) REFERENCES registered_user (user_id) ON DELETE CASCADE;


ALTER TABLE kitchen_equipment ADD CONSTRAINT FK_kitchen_equipment_0 FOREIGN KEY (user_id) REFERENCES registered_user (user_id) ON DELETE CASCADE;


ALTER TABLE mealplan ADD CONSTRAINT FK_mealplan_0 FOREIGN KEY (user_id) REFERENCES registered_user (user_id) ON DELETE CASCADE;


ALTER TABLE recipe_mealplan ADD CONSTRAINT FK_recipe_mealplan_0 FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id) ON DELETE CASCADE;
ALTER TABLE recipe_mealplan ADD CONSTRAINT FK_recipe_mealplan_1 FOREIGN KEY (mealplan_id) REFERENCES mealplan (mealplan_id) ON DELETE CASCADE;


ALTER TABLE excluded_ingredient ADD CONSTRAINT FK_excluded_ingredient_0 FOREIGN KEY (mealplan_id) REFERENCES mealplan (mealplan_id) ON DELETE CASCADE;


