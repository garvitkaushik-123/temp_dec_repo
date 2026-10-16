package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AlertDialog.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a¦\u0001\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"DialogMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDialogMaxWidth", "()F", "F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    private static final float DialogMinWidth = Dp.m6389constructorimpl(280);
    private static final float DialogMaxWidth = Dp.m6389constructorimpl(560);

    /* JADX WARN: Removed duplicated region for block: B:102:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e5  */
    /* renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1877AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final long j, final float f, final long j2, final long j3, final long j4, final long j5, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j6;
        long j7;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1522575799);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)53@1918L2445:AlertDialog.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
                function25 = function22;
            } else {
                function25 = function22;
                if ((i & 384) == 0) {
                    i4 |= startRestartGroup.changedInstance(function25) ? 256 : 128;
                }
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                function26 = function23;
                i4 |= startRestartGroup.changedInstance(function26) ? 2048 : 1024;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    function27 = function24;
                    i4 |= startRestartGroup.changedInstance(function27) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(shape) ? 131072 : 65536;
                        if ((i3 & 64) != 0) {
                            i4 |= 1572864;
                            j6 = j;
                        } else {
                            j6 = j;
                            if ((i & 1572864) == 0) {
                                i4 |= startRestartGroup.changed(j6) ? 1048576 : 524288;
                            }
                        }
                        if ((i3 & 128) != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                            if ((i3 & 256) == 0) {
                                i4 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i4 |= startRestartGroup.changed(j2) ? 67108864 : 33554432;
                            }
                            if ((i3 & 512) == 0) {
                                i4 |= C.ENCODING_PCM_32BIT;
                            } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                                i4 |= startRestartGroup.changed(j3) ? 536870912 : 268435456;
                            }
                            if ((i3 & 1024) == 0) {
                                i5 = i2 | 6;
                                j7 = j4;
                            } else {
                                j7 = j4;
                                if ((i2 & 6) == 0) {
                                    i5 = i2 | (startRestartGroup.changed(j7) ? 4 : 2);
                                } else {
                                    i5 = i2;
                                }
                            }
                            if ((i3 & 2048) == 0) {
                                i5 |= 48;
                            } else if ((i2 & 48) == 0) {
                                i5 |= startRestartGroup.changed(j5) ? 32 : 16;
                                if ((i4 & 306783379) == 306783378 || (i5 & 19) != 18 || !startRestartGroup.getSkipping()) {
                                    Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1522575799, i4, i5, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:52)");
                                    }
                                    final long j8 = j7;
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                    int i7 = i4 >> 12;
                                    Modifier modifier4 = companion;
                                    SurfaceKt.m2633SurfaceT9BRK9s(modifier4, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i8) {
                                            PaddingValues paddingValues;
                                            String str;
                                            ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                                            if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                                                }
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                paddingValues = AlertDialogKt.DialogPadding;
                                                Modifier padding = PaddingKt.padding(companion2, paddingValues);
                                                final Function2<Composer, Integer, Unit> function210 = function25;
                                                final Function2<Composer, Integer, Unit> function211 = function28;
                                                final Function2<Composer, Integer, Unit> function212 = function29;
                                                long j9 = j3;
                                                long j10 = j8;
                                                long j11 = j5;
                                                long j12 = j2;
                                                Function2<Composer, Integer, Unit> function213 = function2;
                                                composer2.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                                composer2.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                if (!(composer2.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer2.startReusableNode();
                                                if (composer2.getInserting()) {
                                                    composer2.createNode(constructor);
                                                } else {
                                                    composer2.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                composer2.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                                                composer2.startReplaceableGroup(76440827);
                                                ComposerKt.sourceInformation(composer2, "*63@2183L339");
                                                if (function210 != null) {
                                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i9) {
                                                            PaddingValues paddingValues2;
                                                            ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                                }
                                                                ColumnScope columnScope = ColumnScope.this;
                                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                paddingValues2 = AlertDialogKt.IconPadding;
                                                                Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                                                Function2<Composer, Integer, Unit> function214 = function210;
                                                                composer3.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                                composer3.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer3.startReusableNode();
                                                                if (composer3.getInserting()) {
                                                                    composer3.createNode(constructor2);
                                                                } else {
                                                                    composer3.useNode();
                                                                }
                                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                }
                                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                                composer3.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                                                function214.invoke(composer3, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                composer3.endReplaceableGroup();
                                                                composer3.endNode();
                                                                composer3.endReplaceableGroup();
                                                                composer3.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer3.skipToGroupEnd();
                                                        }
                                                    }), composer2, ProvidedValue.$stable | 48);
                                                }
                                                composer2.endReplaceableGroup();
                                                composer2.startReplaceableGroup(76441222);
                                                ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                                                if (function211 == null) {
                                                    str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                                } else {
                                                    str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i9) {
                                                            PaddingValues paddingValues2;
                                                            Alignment.Horizontal centerHorizontally;
                                                            ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                                }
                                                                ColumnScope columnScope = ColumnScope.this;
                                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                paddingValues2 = AlertDialogKt.TitlePadding;
                                                                Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                                                if (function210 == null) {
                                                                    centerHorizontally = Alignment.INSTANCE.getStart();
                                                                } else {
                                                                    centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                                }
                                                                Modifier align = columnScope.align(padding2, centerHorizontally);
                                                                Function2<Composer, Integer, Unit> function214 = function211;
                                                                composer3.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                                composer3.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer3.startReusableNode();
                                                                if (composer3.getInserting()) {
                                                                    composer3.createNode(constructor2);
                                                                } else {
                                                                    composer3.useNode();
                                                                }
                                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                }
                                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                                composer3.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                                                function214.invoke(composer3, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                composer3.endReplaceableGroup();
                                                                composer3.endNode();
                                                                composer3.endReplaceableGroup();
                                                                composer3.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer3.skipToGroupEnd();
                                                        }
                                                    }), composer2, 384);
                                                }
                                                composer2.endReplaceableGroup();
                                                composer2.startReplaceableGroup(76442054);
                                                ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                                                if (function212 != null) {
                                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i9) {
                                                            PaddingValues paddingValues2;
                                                            ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                                                }
                                                                ColumnScope columnScope = ColumnScope.this;
                                                                Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                                                paddingValues2 = AlertDialogKt.TextPadding;
                                                                Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                                                Function2<Composer, Integer, Unit> function214 = function212;
                                                                composer3.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                                composer3.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer3.startReusableNode();
                                                                if (composer3.getInserting()) {
                                                                    composer3.createNode(constructor2);
                                                                } else {
                                                                    composer3.useNode();
                                                                }
                                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                }
                                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                                composer3.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                                                function214.invoke(composer3, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                composer3.endReplaceableGroup();
                                                                composer3.endNode();
                                                                composer3.endReplaceableGroup();
                                                                composer3.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer3.skipToGroupEnd();
                                                        }
                                                    }), composer2, 384);
                                                }
                                                composer2.endReplaceableGroup();
                                                Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                                composer2.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                                composer2.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer2, str);
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                if (!(composer2.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer2.startReusableNode();
                                                if (composer2.getInserting()) {
                                                    composer2.createNode(constructor2);
                                                } else {
                                                    composer2.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                composer2.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                                                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceableGroup();
                                                composer2.endNode();
                                                composer2.endReplaceableGroup();
                                                composer2.endReplaceableGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceableGroup();
                                                composer2.endNode();
                                                composer2.endReplaceableGroup();
                                                composer2.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i7 & 112) | (i7 & 896) | ((i4 >> 9) & 57344), 104);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier2;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i8) {
                                            AlertDialogKt.m1877AlertDialogContent4hvqGtA(function2, modifier3, function22, function23, function24, shape, j, f, j2, j3, j4, j5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i4 & 306783379) == 306783378) {
                            }
                            if (i6 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final long j82 = j7;
                            final Function2<? super Composer, ? super Integer, Unit> function282 = function26;
                            final Function2<? super Composer, ? super Integer, Unit> function292 = function27;
                            int i72 = i4 >> 12;
                            Modifier modifier42 = companion;
                            SurfaceKt.m2633SurfaceT9BRK9s(modifier42, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i8) {
                                    PaddingValues paddingValues;
                                    String str;
                                    ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                                    if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                                        }
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        paddingValues = AlertDialogKt.DialogPadding;
                                        Modifier padding = PaddingKt.padding(companion2, paddingValues);
                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                        final Function2<? super Composer, ? super Integer, Unit> function211 = function282;
                                        final Function2<? super Composer, ? super Integer, Unit> function212 = function292;
                                        long j9 = j3;
                                        long j10 = j82;
                                        long j11 = j5;
                                        long j12 = j2;
                                        Function2<Composer, Integer, Unit> function213 = function2;
                                        composer2.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                                        composer2.startReplaceableGroup(76440827);
                                        ComposerKt.sourceInformation(composer2, "*63@2183L339");
                                        if (function210 != null) {
                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i9) {
                                                    PaddingValues paddingValues2;
                                                    ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                        }
                                                        ColumnScope columnScope = ColumnScope.this;
                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                        paddingValues2 = AlertDialogKt.IconPadding;
                                                        Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                                        Function2<Composer, Integer, Unit> function214 = function210;
                                                        composer3.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                        composer3.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                        composer3.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                                        function214.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endReplaceableGroup();
                                                        composer3.endNode();
                                                        composer3.endReplaceableGroup();
                                                        composer3.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }), composer2, ProvidedValue.$stable | 48);
                                        }
                                        composer2.endReplaceableGroup();
                                        composer2.startReplaceableGroup(76441222);
                                        ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                                        if (function211 == null) {
                                            str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                        } else {
                                            str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i9) {
                                                    PaddingValues paddingValues2;
                                                    Alignment.Horizontal centerHorizontally;
                                                    ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                        }
                                                        ColumnScope columnScope = ColumnScope.this;
                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                        paddingValues2 = AlertDialogKt.TitlePadding;
                                                        Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                                        if (function210 == null) {
                                                            centerHorizontally = Alignment.INSTANCE.getStart();
                                                        } else {
                                                            centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                        }
                                                        Modifier align = columnScope.align(padding2, centerHorizontally);
                                                        Function2<Composer, Integer, Unit> function214 = function211;
                                                        composer3.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                        composer3.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                        composer3.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                                        function214.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endReplaceableGroup();
                                                        composer3.endNode();
                                                        composer3.endReplaceableGroup();
                                                        composer3.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }), composer2, 384);
                                        }
                                        composer2.endReplaceableGroup();
                                        composer2.startReplaceableGroup(76442054);
                                        ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                                        if (function212 != null) {
                                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i9) {
                                                    PaddingValues paddingValues2;
                                                    ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                                        }
                                                        ColumnScope columnScope = ColumnScope.this;
                                                        Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                                        paddingValues2 = AlertDialogKt.TextPadding;
                                                        Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                                        Function2<Composer, Integer, Unit> function214 = function212;
                                                        composer3.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                        composer3.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                        composer3.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                                        function214.invoke(composer3, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endReplaceableGroup();
                                                        composer3.endNode();
                                                        composer3.endReplaceableGroup();
                                                        composer3.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }), composer2, 384);
                                        }
                                        composer2.endReplaceableGroup();
                                        Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, str);
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor2);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i72 & 112) | (i72 & 896) | ((i4 >> 9) & 57344), 104);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i3 & 256) == 0) {
                        }
                        if ((i3 & 512) == 0) {
                        }
                        if ((i3 & 1024) == 0) {
                        }
                        if ((i3 & 2048) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        if (i6 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final long j822 = j7;
                        final Function2<? super Composer, ? super Integer, Unit> function2822 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function2922 = function27;
                        int i722 = i4 >> 12;
                        Modifier modifier422 = companion;
                        SurfaceKt.m2633SurfaceT9BRK9s(modifier422, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                PaddingValues paddingValues;
                                String str;
                                ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    paddingValues = AlertDialogKt.DialogPadding;
                                    Modifier padding = PaddingKt.padding(companion2, paddingValues);
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function2822;
                                    final Function2<? super Composer, ? super Integer, Unit> function212 = function2922;
                                    long j9 = j3;
                                    long j10 = j822;
                                    long j11 = j5;
                                    long j12 = j2;
                                    Function2<Composer, Integer, Unit> function213 = function2;
                                    composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                                    composer2.startReplaceableGroup(76440827);
                                    ComposerKt.sourceInformation(composer2, "*63@2183L339");
                                    if (function210 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i9) {
                                                PaddingValues paddingValues2;
                                                ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                    }
                                                    ColumnScope columnScope = ColumnScope.this;
                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                    paddingValues2 = AlertDialogKt.IconPadding;
                                                    Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                                    Function2<Composer, Integer, Unit> function214 = function210;
                                                    composer3.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor2);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                                    function214.invoke(composer3, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, ProvidedValue.$stable | 48);
                                    }
                                    composer2.endReplaceableGroup();
                                    composer2.startReplaceableGroup(76441222);
                                    ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                                    if (function211 == null) {
                                        str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                    } else {
                                        str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i9) {
                                                PaddingValues paddingValues2;
                                                Alignment.Horizontal centerHorizontally;
                                                ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                    }
                                                    ColumnScope columnScope = ColumnScope.this;
                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                    paddingValues2 = AlertDialogKt.TitlePadding;
                                                    Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                                    if (function210 == null) {
                                                        centerHorizontally = Alignment.INSTANCE.getStart();
                                                    } else {
                                                        centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                    }
                                                    Modifier align = columnScope.align(padding2, centerHorizontally);
                                                    Function2<Composer, Integer, Unit> function214 = function211;
                                                    composer3.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor2);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                                    function214.invoke(composer3, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, 384);
                                    }
                                    composer2.endReplaceableGroup();
                                    composer2.startReplaceableGroup(76442054);
                                    ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                                    if (function212 != null) {
                                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i9) {
                                                PaddingValues paddingValues2;
                                                ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                                    }
                                                    ColumnScope columnScope = ColumnScope.this;
                                                    Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                                    paddingValues2 = AlertDialogKt.TextPadding;
                                                    Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                                    Function2<Composer, Integer, Unit> function214 = function212;
                                                    composer3.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor2);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                                    function214.invoke(composer3, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, 384);
                                    }
                                    composer2.endReplaceableGroup();
                                    Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, str);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor2);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i722 & 112) | (i722 & 896) | ((i4 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier422;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) == 0) {
                    }
                    if ((i3 & 512) == 0) {
                    }
                    if ((i3 & 1024) == 0) {
                    }
                    if ((i3 & 2048) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final long j8222 = j7;
                    final Function2<? super Composer, ? super Integer, Unit> function28222 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function29222 = function27;
                    int i7222 = i4 >> 12;
                    Modifier modifier4222 = companion;
                    SurfaceKt.m2633SurfaceT9BRK9s(modifier4222, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            PaddingValues paddingValues;
                            String str;
                            ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                            if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                                }
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                paddingValues = AlertDialogKt.DialogPadding;
                                Modifier padding = PaddingKt.padding(companion2, paddingValues);
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function28222;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function29222;
                                long j9 = j3;
                                long j10 = j8222;
                                long j11 = j5;
                                long j12 = j2;
                                Function2<Composer, Integer, Unit> function213 = function2;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                                composer2.startReplaceableGroup(76440827);
                                ComposerKt.sourceInformation(composer2, "*63@2183L339");
                                if (function210 != null) {
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i9) {
                                            PaddingValues paddingValues2;
                                            ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                }
                                                ColumnScope columnScope = ColumnScope.this;
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                paddingValues2 = AlertDialogKt.IconPadding;
                                                Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                                Function2<Composer, Integer, Unit> function214 = function210;
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                                function214.invoke(composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, ProvidedValue.$stable | 48);
                                }
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(76441222);
                                ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                                if (function211 == null) {
                                    str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                } else {
                                    str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i9) {
                                            PaddingValues paddingValues2;
                                            Alignment.Horizontal centerHorizontally;
                                            ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                                }
                                                ColumnScope columnScope = ColumnScope.this;
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                paddingValues2 = AlertDialogKt.TitlePadding;
                                                Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                                if (function210 == null) {
                                                    centerHorizontally = Alignment.INSTANCE.getStart();
                                                } else {
                                                    centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                }
                                                Modifier align = columnScope.align(padding2, centerHorizontally);
                                                Function2<Composer, Integer, Unit> function214 = function211;
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                                function214.invoke(composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 384);
                                }
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(76442054);
                                ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                                if (function212 != null) {
                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i9) {
                                            PaddingValues paddingValues2;
                                            ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                                }
                                                ColumnScope columnScope = ColumnScope.this;
                                                Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                                paddingValues2 = AlertDialogKt.TextPadding;
                                                Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                                Function2<Composer, Integer, Unit> function214 = function212;
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                                function214.invoke(composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, 384);
                                }
                                composer2.endReplaceableGroup();
                                Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, str);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i7222 & 112) | (i7222 & 896) | ((i4 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function27 = function24;
                if ((i3 & 32) == 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final long j82222 = j7;
                final Function2<? super Composer, ? super Integer, Unit> function282222 = function26;
                final Function2<? super Composer, ? super Integer, Unit> function292222 = function27;
                int i72222 = i4 >> 12;
                Modifier modifier42222 = companion;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier42222, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        PaddingValues paddingValues;
                        String str;
                        ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                        if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                            }
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            paddingValues = AlertDialogKt.DialogPadding;
                            Modifier padding = PaddingKt.padding(companion2, paddingValues);
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function282222;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function292222;
                            long j9 = j3;
                            long j10 = j82222;
                            long j11 = j5;
                            long j12 = j2;
                            Function2<Composer, Integer, Unit> function213 = function2;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                            composer2.startReplaceableGroup(76440827);
                            ComposerKt.sourceInformation(composer2, "*63@2183L339");
                            if (function210 != null) {
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        PaddingValues paddingValues2;
                                        ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                            }
                                            ColumnScope columnScope = ColumnScope.this;
                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                            paddingValues2 = AlertDialogKt.IconPadding;
                                            Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                            Function2<Composer, Integer, Unit> function214 = function210;
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                            function214.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, ProvidedValue.$stable | 48);
                            }
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(76441222);
                            ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                            if (function211 == null) {
                                str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                            } else {
                                str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        PaddingValues paddingValues2;
                                        Alignment.Horizontal centerHorizontally;
                                        ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                            }
                                            ColumnScope columnScope = ColumnScope.this;
                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                            paddingValues2 = AlertDialogKt.TitlePadding;
                                            Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                            if (function210 == null) {
                                                centerHorizontally = Alignment.INSTANCE.getStart();
                                            } else {
                                                centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                            }
                                            Modifier align = columnScope.align(padding2, centerHorizontally);
                                            Function2<Composer, Integer, Unit> function214 = function211;
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                            function214.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 384);
                            }
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(76442054);
                            ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                            if (function212 != null) {
                                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        PaddingValues paddingValues2;
                                        ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                            }
                                            ColumnScope columnScope = ColumnScope.this;
                                            Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                            paddingValues2 = AlertDialogKt.TextPadding;
                                            Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                            Function2<Composer, Integer, Unit> function214 = function212;
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                            function214.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 384);
                            }
                            composer2.endReplaceableGroup();
                            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, str);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i72222 & 112) | (i72222 & 896) | ((i4 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function26 = function23;
            if ((i3 & 16) != 0) {
            }
            function27 = function24;
            if ((i3 & 32) == 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final long j822222 = j7;
            final Function2<? super Composer, ? super Integer, Unit> function2822222 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function2922222 = function27;
            int i722222 = i4 >> 12;
            Modifier modifier422222 = companion;
            SurfaceKt.m2633SurfaceT9BRK9s(modifier422222, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    PaddingValues paddingValues;
                    String str;
                    ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                    if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                        }
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        paddingValues = AlertDialogKt.DialogPadding;
                        Modifier padding = PaddingKt.padding(companion2, paddingValues);
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function2822222;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function2922222;
                        long j9 = j3;
                        long j10 = j822222;
                        long j11 = j5;
                        long j12 = j2;
                        Function2<Composer, Integer, Unit> function213 = function2;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                        composer2.startReplaceableGroup(76440827);
                        ComposerKt.sourceInformation(composer2, "*63@2183L339");
                        if (function210 != null) {
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i9) {
                                    PaddingValues paddingValues2;
                                    ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                        }
                                        ColumnScope columnScope = ColumnScope.this;
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        paddingValues2 = AlertDialogKt.IconPadding;
                                        Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                        Function2<Composer, Integer, Unit> function214 = function210;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                        function214.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ProvidedValue.$stable | 48);
                        }
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(76441222);
                        ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                        if (function211 == null) {
                            str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                        } else {
                            str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i9) {
                                    PaddingValues paddingValues2;
                                    Alignment.Horizontal centerHorizontally;
                                    ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                        }
                                        ColumnScope columnScope = ColumnScope.this;
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        paddingValues2 = AlertDialogKt.TitlePadding;
                                        Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                        if (function210 == null) {
                                            centerHorizontally = Alignment.INSTANCE.getStart();
                                        } else {
                                            centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        }
                                        Modifier align = columnScope.align(padding2, centerHorizontally);
                                        Function2<Composer, Integer, Unit> function214 = function211;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                        function214.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 384);
                        }
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(76442054);
                        ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                        if (function212 != null) {
                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i9) {
                                    PaddingValues paddingValues2;
                                    ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                        }
                                        ColumnScope columnScope = ColumnScope.this;
                                        Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                        paddingValues2 = AlertDialogKt.TextPadding;
                                        Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                        Function2<Composer, Integer, Unit> function214 = function212;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                        function214.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 384);
                        }
                        composer2.endReplaceableGroup();
                        Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, str);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i722222 & 112) | (i722222 & 896) | ((i4 >> 9) & 57344), 104);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        function26 = function23;
        if ((i3 & 16) != 0) {
        }
        function27 = function24;
        if ((i3 & 32) == 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j8222222 = j7;
        final Function2<? super Composer, ? super Integer, Unit> function28222222 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function29222222 = function27;
        int i7222222 = i4 >> 12;
        Modifier modifier4222222 = companion;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier4222222, shape, j6, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                PaddingValues paddingValues;
                String str;
                ComposerKt.sourceInformation(composer2, "C59@2068L2289:AlertDialog.kt#uh7d8r");
                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2126308228, i8, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:59)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    paddingValues = AlertDialogKt.DialogPadding;
                    Modifier padding = PaddingKt.padding(companion2, paddingValues);
                    final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                    final Function2<? super Composer, ? super Integer, Unit> function211 = function28222222;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function29222222;
                    long j9 = j3;
                    long j10 = j8222222;
                    long j11 = j5;
                    long j12 = j2;
                    Function2<Composer, Integer, Unit> function213 = function2;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    final ColumnScope columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 76440821, "C108@3982L365:AlertDialog.kt#uh7d8r");
                    composer2.startReplaceableGroup(76440827);
                    ComposerKt.sourceInformation(composer2, "*63@2183L339");
                    if (function210 != null) {
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j9)), ComposableLambdaKt.composableLambda(composer2, 934657765, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                PaddingValues paddingValues2;
                                ComposerKt.sourceInformation(composer3, "C64@2275L229:AlertDialog.kt#uh7d8r");
                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(934657765, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                    }
                                    ColumnScope columnScope = ColumnScope.this;
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    paddingValues2 = AlertDialogKt.IconPadding;
                                    Modifier align = columnScope.align(PaddingKt.padding(companion3, paddingValues2), Alignment.INSTANCE.getCenterHorizontally());
                                    Function2<Composer, Integer, Unit> function214 = function210;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 691155737, "C69@2476L6:AlertDialog.kt#uh7d8r");
                                    function214.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, ProvidedValue.$stable | 48);
                    }
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(76441222);
                    ComposerKt.sourceInformation(composer2, "*76@2708L10,74@2578L777");
                    if (function211 == null) {
                        str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                    } else {
                        str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j10, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getHeadlineFont()), ComposableLambdaKt.composableLambda(composer2, 434448772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                PaddingValues paddingValues2;
                                Alignment.Horizontal centerHorizontally;
                                ComposerKt.sourceInformation(composer3, "C77@2779L558:AlertDialog.kt#uh7d8r");
                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(434448772, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:77)");
                                    }
                                    ColumnScope columnScope = ColumnScope.this;
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    paddingValues2 = AlertDialogKt.TitlePadding;
                                    Modifier padding2 = PaddingKt.padding(companion3, paddingValues2);
                                    if (function210 == null) {
                                        centerHorizontally = Alignment.INSTANCE.getStart();
                                    } else {
                                        centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    }
                                    Modifier align = columnScope.align(padding2, centerHorizontally);
                                    Function2<Composer, Integer, Unit> function214 = function211;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 691156569, "C89@3308L7:AlertDialog.kt#uh7d8r");
                                    function214.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 384);
                    }
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(76442054);
                    ComposerKt.sourceInformation(composer2, "*94@3440L10,95@3510L445");
                    if (function212 != null) {
                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getSupportingTextFont()), ComposableLambdaKt.composableLambda(composer2, -796843771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                PaddingValues paddingValues2;
                                ComposerKt.sourceInformation(composer3, "C98@3658L279:AlertDialog.kt#uh7d8r");
                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-796843771, i9, -1, "androidx.compose.material3.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:98)");
                                    }
                                    ColumnScope columnScope = ColumnScope.this;
                                    Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
                                    paddingValues2 = AlertDialogKt.TextPadding;
                                    Modifier align = columnScope.align(PaddingKt.padding(weight, paddingValues2), Alignment.INSTANCE.getStart());
                                    Function2<Composer, Integer, Unit> function214 = function212;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 691157170, "C104@3909L6:AlertDialog.kt#uh7d8r");
                                    function214.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 384);
                    }
                    composer2.endReplaceableGroup();
                    Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, str);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 24964985, "C110@4096L10,111@4167L166:AlertDialog.kt#uh7d8r");
                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j12, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), function213, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ((i4 >> 3) & 14) | 12582912 | (i7222222 & 112) | (i7222222 & 896) | ((i4 >> 9) & 57344), 104);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1878AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)130@4637L3306,130@4621L3322:AlertDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:129)");
            }
            startRestartGroup.startReplaceableGroup(-1133133582);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AlertDialog.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int i3;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        final ArrayList arrayList3 = new ArrayList();
                        Ref.IntRef intRef = new Ref.IntRef();
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        ArrayList arrayList4 = new ArrayList();
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        Ref.IntRef intRef4 = new Ref.IntRef();
                        float f3 = f;
                        float f4 = f2;
                        int size = list.size();
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = size;
                            ArrayList arrayList5 = arrayList;
                            Placeable mo5333measureBRTryo0 = list.get(i4).mo5333measureBRTryo0(j);
                            Ref.IntRef intRef5 = intRef3;
                            intRef3 = intRef5;
                            if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef5, measureScope, f3, j, mo5333measureBRTryo0)) {
                                i3 = i4;
                                arrayList = arrayList5;
                            } else {
                                i3 = i4;
                                arrayList = arrayList5;
                                measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f4, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                            }
                            if (!arrayList4.isEmpty()) {
                                intRef3.element += measureScope.mo624roundToPx0680j_4(f3);
                            }
                            arrayList4.add(mo5333measureBRTryo0);
                            intRef3.element += mo5333measureBRTryo0.getWidth();
                            intRef4.element = Math.max(intRef4.element, mo5333measureBRTryo0.getHeight());
                            i4 = i3 + 1;
                            size = i5;
                        }
                        if (!arrayList4.isEmpty()) {
                            measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f2, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                        }
                        final int max = Math.max(intRef.element, Constraints.m6347getMinWidthimpl(j));
                        int max2 = Math.max(intRef2.element, Constraints.m6346getMinHeightimpl(j));
                        final ArrayList arrayList6 = arrayList;
                        final float f5 = f;
                        return MeasureScope.layout$default(measureScope, max, max2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                List<List<Placeable>> list2 = arrayList6;
                                MeasureScope measureScope2 = measureScope;
                                float f6 = f5;
                                int i6 = max;
                                List<Integer> list3 = arrayList3;
                                int size2 = list2.size();
                                for (int i7 = 0; i7 < size2; i7++) {
                                    List<Placeable> list4 = list2.get(i7);
                                    int size3 = list4.size();
                                    int[] iArr = new int[size3];
                                    int i8 = 0;
                                    while (i8 < size3) {
                                        iArr[i8] = list4.get(i8).getWidth() + (i8 < CollectionsKt.getLastIndex(list4) ? measureScope2.mo624roundToPx0680j_4(f6) : 0);
                                        i8++;
                                    }
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    int[] iArr2 = new int[size3];
                                    for (int i9 = 0; i9 < size3; i9++) {
                                        iArr2[i9] = 0;
                                    }
                                    end.arrange(measureScope2, i6, iArr, measureScope2.getLayoutDirection(), iArr2);
                                    int size4 = list4.size();
                                    for (int i10 = 0; i10 < size4; i10++) {
                                        Placeable.PlacementScope.place$default(placementScope, list4.get(i10), iArr2[i10], list3.get(i7).intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                        return list.isEmpty() || (intRef.element + measureScope.mo624roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m6345getMaxWidthimpl(j);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                        if (!list.isEmpty()) {
                            intRef.element += measureScope.mo624roundToPx0680j_4(f3);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(intRef2.element));
                        list4.add(Integer.valueOf(intRef.element));
                        intRef.element += intRef2.element;
                        intRef3.element = Math.max(intRef3.element, intRef4.element);
                        list2.clear();
                        intRef4.element = 0;
                        intRef2.element = 0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            int i3 = (i2 >> 6) & 14;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            int i4 = ((i3 << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f, f2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    static {
        float f = 24;
        DialogPadding = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(f));
        float f2 = 16;
        IconPadding = PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6389constructorimpl(f2), 7, null);
        TitlePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6389constructorimpl(f2), 7, null);
        TextPadding = PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6389constructorimpl(f), 7, null);
    }
}
