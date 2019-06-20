package com.scumm.bdd.dish;

import com.scumm.bdd.contracts.api.Dish;

public class DishScenario {
    private static DishScenario dishScenarioInstance;

    private String dishName;
    private Dish dish;
    private DishScenario() {
    }

    public static synchronized DishScenario getInstance() {
        if (dishScenarioInstance == null) {
            dishScenarioInstance = new DishScenario();
        }
        return dishScenarioInstance;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public static void clean() {
        dishScenarioInstance = null;
    }
}
