package com.asuka.android.asukaandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Author:Asuka
 * Time:2016-9-9
 * Mask: 所有Fragment继承这个Fragment
 */
public class AsukaFragment extends Fragment {

    private boolean injected = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injected = true;
        return AsukaAndroid.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            AsukaAndroid.view().inject(this, this.getView());
        }
    }
}