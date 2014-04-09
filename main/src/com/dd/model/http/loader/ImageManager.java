package com.dd.model.http.loader;

import com.android.volley.RequestQueue;
import com.dd.model.http.RequestQueueFactory;

import org.jetbrains.annotations.NotNull;

import android.content.Context;

public class ImageManager {

    private static ImageManager instance;
    private CacheImageLoader mImageLoader;

    private ImageManager(@NotNull Context context) {
        BitmapLruCache imageCache = new BitmapLruCache();
        RequestQueue queue = RequestQueueFactory.newParallelRequestQueue(context);
        mImageLoader = new CacheImageLoader(queue, imageCache);
    }

    public static synchronized void initializeInstance(@NotNull Context context) {
        if (instance == null) {
            instance = new ImageManager(context);
        }
    }

    @NotNull
    public static synchronized CacheImageLoader getInstance() {
        if (instance == null) {
            throw new IllegalStateException(ImageManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return instance.mImageLoader;
    }
}
