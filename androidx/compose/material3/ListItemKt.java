package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a©\u0001\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001at\u0010'\u001a\u00020\u00172\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a`\u00106\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a`\u0010G\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001af\u0010L\u001a\u00020M*\u0002082\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010P\u001a\u00020Q2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020BH\u0002\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u001e\u0010\n\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u001e\u0010\r\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005\"\u001e\u0010\u0010\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u001e\u0010\u0013\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"LeadingContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "getLeadingContentEndPadding$annotations", "()V", "getLeadingContentEndPadding", "()F", "F", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "getListItemVerticalPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "", "Landroidx/compose/ui/layout/MeasureScope;", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "listItemType", "Landroidx/compose/material3/ListItemType;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ILandroidx/compose/foundation/layout/PaddingValues;J)I", "calculateWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateWidth-xygx4p4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/layout/PaddingValues;J)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "isThreeLine", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float TrailingContentStartPadding;
    private static final float ListItemVerticalPadding = Dp.m6389constructorimpl(8);
    private static final float ListItemThreeLineVerticalPadding = Dp.m6389constructorimpl(12);

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a9  */
    /* renamed from: ListItem-HXNGIdc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2295ListItemHXNGIdc(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, ListItemColors listItemColors, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i8;
        int i9;
        int i10;
        int i11;
        float f3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i12;
        int i13;
        Composer composer3;
        ListItemColors listItemColors2;
        float f4;
        float f5;
        final ListItemColors listItemColors3;
        Function2<? super Composer, ? super Integer, Unit> function211;
        ComposableLambda composableLambda;
        final ComposableLambda composableLambda2;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final float f6;
        final float f7;
        final ListItemColors listItemColors4;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)89@4308L8,144@6169L5,140@6019L637:ListItem.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function26 = function22;
                i3 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function27 = function23;
                    i3 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(function24) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            function28 = function25;
                            i3 |= startRestartGroup.changedInstance(function28) ? 131072 : 65536;
                            if ((i & 1572864) == 0) {
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(listItemColors)) ? 1048576 : 524288;
                            }
                            i8 = i2 & 128;
                            if (i8 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                                i10 = i2 & 256;
                                if (i10 != 0) {
                                    i3 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    i11 = i10;
                                    f3 = f2;
                                    i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                                    composer2 = startRestartGroup;
                                    if ((i3 & 38347923) == 38347922 || !composer2.getSkipping()) {
                                        composer2.startDefaults();
                                        ComposableLambda composableLambda3 = null;
                                        if ((i & 1) != 0 || composer2.getDefaultsInvalid()) {
                                            if (i14 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i4 != 0) {
                                                function26 = null;
                                            }
                                            if (i5 != 0) {
                                                function27 = null;
                                            }
                                            function29 = i6 == 0 ? null : function24;
                                            function210 = i7 == 0 ? null : function28;
                                            if ((i2 & 64) == 0) {
                                                i12 = i9;
                                                i13 = i11;
                                                listItemColors2 = ListItemDefaults.INSTANCE.m2293colorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, C.ENCODING_PCM_32BIT, 511);
                                                composer3 = composer2;
                                                i3 &= -3670017;
                                            } else {
                                                i12 = i9;
                                                i13 = i11;
                                                composer3 = composer2;
                                                listItemColors2 = listItemColors;
                                            }
                                            float m2294getElevationD9Ej5fM = i12 == 0 ? ListItemDefaults.INSTANCE.m2294getElevationD9Ej5fM() : f;
                                            if (i13 == 0) {
                                                f5 = m2294getElevationD9Ej5fM;
                                                f4 = ListItemDefaults.INSTANCE.m2294getElevationD9Ej5fM();
                                            } else {
                                                f4 = f2;
                                                f5 = m2294getElevationD9Ej5fM;
                                            }
                                            listItemColors3 = listItemColors2;
                                        } else {
                                            composer2.skipToGroupEnd();
                                            if ((i2 & 64) != 0) {
                                                i3 &= -3670017;
                                            }
                                            function29 = function24;
                                            listItemColors3 = listItemColors;
                                            f5 = f;
                                            f4 = f3;
                                            function210 = function28;
                                            composer3 = composer2;
                                        }
                                        composer3.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1647707763, i3, -1, "androidx.compose.material3.ListItem (ListItem.kt:92)");
                                        }
                                        final ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i15) {
                                                ComposerKt.sourceInformation(composer4, "C94@4498L160:ListItem.kt#uh7d8r");
                                                if ((i15 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-403249643, i15, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                                    }
                                                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer4, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        });
                                        ComposableLambda composableLambda5 = function27 == null ? ComposableLambdaKt.composableLambda(composer3, -1020860251, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i15) {
                                                ComposerKt.sourceInformation(composer4, "C102@4776L156:ListItem.kt#uh7d8r");
                                                if ((i15 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1020860251, i15, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:102)");
                                                    }
                                                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2291supportingColor0d7_KjU$material3_release(), ListTokens.INSTANCE.getListItemSupportingTextFont(), function27, composer4, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }) : null;
                                        ComposableLambda composableLambda6 = function26 == null ? ComposableLambdaKt.composableLambda(composer3, -764441232, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i15) {
                                                ComposerKt.sourceInformation(composer4, "C111@5056L148:ListItem.kt#uh7d8r");
                                                if ((i15 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-764441232, i15, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:111)");
                                                    }
                                                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2290overlineColor0d7_KjU$material3_release(), ListTokens.INSTANCE.getListItemOverlineFont(), function26, composer4, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }) : null;
                                        if (function29 == null) {
                                            function211 = function29;
                                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 1400509200, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i15) {
                                                    ComposerKt.sourceInformation(composer4, "C120@5326L250:ListItem.kt#uh7d8r");
                                                    if ((i15 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1400509200, i15, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:120)");
                                                        }
                                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, ListItemKt.getLeadingContentEndPadding(), 0.0f, 11, null);
                                                        ListItemColors listItemColors5 = ListItemColors.this;
                                                        Function2<Composer, Integer, Unit> function216 = function29;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 2011888581, "C121@5398L164:ListItem.kt#uh7d8r");
                                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(listItemColors5.m2289leadingIconColorvNxB06k$material3_release(true))), function216, composer4, ProvidedValue.$stable);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        } else {
                                            function211 = function29;
                                            composableLambda = null;
                                        }
                                        if (function210 == null) {
                                            composableLambda2 = composableLambda;
                                            composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1512306332, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i15) {
                                                    ComposerKt.sourceInformation(composer4, "C130@5700L297:ListItem.kt#uh7d8r");
                                                    if ((i15 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1512306332, i15, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:130)");
                                                        }
                                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, ListItemKt.getTrailingContentStartPadding(), 0.0f, 0.0f, 0.0f, 14, null);
                                                        ListItemColors listItemColors5 = ListItemColors.this;
                                                        Function2<Composer, Integer, Unit> function216 = function210;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 2011888960, "C131@5777L206:ListItem.kt#uh7d8r");
                                                        ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(listItemColors5.m2292trailingIconColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function216, composer4, 48);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        } else {
                                            composableLambda2 = composableLambda;
                                        }
                                        final ComposableLambda composableLambda7 = composableLambda6;
                                        final ComposableLambda composableLambda8 = composableLambda5;
                                        final ComposableLambda composableLambda9 = composableLambda3;
                                        int i15 = i3 >> 9;
                                        Composer composer4 = composer3;
                                        SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i16) {
                                                ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                                                if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                                    }
                                                    ListItemKt.ListItemLayout(composableLambda2, composableLambda9, composableLambda4, composableLambda7, composableLambda8, composer5, 384);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, (57344 & i15) | 12582912 | (i15 & 458752), 64);
                                        composer2 = composer4;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function212 = function210;
                                        function213 = function26;
                                        function214 = function27;
                                        f6 = f5;
                                        f7 = f4;
                                        listItemColors4 = listItemColors3;
                                        modifier3 = modifier2;
                                        function215 = function211;
                                    } else {
                                        composer2.skipToGroupEnd();
                                        f6 = f;
                                        modifier3 = modifier2;
                                        function213 = function26;
                                        function214 = function27;
                                        f7 = f3;
                                        function212 = function28;
                                        function215 = function24;
                                        listItemColors4 = listItemColors;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i16) {
                                                ListItemKt.m2295ListItemHXNGIdc(function2, modifier3, function213, function214, function215, function212, listItemColors4, f6, f7, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i11 = i10;
                                f3 = f2;
                                composer2 = startRestartGroup;
                                if ((i3 & 38347923) == 38347922) {
                                }
                                composer2.startDefaults();
                                ComposableLambda composableLambda32 = null;
                                if ((i & 1) != 0) {
                                }
                                if (i14 != 0) {
                                }
                                if (i4 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if ((i2 & 64) == 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                listItemColors3 = listItemColors2;
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda42 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer42, Integer num) {
                                        invoke(composer42, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer42, int i152) {
                                        ComposerKt.sourceInformation(composer42, "C94@4498L160:ListItem.kt#uh7d8r");
                                        if ((i152 & 3) != 2 || !composer42.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-403249643, i152, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                            }
                                            ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer42, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer42.skipToGroupEnd();
                                    }
                                });
                                if (function27 == null) {
                                }
                                if (function26 == null) {
                                }
                                if (function29 == null) {
                                }
                                if (function210 == null) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda72 = composableLambda6;
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda82 = composableLambda5;
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda92 = composableLambda32;
                                int i152 = i3 >> 9;
                                Composer composer42 = composer3;
                                SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i16) {
                                        ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                                        if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                            }
                                            ListItemKt.ListItemLayout(composableLambda2, composableLambda92, composableLambda42, composableLambda72, composableLambda82, composer5, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer42, (57344 & i152) | 12582912 | (i152 & 458752), 64);
                                composer2 = composer42;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function212 = function210;
                                function213 = function26;
                                function214 = function27;
                                f6 = f5;
                                f7 = f4;
                                listItemColors4 = listItemColors3;
                                modifier3 = modifier2;
                                function215 = function211;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i9 = i8;
                            i10 = i2 & 256;
                            if (i10 != 0) {
                            }
                            i11 = i10;
                            f3 = f2;
                            composer2 = startRestartGroup;
                            if ((i3 & 38347923) == 38347922) {
                            }
                            composer2.startDefaults();
                            ComposableLambda composableLambda322 = null;
                            if ((i & 1) != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            listItemColors3 = listItemColors2;
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda422 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer422, Integer num) {
                                    invoke(composer422, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer422, int i1522) {
                                    ComposerKt.sourceInformation(composer422, "C94@4498L160:ListItem.kt#uh7d8r");
                                    if ((i1522 & 3) != 2 || !composer422.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-403249643, i1522, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                        }
                                        ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer422, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer422.skipToGroupEnd();
                                }
                            });
                            if (function27 == null) {
                            }
                            if (function26 == null) {
                            }
                            if (function29 == null) {
                            }
                            if (function210 == null) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda722 = composableLambda6;
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda822 = composableLambda5;
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda922 = composableLambda322;
                            int i1522 = i3 >> 9;
                            Composer composer422 = composer3;
                            SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i16) {
                                    ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                        }
                                        ListItemKt.ListItemLayout(composableLambda2, composableLambda922, composableLambda422, composableLambda722, composableLambda822, composer5, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer422, (57344 & i1522) | 12582912 | (i1522 & 458752), 64);
                            composer2 = composer422;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function212 = function210;
                            function213 = function26;
                            function214 = function27;
                            f6 = f5;
                            f7 = f4;
                            listItemColors4 = listItemColors3;
                            modifier3 = modifier2;
                            function215 = function211;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        function28 = function25;
                        if ((i & 1572864) == 0) {
                        }
                        i8 = i2 & 128;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i2 & 256;
                        if (i10 != 0) {
                        }
                        i11 = i10;
                        f3 = f2;
                        composer2 = startRestartGroup;
                        if ((i3 & 38347923) == 38347922) {
                        }
                        composer2.startDefaults();
                        ComposableLambda composableLambda3222 = null;
                        if ((i & 1) != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        listItemColors3 = listItemColors2;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda4222 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4222, Integer num) {
                                invoke(composer4222, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4222, int i15222) {
                                ComposerKt.sourceInformation(composer4222, "C94@4498L160:ListItem.kt#uh7d8r");
                                if ((i15222 & 3) != 2 || !composer4222.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-403249643, i15222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                    }
                                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer4222, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4222.skipToGroupEnd();
                            }
                        });
                        if (function27 == null) {
                        }
                        if (function26 == null) {
                        }
                        if (function29 == null) {
                        }
                        if (function210 == null) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda7222 = composableLambda6;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda8222 = composableLambda5;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda9222 = composableLambda3222;
                        int i15222 = i3 >> 9;
                        Composer composer4222 = composer3;
                        SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i16) {
                                ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                                if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                    }
                                    ListItemKt.ListItemLayout(composableLambda2, composableLambda9222, composableLambda4222, composableLambda7222, composableLambda8222, composer5, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4222, (57344 & i15222) | 12582912 | (i15222 & 458752), 64);
                        composer2 = composer4222;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function212 = function210;
                        function213 = function26;
                        function214 = function27;
                        f6 = f5;
                        f7 = f4;
                        listItemColors4 = listItemColors3;
                        modifier3 = modifier2;
                        function215 = function211;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    function28 = function25;
                    if ((i & 1572864) == 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    f3 = f2;
                    composer2 = startRestartGroup;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    composer2.startDefaults();
                    ComposableLambda composableLambda32222 = null;
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    listItemColors3 = listItemColors2;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda42222 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer42222, Integer num) {
                            invoke(composer42222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer42222, int i152222) {
                            ComposerKt.sourceInformation(composer42222, "C94@4498L160:ListItem.kt#uh7d8r");
                            if ((i152222 & 3) != 2 || !composer42222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-403249643, i152222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                }
                                ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer42222, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer42222.skipToGroupEnd();
                        }
                    });
                    if (function27 == null) {
                    }
                    if (function26 == null) {
                    }
                    if (function29 == null) {
                    }
                    if (function210 == null) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda72222 = composableLambda6;
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda82222 = composableLambda5;
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda92222 = composableLambda32222;
                    int i152222 = i3 >> 9;
                    Composer composer42222 = composer3;
                    SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i16) {
                            ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                }
                                ListItemKt.ListItemLayout(composableLambda2, composableLambda92222, composableLambda42222, composableLambda72222, composableLambda82222, composer5, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer42222, (57344 & i152222) | 12582912 | (i152222 & 458752), 64);
                    composer2 = composer42222;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function212 = function210;
                    function213 = function26;
                    function214 = function27;
                    f6 = f5;
                    f7 = f4;
                    listItemColors4 = listItemColors3;
                    modifier3 = modifier2;
                    function215 = function211;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function27 = function23;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                function28 = function25;
                if ((i & 1572864) == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                }
                i11 = i10;
                f3 = f2;
                composer2 = startRestartGroup;
                if ((i3 & 38347923) == 38347922) {
                }
                composer2.startDefaults();
                ComposableLambda composableLambda322222 = null;
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                listItemColors3 = listItemColors2;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> composableLambda422222 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer422222, Integer num) {
                        invoke(composer422222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer422222, int i1522222) {
                        ComposerKt.sourceInformation(composer422222, "C94@4498L160:ListItem.kt#uh7d8r");
                        if ((i1522222 & 3) != 2 || !composer422222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-403249643, i1522222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                            }
                            ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer422222, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer422222.skipToGroupEnd();
                    }
                });
                if (function27 == null) {
                }
                if (function26 == null) {
                }
                if (function29 == null) {
                }
                if (function210 == null) {
                }
                final Function2<? super Composer, ? super Integer, Unit> composableLambda722222 = composableLambda6;
                final Function2<? super Composer, ? super Integer, Unit> composableLambda822222 = composableLambda5;
                final Function2<? super Composer, ? super Integer, Unit> composableLambda922222 = composableLambda322222;
                int i1522222 = i3 >> 9;
                Composer composer422222 = composer3;
                SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                        invoke(composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i16) {
                        ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                        if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                            }
                            ListItemKt.ListItemLayout(composableLambda2, composableLambda922222, composableLambda422222, composableLambda722222, composableLambda822222, composer5, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }), composer422222, (57344 & i1522222) | 12582912 | (i1522222 & 458752), 64);
                composer2 = composer422222;
                if (ComposerKt.isTraceInProgress()) {
                }
                function212 = function210;
                function213 = function26;
                function214 = function27;
                f6 = f5;
                f7 = f4;
                listItemColors4 = listItemColors3;
                modifier3 = modifier2;
                function215 = function211;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function26 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function27 = function23;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            function28 = function25;
            if ((i & 1572864) == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
            }
            i11 = i10;
            f3 = f2;
            composer2 = startRestartGroup;
            if ((i3 & 38347923) == 38347922) {
            }
            composer2.startDefaults();
            ComposableLambda composableLambda3222222 = null;
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            listItemColors3 = listItemColors2;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> composableLambda4222222 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4222222, Integer num) {
                    invoke(composer4222222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4222222, int i15222222) {
                    ComposerKt.sourceInformation(composer4222222, "C94@4498L160:ListItem.kt#uh7d8r");
                    if ((i15222222 & 3) != 2 || !composer4222222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-403249643, i15222222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                        }
                        ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer4222222, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4222222.skipToGroupEnd();
                }
            });
            if (function27 == null) {
            }
            if (function26 == null) {
            }
            if (function29 == null) {
            }
            if (function210 == null) {
            }
            final Function2<? super Composer, ? super Integer, Unit> composableLambda7222222 = composableLambda6;
            final Function2<? super Composer, ? super Integer, Unit> composableLambda8222222 = composableLambda5;
            final Function2<? super Composer, ? super Integer, Unit> composableLambda9222222 = composableLambda3222222;
            int i15222222 = i3 >> 9;
            Composer composer4222222 = composer3;
            SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                    invoke(composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i16) {
                    ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                    if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                        }
                        ListItemKt.ListItemLayout(composableLambda2, composableLambda9222222, composableLambda4222222, composableLambda7222222, composableLambda8222222, composer5, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }), composer4222222, (57344 & i15222222) | 12582912 | (i15222222 & 458752), 64);
            composer2 = composer4222222;
            if (ComposerKt.isTraceInProgress()) {
            }
            function212 = function210;
            function213 = function26;
            function214 = function27;
            f6 = f5;
            f7 = f4;
            listItemColors4 = listItemColors3;
            modifier3 = modifier2;
            function215 = function211;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function26 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function27 = function23;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        function28 = function25;
        if ((i & 1572864) == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 != 0) {
        }
        i11 = i10;
        f3 = f2;
        composer2 = startRestartGroup;
        if ((i3 & 38347923) == 38347922) {
        }
        composer2.startDefaults();
        ComposableLambda composableLambda32222222 = null;
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        listItemColors3 = listItemColors2;
        composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> composableLambda42222222 = ComposableLambdaKt.composableLambda(composer3, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer42222222, Integer num) {
                invoke(composer42222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer42222222, int i152222222) {
                ComposerKt.sourceInformation(composer42222222, "C94@4498L160:ListItem.kt#uh7d8r");
                if ((i152222222 & 3) != 2 || !composer42222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-403249643, i152222222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                    }
                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2288headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer42222222, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer42222222.skipToGroupEnd();
            }
        });
        if (function27 == null) {
        }
        if (function26 == null) {
        }
        if (function29 == null) {
        }
        if (function210 == null) {
        }
        final Function2<? super Composer, ? super Integer, Unit> composableLambda72222222 = composableLambda6;
        final Function2<? super Composer, ? super Integer, Unit> composableLambda82222222 = composableLambda5;
        final Function2<? super Composer, ? super Integer, Unit> composableLambda92222222 = composableLambda32222222;
        int i152222222 = i3 >> 9;
        Composer composer42222222 = composer3;
        SurfaceKt.m2633SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }).then(modifier2), ListItemDefaults.INSTANCE.getShape(composer3, 6), listItemColors3.getContainerColor(), listItemColors3.m2288headlineColorvNxB06k$material3_release(true), f5, f4, null, ComposableLambdaKt.composableLambda(composer3, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                invoke(composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer5, int i16) {
                ComposerKt.sourceInformation(composer5, "C150@6378L272:ListItem.kt#uh7d8r");
                if ((i16 & 3) != 2 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1502590376, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                    }
                    ListItemKt.ListItemLayout(composableLambda2, composableLambda92222222, composableLambda42222222, composableLambda72222222, composableLambda82222222, composer5, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }), composer42222222, (57344 & i152222222) | 12582912 | (i152222222 & 458752), 64);
        composer2 = composer42222222;
        if (ComposerKt.isTraceInProgress()) {
        }
        function212 = function210;
        function213 = function26;
        function214 = function27;
        f6 = f5;
        f7 = f4;
        listItemColors4 = listItemColors3;
        modifier3 = modifier2;
        function215 = function211;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2052297037);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItemLayout)P(1,4)168@6954L7,177@7152L3807,169@6966L3993:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052297037, i2, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:167)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) consume;
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function23;
            function2Arr[1] = function24 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2078getLambda1$material3_release() : function24;
            function2Arr[2] = function25 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2079getLambda2$material3_release() : function25;
            function2Arr[3] = function2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2080getLambda3$material3_release() : function2;
            function2Arr[4] = function22 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2081getLambda4$material3_release() : function22;
            List listOf = CollectionsKt.listOf((Object[]) function2Arr);
            startRestartGroup.startReplaceableGroup(1361340338);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ListItem.kt#9igjgp");
            boolean changed = startRestartGroup.changed(layoutDirection);
            MultiContentMeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.ListItemKt$ListItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    /* renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult mo2302measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
                        int m2301calculateWidthxygx4p4;
                        int m2300calculateHeightN4Jib3Y;
                        MeasureResult place;
                        List<? extends Measurable> list2 = list.get(0);
                        List<? extends Measurable> list3 = list.get(1);
                        List<? extends Measurable> list4 = list.get(2);
                        List<? extends Measurable> list5 = list.get(3);
                        List<? extends Measurable> list6 = list.get(4);
                        long m6361offsetNN6EwU = ConstraintsKt.m6361offsetNN6EwU(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null), -measureScope.mo624roundToPx0680j_4(Dp.m6389constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), -measureScope.mo624roundToPx0680j_4(Dp.m6389constructorimpl(ListItemKt.getListItemVerticalPadding() * 2)));
                        Measurable measurable = (Measurable) CollectionsKt.firstOrNull((List) list5);
                        Placeable mo5333measureBRTryo0 = measurable != null ? measurable.mo5333measureBRTryo0(m6361offsetNN6EwU) : null;
                        int widthOrZero = TextFieldImplKt.widthOrZero(mo5333measureBRTryo0);
                        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull((List) list6);
                        Placeable mo5333measureBRTryo02 = measurable2 != null ? measurable2.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(m6361offsetNN6EwU, -widthOrZero, 0, 2, null)) : null;
                        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(mo5333measureBRTryo02);
                        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull((List) list2);
                        Placeable mo5333measureBRTryo03 = measurable3 != null ? measurable3.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(m6361offsetNN6EwU, -widthOrZero2, 0, 2, null)) : null;
                        int heightOrZero = TextFieldImplKt.heightOrZero(mo5333measureBRTryo03);
                        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull((List) list4);
                        Placeable mo5333measureBRTryo04 = measurable4 != null ? measurable4.mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(m6361offsetNN6EwU, -widthOrZero2, -heightOrZero)) : null;
                        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(mo5333measureBRTryo04);
                        boolean z = (mo5333measureBRTryo04 == null || mo5333measureBRTryo04.get(AlignmentLineKt.getFirstBaseline()) == mo5333measureBRTryo04.get(AlignmentLineKt.getLastBaseline())) ? false : true;
                        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull((List) list3);
                        Placeable mo5333measureBRTryo05 = measurable5 != null ? measurable5.mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(m6361offsetNN6EwU, -widthOrZero2, -heightOrZero2)) : null;
                        int m2312getListItemTypeZLSjz4$material3_release = ListItemType.INSTANCE.m2312getListItemTypeZLSjz4$material3_release(mo5333measureBRTryo05 != null, mo5333measureBRTryo04 != null, z);
                        boolean m2307equalsimpl0 = ListItemType.m2307equalsimpl0(m2312getListItemTypeZLSjz4$material3_release, ListItemType.INSTANCE.m2314getThreeLineAlXitO8());
                        PaddingValues m875PaddingValuesa9UjIt4 = PaddingKt.m875PaddingValuesa9UjIt4(ListItemKt.getListItemStartPadding(), m2307equalsimpl0 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding(), ListItemKt.getListItemEndPadding(), m2307equalsimpl0 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding());
                        Placeable placeable = mo5333measureBRTryo02;
                        Placeable placeable2 = mo5333measureBRTryo0;
                        Placeable placeable3 = mo5333measureBRTryo04;
                        Placeable placeable4 = mo5333measureBRTryo05;
                        m2301calculateWidthxygx4p4 = ListItemKt.m2301calculateWidthxygx4p4(measureScope, placeable2, placeable, mo5333measureBRTryo03, placeable4, placeable3, LayoutDirection.this, m875PaddingValuesa9UjIt4, j);
                        m2300calculateHeightN4Jib3Y = ListItemKt.m2300calculateHeightN4Jib3Y(measureScope, placeable2, placeable, mo5333measureBRTryo03, placeable4, placeable3, m2312getListItemTypeZLSjz4$material3_release, m875PaddingValuesa9UjIt4, j);
                        place = ListItemKt.place(measureScope, m2301calculateWidthxygx4p4, m2300calculateHeightN4Jib3Y, placeable2, placeable, mo5333measureBRTryo03, placeable4, placeable3, m2307equalsimpl0, LayoutDirection.this, m875PaddingValuesa9UjIt4);
                        return place;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1399185516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(multiContentMeasurePolicy);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItemLayout$2
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

                public final void invoke(Composer composer2, int i3) {
                    ListItemKt.ListItemLayout(function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-xygx4p4, reason: not valid java name */
    public static final int m2301calculateWidthxygx4p4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, LayoutDirection layoutDirection, PaddingValues paddingValues, long j) {
        if (Constraints.m6341getHasBoundedWidthimpl(j)) {
            return Constraints.m6345getMaxWidthimpl(j);
        }
        int i = measureScope.mo624roundToPx0680j_4(Dp.m6389constructorimpl(paddingValues.mo830calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues.mo831calculateRightPaddingu2uoSUM(layoutDirection)));
        return i + TextFieldImplKt.widthOrZero(placeable) + Math.max(TextFieldImplKt.widthOrZero(placeable3), Math.max(TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable5))) + TextFieldImplKt.widthOrZero(placeable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y, reason: not valid java name */
    public static final int m2300calculateHeightN4Jib3Y(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i, PaddingValues paddingValues, long j) {
        float m3271getListItemTwoLineContainerHeightD9Ej5fM;
        if (ListItemType.m2307equalsimpl0(i, ListItemType.INSTANCE.m2313getOneLineAlXitO8())) {
            m3271getListItemTwoLineContainerHeightD9Ej5fM = ListTokens.INSTANCE.m3267getListItemOneLineContainerHeightD9Ej5fM();
        } else {
            m3271getListItemTwoLineContainerHeightD9Ej5fM = ListItemType.m2307equalsimpl0(i, ListItemType.INSTANCE.m2315getTwoLineAlXitO8()) ? ListTokens.INSTANCE.m3271getListItemTwoLineContainerHeightD9Ej5fM() : ListTokens.INSTANCE.m3269getListItemThreeLineContainerHeightD9Ej5fM();
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(m3271getListItemTwoLineContainerHeightD9Ej5fM)), measureScope.mo624roundToPx0680j_4(Dp.m6389constructorimpl(paddingValues.getTop() + paddingValues.getBottom())) + Math.max(TextFieldImplKt.heightOrZero(placeable), Math.max(TextFieldImplKt.heightOrZero(placeable3) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable5), TextFieldImplKt.heightOrZero(placeable2)))), Constraints.m6344getMaxHeightimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult place(final MeasureScope measureScope, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5, final boolean z, final LayoutDirection layoutDirection, final PaddingValues paddingValues) {
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ListItemKt$place$1
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
                int i3 = MeasureScope.this.mo624roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, layoutDirection));
                int i4 = MeasureScope.this.mo624roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, layoutDirection));
                int i5 = MeasureScope.this.mo624roundToPx0680j_4(paddingValues.getTop());
                Placeable placeable6 = placeable;
                if (placeable6 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, i3, z ? i5 : Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), i2), 0.0f, 4, null);
                }
                Placeable placeable7 = placeable2;
                if (placeable7 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - i4) - placeable7.getWidth(), z ? i5 : Alignment.INSTANCE.getCenterVertically().align(placeable7.getHeight(), i2), 0.0f, 4, null);
                }
                int widthOrZero = i3 + TextFieldImplKt.widthOrZero(placeable);
                if (!z) {
                    i5 = Alignment.INSTANCE.getCenterVertically().align(TextFieldImplKt.heightOrZero(placeable3) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable5), i2);
                }
                int i6 = i5;
                Placeable placeable8 = placeable4;
                if (placeable8 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, widthOrZero, i6, 0.0f, 4, null);
                }
                int heightOrZero = i6 + TextFieldImplKt.heightOrZero(placeable4);
                Placeable placeable9 = placeable3;
                if (placeable9 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, widthOrZero, heightOrZero, 0.0f, 4, null);
                }
                int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(placeable3);
                Placeable placeable10 = placeable5;
                if (placeable10 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, widthOrZero, heightOrZero2, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final void m2296ProvideTextStyleFromToken3JVO9M(long j, final TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        long j2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)520@20833L10,518@20747L142:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:518)");
            }
            j2 = j;
            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), typographyKeyTokens), function2, startRestartGroup, i2 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE);
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            j2 = j;
            function22 = function2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j3 = j2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
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

                public final void invoke(Composer composer2, int i3) {
                    ListItemKt.m2296ProvideTextStyleFromToken3JVO9M(j3, typographyKeyTokens, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    static {
        float f = 16;
        ListItemStartPadding = Dp.m6389constructorimpl(f);
        ListItemEndPadding = Dp.m6389constructorimpl(f);
        LeadingContentEndPadding = Dp.m6389constructorimpl(f);
        TrailingContentStartPadding = Dp.m6389constructorimpl(f);
    }
}
