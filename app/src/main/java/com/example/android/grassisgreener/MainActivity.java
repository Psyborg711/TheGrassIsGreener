package com.example.android.grassisgreener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitClicked (View view)
    {
        // Declare boolean to let the array know when the last parameter has been added
        boolean endOfList = false;

        // Declaring Spinner objects for each of the user choices
        Spinner sp1 = (Spinner) findViewById(R.id.firstCitySpinner);
        Spinner sp2 = (Spinner) findViewById(R.id.secondCitySpinner);
        Spinner sp3 = (Spinner) findViewById(R.id.option_one);
        Spinner sp4 = (Spinner) findViewById(R.id.option_two);
        Spinner sp5 = (Spinner) findViewById(R.id.option_three);

        // Declaring both city strings from the spinner objects
        String city1 = sp1.getSelectedItem().toString();
        String city2 = sp2.getSelectedItem().toString();

        // Declaring strings for each of the user choices of captured Parameters
        String param1 = sp3.getSelectedItem().toString();
        String param2 = sp4.getSelectedItem().toString();
        String param3 = sp5.getSelectedItem().toString();

        // Creating a String Array to hold the selected parameters
        ArrayList<String> totParams = new ArrayList<String>();

        // Building the parameter list
        totParams.add(param1);

        // Continue if parameter2 does not match parameter1
        if (!param2.equals(param1)) {
            totParams.add(param2);
            // Continue if paramter3 does not match parameter 1 or parameter2
            if (!param3.equals(param1) | !param3.equals(param2)) {
                totParams.add(param3);
            }
            // Parameter has matched, making user change their choices and re-trying
            else {
                Toast.makeText(getApplicationContext(), "A duplicate parameter was detected, please change and submit again.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        // Parameter has matched, making user change their choices and re-trying
        else
        {
            Toast.makeText(getApplicationContext(), "A duplicate parameter was detected, please change and submit again.",
                    Toast.LENGTH_SHORT).show();
        }

        // Calling the method to output parameter values
        outputCity1(city1,totParams);


    }

    private void outputCity1 (String cityName, ArrayList chosenParams)
    {
        if(cityName.equals("Kansas City"))
        {
            String[] myStrings = getResources().getStringArray(R.array.kansas_city_parameters);

            TextView tv1 = findViewById(R.id.unit_aa);
            tv1.setText("Hi");
        }

        if(cityName.equals("Omaha"))
        {
            String[] myStrings = getResources().getStringArray(R.array.kansas_city_parameters);
        }

        if(cityName.equals("Chicago"))
        {
            String[] myStrings = getResources().getStringArray(R.array.kansas_city_parameters);
        }

        if(cityName.equals("Minneapolis"))
        {
            String[] myStrings = getResources().getStringArray(R.array.kansas_city_parameters);
        }

    }
}
