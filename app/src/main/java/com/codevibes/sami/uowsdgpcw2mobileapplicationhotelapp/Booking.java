package com.codevibes.sami.uowsdgpcw2mobileapplicationhotelapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class Booking extends AppCompatActivity implements OnClickListener{

    // Declaring view objects
    private EditText Name_booking;
    private EditText Mobile_number__booking;
    private EditText Number_of_heads_booking;
    private DatePicker Date_Picker_booking;
    private CheckBox Bird_watching_check_booking;
    private CheckBox Safari_check_booking;
    private Button Confirm_booking;

    // Variables for date and calender details
    final Calendar calender = Calendar.getInstance();
    int year = calender.get(Calendar.YEAR);
    int month = calender.get(Calendar.MONTH) + 1;
    int day = calender.get(Calendar.DAY_OF_MONTH);

    // Bird watch and safari cost container variables
    int birdWatch = 0;
    int safari = 0;

    int rooms;
    int cottage_fee;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Name_booking = (EditText) findViewById(R.id.Name_booking);
        Mobile_number__booking = (EditText) findViewById((R.id.Mobile_number_booking));
        Number_of_heads_booking = (EditText) findViewById(R.id.Number_of_heads_booking);
        Date_Picker_booking = (DatePicker) findViewById(R.id.Date_Picker_booking);
        Bird_watching_check_booking = (CheckBox) findViewById(R.id.Bird_watching_check_booking);
        Safari_check_booking = (CheckBox) findViewById(R.id.Safari_check_booking);
        Confirm_booking = (Button) findViewById(R.id.Confirm_booking);
        Confirm_booking.setOnClickListener(this);

    }

    public void booking() {

        // Get customer name and mobile number entries to String variables
        String customer_name = Name_booking.getText().toString().trim();
        String mobile_number = Mobile_number__booking.getText().toString().trim();
        int number_of_heads = Integer.parseInt(Number_of_heads_booking.getText().toString());

        // Check if customer name field is empty
        if (TextUtils.isEmpty(customer_name)) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if mobile number field is empty
        if (TextUtils.isEmpty(mobile_number)) {
            Toast.makeText(this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculating needed least number of rooms
        rooms = (int)Math.ceil((double) number_of_heads/4);

        // Calculating total cottage fee
        cottage_fee = rooms * 30000;

        // Calculate bird watch cost
        if(Bird_watching_check_booking.isChecked()){
            birdWatch = number_of_heads * 2000;
        }

        // Calculating safari cost
        if(Safari_check_booking.isChecked()){
            safari = number_of_heads * 5000;
        }

        // calculating total amount
        total = cottage_fee + birdWatch + safari;

        // Set current date to the DatePicker
        // calendar.set(Calendar.YEAR, year);
        // calendar.set(Calendar.MONTH, month);
        // calendar.set(Calendar.DAY_OF_MONTH, day);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(AlertDialogActivity.this);

        // Setting Dialog Title
        alertDialog.setTitle("Processing order...");

        // Setting Dialog Message
        alertDialog.setMessage("You have to book " + rooms + " cottage(s)! " +
                "/n Cottage fee       ➡ Rs." + cottage_fee + "/n Bird watching fee ➡ Rs." + birdWatch +
                "/n Safari cost       ➡ Rs." + safari + "/n The cost is Rs." + total + "/= 0nly!");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.save);

        // Setting Positive "Confirm" Button
        alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // If user pressed Confirm button part is here
                startActivity(new Intent(Booking.this, OrderSplash.class));
            }
        });

        // Setting Negative "Cancel" Button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // If user pressed Cancel button part is here
                startActivity(new Intent(Booking.this, Booking.class));
                Toast.makeText(getApplicationContext(), "Changes aren't saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick (View view){

        if (view == Confirm_booking) {

            booking();

        }

    }

}
