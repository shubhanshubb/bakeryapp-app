package hicham.info3245.com.bakeryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoriesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_page);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPref.edit();

        ////////add new categoies
        String[] categories = new String[] {"Non Vegs","Vegs","VegRolls","Breads","Sweets","Non VegRolls","Ice-Cream","Shakes","Candys & Jellys"};

        final ListView listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.textView, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);

                switch(itemValue) {
                    case "Non Vegs":
                        editor.putString("Category", "Non Vegs");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Vegs":
                        editor.putString("Category","Vegs");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "VegRolls":
                        editor.putString("Category","VegRolls");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Breads":
                        editor.putString("Category", "Breads");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Sweets":
                        editor.putString("Category", "Sweets");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Non VegRolls":
                        editor.putString("Category", "Non VegRolls");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Ice-Cream":
                        editor.putString("Category", "Ice-Cream");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;


                    case "Candys & Jellys":
                        editor.putString("Category", "Candys & Jellys");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;

                    case "Shakes":
                        editor.putString("Category", "Shakes");
                        editor.commit();
                        startActivity(new Intent(CategoriesPage.this, DisplayItemsByCategory.class));
                        break;
                }
            }
        });

    }
}
