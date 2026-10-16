package com.moloco.sdk.internal.publisher.nativead.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;

/* loaded from: classes6.dex */
public final class e {
    public static final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
        composer.startReplaceableGroup(-1062465295);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062465295, i, -1, "com.moloco.sdk.internal.publisher.nativead.ui.nativeVideoMuteButton (NativeVideoMuteButton.kt:11)");
        }
        Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a2 = n.a(0L, 0L, null, 0L, Alignment.INSTANCE.getTopStart(), null, Color.INSTANCE.m4100getWhite0d7_KjU(), PainterResources_androidKt.painterResource(R.drawable.moloco_twotone_volume_off_24, composer, 0), PainterResources_androidKt.painterResource(R.drawable.moloco_twotone_volume_up_24, composer, 0), null, composer, 1597440, 559);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return a2;
    }
}
