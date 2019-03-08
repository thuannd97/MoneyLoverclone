package thuannd.com.moneyloverclone;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import thuannd.com.moneyloverclone.adapter.PageAdapter;
import thuannd.com.moneyloverclone.view.ui.FragmentCategory;
import thuannd.com.moneyloverclone.view.ui.FragmentDealList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int navIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupViewPager();

        loadFragmentWithoutBackStack(getFragmentHome());
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_deal_list:
                navIndex = 0;
                Toast.makeText(this, "so giao dich", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_category:
                navIndex = 1;
                Toast.makeText(this, "nhom", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_trending:
                navIndex = 2;
                Toast.makeText(this, "xu huong", Toast.LENGTH_SHORT).show();
                break;
            default:
                navIndex = 0;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Fragment getFragmentHome() {
        switch (navIndex) {
            case 0:
                return FragmentDealList.newInstance(1, 2019);
            case 1:
                return FragmentCategory.newInstance("test", "test");
            case 2:
                return FragmentDealList.newInstance(3, 2019);
            default:
                return FragmentDealList.newInstance(8, 2019);
        }
    }

    public void loadFragmentWithoutBackStack(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
    }


    public void setupViewPager() {
        // view page
        ViewPager viewPager = findViewById(R.id.viewPager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        pageAdapter.add(FragmentDealList.newInstance(1, 2019), "Tháng 1");
        pageAdapter.add(FragmentDealList.newInstance(2, 2019), "Tháng 2");
        pageAdapter.add(FragmentDealList.newInstance(3, 2019), "Tháng 3");
        pageAdapter.add(FragmentDealList.newInstance(4, 2019), "Tháng 4");
        pageAdapter.add(FragmentDealList.newInstance(5, 2019), "Tháng 5");
        pageAdapter.add(FragmentDealList.newInstance(6, 2019), "Tháng 6");
        pageAdapter.add(FragmentCategory.newInstance("test", "test"), "Tháng 7");
        viewPager.setAdapter(pageAdapter);

        // tab layout
        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);
    }

}
