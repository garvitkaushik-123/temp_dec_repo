package com.moloco.sdk.internal.publisher.nativead.ui;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.R;
import com.moloco.sdk.internal.publisher.nativead.ui.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5564a = new a();
    public static Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> b = ComposableLambdaKt.composableLambdaInstance(1019496058, false, C0452a.f5565a);

    public final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> a() {
        return b;
    }

    /* renamed from: com.moloco.sdk.internal.publisher.nativead.ui.a$a, reason: collision with other inner class name */
    public static final class C0452a implements Function5<BoxScope, Boolean, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0452a f5565a = new C0452a();

        /* renamed from: com.moloco.sdk.internal.publisher.nativead.ui.a$a$a, reason: collision with other inner class name */
        public static final class C0453a implements Function3<Boolean, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f5566a;

            public C0453a(Function0<Unit> function0) {
                this.f5566a = function0;
            }

            public final void a(boolean z, Composer composer, int i) {
                int i2;
                if ((i & 6) == 0) {
                    i2 = i | (composer.changed(z) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1776469658, i2, -1, "com.moloco.sdk.internal.publisher.nativead.ui.ComposableSingletons$NativeVideoPlaybackControlUIKt.lambda-1.<anonymous>.<anonymous> (NativeVideoPlaybackControlUI.kt:30)");
                }
                r.a(PainterResources_androidKt.painterResource(z ? R.drawable.moloco_twotone_pause_24 : R.drawable.moloco_twotone_play_arrow_24, composer, 0), this.f5566a, null, false, "play/pause", Color.INSTANCE.m4100getWhite0d7_KjU(), 0L, 0L, null, 0L, composer, 221184, 972);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
                a(bool.booleanValue(), composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        public final void a(BoxScope boxScope, boolean z, Function0<Unit> onClick, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(onClick) ? 256 : 128;
            }
            if ((i2 & 1171) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1019496058, i2, -1, "com.moloco.sdk.internal.publisher.nativead.ui.ComposableSingletons$NativeVideoPlaybackControlUIKt.lambda-1.<anonymous> (NativeVideoPlaybackControlUI.kt:17)");
            }
            Modifier m879padding3ABfNKs = PaddingKt.m879padding3ABfNKs(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), Dp.m6389constructorimpl(4));
            composer.startReplaceableGroup(277443603);
            final String str = "playback_control_button";
            boolean changed = composer.changed("playback_control_button");
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.internal.publisher.nativead.ui.a$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.C0452a.a(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            CrossfadeKt.Crossfade(Boolean.valueOf(z), SemanticsModifierKt.semantics$default(m879padding3ABfNKs, false, (Function1) rememberedValue, 1, null), null, ComposableLambdaKt.composableLambda(composer, 1776469658, true, new C0453a(onClick)), composer, ((i2 >> 3) & 14) | 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
            return Unit.INSTANCE;
        }
    }
}
