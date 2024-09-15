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

public class Login extends AppCompatActivity {
    String username = "";
    String password = "";
    Cursor resultSet;
    SQLiteDatabase bakeryappdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bakeryappdb = openOrCreateDatabase("bakery db", MODE_PRIVATE, null);

        //Incase adding new columns to table, uncomment these
        // bakeryappdb.execSQL("DROP TABLE Goods");
        //bakeryappdb.execSQL("DROP TABLE Accounts");

        bakeryappdb.execSQL("CREATE TABLE IF NOT EXISTS Accounts(" +
                "Username VARCHAR," +
                " Password VARCHAR," +
                " Address VARCHAR DEFAULT 'Not Specified'," +
                " Email VARCHAR," +
                " Phone VARCHAR," +
                " Cardholder VARCHAR DEFAULT 'Not Specified'," +
                " Creditcard VARCHAR DEFAULT 'Not Specified'," +
                " ShoppingCart VARCHAR DEFAULT ''," +
                " CartTotal REAL DEFAULT 0.0);");

        bakeryappdb.execSQL("CREATE TABLE IF NOT EXISTS Goods(" +
                "Name VARCHAR," +
                " Description VARCHAR," +
                " Category VARCHAR," +
                " Price VARCHAR);");

        bakeryappdb.execSQL("INSERT INTO Accounts (Username, Password, Address, Email, Phone) " +
                "VALUES('admin','admin', '9500 Goose Rd Unit #402', 'bakeryadmin@gmail.com', '1-800-BAKERY-APP');");

