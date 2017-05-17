package com.vikranth.stats_account;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int currVal = 108;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        return super.onOptionsItemSelected(item);
    }

    public void Calculate(View view) {
        EditText item_1 = (EditText) findViewById(R.id.item_1);
        EditText item_2 = (EditText) findViewById(R.id.item_2);
        EditText item_3 = (EditText) findViewById(R.id.item_3);
        EditText item_4 = (EditText) findViewById(R.id.item_4);
        TextView textView = (TextView) findViewById(R.id.cost);
        TextView balance = (TextView) findViewById(R.id.balance);
        int sum = getNum(item_1) + getNum(item_2) + getNum(item_3) + getNum(item_4);
        if (currVal - sum > 0) {
            currVal = 108 - sum;
            textView.setText("$" + currVal);
            balance.setText("Current Balance: $" + (108 - currVal));
        } else {
            Toast.makeText(this, "Invalid Move. There is a negative Balnce", Toast.LENGTH_LONG).show();
        }

    }

    public int getNum(EditText editText) {
        if (editText.getText().toString().length() == 0) return 0;
        return Integer.parseInt(editText.getText().toString());
    }
}
