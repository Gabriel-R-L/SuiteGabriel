package com.suitegabriel.suitesensores.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.suitegabriel.suitesensores.R;
import com.suitegabriel.suitesensores.sensores.Linterna;
import com.suitegabriel.suitesensores.sensores.Musica;
import com.suitegabriel.suitesensores.sensores.Nivel;
import com.suitegabriel.suitesensores.utils.Calculadora;
import com.suitegabriel.suitesensores.utils.Creditos;
import com.suitegabriel.suitesensores.utils.Info;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    * menu hamburguesa
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* Establecer la orientación a retrato
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        * menu de la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        * menu hamburguesa e iniciar event listener
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        * cargar el menu
        navigationView.inflateMenu(R.menu.nav_menu_dele);

//        * cargar el header
        navigationView.inflateHeaderView(R.layout.nav_header_dele);

//        * crear el menu hamburguesa
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        * abrir el fragmento home al iniciar la app
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Calculadora()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

//    * crear la toolbar de la app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.dele_calc) {
            Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Calculadora()).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    //    * manejar los eventos del menu hamburguesa
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nav_home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();

//              * cambiar el menu hamburguesa
            NavigationView navigationView = findViewById(R.id.nav_view);
//              * limpiar el menu hamburguesa para que no se duplique
            navigationView.getMenu().clear();
            navigationView.removeHeaderView(navigationView.getHeaderView(0));
//              * cargar el menu de cada uno
            navigationView.inflateMenu(R.menu.nav_menu_dele);
//              * cargar el header
            navigationView.inflateHeaderView(R.layout.nav_header_dele);

//            * cargar la calculadora
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Calculadora()).commit();

        } else if (item.getItemId()==R.id.nav_linterna) {
            Toast.makeText(this, "Linterna", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Linterna()).commit();
        } else if (item.getItemId()==R.id.nav_musica) {
            Toast.makeText(this, "Musica", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Musica()).commit();
        } else if (item.getItemId()==R.id.nav_nivel) {
            Toast.makeText(this, "Nivel", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Nivel()).commit();
        } else if (item.getItemId()==R.id.nav_creditos) {
            Toast.makeText(this, "Créditos", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Creditos()).commit();
        } else if (item.getItemId()==R.id.nav_info) {
            Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Info()).commit();
        } else if (item.getItemId()==R.id.nav_salir) {
            Toast.makeText(this, "Saliendo*", Toast.LENGTH_SHORT).show();
            finishAffinity();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}