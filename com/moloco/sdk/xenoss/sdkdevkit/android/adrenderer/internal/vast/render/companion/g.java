package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g {
    public static final int f = 8;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f6200a;
    public List<String> b;
    public List<String> c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h d;
    public final l e;

    public g(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, List<String> list, List<String> list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker, l vastTracker) {
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.f6200a = customUserEventBuilderService;
        this.b = list;
        this.c = list2;
        this.d = buttonTracker;
        this.e = vastTracker;
    }

    public final void a(a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.d.a(button);
    }

    public final void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.d.a(buttonType);
    }

    public final void a(a.AbstractC0571a.f lastClickPosition) {
        Intrinsics.checkNotNullParameter(lastClickPosition, "lastClickPosition");
        List<String> list = this.b;
        if (list != null) {
            l.a.a(this.e, list, null, null, null, this.d.q(), this.f6200a, lastClickPosition, 14, null);
            this.b = null;
        }
    }

    public /* synthetic */ g(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, List list, List list2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, list, list2, (i & 8) != 0 ? j.a() : hVar, (i & 16) != 0 ? n.b() : lVar);
    }

    public final void a() {
        List<String> list = this.c;
        if (list != null) {
            l.a.a(this.e, list, null, null, null, 14, null);
            this.c = null;
        }
    }
}
