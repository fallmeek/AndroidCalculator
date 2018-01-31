package com.mycalculator.mycalculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import com.mycalculator.mycalculator.databinding.ActivityMainBinding;

import com.mycalculator.mycalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION = '0';
    private DecimalFormat decimalFormat;
    private boolean isReset = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // call supper onCreate event
        super.onCreate(savedInstanceState);

        // define format display text
        decimalFormat = new DecimalFormat("#.##########");

        // Binding content view which defined in res\layout\activity_main in binding variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // set event listener to dot button
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double.parseDouble(binding.editText.getText().toString()  + ".");
                    binding.editText.setText(binding.editText.getText() + ".");
                } catch (Exception ex) {

                }
            }
        });

        // set event listener to 0 button
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("0");
            }
        });

        // set event listener to 1 button
        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("1");
            }
        });

        // set event listener to 2 button
        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("2");
            }
        });

        // set event listener to 3 button
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("3");
            }
        });
        // set event listener to 4 button
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("4");
            }
        });
        // set event listener to 5 button
        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("5");
            }
        });
        // set event listener to 6 button
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("6");
            }
        });
        // set event listener to 7 button
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("7");
            }
        });
        // set event listener to 8 button
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("8");
            }
        });
        // set event listener to 9 button
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addText("9");
            }
        });
        // set event listener to C button
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
            }
        });
        // set event listener to AC button
        binding.buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
                binding.infoTextView.setText("");
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
            }
        });

        // set event listener to Add button
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                displayResult(ADDITION);
            }
        });

        // set event listener to Subtract button
        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                displayResult (SUBTRACTION);
            }
        });

        // set event listener to Multiply button
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                displayResult (MULTIPLICATION);
            }
        });

        // set event listener to Divide button
        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                displayResult (DIVISION);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logger.getLogger("MainActivity").log(Level.INFO, String.valueOf(CURRENT_ACTION));
                computeCalculation();
                if (!Double.isNaN(valueOne)) {
                    binding.infoTextView.setText(decimalFormat.format(valueOne));
                } else {
                    binding.infoTextView.setText(null);
                    valueOne = Double.NaN;
                }
                binding.editText.setText(null);

                CURRENT_ACTION = '0';
            }
        });
//        setContentView(R.layout.activity_main);
    }
    private void computeCalculation(){

        // kiem tra text
        if (Double.isNaN(valueOne)) {
            // khong co gia tri cu
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            } catch (Exception ex) {}
        } else {
            // co gia tri cu
            try {
                valueTwo = Double.parseDouble(binding.editText.getText().toString());
                if (CURRENT_ACTION == ADDITION) {
                    valueOne = valueOne + valueTwo;
                } else if (CURRENT_ACTION == SUBTRACTION) {
                    valueOne = valueOne - valueTwo;
                } else if (CURRENT_ACTION == MULTIPLICATION) {
                    valueOne = valueOne * valueTwo;
                } else if (CURRENT_ACTION == DIVISION) {
                    valueOne = valueOne / valueTwo;
                } else {
                    valueOne = valueTwo;
                }
            } catch (Exception ex) {}
        }
    }

    private void addText(String tabValue) {
        if ("0".equals(binding.editText.getText().toString())) {
            binding.editText.setText(tabValue);
        } else {
            binding.editText.setText(binding.editText.getText() + tabValue);
        }
    }

    private void displayResult (char action) {
        if (!Double.isNaN(valueOne)) {
            binding.infoTextView.setText(decimalFormat.format(valueOne) + action);
            binding.editText.setText(null);
            CURRENT_ACTION = action;
        }
    }

}
