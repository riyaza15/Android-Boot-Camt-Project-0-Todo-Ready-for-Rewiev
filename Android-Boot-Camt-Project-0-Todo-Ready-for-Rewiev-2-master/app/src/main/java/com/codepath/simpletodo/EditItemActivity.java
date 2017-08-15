package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String stItemText = getIntent().getStringExtra("item_text");
        EditText eItemText = (EditText) findViewById(R.id.editText);
        eItemText.setText(stItemText);
        eItemText.setSelection(stItemText.length());

        itemPosition = getIntent().getIntExtra("item_position", -1);


    }

    public void onSave(View v) {
        Intent data = new Intent();

        EditText eItemText = (EditText) findViewById(R.id.editText);
        data.putExtra("item_text", eItemText.getText().toString());
        data.putExtra("item_position", itemPosition);

        setResult(RESULT_OK, data);        this.finish();
    }


}
