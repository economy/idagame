package com.ida.idagame;

import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

/**
 * Created by economy on 8/24/16.
 */

public class MapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    GoogleMap.OnInfoWindowClickListener,
    GoogleMap.OnMapLongClickListener,
    GoogleMap.OnMapClickListener,
    GoogleMap.OnMarkerClickListener{

    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;

    private final int[] MAP_TYPES = { GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE };
    private int curMapTypeIndex = 1;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        mGoogleApiClient = new GoogleApiClient.Builder( getActivity() )
                .addConnectionCallbacks( this )
                .addOnConnectionFailedListener( this )
                .addApi( LocationServices.API )
                .build();

        initListeners();
    }

    private void initListeners() {
        getMap().setOnMarkerClickListener(this);
        getMap().setOnMapLongClickListener(this);
        getMap().setOnInfoWindowClickListener( this );
        getMap().setOnMapClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if( mGoogleApiClient != null && mGoogleApiClient.isConnected() ) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        mCurrentLocation = LocationServices
                .FusedLocationApi
                .getLastLocation( mGoogleApiClient );

        // NB: location returning null
        if(mCurrentLocation == null) {
            mCurrentLocation = new Location( "" );
            mCurrentLocation.setLatitude( 37.422535 );
            mCurrentLocation.setLongitude( -122.084804 );
        }

        //System.out.println(mCurrentLocation);
        initCamera( mCurrentLocation );
    }

    private void initCamera( Location location ) {
        CameraPosition position = CameraPosition.builder()
                .target( new LatLng( location.getLatitude(),
                        location.getLongitude() ) )
                .zoom( 16f )
                .bearing( 0.0f )
                .tilt( 0.0f )
                .build();

        getMap().animateCamera( CameraUpdateFactory
                .newCameraPosition( position ), null );

        getMap().setMapType( MAP_TYPES[curMapTypeIndex] );
        getMap().setTrafficEnabled( false );
        getMap().setMyLocationEnabled( true );
        getMap().getUiSettings().setZoomControlsEnabled( true );
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //Create a default location if the Google API Client fails. Placing location at Googleplex
        mCurrentLocation = new Location( "" );
        mCurrentLocation.setLatitude( 37.422535 );
        mCurrentLocation.setLongitude( -122.084804 );
        initCamera(mCurrentLocation);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
