package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.jsu.mcis.cs408.calculatorremix.databinding.TempConverterFragmentBinding;

public class TempConverterLayoutFragment extends Fragment {

    private TempConverterFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TempConverterFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText f = binding.fahrenheitInput;
                EditText c = binding.celsiusInput;

                String fInput = f.getText().toString();
                String cInput = c.getText().toString();

                if((fInput.isEmpty()) && (!(cInput.isEmpty()))) {

                    f.setText(convertToFahrenheit(view, cInput));
                }
                else if((!(fInput.isEmpty())) && (cInput.isEmpty())) {

                    c.setText(convertToCelsius(view, fInput));
                }
                else if((!(fInput.isEmpty())) && (!(cInput.isEmpty()))) {

                    c.setText(convertToCelsius(view, fInput));
                }
                else if((fInput.isEmpty()) && (cInput.isEmpty())) {
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

    public String convertToFahrenheit(View view, String cInput) {

        double c;
        String convertValue ="";

        if(isNumeric(cInput)) {

            c = Double.parseDouble(cInput);

            double f = (((c * 9) /5) + 32);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(f);
        }
        else {
            Toast.makeText(view.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
        }

        return convertValue;
    }
    public String convertToCelsius(View view, String fInput) {

        double f;
        String convertValue = "";

        if(isNumeric(fInput)) {

            f = Double.parseDouble(fInput);

            double c = (((f - 32) * 5)/9);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(c);
        }
        else {
            Toast.makeText(view.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
        }

        return convertValue;
    }
}
