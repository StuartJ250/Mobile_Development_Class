package com.example.d308jacobson.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.d308jacobson.R;
import com.example.d308jacobson.database.Repository;
import com.example.d308jacobson.entities.Excursion;
import com.example.d308jacobson.entities.Vacation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.List;

public class VacationList extends AppCompatActivity {

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vacation_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VacationList.this, VacationDetails.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        repository= new Repository(getApplication());
        List<Vacation> allVacations = repository.getmAllVacations();
        final VacationAdapter vacationAdapter = new VacationAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vacationAdapter);
        vacationAdapter.setVacations(allVacations);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_vacation_list, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        if(item.getItemId() == R.id.sample){
            repository = new Repository(getApplication());
            //Toast.makeText(VacationList.this, "put in sample data", Toast.LENGTH_LONG).show();
            Vacation vacation = new Vacation(0, "Kokomo", "Taco Bell", "3/30/2025", "4/10/2025");
            repository.insert(vacation);
            vacation = new Vacation(0, "Bermuda", "Motel 9", "3/30/2025", "4/10/2025");
            repository.insert(vacation);
            Excursion excursion = new Excursion(0, "Biking", "4/01/2025", 1);
            repository.insert(excursion);
            excursion = new Excursion(0, "Hiking", "4/01/2025", 1);
            repository.insert(excursion);


            return true;
        }

        if(item.getItemId() == R.id.sample2){
            Toast.makeText(VacationList.this, "put in sample data", Toast.LENGTH_LONG).show();
            return true;
        }

        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return true;

    }
}