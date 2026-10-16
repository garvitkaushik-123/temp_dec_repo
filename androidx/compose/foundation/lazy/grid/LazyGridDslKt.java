package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyGridDsl.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a%\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00106\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00107\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010;\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010<¨\u0006="}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", FirebaseAnalytics.Param.ITEMS, "T", "", C3040d4.h.W, "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        LazyGridState lazyGridState2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i6;
        int i7;
        Arrangement.Horizontal horizontal2;
        int i8;
        int i9;
        FlingBehavior flingBehavior2;
        boolean z4;
        Modifier modifier3;
        int i10;
        boolean z5;
        int i11;
        FlingBehavior flingBehavior3;
        int i12;
        Composer composer2;
        final Modifier modifier4;
        final LazyGridState lazyGridState3;
        final PaddingValues paddingValues3;
        final boolean z6;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)64@2980L23,70@3340L15,75@3468L71,74@3442L481:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    if (startRestartGroup.changed(lazyGridState2)) {
                        i15 = 256;
                        i3 |= i15;
                    }
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i15 = 128;
                i3 |= i15;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            if (startRestartGroup.changed(vertical2)) {
                                i14 = 131072;
                                i3 |= i14;
                            }
                        } else {
                            vertical2 = vertical;
                        }
                        i14 = 65536;
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                        i7 = 57344;
                        horizontal2 = horizontal;
                    } else {
                        i7 = 57344;
                        horizontal2 = horizontal;
                        if ((i & 3670016) == 0) {
                            i3 |= startRestartGroup.changed(horizontal2) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i13 = 8388608;
                            i3 |= i13;
                        }
                        i13 = 4194304;
                        i3 |= i13;
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & 1879048192) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            if ((i3 & 1533916891) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                        lazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                    }
                                    if (i4 != 0) {
                                        paddingValues2 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0));
                                    }
                                    boolean z8 = i5 == 0 ? z3 : false;
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i3 &= -458753;
                                        vertical2 = !z8 ? arrangement.getTop() : arrangement.getBottom();
                                    }
                                    if (i6 != 0) {
                                        horizontal2 = Arrangement.INSTANCE.getStart();
                                    }
                                    if ((i2 & 128) == 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                    }
                                    if (i9 == 0) {
                                        modifier3 = modifier2;
                                        z4 = true;
                                    } else {
                                        z4 = z2;
                                        modifier3 = modifier2;
                                    }
                                    i10 = 29360128;
                                    z5 = z8;
                                    i11 = 234881024;
                                    flingBehavior3 = flingBehavior2;
                                    i12 = 1879048192;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    boolean z9 = z3;
                                    modifier3 = modifier2;
                                    i10 = 29360128;
                                    z5 = z9;
                                    z4 = z2;
                                    i11 = 234881024;
                                    i12 = 1879048192;
                                    flingBehavior3 = flingBehavior;
                                }
                                Arrangement.Vertical vertical4 = vertical2;
                                LazyGridState lazyGridState4 = lazyGridState2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                                }
                                int i17 = i3 >> 3;
                                int i18 = i3 << 9;
                                composer2 = startRestartGroup;
                                PaddingValues paddingValues4 = paddingValues2;
                                Arrangement.Horizontal horizontal4 = horizontal2;
                                LazyGridKt.LazyGrid(modifier3, lazyGridState4, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17 & 896)), paddingValues4, z5, true, flingBehavior3, z4, vertical4, horizontal4, function1, composer2, (i11 & i18) | (i10 & i17) | (i17 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i17 & 112) | (i3 & 7168) | (i3 & i7) | (i17 & 3670016) | (i12 & i18), (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                lazyGridState3 = lazyGridState4;
                                paddingValues3 = paddingValues4;
                                z6 = z5;
                                flingBehavior4 = flingBehavior3;
                                z7 = z4;
                                vertical3 = vertical4;
                                horizontal3 = horizontal4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                composer2 = startRestartGroup;
                                modifier4 = modifier2;
                                lazyGridState3 = lazyGridState2;
                                paddingValues3 = paddingValues2;
                                horizontal3 = horizontal2;
                                z6 = z3;
                                vertical3 = vertical2;
                                flingBehavior4 = flingBehavior;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
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
                                        LazyGridDslKt.LazyVerticalGrid(GridCells.this, modifier4, lazyGridState3, paddingValues3, z6, vertical3, horizontal3, flingBehavior4, z7, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i9 == 0) {
                        }
                        i10 = 29360128;
                        z5 = z8;
                        i11 = 234881024;
                        flingBehavior3 = flingBehavior2;
                        i12 = 1879048192;
                        Arrangement.Vertical vertical42 = vertical2;
                        LazyGridState lazyGridState42 = lazyGridState2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i172 = i3 >> 3;
                        int i182 = i3 << 9;
                        composer2 = startRestartGroup;
                        PaddingValues paddingValues42 = paddingValues2;
                        Arrangement.Horizontal horizontal42 = horizontal2;
                        LazyGridKt.LazyGrid(modifier3, lazyGridState42, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i172 & 896)), paddingValues42, z5, true, flingBehavior3, z4, vertical42, horizontal42, function1, composer2, (i11 & i182) | (i10 & i172) | (i172 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i172 & 112) | (i3 & 7168) | (i3 & i7) | (i172 & 3670016) | (i12 & i182), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        lazyGridState3 = lazyGridState42;
                        paddingValues3 = paddingValues42;
                        z6 = z5;
                        flingBehavior4 = flingBehavior3;
                        z7 = z4;
                        vertical3 = vertical42;
                        horizontal3 = horizontal42;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i9 == 0) {
                    }
                    i10 = 29360128;
                    z5 = z8;
                    i11 = 234881024;
                    flingBehavior3 = flingBehavior2;
                    i12 = 1879048192;
                    Arrangement.Vertical vertical422 = vertical2;
                    LazyGridState lazyGridState422 = lazyGridState2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1722 = i3 >> 3;
                    int i1822 = i3 << 9;
                    composer2 = startRestartGroup;
                    PaddingValues paddingValues422 = paddingValues2;
                    Arrangement.Horizontal horizontal422 = horizontal2;
                    LazyGridKt.LazyGrid(modifier3, lazyGridState422, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1722 & 896)), paddingValues422, z5, true, flingBehavior3, z4, vertical422, horizontal422, function1, composer2, (i11 & i1822) | (i10 & i1722) | (i1722 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1722 & 112) | (i3 & 7168) | (i3 & i7) | (i1722 & 3670016) | (i12 & i1822), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    lazyGridState3 = lazyGridState422;
                    paddingValues3 = paddingValues422;
                    z6 = z5;
                    flingBehavior4 = flingBehavior3;
                    z7 = z4;
                    vertical3 = vertical422;
                    horizontal3 = horizontal422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((458752 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (i9 == 0) {
                }
                i10 = 29360128;
                z5 = z8;
                i11 = 234881024;
                flingBehavior3 = flingBehavior2;
                i12 = 1879048192;
                Arrangement.Vertical vertical4222 = vertical2;
                LazyGridState lazyGridState4222 = lazyGridState2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i17222 = i3 >> 3;
                int i18222 = i3 << 9;
                composer2 = startRestartGroup;
                PaddingValues paddingValues4222 = paddingValues2;
                Arrangement.Horizontal horizontal4222 = horizontal2;
                LazyGridKt.LazyGrid(modifier3, lazyGridState4222, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17222 & 896)), paddingValues4222, z5, true, flingBehavior3, z4, vertical4222, horizontal4222, function1, composer2, (i11 & i18222) | (i10 & i17222) | (i17222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i17222 & 112) | (i3 & 7168) | (i3 & i7) | (i17222 & 3670016) | (i12 & i18222), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                lazyGridState3 = lazyGridState4222;
                paddingValues3 = paddingValues4222;
                z6 = z5;
                flingBehavior4 = flingBehavior3;
                z7 = z4;
                vertical3 = vertical4222;
                horizontal3 = horizontal4222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((458752 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (i9 == 0) {
            }
            i10 = 29360128;
            z5 = z8;
            i11 = 234881024;
            flingBehavior3 = flingBehavior2;
            i12 = 1879048192;
            Arrangement.Vertical vertical42222 = vertical2;
            LazyGridState lazyGridState42222 = lazyGridState2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i172222 = i3 >> 3;
            int i182222 = i3 << 9;
            composer2 = startRestartGroup;
            PaddingValues paddingValues42222 = paddingValues2;
            Arrangement.Horizontal horizontal42222 = horizontal2;
            LazyGridKt.LazyGrid(modifier3, lazyGridState42222, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i172222 & 896)), paddingValues42222, z5, true, flingBehavior3, z4, vertical42222, horizontal42222, function1, composer2, (i11 & i182222) | (i10 & i172222) | (i172222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i172222 & 112) | (i3 & 7168) | (i3 & i7) | (i172222 & 3670016) | (i12 & i182222), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            lazyGridState3 = lazyGridState42222;
            paddingValues3 = paddingValues42222;
            z6 = z5;
            flingBehavior4 = flingBehavior3;
            z7 = z4;
            vertical3 = vertical42222;
            horizontal3 = horizontal42222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((458752 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (i9 == 0) {
        }
        i10 = 29360128;
        z5 = z8;
        i11 = 234881024;
        flingBehavior3 = flingBehavior2;
        i12 = 1879048192;
        Arrangement.Vertical vertical422222 = vertical2;
        LazyGridState lazyGridState422222 = lazyGridState2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1722222 = i3 >> 3;
        int i1822222 = i3 << 9;
        composer2 = startRestartGroup;
        PaddingValues paddingValues422222 = paddingValues2;
        Arrangement.Horizontal horizontal422222 = horizontal2;
        LazyGridKt.LazyGrid(modifier3, lazyGridState422222, rememberColumnWidthSums(gridCells, horizontal2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1722222 & 896)), paddingValues422222, z5, true, flingBehavior3, z4, vertical422222, horizontal422222, function1, composer2, (i11 & i1822222) | (i10 & i1722222) | (i1722222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1722222 & 112) | (i3 & 7168) | (i3 & i7) | (i1722222 & 3670016) | (i12 & i1822222), (i3 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        lazyGridState3 = lazyGridState422222;
        paddingValues3 = paddingValues422222;
        z6 = z5;
        flingBehavior4 = flingBehavior3;
        z7 = z4;
        vertical3 = vertical422222;
        horizontal3 = horizontal422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        LazyGridState lazyGridState2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Horizontal horizontal2;
        int i6;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        int i9;
        FlingBehavior flingBehavior2;
        FlingBehavior flingBehavior3;
        int i10;
        boolean z4;
        int i11;
        boolean z5;
        Modifier modifier3;
        Arrangement.Horizontal horizontal3;
        LazyGridState lazyGridState3;
        Composer composer2;
        final Modifier modifier4;
        final LazyGridState lazyGridState4;
        final PaddingValues paddingValues3;
        final boolean z6;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)117@5477L23,123@5834L15,128@5962L64,127@5936L475:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    if (startRestartGroup.changed(lazyGridState2)) {
                        i14 = 256;
                        i3 |= i14;
                    }
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i14 = 128;
                i3 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            horizontal2 = horizontal;
                            if (startRestartGroup.changed(horizontal2)) {
                                i13 = 131072;
                                i3 |= i13;
                            }
                        } else {
                            horizontal2 = horizontal;
                        }
                        i13 = 65536;
                        i3 |= i13;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                        i7 = 57344;
                        vertical2 = vertical;
                    } else {
                        i7 = 57344;
                        vertical2 = vertical;
                        if ((i & 3670016) == 0) {
                            i3 |= startRestartGroup.changed(vertical2) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i12 = 8388608;
                            i3 |= i12;
                        }
                        i12 = 4194304;
                        i3 |= i12;
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & 1879048192) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            if ((i3 & 1533916891) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i15 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                        lazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                    }
                                    if (i4 != 0) {
                                        paddingValues2 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0));
                                    }
                                    boolean z8 = i5 == 0 ? z3 : false;
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i3 &= -458753;
                                        horizontal2 = !z8 ? arrangement.getStart() : arrangement.getEnd();
                                    }
                                    if (i6 != 0) {
                                        vertical2 = Arrangement.INSTANCE.getTop();
                                    }
                                    if ((i2 & 128) == 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                    }
                                    if (i9 == 0) {
                                        flingBehavior3 = flingBehavior2;
                                        i10 = 234881024;
                                        z4 = z8;
                                        i11 = 29360128;
                                        modifier3 = modifier2;
                                        z5 = true;
                                    } else {
                                        flingBehavior3 = flingBehavior2;
                                        i10 = 234881024;
                                        z4 = z8;
                                        i11 = 29360128;
                                        z5 = z2;
                                        modifier3 = modifier2;
                                    }
                                    horizontal3 = horizontal2;
                                    lazyGridState3 = lazyGridState2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    z5 = z2;
                                    horizontal3 = horizontal2;
                                    i11 = 29360128;
                                    i10 = 234881024;
                                    flingBehavior3 = flingBehavior;
                                    lazyGridState3 = lazyGridState2;
                                    z4 = z3;
                                    modifier3 = modifier2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:126)");
                                }
                                int i16 = i3 >> 3;
                                composer2 = startRestartGroup;
                                PaddingValues paddingValues4 = paddingValues2;
                                Arrangement.Vertical vertical4 = vertical2;
                                LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i16 & 896)), paddingValues4, z4, false, flingBehavior3, z5, vertical4, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i16) | (i16 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i16 & 112) | (i3 & 7168) | (i3 & i7) | (i16 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                lazyGridState4 = lazyGridState3;
                                paddingValues3 = paddingValues4;
                                z6 = z4;
                                flingBehavior4 = flingBehavior3;
                                z7 = z5;
                                vertical3 = vertical4;
                                horizontal4 = horizontal3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                composer2 = startRestartGroup;
                                modifier4 = modifier2;
                                lazyGridState4 = lazyGridState2;
                                paddingValues3 = paddingValues2;
                                vertical3 = vertical2;
                                z6 = z3;
                                horizontal4 = horizontal2;
                                flingBehavior4 = flingBehavior;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
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

                                    public final void invoke(Composer composer3, int i17) {
                                        LazyGridDslKt.LazyHorizontalGrid(GridCells.this, modifier4, lazyGridState4, paddingValues3, z6, horizontal4, vertical3, flingBehavior4, z7, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i9 == 0) {
                        }
                        horizontal3 = horizontal2;
                        lazyGridState3 = lazyGridState2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i162 = i3 >> 3;
                        composer2 = startRestartGroup;
                        PaddingValues paddingValues42 = paddingValues2;
                        Arrangement.Vertical vertical42 = vertical2;
                        LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i162 & 896)), paddingValues42, z4, false, flingBehavior3, z5, vertical42, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i162) | (i162 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i162 & 112) | (i3 & 7168) | (i3 & i7) | (i162 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        lazyGridState4 = lazyGridState3;
                        paddingValues3 = paddingValues42;
                        z6 = z4;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        vertical3 = vertical42;
                        horizontal4 = horizontal3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i9 == 0) {
                    }
                    horizontal3 = horizontal2;
                    lazyGridState3 = lazyGridState2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1622 = i3 >> 3;
                    composer2 = startRestartGroup;
                    PaddingValues paddingValues422 = paddingValues2;
                    Arrangement.Vertical vertical422 = vertical2;
                    LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1622 & 896)), paddingValues422, z4, false, flingBehavior3, z5, vertical422, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i1622) | (i1622 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1622 & 112) | (i3 & 7168) | (i3 & i7) | (i1622 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    lazyGridState4 = lazyGridState3;
                    paddingValues3 = paddingValues422;
                    z6 = z4;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    vertical3 = vertical422;
                    horizontal4 = horizontal3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((458752 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i15 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (i9 == 0) {
                }
                horizontal3 = horizontal2;
                lazyGridState3 = lazyGridState2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i16222 = i3 >> 3;
                composer2 = startRestartGroup;
                PaddingValues paddingValues4222 = paddingValues2;
                Arrangement.Vertical vertical4222 = vertical2;
                LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i16222 & 896)), paddingValues4222, z4, false, flingBehavior3, z5, vertical4222, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i16222) | (i16222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i16222 & 112) | (i3 & 7168) | (i3 & i7) | (i16222 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                lazyGridState4 = lazyGridState3;
                paddingValues3 = paddingValues4222;
                z6 = z4;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                vertical3 = vertical4222;
                horizontal4 = horizontal3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((458752 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (i9 == 0) {
            }
            horizontal3 = horizontal2;
            lazyGridState3 = lazyGridState2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i162222 = i3 >> 3;
            composer2 = startRestartGroup;
            PaddingValues paddingValues42222 = paddingValues2;
            Arrangement.Vertical vertical42222 = vertical2;
            LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i162222 & 896)), paddingValues42222, z4, false, flingBehavior3, z5, vertical42222, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i162222) | (i162222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i162222 & 112) | (i3 & 7168) | (i3 & i7) | (i162222 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            lazyGridState4 = lazyGridState3;
            paddingValues3 = paddingValues42222;
            z6 = z4;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
            vertical3 = vertical42222;
            horizontal4 = horizontal3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((458752 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (i9 == 0) {
        }
        horizontal3 = horizontal2;
        lazyGridState3 = lazyGridState2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1622222 = i3 >> 3;
        composer2 = startRestartGroup;
        PaddingValues paddingValues422222 = paddingValues2;
        Arrangement.Vertical vertical422222 = vertical2;
        LazyGridKt.LazyGrid(modifier3, lazyGridState3, rememberRowHeightSums(gridCells, vertical2, paddingValues2, startRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1622222 & 896)), paddingValues422222, z4, false, flingBehavior3, z5, vertical422222, horizontal3, function1, composer2, (i10 & (i3 << 6)) | (i11 & i1622222) | (i1622222 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1622222 & 112) | (i3 & 7168) | (i3 & i7) | (i1622222 & 3670016) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        lazyGridState4 = lazyGridState3;
        paddingValues3 = paddingValues422222;
        z6 = z4;
        flingBehavior4 = flingBehavior3;
        z7 = z5;
        vertical3 = vertical422222;
        horizontal4 = horizontal3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(1632454918);
        ComposerKt.sourceInformation(composer, "C(rememberColumnWidthSums)P(!1,2)148@6622L975:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(gridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m1009invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m1009invoke0kLqBqw(Density density, long j) {
                    if (Constraints.m6345getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
                    }
                    int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j) - density.mo624roundToPx0680j_4(Dp.m6389constructorimpl(PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr)));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, m6345getMaxWidthimpl, density.mo624roundToPx0680j_4(horizontal2.getSpacing())));
                    int[] iArr = new int[intArray.length];
                    horizontal2.arrange(density, m6345getMaxWidthimpl, intArray, LayoutDirection.Ltr, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridSlotsProvider;
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-741512409);
        ComposerKt.sourceInformation(composer, "C(rememberRowHeightSums)P(1,2)181@7795L909:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-741512409, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:181)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(gridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m1010invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m1010invoke0kLqBqw(Density density, long j) {
                    if (Constraints.m6344getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
                    }
                    int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j) - density.mo624roundToPx0680j_4(Dp.m6389constructorimpl(PaddingValues.this.getTop() + PaddingValues.this.getBottom()));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Vertical vertical2 = vertical;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, m6344getMaxHeightimpl, density.mo624roundToPx0680j_4(vertical2.getSpacing())));
                    int[] iArr = new int[intArray.length];
                    vertical2.arrange(density, m6344getMaxHeightimpl, intArray, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyGridDslKt$items$1) obj2);
                }
            };
        }
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke((LazyGridDslKt$items$6) obj2);
                }
            };
        }
        lazyGridScope.items(objArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, objArr) : null, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(tArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, tArr) : null, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(objArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, objArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(tArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, tArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
