package com.example.rajshekhar.toggle_check_edit_saveprefrence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox checkBox;
    EditText editText;
    Button button;
    ToggleButton toggleButton;
    boolean on=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        editText = (EditText) findViewById(R.id.editText1);
        toggleButton=(ToggleButton)findViewById(R.id.toggle);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
        loadSavePrefrence();

    }
    private void loadSavePrefrence() {
      SharedPreferences sharedPreferences =PreferenceManager
              .getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        boolean toogleValue=sharedPreferences.getBoolean("toogle_value",false);
        String et_name=sharedPreferences.getString("et_value","YourName");


        //checkbox
        if(checkBoxValue){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }

        //toogle
        if(toogleValue){
            toggleButton.setChecked(true);
        }else {
            toggleButton.setChecked(false);
        }
        if(toggleButton.isChecked()){
            toggleButton.setChecked(true);
        }else {

            toggleButton.setChecked(false);
        }

        //Edit_text
        editText.setText(et_name);

    }
    private void savePreferencesBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    private void  savePreferenceString(String key,String value){
        SharedPreferences sharedPreferences=PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();

    }

    @Override
    public void onClick(View v) {
        savePreferencesBoolean("CheckBox_Value",checkBox.isChecked());
        savePreferencesBoolean("toogle_value",toggleButton.isChecked());
        if(checkBox.isChecked() && toggleButton.isChecked())
            savePreferenceString("et_value",editText.getText().toString());
            finish();

    }
}
