package edu.orangecoastcollege.cs273.rorellana2.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Associate the controller with the needed views
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalCostTextView;

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    ShipItem newItem = new ShipItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widgets in our app
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        // Define a listener for the weightEditText (onTextChange)
        weightEditText.addTextChangedListener(weightEditTextChangeListener);
    }

    private TextWatcher weightEditTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Try to get the amount from weightEditText:
            try {
                double weight = Double.parseDouble(s.toString()) / 100.0;
                newItem.setWeight(weight);
            }
            catch (NumberFormatException e)
            {
                weightEditText.setText("");
            }
            // No exceptions, input is valid
            updateViews();
        }


        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private void updateViews()
    {
        // 1) Set the added cost (addedCostTextView)
        addedCostTextView.setText(currency.format(newItem.getAddedCost()));
        // 2) Set the total cost (totalCostTextView)
        totalCostTextView.setText(currency.format(newItem.getTotalCost()));
    }
}
