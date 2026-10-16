package com.fyber.inneractive.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class l0 {
    public final WeakHashMap b = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap f1765a = new WeakHashMap();
    public final j c = new j(16, new g0());
    public final j d = new j(16, new h0());

    public final void a(Context context, View view, k0 k0Var) {
        View rootView;
        ViewTreeObserver viewTreeObserver;
        IAlog.a("%strackView called with context: %s view: %s", "IAVisibilityTracker: ", context, view);
        if (context == null) {
            throw new IllegalStateException("View must be attached to an Activity context");
        }
        Context applicationContext = context.getApplicationContext();
        WeakHashMap weakHashMap = (WeakHashMap) this.b.get(applicationContext);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.b.put(applicationContext, weakHashMap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.getWindow() != null) {
                    rootView = activity.getWindow().getDecorView();
                    viewTreeObserver = rootView.getViewTreeObserver();
                    if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                        i0 i0Var = new i0(this, applicationContext);
                        viewTreeObserver.addOnPreDrawListener(i0Var);
                        this.f1765a.put(applicationContext, new Pair(viewTreeObserver, i0Var));
                    }
                }
            }
            rootView = view.getRootView();
            viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                i0 i0Var2 = new i0(this, applicationContext);
                viewTreeObserver.addOnPreDrawListener(i0Var2);
                this.f1765a.put(applicationContext, new Pair(viewTreeObserver, i0Var2));
            }
        }
        weakHashMap.put(view, k0Var);
        b();
    }

    public final void b() {
        for (Context context : this.b.keySet()) {
            IAlog.a("%stracking context: %s", "IAVisibilityTracker: ", context);
            WeakHashMap weakHashMap = (WeakHashMap) this.b.get(context);
            if (weakHashMap != null) {
                Iterator it = weakHashMap.keySet().iterator();
                while (it.hasNext()) {
                    IAlog.a("%stracking view: %s", "IAVisibilityTracker: ", (View) it.next());
                }
            }
        }
    }

    public final void a(View view) {
        IAlog.a("%sunTrackView called with view", "IAVisibilityTracker: ");
        if (view == null) {
            IAlog.a("%sunTrackView called with a null view!", "IAVisibilityTracker: ");
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            IAlog.a("%sview.getContext() returned null!", "IAVisibilityTracker: ");
            return;
        }
        Map map = (Map) this.b.get(context);
        if (map != null) {
            a(context, map, view);
        } else {
            Iterator it = new HashSet(this.b.keySet()).iterator();
            while (it.hasNext()) {
                Context context2 = (Context) it.next();
                WeakHashMap weakHashMap = (WeakHashMap) this.b.get(context2);
                if (weakHashMap != null) {
                    a(context2, weakHashMap, view);
                }
            }
        }
        b();
    }

    public final void a(Context context, Map map, View view) {
        if (map.remove(view) != null) {
            if (IAlog.f1749a <= 2) {
                IAlog.e("removeViewFromContext found view for removal!", new Object[0]);
            }
            if (map.isEmpty()) {
                this.b.remove(context);
                Pair pair = (Pair) this.f1765a.get(context);
                if (pair != null) {
                    if (((ViewTreeObserver) pair.first).isAlive()) {
                        ((ViewTreeObserver) pair.first).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) pair.second);
                    }
                    this.f1765a.remove(context);
                }
            }
        }
    }

    public final void a() {
        this.b.clear();
        Iterator it = this.f1765a.keySet().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) this.f1765a.get((Context) it.next());
            if (pair != null && ((ViewTreeObserver) pair.first).isAlive()) {
                ((ViewTreeObserver) pair.first).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) pair.second);
            }
        }
        this.f1765a.clear();
    }
}
