package com.example.vidhishah.simpletodogithub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
    }


            public void onEditItems(View view) {


                EditText editedittext = (EditText) findViewById(R.id.editedittext);
                Intent data = new Intent();
                String itemText = editedittext.getText().toString();
                data.putExtra("",itemText);
                setResult(1,data);
                finish();
                //System.out.println(itemText);
                //itemsAdapter.add(itemText);
                //editedittext.setText("");
                //writeItems();

            }
   /* private void writeItems() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}


