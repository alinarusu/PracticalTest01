package practicaltest01.pdsd.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;


public class PracticalTest01MainActivity extends ActionBarActivity {

    protected Button name;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("stare", String.valueOf((stare)));

        if(stare == "Name") {
            outState.putString("name", text.getText().toString());
        }

        if(stare == "Email") {
            outState.putString("email", text.getText().toString());
        }

        if(stare == "Phone") {
            outState.putString("phone", text.getText().toString());
        }

        //outState.putString("name", text.getText().toString());
        //outState.putString("email", String.valueOf(ret_email));
       // outState.putString("phone", String.valueOf(ret_phone));

        outState.putString("stare", String.valueOf((stare)));
    }

    protected Button email;
    protected Button phone;
    protected Button nav;
    EditText text;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    protected String ret_name = "Name", ret_email = "Email", ret_phone = "Phone", stare;

    protected class ButtonClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.name:
                    if(stare == "Name") {
                        ret_name = text.getText().toString();
                    }
                    text.setText(ret_name);
                    stare = "Name";
                    break;
                case R.id.email:

                    if(stare == "Email") {
                        ret_email = text.getText().toString();
                    }
                    text.setText(ret_email);
                    stare = "Email";
                    break;
                case R.id.phone:
                    if(stare == "Phone") {
                        ret_phone = text.getText().toString();
                    }
                    text.setText(ret_phone);
                    stare = "Phone";
                    break;

                case R.id.nav:
                    Intent intent = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);

                    intent.putExtra("name", String.valueOf(String.valueOf(name.getText().toString())));
                    intent.putExtra("email", String.valueOf(String.valueOf(name.getText().toString())));
                    intent.putExtra("phone", String.valueOf(String.valueOf(name.getText().toString())));
                            //Integer.parseInt(name.getText().toString()) +
                              //      Integer.parseInt(rightText.getText().toString())
                  //  ));
                    startActivityForResult(intent, 2000);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        name = (Button)findViewById(R.id.name);
        email = (Button)findViewById(R.id.email);
        phone = (Button)findViewById(R.id.phone);
        nav = (Button)findViewById(R.id.nav);
        text = (EditText)findViewById(R.id.text);

        name.setOnClickListener(buttonClickListener);
        email.setOnClickListener(buttonClickListener);
        phone.setOnClickListener(buttonClickListener);
        nav.setOnClickListener(buttonClickListener);

        if(savedInstanceState!=null){

            String my_name = savedInstanceState.getString("name");
            String my_email = savedInstanceState.getString("email");
            String my_phone = savedInstanceState.getString("email");

            stare = savedInstanceState.getString("stare", String.valueOf((stare)));

            if(stare == "Name") {
                text.setText(String.valueOf(my_name));
            }
            if(stare == "Email") {
                text.setText(String.valueOf(my_email));
            }
            if(stare == "Phone") {
                text.setText(String.valueOf(my_phone));
            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
