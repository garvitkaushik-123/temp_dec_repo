package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurementHelper.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\u0002\u0010\u0014J2\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020+H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002J0\u00108\u001a\u0002092\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b>\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020+2\u0006\u0010/\u001a\u000200J\n\u0010\n\u001a\u00020+*\u00020\u0013J\n\u0010F\u001a\u00020+*\u00020\u0013R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getCrossAxisPosition", "", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    public static final int $stable = 8;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> list, Placeable[] placeableArr) {
        this.orientation = layoutOrientation;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = list;
        this.placeables = placeableArr;
        int size = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name and from getter */
    public final float getArrangementSpacing() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    public final int crossAxisSize(Placeable placeable) {
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m908measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        long j;
        String str;
        String str2;
        float f;
        long j2;
        RowColumnMeasurementHelper rowColumnMeasurementHelper;
        int i;
        int coerceIn;
        long j3;
        String str3;
        int i2;
        long j4;
        float f2;
        String str4;
        int i3;
        int i4;
        int i5;
        int i6;
        float f3;
        int i7;
        int i8;
        int i9;
        long j5;
        int i10;
        int i11;
        long j6;
        int max;
        int i12;
        long j7;
        long j8;
        int i13 = endIndex;
        long m848constructorimpl = OrientationIndependentConstraints.m848constructorimpl(constraints, this.orientation);
        long j9 = measureScope.mo624roundToPx0680j_4(this.arrangementSpacing);
        int i14 = i13 - startIndex;
        int i15 = startIndex;
        int i16 = 0;
        float f4 = 0.0f;
        int i17 = 0;
        long j10 = 0;
        int i18 = 0;
        boolean z = false;
        while (true) {
            int i19 = Integer.MAX_VALUE;
            if (i15 >= i13) {
                break;
            }
            Measurable measurable = this.measurables.get(i15);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i15];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > 0.0f) {
                float f5 = f4 + weight;
                i12 = i16 + 1;
                i11 = i14;
                f3 = f5;
                i9 = i15;
                max = i17;
            } else {
                int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(m848constructorimpl);
                Placeable placeable = this.placeables[i15];
                if (placeable == null) {
                    if (m6345getMaxWidthimpl == Integer.MAX_VALUE) {
                        j7 = m848constructorimpl;
                        j8 = 0;
                    } else {
                        j7 = m848constructorimpl;
                        j8 = 0;
                        i19 = (int) RangesKt.coerceAtLeast(m6345getMaxWidthimpl - j10, 0L);
                    }
                    i9 = i15;
                    int i20 = i19;
                    i8 = m6345getMaxWidthimpl;
                    float f6 = f4;
                    i10 = i16;
                    i11 = i14;
                    f3 = f6;
                    i7 = i17;
                    j6 = j8;
                    m848constructorimpl = j7;
                    j5 = j10;
                    placeable = measurable.mo5333measureBRTryo0(OrientationIndependentConstraints.m861toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m850copyyUG9Ft0$default(m848constructorimpl, 0, i20, 0, 0, 8, null), this.orientation));
                } else {
                    f3 = f4;
                    i7 = i17;
                    i8 = m6345getMaxWidthimpl;
                    i9 = i15;
                    j5 = j10;
                    i10 = i16;
                    i11 = i14;
                    j6 = 0;
                }
                int min = Math.min((int) j9, (int) RangesKt.coerceAtLeast((i8 - j5) - mainAxisSize(placeable), j6));
                j10 = j5 + mainAxisSize(placeable) + min;
                max = Math.max(i7, crossAxisSize(placeable));
                z = z || RowColumnImplKt.isRelative(rowColumnParentData);
                this.placeables[i9] = placeable;
                i12 = i10;
                i18 = min;
            }
            i15 = i9 + 1;
            i14 = i11;
            i17 = max;
            i16 = i12;
            f4 = f3;
        }
        int i21 = i16;
        float f7 = f4;
        int i22 = i14;
        long j11 = j10;
        int i23 = i17;
        if (i21 == 0) {
            j = m848constructorimpl;
            i = i23;
            rowColumnMeasurementHelper = this;
            j3 = j11 - i18;
            coerceIn = 0;
        } else {
            int m6347getMinWidthimpl = (f7 <= 0.0f || Constraints.m6345getMaxWidthimpl(m848constructorimpl) == Integer.MAX_VALUE) ? Constraints.m6347getMinWidthimpl(m848constructorimpl) : Constraints.m6345getMaxWidthimpl(m848constructorimpl);
            long j12 = (i21 - 1) * j9;
            long coerceAtLeast = RangesKt.coerceAtLeast((m6347getMinWidthimpl - j11) - j12, 0L);
            float f8 = f7 > 0.0f ? coerceAtLeast / f7 : 0.0f;
            int i24 = startIndex;
            long j13 = coerceAtLeast;
            while (true) {
                j = m848constructorimpl;
                str = "arrangementSpacingTotal ";
                str2 = "fixedSpace ";
                f = f8;
                j2 = coerceAtLeast;
                if (i24 >= i13) {
                    break;
                }
                int i25 = i24;
                float weight2 = RowColumnImplKt.getWeight(this.rowColumnParentData[i25]);
                float f9 = f * weight2;
                try {
                    j13 -= MathKt.roundToInt(f9);
                    i24 = i25 + 1;
                    i13 = endIndex;
                    m848constructorimpl = j;
                    f8 = f;
                    coerceAtLeast = j2;
                } catch (IllegalArgumentException e) {
                    StringBuilder sb = new StringBuilder("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax ");
                    sb.append(Constraints.m6345getMaxWidthimpl(j)).append("mainAxisMin ").append(Constraints.m6347getMinWidthimpl(j)).append("targetSpace ").append(m6347getMinWidthimpl).append("arrangementSpacingPx ").append(j9).append("weightChildrenCount ").append(i21).append("fixedSpace ").append(j11).append("arrangementSpacingTotal ").append(j12).append("remainingToTarget ").append(j2).append("totalWeight ").append(f7).append("weightUnitSpace ").append(f).append("itemWeight ").append(weight2).append("weightedSize ");
                    sb.append(f9);
                    throw new IllegalArgumentException(sb.toString()).initCause(e);
                }
            }
            String str5 = "remainingToTarget ";
            long j14 = j11;
            float f10 = f7;
            int i26 = i23;
            int i27 = 0;
            int i28 = startIndex;
            while (i28 < endIndex) {
                int i29 = i27;
                if (this.placeables[i28] == null) {
                    Measurable measurable2 = this.measurables.get(i28);
                    i2 = i28;
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i2];
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int sign = MathKt.getSign(j13);
                    long j15 = j14;
                    j13 -= sign;
                    float f11 = f * weight3;
                    int max2 = Math.max(0, MathKt.roundToInt(f11) + sign);
                    try {
                        f2 = f11;
                        try {
                            str3 = str;
                            str4 = str2;
                            i3 = i21;
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            str3 = str;
                            str4 = str2;
                            i3 = i21;
                            StringBuilder sb2 = new StringBuilder("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ");
                            sb2.append(Constraints.m6345getMaxWidthimpl(j)).append("mainAxisMin ").append(Constraints.m6347getMinWidthimpl(j)).append("targetSpace ").append(m6347getMinWidthimpl).append("arrangementSpacingPx ").append(j9).append("weightChildrenCount ").append(i3).append(str4).append(j15).append(str3).append(j12).append(str5).append(j2).append("totalWeight ").append(f10).append("weightUnitSpace ").append(f).append("weight ").append(weight3).append("weightedSize ");
                            sb2.append(f2).append("remainderUnit ").append(sign).append("childMainAxisSize ").append(max2);
                            throw new IllegalArgumentException(sb2.toString()).initCause(e);
                        }
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        f2 = f11;
                    }
                    try {
                        Placeable mo5333measureBRTryo0 = measurable2.mo5333measureBRTryo0(OrientationIndependentConstraints.m861toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m846constructorimpl((!RowColumnImplKt.getFill(rowColumnParentData2) || max2 == Integer.MAX_VALUE) ? 0 : max2, max2, 0, Constraints.m6344getMaxHeightimpl(j)), this.orientation));
                        int mainAxisSize = i29 + mainAxisSize(mo5333measureBRTryo0);
                        i26 = Math.max(i26, crossAxisSize(mo5333measureBRTryo0));
                        z = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                        this.placeables[i2] = mo5333measureBRTryo0;
                        i29 = mainAxisSize;
                        j4 = j15;
                        i21 = i3;
                        str2 = str4;
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        StringBuilder sb22 = new StringBuilder("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ");
                        sb22.append(Constraints.m6345getMaxWidthimpl(j)).append("mainAxisMin ").append(Constraints.m6347getMinWidthimpl(j)).append("targetSpace ").append(m6347getMinWidthimpl).append("arrangementSpacingPx ").append(j9).append("weightChildrenCount ").append(i3).append(str4).append(j15).append(str3).append(j12).append(str5).append(j2).append("totalWeight ").append(f10).append("weightUnitSpace ").append(f).append("weight ").append(weight3).append("weightedSize ");
                        sb22.append(f2).append("remainderUnit ").append(sign).append("childMainAxisSize ").append(max2);
                        throw new IllegalArgumentException(sb22.toString()).initCause(e);
                    }
                } else {
                    str3 = str;
                    i2 = i28;
                    j4 = j14;
                }
                f10 = f10;
                str = str3;
                str5 = str5;
                long j16 = j4;
                i28 = i2 + 1;
                j14 = j16;
                i27 = i29;
            }
            long j17 = j14;
            rowColumnMeasurementHelper = this;
            i = i26;
            coerceIn = (int) RangesKt.coerceIn(i27 + j12, 0L, Constraints.m6345getMaxWidthimpl(j) - j17);
            j3 = j17;
        }
        if (z) {
            i4 = endIndex;
            int i30 = 0;
            i5 = 0;
            for (int i31 = startIndex; i31 < i4; i31++) {
                Placeable placeable2 = rowColumnMeasurementHelper.placeables[i31];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(rowColumnMeasurementHelper.rowColumnParentData[i31]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    Integer num = calculateAlignmentLinePosition$foundation_layout_release;
                    int intValue = num.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    i30 = Math.max(i30, intValue);
                    int crossAxisSize = rowColumnMeasurementHelper.crossAxisSize(placeable2);
                    int intValue2 = num.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = rowColumnMeasurementHelper.crossAxisSize(placeable2);
                    }
                    i5 = Math.max(i5, crossAxisSize - intValue2);
                }
            }
            i6 = i30;
        } else {
            i4 = endIndex;
            i5 = 0;
            i6 = 0;
        }
        int max3 = Math.max((int) RangesKt.coerceAtLeast(j3 + coerceIn, 0L), Constraints.m6347getMinWidthimpl(j));
        int max4 = (Constraints.m6344getMaxHeightimpl(j) == Integer.MAX_VALUE || rowColumnMeasurementHelper.crossAxisSize != SizeMode.Expand) ? Math.max(i, Math.max(Constraints.m6346getMinHeightimpl(j), i5 + i6)) : Constraints.m6344getMaxHeightimpl(j);
        int[] iArr = new int[i22];
        for (int i32 = 0; i32 < i22; i32++) {
            iArr[i32] = 0;
        }
        int[] iArr2 = new int[i22];
        for (int i33 = 0; i33 < i22; i33++) {
            Placeable placeable3 = rowColumnMeasurementHelper.placeables[i33 + startIndex];
            Intrinsics.checkNotNull(placeable3);
            iArr2[i33] = rowColumnMeasurementHelper.mainAxisSize(placeable3);
        }
        return new RowColumnMeasureHelperResult(max4, max3, startIndex, i4, i6, rowColumnMeasurementHelper.mainAxisPositions(max3, iArr2, iArr, measureScope));
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        if (this.orientation == LayoutOrientation.Vertical) {
            Arrangement.Vertical vertical = this.verticalArrangement;
            if (vertical == null) {
                throw new IllegalArgumentException("null verticalArrangement in Column".toString());
            }
            vertical.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
            return mainAxisPositions;
        }
        Arrangement.Horizontal horizontal = this.horizontalArrangement;
        if (horizontal == null) {
            throw new IllegalArgumentException("null horizontalArrangement in Row".toString());
        }
        horizontal.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment crossAxisAlignment;
        if (parentData == null || (crossAxisAlignment = parentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(crossAxisSize, layoutDirection, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        int endIndex = measureResult.getEndIndex();
        for (int startIndex = measureResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placeableScope, placeable, mainAxisPositions[startIndex - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placeableScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - measureResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }
}
