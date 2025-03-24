// NAME: Caleb Winn
// PARTNER NAME:
// CS111 SECTION #:
// DATE: 3/22

public class Main
{

	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		//DECLARATION + INITIALIZATION SECTION
		TacoStand.initialize();

		//INPUT + CALCULATION + OUTPUT SECTION
		TacoStand.addTotalFunds(20);
		TacoStand.orderSupplies(15);

		System.out.println("OPENING UP THE STAND...");
		System.out.println( TacoStand.getStatus() +"\n\n");

		Main.printWelcome();
		System.out.println("\n");
		
		Main.takeOrder();
		//call takeOrder more times if you'd like! (once everything works once though!)

		System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
	}

	/**
	 * Outputs welcome message to start program that user sees
	 */
	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
		//ascii art credit:
		//https://mizbizbby.tumblr.com/post/12937794639/happy-taco-ascii-art-for-taco-thursday
	}
	
	/**
	 * Prints menu and prompts user for input for kind of taco and number in order. If tacos are available,
	 * will update total funds and confirm order with user, otherwise error message given
	 */
	public static void takeOrder()
{
    // 1. Print the menu
    TacoStand.printMenu();
    
    // 2. Ask user for taco option (1–4)
    int option = UtilityBelt.readInt("Enter choice> ", 1, 4);

    // 3. Ask user for number of tacos (1–5, or 1–50, etc.)
    int numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);

    // 4. Enforce a 5-taco max limit
    if (numTacosOrdered > 5) {
        System.out.println("We don't have that many tacos, sorry! Try again :(");
        return;
    }

    // 5. Check if there are enough tacos
    if (!TacoStand.areTacosAvailable(option, numTacosOrdered)) {
        System.out.println("We don't have that many tacos, sorry! Try again :(");
        return;
    }

    // 6. Process the order
    TacoStand.updateTotalFunds(option, numTacosOrdered);

    // 7. Print confirmation
    Main.printConfirmation(numTacosOrdered);
}
		
	

   // ... other methods remain unchanged ...

    /**
 * Prints confirmation message that varies based on the number of tacos in the order.
 *
 * @param numTacos number of tacos ordered
 */
public static void printConfirmation(int numTacos)
{
    if (numTacos <= 0) {
        System.out.println("No tacos ordered.");
        return;
    }
    
    System.out.println("Here you go, buen provecho!");
    
    // Print taco art: show up to 10 taco icons (to prevent too much output if a large number is ordered)
    int tacoIcons = Math.min(numTacos, 10);
    System.out.println("🌮".repeat(tacoIcons));
	System.out.println("");
}
    
    // ... other methods remain unchanged ...
}
