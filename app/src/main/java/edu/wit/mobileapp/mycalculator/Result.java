package edu.wit.mobileapp.mycalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This class represents the activity where the result is shown for the calculator app.
 * @author Samuel Hernandez
 */
public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = this.getIntent().getExtras();
        setText(bundle);
    }

    /**
     * Given a bundle this method extracts the data and sets the result text
     * according to the information contained in the bundle.
     * @param bundle the bundle containing the needed information
     */
    private void setText(Bundle bundle){

        //Get info and TextView
        String gender = bundle.getString("gender");
        int feet = bundle.getInt("feet");
        int inches = bundle.getInt("inches");
        TextView textView = findViewById(R.id.resultText);

        //Calculate weight
        double weight = 50 + 2.3*((feet*12+inches)-60);
        if(gender.equals("Female"))
            weight = 45.5 + 2.3*((feet*12+inches)-60);

        //Construct and place text
        String text = "You are "+gender+"\nYour height is "+feet+"'"+inches+"\""+"" +
                "\nThe standard weight is "+weight+"0 kg";
        textView.setText(text);
    }
}