package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {

    public static final class a implements Function3<o, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f6019a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.n$a$a, reason: collision with other inner class name */
        public static final class C0518a implements Function3<RowScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f6020a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TextStyle c;

            public C0518a(o oVar, long j, TextStyle textStyle) {
                this.f6020a = oVar;
                this.b = j;
                this.c = textStyle;
            }

            public final void a(RowScope TextButton, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-291791758, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous>.<anonymous> (CountdownButton.kt:84)");
                }
                TextKt.m1844TextfLXpl1I(((o.c) this.f6020a).a(), null, 0L, this.b, null, null, null, 0L, null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, 0, false, 1, null, this.c, composer, 0, 3072, 24054);
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

        public a(Function0<Unit> function0, boolean z, long j, long j2, long j3) {
            this.f6019a = function0;
            this.b = z;
            this.c = j;
            this.d = j2;
            this.e = j3;
        }

        public final void a(o buttonPart, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(buttonPart, "buttonPart");
            if ((i & 6) == 0) {
                i2 = i | (composer.changed(buttonPart) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1264027403, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous> (CountdownButton.kt:56)");
            }
            TextStyle h6 = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH6();
            if (buttonPart instanceof o.a) {
                composer.startReplaceableGroup(1000154410);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof o.b) {
                composer.startReplaceableGroup(1000496526);
                o.b bVar = (o.b) buttonPart;
                r.a(bVar.e(), this.f6019a, null, this.b, bVar.c(), this.c, this.d, bVar.d(), bVar.b(), bVar.a(), composer, 0, 4);
                composer.endReplaceableGroup();
            } else {
                if (!(buttonPart instanceof o.c)) {
                    composer.startReplaceableGroup(-1491758567);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(-1491726713);
                Function0<Unit> function0 = this.f6019a;
                boolean z = this.b;
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                long j = this.c;
                ButtonKt.TextButton(function0, null, z, null, null, null, null, buttonDefaults.m1577textButtonColorsRGew2ao(0L, j, j, composer, ButtonDefaults.$stable << 9, 1), null, ComposableLambdaKt.composableLambda(composer, -291791758, true, new C0518a(buttonPart, this.e, h6)), composer, C.ENCODING_PCM_32BIT, 378);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(o oVar, Composer composer, Integer num) {
            a(oVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(o oVar, Modifier modifier, Function0 function0, boolean z, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar, int i, int i2, Composer composer, int i3) {
        a(oVar, modifier, function0, z, j, j2, j3, iVar, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final o countdownButtonPart, Modifier modifier, final Function0<Unit> onClick, final boolean z, long j, long j2, long j3, final com.moloco.sdk.internal.ortb.model.i iVar, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j4;
        int i4;
        long j5;
        int i5;
        Modifier modifier3;
        long j6;
        long j7;
        long d;
        Composer composer2;
        final Modifier modifier4;
        final long j8;
        final long j9;
        final long j10;
        o.a aVar;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(countdownButtonPart, "countdownButtonPart");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-913983839);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(countdownButtonPart) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(onClick) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j;
                        if (startRestartGroup.changed(j4)) {
                            i6 = 16384;
                            i3 |= i6;
                        }
                    } else {
                        j4 = j;
                    }
                    i6 = 8192;
                    i3 |= i6;
                } else {
                    j4 = j;
                }
                i4 = i2 & 32;
                if (i4 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    j5 = j2;
                    i3 |= startRestartGroup.changed(j5) ? 131072 : 65536;
                    i5 = i2 & 64;
                    if (i5 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(j3) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(iVar) ? 8388608 : 4194304;
                    }
                    if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, MaterialTheme.$stable).m1603getPrimary0d7_KjU();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                j5 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b();
                            }
                            if (i5 != 0) {
                                long j11 = j5;
                                modifier3 = modifier2;
                                j6 = j4;
                                j7 = j11;
                                d = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d();
                                int i8 = i3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-913983839, i8, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton (CountdownButton.kt:36)");
                                }
                                Modifier m929size6HolHcs = SizeKt.m929size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7);
                                Alignment topEnd = Alignment.INSTANCE.getTopEnd();
                                startRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topEnd, false, startRestartGroup, 6);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                long j12 = j6;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m929size6HolHcs);
                                long j13 = j7;
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
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, density, companion.getSetDensity());
                                Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                                Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                                startRestartGroup.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                startRestartGroup.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                startRestartGroup.startReplaceableGroup(523922004);
                                if ((countdownButtonPart instanceof o.a) && iVar != null) {
                                    aVar = (o.a) countdownButtonPart;
                                    if (aVar.b()) {
                                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(iVar, aVar.c(), aVar.a(), startRestartGroup, (i8 >> 21) & 14);
                                    }
                                }
                                startRestartGroup.endReplaceableGroup();
                                long j14 = d;
                                composer2 = startRestartGroup;
                                Modifier modifier5 = modifier3;
                                CrossfadeKt.Crossfade(countdownButtonPart, modifier5, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1264027403, true, new a(onClick, z, j12, j13, d)), composer2, (i8 & 14) | 3072 | (i8 & 112), 4);
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier5;
                                j8 = j12;
                                j9 = j13;
                                j10 = j14;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        long j15 = j5;
                        modifier3 = modifier2;
                        j6 = j4;
                        j7 = j15;
                        d = j3;
                        int i82 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Modifier m929size6HolHcs2 = SizeKt.m929size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7);
                        Alignment topEnd2 = Alignment.INSTANCE.getTopEnd();
                        startRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(topEnd2, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        long j122 = j6;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m929size6HolHcs2);
                        long j132 = j7;
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        startRestartGroup.disableReusing();
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, density2, companion2.getSetDensity());
                        Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                        Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                        startRestartGroup.enableReusing();
                        materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        startRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceableGroup(523922004);
                        if (countdownButtonPart instanceof o.a) {
                            aVar = (o.a) countdownButtonPart;
                            if (aVar.b()) {
                            }
                        }
                        startRestartGroup.endReplaceableGroup();
                        long j142 = d;
                        composer2 = startRestartGroup;
                        Modifier modifier52 = modifier3;
                        CrossfadeKt.Crossfade(countdownButtonPart, modifier52, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1264027403, true, new a(onClick, z, j122, j132, d)), composer2, (i82 & 14) | 3072 | (i82 & 112), 4);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier52;
                        j8 = j122;
                        j9 = j132;
                        j10 = j142;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        j8 = j4;
                        composer2 = startRestartGroup;
                        j9 = j5;
                        j10 = j3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.n$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return n.a(o.this, modifier4, onClick, z, j8, j9, j10, iVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                j5 = j2;
                i5 = i2 & 64;
                if (i5 == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                long j152 = j5;
                modifier3 = modifier2;
                j6 = j4;
                j7 = j152;
                d = j3;
                int i822 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m929size6HolHcs22 = SizeKt.m929size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7);
                Alignment topEnd22 = Alignment.INSTANCE.getTopEnd();
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(topEnd22, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                long j1222 = j6;
                Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(m929size6HolHcs22);
                long j1322 = j7;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                startRestartGroup.disableReusing();
                Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl22, rememberBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl22, density22, companion22.getSetDensity());
                Updater.m3600setimpl(m3593constructorimpl22, layoutDirection22, companion22.getSetLayoutDirection());
                Updater.m3600setimpl(m3593constructorimpl22, viewConfiguration22, companion22.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(523922004);
                if (countdownButtonPart instanceof o.a) {
                }
                startRestartGroup.endReplaceableGroup();
                long j1422 = d;
                composer2 = startRestartGroup;
                Modifier modifier522 = modifier3;
                CrossfadeKt.Crossfade(countdownButtonPart, modifier522, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1264027403, true, new a(onClick, z, j1222, j1322, d)), composer2, (i822 & 14) | 3072 | (i822 & 112), 4);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier522;
                j8 = j1222;
                j9 = j1322;
                j10 = j1422;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i & 24576) == 0) {
            }
            i4 = i2 & 32;
            if (i4 != 0) {
            }
            j5 = j2;
            i5 = i2 & 64;
            if (i5 == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            long j1522 = j5;
            modifier3 = modifier2;
            j6 = j4;
            j7 = j1522;
            d = j3;
            int i8222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m929size6HolHcs222 = SizeKt.m929size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7);
            Alignment topEnd222 = Alignment.INSTANCE.getTopEnd();
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(topEnd222, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            long j12222 = j6;
            Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf222 = LayoutKt.materializerOf(m929size6HolHcs222);
            long j13222 = j7;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl222 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl222, rememberBoxMeasurePolicy222, companion222.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl222, density222, companion222.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl222, layoutDirection222, companion222.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl222, viewConfiguration222, companion222.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(523922004);
            if (countdownButtonPart instanceof o.a) {
            }
            startRestartGroup.endReplaceableGroup();
            long j14222 = d;
            composer2 = startRestartGroup;
            Modifier modifier5222 = modifier3;
            CrossfadeKt.Crossfade(countdownButtonPart, modifier5222, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1264027403, true, new a(onClick, z, j12222, j13222, d)), composer2, (i8222 & 14) | 3072 | (i8222 & 112), 4);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier5222;
            j8 = j12222;
            j9 = j13222;
            j10 = j14222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        j5 = j2;
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        long j15222 = j5;
        modifier3 = modifier2;
        j6 = j4;
        j7 = j15222;
        d = j3;
        int i82222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m929size6HolHcs2222 = SizeKt.m929size6HolHcs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7);
        Alignment topEnd2222 = Alignment.INSTANCE.getTopEnd();
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(topEnd2222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density2222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        long j122222 = j6;
        Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2222 = LayoutKt.materializerOf(m929size6HolHcs2222);
        long j132222 = j7;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        startRestartGroup.disableReusing();
        Composer m3593constructorimpl2222 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl2222, rememberBoxMeasurePolicy2222, companion2222.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl2222, density2222, companion2222.getSetDensity());
        Updater.m3600setimpl(m3593constructorimpl2222, layoutDirection2222, companion2222.getSetLayoutDirection());
        Updater.m3600setimpl(m3593constructorimpl2222, viewConfiguration2222, companion2222.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(523922004);
        if (countdownButtonPart instanceof o.a) {
        }
        startRestartGroup.endReplaceableGroup();
        long j142222 = d;
        composer2 = startRestartGroup;
        Modifier modifier52222 = modifier3;
        CrossfadeKt.Crossfade(countdownButtonPart, modifier52222, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1264027403, true, new a(onClick, z, j122222, j132222, d)), composer2, (i82222 & 14) | 3072 | (i82222 & 112), 4);
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier52222;
        j8 = j122222;
        j9 = j132222;
        j10 = j142222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
