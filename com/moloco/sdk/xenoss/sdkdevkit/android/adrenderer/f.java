package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: classes6.dex */
public final class f implements InterfaceC3450c {
    public static final int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5767a;
    public final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> b;
    public final int c;
    public final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> d;

    public static final class a implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5768a = new a();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(1952438088);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1952438088, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.AdWebViewOptions.<init>.<anonymous> (AdRenderingOptions.kt:25)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public f() {
        this(0, null, 0, null, 15, null);
    }

    public final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> a() {
        return this.b;
    }

    public final int b() {
        return this.f5767a;
    }

    public final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(int i, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, int i2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> decClose) {
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Intrinsics.checkNotNullParameter(decClose, "decClose");
        this.f5767a = i;
        this.b = adWebViewRenderer;
        this.c = i2;
        this.d = decClose;
    }

    public /* synthetic */ f(int i, Function9 function9, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 5 : i, (i3 & 2) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(0L, null, 3, null) : function9, (i3 & 4) != 0 ? 5 : i2, (i3 & 8) != 0 ? a.f5768a : function2);
    }
}
