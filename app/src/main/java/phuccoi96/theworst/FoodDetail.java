package phuccoi96.theworst;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import phuccoi96.theworst.Model.Food_In_Detail;
import phuccoi96.theworst.Model.Place_In_Detail;

/**
 * Created by USER on 1/24/2018.
 */

public class FoodDetail extends AppCompatActivity {


    TextView place_name,place_price,place_description;
    ImageView place_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnSearch;
    ElegantNumberButton numberButton;

    String foodId="";

    FirebaseDatabase database;
    DatabaseReference food;

    private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        food = database.getReference("Food_In_Detail");


        //Init view
       // numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnSearch = (FloatingActionButton)findViewById(R.id.btnSearch);


        place_description = (TextView)findViewById(R.id.place_description);
        place_name = (TextView)findViewById(R.id.place_name);
        place_price = (TextView)findViewById(R.id.place_price);
        place_image = (ImageView)findViewById(R.id.img_food);


        collapsingToolbarLayout =(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //get place Id from Intent
        if(getIntent()!=null)
            foodId = getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty())
        {
            getDetailPlace(foodId);
        }
    }

    private void getDetailPlace(final String foodId) {

        food.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //cho nay no dung Place chu ko dung Place_In_Detail nhu minh
                Food_In_Detail food = dataSnapshot.getValue(Food_In_Detail.class);


                //Set image
                Picasso.with(getBaseContext()).load(food.getImage())
                        .into(place_image);

                collapsingToolbarLayout.setTitle(food.getName());

                place_price.setText(food.getPrice());
                place_name.setText(food.getName());
                place_description.setText(food.getDescription());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
