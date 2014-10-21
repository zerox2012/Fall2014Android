package usf.fall2014.android.fishingbuddy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Map extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		 Button message = (Button) this.findViewById(R.id.button_message);
		 OnClickListener message_clickEvent = new OnClickListener(){
	        	public void onClick(View arg0){
	        		Intent myIntent = new Intent(arg0.getContext(), Message.class);
	        		Bundle bundle = new Bundle();
	       		
	        		myIntent.putExtras(bundle);
	        		startActivityForResult(myIntent, 0);
				}
	        };
	       message.setOnClickListener(message_clickEvent);
	}

}
