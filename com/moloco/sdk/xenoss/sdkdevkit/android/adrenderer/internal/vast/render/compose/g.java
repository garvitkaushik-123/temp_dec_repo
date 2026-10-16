package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;

/* loaded from: classes6.dex */
public final class g {
    public static final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, long j, long j2, long j3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o oVar, Function0<Unit> function0, com.moloco.sdk.internal.ortb.model.i iVar, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-78614409);
        Alignment topEnd = (i2 & 1) != 0 ? Alignment.INSTANCE.getTopEnd() : alignment;
        PaddingValues m872PaddingValues0680j_4 = (i2 & 2) != 0 ? PaddingKt.m872PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long m1603getPrimary0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m1603getPrimary0d7_KjU() : j;
        long b = (i2 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j2;
        long d = (i2 & 16) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d() : j3;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o a2 = (i2 & 32) != 0 ? a(null, 0L, null, 0L, composer, 0, 15) : oVar;
        Function0<Unit> function02 = (i2 & 64) != 0 ? null : function0;
        com.moloco.sdk.internal.ortb.model.i iVar2 = (i2 & 128) == 0 ? iVar : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-78614409, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultAdSkipCountdownButton (DefaultAdSkipCountdownButton.kt:35)");
        }
        int i3 = i << 3;
        Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d.a(topEnd, m872PaddingValues0680j_4, m1603getPrimary0d7_KjU, b, d, a2, a.AbstractC0571a.c.EnumC0573a.c, function02, iVar2, composer, (i3 & 234881024) | (i & 14) | 1572864 | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (29360128 & i3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return a3;
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o a(Painter painter, long j, Shape shape, long j2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-571269297);
        if ((i2 & 1) != 0) {
            painter = PainterResources_androidKt.painterResource(R.drawable.ic_round_skip_next_24, composer, 0);
        }
        Painter painter2 = painter;
        if ((i2 & 2) != 0) {
            j = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            shape = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.f();
        }
        Shape shape2 = shape;
        long e = (i2 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-571269297, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.adSkipAfterCountdownIcon (DefaultAdSkipCountdownButton.kt:53)");
        }
        o.b bVar = new o.b(painter2, "Skip", j3, shape2, e, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bVar;
    }
}
