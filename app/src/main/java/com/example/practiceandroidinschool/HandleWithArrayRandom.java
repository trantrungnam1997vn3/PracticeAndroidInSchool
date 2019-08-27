package com.example.practiceandroidinschool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class HandleWithArrayRandom extends Fragment implements View.OnClickListener {

    private Button btnClick;
    private TextView textViewArray, textViewArrayACS, textViewArrayDESC, textViewMax,
            textViewMin, textViewSortASC, textViewSumPrime, textViewCountPrime;
    private EditText inputN;
    private List<Integer> arrayInt;

    public HandleWithArrayRandom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_handle_with_array_random, container, false);

        btnClick = (Button) view.findViewById(R.id.btnClick);
        btnClick.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClick: {
                inputN = (EditText) getView().findViewById(R.id.inputN);
                textViewArray = (TextView) getView().findViewById(R.id.textViewArray);
                textViewArrayACS = (TextView) getView().findViewById(R.id.textViewArrayACS);
                textViewArrayDESC = (TextView) getView().findViewById(R.id.textViewArrayDESC);
                textViewMax = (TextView) getView().findViewById(R.id.textViewMax);
                textViewMin = (TextView) getView().findViewById(R.id.textViewMin);
                textViewSortASC = (TextView) getView().findViewById(R.id.textViewSortASC);
                textViewSumPrime = (TextView) getView().findViewById(R.id.textViewSumPrime);
                textViewCountPrime = (TextView) getView().findViewById(R.id.textViewCountPrime);
                try {
                    int n = Integer.parseInt(inputN.getText().toString());
                    arrayInt = randomArray(n);
                    textViewArray.setText(arrayInt.toString());
                    textViewArrayACS.setText("Xuất xuôi: " + arrayInt.toString());
                    Collections.reverse(arrayInt);
                    textViewArrayDESC.setText("Xuất ngược:" + arrayInt.toString());
                    textViewMax.setText("Max: " + Collections.max(arrayInt).toString());
                    textViewMin.setText("Min: " + Collections.min(arrayInt).toString());
                    Collections.sort(arrayInt);
                    textViewSortASC.setText("Mảng tăng dần: " + arrayInt.toString());
                    textViewSumPrime.setText("Tổng số nguyên tố: " + computePrime(arrayInt).first);
                    textViewCountPrime.setText("Tổng số nguyên tố: " + computePrime(arrayInt).second);

                } catch (Exception e) {
                    textViewArray.setText(e + "");
                }
                break;
            }
        }
    }

    public List<Integer> randomArray(int n) {
        Random rd = new Random();
        List<Integer> randomArray = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            randomArray.add(rd.nextInt(100) + 1);
        }
        return randomArray;
    }


    public Pair<Integer, Integer> computePrime(List<Integer> arrayInput) {
        int sumPrime = 0;
        int count = 0;
        for (int item : arrayInput) {
            if (item == 2) {
                sumPrime += item;
            } else {
                for (int i = 2; i < item; i++) {
                    if (item % i == 0) {
                        break;
                    }
                    if (i == item - 1) {
                        sumPrime += item;
                        count++;
                    }
                }

            }
        }
        return new Pair(sumPrime, count);
    }

}
