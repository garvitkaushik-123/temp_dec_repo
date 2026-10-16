package com.bytedance.sdk.openadsdk.multipro.eli;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.MGA;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.ui;
import com.bytedance.sdk.openadsdk.multipro.aGH;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class eli {
    private static final ConcurrentHashMap<String, Object> DbA = new ConcurrentHashMap<>();
    public static MGA eli;

    public static MGA eli(Context context) {
        if (context == null) {
            try {
                dV.eli();
            } catch (Throwable unused) {
                dZ.wC("binder error");
            }
        }
        if (eli == null) {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                eli = com.bytedance.sdk.openadsdk.multipro.aidl.eli.MGA.eli(com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(5));
            } else {
                eli = com.bytedance.sdk.openadsdk.multipro.aidl.eli.MGA.DbA();
            }
        }
        return eli;
    }

    private static String eli() {
        return aGH.DbA + "/t_db/ttopensdk.db/";
    }

    public static void eli(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (eli(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                ui.eli(context).eli().eli(str, (String) null, contentValues);
                return;
            }
            MGA eli2 = eli(context);
            if (eli2 != null) {
                eli2.eli(Uri.parse(eli() + str), contentValues);
            }
        }
    }

    public static int eli(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (eli(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                return ui.eli(context).eli().eli(str, str2, strArr);
            }
            MGA eli2 = eli(context);
            if (eli2 != null) {
                return eli2.eli(Uri.parse(eli() + str), str2, strArr);
            }
            return 0;
        }
    }

    public static int eli(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            synchronized (eli(str)) {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    return ui.eli(context).eli().eli(str, contentValues, str2, strArr);
                }
                MGA eli2 = eli(context);
                if (eli2 != null) {
                    return eli2.eli(Uri.parse(eli() + str), contentValues, str2, strArr);
                }
            }
        }
        return 0;
    }

    public static Map<String, List<String>> eli(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (eli(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                return eli(ui.eli(context).eli().eli(str, strArr, str2, strArr2, str3, str4, str5));
            }
            MGA eli2 = eli(context);
            if (eli2 != null) {
                return eli2.eli(Uri.parse(eli() + str), strArr, str2, strArr2, str5);
            }
            return null;
        }
    }

    public static Map<String, List<String>> eli(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (cursor != null) {
            try {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.getCount() > 0 && cursor.moveToNext()) {
                    for (String str : columnNames) {
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new LinkedList());
                        }
                        ((List) hashMap.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return hashMap;
                }
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return hashMap;
    }

    private static Object eli(String str) {
        Object obj;
        ConcurrentHashMap<String, Object> concurrentHashMap = DbA;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (eli.class) {
            obj = concurrentHashMap.get(str);
            if (obj == null) {
                obj = new Object();
                concurrentHashMap.put(str, obj);
            }
        }
        return obj;
    }
}
