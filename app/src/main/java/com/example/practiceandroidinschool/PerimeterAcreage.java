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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerimeterAcreage extends Fragment implements View.OnClickListener {
    private Button btnPerimeter, btnAcreage;
    private EditText widthField, lengthField;
    private TextView resultField;

    public PerimeterAcreage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perimeter_acreage, container, false);

        btnPerimeter = view.findViewById(R.id.perimeterButton);

        btnAcreage = view.findViewById(R.id.acreageButton);

        btnAcreage.setOnClickListener(this);
        btnPerimeter.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.perimeterButton: {
                Log.i("myApp", "perimeter");
                widthField = (EditText) getView().findViewById(R.id.width);
                lengthField = (EditText) getView().findViewById(R.id.length);
                Log.i("myApp", widthField + "");
                int width = Integer.parseInt(widthField.getText().toString());
                int length = Integer.parseInt(lengthField.getText().toString());
                int result = (width + length) * 2;
                resultField = (TextView) getView().findViewById(R.id.resultField);

                resultField.setText("perimeter: " + result);
                break;
            }
            case R.id.acreageButton: {
                Log.i("myApp", "acreage");
                widthField = (EditText) getView().findViewById(R.id.width);
                lengthField = (EditText) getView().findViewById(R.id.length);
                int width = Integer.parseInt(widthField.getText().toString());
                int length = Integer.parseInt(lengthField.getText().toString());

                int acreage = width * length;
                resultField = (TextView) getView().findViewById(R.id.resultField);
                Log.d("MyApp",acreage+"");
                resultField.setText("Acreage: " + acreage );
                break;
            }
        }
    }
}
