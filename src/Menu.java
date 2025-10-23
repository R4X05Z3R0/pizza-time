import java.util.ArrayList;

public class Menu {
   private ArrayList<Pizza> menu;

    public Menu(){
        menu = new ArrayList<>();
        populateList();
    }

    public void populateList(){
        menu.add(new Pizza("Margherita", 1, 75.0, "Tomato Sauce, Mozzarella"));
        menu.add(new Pizza("Pepperoni", 2, 85.0, "Tomato Sauce, Mozzarella, Pepperoni"));
        menu.add(new Pizza("Hawaiian", 3, 90.0, "Tomato Sauce, Mozzarella, Ham, Pineapple"));
        menu.add(new Pizza("BBQ Chicken", 4, 95.0, "BBQ Sauce, Mozzarella, Chicken, Red Onions"));
        menu.add(new Pizza("Veggie", 5, 80.0, "Tomato Sauce, Mozzarella, Peppers, Onions, Olives, Mushrooms"));
        menu.add(new Pizza("Meat Lovers", 6, 100.0, "Tomato Sauce, Mozzarella, Pepperoni, Ham, Sausage, Bacon"));
        menu.add(new Pizza("Four Cheese", 7, 90.0, "Tomato Sauce, Mozzarella, Parmesan, Gorgonzola, Cheddar"));
        menu.add(new Pizza("Capricciosa", 8, 85.0, "Tomato Sauce, Mozzarella, Ham, Artichokes, Mushrooms, Olives"));
        menu.add(new Pizza("Diavola", 9, 88.0, "Tomato Sauce, Mozzarella, Spicy Salami, Chili Flakes"));
        menu.add(new Pizza("Tuna", 10, 82.0, "Tomato Sauce, Mozzarella, Tuna, Red Onions"));
        menu.add(new Pizza("Chicken Alfredo", 11, 92.0, "Alfredo Sauce, Mozzarella, Chicken, Spinach"));
        menu.add(new Pizza("Buffalo Chicken", 12, 94.0, "Buffalo Sauce, Mozzarella, Chicken, Red Onions"));
        menu.add(new Pizza("Prosciutto", 13, 95.0, "Tomato Sauce, Mozzarella, Prosciutto, Arugula"));
        menu.add(new Pizza("Carbonara", 14, 90.0, "Cream Sauce, Mozzarella, Bacon, Egg"));
        menu.add(new Pizza("Spinach & Feta", 15, 85.0, "Tomato Sauce, Mozzarella, Spinach, Feta Cheese"));
        menu.add(new Pizza("Mediterranean", 16, 88.0, "Tomato Sauce, Mozzarella, Olives, Feta, Sun-Dried Tomatoes"));
        menu.add(new Pizza("Truffle Mushroom", 17, 110.0, "Truffle Cream, Mozzarella, Mushrooms, Parmesan"));
        menu.add(new Pizza("Seafood", 18, 120.0, "Tomato Sauce, Mozzarella, Shrimp, Squid, Mussels"));
        menu.add(new Pizza("Cheeseburger", 19, 95.0, "Tomato Sauce, Mozzarella, Ground Beef, Onions, Pickles"));
        menu.add(new Pizza("Mexican", 20, 90.0, "Tomato Sauce, Mozzarella, Jalapeños, Minced Beef, Corn"));
        menu.add(new Pizza("Pesto Chicken", 21, 93.0, "Pesto Sauce, Mozzarella, Chicken, Cherry Tomatoes"));
        menu.add(new Pizza("Garden Fresh", 22, 80.0, "Tomato Sauce, Mozzarella, Zucchini, Peppers, Onions"));
        menu.add(new Pizza("Bacon Supreme", 23, 97.0, "Tomato Sauce, Mozzarella, Bacon, Mushrooms, Onions"));
        menu.add(new Pizza("Sausage & Peppers", 24, 89.0, "Tomato Sauce, Mozzarella, Italian Sausage, Bell Peppers"));
        menu.add(new Pizza("Garlic Shrimp", 25, 115.0, "Garlic Cream Sauce, Mozzarella, Shrimp, Spinach"));
        menu.add(new Pizza("Pulled Pork", 26, 100.0, "BBQ Sauce, Mozzarella, Pulled Pork, Red Onions"));
        menu.add(new Pizza("Sweet Chili Chicken", 27, 92.0, "Sweet Chili Sauce, Mozzarella, Chicken, Pineapple"));
        menu.add(new Pizza("Eggplant Parmesan", 28, 85.0, "Tomato Sauce, Mozzarella, Fried Eggplant, Parmesan"));
        menu.add(new Pizza("Smoky BBQ", 29, 96.0, "BBQ Sauce, Mozzarella, Bacon, Onion, Beef"));
        menu.add(new Pizza("Nordic", 30, 105.0, "Crème Fraîche, Mozzarella, Smoked Salmon, Dill"));
    }

    public void displayMenu(){
        System.out.println("""
                 __  __ _____ _   _ _   _
                |  \\/  | ____| \\ | | | | |
                | |\\/| |  _| |  \\| | | | |
                |_|  |_|_____|_| \\_|\\___/
                """);
        for(Pizza pizza : menu){
            System.out.println(pizza);
        }
    }

    public Pizza findPizzaByID(int id){
        for (Pizza pizza : menu) {
            if (pizza.getId() == id) {
                return pizza;
            }
        }
        System.out.println("Pizza not found");
        return null;
    }

    public ArrayList<Pizza> getMenu(){
        return menu;
    }

}
