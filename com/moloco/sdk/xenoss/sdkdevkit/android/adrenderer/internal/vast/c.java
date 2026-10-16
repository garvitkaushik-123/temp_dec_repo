package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* loaded from: classes6.dex */
public final class c {

    public static final class a implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Unit f6058a;

        public a(Unit unit) {
            this.f6058a = unit;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1040652088, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastView.<anonymous>.<anonymous> (VastActivity.kt:231)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a.class, "goNextAdPartOrDismissAd", "goNextAdPartOrDismissAd()V", 0);
        }

        public final void a() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a) this.receiver).y();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, Function2 function2, z zVar, int i, int i2, Composer composer, int i3) {
        a(activity, aVar, function2, zVar, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
    
        if ((r29 & 2) != 0) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final Activity activity, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> function2, final z zVar, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> function22;
        final Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> function23;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1851234025);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(activity) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(aVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 2) == 0) {
                function22 = function2;
                if (startRestartGroup.changed(function22)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                function22 = function2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            function22 = function2;
        }
        if ((i2 & 4) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(zVar) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function23 = function22;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    function22 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(0L, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i) null, (Function2) null, (Function2) null, (Function2) null, (K) null, 1023, (Object) null);
                    i3 &= -897;
                }
                int i5 = i3;
                function23 = function22;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1851234025, i5, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastView (VastActivity.kt:227)");
                }
                startRestartGroup.startReplaceableGroup(1545874070);
                startRestartGroup.startReplaceableGroup(1545872796);
                boolean changed = startRestartGroup.changed(function23) | startRestartGroup.changed(aVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.c$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return c.a(Function2.this, aVar, (Context) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) rememberedValue, null, null, startRestartGroup, 0, 6);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1545874835);
                if (zVar != null) {
                    zVar.a(ComposableLambdaKt.composableLambda(startRestartGroup, 1040652088, true, new a(unit)), startRestartGroup, ((i5 >> 6) & 112) | 6);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1545876759);
                boolean changed2 = startRestartGroup.changed(aVar);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new b(aVar);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                BackHandlerKt.BackHandler(false, (Function0) ((KFunction) rememberedValue2), startRestartGroup, 0, 1);
                s.a(activity, startRestartGroup, i5 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.c$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return c.a(activity, aVar, function23, zVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final View a(Function2 function2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return (View) function2.invoke(ctx, aVar);
    }
}
