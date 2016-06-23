package com.example.gohan.volleyrequestqdemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Freeware Sys on 23-Jun-16.
 */
public class Mysingleton {

    private static Mysingleton mInstance;
    private RequestQueue requestQueue;
    private static Context nCtx;


    //constructor
    private Mysingleton(Context context)
    {
        nCtx = context;
        requestQueue = getRequestQue();
    }


    //for getting requestQueue
    public RequestQueue getRequestQue()
    {
        if(requestQueue==null)
        {
            // last through lifetime of the app
            requestQueue = Volley.newRequestQueue(nCtx.getApplicationContext());
        }
        return requestQueue;
    }


    //method for returning instance of singletop

    public static synchronized Mysingleton getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance = new Mysingleton(context);
        }
        return mInstance;
    }

    // for adding to requestQueue

    public void addToRequestQue(Request request)
    {
        requestQueue.add(request);
    }
}
