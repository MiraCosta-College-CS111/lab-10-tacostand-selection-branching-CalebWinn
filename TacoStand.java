public class TacoStand
{
    /* CONSTANT VARIABLES */
    public static final String BAR = "----------------------------------------";
    public static final double PRICE_ASADA = 2.5;
    public static final double PRICE_POLLO = 1.75;
    public static final double PRICE_LENGUA = 3.0;
    public static final double PRICE_ULTIMATE = 18.0;
    public static final double SUPPLY_COST = 0.75; // cost per taco in supplies

    /* STATIC VARIABLES */
    private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
    private static double totalFunds = 0.0;

    /**
     * Sets the store to zero for use in automated testing.
     */
    public static void initialize()
    {
        numAsada = numPollo = numLengua = numUltimate = 0;
        totalFunds = 0.0;
    }

    /**
     * Outputs menu options (kinds of tacos) customer can use to order.
     */
    public static void printMenu()
    {
        System.out.println("Menu options:\n" + TacoStand.BAR);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", TacoStand.PRICE_ASADA);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", TacoStand.PRICE_POLLO);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", TacoStand.PRICE_LENGUA);
        System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", TacoStand.PRICE_ULTIMATE);
        System.out.println(TacoStand.BAR);
    }
    
    /**
     * Returns a summary (all static variables) of the CURRENT status of the taco stand.
     *
     * @return String containing current values related to taco stand, no new line at end.
     */
    public static String getStatus()
    {
        return String.format("%s%nMCC Taco Stand Status%n%s%n" +
            "%-23s$%-7.2f%n%s%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n" +
            "%-23s%2d tacos%n%s",
            TacoStand.BAR, TacoStand.BAR, 
            "Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
            "# of Asada Left:", TacoStand.numAsada,
            "# of Pollo Left:", TacoStand.numPollo,
            "# of Lengua Left:", TacoStand.numLengua,
            "# of Ultimate Left:", TacoStand.numUltimate, TacoStand.BAR);
    }

    /**
     * Increases totalFunds static variable.
     * 
     * @param funds assumes >0 value added to total funds available for cart.
     */
    public static void addTotalFunds(int funds)
    {
        TacoStand.totalFunds += funds;
    }
    
    /**
     * Checks if the proposed budget to order supplies can be used based on available funds.
     * If within total funds, subtracts the budget and increments the number of each type of taco equally.
     * Otherwise, no variables are changed.
     * 
     * @param budget funds to use to order supplies.
     * @return boolean representing if supplies could be ordered (true if successful, false if insufficient funds).
     */
    public static boolean orderSupplies(double budget)
    {
        // Check if budget is within available funds
        if (budget > TacoStand.totalFunds) {
            return false;
        }

        // Calculate the total number of tacos that can be purchased with the budget
        // and distribute equally among the four taco types.
        int tacosEach = (int)Math.round((budget / SUPPLY_COST) / 4.0);

        // Update funds and supply counts
        TacoStand.totalFunds -= budget;
        TacoStand.numAsada += tacosEach;
        TacoStand.numPollo += tacosEach;
        TacoStand.numLengua += tacosEach;
        TacoStand.numUltimate += tacosEach;

        return true;
    }

    /**
     * Processes a taco sale by adding the sale amount to total funds and decreasing
     * the supply count for the specific taco ordered.
     * 
     * @param tacoOption menu option (kind of taco) from 1 to 4.
     * @param numTacos number of tacos as part of order, assume > 0.
     */
    public static void updateTotalFunds(int tacoOption, int numTacos)
    {
        double saleAmount = 0.0;
        switch(tacoOption) {
            case 1:
                saleAmount = PRICE_ASADA * numTacos;
                numAsada -= numTacos;
                break;
            case 2:
                saleAmount = PRICE_POLLO * numTacos;
                numPollo -= numTacos;
                break;
            case 3:
                saleAmount = PRICE_LENGUA * numTacos;
                numLengua -= numTacos;
                break;
            case 4:
                saleAmount = PRICE_ULTIMATE * numTacos;
                numUltimate -= numTacos;
                break;
            default:
                System.out.println("Invalid taco option.");
                return;
        }
        // Add the sale amount to the total funds.
        totalFunds += saleAmount;
    }
    
    
    /**
     * Determines if taco order can be fulfilled (number of tacos for specific kind are available).
     * 
     * @param tacoOption menu option (kind of taco)
     * @param numTacos number of tacos as part of order
     * @return boolean representing if specific kind of tacos, for the number in order, are available.
     */
    /**
 * Determines if taco order can be fulfilled (number of tacos for specific kind are available).
 * 
 * @param tacoOption menu option (kind of taco)
 * @param numTacos number of tacos as part of order
 * @return boolean representing if specific kind of tacos, for the number in order, are available.
 */
    public static boolean areTacosAvailable(int tacoOption, int numTacos)
{
    switch(tacoOption) {
        case 1:
            return numAsada >= numTacos;
        case 2:
            return numPollo >= numTacos;
        case 3:
            return numLengua >= numTacos;
        case 4:
            return numUltimate >= numTacos;
        default:
            System.out.println("Invalid taco option.");
            return false;
    }
}
}