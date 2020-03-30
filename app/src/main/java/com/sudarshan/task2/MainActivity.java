package com.sudarshan.task2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Button alert;
    Button date;
    private int Year, Month, Day;
    Button snackBar;
    Button toast;
    Button progressBar;
    //AVLoadingIndicatorView avloading;
    AVLoadingIndicatorView avi;
    //CalendarView mycalender = findViewById(R.id.calenderView);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert = findViewById(R.id.alertBox);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        date = findViewById(R.id.datePicker);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                Year = calendar.get(Calendar.YEAR);
                Month = calendar.get(Calendar.MONTH);
                Day =  calendar.get(Calendar.DAY_OF_MONTH);
                 DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         date.setText(new StringBuilder().append(dayOfMonth).append("-").append(month).append("-").append(year));
                     }
                 },Year,Month,Day);
                 datePickerDialog.show();
            }
        });

        snackBar = findViewById(R.id.snackBar);
        snackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar sb = Snackbar.make(v, "Isn't it good",Snackbar.LENGTH_LONG);
                sb.show();
            }
        });


        toast = findViewById(R.id.toastButton);
        toast.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Made By Sudarshan Sinha", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        progressBar = findViewById(R.id.progressBar);
        avi = findViewById(R.id.avl);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBar();
            }
        });


    }
    int sum=0;

    public void setProgressBar()
    {
        if (sum == 0)
        {
            avi.animate().alpha(1).setDuration(10);
            //avi.animate().alpha(0).setDuration(10);
            sum = 1;

        }else {
            avi.animate().alpha(0).setDuration(10);
            sum = 0;
        }
    }

    public void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sudarshan's app");
        final View custom = getLayoutInflater().inflate(R.layout.dialog_file,null);
        builder.setView(custom);

        builder.setPositiveButton("Nice", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("It's Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    }




