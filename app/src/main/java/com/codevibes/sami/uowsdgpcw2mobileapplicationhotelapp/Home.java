package com.codevibes.sami.uowsdgpcw2mobileapplicationhotelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button My_account_button;
    private Button Previous_orders_button;
    private Button Book_now_button;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //listView = (ListView) findViewById(R.id.listView);
        My_account_button = (Button) findViewById(R.id.My_account_button);
        Previous_orders_button = (Button) findViewById(R.id.Previous_orders_button);
        Book_now_button = (Button) findViewById(R.id.Book_now_button);

        My_account_button.setOnClickListener(this);
        Previous_orders_button.setOnClickListener(this);
        Book_now_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == My_account_button) {
            startActivity(new Intent(Home.this, edit_account.class));
        } else if (view == Previous_orders_button) {
            startActivity(new Intent(Home.this, Login.class));
        } else if (view == Book_now_button){
            startActivity(new Intent(Home.this, Booking.class));
        }
    }
}
