package edu.wit.mobileapp.mycalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * This app calculates the ideal weight given gender and height
 * @author Samuel Hernandez
 */
public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //Set listener for Calculate Button
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v-> {
            Intent intent = new Intent(Calculator.this, Result.class);
            Bundle bundle = constructBundle();
            intent.putExtras(bundle);
            startActivity(intent);
            //Finish not wanted since we may want to recalculate
        });
    }

    /**
     * This method puts the information gathered by the EditTexts and RadioButton into the bundle.
     * @return the bundle with the input added to it
     */
    private Bundle constructBundle(){
        Bundle bundle = new Bundle();

        //Get and put gender input
        String selectedGender = "Male";
        RadioButton femaleButton = findViewById(R.id.femaleButton);
        if(femaleButton.isChecked())
            selectedGender = "Female";
        bundle.putString("gender", selectedGender);

        //Get and put height input
        EditText et = findViewById(R.id.feetInput);
        bundle.putInt("feet", Integer.parseInt(et.getText().toString()));
        et = findViewById(R.id.inchesInput);
        bundle.putInt("inches", Integer.parseInt(et.getText().toString()));

        return bundle;
    }
}