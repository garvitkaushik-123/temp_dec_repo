package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Xe {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2930x f2487a;
    public C2939x8 b;
    public WeakReference c;
    public final AdConfig d;

    public Xe(InterfaceC2930x container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f2487a = container;
        this.d = container.getAdConfig();
    }

    public abstract View a(View view, ViewGroup viewGroup, boolean z);

    public void a() {
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public abstract void a(byte b);

    public abstract void a(Context context, byte b);

    public abstract void a(View view);

    public abstract void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract void a(Map map);

    public View b() {
        WeakReference weakReference = this.c;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public C2939x8 c() {
        return this.b;
    }

    public View d() {
        return null;
    }

    public abstract void e();
}
