package com.example.testappcenterandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.crashes.CrashesListener;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;

public class MainActivity extends AppCompatActivity {

    Button buttnCrash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCenter.start(getApplication(),"bd416e1a-b8b8-4d06-9ceb-96c0c18b4a85",Analytics.class,Crashes.class);
        AppCenter.setLogLevel(Log.VERBOSE);
buttnCrash = (Button)findViewById(R.id.button1);
        Crashes.getLastSessionCrashReport();
        Crashes.setListener(new CrashesListener() {
            @Override
            public boolean shouldProcess(ErrorReport report) {




                return false;




            }

            @Override
            public boolean shouldAwaitUserConfirmation() {
                return false;
            }

            @Override
            public Iterable<ErrorAttachmentLog> getErrorAttachments(ErrorReport report) {
                return null;
            }

            @Override
            public void onBeforeSending(ErrorReport report) {

            }

            @Override
            public void onSendingFailed(ErrorReport report, Exception e) {

            }

            @Override
            public void onSendingSucceeded(ErrorReport report) {

            }
        });


        buttnCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crashes.generateTestCrash();
            }
        });

    }
}
