package com.example.counter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
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
        long count = Long.parseLong(currentText.toString());
        count += 1;
        textView.setText(Long.toString(count));
    }

    /** called when minus button pressed */
    public void decrement(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        CharSequence currentText = textView.getText();
        long count = Long.parseLong(currentText.toString());
        count -= 1;
        textView.setText(Long.toString(count));

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
/*
    public void settings (View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
 */

    public void set (View view) {
        AlertDialog.Builder setBuilder = new AlertDialog.Builder(this);
        setBuilder.setTitle("Set Value");
        final EditText value = new EditText(this);
        value.setInputType(InputType.TYPE_CLASS_NUMBER);
        value.setHint("Enter a value to preset...");
        setBuilder.setView(value);

        setBuilder.setPositiveButton(
                "Set",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            long myNumber = Long.parseLong(value.getText().toString());
//                            int zero = 0;
                           textView.setText(Long.toString(myNumber));
                        } catch(Exception e) {

                        }


                    }
                }
        );

        setBuilder.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        AlertDialog setAlert = setBuilder.create();
        setAlert.show();

    }

}
