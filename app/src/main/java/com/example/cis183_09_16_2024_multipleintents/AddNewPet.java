package com.example.cis183_09_16_2024_multipleintents;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class AddNewPet extends AppCompatActivity {
    Button btn_j_addNew_addPet;
    Intent intent_j_MainActivity;
    TextView et_j_name;
    TextView et_j_age;
    ArrayList<Pet> petdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_pet);

        btn_j_addNew_addPet = findViewById(R.id.btn_v_newPet_addPet);
        et_j_name = findViewById(R.id.et_v_name);
        et_j_age = findViewById(R.id.et_v_age);



        //code to get info passed from mainactivity.java
        //get the intent that called me

        Intent cameFrom = getIntent();
        petdata = new ArrayList<Pet>();
        if(cameFrom.getSerializableExtra("Petdata") != null)
        {
            Log.d("HEre", "Did this start?");
            petdata = (ArrayList<Pet>)cameFrom.getSerializableExtra("Petdata");
        }
        //get the bundle that was passed to me from "cameFrom" intent
        //Get the info in the bundle called "InfoPassed" -> set in MainActivity.java
        intent_j_MainActivity = new Intent(AddNewPet.this, MainActivity.class);
        addPetButtonListener();


    }
    private void eventlistner()
    {
        et_j_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
            String vaildage;
            vaildage = et_j_age.getText().toString();
            if(Integer.parseInt(vaildage) == 0)
            {

            }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void addpet()
    {
        if(!et_j_name.getText().toString().isEmpty() && !et_j_age.getText().toString().isEmpty())
        {
            Pet pettoadd = new Pet();
            pettoadd.setName(et_j_name.getText().toString());
            pettoadd.setAge(Integer.parseInt(et_j_age.getText().toString()));
            petdata.add(pettoadd);
        }
    }

    private void addPetButtonListener()
    {
        btn_j_addNew_addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addpet();
                intent_j_MainActivity.putExtra("Petdata", petdata);
                startActivity(intent_j_MainActivity);
            }
        });
    }



}