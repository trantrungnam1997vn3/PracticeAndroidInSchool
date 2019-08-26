package com.example.practiceandroidinschool;


import android.opengl.EGLExt;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleEquation extends Fragment implements View.OnClickListener {

    private Button btnExecute;
    private EditText inputA, inputB, inputC;
    private TextView textViewResult;
    private Spinner spinerOperation;
    private List<String> listOperation = new ArrayList<String>();

    public SimpleEquation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_equation, container, false);
        listOperation.add("+");
        listOperation.add("-");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, listOperation);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Log.i("myApp", "go hể");
        spinerOperation = (Spinner) view.findViewById(R.id.spinnerOperation);
        spinerOperation.setAdapter(arrayAdapter);
        btnExecute = (Button) view.findViewById(R.id.btnExecute);
        btnExecute.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExecute: {
                inputA = getView().findViewById(R.id.inputA);
                inputB = getView().findViewById(R.id.inputB);
                inputC = getView().findViewById(R.id.inputC);
                spinerOperation = getView().findViewById(R.id.spinnerOperation);
                textViewResult = getView().findViewById(R.id.textViewResult);
                try {

                    int a = Integer.parseInt(inputA.getText().toString());
                    int b = Integer.parseInt(inputB.getText().toString());
                    int c = Integer.parseInt(inputC.getText().toString());
                    String operation = spinerOperation.getSelectedItem().toString();
                    Log.i("myApp", "go here" + operation);
                    switch (operation) {
                        case "+": {
                            float result = (c - b) / (float)a;
                            textViewResult.setText("Kết quả: " + result);
                            break;
                        }
                        case "-": {
                            float result = (c + b) / (float)a;
                            textViewResult.setText("Kết quả: " + result);
                            break;
                        }
                        default:
                            break;
                    }
                } catch (Exception e) {
                    textViewResult.setText(e.toString());
                    return;
                }

                break;
            }
            default:
                break;
        }
    }
}
