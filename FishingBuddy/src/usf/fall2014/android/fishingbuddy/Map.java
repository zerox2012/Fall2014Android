package usf.fall2014.android.fishingbuddy;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity {
	 
    // Google Map
    private GoogleMap mMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
     
        mapSetup();
 
    
    }

	private void mapSetup() 
	{
		if(mMap == null)
		  {
			mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
			if(mMap != null)
			{
				initializeMap();
			}
		  }
		}

	private void initializeMap()
	{
		double latitude = 0.0;
		double longitude = 0.0;
		
		mMap.setMyLocationEnabled(true); // Enables MyLocation
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE); // Gets the LocationManager
		Criteria criteria = new Criteria(); // Criteria Object to contact provider
		String provider = locationManager.getBestProvider(criteria, true); // Gets the name of the best provider
		Location myLocation = locationManager.getLastKnownLocation(provider); // Gets current location
		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // Sets the type of map used
		latitude = myLocation.getLatitude(); // Gets the Lat. of current location
	    longitude = myLocation.getLongitude();// Gets the Lng. of the current location
		
		
		LatLng latLng = new LatLng(latitude,longitude); //creates an object to reference coordinates
		mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng)); // Shows current location on the map
		
		// ZOOM
		mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
		mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!"));
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO!
		return true;
		
	}
	
	
}