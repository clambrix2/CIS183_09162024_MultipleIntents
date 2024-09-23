package com.example.cis183_09_16_2024_multipleintents;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_j_goToAddPet;
    ListView lv_j_listOfPets;
    Intent intent_j_addNewPet;
    ArrayList<Pet> petArrayList;
    Custom_Cell adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_j_goToAddPet = findViewById(R.id.btn_v_main_addNewPet);
        lv_j_listOfPets  = findViewById(R.id.lv_v_listOfPets);


        Intent cameFrom = getIntent();
        petArrayList = new ArrayList<>();
        if(cameFrom.getSerializableExtra("Petdata") != null)
        {
            petArrayList = (ArrayList<Pet>) cameFrom.getSerializableExtra("Petdata");
            filllist();
        }


        //give the intent the following info:
        //the class that you came from
        //the class you want to open
        intent_j_addNewPet = new Intent(MainActivity.this, AddNewPet.class);
        if(petArrayList != null)
        {
            intent_j_addNewPet.putExtra("Petdata", petArrayList);
        }
        //setup the button listener
        addNewPetButtonListener();
    }
    private void testing()
    {
        for(int i = 0; i < petArrayList.size(); i++)
        {
            Log.d("Name", petArrayList.get(i).getName());
            Log.d("Age", petArrayList.get(i).getAge() + "");
        }
    }


    private void addNewPetButtonListener()
    {
        btn_j_goToAddPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_addNewPet);
            }
        });
    }
    private void filllist()
    {
        Log.d("Here", "creating adaptor info");
            for(int i = 0; i < petArrayList.size(); i++)
            {
                adapter = new Custom_Cell(this, petArrayList);
            }
            lv_j_listOfPets.setAdapter(adapter);


    }

}