package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3454d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.N;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o {
    public static final Unit a(j.a aVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        a(aVar, modifier, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Unit b(j.a aVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        a(aVar, modifier, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void a(final j.a htmlResource, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(htmlResource, "htmlResource");
        Composer startRestartGroup = composer.startRestartGroup(-1230364815);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(htmlResource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            final Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1230364815, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastResourceHtml (VastResourceHtml.kt:11)");
            }
            startRestartGroup.startReplaceableGroup(-1944712831);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                N n = N.f5809a;
                Object obj = N.b.get(Integer.valueOf(htmlResource.b()));
                if (!(obj instanceof C3454d)) {
                    obj = null;
                }
                rememberedValue = (C3454d) obj;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            C3454d c3454d = (C3454d) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            if (c3454d == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.o$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return o.a(j.a.this, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(c3454d, modifier2, null, startRestartGroup, (i3 & 112) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.o$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return o.b(j.a.this, modifier, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }
}
