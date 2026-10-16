package io.bidmachine.iab.vast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.view.View;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes7.dex */
public class VastHelper {

    /* renamed from: a, reason: collision with root package name */
    static final WeakHashMap<View, OnScreenStateChangeListener> f6866a = new WeakHashMap<>();
    private static final BroadcastReceiver b = new a();
    private static final IntentFilter c;
    private static boolean d;
    private static boolean e;

    public interface OnScreenStateChangeListener {
        void onScreenStateChange(boolean isScreenOn);
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (VastHelper.class) {
                boolean unused = VastHelper.e = "android.intent.action.SCREEN_ON".equals(intent.getAction());
            }
            WeakHashMap<View, OnScreenStateChangeListener> weakHashMap = VastHelper.f6866a;
            synchronized (weakHashMap) {
                Iterator<OnScreenStateChangeListener> it = weakHashMap.values().iterator();
                while (it.hasNext()) {
                    it.next().onScreenStateChange(VastHelper.e);
                }
            }
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        c = intentFilter;
        d = false;
        e = false;
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
    }

    public static void addScreenStateChangeListener(View view, OnScreenStateChangeListener listener) {
        a(view.getContext());
        WeakHashMap<View, OnScreenStateChangeListener> weakHashMap = f6866a;
        synchronized (weakHashMap) {
            weakHashMap.put(view, listener);
        }
    }

    public static boolean isScreenOn(Context context) {
        a(context);
        return e;
    }

    public static void removeScreenStateChangeListener(View view) {
        if (d) {
            WeakHashMap<View, OnScreenStateChangeListener> weakHashMap = f6866a;
            synchronized (weakHashMap) {
                weakHashMap.remove(view);
            }
        }
    }

    private static synchronized void a(Context context) {
        synchronized (VastHelper.class) {
            if (!d) {
                synchronized (VastHelper.class) {
                    if (!d) {
                        e = ((PowerManager) context.getSystemService("power")).isScreenOn();
                        context.getApplicationContext().registerReceiver(b, c);
                        d = true;
                    }
                }
            }
        }
    }
}
