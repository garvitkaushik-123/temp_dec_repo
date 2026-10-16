package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.app.Activity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3451a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class s {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.HideSystemUIKt$HideSystemUI$1$1", f = "HideSystemUI.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6034a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, Activity activity, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = z;
            this.c = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6034a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b) {
                C3451a.a(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Activity activity, int i, Composer composer, int i2) {
        a(activity, composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final void a(final Activity activity, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-726701488);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(activity) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-726701488, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.HideSystemUI (HideSystemUI.kt:9)");
            }
            boolean isWindowFocused = ((WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo())).isWindowFocused();
            Boolean valueOf = Boolean.valueOf(isWindowFocused);
            startRestartGroup.startReplaceableGroup(-1598618285);
            boolean changed = startRestartGroup.changed(isWindowFocused) | startRestartGroup.changed(activity);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new a(isWindowFocused, activity, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return s.a(activity, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
