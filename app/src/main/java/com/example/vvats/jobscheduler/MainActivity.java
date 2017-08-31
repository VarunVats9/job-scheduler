package com.example.vvats.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton toggleButton;
    JobScheduler jobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            JobInfo.Builder job = new JobInfo.Builder(1, new ComponentName(getPackageName(), MyService.class.getName()))
                    .setRequiresDeviceIdle(false)
                    .setRequiresCharging(false)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
            jobScheduler.schedule(job.build());
        } else {
            jobScheduler.cancelAll();
        }
    }
}
