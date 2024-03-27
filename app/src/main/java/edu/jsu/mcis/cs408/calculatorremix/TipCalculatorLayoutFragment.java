package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.jsu.mcis.cs408.calculatorremix.databinding.TipCalculatorFragmentBinding;

public class TipCalculatorLayoutFragment extends Fragment {


    // Instances of this class are used for the individual fragments within the tabbed layout

    public static final String ARG_ID = "id";

    private TipCalculatorFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipCalculatorFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // Get numeric ID from parameter list
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt(ARG_ID));

        // Display numeric ID in TextView in fragment layout
        //binding.fragmentId.setText(id);

        binding.calculateTipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double total = 0.0;
                double percent = 0.0;
                int numPeople = 0;

                TextView t = binding.totalBillInput;
                total = parseDouble(t.getText().toString());

                t = binding.tipPercentInput;
                percent = parseDouble(t.getText().toString());


                t = binding.totalPeopleInput;
                numPeople = parseInt(t.getText().toString());

                double tip = 0.0;

                if((total != 0.0) && (percent != 0.0) && (numPeople != 0)) {

                    percent = percent / 100;
                    tip = total * percent;
                    tip = tip / numPeople;

                    DecimalFormat df = new DecimalFormat("#.00");
                    String tipOwed = df.format(tip);

                    String output = (getResources().getString(R.string.tip_output) + " " + tipOwed);
                    t = binding.output;
                    t.setText(output);
                }
            }
        });

    }

    public double parseDouble(String n) {

        try {
            double d = Double.parseDouble(n);
            return d;
        }
        catch(NumberFormatException nfe) {
            return 0.0;
        }

    }

    public int parseInt(String n) {

        try {
            int i = Integer.parseInt(n);
            return i;
        }
        catch(NumberFormatException nfe) {
            return 0;
        }
    }


}