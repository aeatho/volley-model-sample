package com.dd.model.http;

import com.android.volley.RequestQueue;

import org.jetbrains.annotations.NotNull;

import android.content.Context;

public class RequestManager {

    private static RequestManager sInstance;
    private RequestQueue mParallelQueue;
    private RequestQueue mQueue;

    private RequestManager(@NotNull Context context) {
        mParallelQueue = RequestQueueFactory.newParallelRequestQueue(context);
        mQueue = RequestQueueFactory.newRequestQueue(context);
    }

    public static synchronized void initializeInstance(@NotNull Context context) {
        if (sInstance == null) {
            sInstance = new RequestManager(context);
        }
    }

    @NotNull
    public static synchronized RequestQueue getParallelQueue() {
        if (sInstance == null) {
            throw new IllegalStateException(RequestManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance.mParallelQueue;
    }

    @NotNull
    public static synchronized RequestQueue getQueue() {
        if (sInstance == null) {
            throw new IllegalStateException(RequestManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance.mQueue;
    }
}
