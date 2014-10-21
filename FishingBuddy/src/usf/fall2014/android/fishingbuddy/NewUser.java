package usf.fall2014.android.fishingbuddy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUser extends ActionBarActivity {

	EditText new_username,new_password,editTextConfirmPassword;
    Button button_create;
 
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
 
        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
 
        // Get References of Views
        new_username=(EditText)findViewById(R.id.new_username);
        new_password=(EditText)findViewById(R.id.new_password);
        //editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
 
        button_create=(Button)findViewById(R.id.button_create);
        button_create.setOnClickListener(new View.OnClickListener() {
 
        public void onClick(View v) {
            // TODO Auto-generated method stub
 
            String userName=new_username.getText().toString();
            String password=new_password.getText().toString();
            //String confirmPassword=editTextConfirmPassword.getText().toString();
 
            // check if any of the fields are vacant
            if(userName.equals("")||password.equals(""))//||confirmPassword.equals(""))
            {
                    Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
                    return;
            }
            // check if both password matches
            /*if(!password.equals(confirmPassword))
            {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                return;
            }*/
            else
            {
                // Save the Data in Database
                loginDataBaseAdapter.insertEntry(userName, password);
                Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            }
        }
    });
}
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
 
        loginDataBaseAdapter.close();
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_user, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
