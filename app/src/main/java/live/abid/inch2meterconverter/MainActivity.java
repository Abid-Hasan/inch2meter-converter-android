package live.abid.inch2meterconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText inchesEditText;
    Button convertButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setCalculateButtonClickListener();
    }

    private void setCalculateButtonClickListener() {
        convertButton.setOnClickListener(v -> {
            double meter = convertToMeters();
            if (meter == -1) return;
            showResult(meter);
        });
    }

    private void showResult(double meter) {
        String result = String.format(Locale.ENGLISH, "= %.2f meter(s)", meter);
        resultTextView.setText(result);
    }

    private double convertToMeters() {
        String inchesString = inchesEditText.getText().toString();
        if (inchesString.isEmpty()) {
            Toast.makeText(this, "Please enter an inch value", Toast.LENGTH_SHORT).show();
            return -1;
        }

        try {
            double inches = Double.parseDouble(inchesString);
            return inches * 0.0254;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid inch value", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.inches_edit_text);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text);
    }
}