package com.bytedance.sdk.openadsdk.core.FC.eli;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile DbA eli;
    private final ArrayList<String> DbA = new ArrayList<>();
    private final AtomicBoolean Os = new AtomicBoolean(false);
    private long aGH = System.currentTimeMillis();
    private long ui = 0;
    private long MGA = 0;
    private String kb = "";
    private String wC = "";
    private String FC = "";
    private boolean aAs = false;
    private boolean du = false;

    public static DbA eli(Application application) {
        if (eli == null) {
            synchronized (DbA.class) {
                if (eli == null) {
                    DbA dbA = new DbA();
                    eli = dbA;
                    dbA.aAs = eli((Context) application);
                    eli.du = eli(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    eli.eli();
                }
            }
        }
        return eli;
    }

    private static int eli(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static boolean eli(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public void eli(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.DbA.size() == 0) {
            this.kb = localClassName;
            this.ui = System.currentTimeMillis();
            this.MGA = System.currentTimeMillis() - this.aGH;
            this.Os.set(false);
        }
        if (!this.DbA.contains(localClassName)) {
            this.DbA.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.FC = localClassName;
    }

    public void DbA(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.DbA.contains(localClassName)) {
            this.DbA.remove(localClassName);
        }
        if (this.DbA.size() == 0) {
            this.aGH = System.currentTimeMillis();
            this.Os.set(true);
            this.wC = localClassName;
        }
    }

    private void eli() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField(C3040d4.h.h0);
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object valueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(valueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(valueAt)).getLocalClassName();
                        if (!this.DbA.contains(localClassName)) {
                            this.DbA.add(localClassName);
                        }
                    }
                }
                this.Os.set(this.DbA.size() <= 0);
            }
        } catch (Throwable unused) {
        }
    }

    public String eli(String str, long j, int i) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.ui;
        long j3 = currentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.Os.get() && this.du) {
            i2 |= 2;
        }
        if (!this.Os.get() && this.MGA >= 5000 && j2 < 1000) {
            i2 = this.wC.equals(this.FC) ? i2 | 4 : i2 | 8;
        }
        try {
            str2 = new JSONObject().put("rst", i2).put("adtag", str).put("bakdur", this.MGA).put("rit", i).put("poptime", j2).put("unlocktime", j3).put("bakground", this.Os).put("alert", this.du).put(NotificationCompat.CATEGORY_SYSTEM, this.aAs).put("actsize", this.DbA.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.DbA.Os()).toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        this.kb = "";
        this.MGA = 0L;
        this.ui = 0L;
        this.aGH = System.currentTimeMillis();
        return str2;
    }
}
