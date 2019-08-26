package com.example.practiceandroidinschool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleEquation extends Fragment implements View.OnClickListener {

    private Button computePTB1;
    private EditText ptb1Input;
    private TextView resultAfterCompute;

    public SimpleEquation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_equation, container, false);

        computePTB1 = (Button) view.findViewById(R.id.computePTB1);

        computePTB1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.computePTB1: {
                ptb1Input = (EditText) getView().findViewById(R.id.ptb1);

                String equation = ptb1Input.getText().toString();

                Log.d("MyApp", equation);

                Matcher numberMatch = Pattern.compile("[\\d]+").matcher(equation);


                Log.d("MyApp", numberMatch.find(1)+"");
                Matcher operatorMatch = Pattern.compile("[+-]+").matcher(equation);

                if (numberMatch.find() && numberMatch.group().length() == 3 && operatorMatch.group().length() == 1) {
                    double x = 0.0;
                    switch (operatorMatch.group(0)) {
                        case "+":
                            x = (Integer.parseInt(numberMatch.group(2)) - Integer.parseInt(numberMatch.group(1))) / Integer.parseInt(numberMatch.group(0));

                            Log.d("MyApp", x + "");
                            break;
                        case "-":
                            x = (Integer.parseInt(numberMatch.group(2)) + Integer.parseInt(numberMatch.group(1))) / Integer.parseInt(numberMatch.group(0));

                            Log.d("MyApp", x + "");
                            break;
                        default:
                            break;

                    }

                    resultAfterCompute = (TextView) getView().findViewById(R.id.resultAfterCompute);
                    resultAfterCompute.setText(x + "");
                }

                break;
            }
        }
    }
}
