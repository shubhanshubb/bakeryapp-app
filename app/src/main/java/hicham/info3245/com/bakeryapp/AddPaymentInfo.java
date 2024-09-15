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
import android.widget.EditText;
import android.widget.TextView;

public class AddPaymentInfo extends AppCompatActivity {
    String username, password, cardNumber, cardHolder;

    SQLiteDatabase bakeryappdb;
    Cursor resultSet;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment_info);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        username = sharedPref.getString("Username", "");
        password = sharedPref.getString("Password", "");

        bakeryappdb = openOrCreateDatabase("bakery db", MODE_PRIVATE, null);

        final EditText edtxtCardholder = (EditText)findViewById(R.id.edtxtCardholder);
        final EditText numCardNumber = (EditText)findViewById(R.id.numCardNumber);
        final TextView txtError = (TextView)findViewById(R.id.txtError);

        Button btnPaymentInfo =(Button)findViewById(R.id.btnPaymentInfo);
        Button btnCancel =(Button)findViewById(R.id.btncancel);

        btnPaymentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNumber = numCardNumber.getText().toString();
                cardHolder = edtxtCardholder.getText().toString();

                if(cardHolder.compareTo("") == 0){
                    System.out.println(cardNumber);
                    txtError.setText("Please enter the Cardholder\'s name");
                    return;
                }

                if(cardNumber.compareTo("") == 0){
                    txtError.setText("Please enter a Card Number");
                    System.out.println(cardNumber);
                    return;
                }

                bakeryappdb.execSQL("UPDATE Accounts " +
                        "SET Cardholder = '" + cardHolder + "', Creditcard = '" + cardNumber + "' " +
                        "WHERE Username = '" + username + "' AND Password = '" + password + "'");
                System.out.println(cardHolder + " " + cardNumber);

                txtError.setText("Success");
                startActivity(new Intent(AddPaymentInfo.this, Profile.class));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                edtxtCardholder.setText("");
                numCardNumber.setText("");
                Intent intent = new Intent(AddPaymentInfo.this,Profile.class);
                startActivity(intent);
            }
        });

    }
}
