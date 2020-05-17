package com.matheus.f.n.pereira.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.matheus.f.n.pereira.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlfabetoFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;

    private MediaPlayer mediaPlayer;

    public AlfabetoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alfabeto, container, false);

        buttonA = view.findViewById(R.id.buttonA);
        buttonB = view.findViewById(R.id.buttonB);
        buttonC = view.findViewById(R.id.buttonC);
        buttonD = view.findViewById(R.id.buttonD);
        buttonE = view.findViewById(R.id.buttonE);
        buttonF = view.findViewById(R.id.buttonF);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonA:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.a);
                break;
            case R.id.buttonB:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.b);
                break;
            case R.id.buttonC:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.c);
                break;
            case R.id.buttonD:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.d);
                break;
            case R.id.buttonE:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.e);
                break;
            case R.id.buttonF:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.f);
                break;
        }
        tocarSom();
    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
