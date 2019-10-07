package com.example.android.appmovie.bases;

import android.os.Bundle;

public interface BaseContract {

    interface View extends BaseView { }

    interface Presenter {
        void init(Bundle extras);

        Bundle getExtras();

        void setExtras(Bundle extras);

    }
}
