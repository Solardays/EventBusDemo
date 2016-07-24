package com.jc.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jc.eventbusdemo.entities.MessageEvent;
import com.jc.eventbusdemo.view.TouchEventUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout tefRl,tecRl;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        tefRl = (RelativeLayout) findViewById(R.id.tef_rl);
        tecRl = (RelativeLayout) findViewById(R.id.tec_rl);

        tefRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(
                        new MessageEvent("TouchEventFather"));
            }
        });

        tecRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(
                        new MessageEvent("TouchEventChild"));
            }
        });

        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
//                finish();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TouchEvent", "MainActivity | dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("TouchEvent", "MainActivity | onTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
        return true;
    }


    @Subscribe
    public void onEventBackgroundThread(MessageEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getmMsg();
        Log.e("TouchEvent", msg);
        textView.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
