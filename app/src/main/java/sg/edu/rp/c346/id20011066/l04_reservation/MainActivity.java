package sg.edu.rp.c346.id20011066.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText size;
    DatePicker dp;
    TimePicker tp;
    CheckBox smoking;
    Button btnConfirm;
    Button btnReset;
    TextView information1;
    TextView information2;
    TextView information3;
    TextView information4;
    TextView information5;
    TextView information6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextPhone);
        size = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smoking = findViewById(R.id.checkSmoking);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);

        information1 = findViewById(R.id.textInformation1);
        information2 = findViewById(R.id.textInformation2);
        information3 = findViewById(R.id.textInformation3);
        information4 = findViewById(R.id.textInformation4);
        information5 = findViewById(R.id.textInformation5);
        information6 = findViewById(R.id.textInformation6);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = dp.getMonth() + 1;
                String number = size.getText().toString();
                
                int iSize = Integer.parseInt(number);

                if(iSize > 5) {
                    Toast.makeText(MainActivity.this, "Max 5 people allowed", Toast.LENGTH_LONG).show();

                }

                if(name.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "You did not enter your name", Toast.LENGTH_LONG).show();
                } else {
                    information1.setText("Name: " + name.getText().toString());
                }

                if(phone.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "You did not enter your phone number", Toast.LENGTH_LONG).show();
                } else {
                    information2.setText("Phone: " + phone.getText().toString());
                }

                if(size.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "You did not enter the number of people", Toast.LENGTH_LONG).show();
                } else {
                    information3.setText("Size: " + size.getText().toString() + "people");
                }

                information4.setText("Date allocated: " + dp.getDayOfMonth() + "/" + month  + "/" + dp.getYear());
                information5.setText("Time allocated: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute());

                if(smoking.isChecked()) {
                    information6.setText("Table: " + smoking.getText().toString());
                } else {
                    information6.setText("Table: " + smoking.getText().toString());
                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2021, 5, 1);
                name.setText(" ");
                phone.setText(" ");
                size.setText(" ");
                smoking.setChecked(false);
                information1.setText(" ");
                information2.setText(" ");
                information3.setText(" ");
                information4.setText(" ");
                information5.setText(" ");
                information6.setText(" ");

            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay > 20 || hourOfDay < 8) {
                   Toast.makeText(MainActivity.this, "Opened between 8am to 8:59pm ", Toast.LENGTH_LONG).show();
                   tp.setCurrentHour(8);
                   tp.setCurrentMinute(00);
                }
            }
        });
    }
}