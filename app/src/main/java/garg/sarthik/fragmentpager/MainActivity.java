package garg.sarthik.fragmentpager;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = findViewById(R.id.vpFrags);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vp);
    }

    public void addIntent(Object object)
    {
        if(object instanceof StarDetails)
        {
             StarDetails sd = (StarDetails)object;
             Intent i = new Intent(MainActivity.this,SecondActivity.class);
             i.putExtra("Name",sd.getName());
             i.putExtra("Detail",sd.getDetails());
             i.putExtra("ImageURL",sd.getImageURL());
             i.putExtra("MoreURL",sd.getMoreURL());
             startActivity(i);
        }
        else{
            if(object instanceof PlanetDetails){
                PlanetDetails pd = (PlanetDetails)object;
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("Name",pd.getName());
                i.putExtra("Detail",pd.getDetails());
                i.putExtra("ImageURL",pd.getImageURL());
                i.putExtra("MoreURL",pd.getMoreURL());
                startActivity(i);
            }
            else{
                if(object instanceof GalaxyDetails)
                {
                    GalaxyDetails gd = (GalaxyDetails)object;
                    Intent i = new Intent(MainActivity.this,SecondActivity.class);
                    i.putExtra("Name",gd.getName());
                    i.putExtra("Detail",gd.getDetails());
                    i.putExtra("ImageURL",gd.getImageURL());
                    i.putExtra("MoreURL",gd.getMoreURL());
                    startActivity(i);
                }
            }
        }

    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Planets";
                case 1:
                    return "Stars";
                case 2:
                    return "Galaxies";
            }
            return "";
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new Frag_PlanetList();
                case 1:
                    return new Frag_StarList();
                case 2:
                    return new Frag_GalaxyList();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

//    @Override
//    public void handleOnClick(Student student) {
//        FrameLayout containerB = findViewById(R.id.containerB);
//        if (containerB == null){
//            //Portrait, start the intent
//        }
//        else{
//            //Landscape, start the fragment
//        }
//    }
}
