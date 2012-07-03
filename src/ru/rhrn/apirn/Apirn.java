package ru.rhrn.apirn;

import ru.rhrn.apirn.NetHelper;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class Apirn extends Activity
{

    NetHelper net = new NetHelper((Context) this);
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void join(View view) {

        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        if (net.isOnline()) {
          Toast.makeText(this, "network enabled", Toast.LENGTH_SHORT).show();
          
        } else {
          Toast.makeText(this, "network disabled", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, net.join(email.getText().toString(), password.getText().toString()), Toast.LENGTH_SHORT).show();
    }

}
