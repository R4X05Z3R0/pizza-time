import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        PizzaBar pizzaBar = new PizzaBar(menu);

        int orderCount = 0;

        while (true) {
            mainMenu();
            int option = input.nextInt();
            switch (option) {
                case 1:
                    menu.displayMenu(); //Displays Menu
                    boolean yesOrNo = true;
                    Order order = new Order();
                    while (yesOrNo) {
                        //Pizza Information and Amount
                        System.out.println("Select Pizza: ");
                        int id = input.nextInt();
                        Pizza selectedPizza = menu.findPizzaByID(id); // Searches through list for Pizza
                        System.out.println("You selected:\n" + selectedPizza + "\n");
                        System.out.println("Insert Amount: ");
                        int amount = input.nextInt();
                        order.addLine(selectedPizza, amount);
                        System.out.println("You selected:\n" + order);



                        System.out.println("Continue Order?");
                        String choose = input.next();

                        if (choose.equalsIgnoreCase("no")) {
                            yesOrNo = false;
                        }

                    }
                    //Customer Information
                    System.out.println("Insert Customer Name:");
                    String cName = input.next();
                    System.out.println("Insert Customer Number:");
                    String cNumber = input.next();

                    Customer customer = new Customer(cName, cNumber);

                    orderCount++;

                    OrderOverview overview = new OrderOverview(customer, order, orderCount);
                    pizzaBar.addOrder(overview);
                    overview.displayOverview();


                    //Create function that takes order and customer name to array of completed orders
                    break;
                case 2:
                    //Order List
                    pizzaBar.displayOrder();
                    subMenu();
                    int option1 = input.nextInt();
                    switch (option1){
                        case 1:
                            System.out.println("Select Order To Ready:");
                            int orderID = input.nextInt();
                            pizzaBar.setReady(orderID);
                            //Function that sets order to ready and deletes it from list
                            break;
                        case 2:
                            //Go back to Main Menu
                            System.out.println();
                            break;
                    }
                    break;
                case 3:
                    //History
                    System.out.println("\nCOMPLETED ORDERS:");
                    pizzaBar.displayCompletedOrders();
                    break;
                case 4:
                    //Admin
                    adminMenu();
                    int option2 = input.nextInt();
                    switch (option2){
                        case 1:
                        //Change Price
                            break;
                        case 2:
                        //Set Customer
                            break;
                        case 3:
                            //Go back to main menu
                            System.out.println();
                            break;
                    }
                    break;
                case 5:
                    //Exit
                    System.out.println("Ending Program...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");

            }
        }
    }

    private static void adminMenu() {
        System.out.println("\nSelect An Option:");
        System.out.println("1. CHANGE PRICE");
        System.out.println("2. ADD FAVORITE CUSTOMERS");
        System.out.println("3. MAIN MENU");
    }

    private static void subMenu() {
        System.out.println("\nSelect An Option:");
        System.out.println("1. Ready Order");
        System.out.println("2. Go Back To Main Menu");
    }

    private static void mainMenu() {
        System.out.println("Select An Option:");
        System.out.println("1. Order");
        System.out.println("2. Order List");
        System.out.println("3. History");
        System.out.println("4. ADMIN");
        System.out.println("5. Exit");
    }
}
