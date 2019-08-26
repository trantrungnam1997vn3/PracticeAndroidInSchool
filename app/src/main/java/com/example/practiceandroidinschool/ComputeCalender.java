package com.example.practiceandroidinschool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComputeCalender extends Fragment implements View.OnClickListener{

    private Button btnComputeYear;
    private EditText yearInput;
    private TextView resultOfYear;

    public ComputeCalender() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compute_calender, container, false);

        btnComputeYear = (Button) view.findViewById(R.id.computeYear);

        btnComputeYear.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.computeYear: {
                yearInput = (EditText) getView().findViewById(R.id.yearInput);
                int year = Integer.parseInt(yearInput.getText().toString());
                resultOfYear = (TextView) getView().findViewById(R.id.resultOfYear);

                int surplus = year % 60;

                if (surplus <= 3) {
                    surplus += 60;
                }

                Map canOfYear = createMapEndOfCan();
                HashMap<Integer, String> chiOfYear = (HashMap<Integer, String>) createChiOfYear();


                int canInt = year % 10;

                resultOfYear.setText(canOfYear.get(canInt) +" "+ chiOfYear.get(surplus));
                break;
            }
        }
    }

    public Map createMapEndOfCan() {
        Map lunarYear = new HashMap<Integer, List>();

        Map otherValues = new HashMap<Integer, String>();

        otherValues.put(0, "CANH");
        otherValues.put(1, "TÂN");
        otherValues.put(2, "NHÂM");
        otherValues.put(3, "QUÍ");
        otherValues.put(4, "GIÁP");
        otherValues.put(5, "ẤT");
        otherValues.put(6, "BÍNH");
        otherValues.put(7, "ĐINH");
        otherValues.put(8, "MẬU");
        otherValues.put(9, "KỈ");

        return otherValues;
    }

    public HashMap createChiOfYear() {
        HashMap chiOfYear = new HashMap<Integer, String>();
        String[] nameCall = new String[] {"TÝ",  "SỮU ", "DẦN",  "MÃO",  "THÌN",  "TỊ",  "NGỌ",  "MÙI",  "THÂN", "DẬU",  "TUẤT", "HỢI"};
        for(int i = 4; i <= 63; i++) {
            chiOfYear.put(i, nameCall[(i-4) % 12]);
        }
        return chiOfYear;
    }

}
