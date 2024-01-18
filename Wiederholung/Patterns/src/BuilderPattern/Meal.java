package BuilderPattern;

public class Meal {
    private String mainCourse;
    private String sideDish;
    private String drink;
    private String dessert;

    private Meal() {}

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mainCourse='" + mainCourse + '\'' +
                ", sideDish='" + sideDish + '\'' +
                ", drink='" + drink + '\'' +
                ", dessert='" + dessert + '\'' +
                '}';
    }

    public static class MealBuilder {
        private String mainCourse;
        private String sideDish;
        private String drink;
        private String dessert;

        public MealBuilder() {}

        public MealBuilder withMainCourse(String mainCourse) {
            this.mainCourse = mainCourse;
            return this;
        }

        public MealBuilder withSideDish(String sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        public MealBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder withDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            Meal meal = new Meal();
            meal.setMainCourse(this.mainCourse);
            meal.setSideDish(this.sideDish);
            meal.setDrink(this.drink);
            meal.setDessert(this.dessert);
            return meal;
        }
    }
}
