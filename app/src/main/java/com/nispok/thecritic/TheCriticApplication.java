package com.nispok.thecritic;

import android.app.Application;

import com.nispok.thecritic.data.DaggerTmdbComponent;
import com.nispok.thecritic.data.TmdbComponent;
import com.nispok.thecritic.data.TmdbModule;

public class TheCriticApplication extends Application {

    TmdbComponent tmdbComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        tmdbComponent = DaggerTmdbComponent.builder()
                .tmdbModule(new TmdbModule()).build();
    }

    public TmdbComponent getTmdbComponent() {
        return tmdbComponent;
    }
}
