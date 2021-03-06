package com.lepetit.gradehelper;

import com.lepetit.messagehelper.ConnectEvent;
import com.lepetit.messagehelper.FinishEvent;
import com.lepetit.okhttphelper.OKHttpUnit;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Response;

public class GetGradeInfo {
    private static GetGradeInfo instance;

    private GetGradeInfo() {}

    private static GetGradeInfo getInstance() {
        if (instance == null) {
            instance = new GetGradeInfo();
        }
        return instance;
    }

    private void _get() {
        Headers headers = setHeaders();
        FormBody body = setFormBody();
        OKHttpUnit.postAsync(StringCollection.url, body, headers, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                EventBus.getDefault().post(new ConnectEvent(false));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                EventBus.getDefault().post(new ConnectEvent(true));
                DealHtml.analyze(response.body().string());
                EventBus.getDefault().post(new FinishEvent());
            }
        });
    }

    private Headers setHeaders() {
        return new Headers.Builder()
                .add("Referer", StringCollection.reference)
                .add("User-Agent", StringCollection.userAgent)
                .build();
    }

    private FormBody setFormBody() {
        return new FormBody.Builder()
                .add("kksj", "")
                .add("kcxz", "")
                .add("kcmc", "")
                .add("xsfs", "all")
                .build();
    }

    public static void get() {
        getInstance()._get();
    }
}
