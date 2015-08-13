package com.girls.team9.whowant;

import android.app.SearchManager;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;

    FragmentTransaction fragmentTransaction;
    Fragment cur_fragment=new MainFragment();

    Boolean isvisible=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, SplashActivity.class));

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpNavDrawer();

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, cur_fragment);
        fragmentTransaction.commit();
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        navigationView=(NavigationView)findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getGroupId() == R.id.group_a) {
                    navigationView.getMenu().setGroupCheckable(R.id.group_b, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_a, true, true);
                } else if (menuItem.getGroupId() == R.id.group_b) {
                    navigationView.getMenu().setGroupCheckable(R.id.group_a, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_b, true, true);
                }


                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        getSupportActionBar().setTitle("추천 상품");

                        cur_fragment = new MainFragment();
                        fragmentTransaction.replace(R.id.container, cur_fragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        isvisible = true;
                        invalidateOptionsMenu();
                        return true;

                    case R.id.basket:
                        getSupportActionBar().setTitle("장바구니");
                        cur_fragment = new BasketFragment();
                        fragmentTransaction.replace(R.id.container, cur_fragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        isvisible = true;
                        invalidateOptionsMenu();
                        return true;

//                    case R.id.setup:
//                        getSupportActionBar().setTitle("설정");
//                        cur_fragment = new SetupFragment();
//                        fragmentTransaction.replace(R.id.container, cur_fragment);
//                        fragmentTransaction.commit();
//                        drawerLayout.closeDrawers();
//                        isvisible = false;
//                        invalidateOptionsMenu();
//                        return true;


                }
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (drawerLayout.isDrawerOpen(navigationView))
                    drawerLayout.closeDrawers();
                else {
                    moveTaskToBack(true);
                    finish();
                }//end else
                break;
        }//end switch

        return true;
    }

    private void setUpNavDrawer() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("소개");
        toolbar.setNavigationIcon(R.drawable.drawericon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }//setUpNavDrawer

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}//class
