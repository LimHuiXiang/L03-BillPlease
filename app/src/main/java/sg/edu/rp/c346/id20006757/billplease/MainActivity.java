package sg.edu.rp.c346.id20006757.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Step 1 Handles Creation
        EditText amount;
        EditText numPax;
        ToggleButton svs;
        ToggleButton gst;
        TextView TotalBill;
        TextView EachPays;
        Button split;
        Button reset;
        EditText discount;

    //Step 2Bridge the UI with the controller
        amount = findViewById(R.id.InputAmount);
        numPax = findViewById(R.id.NoOfPax);
        TotalBill = findViewById(R.id.TotalBill);
        EachPays = findViewById(R.id.EachPay);
        svs = findViewById(R.id.tbSVS);
        gst =findViewById(R.id.tbGST);
        split =findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        discount =findViewById(R.id.Discount);



        //Step 3 Create the event listener

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                if(amount.getText().toString().trim().length()!=0 && numPax.getText().toString().trim().length()!=0){
                    double newAmt = 0.0;
                    if (!svs.isChecked() && !gst.isChecked()) {
                        newAmt = Double.parseDouble(amount.getText().toString());
                    }else if (svs.isChecked() &&!gst.isChecked()) {
                        newAmt = Double.parseDouble(amount.getText().toString()) * 1.1;
                    }else if (!svs.isChecked() &&gst.isChecked()){
                        newAmt = Double.parseDouble(amount.getText().toString())*1.07;
                    }else {
                        newAmt = Double.parseDouble(amount.getText().toString())*1.17;
                    }

                    //Discount
                    if (discount.getText().toString().trim().length() !=0){
                        newAmt = 1-Double.parseDouble(discount.getText().toString()) /100;
                    }

                    TotalBill.setText("Total Bill: $" + String.format("%.2f,newAmt"));
                    int numPerson = Integer.parseInt((numPax.getText().toString()));
                    if (numPerson !=1)
                        EachPays.setText("Each Pays $" + String.format("%.2f", newAmt/numPerson));
                        else
                            EachPays.setText("Each Pays: $" + newAmt);

                }


            }
        });
        //Updates
                    reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            {
                                amount.setText("");
                                numPax.setText("");
                                svs.setChecked(false);
                                gst.setChecked(false);
                                discount.setText("");
                            }
                        }
                    });

                    //Added TextView v2


    }
}