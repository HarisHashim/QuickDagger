package my.devs.apps.testing.quickdagger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by harishashim on 8/12/2017.
 */

//Move this interface to its own class file and do Build => Make Project
@Singleton
@Component(modules = {AndroidInjectionModule.class, App.AppModule.class})
public interface AppComponent extends AndroidInjector<App> {
}


