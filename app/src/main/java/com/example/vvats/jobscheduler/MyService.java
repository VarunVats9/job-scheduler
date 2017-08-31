package com.example.vvats.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyService extends JobService {
    public MyService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this, "Job Started", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Toast.makeText(this, "Job Stopped", Toast.LENGTH_SHORT).show();
        return false;
    }


}
