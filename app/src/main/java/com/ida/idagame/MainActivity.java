package com.ida.idagame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String hello;
        //Button mybtn = new Button(this);
        //TextView txtView = new TextView(this);
        //mybtn.setOnClickListener(this);
        final StoreState myStoreState = new StoreState();
        final Activity myActivity = new Activity();
        final User myUser = new User();
        final Button mybtnBank = (Button) findViewById(R.id.buttonBank);
        final Button mybtnAtm = (Button) findViewById(R.id.buttonAtm);
        final Button mybtnGas = (Button) findViewById(R.id.buttonGas);
        final TextView txtView = (TextView) findViewById(R.id.textView4);
        final TextView txtView2 = (TextView) findViewById(R.id.textView2); // This one is CCs stolen, IDs stolen, balance...
        txtView.setText("Grand Theft ID");
        txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));
        //txtView.setVisibility(View.GONE);

        final Button mybtnOption1 = (Button) findViewById(R.id.buttonOption1);
        final Button mybtnOption2 = (Button) findViewById(R.id.buttonOption2);
        final Button mybtnOption3 = (Button) findViewById(R.id.buttonOption3);
        mybtnOption1.setVisibility(View.GONE);
        mybtnOption2.setVisibility(View.GONE);
        mybtnOption3.setVisibility(View.GONE);


        mybtnBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                myStoreState.store = 1;
                txtView.setText("Grand Theft ID");
                txtView.setVisibility(View.VISIBLE);
                mybtnOption1.setText("Open Account");
                mybtnOption2.setText("Rob the Bank");
                mybtnOption3.setText("Nothing because I am\nscared of LifeLock");
                mybtnOption1.setVisibility(View.VISIBLE);
                mybtnOption2.setVisibility(View.VISIBLE);
                mybtnOption3.setVisibility(View.VISIBLE);
                mybtnOption1.setTextColor(0xAAFF0000);
                mybtnOption2.setTextColor(0xAAFF0000);
                mybtnOption3.setTextColor(0xAAFF0000);
            }
        });
        mybtnAtm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                myStoreState.store = 2;
                txtView.setText("Grand Theft ID");
                txtView.setVisibility(View.VISIBLE);
                mybtnOption1.setText("Hack ID");
                mybtnOption2.setText("Install Card Reader");
                mybtnOption3.setText("Nothing because I am\nscared of LifeLock");
                mybtnOption1.setVisibility(View.VISIBLE);
                mybtnOption2.setVisibility(View.VISIBLE);
                mybtnOption3.setVisibility(View.VISIBLE);
                mybtnOption1.setTextColor(0xAAFF0000);
                mybtnOption2.setTextColor(0xAAFF0000);
                mybtnOption3.setTextColor(0xAAFF0000);
            }
        });
        mybtnGas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                myStoreState.store = 3;
                txtView.setText("Grand Theft ID");
                txtView.setVisibility(View.VISIBLE);
                mybtnOption1.setText("Install Card Reader");
                mybtnOption2.setText("Get Gas");
                mybtnOption3.setText("Nothing because I am\nscared of LifeLock");
                mybtnOption1.setVisibility(View.VISIBLE);
                mybtnOption2.setVisibility(View.VISIBLE);
                mybtnOption3.setVisibility(View.VISIBLE);
                mybtnOption1.setTextColor(0xAAFF0000);
                mybtnOption2.setTextColor(0xAAFF0000);
                mybtnOption3.setTextColor(0xAAFF0000);
            }
        });

        mybtnOption1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (myStoreState.store == 1)
                {
                    myUser.action("openAccount");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));

                }
                else if (myStoreState.store == 2)
                {
                    myUser.action("hackID");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));

                }
                else if (myStoreState.store == 3)
                {
                    myUser.action("stealCC");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));
                }
                txtView.setText("Grand Theft ID");
            }
        });

        // Rob the bank
        // Install card reader
        // Get Gas
        mybtnOption2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (myStoreState.store == 1)
                {
                    myUser.action("robBank");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));

                }
                else if (myStoreState.store == 2)
                {
                    myUser.action("stealCC");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));

                }
                else if (myStoreState.store == 3)
                {
                    myUser.action("getGas");
                    mybtnOption1.setVisibility(View.GONE);
                    mybtnOption2.setVisibility(View.GONE);
                    mybtnOption3.setVisibility(View.GONE);
                    //txtView.setVisibility(View.GONE);
                    txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));
                }
                txtView.setText("Grand Theft ID");
            }
        });

        mybtnOption3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                mybtnOption1.setVisibility(View.GONE);
                mybtnOption2.setVisibility(View.GONE);
                mybtnOption3.setVisibility(View.GONE);
                //txtView.setVisibility(View.GONE);
                txtView2.setText("CCs Stolen: " + String.valueOf(myUser.numCC) + "\nIDs Stolen: " + String.valueOf(myUser.numID) + "\nBalance: " + String.valueOf(myUser.cash));
                txtView.setText("YES LIFELOCK RULES!");
            }
        });
    }
}

/*

package com.ida.idagame;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/


