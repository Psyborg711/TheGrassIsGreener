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

    public void submitClicked(View view) {
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

        // Continue if city1 does not match city2
        if (!city1.equals(city2.toString()))
        {
            // Continue if parameter2 does not match parameter1
            if (!param2.equals(param1))
            {
                totParams.add(param2);
                // Continue if parameter3 does not match parameter 1 or parameter2
                if (!param3.equals(param1))
                {
                    totParams.add(param3);
                    if (!param3.equals(param2))
                    {
                        // Calling the method to output parameter values
                        findOutputs(city1, totParams,true);
                        findOutputs(city2, totParams,false);
                    }
                    else if (param3.equals("None"))
                    {
                        // Calling the method to output parameter values
                        findOutputs(city1, totParams,true);
                        findOutputs(city2, totParams,false);
                    }
                    // Parameter has matched, making user change their choices and re-trying
                    else
                    {
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
            }
            // Parameter has matched, making user change their choices and re-trying
            else
            {
                Toast.makeText(getApplicationContext(), "A duplicate parameter was detected, please change and submit again.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "First City can not match Second City, please change and submit again.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void findOutputs(String cityName, ArrayList chosenParams, boolean firstCity)
    {
        String[] paramData;

        if (cityName.equals("Kansas City"))
        {
            // set paramData to the array list
            paramData = getResources().getStringArray(R.array.kansas_city_parameters);
            if (firstCity == true) {
                textOutput1(paramData, chosenParams.get(0).toString(), 1);
                textOutput1(paramData, chosenParams.get(1).toString(), 2);
                textOutput1(paramData, chosenParams.get(2).toString(), 3);
            }
            else
            {
                textOutput2(paramData, chosenParams.get(0).toString(), 1);
                textOutput2(paramData, chosenParams.get(1).toString(), 2);
                textOutput2(paramData, chosenParams.get(2).toString(), 3);
            }
        }

        if (cityName.equals("Omaha")) {
            // set paramData to the array list
            paramData = getResources().getStringArray(R.array.omaha_parameters);
            if (firstCity == true) {
                textOutput1(paramData, chosenParams.get(0).toString(), 1);
                textOutput1(paramData, chosenParams.get(1).toString(), 2);
                textOutput1(paramData, chosenParams.get(2).toString(), 3);
            }
            else
            {
                textOutput2(paramData, chosenParams.get(0).toString(), 1);
                textOutput2(paramData, chosenParams.get(1).toString(), 2);
                textOutput2(paramData, chosenParams.get(2).toString(), 3);
            }
        }

        if (cityName.equals("Chicago")) {
            // set paramData to the array list
            paramData = getResources().getStringArray(R.array.chicago_parameters);
            if (firstCity == true) {
                textOutput1(paramData, chosenParams.get(0).toString(), 1);
                textOutput1(paramData, chosenParams.get(1).toString(), 2);
                textOutput1(paramData, chosenParams.get(2).toString(), 3);
            }
            else
            {
                textOutput2(paramData, chosenParams.get(0).toString(), 1);
                textOutput2(paramData, chosenParams.get(1).toString(), 2);
                textOutput2(paramData, chosenParams.get(2).toString(), 3);
            }
        }

        if (cityName.equals("Minneapolis")) {
            // set paramData to the array list
            paramData = getResources().getStringArray(R.array.minneapolis_parameters);
            if (firstCity == true) {
                textOutput1(paramData, chosenParams.get(0).toString(), 1);
                textOutput1(paramData, chosenParams.get(1).toString(), 2);
                textOutput1(paramData, chosenParams.get(2).toString(), 3);
            }
            else
            {
                textOutput2(paramData, chosenParams.get(0).toString(), 1);
                textOutput2(paramData, chosenParams.get(1).toString(), 2);
                textOutput2(paramData, chosenParams.get(2).toString(), 3);
            }
        }

    }

    private void textOutput1(String[] cityParamData, String parameterChoice, int outputWindowNum) {
        if (outputWindowNum == 1) {
            // Setup Output1
            TextView tv1 = findViewById(R.id.unit_aa);

            switch (parameterChoice) {
                case "Land Size":
                    tv1.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv1.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv1.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv1.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv1.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv1.setText(cityParamData[5]);
                    break;
                default:
                    tv1.setText("NULL");
                    break;
            }
        }

        if (outputWindowNum == 2) {
            // Setup Output2
            TextView tv2 = findViewById(R.id.unit_ba);

            switch (parameterChoice) {
                case "Land Size":
                    tv2.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv2.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv2.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv2.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv2.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv2.setText(cityParamData[5]);
                    break;
                default:
                    tv2.setText("NULL");
                    break;
            }
        }
        if (outputWindowNum == 3) {
            // Setup Output3
            TextView tv3 = findViewById(R.id.unit_ca);

            switch (parameterChoice) {
                case "Land Size":
                    tv3.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv3.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv3.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv3.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv3.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv3.setText(cityParamData[5]);
                    break;
                default:
                    tv3.setText("NULL");
                    break;
            }
        }
    }

    private void textOutput2(String[] cityParamData, String parameterChoice, int outputWindowNum) {
        if (outputWindowNum == 1) {
            // Setup Output1
            TextView tv1 = findViewById(R.id.unit_ab);

            switch (parameterChoice) {
                case "Land Size":
                    tv1.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv1.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv1.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv1.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv1.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv1.setText(cityParamData[5]);
                    break;
                default:
                    tv1.setText("NULL");
                    break;
            }
        }

        if (outputWindowNum == 2) {
            // Setup Output2
            TextView tv2 = findViewById(R.id.unit_bb);

            switch (parameterChoice) {
                case "Land Size":
                    tv2.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv2.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv2.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv2.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv2.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv2.setText(cityParamData[5]);
                    break;
                default:
                    tv2.setText("NULL");
                    break;
            }
        }
        if (outputWindowNum == 3) {
            // Setup Output3
            TextView tv3 = findViewById(R.id.unit_cb);

            switch (parameterChoice) {
                case "Land Size":
                    tv3.setText(cityParamData[0]);
                    break;
                case "Majority Party":
                    tv3.setText(cityParamData[1]);
                    break;
                case "Population":
                    tv3.setText(cityParamData[2]);
                    break;
                case "Median Household Income":
                    tv3.setText(cityParamData[3]);
                    break;
                case "Median Gross Rent":
                    tv3.setText(cityParamData[4]);
                    break;
                case "Percentage of Population in Poverty":
                    tv3.setText(cityParamData[5]);
                    break;
                default:
                    tv3.setText("NULL");
                    break;
            }
        }
    } // end of method
}


