package cn.refactor.smoothcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.refactor.library.SmoothCheckBox;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final SmoothCheckBox mcb = (SmoothCheckBox) findViewById(R.id.mcb);
        mcb.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                Log.d("MellowCheckBox", String.valueOf(isChecked));
            }
        });
    }

}
