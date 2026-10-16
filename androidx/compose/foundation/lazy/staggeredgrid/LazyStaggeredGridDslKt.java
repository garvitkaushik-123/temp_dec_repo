package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0083\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010$\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00104\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00106\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010;\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", FirebaseAnalytics.Param.ITEMS, "T", "", C3040d4.h.W, "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1066LazyVerticalStaggeredGridzadm560(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        float f2;
        int i9;
        int i10;
        int i11;
        LazyStaggeredGridState lazyStaggeredGridState2;
        PaddingValues m872PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical m788spacedBy0680j_4;
        FlingBehavior flingBehavior2;
        LazyStaggeredGridState lazyStaggeredGridState3;
        float f3;
        FlingBehavior flingBehavior3;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final Arrangement.Horizontal horizontal2;
        final LazyStaggeredGridState lazyStaggeredGridState4;
        final Modifier modifier3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final FlingBehavior flingBehavior4;
        final boolean z6;
        final float f4;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1695323794);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)64@3068L32,69@3365L15,83@3878L67,73@3476L502:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i6 = i2 & 16;
                if (i6 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i8 = 57344;
                        f2 = f;
                    } else {
                        i8 = 57344;
                        f2 = f;
                        if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                    }
                    i9 = i2 & 64;
                    if (i9 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i3 |= startRestartGroup.changed(horizontal) ? 1048576 : 524288;
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i15 = 8388608;
                            i3 |= i15;
                        }
                        i15 = 4194304;
                        i3 |= i15;
                    }
                    i10 = i2 & 256;
                    if (i10 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i11 = i10;
                        i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((1879048192 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        }
                        if (i4 == 4 || (1533916891 & i3) != 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    lazyStaggeredGridState2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                                }
                                m872PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                float m6389constructorimpl = i7 != 0 ? Dp.m6389constructorimpl(0) : f2;
                                m788spacedBy0680j_4 = i9 != 0 ? Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(0)) : horizontal;
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    z4 = true;
                                    i13 = 29360128;
                                    lazyStaggeredGridState3 = lazyStaggeredGridState2;
                                    f3 = m6389constructorimpl;
                                    flingBehavior3 = flingBehavior2;
                                    i12 = 3670016;
                                    i14 = 1695323794;
                                    boolean z7 = z3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i14, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:72)");
                                    }
                                    int i17 = i3 >> 3;
                                    int i18 = i3 << 3;
                                    composer2 = startRestartGroup;
                                    Modifier modifier4 = modifier2;
                                    PaddingValues paddingValues4 = m872PaddingValues0680j_4;
                                    LazyStaggeredGridKt.m1071LazyStaggeredGridLJWHXA8(lazyStaggeredGridState3, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, m788spacedBy0680j_4, m872PaddingValues0680j_4, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17 & 896)), modifier4, paddingValues4, z7, flingBehavior3, z4, f3, m788spacedBy0680j_4.getSpacing(), function1, composer2, (i13 & i17) | (i12 & i17) | ((i3 << 6) & 7168) | 56 | (i18 & i8) | (i18 & 458752) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    horizontal2 = m788spacedBy0680j_4;
                                    lazyStaggeredGridState4 = lazyStaggeredGridState3;
                                    modifier3 = modifier4;
                                    paddingValues3 = paddingValues4;
                                    z5 = z7;
                                    flingBehavior4 = flingBehavior3;
                                    z6 = z4;
                                    f4 = f3;
                                } else {
                                    lazyStaggeredGridState3 = lazyStaggeredGridState2;
                                    f3 = m6389constructorimpl;
                                    flingBehavior3 = flingBehavior2;
                                    i12 = 3670016;
                                    i13 = 29360128;
                                    i14 = 1695323794;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if (i4 != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                m788spacedBy0680j_4 = horizontal;
                                flingBehavior3 = flingBehavior;
                                m872PaddingValues0680j_4 = paddingValues2;
                                f3 = f2;
                                i12 = 3670016;
                                i13 = 29360128;
                                i14 = 1695323794;
                                lazyStaggeredGridState3 = lazyStaggeredGridState;
                            }
                            z4 = z2;
                            boolean z72 = z3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i172 = i3 >> 3;
                            int i182 = i3 << 3;
                            composer2 = startRestartGroup;
                            Modifier modifier42 = modifier2;
                            PaddingValues paddingValues42 = m872PaddingValues0680j_4;
                            LazyStaggeredGridKt.m1071LazyStaggeredGridLJWHXA8(lazyStaggeredGridState3, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, m788spacedBy0680j_4, m872PaddingValues0680j_4, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i172 & 896)), modifier42, paddingValues42, z72, flingBehavior3, z4, f3, m788spacedBy0680j_4.getSpacing(), function1, composer2, (i13 & i172) | (i12 & i172) | ((i3 << 6) & 7168) | 56 | (i182 & i8) | (i182 & 458752) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            horizontal2 = m788spacedBy0680j_4;
                            lazyStaggeredGridState4 = lazyStaggeredGridState3;
                            modifier3 = modifier42;
                            paddingValues3 = paddingValues42;
                            z5 = z72;
                            flingBehavior4 = flingBehavior3;
                            z6 = z4;
                            f4 = f3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            lazyStaggeredGridState4 = lazyStaggeredGridState;
                            horizontal2 = horizontal;
                            flingBehavior4 = flingBehavior;
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            paddingValues3 = paddingValues2;
                            f4 = f2;
                            z5 = z3;
                            z6 = z2;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
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

                                public final void invoke(Composer composer3, int i19) {
                                    LazyStaggeredGridDslKt.m1066LazyVerticalStaggeredGridzadm560(StaggeredGridCells.this, modifier3, lazyStaggeredGridState4, paddingValues3, z5, f4, horizontal2, flingBehavior4, z6, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i11 = i10;
                    if ((i2 & 512) != 0) {
                    }
                    if (i4 == 4) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i11 != 0) {
                    }
                }
                z3 = z;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                i9 = i2 & 64;
                if (i9 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i2 & 512) != 0) {
                }
                if (i4 == 4) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i11 != 0) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            i9 = i2 & 64;
            if (i9 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i2 & 512) != 0) {
            }
            if (i4 == 4) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i11 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        i9 = i2 & 64;
        if (i9 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i2 & 512) != 0) {
        }
        if (i4 == 4) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i11 != 0) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1267076841);
        ComposerKt.sourceInformation(composer, "C(rememberColumnSlots)P(!1,2)94@4216L1114:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:94)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(staggeredGridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        LazyStaggeredGridSlotCache rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberColumnSlots$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m1067invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m1067invoke0kLqBqw(Density density, long j) {
                    if (Constraints.m6345getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
                    }
                    int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j) - density.mo624roundToPx0680j_4(Dp.m6389constructorimpl(PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr)));
                    StaggeredGridCells staggeredGridCells2 = staggeredGridCells;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] calculateCrossAxisCellSizes = staggeredGridCells2.calculateCrossAxisCellSizes(density, m6345getMaxWidthimpl, density.mo624roundToPx0680j_4(horizontal2.getSpacing()));
                    int[] iArr = new int[calculateCrossAxisCellSizes.length];
                    horizontal2.arrange(density, m6345getMaxWidthimpl, calculateCrossAxisCellSizes, LayoutDirection.Ltr, iArr);
                    return new LazyStaggeredGridSlots(iArr, calculateCrossAxisCellSizes);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1065LazyHorizontalStaggeredGridcJHQLPU(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        Arrangement.Vertical vertical2;
        int i9;
        int i10;
        int i11;
        LazyStaggeredGridState lazyStaggeredGridState2;
        PaddingValues m872PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical m788spacedBy0680j_4;
        FlingBehavior flingBehavior2;
        float f2;
        LazyStaggeredGridState lazyStaggeredGridState3;
        FlingBehavior flingBehavior3;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final Arrangement.Vertical vertical3;
        final LazyStaggeredGridState lazyStaggeredGridState4;
        final Modifier modifier3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final FlingBehavior flingBehavior4;
        final boolean z6;
        final float f3;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-8666074);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)154@6993L32,159@7288L15,173@7803L59,163@7399L496:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i6 = i2 & 16;
                if (i6 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i8 = 57344;
                        vertical2 = vertical;
                    } else {
                        i8 = 57344;
                        vertical2 = vertical;
                        if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changed(vertical2) ? 131072 : 65536;
                        }
                    }
                    i9 = i2 & 64;
                    if (i9 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i3 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i15 = 8388608;
                            i3 |= i15;
                        }
                        i15 = 4194304;
                        i3 |= i15;
                    }
                    i10 = i2 & 256;
                    if (i10 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i11 = i10;
                        i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((1879048192 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        }
                        if (i4 == 4 || (1533916891 & i3) != 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    lazyStaggeredGridState2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                                }
                                m872PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                m788spacedBy0680j_4 = i7 != 0 ? Arrangement.INSTANCE.m788spacedBy0680j_4(Dp.m6389constructorimpl(0)) : vertical2;
                                float m6389constructorimpl = i9 != 0 ? Dp.m6389constructorimpl(0) : f;
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i11 != 0) {
                                    f2 = m6389constructorimpl;
                                    lazyStaggeredGridState3 = lazyStaggeredGridState2;
                                    flingBehavior3 = flingBehavior2;
                                    i13 = 29360128;
                                    i14 = -8666074;
                                    z4 = true;
                                    i12 = 3670016;
                                    boolean z7 = z3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i14, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:162)");
                                    }
                                    int i17 = i3 >> 3;
                                    int i18 = i3 << 6;
                                    int i19 = i3 << 3;
                                    composer2 = startRestartGroup;
                                    Modifier modifier4 = modifier2;
                                    PaddingValues paddingValues4 = m872PaddingValues0680j_4;
                                    LazyStaggeredGridKt.m1071LazyStaggeredGridLJWHXA8(lazyStaggeredGridState3, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, m788spacedBy0680j_4, m872PaddingValues0680j_4, startRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i17 & 896)), modifier4, paddingValues4, z7, flingBehavior3, z4, f2, m788spacedBy0680j_4.getSpacing(), function1, composer2, (i18 & 7168) | 56 | (i19 & i8) | (i19 & 458752) | (i12 & i17) | (i17 & i13) | (i18 & 234881024), (i3 >> 27) & 14, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    vertical3 = m788spacedBy0680j_4;
                                    lazyStaggeredGridState4 = lazyStaggeredGridState3;
                                    modifier3 = modifier4;
                                    paddingValues3 = paddingValues4;
                                    z5 = z7;
                                    flingBehavior4 = flingBehavior3;
                                    z6 = z4;
                                    f3 = f2;
                                } else {
                                    f2 = m6389constructorimpl;
                                    lazyStaggeredGridState3 = lazyStaggeredGridState2;
                                    flingBehavior3 = flingBehavior2;
                                    i12 = 3670016;
                                    i13 = 29360128;
                                    i14 = -8666074;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if (i4 != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                f2 = f;
                                flingBehavior3 = flingBehavior;
                                m872PaddingValues0680j_4 = paddingValues2;
                                m788spacedBy0680j_4 = vertical2;
                                i12 = 3670016;
                                i13 = 29360128;
                                i14 = -8666074;
                                lazyStaggeredGridState3 = lazyStaggeredGridState;
                            }
                            z4 = z2;
                            boolean z72 = z3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i172 = i3 >> 3;
                            int i182 = i3 << 6;
                            int i192 = i3 << 3;
                            composer2 = startRestartGroup;
                            Modifier modifier42 = modifier2;
                            PaddingValues paddingValues42 = m872PaddingValues0680j_4;
                            LazyStaggeredGridKt.m1071LazyStaggeredGridLJWHXA8(lazyStaggeredGridState3, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, m788spacedBy0680j_4, m872PaddingValues0680j_4, startRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i172 & 896)), modifier42, paddingValues42, z72, flingBehavior3, z4, f2, m788spacedBy0680j_4.getSpacing(), function1, composer2, (i182 & 7168) | 56 | (i192 & i8) | (i192 & 458752) | (i12 & i172) | (i172 & i13) | (i182 & 234881024), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            vertical3 = m788spacedBy0680j_4;
                            lazyStaggeredGridState4 = lazyStaggeredGridState3;
                            modifier3 = modifier42;
                            paddingValues3 = paddingValues42;
                            z5 = z72;
                            flingBehavior4 = flingBehavior3;
                            z6 = z4;
                            f3 = f2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            lazyStaggeredGridState4 = lazyStaggeredGridState;
                            f3 = f;
                            flingBehavior4 = flingBehavior;
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            paddingValues3 = paddingValues2;
                            vertical3 = vertical2;
                            z5 = z3;
                            z6 = z2;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
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

                                public final void invoke(Composer composer3, int i20) {
                                    LazyStaggeredGridDslKt.m1065LazyHorizontalStaggeredGridcJHQLPU(StaggeredGridCells.this, modifier3, lazyStaggeredGridState4, paddingValues3, z5, vertical3, f3, flingBehavior4, z6, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i11 = i10;
                    if ((i2 & 512) != 0) {
                    }
                    if (i4 == 4) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i11 != 0) {
                    }
                }
                z3 = z;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                i9 = i2 & 64;
                if (i9 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i2 & 512) != 0) {
                }
                if (i4 == 4) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i11 != 0) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            i9 = i2 & 64;
            if (i9 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i2 & 512) != 0) {
            }
            if (i4 == 4) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i11 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        i9 = i2 & 64;
        if (i9 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i2 & 512) != 0) {
        }
        if (i4 == 4) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i11 != 0) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1532383053);
        ComposerKt.sourceInformation(composer, "C(rememberRowSlots)P(1,2)184@8120L940:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:184)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(staggeredGridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        LazyStaggeredGridSlotCache rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberRowSlots$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m1068invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m1068invoke0kLqBqw(Density density, long j) {
                    if (Constraints.m6344getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
                    }
                    int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j) - density.mo624roundToPx0680j_4(Dp.m6389constructorimpl(PaddingValues.this.getTop() + PaddingValues.this.getBottom()));
                    StaggeredGridCells staggeredGridCells2 = staggeredGridCells;
                    Arrangement.Vertical vertical2 = vertical;
                    int[] calculateCrossAxisCellSizes = staggeredGridCells2.calculateCrossAxisCellSizes(density, m6344getMaxHeightimpl, density.mo624roundToPx0680j_4(vertical2.getSpacing()));
                    int[] iArr = new int[calculateCrossAxisCellSizes.length];
                    vertical2.arrange(density, m6344getMaxHeightimpl, calculateCrossAxisCellSizes, iArr);
                    return new LazyStaggeredGridSlots(iArr, calculateCrossAxisCellSizes);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridStaggeredGridSlotsProvider;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyStaggeredGridDslKt$items$1) obj2);
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new LazyStaggeredGridDslKt$items$3(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new LazyStaggeredGridDslKt$items$3(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyStaggeredGridDslKt$items$6) obj2);
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, objArr) : null, new LazyStaggeredGridDslKt$items$8(function12, objArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, objArr) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(tArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, tArr) : null, new LazyStaggeredGridDslKt$items$8(function12, tArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, tArr) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, objArr) : null, new LazyStaggeredGridDslKt$itemsIndexed$8(function22, objArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, objArr) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(tArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr) : null, new LazyStaggeredGridDslKt$itemsIndexed$8(function22, tArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
