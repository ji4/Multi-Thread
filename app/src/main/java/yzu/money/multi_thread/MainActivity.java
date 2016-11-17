package yzu.money.multi_thread;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngo= (Button) findViewById(R.id.button);
        btngo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
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
}
