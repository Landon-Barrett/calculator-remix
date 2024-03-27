package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.jsu.mcis.cs408.calculatorremix.databinding.TempConverterFragmentBinding;

public class TempConverterLayoutFragment extends Fragment {


    // Instances of this class are used for the individual fragments within the tabbed layout

    public static final String ARG_ID = "id";

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

        // Get numeric ID from parameter list
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt(ARG_ID));

        // Display numeric ID in TextView in fragment layout
        //binding.fragmentId.setText(id);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText f = binding.fahrenheitInput;
                EditText c = binding.celsiusInput;

                String fInput = f.getText().toString();
                String cInput = c.getText().toString();

                if((fInput.isEmpty()) && (!(cInput.isEmpty()))) {

                    f.setText(convertToFahrenheit(cInput));
                }
                else if((!(fInput.isEmpty())) && (cInput.isEmpty())) {

                    c.setText(convertToCelsius(fInput));
                }
                else if((!(fInput.isEmpty())) && (!(cInput.isEmpty()))) {

                    c.setText(convertToCelsius(fInput));
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

    public String convertToFahrenheit(String cInput) {

        double c;
        String convertValue ="";

        if(isNumeric(cInput)) {

            c = Double.parseDouble(cInput);

            double f = (((c * 9) /5) + 32);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(f);
        }
        else {

        }

        return convertValue;
    }
    public String convertToCelsius(String fInput) {

        double f;
        String convertValue = "";

        if(isNumeric(fInput)) {

            f = Double.parseDouble(fInput);

            double c = (((f - 32) * 5)/9);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(c);
        }
        else {

        }

        return convertValue;
    }
}
