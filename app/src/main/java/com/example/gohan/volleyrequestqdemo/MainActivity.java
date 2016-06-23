package com.example.gohan.volleyrequestqdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    String server_url = "http://192.168.26.11:8080/Learn/volley/greetings.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.ser_btn);
        textView = (TextView) findViewById(R.id.ser_txt);
        // For message Cache
        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
        // For n/w transaction
        Network network = new BasicNetwork(new HurlStack());
    }
}
