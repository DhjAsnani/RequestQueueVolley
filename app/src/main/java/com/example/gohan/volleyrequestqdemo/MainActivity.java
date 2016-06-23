package com.example.gohan.volleyrequestqdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {
    Button btn,img_btn;
   // String uri = "@drawable/error";
    TextView textView;
    ImageView imageView;
    String server_url = "http://192.168.26.11:8080/Learn/volley/greetings.php";
    String img_url = "http://192.168.26.11:8080/Learn/volley/gogeta.png";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.ser_btn);
        textView = (TextView) findViewById(R.id.ser_txt);
        img_btn = (Button) findViewById(R.id.img_btm);
        imageView = (ImageView) findViewById(R.id.imageView);
       /* This method is for requestQueue
        // For message Cache
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        // For n/w transaction
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                        requestQueue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Error....");
                        error.printStackTrace();

                    }
                });
                requestQueue.add(stringRequest);
            }
        });*/


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    textView.setText("Error.......");
                        error.printStackTrace();
                    }
                });
                Mysingleton.getInstance(getApplicationContext()).addToRequestQue(stringRequest);
            }
        });



        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageRequest imageRequest = new ImageRequest(img_url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                            imageView.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.errors));
                        error.printStackTrace();
                    }
                });
                Mysingleton.getInstance(getApplicationContext()).addToRequestQue(imageRequest);
            }
        });
    }
}
