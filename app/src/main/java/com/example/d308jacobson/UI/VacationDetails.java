package com.example.d308jacobson.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
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

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class VacationDetails extends AppCompatActivity {
    String name;
    String hotel;
    String startDate;
    String endDate;
    int vacationID;

    int numExcursions;

    EditText editName;
    EditText editHotel;
    TextView editStartDate;
    TextView editEndDate;

    Repository repository;
    Vacation currentVacation;
    DatePickerDialog.OnDateSetListener startDatePicker;
    DatePickerDialog.OnDateSetListener endDatePicker;
    final Calendar myStartCalendar = Calendar.getInstance();
    final Calendar myEndCalendar = Calendar.getInstance();

    List<Excursion> filteredExcursion = new ArrayList<>();
    Random rand = new Random();
    int numAlert = rand.nextInt();

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
        startDate = getIntent().getStringExtra("startdate");
        endDate = getIntent().getStringExtra("enddate");
        vacationID = getIntent().getIntExtra("id", -1);
        //Log.d("VacationDetails", "startDate: " + startDate + ", endDate: " + endDate);

        editName.setText(name);
        editHotel.setText(hotel);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VacationDetails.this, ExcursionDetails.class);
                intent.putExtra("vacaID", vacationID);
                intent.putExtra("startdate", startDate);
                intent.putExtra("enddate", endDate);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.excursionrecyclerview);
        repository = new Repository(getApplication());
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for (Excursion e : repository.getmAllExcursions()) {
            if (e.getVacationID() == vacationID) filteredExcursions.add(e);
        }
        excursionAdapter.setmExcursions(filteredExcursions);

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        if (startDate != null && endDate != null) {
            try {
                Date startDate2 = sdf.parse(startDate);
                Date endDate2 = sdf.parse(endDate);
                myStartCalendar.setTime(startDate2);
                myEndCalendar.setTime(endDate2);
                updateLabelStart();
                updateLabelEnd();

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        startDatePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myStartCalendar.set(Calendar.YEAR, year);
                myStartCalendar.set(Calendar.MONTH, month);
                myStartCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabelStart();
            }
        };

        editStartDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Date date;
                String info = editStartDate.getText().toString();
                if (info.equals("")) {
                    info = "03/01/25";
                }
                try {
                    myStartCalendar.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(VacationDetails.this, startDatePicker, myStartCalendar.get(Calendar.YEAR), myStartCalendar.get(Calendar.MONTH), myStartCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endDatePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myEndCalendar.set(Calendar.YEAR, year);
                myEndCalendar.set(Calendar.MONTH, month);
                myEndCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabelEnd();
            }
        };

        editEndDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Date date;
                String info = editEndDate.getText().toString();
                if (info.equals("")) {
                    info = "03/01/25";
                }
                try {
                    myEndCalendar.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(VacationDetails.this, endDatePicker, myEndCalendar.get(Calendar.YEAR), myEndCalendar.get(Calendar.MONTH), myEndCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    public void updateLabelStart() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editStartDate.setText(sdf.format(myStartCalendar.getTime()));
    }

    public void updateLabelEnd() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editEndDate.setText(sdf.format(myEndCalendar.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vacation_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }

        if (item.getItemId() == R.id.vacationSave) {
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            String sDateString = sdf.format(myStartCalendar.getTime());
            String eDateString = sdf.format(myEndCalendar.getTime());

            try{
                Date vStart = sdf.parse(sDateString);
                Date vEnd = sdf.parse(eDateString);
                if(vEnd.before(vStart)){
                    Toast.makeText(VacationDetails.this, "Vacation end date must be after the start date", Toast.LENGTH_LONG).show();
                }else{
                    Vacation vacation;
                    if (vacationID == -1) {
                        if (repository.getmAllVacations().size() == 0) {
                            vacationID = 1;
                        } else {
                            vacationID = repository.getmAllVacations().get(repository.getmAllVacations().size() - 1).getVacationID() + 1;
                        }
                        vacation = new Vacation(vacationID, editName.getText().toString(), editHotel.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                        repository.insert(vacation);
                        this.finish();

                    } else {
                        vacation = new Vacation(vacationID, editName.getText().toString(), editHotel.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                        repository.update(vacation);
                        this.finish();
                    }
                }
            }catch (ParseException e){
                e.printStackTrace();
            }

        }

        if (item.getItemId() == R.id.vacationNotifyStart){
            String sDateFromScreen = editStartDate.getText().toString();
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            Date myStartDate = null;
            try{
                myStartDate = sdf.parse(sDateFromScreen);
            } catch (ParseException e){
                e.printStackTrace();
            }
            Long sTrigger = myStartDate.getTime();
            Intent intent = new Intent(VacationDetails.this, MyReceiver.class);
            intent.putExtra("key", "Start of Vacation");
            PendingIntent sender = PendingIntent.getBroadcast(VacationDetails.this, ++MainActivity.numAlert, intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, sTrigger, sender);
        }

        if (item.getItemId() == R.id.vacationNotifyEnd){
            String eDateFromScreen = editEndDate.getText().toString();
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


            Date myEndDate = null;
            try{
                myEndDate = sdf.parse(eDateFromScreen);
            } catch (ParseException e){
                e.printStackTrace();
            }
            Long sTrigger = myEndDate.getTime();
            Intent intent = new Intent(VacationDetails.this, MyReceiver.class);
            intent.putExtra("key", "End of Vacation");
            PendingIntent sender = PendingIntent.getBroadcast(VacationDetails.this, ++MainActivity.numAlert, intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, sTrigger, sender);
        }

        if (item.getItemId() == R.id.vacationDelete) {

            for (Vacation vacation : repository.getmAllVacations()) {
                if (vacation.getVacationID() == vacationID) {
                    currentVacation = vacation;
                    break;
                }
            }
            numExcursions = 0;
            for (Excursion excursion : repository.getmAllExcursions()) {
                if (excursion.getVacationID() == vacationID) {
                    numExcursions++;
                }
            }
            if (numExcursions == 0) {
                repository.delete(currentVacation);
                Toast.makeText(VacationDetails.this, currentVacation.getVacationName() + " was deleted.", Toast.LENGTH_LONG).show();
                this.finish();
            }
            else {
                Toast.makeText(VacationDetails.this, "Can't delete a Vacation with excursions", Toast.LENGTH_LONG).show();
            }
        }

        if(item.getItemId() == R.id.vacationShare){
            Intent sentIntent = new Intent();
            sentIntent.setAction(Intent.ACTION_SEND);;
            sentIntent.putExtra(Intent.EXTRA_TITLE, "Sharing Vacation");
            StringBuilder shareVacation = new StringBuilder();
            shareVacation.append("Vacation: " + editName.getText().toString() + "\n");
            shareVacation.append("Hotel: " + editHotel.getText().toString() + "\n");
            shareVacation.append("Start Date: " + editStartDate.getText().toString() + "\n");
            shareVacation.append("End Date: " + editEndDate.getText().toString() + "\n");
            for (int i = 0; i < filteredExcursion.size(); i++){
                shareVacation.append( (i + 1) + ". " + filteredExcursion.get(i).getExcursionName() + "\n");
                shareVacation.append("     Date: " + filteredExcursion.get(i).getExcursionDate() + "\n");
            }
            sentIntent.putExtra(Intent.EXTRA_TEXT, shareVacation.toString());
            sentIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sentIntent, null);
            startActivity(shareIntent);
            return true;
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
            if (e.getVacationID() == vacationID) filteredExcursions.add(e);
        }
        excursionAdapter.setmExcursions(filteredExcursions);
    }

}