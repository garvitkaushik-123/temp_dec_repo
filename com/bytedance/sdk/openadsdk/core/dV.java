package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class dV {
    private static volatile CMM<com.bytedance.sdk.openadsdk.aGH.eli> DbA = null;
    private static int Os = -1;
    private static volatile Context eli;

    public static Context eli() {
        if (eli == null) {
            DbA(null);
        }
        return eli;
    }

    public static Context eli(Context context) {
        if (context == null) {
            context = eli();
        }
        if (context instanceof Application) {
            return context;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static void DbA(Context context) {
        if (eli == null) {
            synchronized (dV.class) {
                if (eli == null) {
                    if (context != null) {
                        eli = context;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            eli = applicationContext;
                        }
                        return;
                    }
                    try {
                        Application eli2 = eli.eli();
                        if (eli2 != null) {
                            eli = eli2;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static int DbA() {
        Context eli2;
        if (Os < 0 && (eli2 = eli()) != null) {
            Os = ViewConfiguration.get(eli2).getScaledTouchSlop();
        }
        return Os;
    }

    public static CMM<com.bytedance.sdk.openadsdk.aGH.eli> Os() {
        if (DbA == null) {
            synchronized (dV.class) {
                if (DbA == null) {
                    DbA = new ev(eli);
                }
            }
        }
        return DbA;
    }

    public static com.bytedance.sdk.openadsdk.core.settings.MGA aGH() {
        return com.bytedance.sdk.openadsdk.core.settings.NU.nY();
    }

    public static com.bytedance.sdk.openadsdk.Dfc.Os.DbA ui() {
        if (!com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            return com.bytedance.sdk.openadsdk.Dfc.Os.Os.eli();
        }
        return com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli();
    }

    private static class eli {
        private static volatile Application eli;

        public static Application eli() {
            return eli;
        }

        static {
            try {
                Object DbA = DbA();
                eli = (Application) DbA.getClass().getMethod("getApplication", new Class[0]).invoke(DbA, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.eli("MyApplication", "application get failed", th);
            }
        }

        private static Object DbA() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.eli("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
