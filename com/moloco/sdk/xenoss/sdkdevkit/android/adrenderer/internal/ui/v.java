package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class v {
    public static final Unit a(Modifier modifier, a.AbstractC0571a.c.EnumC0573a enumC0573a, Function1 function1, Function3 function3, int i, int i2, Composer composer, int i3) {
        a(modifier, enumC0573a, function1, function3, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final a.AbstractC0571a.c.EnumC0573a buttonType, final Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1040306081);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(buttonType) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(onButtonRendered) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1040306081, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.TrackableButton (TrackableButton.kt:22)");
            }
            startRestartGroup.startReplaceableGroup(-334659178);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(buttonType), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            a.AbstractC0571a.c a2 = a(mutableState);
            startRestartGroup.startReplaceableGroup(-334654626);
            boolean changed = startRestartGroup.changed(mutableState) | startRestartGroup.changed(onButtonRendered);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return v.a(Function1.this, mutableState, (a.AbstractC0571a.c) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            content.invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a.a(modifier, a2, (Function1<? super a.AbstractC0571a.c, Unit>) rememberedValue2), startRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return v.a(Modifier.this, buttonType, onButtonRendered, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function1 function1, MutableState mutableState, a.AbstractC0571a.c it) {
        Intrinsics.checkNotNullParameter(it, "it");
        a(mutableState, it);
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public static final a.AbstractC0571a.c a(MutableState<a.AbstractC0571a.c> mutableState) {
        return mutableState.getValue();
    }

    public static final void a(MutableState<a.AbstractC0571a.c> mutableState, a.AbstractC0571a.c cVar) {
        mutableState.setValue(cVar);
    }
}
