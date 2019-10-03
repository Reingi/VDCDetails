package com.example.vdcdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.badoualy.stepperindicator.StepperIndicator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Adddetails extends AppCompatActivity implements Personaldetails.OnFragmentInteractionListener, Housedetails.OnFragmentInteractionListener, Familymember.OnFragmentInteractionListener{

        private SectionsPagerAdapter mSectionsPagerAdapter;

        private NonSwipeableViewPager mViewPager;

        private StepperIndicator stepperIndicator;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adddetails);

            final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
            navigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navhome:
                            Intent intent = new Intent(getApplicationContext(),MainView.class);
                            startActivity(intent);
                            break;
                            //return true;
                        case R.id.navlogout:
                            Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent1);
                            break;
                        case R.id.navadd:
                            Intent intent2 = new Intent(getApplicationContext(),Adddetails.class);
                            startActivity(intent2);
                            break;
                    }
                }
            });

            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            mViewPager = findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            stepperIndicator = findViewById(R.id.stepperIndicator);

            stepperIndicator.showLabels(true);
            stepperIndicator.setViewPager(mViewPager);

            stepperIndicator.setViewPager(mViewPager,mViewPager.getAdapter().getCount()-1);

        }

        protected int getLayoutResource(){
            return R.layout.activity_adddetails;
        }

        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return Personaldetails.newInstance("", "");
                    case 1:
                        return Housedetails.newInstance("", "");
                    case 2:
                        return Familymember.newInstance("", "");
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "व्यक्तिगत विवरण";
                    case 1:
                        return "घरको विवरण";
                    case 2:
                        return "परिवारको विवरण";
                }
                return null;
            }
        }

        @Override
        public void onNextPressed(Fragment fragment) {
            if (fragment instanceof Personaldetails) {
                mViewPager.setCurrentItem(1, true);
            } else if (fragment instanceof Housedetails) {
                mViewPager.setCurrentItem(2, true);
            } else if (fragment instanceof Familymember) {
                Toast.makeText(this, "Thanks For Registering", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        @Override
        public void onBackPressed(Fragment fragment) {
            if (fragment instanceof Housedetails) {
                mViewPager.setCurrentItem(0, true);
            } else if (fragment instanceof Familymember) {
                mViewPager.setCurrentItem(1, true);
            }
        }

        @Override
        public void onSavePressed(Fragment fragment) {
            System.out.println("saved button clicked");
        }
    }
