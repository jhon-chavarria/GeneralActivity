package com.jhon.generalactivity.fragments;


import android.content.Intent;

import com.jhon.generalactivity.R;
import com.jhon.generalactivity.activities.GeneralActivity;
import com.jhon.generalactivity.utils.IntentUtil;

import butterknife.OnClick;

/**
 * Created by jhon on 28/7/15.
 */
public class LoginFragment extends BaseFragment {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_login;
    }

    @Override
    protected int getTitleResourceId() {
        return R.string.app_name;
    }


    @OnClick(R.id.sign_in)
    public void signIn() {
        Intent intent = IntentUtil.getGeneralActivityIntent(getActivity(), FirstFragment.class, true);
        intent.putExtra(GeneralActivity.EXTRA_SHOW_HOME_AS_UP, false);
        intent.putExtra(GeneralActivity.EXTRA_SHOW_MENU_SETTINGS, true);
        IntentUtil.startActivity(getActivity(), intent);
        getActivity().finish();
    }
}
