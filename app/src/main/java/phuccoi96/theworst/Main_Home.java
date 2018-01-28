package phuccoi96.theworst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Main_Home extends AppCompatActivity implements View.OnClickListener {

    private CardView nhatrangplaces,nhatrangrestaurant,nhatranglanguage,nhatrangMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__home);

        //defining Cards
        nhatrangplaces=(CardView)findViewById(R.id.nhaTrangPlaces);
        nhatrangrestaurant=(CardView)findViewById(R.id.nhaTrangRestaurant);
        nhatranglanguage=(CardView)findViewById(R.id.nhaTrangLanguage);
        nhatrangMap=(CardView)findViewById(R.id.nhaTrangMap);


        //Add click listener to the cards
        nhatrangplaces.setOnClickListener(this);
        nhatrangrestaurant.setOnClickListener(this);
        nhatranglanguage.setOnClickListener(this);
        nhatrangMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;

        switch (v.getId())
        {
            case R.id.nhaTrangPlaces : i = new Intent(this,Home.class); break;
            case R.id.nhaTrangRestaurant : i = new Intent(this,HomeFood.class); break;
            case R.id.nhaTrangLanguage : i = new Intent(this,Main_Language.class); break;
            case R.id.nhaTrangMap : i = new Intent(this,activity_GGMAP.class); break;
            default: break;
        }
        startActivity(i);

    }
}
