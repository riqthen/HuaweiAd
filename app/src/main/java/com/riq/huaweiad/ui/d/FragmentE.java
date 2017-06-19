package com.riq.huaweiad.ui.d;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.riq.huaweiad.R;
import com.riq.huaweiad.utils.Lcat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentE extends Fragment {


    @BindView(R.id.sv_fe)
    SurfaceView svFe;
    private Unbinder unbinder;
    private MediaPlayer mp;

    public FragmentE() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e, container, false);
        unbinder = ButterKnife.bind(this, view);
        mp = MediaPlayer.create(getActivity(), R.raw.meipai);
        initSV();
        Lcat.print("create1");
        return view;
    }

    private void initSV() {
        svFe.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mp.setDisplay(holder);
                mp.setLooping(true);
                mp.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mp.stop();
                mp.release();
                mp = null;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Lcat.print("destroy1");
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mp != null && mp.isPlaying()) {
//            mp.stop();
//            mp.release();
//            mp = null;
//        }
//    }
}
