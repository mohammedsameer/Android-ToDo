package mytodoapplication.msameer.todo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameText = (TextView) this.findViewById(R.id.nameText);
        nameText.setText("Hello Mohammed Sameer");

        // Car image overridden in java layer
        ImageView carImage = (ImageView) this.findViewById(R.id.shoppingCartImg);
        carImage.setImageResource(R.drawable.ic_shopping_cart);

        Button clickMeButton = (Button)  this.findViewById(R.id.showCartButton);
        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListView listView = (ListView) findViewById(R.id.groceryList);
                final GroceryAdapter groceryAdapter = new GroceryAdapter();
                listView.setAdapter(groceryAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, groceryAdapter.items.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Grocery adapter
     */
    public class GroceryAdapter extends BaseAdapter {

        List<String> items = new ArrayList<>();

        public GroceryAdapter() {
            items.add("Milk");
            items.add("Egg");
            items.add("Cheese");
            items.add("Bread");
            items.add("Apple");
            items.add("Banana");
            items.add("Mango");
            items.add("Cherry");
            items.add("Strawberry");
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View listItemView = inflater.inflate(R.layout.list_item, parent, false);

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.bulletImg);
            TextView textView = (TextView) listItemView.findViewById(R.id.listItem);

            imageView.setImageResource(R.drawable.ic_action_navigation_check);
            textView.setText(items.get(position));

            return listItemView;
        }
    }
}