        //Non vegs values
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenbiryani','order of 1','Non Vegs','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonbiryani','order of 2','Non Vegs','399');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenkorma','order of 3','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonkorma','order of 4','Non Vegs','450');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fishrice','order of 5','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fishcurry','order of 6','Non Vegs','399');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenkabab','order of 7','Non Vegs','300');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenchops','order of 8','Non Vegs','500');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonfry','order of 9','Non Vegs','400');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonchukka','order of 10','Non Vegs','399');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonrogan','order of 11','Non Vegs','600');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonbarra','order of 12','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttondahiwala','order of 13','Non Vegs','400');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonkeema','order of 14','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenkalimirch','order of 15','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenafghani','order of 16','Non Vegs','300');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenmalaltikka','order of 17','Non Vegs','299');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenstew','order of 18','Non Vegs','350');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenchilly','order of 19','Non Vegs','250');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenfryrice','order of 20','Non Vegs','300');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('butterchicken','order of 21','Non Vegs','300');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickencutlet','order of 22','Non Vegs','349');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('tandoorichicken','order of 23','Non Vegs','249');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fishbaked','order of 24','Non Vegs','400');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('butteredshrimp','order of 25','Non Vegs','350');");
        //Vegs
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('plainrice','Order of 1','Vegs','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('jeerarice','Order of 2','Vegs','25');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('masalarice','Order of 3','Vegs','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttorrice','Order of 4','Vegs','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('vegpulao','Order of 5','Vegs','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('vegbiryani','Order of 6','Vegs','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('aloojeera','Order of 7','Vegs','100');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('mushroommasala','Order of 8','Vegs','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('vegetablekorma','Order of 9','Vegs','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paneerbutter','Order of 1','Vegs','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paneerkurma','Order of 10','Vegs','45');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('allomasala','Order of 11','Vegs','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('sambarcurry','Order of 12','Vegs','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('sambarvada','Order of 13','Vegs','45');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('mixveg','Order of 14','Vegs','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('pumkingcurry','Order of 15','Vegs','29');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('tamatocurry','Order of 16','Vegs','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('vegkorma','Order of 17','Vegs','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paneermasala','Order of 18','Vegs','60');");

        //VegRolls
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paneerroll','Order of 1','VegRolls','56');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paneerbhurjiroll','Order of 2','VegRolls','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('potatoroll','Order of 3','VegRolls','56');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('eggroll','Order of 4','VegRolls','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('mushroomroll','Order of 5','VegRolls','32');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('soysroll','Order of 6','VegRolls','32');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('vegseekhroll','Order of 7','VegRolls','32');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cheessoyaroll','Order of 8','VegRolls','149');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cauliflowerroll','Order of 9','VegRolls','89');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('soyacheesroll','Order of 10','VegRolls','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('musroombutterroll','Order of 11','VegRolls','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('eggbutterroll','Order of 12','VegRolls','70');");


        //Breads
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('frenchbread','Order of 13','Breads','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gobiparatha','Order of 14','Breads','90');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('grilledcornandpeachflatbread','Order of 15','Breads','100');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('honeybourdoughbread','Order of 16','Breads','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('lemonicecream','Order of 17','Breads','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('multigraintoast','Order of 18','Breads','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('mushroomflatbread','Order of 19','Breads','90');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('naan','Order of 20','Breads','100');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('panettonebread','Order of 21','Breads','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('paratha','Order of 22','Breads','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('punjabialooparatha','Order of 23','Breads','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('ryebread','Order of 24','Breads','90');");

//Sweets
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gulabjamun','order of 1','Sweets','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('carrothalwa','order of 2','Sweets','69');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('phirni','order of 3','Sweets','55');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('kajukatli','order of 4','Sweets','85');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('jalebi','order of 5','Sweets','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('rasmalai','order of 6','Sweets','59');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('kheerpoore','order of 7','Sweets','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('peanutchikki','order of 8','Sweets','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('nankhatai','order of 9','Sweets','60');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('guavacheese','order of 10','Sweets','89');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('kheer','order of 11','Sweets','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('kalakhand','order of 12','Sweets','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('petha','order of 13','Sweets','60');");

        //Non VegRolls
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenroll','order of 1','Non VegRolls','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonroll','order of 2','Non VegRolls','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('keemaroll','order of 3','Non VegRolls','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickentandooriroll','order of 4','Non VegRolls','45');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttoneggroll','order of 5','Non VegRolls','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenroll','order of 6','Non VegRolls','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenkathiroll','order of 7','Non VegRolls','30');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fishroll','order of 8','Non VegRolls','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chickenchillyroll','order of 9','Non VegRolls','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttontandooriroll','order of 10','Non VegRolls','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('muttonkemaroll','order of 11','Non VegRolls','60');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fishtandooriroll','order of 12','Non VegRolls','35');");



        //Ice-Cream values
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('bananaicecream','order of 1','Ice-Cream','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('blackberryblueberryicecream','order of 2','Ice-Cream','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('blackcurranticecream','order of 3','Ice-Cream','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('blackcurranticecreambox','order of 4','Ice-Cream','45');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('blackraspberryicecream','order of 5','Ice-Cream','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('bubblegumicecreamphoto','order of 6','Ice-Cream','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chamomileblackberryicecream','order of 7','Ice-Cream','30');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chocolatebrowniewithvanillaicecream','order of 8','Ice-Cream','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chocolatecakewithstrawberrybuttercream','order of 9','Ice-Cream','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('coconutmilkicecream','order of 10','Ice-Cream','39');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('coffeeanddonutsicecream','order of 11','Ice-Cream','60');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cottoncandyicecream','order of 12','Ice-Cream','35');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cottoncandyicecreammint','order of 13','Ice-Cream','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('creamyclassicchocolateicecream','order of 14','Ice-Cream','30');");

        //Shakes values
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('bananaproteinsmoothieormilkshake','order of 1','Shakes','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('bananasplitmilkshake','order of 2','Shakes','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('blackandbluepowersoothie','order of 3','Shakes','60');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('caramelshake','order of 4','Shakes','50');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cherryblossom','order of 5','Shakes','55');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cherrymilkshake','order of 6','Shakes','60');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cherryvanilla','order of 7','Shakes','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cherryvanillamilkshake','order of 8','Shakes','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('chocolateshake','order of 9','Shakes','40');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('coffeecaramelmylkshake.pong','order of 10','Shakes','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('cookiebuttermilkshakes','order of 11','Shakes','65');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('doublehazelhutchocolatemilkshake','order of 12','Shakes','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('fruitshake','order of 13','Shakes','50');");

        //Candys & Jellys
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('candycanes','order of 1','Candys & Jellys','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('candycorn','order of 2','Candys & Jellys','69');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gumballs','order of 3','Candys & Jellys','55');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gumdrops','order of 4','Candys & Jellys','85');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gummiworms','order of 5','Candys & Jellys','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('gummybears','order of 6','Candys & Jellys','59');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('heartjelly','order of 7','Candys & Jellys','70');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('jellybeans','order of 8','Candys & Jellys','80');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('sourrainbow','order of 12','Candys & Jellys','75');");
        bakeryappdb.execSQL("INSERT INTO Goods VALUES('sweetcandy','order of 13','Candys & Jellys','60');");


        Button buttonLogin = (Button)findViewById(R.id.btnLogin);
        Button buttonSignup = (Button)findViewById(R.id.btnJoin);

        final TextView txtError = (TextView)findViewById(R.id.txtError);
        final EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();

                resultSet = bakeryappdb.rawQuery("SELECT Username, Password FROM Accounts WHERE Username = '" + username + "' AND Password = '" + password + "'" , null);
                resultSet.moveToFirst();
                if(resultSet.getCount() <= 0){
                    txtError.setText("Incorrect username and or password");
                }else {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("Username", username);
                    editor.putString("Password", password);
                    editor.commit();

                    txtError.setText("");
                    startActivity(new Intent(Login.this, Profile.class));
                }
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Login.this, CreateAccount.class));
            }
        });
    }

}


