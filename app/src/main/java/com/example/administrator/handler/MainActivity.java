package com.example.administrator.handler;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private TextView  mTextView;
    private Handler mHandler = new Handler();
    int pic[] = {R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4, R.drawable.pic_5
    };
    int index;
    private MyRunnable myHandler=new MyRunnable();

    class MyRunnable implements Runnable {


        @Override
        public void run() {
            index++;
            index = index%3;
            mImageView.setImageResource(pic[index]);
            mHandler.postDelayed(myHandler, 3000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv_title);
        mImageView = (ImageView) findViewById(R.id.iv_pic);
        mHandler.postDelayed(myHandler, 1000);
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(2000);
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mTextView.setText("Update");
//                        }
//                    });
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
    }

}
