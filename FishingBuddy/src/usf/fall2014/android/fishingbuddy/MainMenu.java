package usf.fall2014.android.fishingbuddy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		Button fishingMap = (Button) this.findViewById(R.id.button_map);
        Button gallery = (Button) this.findViewById(R.id.button_gallery);
	    Button exitApp = (Button) this.findViewById(R.id.button_exitapp);
	    
	    //waiting for the map button to be clicked
	    OnClickListener fishingMap_clickEvent = new OnClickListener(){
         	public void onClick(View arg0){
         		Intent myIntent = new Intent(arg0.getContext(), Map.class);
         		Bundle bundle = new Bundle();
        		
         		myIntent.putExtras(bundle);
         		startActivityForResult(myIntent, 0);
  			}
         };
        fishingMap.setOnClickListener(fishingMap_clickEvent);
        
        //waiting for the gallery button to be clicked
        OnClickListener gallery_clickEvent = new OnClickListener(){
         	public void onClick(View arg0){
         		Intent myIntent = new Intent(arg0.getContext(), Gallery.class);
         		Bundle bundle = new Bundle();
        		
         		myIntent.putExtras(bundle);
         		startActivityForResult(myIntent, 0);
  			}
         };
        gallery.setOnClickListener(gallery_clickEvent);
        
        //waiting for the exit button to be clicked
        OnClickListener exitApp_clickEvent = new OnClickListener(){
         	public void onClick(View arg0){
         		finish();         		
         		System.exit(0);       		
  			}
         };
        exitApp.setOnClickListener(exitApp_clickEvent);
	}
}
