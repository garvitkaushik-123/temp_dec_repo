package com.inmobi.media;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes4.dex */
public abstract class F4 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2280a = 0;

    public static final ArrayList a(Context context) {
        File databasePath;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        String[] databaseList = context.databaseList();
        if (databaseList != null && databaseList.length != 0) {
            for (String str : databaseList) {
                Intrinsics.checkNotNull(str);
                if (new Regex("com\\.im_([0-9]+\\.){3}db").matches(str)) {
                    int i = C2969z3.f2770a;
                    if (!Intrinsics.areEqual(str, "com.im_10.8.7.db") && (databasePath = context.getDatabasePath(str)) != null && databasePath.exists() && !context.deleteDatabase(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = C6.b;
        Intrinsics.checkNotNullParameter("carb_store", "fileKey");
        Intrinsics.checkNotNullParameter("aes_key_store", "fileKey");
        Intrinsics.checkNotNullParameter("mraid_js_store", "fileKey");
        Intrinsics.checkNotNullParameter("omid_js_store", "fileKey");
        Intrinsics.checkNotNullParameter("user_info_store", "fileKey");
        Intrinsics.checkNotNullParameter("coppa_store", "fileKey");
        Intrinsics.checkNotNullParameter("gesture_info_store", "fileKey");
        Intrinsics.checkNotNullParameter("display_info_store", "fileKey");
        Intrinsics.checkNotNullParameter("unified_id_info_store", "fileKey");
        Intrinsics.checkNotNullParameter("app_bundle_store", "fileKey");
        Intrinsics.checkNotNullParameter("pub_signals_store", "fileKey");
        Intrinsics.checkNotNullParameter("CrashSession-store", "fileKey");
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"com.im.keyValueStore.carb_store", "com.im.keyValueStore.aes_key_store", "com.im.keyValueStore.mraid_js_store", "com.im.keyValueStore.omid_js_store", "com.im.keyValueStore.user_info_store", "com.im.keyValueStore.coppa_store", "com.im.keyValueStore.gesture_info_store", "com.im.keyValueStore.display_info_store", "com.im.keyValueStore.unified_id_info_store", "com.im.keyValueStore.app_bundle_store", "com.im.keyValueStore.pub_signals_store", "com.im.keyValueStore.CrashSession-store"}).iterator();
        while (it.hasNext()) {
            context.deleteSharedPreferences((String) it.next());
        }
        return !a(context).isEmpty();
    }

    public static final void a(File path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            if (path.exists()) {
                File[] listFiles = path.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isDirectory()) {
                            Intrinsics.checkNotNull(file);
                            a(file);
                        } else if (file.delete()) {
                            Intrinsics.checkNotNullExpressionValue("F4", "TAG");
                            file.getName();
                        }
                    }
                }
                if (path.delete()) {
                    Intrinsics.checkNotNullExpressionValue("F4", "TAG");
                    path.getName();
                }
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("F4", "TAG");
        }
    }
}
