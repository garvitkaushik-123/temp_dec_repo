package androidx.compose.material;

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
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\n\u001a\u0090\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0179 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i5;
        boolean z2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<Composer, Integer, Unit> applyTextStyle;
        Function2<Composer, Integer, Unit> applyTextStyle2;
        Function2<Composer, Integer, Unit> applyTextStyle3;
        Function2<Composer, Integer, Unit> applyTextStyle4;
        Modifier semantics;
        Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItem)P(1!1,3,4!1,6)84@3532L10,86@3615L4,87@3705L6,88@3806L4,89@3899L4:ListItem.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            function26 = function2;
            i3 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                function27 = function22;
                i3 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        function28 = function23;
                        i3 |= startRestartGroup.changedInstance(function28) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            i3 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                        if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i9 != 0) {
                                function26 = null;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function215 = i4 != 0 ? null : function27;
                            boolean z4 = i5 != 0 ? true : z2;
                            function29 = i6 != 0 ? null : function28;
                            Function2<? super Composer, ? super Integer, Unit> function216 = i7 == 0 ? function24 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-450923337, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:83)");
                            }
                            Typography typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                            applyTextStyle = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function25);
                            Intrinsics.checkNotNull(applyTextStyle);
                            applyTextStyle2 = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), function215);
                            applyTextStyle3 = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function29);
                            applyTextStyle4 = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function216);
                            semantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (applyTextStyle2 == null || applyTextStyle3 != null) {
                                function210 = function26;
                                function211 = function29;
                                if ((applyTextStyle3 != null && z4) || applyTextStyle2 == null) {
                                    startRestartGroup.startReplaceableGroup(-210280247);
                                    ComposerKt.sourceInformation(startRestartGroup, "98@4274L184");
                                    TwoLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
                                    startRestartGroup = startRestartGroup;
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    startRestartGroup.startReplaceableGroup(-210280033);
                                    ComposerKt.sourceInformation(startRestartGroup, "107@4490L184");
                                    ThreeLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
                                    startRestartGroup = startRestartGroup;
                                    startRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                startRestartGroup.startReplaceableGroup(-210280444);
                                ComposerKt.sourceInformation(startRestartGroup, "94@4077L61");
                                function210 = function26;
                                function211 = function29;
                                OneLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle4, startRestartGroup, (i3 & 112) | 24576, 0);
                                startRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function212 = function215;
                            z3 = z4;
                            function213 = function210;
                            function214 = function216;
                            modifier3 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function214 = function24;
                            modifier3 = modifier2;
                            function213 = function26;
                            function212 = function27;
                            z3 = z2;
                            function211 = function28;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$1
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

                                public final void invoke(Composer composer2, int i10) {
                                    ListItemKt.ListItem(Modifier.this, function213, function212, z3, function211, function214, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function28 = function23;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i3 & 2995931) == 599186) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Typography typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    applyTextStyle = applyTextStyle(typography2.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function25);
                    Intrinsics.checkNotNull(applyTextStyle);
                    applyTextStyle2 = applyTextStyle(typography2.getBody2(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), function215);
                    applyTextStyle3 = applyTextStyle(typography2.getOverline(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function29);
                    applyTextStyle4 = applyTextStyle(typography2.getCaption(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function216);
                    semantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    if (applyTextStyle2 == null) {
                    }
                    function210 = function26;
                    function211 = function29;
                    if (applyTextStyle3 != null) {
                    }
                    startRestartGroup.startReplaceableGroup(-210280033);
                    ComposerKt.sourceInformation(startRestartGroup, "107@4490L184");
                    ThreeLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
                    startRestartGroup = startRestartGroup;
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function212 = function215;
                    z3 = z4;
                    function213 = function210;
                    function214 = function216;
                    modifier3 = companion;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function28 = function23;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i3 & 2995931) == 599186) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Typography typography22 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                applyTextStyle = applyTextStyle(typography22.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function25);
                Intrinsics.checkNotNull(applyTextStyle);
                applyTextStyle2 = applyTextStyle(typography22.getBody2(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), function215);
                applyTextStyle3 = applyTextStyle(typography22.getOverline(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function29);
                applyTextStyle4 = applyTextStyle(typography22.getCaption(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function216);
                semantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                if (applyTextStyle2 == null) {
                }
                function210 = function26;
                function211 = function29;
                if (applyTextStyle3 != null) {
                }
                startRestartGroup.startReplaceableGroup(-210280033);
                ComposerKt.sourceInformation(startRestartGroup, "107@4490L184");
                ThreeLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                function212 = function215;
                z3 = z4;
                function213 = function210;
                function214 = function216;
                modifier3 = companion;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function27 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function28 = function23;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 2995931) == 599186) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Typography typography222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
            applyTextStyle = applyTextStyle(typography222.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function25);
            Intrinsics.checkNotNull(applyTextStyle);
            applyTextStyle2 = applyTextStyle(typography222.getBody2(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), function215);
            applyTextStyle3 = applyTextStyle(typography222.getOverline(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function29);
            applyTextStyle4 = applyTextStyle(typography222.getCaption(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function216);
            semantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            });
            if (applyTextStyle2 == null) {
            }
            function210 = function26;
            function211 = function29;
            if (applyTextStyle3 != null) {
            }
            startRestartGroup.startReplaceableGroup(-210280033);
            ComposerKt.sourceInformation(startRestartGroup, "107@4490L184");
            ThreeLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
            startRestartGroup = startRestartGroup;
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            function212 = function215;
            z3 = z4;
            function213 = function210;
            function214 = function216;
            modifier3 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function26 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function27 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function28 = function23;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 2995931) == 599186) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Typography typography2222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
        applyTextStyle = applyTextStyle(typography2222.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function25);
        Intrinsics.checkNotNull(applyTextStyle);
        applyTextStyle2 = applyTextStyle(typography2222.getBody2(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), function215);
        applyTextStyle3 = applyTextStyle(typography2222.getOverline(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function29);
        applyTextStyle4 = applyTextStyle(typography2222.getCaption(), ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6), function216);
        semantics = SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        });
        if (applyTextStyle2 == null) {
        }
        function210 = function26;
        function211 = function29;
        if (applyTextStyle3 != null) {
        }
        startRestartGroup.startReplaceableGroup(-210280033);
        ComposerKt.sourceInformation(startRestartGroup, "107@4490L184");
        ThreeLine.INSTANCE.ListItem(semantics, function210, applyTextStyle, applyTextStyle2, applyTextStyle3, applyTextStyle4, startRestartGroup, (i3 & 112) | 1572864, 0);
        startRestartGroup = startRestartGroup;
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        function212 = function215;
        z3 = z4;
        function213 = function210;
        function214 = function216;
        modifier3 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(final List<Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Composer startRestartGroup = composer.startRestartGroup(1631148337);
        ComposerKt.sourceInformation(startRestartGroup, "C(BaselinesOffsetColumn)P(2,1)355@13242L1135:ListItem.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1631148337, i, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:354)");
        }
        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list2, long j) {
                int i3;
                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, null);
                ArrayList arrayList = new ArrayList(list2.size());
                int size = list2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.add(list2.get(i4).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                }
                final ArrayList arrayList2 = arrayList;
                int size2 = arrayList2.size();
                Integer num = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    num = Integer.valueOf(Math.max(num.intValue(), ((Placeable) arrayList2.get(i5)).getWidth()));
                }
                int intValue = num.intValue();
                int size3 = arrayList2.size();
                final Integer[] numArr = new Integer[size3];
                for (int i6 = 0; i6 < size3; i6++) {
                    numArr[i6] = 0;
                }
                List<Dp> list3 = list;
                int size4 = arrayList2.size();
                int i7 = 0;
                for (int i8 = 0; i8 < size4; i8++) {
                    Placeable placeable = (Placeable) arrayList2.get(i8);
                    if (i8 > 0) {
                        int i9 = i8 - 1;
                        i3 = ((Placeable) arrayList2.get(i9)).getHeight() - ((Placeable) arrayList2.get(i9)).get(AlignmentLineKt.getLastBaseline());
                    } else {
                        i3 = 0;
                    }
                    int max = Math.max(0, (measureScope.mo624roundToPx0680j_4(list3.get(i8).m6403unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - i3);
                    numArr[i8] = Integer.valueOf(max + i7);
                    i7 += max + placeable.getHeight();
                }
                return MeasureScope.layout$default(measureScope, intValue, i7, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        List<Placeable> list4 = arrayList2;
                        Integer[] numArr2 = numArr;
                        int size5 = list4.size();
                        for (int i10 = 0; i10 < size5; i10++) {
                            Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i10), 0, numArr2[i10].intValue(), 0.0f, 4, null);
                        }
                    }
                }, 4, null);
            }
        };
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int i3 = (((((i >> 6) & 14) | (i & 112)) << 9) & 7168) | 6;
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
        function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$BaselinesOffsetColumn$2
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

                public final void invoke(Composer composer2, int i4) {
                    ListItemKt.BaselinesOffsetColumn(list, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m1695OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1062692685);
        ComposerKt.sourceInformation(startRestartGroup, "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)397@14905L806:ListItem.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062692685, i3, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:396)");
            }
            startRestartGroup.startReplaceableGroup(-1616626060);
            boolean changed = startRestartGroup.changed(f);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int max;
                        final int m6518getYimpl;
                        final Placeable mo5333measureBRTryo0 = list.get(0).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                        int i5 = mo5333measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                        if (i5 != Integer.MIN_VALUE) {
                            m6518getYimpl = measureScope.mo624roundToPx0680j_4(f) - i5;
                            max = Math.max(Constraints.m6346getMinHeightimpl(j), mo5333measureBRTryo0.getHeight() + m6518getYimpl);
                        } else {
                            max = Math.max(Constraints.m6346getMinHeightimpl(j), mo5333measureBRTryo0.getHeight());
                            m6518getYimpl = IntOffset.m6518getYimpl(Alignment.INSTANCE.getCenter().mo3699alignKFBX0sM(IntSize.INSTANCE.m6564getZeroYbymL2g(), IntSizeKt.IntSize(0, max - mo5333measureBRTryo0.getHeight()), measureScope.getLayoutDirection()));
                        }
                        return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$1.1
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
                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, m6518getYimpl, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i5 = (((((i3 >> 6) & 14) | (i3 & 112)) << 9) & 7168) | 6;
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
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$2
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
                    ListItemKt.m1695OffsetToBaselineOrCenterKz89ssw(f, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        final LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m6259getProportionalPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m6270getBothEVpEnUU(), null);
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$applyTextStyle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C430@16067L163:ListItem.kt#jmzs0o");
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830176860, i, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:430)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f));
                    final TextStyle textStyle2 = textStyle;
                    final LineHeightStyle lineHeightStyle2 = lineHeightStyle;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer, 1665877604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt$applyTextStyle$1.1
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

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C431@16147L73:ListItem.kt#jmzs0o");
                            if ((i2 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1665877604, i2, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:431)");
                            }
                            TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(TextStyle.this, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, lineHeightStyle2, 0, 0, null, 15728639, null), function22, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }
}
