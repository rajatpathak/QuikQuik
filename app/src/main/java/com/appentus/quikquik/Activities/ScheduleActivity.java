package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.appentus.quikquik.R;

import java.util.Calendar;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class ScheduleActivity extends AppCompatActivity {
    Activity activity=this;

    @BindView(R.id.txtmonthyear)
    TextView txtmonthyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, 0);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 3);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());

       /* HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()   // default to "EEE".
                .showTopText(false)              // show or hide TopText (default to true).
                .showBottomText(true)           // show or hide BottomText (default to true).
                .textColor(R.color.gray, R.color.white)    // default to (Color.LTGRAY, Color.WHITE).
                .selectedDateBackground(getResources().getDrawable(R.drawable.whiteround))      // set selected date cell background.
                .selectorColor(R.color.colororange)// set selection indicator bar's color (default to colorAccent).
                .end()          // ends configuration.
                .defaultSelectedDate(cal)    // Date to be selected at start (default to current day `Calendar.getInstance()`).
                .build();*/

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .showTopText(false)
                .selectorColor(Color.RED)
                .end()
                .build();

        horizontalCalendar.getConfig()
                .setSelectorColor(R.color.colororange);

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String d = date.getTime()+"";
                String n =d.substring(d.indexOf(" "));
                txtmonthyear.setText(n.substring(0, 4)+" "+ n.substring(n.length()-4));
            }
        });
    }

    @OnClick({R.id.ivback,R.id.tvcontinue})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
            case R.id.tvcontinue:
                startActivity(new Intent(activity, RatingOrderActivity.class));
                break;
        }
    }
}
