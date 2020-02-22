package com.example.counter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** called when plus button pressed */
    public void increment(View view) {
        TextView textView =  (TextView) findViewById(R.id.textView);
        CharSequence currentText = textView.getText();
        int count = Integer.parseInt(currentText.toString());
        count += 1;
        textView.setText(Integer.toString(count));
    }

    /** called when minus button pressed */
    public void decrement(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        CharSequence currentText = textView.getText();
        int count = Integer.parseInt(currentText.toString());
        count -= 1;
        textView.setText(Integer.toString(count));
    }

    /** called when reset button pressed */
    public void reset (View view) {

        // set up new AlertBuilder object to build the warning alert
        AlertDialog.Builder resetBuilder = new AlertDialog.Builder(this);
        resetBuilder.setTitle("Counter Reset");
        resetBuilder.setMessage("Are you sure you want to reset this counter?");
        resetBuilder.setCancelable(true);

        resetBuilder.setPositiveButton(
                "Reset",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if user chooses reset, the counter will be reset to zero
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(R.string.counter_zero);
                    }
                }
        );

        resetBuilder.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if user chooses cancel, the alert closes and the counters is unchanged
                        dialog.cancel();
                    }
                }
        );

        // build alert and show
        AlertDialog resetAlert = resetBuilder.create();
        resetAlert.show();

    }
}
