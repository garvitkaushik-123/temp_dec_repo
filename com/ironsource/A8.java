package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class A8 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f2790a;
    private a b;

    public interface a {
        void a(ag agVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A8(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2790a = "ISNNativeAdContainer";
    }

    private final ag a() {
        return new ag(getVisibility() == 0, getWindowVisibility() == 0, isShown());
    }

    public final a getListener$mediationsdk_release() {
        return this.b;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        Logger.i(this.f2790a, "onVisibilityChanged: " + i);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Logger.i(this.f2790a, "onWindowVisibilityChanged: " + i);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public final void setListener$mediationsdk_release(a aVar) {
        this.b = aVar;
    }
}
