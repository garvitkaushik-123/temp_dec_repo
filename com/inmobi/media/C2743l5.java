package com.inmobi.media;

import android.view.OrientationEventListener;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.ironsource.C3040d4;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* renamed from: com.inmobi.media.l5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2743l5 extends OrientationEventListener {
    public static final /* synthetic */ KProperty[] d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(C2743l5.class, "currentOrientation", "getCurrentOrientation()Lcom/inmobi/ads/rendering/orientation/Orientation;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final InMobiAdActivity f2629a;
    public final HashSet b;
    public final C2727k5 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2743l5(InMobiAdActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2629a = activity;
        this.b = new HashSet();
        Delegates delegates = Delegates.INSTANCE;
        this.c = new C2727k5(AbstractC2829qa.a(U3.g()), this);
    }

    public final void a(C2844ra orientationProperties) {
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        try {
            if (orientationProperties.f2695a) {
                this.f2629a.setRequestedOrientation(13);
                return;
            }
            String str = orientationProperties.b;
            if (Intrinsics.areEqual(str, C3040d4.h.C)) {
                this.f2629a.setRequestedOrientation(6);
            } else if (Intrinsics.areEqual(str, C3040d4.h.D)) {
                this.f2629a.setRequestedOrientation(7);
            } else {
                this.f2629a.setRequestedOrientation(13);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public final void b() {
        int i = this.f2629a.getResources().getConfiguration().orientation;
        byte g = U3.g();
        int i2 = 1;
        if (g != 1 && g != 2 && (g == 3 || g == 4)) {
            i2 = 2;
        }
        if (i == i2) {
            this.c.setValue(this, d[0], AbstractC2829qa.a(U3.g()));
        }
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        b();
    }

    public final void a() {
        if (this.b.isEmpty()) {
            disable();
        } else {
            enable();
        }
    }
}
