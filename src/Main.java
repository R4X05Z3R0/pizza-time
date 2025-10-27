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
                    System.out.println("-----COMPLETED ORDERS-----");
                    pizzaBar.displayCompletedOrders();
                    break;
                case 4:
                    //Admin
                    adminMenu();
                    int option2 = input.nextInt();
                    switch (option2){
                        case 1:
                        //Change Price
                            changePrice(input, menu);
                            break;
                        case 2:
                        //Set Customer
                            input.nextLine();
                            System.out.println("Enter Customer Name:");
                            String name = input.nextLine();
                            System.out.println("Enter Customer Number:");
                            String number = input.nextLine();
                            pizzaBar.addCustomer(name, number);
                            break;
                        case 3:
                            //Display List of Customers
                            System.out.println("-----List Of Customers------");
                            pizzaBar.displayCustomers();
                            break;
                        case 4:
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

    private static void changePrice(Scanner input, Menu menu) {
        System.out.println("Select pizza by ID:");
        int pizzaID = input.nextInt();
        Pizza a = menu.findPizzaByID(pizzaID);
        double oldPrice = a.getPrice();
        System.out.println("You selected " + a.getName()
        + " - " + a.getPrice() + "kr");

        System.out.println("Enter new amount: ");
        double newAmount = input.nextDouble();
        a.setPrice(newAmount);

        System.out.printf("%s : Old Price - %.2fkr , New Price - %.2fkr%n", a.getName(), oldPrice, a.getPrice());
        return;
    }

    private static void adminMenu() {
        System.out.println("\nSelect An Option:");
        System.out.println("1. CHANGE PRICE");
        System.out.println("2. ADD FAVORITE CUSTOMERS");
        System.out.println("3. DISPLAY CUSTOMERS");
        System.out.println("4. MAIN MENU");
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
        System.out.print(">>>");
    }
}
