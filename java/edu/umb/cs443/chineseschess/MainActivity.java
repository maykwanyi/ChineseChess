package edu.umb.cs443.chineseschess;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {
    GridView gridView;
    private String[] numbers = new String[9*10];

    Thread t1;
    MoveTask t2;

    private static int target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        for (int i = 0; i < numbers.length; i++) numbers[i] = " ";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.selected_piece, numbers);

        gridView.setAdapter(adapter);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id){
                t2=new MoveTask();
                t2.execute(new Integer(position));
            }
        });

        t1=new Thread(new Runnable(){
            public void run(){
                while(true) {
                    gridView.post(new Runnable() {
                        public void run() {
                            ((ArrayAdapter) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    });
                }
            }
        }

        );
        t1.start();
    }

    private class MoveTask extends AsyncTask<Integer, Void, Void>{
        @Override
        protected Void doInBackground(Integer... params) {
            target=params[0].intValue();
            Log.i("myTag", params[0].toString());

            publishProgress();

            return null;
        }

        protected void onProgressUpdate(Void... values) {
            ((ArrayAdapter)gridView.getAdapter()).notifyDataSetChanged();
        }

    }


}
