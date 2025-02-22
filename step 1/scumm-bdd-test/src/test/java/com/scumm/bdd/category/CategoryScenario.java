package com.scumm.bdd.category;

import com.scumm.bdd.contracts.api.Category;

public class CategoryScenario {
    private static CategoryScenario categoryScenarioInstance;

    private String categoryName;
    private Category category;

    private CategoryScenario() {
    }

    public static synchronized CategoryScenario getInstance() {
        if (categoryScenarioInstance == null) {
            categoryScenarioInstance = new CategoryScenario();
        }
        return categoryScenarioInstance;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static void clean() {
        categoryScenarioInstance = null;
    }
}
