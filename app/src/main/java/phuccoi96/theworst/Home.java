package phuccoi96.theworst;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import phuccoi96.theworst.Common.Common;
import phuccoi96.theworst.Interface.ItemClickListener;
<<<<<<< HEAD
import phuccoi96.theworst.ViewHolder.MenuViewHolder;

import phuccoi96.theworst.Model.Place;
=======
import phuccoi96.theworst.Model.Place;
import phuccoi96.theworst.ViewHolder.MenuViewHolder;
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    FirebaseDatabase database;
    DatabaseReference place;
    TextView txtFullName;

    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter <Place,MenuViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        setSupportActionBar(toolbar);

        //Init FireBASE
        database = FirebaseDatabase.getInstance();
        place = database.getReference("Place");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

<<<<<<< HEAD
        //ĐỌC DATABASE NẠP VÀO NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set Name for User (USER ĐANG LOGIN)
=======
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set Name for User
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f
        View headerView = navigationView.getHeaderView(0);
        txtFullName = (TextView)headerView.findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getName());


<<<<<<< HEAD
        //Load menu layout
=======
        //Load menu
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f
        recycler_menu = (RecyclerView)findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);
<<<<<<< HEAD
        loadMenu(); //gọi hàm loadmenu
=======
        loadMenu();
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f


    }

    private void loadMenu() {

        adapter = new FirebaseRecyclerAdapter<Place, MenuViewHolder>(Place.class,R.layout.menu_item,MenuViewHolder.class,place) {
            @Override
            protected void populateViewHolder(MenuViewHolder viewHolder, Place model, int position) {
                viewHolder.txtMenuName.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imageView);
                final Place clickitem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        //Click ListView
                        //Toast.makeText(Home.this,"hahaha"+clickitem.getName(),Toast.LENGTH_SHORT).show();


                        //Start new activity
                        Intent placeDetail = new Intent(Home.this,PlaceDetail.class);
                        placeDetail.putExtra("PlaceId",adapter.getRef(position).getKey()); //send Place ID to new activity
                        startActivity(placeDetail);


                    }
                });
            }
        };
        recycler_menu.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

<<<<<<< HEAD

    // menu tùy chọn (bên trái)
=======
>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
<<<<<<< HEAD

            Intent homeIntent = new Intent(Home.this,HomeFood.class);
            startActivity(homeIntent);
            finish();


        } else if (id == R.id.nav_food) {

//            Intent activity_GGMAP = new Intent(Home.this,Foodlist.class);
//            startActivity(activity_GGMAP);
//            finish();
            Toast.makeText(Home.this,"No function here",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_log_out) {

            //------Logout----
            Intent signin = new Intent(Home.this,SignIn.class);
            startActivity(signin);
            finish();
=======
            // Handle the camera action
        } else if (id == R.id.nav_place) {

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_log_out) {

>>>>>>> 13ed390808fb6e7407fc501414302a0d384bec2f
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
