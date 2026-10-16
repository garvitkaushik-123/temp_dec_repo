package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f6289a;
    public List<String> b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l c;

    public b(List<String> list, List<String> list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l vastTracker) {
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.f6289a = list;
        this.b = list2;
        this.c = vastTracker;
    }

    public static /* synthetic */ void a(b bVar, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        bVar.a(num, str);
    }

    public static /* synthetic */ void b(b bVar, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        bVar.b(num, str);
    }

    public final void a(Integer num, String str) {
        List<String> list = this.f6289a;
        if (list != null) {
            this.c.a(list, null, num, str);
            this.f6289a = null;
        }
    }

    public final void b(Integer num, String str) {
        List<String> list = this.b;
        if (list != null) {
            this.c.a(list, null, num, str);
            this.b = null;
        }
    }

    public /* synthetic */ b(List list, List list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? n.b() : lVar);
    }
}
