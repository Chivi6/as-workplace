package com.example.administrator.forceoffline;

import android.app.Activity;
import android.util.Log;
import android.view.ViewDebug;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public  class ActivityList{
    public static List<Activity> activityList = new ArrayList<>();
    public static void add(Activity activity){
        activityList.add(activity);
    }
    public static void remove(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
