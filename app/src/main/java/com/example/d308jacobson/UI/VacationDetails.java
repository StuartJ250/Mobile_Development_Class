package com.example.d308jacobson.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.List;

public class VacationDetails extends AppCompatActivity {
    String name;
    String hotel;
    String startDate;
    String endDate;
    int vacayID;
    Vacation currentVacation;
    int numExcursions;

    EditText editName;
    EditText editHotel;
    EditText editStartDate;
    EditText editEndDate;

    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vacation_details);

        editName = findViewById(R.id.nametext);
        editHotel = findViewById(R.id.hoteltext);
        editStartDate = findViewById(R.id.startdate);
        editEndDate = findViewById(R.id.enddate);

        name = getIntent().getStringExtra("name");
        hotel = getIntent().getStringExtra("hotel");
        startDate = getIntent().getStringExtra("start date");
        endDate = getIntent().getStringExtra("end date");
        vacayID = getIntent().getIntExtra("id", -1);

        editName.setText(name);
        editHotel.setText(hotel);
        editStartDate.setText(startDate);
        editEndDate.setText(endDate);



        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VacationDetails.this, ExcursionDetails.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.excursionrecyclerview);
        repository = new Repository(getApplication());
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for(Excursion e : repository.getmAllExcursions()){
            if (e.getVacationID() == vacayID) filteredExcursions.add(e);
        }
        excursionAdapter.setmExcursions(filteredExcursions);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_vacation_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }

        if(item.getItemId() == R.id.vacationSave){
            Vacation vacation;
            if(vacayID == -1){
                if(repository.getmAllVacations().size() == 0) {
                    vacayID = 1;
                }
                else {
                    vacayID = repository.getmAllVacations().get(repository.getmAllVacations().size() - 1).getVacationID() + 1;
                }
                vacation = new Vacation(vacayID, editName.getText().toString(), editHotel.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                repository.insert(vacation);
                this.finish();

            }
            else{
                vacation = new Vacation(vacayID, editName.getText().toString(), editHotel.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                repository.update(vacation);
                this.finish();
            }
        }
        if(item.getItemId() == R.id.vacationDelete){

            for(Vacation vacation : repository.getmAllVacations()){
                if(vacation.getVacationID() == vacayID){
                    currentVacation = vacation;
                }
                numExcursions = 0;
                for(Excursion excursion: repository.getmAllExcursions()){
                    if(excursion.getVacationID() == vacayID){
                        ++numExcursions;
                    }
                }
                if(numExcursions == 0){
                    repository.delete(currentVacation);
                    Toast.makeText(VacationDetails.this, currentVacation.getVacationName() + " was deleted.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(VacationDetails.this, "Can't delete a Vacation with excursions", Toast.LENGTH_LONG).show();
                }
            }
        }
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.excursionrecyclerview);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for(Excursion e : repository.getmAllExcursions()){
            if (e.getVacationID() == vacayID) filteredExcursions.add(e);
        }
        excursionAdapter.setmExcursions(filteredExcursions);
    }

}