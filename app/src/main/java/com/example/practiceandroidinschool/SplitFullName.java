package com.example.practiceandroidinschool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplitFullName extends Fragment implements View.OnClickListener {

    private EditText inputFullName;
    private Button btnClick;
    private TextView viewTextFirstName, viewTextLastName;

    public SplitFullName() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_split_full_name, container, false);

        btnClick = (Button) view.findViewById(R.id.btnClick);
        btnClick.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClick: {

                inputFullName = (EditText) getView().findViewById(R.id.inputFullName);
                String[] fullName = inputFullName.getText().toString().split(" ");
                viewTextFirstName = getView().findViewById(R.id.viewTextFirstName);
                viewTextLastName = getView().findViewById(R.id.viewTextLastName);
                String middleNameandLastName = "";
                if (fullName.length > 2) {
                    for (int i = 1; i < fullName.length; i++) {
                        middleNameandLastName += fullName[i] + "";
                    }
                } else middleNameandLastName = fullName[1];
                viewTextFirstName.setText("Tên: " + middleNameandLastName);
                viewTextLastName.setText("Họ: " + fullName[0]);
                break;
            }
            default:
                break;
        }
    }
}
