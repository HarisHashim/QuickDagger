package my.devs.apps.testing.quickdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject TestService testService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textHello = (TextView)findViewById(R.id.text_hello);
        if(testService != null){
            textHello.setText("SUCCESS! User is " + testService.getUser().getName() +
                    " and email is " + testService.getUser().getEmail());
        }else{
            textHello.setText("FAILURE!");
        }

    }
}

