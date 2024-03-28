package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.jsu.mcis.cs408.calculatorremix.databinding.DistanceConverterFragmentBinding;

public class DistanceConverterLayoutFragment extends Fragment {
    private final static double CONVERT_VALUE = (1.609);

    private DistanceConverterFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceConverterFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.convertDistanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText m = binding.milesInput;
                EditText k = binding.kilometersInput;

                String mInput = m.getText().toString();
                String kInput = k.getText().toString();

                if((mInput.isEmpty()) && (!(kInput.isEmpty()))) {

                    m.setText(convertToMiles(view, kInput));
                }
                else if((!(mInput.isEmpty())) && (kInput.isEmpty())) {

                    k.setText(convertToKilometers(view, mInput));
                }
                else if((!(mInput.isEmpty())) && (!(kInput.isEmpty()))) {

                    k.setText(convertToKilometers(view, mInput));
                }
                else if((mInput.isEmpty()) && (kInput.isEmpty())) {
                    Toast.makeText(view.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public boolean isNumeric(String n) {

        try {
            double d = Double.parseDouble(n);
            return true;
        }
        catch(NumberFormatException nfe) {
            return false;
        }

    }

    public String convertToMiles(View view, String kInput) {

        double k;
        String convertValue ="";

        if(isNumeric(kInput)) {

            k = Double.parseDouble(kInput);

            double m = (k / CONVERT_VALUE);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(m);
        }
        else {
            Toast.makeText(view.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
        }

        return convertValue;
    }
    public String convertToKilometers(View view, String mInput) {

        double m;
        String convertValue = "";

        if(isNumeric(mInput)) {

            m = Double.parseDouble(mInput);

            double k = (m * CONVERT_VALUE);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(k);
        }
        else {
            Toast.makeText(view.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
        }

        return convertValue;
    }
}
