package my.devs.apps.testing.quickdagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject TestService testService;

    TextView textHello;

    private Button buttonEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHello = (TextView)findViewById(R.id.text_hello);

        buttonEdit  = (Button) findViewById(R.id.button_Edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(MainActivity.class.getSimpleName(), "Resuming! User is " + testService.getUser().getEmail());

        if(testService != null){
            textHello.setText("SUCCESS! User is " + testService.getUser().getName() +
                    " and email is " + testService.getUser().getEmail());
        }else{
            textHello.setText("FAILURE!");
        }
    }
}

