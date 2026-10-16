package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.DbA.eli.eli.eli;
import com.bykv.vk.openvk.eli.eli.eli.eli.DbA;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.openadsdk.core.dV;
import java.io.File;

/* loaded from: classes3.dex */
public class CacheDirFactory {
    public static volatile DbA MEDIA_CACHE_DIR = null;
    public static String ROOT_DIR = null;
    public static final int SPLASH_USE_INTERNAL_STORAGE = 1;
    private static String eli;

    public static int getCacheType() {
        return 1;
    }

    private static DbA eli() {
        if (MEDIA_CACHE_DIR == null) {
            synchronized (CacheDirFactory.class) {
                if (MEDIA_CACHE_DIR == null) {
                    eli eliVar = new eli();
                    MEDIA_CACHE_DIR = eliVar;
                    eliVar.eli(getRootDir());
                    MEDIA_CACHE_DIR.aGH();
                }
            }
        }
        return MEDIA_CACHE_DIR;
    }

    public static String getRootDir() {
        if (!TextUtils.isEmpty(ROOT_DIR)) {
            return ROOT_DIR;
        }
        File eli2 = kb.eli(dV.eli(), com.bytedance.sdk.openadsdk.multipro.DbA.Os(), "tt_ad");
        if (eli2.isFile()) {
            eli2.delete();
        }
        if (!eli2.exists()) {
            eli2.mkdirs();
        }
        String absolutePath = eli2.getAbsolutePath();
        ROOT_DIR = absolutePath;
        return absolutePath;
    }

    public static DbA getICacheDir(int i) {
        return eli();
    }

    public static String getImageCacheDir(String str) {
        if (eli == null) {
            eli = getDiskCacheDirPath(str);
        }
        return eli;
    }

    public static String getDiskCacheDirPath(String str) {
        return getRootDir() + File.separator + str;
    }
}
