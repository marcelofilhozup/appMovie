package com.example.android.appmovie.bases;

import android.os.Bundle;

public abstract class BasePresenter implements BaseContract.Presenter {

    private Bundle extras;
    private BaseContract.View mView;
    public BasePresenter(BaseContract.View view) {
        this.mView = view;
    }

    @Override
    public final void init(Bundle extras) {

        if (extras != null)
            this.extras = extras;
        else
            this.extras = new Bundle();
        init();
    }

    @Override
    public Bundle getExtras() {
        return extras;
    }

    @Override
    public void setExtras(Bundle extras) {
        this.extras = extras;
    }

    public abstract void init();
}
