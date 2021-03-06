package com.jhon.generalactivity.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jhon.generalactivity.R;

import butterknife.Bind;

/**
 * Created by jhon on 28/7/15.
 */
public class GeneralActivity extends BaseActivity {

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public static final String EXTRA_CLASS_NAME = "GENERAL_ACTIVITY_EXTRA_CLASS_NAME";
    public static final String EXTRA_SHOW_HOME_AS_UP = "GENERAL_ACTIVITY_SHOW_HOME_AS_UP";
    public static final String EXTRA_SHOW_MENU_SETTINGS = "GENERAL_ACTIVITY_SHOW_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() == null) {
            return;
        }

        setSupportActionBar(toolbar);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final FragmentManager manager = getFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment,
                Fragment.instantiate(this, getIntent().getStringExtra(EXTRA_CLASS_NAME)));
        transaction.commit();

        if (getSupportActionBar() == null) {
            return;
        }


        if (getIntent().hasExtra(EXTRA_SHOW_HOME_AS_UP) &&
                getIntent().getBooleanExtra(EXTRA_SHOW_HOME_AS_UP, false)) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (getIntent().hasExtra(EXTRA_SHOW_MENU_SETTINGS) && getIntent().getBooleanExtra(EXTRA_SHOW_MENU_SETTINGS, true))
            menu.findItem(R.id.action_settings).setVisible(true);

        return true;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_general;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
