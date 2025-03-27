package com.bca.mobile_programming.unit_5;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bca.mobile_programming.R;

public class Fragment_one extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.unit_5_fragment_one, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragment", "Fragment_one - onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        Log.d("Fragment", "Fragment_one - onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment", "Fragment_one - onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment", "Fragment_one - onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment", "Fragment_one - onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment", "Fragment_one - onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment", "Fragment_one - onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment", "Fragment_one - onDestroy");
    }
}
