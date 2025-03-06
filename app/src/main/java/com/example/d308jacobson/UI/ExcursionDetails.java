package com.example.d308jacobson.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.d308jacobson.R;
import com.example.d308jacobson.database.Repository;
import com.example.d308jacobson.entities.Excursion;
import com.example.d308jacobson.entities.Vacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExcursionDetails extends AppCompatActivity {

    String name;
    String date;
    int excursionID;
    int vacationID;

    EditText editName;
    TextView editDate;
    EditText editNote;

    Repository repository;
    Excursion currentExcursion;

    DatePickerDialog.OnDateSetListener datePicker;
    final Calendar myCalendarStart = Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_excursion_details);
        repository = new Repository(getApplication());

        name = getIntent().getStringExtra("name");
        editName = findViewById(R.id.excursionnametext);
        editName.setText(name);

        date = getIntent().getStringExtra("date");
        editDate = findViewById(R.id.editDate);
        editDate.setText(date);

        editNote = findViewById(R.id.note);

        excursionID = getIntent().getIntExtra("id", -1);
        vacationID = getIntent().getIntExtra("vacaID", -1);

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datePicker = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, month);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, day);

                updateLabelStart();
            }
        };

        editDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Date date;
                String info = editDate.getText().toString();
                if(info.equals("")){
                    info="03/01/25";
                }
                try{
                    myCalendarStart.setTime(sdf.parse(info));

                } catch (ParseException e){
                    e.printStackTrace();
                }
                new DatePickerDialog(ExcursionDetails.this, datePicker, myCalendarStart.get(Calendar.YEAR), myCalendarStart.get(Calendar.MONTH), myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    private void updateLabelStart(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editDate.setText(sdf.format(myCalendarStart.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_excursions_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            this.finish();
            return true;
        }
        if(item.getItemId() == R.id.excursionSave) {
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            String excursionDate = sdf.format(myCalendarStart.getTime());

            Vacation vacation = null;
            List<Vacation> vacations = repository.getmAllVacations();
            Excursion excursion;

            for (Vacation vacay : vacations){
                if (vacay.getVacationID() == vacationID){
                    vacation = vacay;
                    break;
                }
            }
            try{
                Date eDate = sdf.parse(excursionDate);
                Date sDate = sdf.parse(vacation.getStartDate());
                Date endDate = sdf.parse(vacation.getEndDate());
                if (eDate.before(sDate) || eDate.after(endDate)){
                    Toast.makeText(this,"Excursion Date must be within Vacation dates", Toast.LENGTH_LONG).show();
                }
                else{
                    if (excursionID == -1) {
                        if (repository.getmAllExcursions().size() == 0) {
                            excursionID = 1;
                            excursion = new Excursion(excursionID, editName.getText().toString(), editDate.getText().toString(), vacationID);
                            repository.insert(excursion);
                            this.finish();
                        }
                        else {
                            excursionID = repository.getmAllExcursions().get(repository.getmAllExcursions().size() - 1).getExcursionID() + 1;
                            excursion = new Excursion(excursionID, editName.getText().toString(), editDate.getText().toString(), vacationID);
                            repository.insert(excursion);
                            this.finish();
                        }

                    }
                    else{
                        excursion = new Excursion(excursionID, editName.getText().toString(), editDate.getText().toString(), vacationID);
                        repository.update(excursion);
                        this.finish();
                    }
                }
            } catch (ParseException e){
                e.printStackTrace();
            }

            return true;
        }

        if(item.getItemId() == R.id.excursionShare){
            Intent sentIntent = new Intent();
            sentIntent.setAction(Intent.ACTION_SEND);
            sentIntent.putExtra(Intent.EXTRA_TITLE, "Excursion Details");
            StringBuilder shareExcursion = new StringBuilder();
            shareExcursion.append("Excursion: " + editName.getText().toString() + "\n");
            shareExcursion.append("Date: " + editDate.getText().toString() + "\n");
            shareExcursion.append("Note: " + editNote.getText().toString() + "\n");
            sentIntent.putExtra(Intent.EXTRA_TEXT, shareExcursion.toString());
            sentIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sentIntent, null);
            startActivity(shareIntent);
            return true;
        }

        if (item.getItemId() == R.id.notify){
            String dateFromScreen = editDate.getText().toString();
            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            Date myDate = null;
            try{
                myDate = sdf.parse(dateFromScreen);
            } catch (ParseException e){
                e.printStackTrace();
            }
            Long trigger = myDate.getTime();
            Intent intent = new Intent(ExcursionDetails.this, MyReceiver.class);
            intent.putExtra("key", "Start Excursion");
            PendingIntent sender = PendingIntent.getBroadcast(ExcursionDetails.this, ++MainActivity.numAlert,intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);

            return true;
        }

        if(item.getItemId() == R.id.excursionDelete){
            for (Excursion excursion : repository.getmAllExcursions()) {
                if (excursion.getExcursionID() == excursionID) {
                    currentExcursion = excursion;
                    break;
                }
            }
            repository.delete(currentExcursion);
            Toast.makeText(ExcursionDetails.this, currentExcursion.getExcursionName() + " was deleted.", Toast.LENGTH_LONG).show();
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onResume(){
        super.onResume();
        updateLabelStart();
    }
}