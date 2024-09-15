package hicham.info3245.com.bakeryapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {
    Cursor resultSet;
    SQLiteDatabase bakeryappdb;
    String name, email, phone, password, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        bakeryappdb = openOrCreateDatabase("bakery db", MODE_PRIVATE, null);

        final TextView txtError = (TextView)findViewById(R.id.txtError);

        final EditText txtName = (EditText)findViewById(R.id.txtName);
        final EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        final EditText txtPhone = (EditText)findViewById(R.id.txtPhone);
        final EditText txtCreatePass = (EditText)findViewById(R.id.txtCreatePass);
        final EditText txtConfirmPass = (EditText)findViewById(R.id.txtConfirmPass);

        Button btnCreate = (Button)findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                email = txtEmail.getText().toString();
                phone = txtPhone.getText().toString();
                password = txtCreatePass.getText().toString();
                confirmPass = txtConfirmPass.getText().toString();

                if(name.compareTo("") == 0){
                    txtError.setText("Please enter a valid username");
                    return;
                }
                if(email.compareTo("") == 0){
                    txtError.setText("Please enter a valid email");
                    return;
                }
                if(phone.compareTo("") == 0){
                    txtError.setText("Please enter a valid phone");
                    return;
                }
                if(password.compareTo("") == 0){
                    txtError.setText("Please enter a valid password");
                    return;
                }
                if(!(confirmPass.compareTo(password) == 0)){
                    txtError.setText("Make sure your passwords match!");
                    return;
                }
                txtError.setText("Success");

                bakeryappdb.execSQL("INSERT INTO Accounts (Username, Password, Email, Phone) " +
                        "VALUES('" + name +"','" + password +"', '"+ email +"', '"+ phone +"');");
            }
        });

    }
}
