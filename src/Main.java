import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        PizzaBar pizzaBar = new PizzaBar(menu);

        int orderCount = 0;

        while (true) {
            mainMenu();
            int option;

            if(input.hasNextInt()){
            option = input.nextInt();
            } else {
                System.out.println("Error: Please Enter Valid Number");
                input.next();
                continue;
            }
            switch (option) {
                case 1:
                    menu.displayMenu(); //Displays Menu
                    boolean yesOrNo = true;
                    Order order = new Order();

                    while (yesOrNo){
                        int id = 0;
                        while (true){
                            System.out.println("Select Pizza (Enter ID) :");
                            if (input.hasNextInt()){ //Checks if input is int before continuing
                                id = input.nextInt();
                                Pizza selectedPizza = menu.findPizzaByID(id);
                                if (selectedPizza != null){//Checks if it exists at all
                                    System.out.println("You have selected: " + selectedPizza.getName().toUpperCase() + "\n");
                                    break;
                                } else {
                                    System.out.println("Pizza does not exist");
                                }
                            } else {
                                input.next();
                                System.out.println("Please Enter A Valid Number");
                            }

                        }

                        //Amount Verification
                        int amount = 0;
                        while (true) {
                            System.out.println("Insert Amount: ");
                            if (input.hasNextInt()) {
                                amount = input.nextInt();
                                if (amount > 0) {
                                    //Just ends loop
                                    break;
                                } else {
                                    System.out.println("Error: Amount must be greater than 0");
                                }
                            } else {
                                input.next();
                                System.out.println("Error: Enter a number");
                            }
                        }

                        //Order Display
                        Pizza selectedPizza = menu.findPizzaByID(id);
                        order.addLine(selectedPizza,amount);
                        System.out.println("You have selected: \n" + order);

                        //Continue confirmation
                        while (true) {
                            System.out.println("Continue order?");
                            String choose = input.next();
                            if (choose.equalsIgnoreCase("yes")){
                                break;
                            } else if (choose.equalsIgnoreCase("no")){
                                yesOrNo = false;
                                break;
                            } else {
                                System.out.println("Error: Please enter \"Yes\" or \" No\"");
                            }
                        }
                    }

                    //Customer Information
                    Customer customer = addCustomer(input);
                    orderCount++;

                    //Adds order to orderlist

                    OrderOverview overview = new OrderOverview(customer, order, orderCount);
                    pizzaBar.addOrder(overview);
                    overview.displayOverview();

                    //Create function that takes order and customer name to array of completed orders
                    break;


                case 2:
                    //Order List
                    pizzaBar.displayOrder();

                    int option1;
                    while (true) {
                        subMenu();
                        if (input.hasNextInt()) {
                            option1 = input.nextInt();
                            break;
                        } else {
                            System.out.println("Error: Enter Number\n");
                            input.next();
                        }
                    }
                    switch (option1) {
                        case 1:
                            while (true) {
                                System.out.println("Select Order To Ready:");
                                if (!input.hasNextInt()) {
                                    System.out.println("Error: Enter Number");
                                    input.next();
                                } else {
                                    int orderID = input.nextInt();
                                    pizzaBar.setReady(orderID);
                                    break;
                                }
                            }

                            //Function that sets order to ready and deletes it from list

                        case 2:
                            //Go back to Main Menu
                            System.out.println();
                            break;
                        default:
                            //Invalid Choice
                            System.out.println("Invalid Choice. Try Again.");
                    }
                    break;


                case 3:
                    //History
                    System.out.println("-----COMPLETED ORDERS-----");
                    pizzaBar.displayCompletedOrders();
                    break;


                case 4:
                    //Admin
                    int option2;
                    while (true) {
                        adminMenu();
                        if (input.hasNextInt()) {
                            option2 = input.nextInt();
                            break;
                        } else {
                            System.out.println("Error: Enter Number");
                            input.next();
                        }
                    }
                    switch (option2) {
                        case 1:
                            //Change Price
                            changePrice(input, menu);
                            break;
                        case 2:
                            //Set Customer
                            input.nextLine();
                            String name;
                            String number;
                            System.out.println("Enter Customer Name:");
                            name = input.nextLine();

                            while (true){
                                System.out.println("Enter Customer Number:");
                                number = input.nextLine();
                                if (number.matches("\\d{8}")){
                                    break;
                                }else {
                                    System.out.println("Error: Enter Number (8 Digits)\n");
                                }
                            }

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
                        default:
                            System.out.println("Invalid Choice");
                    }
                    break;


                case 5:
                    //Exit
                    System.out.println("Ending Program...");
                    input.close();
                    System.exit(0);
                    break;


                default:
                    System.out.println("Error: Invalid Option.");

            }
        }
    }

    private static void changePrice(Scanner input, Menu menu) {
        int pizzaID;
        while (true){
            System.out.println("Select pizza by ID:");
            if(input.hasNextInt()){
                pizzaID = input.nextInt();
                break;
            } else {
                System.out.println("Error: Enter Number");
                input.next();
            }
        }
        Pizza a = menu.findPizzaByID(pizzaID);
        double oldPrice = a.getPrice();
        System.out.println("You selected " + a.getName()
                + " - " + a.getPrice() + "kr");

        double newAmount = 0;
        while(true) {
            System.out.println("Enter new amount: ");
            if (input.hasNextDouble()){
                newAmount = input.nextDouble();
                break;
            } else {
                System.out.println("Error: Enter A Number");
                input.next();
            }
        }
        a.setPrice(newAmount);

        System.out.printf("%s : Old Price - %.2fkr , New Price - %.2fkr%n", a.getName(), oldPrice, a.getPrice());
    }

    private static void adminMenu() {
        System.out.println("\nSelect An Option:");
        System.out.println("1. CHANGE PRICE");
        System.out.println("2. ADD FAVORITE CUSTOMERS");
        System.out.println("3. DISPLAY CUSTOMERS");
        System.out.println("4. MAIN MENU");
        System.out.print(">>>");
    }

    private static void subMenu() {
        System.out.println("Select An Option:");
        System.out.println("1. Ready Order");
        System.out.println("2. Go Back To Main Menu");
        System.out.print(">>>");
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

    public static Customer addCustomer(Scanner input) {
        input.nextLine();
        System.out.println("Enter Customer Name: ");
        String name = input.next();
        System.out.println("Enter Phone Number (8 digits): ");
        String phone = input.next();
        while (!isValidPhone(phone)) {
            System.out.println("Invalid Phone Number. Try Again.");
            System.out.println("Enter Phone Number (8 digits): ");
            phone = input.next();
        }
        return new Customer(name,phone);
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{8}");
    }
}
