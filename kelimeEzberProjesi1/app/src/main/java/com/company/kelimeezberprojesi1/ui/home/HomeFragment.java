package com.company.kelimeezberprojesi1.ui.home;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.kelimeezberprojesi1.R;
import com.company.kelimeezberprojesi1.databinding.FragmentHomeBinding;
import com.company.kelimeezberprojesi1.sqlwords;
import com.company.kelimeezberprojesi1.wordadapter;
import com.company.kelimeezberprojesi1.wordviewmodel;

import java.util.List;

public class HomeFragment extends Fragment  {
    private wordviewmodel wordview;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        wordview = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(wordviewmodel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recview= getActivity().findViewById(com.company.kelimeezberprojesi1.R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        wordadapter wordadapter = new wordadapter();
        recview.setAdapter(wordadapter);

        wordview.getAllwords().observe(this, new Observer<List<sqlwords>>() {
            @Override
            public void onChanged(@Nullable @androidx.annotation.Nullable List<sqlwords> sqlwords) {
                //recycleview
                wordadapter.setWords(sqlwords);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}