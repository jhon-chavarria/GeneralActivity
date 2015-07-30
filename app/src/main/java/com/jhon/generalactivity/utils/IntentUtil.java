package com.jhon.generalactivity.utils;

import android.app.Activity;
import android.content.Intent;

import com.jhon.generalactivity.R;
import com.jhon.generalactivity.activities.GeneralActivity;

/**
 * Created by jhon on 28/7/15.
 */
public class IntentUtil {

    public static void goToGeneralActivity(Activity activity, Class cls, boolean useTransition) {
        goToGeneralActivity(activity, cls, false, useTransition);
    }

    public static void goToGeneralActivity(Activity activity, Class cls, boolean showSettings, boolean useTransition) {
        final Intent intent = getGeneralActivityIntent(activity, cls, showSettings);
        activity.startActivity(intent);

        if (useTransition) {
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public static Intent getGeneralActivityIntent(Activity activity, Class cls, boolean showSettings) {
        final Intent intent = new Intent(activity, GeneralActivity.class);
        intent.putExtra(GeneralActivity.EXTRA_CLASS_NAME, cls.getName());

        if (showSettings) {
            intent.putExtra(GeneralActivity.EXTRA_SHOW_MENU_SETTINGS, true);
        }

        return intent;
    }
    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
