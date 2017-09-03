package my.devs.apps.testing.quickdagger;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Module
    public abstract class AppModule {
        @ContributesAndroidInjector
        abstract MainActivity mainActivity();

        @ContributesAndroidInjector
        abstract EditActivity editActivity();

    }
}


