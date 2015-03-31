package practicaltest01.pdsd.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PracticalTest01SecondaryActivity extends ActionBarActivity {


    protected Button ok, cancel;
    protected EditText email, name, phone;

    protected ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();

    private class ButtonClickListener2 implements Button.OnClickListener{

        //C1
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ok:
                    setResult(RESULT_OK, new Intent());
                    break;
                case R.id.cancel:
                    setResult(RESULT_CANCELED, new Intent());
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);

        ok = (Button)findViewById(R.id.ok);
        cancel = (Button)findViewById(R.id.cancel);

        ok.setOnClickListener(buttonClickListener2);
        cancel.setOnClickListener(buttonClickListener2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_secondary, menu);
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
