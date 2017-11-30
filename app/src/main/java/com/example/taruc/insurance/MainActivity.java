package com.example.taruc.insurance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinner);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //create an adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Position:"+ position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view)
    {
        double premium = 0;
        int pos;
        pos = spinnerAge.getSelectedItemPosition();
        //TODO: determine the basic program
        if(pos == 0)
            premium += 50;
        else if(pos == 1)
            premium += 55;
        else if(pos == 2)
            premium += 60;
        else if(pos == 3)
            premium += 70;
        else if(pos == 4)
            premium += 120;
        else if(pos == 5)
            premium += 160;
        else if(pos == 6)
            premium += 200;
        else if(pos == 7)
            premium += 250;

        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender == R.id.radioButtonMale) {
            //TODO: calculate premium for male
            if(pos == 0)
                premium += 0;
            else if(pos == 1)
                premium +=0;
            else if(pos == 2)
                premium += 50;
            else if(pos == 3)
                premium += 100;
            else if(pos == 4)
                premium += 100;
            else if(pos == 5)
                premium += 50;
            else if(pos == 6)
                premium += 0;
            else if(pos == 7)
                premium += 0;

        }

        if(checkBoxSmoker.isChecked())
        {
            //TODO: calculate premium for smoker
            if(pos == 1)
                premium += 0;
            else if(pos == 2)
                premium +=0;
            else if(pos == 3)
                premium += 0;
            else if(pos == 4)
                premium += 100;
            else if(pos == 5)
                premium += 150;
            else if(pos == 6)
                premium += 150;
            else if(pos == 7)
                premium += 250;
            else if(pos == 8)
                premium += 250;


        }
        textViewPremium.setText(getString(R.string.premium)+":"+ premium);
    }

    public void resetPremium(View view)
    {
        //TODO: clear UI and reset premium value
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(true);
        radioButtonFemale.setChecked(false);
        checkBoxSmoker.setChecked(false);
    }
}
