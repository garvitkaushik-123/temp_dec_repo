package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import coil.compose.SingletonAsyncImageKt;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final long f6022a = ColorKt.Color$default(71, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 238, 0, 8, null);
    public static final long b = Color.INSTANCE.m4100getWhite0d7_KjU();

    public static final class a implements Function3<RowScope, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6023a;

        public a(String str) {
            this.f6023a = str;
        }

        public final void a(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091822665, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DEC.<anonymous>.<anonymous> (DEC.kt:73)");
            }
            String str = this.f6023a;
            if (str == null) {
                str = "";
            }
            TextKt.m1844TextfLXpl1I(str, null, p.b, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 1, null, null, composer, 196992, 3120, 55258);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            a(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, String str, String str2, String str3, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, str, str2, str3, function0, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final String str, final String str2, String str3, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Modifier.Companion companion;
        String str4;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(267258467);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(str3) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(onClick) ? 16384 : 8192;
        }
        int i5 = i3;
        if ((i5 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            str4 = str3;
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267258467, i5, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DEC (DEC.kt:36)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            Color.Companion companion2 = Color.INSTANCE;
            Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(BackgroundKt.m527backgroundbw27NRU$default(fillMaxSize$default, companion2.m4089getBlack0d7_KjU(), null, 2, null), false, null, null, onClick, 7, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m561clickableXHw0xAI$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, density, companion3.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifier5 = modifier4;
            SingletonAsyncImageKt.m6740AsyncImage3HmZ8SU(str, null, SizeKt.m928size3ABfNKs(companion4, Dp.m6389constructorimpl(128)), null, null, null, null, 0.0f, null, 0, startRestartGroup, ((i5 >> 3) & 14) | 432, 1016);
            Composer composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-707855849);
            if (str2 != null) {
                SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion4, Dp.m6389constructorimpl(12)), composer2, 6);
                companion = companion4;
                TextKt.m1844TextfLXpl1I(str2, null, companion2.m4100getWhite0d7_KjU(), 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 2, null, null, composer2, ((i5 >> 6) & 14) | 196992, 3120, 55258);
                composer2 = composer2;
            } else {
                companion = companion4;
            }
            composer2.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion, Dp.m6389constructorimpl(8)), composer2, 6);
            Composer composer3 = composer2;
            startRestartGroup = composer3;
            str4 = str3;
            ButtonKt.Button(onClick, null, false, null, null, RoundedCornerShapeKt.getCircleShape(), null, ButtonDefaults.INSTANCE.m1568buttonColorsro_MJ88(f6022a, b, 0L, 0L, composer3, (ButtonDefaults.$stable << 12) | 54, 12), null, ComposableLambdaKt.composableLambda(startRestartGroup, 1091822665, true, new a(str4)), startRestartGroup, ((i5 >> 12) & 14) | C.ENCODING_PCM_32BIT, 350);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final String str5 = str4;
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return p.a(Modifier.this, str, str2, str5, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-227963495);
        if (i == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227963495, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DECPreview (DEC.kt:89)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, l.f6015a.a(), startRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return p.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
