package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f6225a = c.f6208a.a();

    public static final Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(718660168);
        if ((i2 & 1) != 0) {
            function5 = f6225a;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(718660168, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl (PlaybackControl.kt:30)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1901828083, true, new a(function5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> a() {
        return f6225a;
    }

    public static final class a implements Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f6226a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5) {
            this.f6226a = function5;
        }

        public final void a(BoxScope boxScope, final boolean z, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, final Function1<? super Boolean, Unit> onShouldPlay, final Function0<Unit> onShouldReplay, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(onShouldPlay, "onShouldPlay");
            Intrinsics.checkNotNullParameter(onShouldReplay, "onShouldReplay");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(progress) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(onShouldPlay) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= composer.changed(onShouldReplay) ? 16384 : 8192;
            }
            if ((74899 & i2) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1901828083, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl.<anonymous> (PlaybackControl.kt:32)");
            }
            composer.startReplaceableGroup(263769922);
            boolean changed = composer.changed(progress) | composer.changed(onShouldReplay) | composer.changed(onShouldPlay) | composer.changed(z);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return j.a.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.this, onShouldReplay, onShouldPlay, z);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            this.f6226a.invoke(boxScope, Boolean.valueOf(z), (Function0) rememberedValue, composer, Integer.valueOf(i2 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function1<? super Boolean, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function0 function0, Function1 function1, boolean z) {
            if (iVar instanceof i.a) {
                function0.invoke();
            } else {
                function1.invoke(Boolean.valueOf(!z));
            }
            return Unit.INSTANCE;
        }
    }
}
