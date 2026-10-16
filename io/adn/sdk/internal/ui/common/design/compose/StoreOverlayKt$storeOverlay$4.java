package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.google.android.exoplayer2.C;
import io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4;
import io.adn.sdk.internal.ui.utils.UIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StoreOverlay.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class StoreOverlayKt$storeOverlay$4 implements Function3<BoxScope, Composer, Integer, Unit> {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ long $ctaColor;
    final /* synthetic */ String $ctaText;
    final /* synthetic */ long $ctaTextColor;
    final /* synthetic */ double $delayBeforeDisplay;
    final /* synthetic */ String $description;
    final /* synthetic */ Object $icon;
    final /* synthetic */ boolean $isDismissable;
    final /* synthetic */ String $name;
    final /* synthetic */ Function0<Unit> $onCtaClick;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ PaddingValues $padding;

    StoreOverlayKt$storeOverlay$4(double d, Alignment alignment, PaddingValues paddingValues, boolean z, Function0<Unit> function0, Object obj, long j, long j2, Function0<Unit> function02, String str, String str2, String str3) {
        this.$delayBeforeDisplay = d;
        this.$alignment = alignment;
        this.$padding = paddingValues;
        this.$isDismissable = z;
        this.$onDismiss = function0;
        this.$icon = obj;
        this.$ctaColor = j;
        this.$ctaTextColor = j2;
        this.$onCtaClick = function02;
        this.$name = str;
        this.$description = str2;
        this.$ctaText = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$5$lambda$4(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$7$lambda$6(int i) {
        return i;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
        invoke(boxScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public final void invoke(BoxScope boxScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2008234273, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay.<anonymous> (StoreOverlay.kt:97)");
        }
        composer.startReplaceableGroup(606479617);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceableGroup();
        float m6389constructorimpl = Dp.m6389constructorimpl(68);
        Unit unit = Unit.INSTANCE;
        composer.startReplaceableGroup(606482643);
        boolean changed = composer.changed(this.$delayBeforeDisplay);
        double d = this.$delayBeforeDisplay;
        StoreOverlayKt$storeOverlay$4$1$1 rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new StoreOverlayKt$storeOverlay$4$1$1(d, mutableState, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 6);
        boolean invoke$lambda$1 = invoke$lambda$1(mutableState);
        TweenSpec tween$default = AnimationSpecKt.tween$default(800, 0, null, 6, null);
        composer.startReplaceableGroup(606489061);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = StoreOverlayKt$storeOverlay$4.invoke$lambda$5$lambda$4(((Integer) obj).intValue());
                    return Integer.valueOf(invoke$lambda$5$lambda$4);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        EnterTransition slideInVertically = EnterExitTransitionKt.slideInVertically(tween$default, (Function1) rememberedValue3);
        TweenSpec tween$default2 = AnimationSpecKt.tween$default(500, 0, null, 6, null);
        composer.startReplaceableGroup(606493477);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int invoke$lambda$7$lambda$6;
                    invoke$lambda$7$lambda$6 = StoreOverlayKt$storeOverlay$4.invoke$lambda$7$lambda$6(((Integer) obj).intValue());
                    return Integer.valueOf(invoke$lambda$7$lambda$6);
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        AnimatedVisibilityKt.AnimatedVisibility(invoke$lambda$1, PaddingKt.padding(boxScope.align(Modifier.INSTANCE, this.$alignment), this.$padding), slideInVertically, EnterExitTransitionKt.slideOutVertically(tween$default2, (Function1) rememberedValue4), (String) null, ComposableLambdaKt.composableLambda(composer, -114854985, true, new AnonymousClass4(m6389constructorimpl, this.$isDismissable, this.$onDismiss, mutableState, this.$icon, this.$ctaColor, this.$ctaTextColor, this.$onCtaClick, this.$name, this.$description, this.$ctaText)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* compiled from: StoreOverlay.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4$4, reason: invalid class name */
    static final class AnonymousClass4 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
        final /* synthetic */ float $containerHeight;
        final /* synthetic */ long $ctaColor;
        final /* synthetic */ String $ctaText;
        final /* synthetic */ long $ctaTextColor;
        final /* synthetic */ String $description;
        final /* synthetic */ Object $icon;
        final /* synthetic */ boolean $isDismissable;
        final /* synthetic */ MutableState<Boolean> $isVisible$delegate;
        final /* synthetic */ String $name;
        final /* synthetic */ Function0<Unit> $onCtaClick;
        final /* synthetic */ Function0<Unit> $onDismiss;

        AnonymousClass4(float f, boolean z, Function0<Unit> function0, MutableState<Boolean> mutableState, Object obj, long j, long j2, Function0<Unit> function02, String str, String str2, String str3) {
            this.$containerHeight = f;
            this.$isDismissable = z;
            this.$onDismiss = function0;
            this.$isVisible$delegate = mutableState;
            this.$icon = obj;
            this.$ctaColor = j;
            this.$ctaTextColor = j2;
            this.$onCtaClick = function02;
            this.$name = str;
            this.$description = str2;
            this.$ctaText = str3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
            Modifier.Companion companion;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114854985, i, -1, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay.<anonymous>.<anonymous> (StoreOverlay.kt:119)");
            }
            Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), this.$containerHeight);
            composer.startReplaceableGroup(518603191);
            if (this.$isDismissable) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f = this.$containerHeight;
                composer.startReplaceableGroup(518608475);
                boolean changed = composer.changed(this.$onDismiss);
                final Function0<Unit> function0 = this.$onDismiss;
                final MutableState<Boolean> mutableState = this.$isVisible$delegate;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4$4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$1$lambda$0;
                            invoke$lambda$1$lambda$0 = StoreOverlayKt$storeOverlay$4.AnonymousClass4.invoke$lambda$1$lambda$0(Function0.this, mutableState);
                            return invoke$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                companion = StoreOverlayKt.m9534dragDismissableziNgDLE$default(companion2, f, 0.0f, (Function0) rememberedValue, 2, null);
            } else {
                companion = Modifier.INSTANCE;
            }
            composer.endReplaceableGroup();
            Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(m914height3ABfNKs.then(companion), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(16))), Color.m4062copywmQWz5c$default(Color.INSTANCE.m4095getLightGray0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Object obj = this.$icon;
            long j = this.$ctaColor;
            final long j2 = this.$ctaTextColor;
            Function0<Unit> function02 = this.$onCtaClick;
            String str = this.$name;
            String str2 = this.$description;
            final String str3 = this.$ctaText;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m527backgroundbw27NRU$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            float f2 = 8;
            Modifier m879padding3ABfNKs = PaddingKt.m879padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(f2));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m879padding3ABfNKs);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer);
            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            SingletonAsyncImageKt.m6742AsyncImagegl8XCv8(obj, null, ClipKt.clip(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(52)), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f2))), null, null, null, null, 0.0f, null, 0, false, null, composer, 48, 0, 4088);
            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f2)), composer, 6);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(weight$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer);
            Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2781Text4IGK_g(str == null ? "" : str, (Modifier) null, Color.INSTANCE.m4089getBlack0d7_KjU(), TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3456, 3120, 120818);
            SpacerKt.Spacer(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(5)), composer, 6);
            TextKt.m2781Text4IGK_g(str2 == null ? "" : str2, (Modifier) null, Color.INSTANCE.m4092getDarkGray0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3456, 3120, 120818);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f2)), composer, 6);
            ButtonKt.Button(function02, null, false, RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(17)), ButtonDefaults.INSTANCE.m1923buttonColorsro_MJ88(j, j2, 0L, 0L, composer, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.composableLambda(composer, 70618897, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$4$4$2$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i2 & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70618897, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoreOverlay.kt:189)");
                        }
                        TextKt.m2781Text4IGK_g(str3, (Modifier) null, j2, UIConstants.INSTANCE.m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release(), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 3072, 0, 131058);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composer, C.ENCODING_PCM_32BIT, 486);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function0 function0, MutableState mutableState) {
            StoreOverlayKt$storeOverlay$4.invoke$lambda$2(mutableState, false);
            function0.invoke();
            return Unit.INSTANCE;
        }
    }
}
