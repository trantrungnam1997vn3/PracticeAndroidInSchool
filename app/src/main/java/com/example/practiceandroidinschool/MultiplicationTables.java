package com.example.practiceandroidinschool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultiplicationTables extends Fragment implements View.OnClickListener {

    private ListView listMultiplication;
    private List<String> multiplication;
    private Button btnMultiplication;
    private EditText inputN;

    public MultiplicationTables() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multiplication_tables, container, false);
        btnMultiplication = (Button) view.findViewById(R.id.btnMultiplication);
        btnMultiplication.setOnClickListener(this);

        return view;
    }

    public List<String> computeMultiplication(int n) {
        List<String> listMultiplication = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            listMultiplication.add("Bảng cửu chương " + i + "");
            for (int j = 1; j <= 10; j++) {
                listMultiplication.add("" + i + "x" + j + "=" + (i * j) + "");
            }
        }
        return listMultiplication;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMultiplication: {
                inputN = (EditText) getView().findViewById(R.id.inputN);
                int n = Integer.parseInt(inputN.getText().toString());
                multiplication = computeMultiplication(n);
                listMultiplication = getView().findViewById(R.id.listMultiplication);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, multiplication);
                listMultiplication.setAdapter(arrayAdapter);
                break;
            }

            default:
                break;
        }

    }
}
