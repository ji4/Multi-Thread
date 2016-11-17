package yzu.money.multi_thread;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo= (Button) findViewById(R.id.button);
        btngo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("test");
                //Log.i("money","test");
            }
        });
    }
}
