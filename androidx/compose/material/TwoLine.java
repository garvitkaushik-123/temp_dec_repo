package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J~\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0012\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/material/TwoLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TwoLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconVerticalPadding;
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    private static final float TrailingRightPadding;
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float MinHeight = Dp.m6389constructorimpl(64);
    private static final float MinHeightWithIcon = Dp.m6389constructorimpl(72);
    private static final float IconMinPaddedWidth = Dp.m6389constructorimpl(40);
    private static final float OverlineBaselineOffset = Dp.m6389constructorimpl(24);
    private static final float PrimaryBaselineOffsetNoIcon = Dp.m6389constructorimpl(28);
    private static final float PrimaryBaselineOffsetWithIcon = Dp.m6389constructorimpl(32);

    private TwoLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ListItem(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        TwoLine twoLine;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        Modifier modifier3;
        final float f;
        float f2;
        float f3;
        final Modifier modifier4;
        float f4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1340612993);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItem)P(1!1,4,3)208@7880L2468:ListItem.kt#jmzs0o");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 16384 : 8192;
        }
        if ((i2 & 32) == 0) {
            if ((458752 & i) == 0) {
                i4 = startRestartGroup.changedInstance(function25) ? 131072 : 65536;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
                twoLine = this;
            } else {
                twoLine = this;
                if ((3670016 & i) == 0) {
                    i3 |= startRestartGroup.changed(twoLine) ? 1048576 : 524288;
                }
            }
            if ((2995931 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1340612993, i3, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:206)");
                }
                float f5 = function2 != null ? MinHeight : MinHeightWithIcon;
                Modifier m916heightInVpY3zN4$default = SizeKt.m916heightInVpY3zN4$default(companion, f5, 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m916heightInVpY3zN4$default);
                float f6 = f5;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -269995366, "C:ListItem.kt#jmzs0o");
                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(-269995232);
                ComposerKt.sourceInformation(startRestartGroup, "213@8104L532");
                if (function2 == null) {
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    float f7 = IconLeftPadding;
                    Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(companion2, Dp.m6389constructorimpl(f7 + IconMinPaddedWidth), f6, 0.0f, 0.0f, 12, null);
                    float f8 = IconVerticalPadding;
                    Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(m932sizeInqDBjuR0$default, f7, f8, 0.0f, f8, 4, null);
                    Alignment topStart = Alignment.INSTANCE.getTopStart();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default2);
                    modifier3 = companion;
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 506637681, "C225@8628L6:ListItem.kt#jmzs0o");
                    function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                } else {
                    modifier3 = companion;
                }
                startRestartGroup.endReplaceableGroup();
                if (function24 == null) {
                    startRestartGroup.startReplaceableGroup(-269994610);
                    ComposerKt.sourceInformation(startRestartGroup, "229@8708L242");
                    f = f6;
                    ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new Dp[]{Dp.m6387boximpl(OverlineBaselineOffset), Dp.m6387boximpl(OverlineToPrimaryBaselineOffset)}), m883paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(startRestartGroup, -1675021441, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$2
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

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C233@8891L14,234@8926L6:ListItem.kt#jmzs0o");
                            if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1675021441, i6, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:233)");
                                }
                                function24.invoke(composer2, 0);
                                function22.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 390, 0);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    f = f6;
                    startRestartGroup.startReplaceableGroup(-269994330);
                    ComposerKt.sourceInformation(startRestartGroup, "237@8988L668");
                    Dp[] dpArr = new Dp[2];
                    if (function2 != null) {
                        f2 = PrimaryBaselineOffsetWithIcon;
                    } else {
                        f2 = PrimaryBaselineOffsetNoIcon;
                    }
                    dpArr[0] = Dp.m6387boximpl(f2);
                    if (function2 != null) {
                        f3 = PrimaryToSecondaryBaselineOffsetWithIcon;
                    } else {
                        f3 = PrimaryToSecondaryBaselineOffsetNoIcon;
                    }
                    dpArr[1] = Dp.m6387boximpl(f3);
                    ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) dpArr), m883paddingqDBjuR0$default, ComposableLambdaKt.composableLambda(startRestartGroup, 993836488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$3
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

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C252@9594L6,253@9621L17:ListItem.kt#jmzs0o");
                            if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(993836488, i6, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:252)");
                                }
                                function22.invoke(composer2, 0);
                                Function2<Composer, Integer, Unit> function26 = function23;
                                Intrinsics.checkNotNull(function26);
                                function26.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 384, 0);
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.startReplaceableGroup(-2000988210);
                ComposerKt.sourceInformation(startRestartGroup, "257@9723L601");
                if (function25 != null) {
                    if (function2 != null) {
                        f4 = PrimaryBaselineOffsetWithIcon;
                    } else {
                        f4 = PrimaryBaselineOffsetNoIcon;
                    }
                    ListItemKt.m1695OffsetToBaselineOrCenterKz89ssw(f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1696992176, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$4
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

                        public final void invoke(Composer composer2, int i6) {
                            float f9;
                            ComposerKt.sourceInformation(composer2, "C264@9986L320:ListItem.kt#jmzs0o");
                            if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1696992176, i6, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:264)");
                                }
                                Modifier m916heightInVpY3zN4$default2 = SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null);
                                f9 = TwoLine.TrailingRightPadding;
                                Modifier m883paddingqDBjuR0$default3 = PaddingKt.m883paddingqDBjuR0$default(m916heightInVpY3zN4$default2, 0.0f, 0.0f, f9, 0.0f, 11, null);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function26 = function25;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default3);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor3);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1466761876, "C269@10294L10:ListItem.kt#jmzs0o");
                                function26.invoke(composer2, 0);
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
                    }), startRestartGroup, 384, 2);
                }
                startRestartGroup.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final TwoLine twoLine2 = twoLine;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$2
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

                    public final void invoke(Composer composer2, int i6) {
                        TwoLine.this.ListItem(modifier4, function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i4;
        if ((i2 & 64) == 0) {
        }
        if ((2995931 & i3) == 599186) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (function2 != null) {
        }
        Modifier m916heightInVpY3zN4$default2 = SizeKt.m916heightInVpY3zN4$default(companion, f5, 0.0f, 2, null);
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m916heightInVpY3zN4$default2);
        float f62 = f5;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -269995366, "C:ListItem.kt#jmzs0o");
        Modifier m883paddingqDBjuR0$default3 = PaddingKt.m883paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null);
        startRestartGroup.startReplaceableGroup(-269995232);
        ComposerKt.sourceInformation(startRestartGroup, "213@8104L532");
        if (function2 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (function24 == null) {
        }
        startRestartGroup.startReplaceableGroup(-2000988210);
        ComposerKt.sourceInformation(startRestartGroup, "257@9723L601");
        if (function25 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        float f = 16;
        IconLeftPadding = Dp.m6389constructorimpl(f);
        IconVerticalPadding = Dp.m6389constructorimpl(f);
        ContentLeftPadding = Dp.m6389constructorimpl(f);
        ContentRightPadding = Dp.m6389constructorimpl(f);
        float f2 = 20;
        OverlineToPrimaryBaselineOffset = Dp.m6389constructorimpl(f2);
        PrimaryToSecondaryBaselineOffsetNoIcon = Dp.m6389constructorimpl(f2);
        PrimaryToSecondaryBaselineOffsetWithIcon = Dp.m6389constructorimpl(f2);
        TrailingRightPadding = Dp.m6389constructorimpl(f);
    }
}
