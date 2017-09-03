package my.devs.apps.testing.quickdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class EditActivity extends AppCompatActivity {

    @Inject
    TestService service;

    private EditText editEmail;

    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editEmail = (EditText) findViewById(R.id.edit_Email);
        editEmail.setText(service.getUser().getEmail());

        buttonSave = (Button) findViewById(R.id.button_Save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getUser().setEmail(editEmail.getText().toString());
                EditActivity.this.finish();
            }
        });
    }


}
