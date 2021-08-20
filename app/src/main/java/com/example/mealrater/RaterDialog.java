package com.example.mealrater;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.util.zip.Inflater;

public class RaterDialog extends DialogFragment {
    public RaterDialog() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog, container);
        getDialog().setTitle("Rate Meal");
        final RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        Button button = view.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                saveRating(rating);
            }
        });
        return view;
    }
    private void saveRating(float rating) {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didFinishMealRaterDialog(rating);
        getDialog().dismiss();
    }
    public interface SaveRatingListener {
        void didFinishMealRaterDialog(float rating);
    }






}
