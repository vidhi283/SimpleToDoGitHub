package com.example.vidhishah.simpletodogithub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView Lvitems;
    Intent EditIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lvitems = (ListView)findViewById(R.id.Lvitems);
        items = new ArrayList<>();
        readItems();
        itemsAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,items);
        Lvitems.setAdapter(itemsAdapter);
        items.add("first item");
        items.add("second item");
        setupListViewListener();
        setupListViewClickListener();
        //launchComposeView();
    }

    private void setupListViewListener(){
        Lvitems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int pos, long id) {
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });
    }

    private void setupListViewClickListener(){
        Lvitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                i.putExtra("mode", 2);
                startActivityForResult(i, 1);
                writeItems();
                //return true;

            }
        });

        }

    public void onAddItems(View view) {


                EditText addedittext = (EditText) findViewById(R.id.addedittext);
                String itemText = addedittext.getText().toString();
                System.out.println(itemText);
                itemsAdapter.add(itemText);
                addedittext.setText("");
                writeItems();

            }

            private void readItems() {
                File fileDir = getFilesDir();
                File todoFile = new File(fileDir, "todo.txt");
                try {
                    items = new ArrayList<String>(FileUtils.readLines(todoFile));

                } catch (IOException e) {
                    items = new ArrayList<String>();
                }
            }

            private void writeItems() {
                File fileDir = getFilesDir();
                File todoFile = new File(fileDir, "todo.txt");
                try {
                    FileUtils.writeLines(todoFile, items);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == 1) {

            String et1 = data.getExtras().getString("");
            int code = data.getExtras().getInt("code", 0);
            // Toast the name to display temporarily on screen
            Toast.makeText(this, et1, Toast.LENGTH_SHORT).show();
        }
    }

            /*public void launchComposeView() {
                Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                startActivity(i);
            }*/

        }




