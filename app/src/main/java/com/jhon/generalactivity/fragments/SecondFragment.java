package com.jhon.generalactivity.fragments;

import android.content.Intent;

import com.jhon.generalactivity.R;
import com.jhon.generalactivity.activities.GeneralActivity;
import com.jhon.generalactivity.utils.IntentUtil;

import butterknife.OnClick;

/**
 * Created by jhon on 28/7/15.
 */
public class SecondFragment extends BaseFragment {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_second;
    }

    @Override
    protected int getTitleResourceId() {
        return R.string.second_fragment;
    }

    @OnClick(R.id.next)
    public void goNext() {
        Intent intent = IntentUtil.getGeneralActivityIntent(getActivity(), ThirdFragment.class, true);
        intent.putExtra(GeneralActivity.EXTRA_SHOW_HOME_AS_UP, true);
        intent.putExtra(GeneralActivity.EXTRA_SHOW_MENU_SETTINGS, false);
        IntentUtil.startActivity(getActivity(), intent);
    }
}
