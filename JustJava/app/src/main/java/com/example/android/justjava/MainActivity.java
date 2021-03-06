package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is wheter or not the user wants whipped cream topping;
     * @param addChocolate is wheter or not the user wants chocolate toppin
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate)
    {
        // Price of 1 cup coffee
        int baseprice = 5;

        // Add $1 if the user wants whipped cream
        if (addWhippedCream)
        {
            baseprice += 1;
        }

        // Add $2 if the user wants chocolate
        if (addChocolate)
        {
            baseprice += 2;
        }

        // Calculate total
        return quantity * baseprice;
    }

    /**
     * Display summary order
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is wheter or not the user wants whipped cream topping;
     * @param addChocolate is wheter or not the user wants chocolate topping;
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: R$ " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
       if (quantity == 100)
       {
           Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
           return;
       }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus  button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1)
        {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}