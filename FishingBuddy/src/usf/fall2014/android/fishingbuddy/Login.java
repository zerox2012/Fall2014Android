package usf.fall2014.android.fishingbuddy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity 
{
	Button btnSignIn,btnSignUp,btnForgotPassword;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_login);

	     // create a instance of SQLite Database
	     loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();

	     // Get The Reference Of Buttons
	     btnSignIn=(Button)findViewById(R.id.button_login);
	     btnSignUp=(Button)findViewById(R.id.button_new_user);
	     btnForgotPassword=(Button)findViewById(R.id.button_forgot_password);

	    // Set OnClick Listener on SignUp button 
	    btnSignUp.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentSignUP=new Intent(getApplicationContext(),NewUser.class);
			startActivity(intentSignUP);
			}
		});
	    
	 // Set OnClick Listener on SignUp button 
	    btnForgotPassword.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			/// Create Intent for ForgotPassword activity and start it
			Intent intentForgotPass=new Intent(getApplicationContext(),ForgotPassword.class);
			startActivity(intentForgotPass);
			}
		});
	 // Set OnClick Listener on Login button 
	    btnSignIn.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			/// Create Intent for ForgotPassword activity and start it
			Intent intentMainMenu=new Intent(getApplicationContext(),MainMenu.class);
			startActivity(intentMainMenu);
			}
		});
	}
	// Methods to handleClick Event of Sign In Button
	public void signIn(View V)
	   {
			final Dialog dialog = new Dialog(Login.this);
			dialog.setContentView(R.layout.activity_signin);
		    dialog.setTitle("Login");

		    // get the References of views
		    final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
		    final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

			Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

			// Set On ClickListener
			btnSignIn.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					// get The User name and Password
					String userName=editTextUserName.getText().toString();
					String password=editTextPassword.getText().toString();

					// fetch the Password form database for respective user name
					String storedPassword=loginDataBaseAdapter.getSingleEntry(userName);

					// check if the Stored password matches with  Password entered by user
					if(password.equals(storedPassword))
					{
						Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_LONG).show();
						dialog.dismiss();
						Intent intentMainMenu=new Intent(getApplicationContext(),MainMenu.class);
						startActivity(intentMainMenu);
					}
					else
					{
						Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
					}
				}
			});

			dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	    // Close The Database
		loginDataBaseAdapter.close();
	}
}