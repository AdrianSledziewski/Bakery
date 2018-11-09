package store;

import employees.Baker;
import employees.Cashier;
import employees.StoreOwner;
import misc.Customer;

/**
 * This is the main class that stores all object references/dependencies for our Bakery
 *
 */
public class Bakery {

    // A Bakery has references (a.k.a dependencies) on the following classes:
    private Cashier cashier;
    private Baker baker;

    Inventory inventory;
    StoreOwner storeOwner;
    CashRegister cashRegister;

    public Bakery() {
        this.inventory = new Inventory();
        this.cashRegister = new CashRegister();
        this.storeOwner = new StoreOwner(inventory, cashRegister);
        this.baker = new Baker(this.storeOwner);
        this.cashier = new Cashier(this.storeOwner, this.baker);
    }

    public void visit(Customer customer) {

        // In order for a cashier to provide service to a customer during their visit,
        // the cashier must collaborate with both the customer and the store owner.
        // The customer is passed in as an argument but the store owner is passed in
        // in the new employees.Cashier() constructor.
        this.cashier.provideService(customer);
    }
}
