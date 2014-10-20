package usf.fall2014.android.fishingbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import usf.fall2014.android.fishingbuddy.R; 

public class Login extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        //creating buttons so we can use
        Button login = (Button) this.findViewById(R.id.button_login);
        Button newUser = (Button) this.findViewById(R.id.button_new_user);
	    Button forgotPassword = (Button) this.findViewById(R.id.button_forgot_password);
	    
	    //waiting for login button to be clicked
        OnClickListener login_clickEvent = new OnClickListener(){
        	public void onClick(View arg0){
        		Intent myIntent = new Intent(arg0.getContext(), MainMenu.class);
        		Bundle bundle = new Bundle();
       		
        		myIntent.putExtras(bundle);
        		startActivityForResult(myIntent, 0);
			}
        };
       login.setOnClickListener(login_clickEvent);
       
       //waiting for newUser button to be clicked
       OnClickListener newUser_clickEvent = new OnClickListener(){
       	public void onClick(View arg0){
       		Intent myIntent = new Intent(arg0.getContext(), NewUser.class);
       		Bundle bundle = new Bundle();
      		
       		myIntent.putExtras(bundle);
       		startActivityForResult(myIntent, 0);
			}
       };
      newUser.setOnClickListener(newUser_clickEvent);
      
      //waiting for forgotPassword button to be clicked
      OnClickListener forgotPassword_clickEvent = new OnClickListener(){
         	public void onClick(View arg0){
         		Intent myIntent = new Intent(arg0.getContext(), ForgotPassword.class);
         		Bundle bundle = new Bundle();
        		
         		myIntent.putExtras(bundle);
         		startActivityForResult(myIntent, 0);
  			}
         };
        forgotPassword.setOnClickListener(forgotPassword_clickEvent);
    }
}
