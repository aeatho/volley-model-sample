package com.dd.model.http.loader;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

public class CacheImageLoader extends ImageLoader {

    /**
     * Constructs a new ImageLoader.
     *
     * @param queue      The RequestQueue to use for making image requests.
     * @param imageCache The cache to use as an L1 cache.
     */

    private final BitmapLruCache mMemoryCache;
    private final Cache mDiskCache;


    public CacheImageLoader(RequestQueue queue, BitmapLruCache memoryCache) {
        super(queue, memoryCache);
        mMemoryCache = memoryCache;
        mDiskCache = queue.getCache();
    }

    public BitmapLruCache getMemoryCache() {
        return mMemoryCache;
    }
    public Cache getDiskCache() {
        return mDiskCache;
    }
}
