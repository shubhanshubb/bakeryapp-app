package hicham.info3245.com.bakeryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    SQLiteDatabase bakeryappdb;
    Cursor resultSet;
    SharedPreferences sharedPref;

    String username = "";
    String password = "";
    String email = "";
    String phone = "";
    TextView tvOrders;
    String myOrders;

    protected void onResume(){
        super.onResume();
        TextView tvName = (TextView)findViewById(R.id.tvName);
        TextView tvAddress = (TextView)findViewById(R.id.tvAddress);
        TextView tvPhoneInfo = (TextView)findViewById(R.id.tvPhoneInfo);
        TextView tvEmail = (TextView)findViewById(R.id.tvEmail);
        TextView tvPayment = (TextView)findViewById(R.id.tvPayment);
        tvOrders = (TextView)findViewById(R.id.tvOrders);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        username = sharedPref.getString("Username", "");
        password = sharedPref.getString("Password", "");

        bakeryappdb = openOrCreateDatabase("bakery db", MODE_PRIVATE, null);
        resultSet = bakeryappdb.rawQuery("SELECT Username, Phone, Address, Email, Cardholder, Creditcard, ShoppingCart, CartTotal FROM Accounts WHERE Username = '" + username + "' AND Password = '" + password + "'", null);
        resultSet.moveToFirst();

        tvName.setText("WELCOME Mr/Ms: " + resultSet.getString(0));
        tvAddress.setText("Address: " + resultSet.getString(2));
        tvPhoneInfo.setText("Telephone: " + resultSet.getString(1));
        tvEmail.setText("Email: " + resultSet.getString(3));
        tvPayment.setText("Payment Info: Visa " + resultSet.getString(5));
       myOrders = ("Pending Orders: " + resultSet.getString(6) + "Cart Total: Rs"  + resultSet.getString(7));

        System.out.println(resultSet.getString(4) + " " + resultSet.getString(5));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btnShop = (Button)findViewById(R.id.btnShop);
        Button btnAddPaymentInfo = (Button)findViewById(R.id.btnAddPaymentInfo);
        Button btnViewOrders = (Button)findViewById(R.id.btnvieworder);
        TextView profile = (TextView) findViewById(R.id.tvProfile);


        btnAddPaymentInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, AddPaymentInfo.class));
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, CategoriesPage.class));
            }
        });

        btnViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvOrders.setText(myOrders);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, ProfileActivity.class));
            }
        });
    }
}
