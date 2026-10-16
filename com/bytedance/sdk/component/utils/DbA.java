package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class DbA {
    private static eli eli;

    /* renamed from: com.bytedance.sdk.component.utils.DbA$DbA, reason: collision with other inner class name */
    public interface InterfaceC0150DbA {
        void eli();

        void eli(Throwable th);
    }

    public interface eli {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();

        boolean isStartActivityBySubThread();
    }

    public static void eli(eli eliVar) {
        eli = eliVar;
    }

    public static void eli(final Context context, final Intent intent, final InterfaceC0150DbA interfaceC0150DbA) {
        ExecutorService asyncStartActivityThreadPool;
        eli eliVar = eli;
        if (eliVar != null && eliVar.isStartActivityBySubThread() && (asyncStartActivityThreadPool = eli.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.wC.wC("startAct") { // from class: com.bytedance.sdk.component.utils.DbA.1
                @Override // java.lang.Runnable
                public void run() {
                    DbA.Os(context, intent, interfaceC0150DbA);
                }
            });
        } else {
            Os(context, intent, interfaceC0150DbA);
        }
    }

    public static boolean eli(final Context context, final Intent intent, final InterfaceC0150DbA interfaceC0150DbA, boolean z) {
        eli eliVar;
        ExecutorService asyncStartActivityThreadPool;
        if (z && (eliVar = eli) != null && eliVar.isEnableAsyncStartActivity() && (asyncStartActivityThreadPool = eli.getAsyncStartActivityThreadPool()) != null) {
            asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.wC.wC("startAct") { // from class: com.bytedance.sdk.component.utils.DbA.2
                @Override // java.lang.Runnable
                public void run() {
                    DbA.Os(context, intent, interfaceC0150DbA);
                }
            });
            return true;
        }
        return Os(context, intent, interfaceC0150DbA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Os(Context context, Intent intent, InterfaceC0150DbA interfaceC0150DbA) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (interfaceC0150DbA == null) {
                    return true;
                }
                interfaceC0150DbA.eli();
                return true;
            } catch (Throwable th) {
                if (interfaceC0150DbA != null) {
                    interfaceC0150DbA.eli(th);
                }
            }
        }
        return false;
    }

    public static Activity eli(View view) {
        View findViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (findViewById = rootView.findViewById(R.id.content)) == null || (context = findViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public static boolean eli(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
