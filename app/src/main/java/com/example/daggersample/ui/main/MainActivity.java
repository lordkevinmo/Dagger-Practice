package com.example.daggersample.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.daggersample.BaseActivity;
import com.example.daggersample.R;
import com.example.daggersample.ui.main.profile.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import static com.example.daggersample.R.*;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        drawerLayout = findViewById(id.drawer_layout);
        navigationView = findViewById(id.nav_view);

    }

   private void init() {
       NavController navController = Navigation.findNavController(this, id.nav_host_fragment_container);
       NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
       NavigationUI.setupWithNavController(navigationView, navController);
       navigationView.setNavigationItemSelectedListener(this);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == id.logout) {
            sessionManager.logOut();
            return true;
        }

        if (item.getItemId() == id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            } else {
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == id.nav_profile) {
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(id.main, true)
                    .build();

            Navigation.findNavController(this, id.nav_host_fragment_container)
                    .navigate(id.profileScreen);
        } else if (itemId == id.nav_posts) {
            if(isValidDestination(id.postsScreen)) {
                Navigation.findNavController(this, id.nav_host_fragment_container)
                        .navigate(id.postsScreen);
            }
        }
        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isValidDestination(int destination) {
        return destination != Objects.requireNonNull(Navigation.findNavController(
                this, id.nav_host_fragment_container)
                .getCurrentDestination())
                .getId();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(
                Navigation.findNavController(this, id.nav_host_fragment_container),
                drawerLayout);
    }
}
