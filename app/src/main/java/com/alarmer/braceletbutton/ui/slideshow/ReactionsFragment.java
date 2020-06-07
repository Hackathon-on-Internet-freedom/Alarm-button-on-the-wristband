package com.alarmer.braceletbutton.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alarmer.braceletbutton.R;

public class ReactionsFragment extends Fragment {

    private ReactionsViewModel reactionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reactionsViewModel =
                ViewModelProviders.of(this).get(ReactionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reactions, container, false);
        final TextView textView = root.findViewById(R.id.text_reactions);
        reactionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}