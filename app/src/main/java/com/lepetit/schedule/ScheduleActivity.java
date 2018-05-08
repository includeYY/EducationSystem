package com.lepetit.schedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;

import com.lepetit.eventmessage.FinishEvent;
import com.lepetit.eventmessage.ScheduleEvent;
import com.lepetit.greendaohelper.ScheduleData;
import com.lepetit.greendaohelper.ScheduleInfo;
import com.lepetit.leapplication.R;
import com.lepetit.schedulehelper.Schedule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleActivity extends AppCompatActivity {

    private List<ScheduleInfo> scheduleInfos;

    @BindView(R.id.grid)
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        //初始化数据库
        ScheduleData.initDB(getApplicationContext(), "Schedule.db");
        //检查数据库是否有数据
        doSomeCheck();
    }

    private void doSomeCheck() {
        scheduleInfos =  ScheduleData.search();
        if (scheduleInfos.isEmpty()) {
            Schedule.getSchedule();
        } else {
            printSchedule();
        }
    }

    //接收获取数据的广播 并将课表存到本地数据库
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onGetSchedule(ScheduleEvent event) {
        ScheduleData.insert(event.getDay(), event.getCourse(), event.getTeacher(),
                event.getWeek(), event.getTime(), event.getClassroom());
    }

    //接收课表处理完毕的广播
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getScheduleFinish(FinishEvent event) {
        scheduleInfos = ScheduleData.search();
        printSchedule();
    }

    //打印课表
    private void printSchedule() {
        SetSchedule setSchedule = new SetSchedule(getApplicationContext(), gridLayout);
        for (ScheduleInfo info : scheduleInfos) {
            String course = info.getCourse();
            String classroom = info.getClassroom();
            String time = info.getTime();
            int day = Integer.parseInt(info.getDay());
            int rowStart = Integer.parseInt(time.substring(0, 2));
            int rowEnd = Integer.parseInt(time.substring(time.length() - 3, time.length() - 1));
            int rowSize = rowEnd - rowStart + 1;
            setSchedule.addToScreen(course, classroom, rowStart, rowSize, day);
        }
    }
}