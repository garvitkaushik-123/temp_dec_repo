package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Df implements yf {
    public static final WeakHashMap g = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Af f2268a;
    public final InterfaceC2971z5 b;
    public View c;
    public final ConcurrentHashMap d;
    public final WeakReference e;
    public EnumC2813pa f;

    public Df(Activity activity, Af windowInsetListener, InterfaceC2971z5 interfaceC2971z5) {
        Window window;
        Intrinsics.checkNotNullParameter(windowInsetListener, "windowInsetListener");
        this.f2268a = windowInsetListener;
        this.b = interfaceC2971z5;
        this.d = new ConcurrentHashMap();
        WeakReference weakReference = new WeakReference(activity);
        this.e = weakReference;
        if (!L3.f2348a.F()) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler", "WindowInsetsHandler is not supported for this version");
                return;
            }
            return;
        }
        Activity activity2 = (Activity) weakReference.get();
        View decorView = (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView();
        if (decorView != null) {
            this.c = decorView;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler", "startListeningToInsets");
            }
            WeakHashMap weakHashMap = g;
            Object obj = weakHashMap.get(decorView);
            if (obj == null) {
                obj = new zf(decorView);
                weakHashMap.put(decorView, obj);
            }
            Intrinsics.checkNotNullParameter(this, "listener");
            ((zf) obj).f2777a.add(this);
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler_INSTANCE", this + " created - " + weakHashMap.size());
            }
        }
    }

    public final void a(Bf insets, int i) {
        EnumC2813pa orientation = AbstractC2829qa.a(U3.g());
        Cf cf = (Cf) this.d.get(Integer.valueOf(i));
        if (cf == null) {
            cf = new Cf();
            this.d.put(Integer.valueOf(i), cf);
        }
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Bf bf = (Bf) cf.f2256a.get(orientation);
        if (bf == null || !Intrinsics.areEqual(insets, bf)) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler", "safeArea - New value, updating to KV store");
            }
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            Intrinsics.checkNotNullParameter(insets, "insets");
            cf.f2256a.put(orientation, insets);
            ConcurrentHashMap concurrentHashMap = this.d;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(concurrentHashMap.size()));
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((Cf) entry.getValue()).a());
            }
            U3.a(linkedHashMap);
        } else {
            InterfaceC2971z5 interfaceC2971z52 = this.b;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("WindowInsetsHandler", "SafeArea - Same value, no need to update");
            }
        }
        if (this.f != orientation) {
            this.f = orientation;
            Af af = this.f2268a;
            Object obj = this.d.get(Integer.valueOf(i));
            Intrinsics.checkNotNull(obj);
            af.a(orientation, (Cf) obj);
        }
    }

    public final void a() {
        View view = this.c;
        if (view != null) {
            WeakHashMap weakHashMap = g;
            zf zfVar = (zf) weakHashMap.get(view);
            if (zfVar != null) {
                Intrinsics.checkNotNullParameter(this, "listener");
                zfVar.f2777a.remove(this);
                if (zfVar.f2777a.isEmpty()) {
                    zfVar.a();
                    weakHashMap.remove(view);
                }
            }
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WindowInsetsHandler_INSTANCE", this + " destroy - " + weakHashMap.size());
            }
        }
    }
}
