package yzu.money.multi_thread;

import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btngo;
    ImageView iv;
    int img=0;
    int []A={R.drawable.p1, R.drawable.p2};
    Handler handler=new Handler();//管理程式執行
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            iv=(ImageView) findViewById(R.id.imageView);
            iv.setImageResource(A[img]);
            img=(img+1)%2;
            handler.postDelayed(this,100);
        }
    };//沒有變數名稱的宣告方式

    @Override
    protected void onDestroy() {
        if(handler!=null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo= (Button) findViewById(R.id.button);
        btngo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                handler.postDelayed(runnable,30);

                System.out.println("test");
                //Log.i("money","test");
                //way1
                /*new Thread(){
                    public void run()
                    {
                        int i;
                        for(i=0;i<100;i++)
                            System.out.println(i);
                    }
                }.start();*/

                //way2
                mythread t1=new mythread("a",1);
                mythread t2=new mythread("b",2);
                mythread t3=new mythread("c",3);
                mythread t4=new mythread("d",4);
                mythread t5=new mythread("e",5);
                t1.start();
                try {
                    t1.join();//等1跑完，其他再執行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*try {
                    mythread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                t2.start();
                t3.start();
                t4.start();
                t5.start();

                Thread r=new Thread(new myRunable(6));
                r.start();
            }
        });
    }
    class mythread extends Thread{
        int id;

        public mythread(String name, int id) {//constructor
            super(name);
            this.id = id;
        }

        @Override
        public void run() {
            super.run();
            int i;
            for(i=0;i<100;i++)
                System.out.println("id: "+id+", i: "+i);
        }
    }
    class myRunable implements Runnable{
        int id;
        public myRunable(int id) {//constroctor
            this.id=id;
        }

        @Override
        public void run() {
            int i;
            for(i=0;i<100;i++)
                System.out.println("id: "+id+", i: "+i);
        }
    }
}
