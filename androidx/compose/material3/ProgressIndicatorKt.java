package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframeBaseEntity;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.unity3d.services.UnityAdsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00108\u001aH\u00109\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a0\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a:\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a8\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aB\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010B\u001a6\u0010C\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a&\u0010K\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a6\u0010N\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010J\u001a>\u0010P\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a>\u0010S\u001a\u00020&*\u00020D2\u0006\u0010T\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a.\u0010X\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", VastAttributes.STROKE_COLOR, "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final Modifier IncreaseSemanticsBounds;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight;
    private static final float LinearIndicatorWidth;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float SemanticsBoundsPadding;
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARN: Removed duplicated region for block: B:100:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d0  */
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2406LinearProgressIndicator_5eSRE(final Function0<Float> function0, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        int i6;
        long j5;
        final long j6;
        final long j7;
        final int m2397getLinearStrokeCapKaPHkGw;
        boolean z;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        boolean z2;
        Object rememberedValue3;
        final int i7;
        final long j8;
        Composer startRestartGroup = composer.startRestartGroup(-1796992155);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)81@3829L11,82@3892L16,85@4010L31,89@4162L102,93@4334L196,86@4046L484:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? 256 : 128;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? 16384 : 8192;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            j5 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            j5 = j4;
                        }
                        if (i5 != 0) {
                            j6 = j3;
                            j7 = j5;
                            m2397getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw();
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1796992155, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:84)");
                            }
                            startRestartGroup.startReplaceableGroup(-1348540816);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            boolean z3 = true;
                            z = (i4 & 14) != 4;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final Function0 function02 = (Function0) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            Modifier then = modifier2.then(IncreaseSemanticsBounds);
                            startRestartGroup.startReplaceableGroup(-1348540664);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            changed = startRestartGroup.changed(function02);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function02.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier m930sizeVpY3zN4 = SizeKt.m930sizeVpY3zN4(SemanticsModifierKt.semantics(then, true, (Function1) rememberedValue2), LinearIndicatorWidth, LinearIndicatorHeight);
                            startRestartGroup.startReplaceableGroup(-1348540492);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            boolean changed2 = ((((i4 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j7)) || (i4 & 3072) == 2048) | ((57344 & i4) != 16384) | startRestartGroup.changed(function02);
                            if ((((i4 & 896) ^ 384) > 256 || !startRestartGroup.changed(j6)) && (i4 & 384) != 256) {
                                z3 = false;
                            }
                            z2 = changed2 | z3;
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!z2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                                        ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j7, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                        ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope, 0.0f, function02.invoke().floatValue(), j6, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m930sizeVpY3zN4, (Function1) rememberedValue3, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i7 = m2397getLinearStrokeCapKaPHkGw;
                            j8 = j6;
                        } else {
                            j6 = j3;
                            j7 = j5;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        j6 = j3;
                        j7 = j4;
                    }
                    m2397getLinearStrokeCapKaPHkGw = i6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-1348540816);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean z32 = true;
                    if ((i4 & 14) != 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final Function0<Float> function022 = (Function0) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    Modifier then2 = modifier2.then(IncreaseSemanticsBounds);
                    startRestartGroup.startReplaceableGroup(-1348540664);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    changed = startRestartGroup.changed(function022);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function022.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    Modifier m930sizeVpY3zN42 = SizeKt.m930sizeVpY3zN4(SemanticsModifierKt.semantics(then2, true, (Function1) rememberedValue2), LinearIndicatorWidth, LinearIndicatorHeight);
                    startRestartGroup.startReplaceableGroup(-1348540492);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean changed22 = ((((i4 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j7)) || (i4 & 3072) == 2048) | ((57344 & i4) != 16384) | startRestartGroup.changed(function022);
                    if (((i4 & 896) ^ 384) > 256) {
                    }
                    z32 = false;
                    z2 = changed22 | z32;
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z2) {
                    }
                    rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                            ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j7, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                            ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope, 0.0f, function022.invoke().floatValue(), j6, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m930sizeVpY3zN42, (Function1) rememberedValue3, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = m2397getLinearStrokeCapKaPHkGw;
                    j8 = j6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    i7 = i6;
                    j8 = j3;
                    j7 = j4;
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j9 = j7;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ProgressIndicatorKt.m2406LinearProgressIndicator_5eSRE(function0, modifier3, j8, j9, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01e0, code lost:
    
        if (r13.changed(r10) == false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00be  */
    /* renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2403LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        long j4;
        int i5;
        final Modifier.Companion companion;
        final int m2397getLinearStrokeCapKaPHkGw;
        int i6;
        long j5;
        long j6;
        long j7;
        boolean z;
        boolean changed;
        Object rememberedValue;
        final long j8;
        long j9;
        final int i7;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)118@5518L11,119@5581L16,122@5702L28,126@5984L320,137@6348L320,148@6713L324,159@7082L324,175@7581L660,170@7411L830:ProgressIndicator.kt#uh7d8r");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            j3 = j;
            i4 |= ((i3 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i2 & 384) == 0) {
            j4 = j2;
            i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        int i9 = i3 & 8;
        if (i9 != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i5 = i;
            i4 |= startRestartGroup.changed(i5) ? 2048 : 1024;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 2) != 0) {
                        j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                        i4 &= -897;
                    }
                    if (i9 != 0) {
                        m2397getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw();
                        i6 = i4;
                        j5 = j3;
                        j6 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-476865359, i6, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:121)");
                        }
                        InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                        long j12 = j6;
                        boolean z2 = true;
                        final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                                cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                                keyframesSpecConfig.using(at, cubicBezierEasing);
                                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 333);
                                cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                                keyframesSpecConfig.using(at, cubicBezierEasing);
                                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1183);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1000);
                                cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                                keyframesSpecConfig.using(at, cubicBezierEasing);
                                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1567);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                invoke2(keyframesSpecConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1267);
                                cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                                keyframesSpecConfig.using(at, cubicBezierEasing);
                                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1800);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        Modifier m930sizeVpY3zN4 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
                        startRestartGroup.startReplaceableGroup(-1348537245);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if (((i6 & 896) ^ 384) > 256) {
                            j7 = j12;
                        } else {
                            j7 = j12;
                        }
                        if ((i6 & 384) != 256) {
                            z = false;
                            boolean changed2 = ((i6 & 7168) != 2048) | z | startRestartGroup.changed(animateFloat) | startRestartGroup.changed(animateFloat2);
                            if ((((i6 & 112) ^ 48) > 32 || !startRestartGroup.changed(j5)) && (i6 & 48) != 32) {
                                z2 = false;
                            }
                            changed = changed2 | z2 | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat4);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                j8 = j5;
                                final long j13 = j7;
                                j9 = j13;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        DrawScope drawScope2;
                                        float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                                        ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j13, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                        if (animateFloat.getValue().floatValue() - animateFloat2.getValue().floatValue() > 0.0f) {
                                            drawScope2 = drawScope;
                                            ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat.getValue().floatValue(), animateFloat2.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                        } else {
                                            drawScope2 = drawScope;
                                        }
                                        if (animateFloat3.getValue().floatValue() - animateFloat4.getValue().floatValue() > 0.0f) {
                                            ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat3.getValue().floatValue(), animateFloat4.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                j8 = j5;
                                j9 = j7;
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m930sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i7 = m2397getLinearStrokeCapKaPHkGw;
                            j10 = j8;
                            j11 = j9;
                        }
                        z = true;
                        boolean changed22 = ((i6 & 7168) != 2048) | z | startRestartGroup.changed(animateFloat) | startRestartGroup.changed(animateFloat2);
                        if (((i6 & 112) ^ 48) > 32) {
                        }
                        z2 = false;
                        changed = changed22 | z2 | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        j8 = j5;
                        final long j132 = j7;
                        j9 = j132;
                        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawScope) {
                                DrawScope drawScope2;
                                float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                                ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j132, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                if (animateFloat.getValue().floatValue() - animateFloat2.getValue().floatValue() > 0.0f) {
                                    drawScope2 = drawScope;
                                    ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat.getValue().floatValue(), animateFloat2.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                } else {
                                    drawScope2 = drawScope;
                                }
                                if (animateFloat3.getValue().floatValue() - animateFloat4.getValue().floatValue() > 0.0f) {
                                    ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat3.getValue().floatValue(), animateFloat4.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(m930sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i7 = m2397getLinearStrokeCapKaPHkGw;
                        j10 = j8;
                        j11 = j9;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    companion = modifier2;
                }
                i6 = i4;
                j5 = j3;
                j6 = j4;
                m2397getLinearStrokeCapKaPHkGw = i5;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                long j122 = j6;
                boolean z22 = true;
                final State<Float> animateFloat5 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                        cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                        keyframesSpecConfig.using(at, cubicBezierEasing);
                        keyframesSpecConfig.at((Object) Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 333);
                        cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                        keyframesSpecConfig.using(at, cubicBezierEasing);
                        keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1183);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1000);
                        cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                        keyframesSpecConfig.using(at, cubicBezierEasing);
                        keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1567);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat42 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        invoke2(keyframesSpecConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1267);
                        cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                        keyframesSpecConfig.using(at, cubicBezierEasing);
                        keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1800);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier m930sizeVpY3zN42 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
                startRestartGroup.startReplaceableGroup(-1348537245);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                if (((i6 & 896) ^ 384) > 256) {
                }
                if ((i6 & 384) != 256) {
                }
                z = true;
                boolean changed222 = ((i6 & 7168) != 2048) | z | startRestartGroup.changed(animateFloat5) | startRestartGroup.changed(animateFloat22);
                if (((i6 & 112) ^ 48) > 32) {
                }
                z22 = false;
                changed = changed222 | z22 | startRestartGroup.changed(animateFloat32) | startRestartGroup.changed(animateFloat42);
                rememberedValue = startRestartGroup.rememberedValue();
                if (changed) {
                }
                j8 = j5;
                final long j1322 = j7;
                j9 = j1322;
                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        DrawScope drawScope2;
                        float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                        ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j1322, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                        if (animateFloat5.getValue().floatValue() - animateFloat22.getValue().floatValue() > 0.0f) {
                            drawScope2 = drawScope;
                            ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat5.getValue().floatValue(), animateFloat22.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                        } else {
                            drawScope2 = drawScope;
                        }
                        if (animateFloat32.getValue().floatValue() - animateFloat42.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat32.getValue().floatValue(), animateFloat42.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(m930sizeVpY3zN42, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                i7 = m2397getLinearStrokeCapKaPHkGw;
                j10 = j8;
                j11 = j9;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                j10 = j3;
                j11 = j4;
                i7 = i5;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        ProgressIndicatorKt.m2403LinearProgressIndicator2cYBFYY(Modifier.this, j10, j11, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        i5 = i;
        if ((i4 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i3 & 2) != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i9 != 0) {
        }
        i6 = i4;
        j5 = j3;
        j6 = j4;
        m2397getLinearStrokeCapKaPHkGw = i5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        InfiniteTransition rememberInfiniteTransition22 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
        long j1222 = j6;
        boolean z222 = true;
        final State<Float> animateFloat52 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat222 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 333);
                cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1183);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat322 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1000);
                cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1567);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat422 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 1267);
                cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(1.0f), 1800);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        Modifier m930sizeVpY3zN422 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
        startRestartGroup.startReplaceableGroup(-1348537245);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if (((i6 & 896) ^ 384) > 256) {
        }
        if ((i6 & 384) != 256) {
        }
        z = true;
        boolean changed2222 = ((i6 & 7168) != 2048) | z | startRestartGroup.changed(animateFloat52) | startRestartGroup.changed(animateFloat222);
        if (((i6 & 112) ^ 48) > 32) {
        }
        z222 = false;
        changed = changed2222 | z222 | startRestartGroup.changed(animateFloat322) | startRestartGroup.changed(animateFloat422);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        j8 = j5;
        final long j13222 = j7;
        j9 = j13222;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                DrawScope drawScope2;
                float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                ProgressIndicatorKt.m2418drawLinearIndicatorTrackAZGd3zU(drawScope, j13222, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                if (animateFloat52.getValue().floatValue() - animateFloat222.getValue().floatValue() > 0.0f) {
                    drawScope2 = drawScope;
                    ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat52.getValue().floatValue(), animateFloat222.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                } else {
                    drawScope2 = drawScope;
                }
                if (animateFloat322.getValue().floatValue() - animateFloat422.getValue().floatValue() > 0.0f) {
                    ProgressIndicatorKt.m2417drawLinearIndicatorqYKTg0g(drawScope2, animateFloat322.getValue().floatValue(), animateFloat422.getValue().floatValue(), j8, m3888getHeightimpl, m2397getLinearStrokeCapKaPHkGw);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m930sizeVpY3zN422, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        i7 = m2397getLinearStrokeCapKaPHkGw;
        j10 = j8;
        j11 = j9;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x005d  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2405LinearProgressIndicator_5eSRE(final float f, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        int i6;
        int m2397getLinearStrokeCapKaPHkGw;
        boolean z;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier3;
        final long j5;
        final long j6;
        final int i7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(905419617);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)213@8723L11,214@8786L16,217@8918L12,216@8878L155:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? 256 : 128;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? 16384 : 8192;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            m2397getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw();
                            long j7 = j4;
                            long j8 = j3;
                            Modifier modifier4 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(905419617, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:216)");
                            }
                            startRestartGroup.startReplaceableGroup(-1348535908);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            z = (i4 & 14) != 4;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(f);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            composer2 = startRestartGroup;
                            m2406LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier4, j8, j7, m2397getLinearStrokeCapKaPHkGw, composer2, i4 & 65520, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j5 = j8;
                            j6 = j7;
                            i7 = m2397getLinearStrokeCapKaPHkGw;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                    }
                    m2397getLinearStrokeCapKaPHkGw = i6;
                    long j72 = j4;
                    long j82 = j3;
                    Modifier modifier42 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-1348535908);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i4 & 14) != 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(f);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    composer2 = startRestartGroup;
                    m2406LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier42, j82, j72, m2397getLinearStrokeCapKaPHkGw, composer2, i4 & 65520, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    j5 = j82;
                    j6 = j72;
                    i7 = m2397getLinearStrokeCapKaPHkGw;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    j5 = j3;
                    j6 = j4;
                    i7 = i6;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            ProgressIndicatorKt.m2405LinearProgressIndicator_5eSRE(f, modifier3, j5, j6, i7, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            m2397getLinearStrokeCapKaPHkGw = i6;
            long j722 = j4;
            long j822 = j3;
            Modifier modifier422 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1348535908);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i4 & 14) != 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(f);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            m2406LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier422, j822, j722, m2397getLinearStrokeCapKaPHkGw, composer2, i4 & 65520, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            j5 = j822;
            j6 = j722;
            i7 = m2397getLinearStrokeCapKaPHkGw;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        m2397getLinearStrokeCapKaPHkGw = i6;
        long j7222 = j4;
        long j8222 = j3;
        Modifier modifier4222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1348535908);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i4 & 14) != 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(f);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        composer2 = startRestartGroup;
        m2406LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier4222, j8222, j7222, m2397getLinearStrokeCapKaPHkGw, composer2, i4 & 65520, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        j5 = j8222;
        j6 = j7222;
        i7 = m2397getLinearStrokeCapKaPHkGw;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0060  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2407LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        float f2;
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        long j5;
        long j6;
        Modifier modifier3;
        long j7;
        final Modifier modifier4;
        final long j8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)230@9286L11,231@9349L16,232@9371L140:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(f2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i4 = 256;
                        i3 |= i4;
                    }
                } else {
                    j3 = j;
                }
                i4 = 128;
                i3 |= i4;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) == 0) {
                        j5 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        j5 = j3;
                    }
                    if ((i2 & 8) == 0) {
                        i3 &= -7169;
                        modifier3 = companion;
                        j7 = j5;
                        j6 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    } else {
                        j6 = j4;
                        modifier3 = companion;
                        j7 = j5;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    j6 = j4;
                    modifier3 = modifier2;
                    j7 = j3;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-372717133, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:232)");
                }
                m2405LinearProgressIndicator_5eSRE(f2, modifier3, j7, j6, ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                j8 = j7;
                j9 = j6;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                j8 = j3;
                j9 = j4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ProgressIndicatorKt.m2407LinearProgressIndicatoreaDK9VM(f, modifier4, j8, j9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2405LinearProgressIndicator_5eSRE(f2, modifier3, j7, j6, ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j8 = j7;
        j9 = j6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m2404LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        long j5;
        Modifier modifier3;
        final Modifier modifier4;
        final long j6;
        final long j7;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)244@9718L11,245@9781L16,246@9803L126:ProgressIndicator.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            j6 = j3;
            j7 = j4;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
                j5 = j4;
                modifier3 = companion;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j5 = j4;
                modifier3 = modifier2;
            }
            long j8 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:246)");
            }
            m2403LinearProgressIndicator2cYBFYY(modifier3, j8, j5, ProgressIndicatorDefaults.INSTANCE.m2397getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            j6 = j8;
            j7 = j5;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    ProgressIndicatorKt.m2404LinearProgressIndicatorRIQooxk(Modifier.this, j6, j7, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m2417drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc());
        float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
        float f4 = 2;
        float f5 = m3888getHeightimpl / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * m3891getWidthimpl;
        float f7 = (z ? f2 : 1.0f - f) * m3891getWidthimpl;
        if (StrokeCap.m4411equalsimpl0(i, StrokeCap.INSTANCE.m4415getButtKaPHkGw()) || m3888getHeightimpl > m3891getWidthimpl) {
            DrawScope.m4599drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(f8, m3891getWidthimpl - f8);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m4599drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-AZGd3zU, reason: not valid java name */
    public static final void m2418drawLinearIndicatorTrackAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m2417drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ef  */
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2399CircularProgressIndicatorDUhRLBM(final Function0<Float> function0, Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        float f2;
        long j4;
        int i6;
        int i7;
        int m2394getCircularDeterminateStrokeCapKaPHkGw;
        boolean z;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-761680467);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)348@14143L13,350@14277L18,353@14410L31,*354@14477L7,359@14631L102,363@14785L243,357@14558L470:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? 256 : 128;
            } else {
                j3 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    j4 = j2;
                    i4 |= ((i3 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    if ((i4 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                f2 = ProgressIndicatorDefaults.INSTANCE.m2396getCircularStrokeWidthD9Ej5fM();
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                j4 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                m2394getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2394getCircularDeterminateStrokeCapKaPHkGw();
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-761680467, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:352)");
                                }
                                startRestartGroup.startReplaceableGroup(821866314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                                z = (i4 & 14) == 4;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final Function0 function02 = (Function0) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Stroke stroke = new Stroke(((Density) consume).mo630toPx0680j_4(f2), 0.0f, m2394getCircularDeterminateStrokeCapKaPHkGw, 0, null, 26, null);
                                startRestartGroup.startReplaceableGroup(821866535);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                                changed = startRestartGroup.changed(function02);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function02.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2), CircularIndicatorDiameter);
                                startRestartGroup.startReplaceableGroup(821866689);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                                changed2 = startRestartGroup.changed(function02) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    final long j5 = j4;
                                    final long j6 = j3;
                                    rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                            invoke2(drawScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DrawScope drawScope) {
                                            float floatValue = function02.invoke().floatValue() * 360.0f;
                                            ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j5, stroke);
                                            ProgressIndicatorKt.m2415drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j6, stroke);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                CanvasKt.Canvas(m928size3ABfNKs, (Function1) rememberedValue3, startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(821866314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final Function0<Float> function022 = (Function0) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Stroke stroke2 = new Stroke(((Density) consume2).mo630toPx0680j_4(f2), 0.0f, m2394getCircularDeterminateStrokeCapKaPHkGw, 0, null, 26, null);
                        startRestartGroup.startReplaceableGroup(821866535);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        changed = startRestartGroup.changed(function022);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function022.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        Modifier m928size3ABfNKs2 = SizeKt.m928size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2), CircularIndicatorDiameter);
                        startRestartGroup.startReplaceableGroup(821866689);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        changed2 = startRestartGroup.changed(function022) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke2) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        final long j52 = j4;
                        final long j62 = j3;
                        rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawScope) {
                                float floatValue = function022.invoke().floatValue() * 360.0f;
                                ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j52, stroke2);
                                ProgressIndicatorKt.m2415drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j62, stroke2);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(m928size3ABfNKs2, (Function1) rememberedValue3, startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
                    }
                    final long j7 = j3;
                    final float f3 = f2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final long j8 = j4;
                        final int i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                ProgressIndicatorKt.m2399CircularProgressIndicatorDUhRLBM(function0, modifier3, j7, f3, j8, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i;
                if ((i4 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(821866314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i4 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                final Function0<Float> function0222 = (Function0) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Stroke stroke22 = new Stroke(((Density) consume22).mo630toPx0680j_4(f2), 0.0f, m2394getCircularDeterminateStrokeCapKaPHkGw, 0, null, 26, null);
                startRestartGroup.startReplaceableGroup(821866535);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                changed = startRestartGroup.changed(function0222);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function0222.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                Modifier m928size3ABfNKs22 = SizeKt.m928size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2), CircularIndicatorDiameter);
                startRestartGroup.startReplaceableGroup(821866689);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                changed2 = startRestartGroup.changed(function0222) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke22) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                final long j522 = j4;
                final long j622 = j3;
                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        float floatValue = function0222.invoke().floatValue() * 360.0f;
                        ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j522, stroke22);
                        ProgressIndicatorKt.m2415drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j622, stroke22);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(m928size3ABfNKs22, (Function1) rememberedValue3, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                final long j72 = j3;
                final float f32 = f2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            if ((i4 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(821866314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i4 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            final Function0<Float> function02222 = (Function0) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Stroke stroke222 = new Stroke(((Density) consume222).mo630toPx0680j_4(f2), 0.0f, m2394getCircularDeterminateStrokeCapKaPHkGw, 0, null, 26, null);
            startRestartGroup.startReplaceableGroup(821866535);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            changed = startRestartGroup.changed(function02222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function02222.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            Modifier m928size3ABfNKs222 = SizeKt.m928size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2), CircularIndicatorDiameter);
            startRestartGroup.startReplaceableGroup(821866689);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            changed2 = startRestartGroup.changed(function02222) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke222) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            final long j5222 = j4;
            final long j6222 = j3;
            rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    float floatValue = function02222.invoke().floatValue() * 360.0f;
                    ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j5222, stroke222);
                    ProgressIndicatorKt.m2415drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j6222, stroke222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m928size3ABfNKs222, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            final long j722 = j3;
            final float f322 = f2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f2 = f;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        if ((i4 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(821866314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i4 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(RangesKt.coerceIn(function0.invoke().floatValue(), 0.0f, 1.0f));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        final Function0<Float> function022222 = (Function0) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Stroke stroke2222 = new Stroke(((Density) consume2222).mo630toPx0680j_4(f2), 0.0f, m2394getCircularDeterminateStrokeCapKaPHkGw, 0, null, 26, null);
        startRestartGroup.startReplaceableGroup(821866535);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        changed = startRestartGroup.changed(function022222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function022222.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        Modifier m928size3ABfNKs2222 = SizeKt.m928size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue2), CircularIndicatorDiameter);
        startRestartGroup.startReplaceableGroup(821866689);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        changed2 = startRestartGroup.changed(function022222) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke2222) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        final long j52222 = j4;
        final long j62222 = j3;
        rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                float floatValue = function022222.invoke().floatValue() * 360.0f;
                ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j52222, stroke2222);
                ProgressIndicatorKt.m2415drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j62222, stroke2222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m928size3ABfNKs2222, (Function1) rememberedValue3, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j7222 = j3;
        final float f3222 = f2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0083  */
    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2400CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        float f2;
        long j4;
        int i5;
        int i6;
        Modifier.Companion companion;
        int m2395getCircularIndeterminateStrokeCapKaPHkGw;
        int i7;
        long j5;
        long j6;
        boolean z;
        Object rememberedValue;
        final long j7;
        final long j8;
        final long j9;
        final float f3;
        final long j10;
        final int i8;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)391@16088L13,393@16222L18,*396@16366L7,400@16465L28,402@16622L278,414@17014L230,425@17361L346,436@17740L355,451@18209L628,447@18100L737:ProgressIndicator.kt#uh7d8r");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            j3 = j;
            i4 |= ((i3 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        int i10 = i3 & 4;
        if (i10 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? 256 : 128;
            if ((i2 & 3072) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? 16384 : 8192;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                            i4 &= -113;
                        }
                        if (i10 != 0) {
                            f2 = ProgressIndicatorDefaults.INSTANCE.m2396getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                            j4 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                        }
                        if (i5 != 0) {
                            m2395getCircularIndeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2395getCircularIndeterminateStrokeCapKaPHkGw();
                            i7 = i4;
                            j5 = j3;
                            final float f4 = f2;
                            j6 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-115871647, i7, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:395)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Stroke stroke = new Stroke(((Density) consume).mo630toPx0680j_4(f4), 0.0f, m2395getCircularIndeterminateStrokeCapKaPHkGw, 0, null, 26, null);
                            int i11 = m2395getCircularIndeterminateStrokeCapKaPHkGw;
                            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                            Modifier modifier4 = companion;
                            boolean z2 = true;
                            final State animateValue = InfiniteTransitionKt.animateValue(rememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                            final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    invoke2(keyframesSpecConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(at, cubicBezierEasing);
                                    keyframesSpecConfig.at((Object) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    invoke2(keyframesSpecConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(at, cubicBezierEasing);
                                    keyframesSpecConfig.at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier4), CircularIndicatorDiameter);
                            startRestartGroup.startReplaceableGroup(821870113);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            boolean changedInstance = ((i7 & 896) != 256) | ((((i7 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j6)) || (i7 & 3072) == 2048) | startRestartGroup.changedInstance(stroke) | startRestartGroup.changed(animateValue) | startRestartGroup.changed(animateFloat2) | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat);
                            if ((((i7 & 112) ^ 48) > 32 || !startRestartGroup.changed(j5)) && (i7 & 48) != 32) {
                                z2 = false;
                            }
                            z = changedInstance | z2;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                j7 = j5;
                                j8 = j6;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j8, stroke);
                                        ProgressIndicatorKt.m2416drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat3.getValue().floatValue() + (((animateValue.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat.getValue().floatValue(), f4, Math.abs(animateFloat2.getValue().floatValue() - animateFloat3.getValue().floatValue()), j7, stroke);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                j7 = j5;
                                j8 = j6;
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m928size3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j9 = j8;
                            f3 = f4;
                            j10 = j7;
                            i8 = i11;
                            modifier3 = modifier4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        companion = modifier2;
                    }
                    i7 = i4;
                    m2395getCircularIndeterminateStrokeCapKaPHkGw = i6;
                    j5 = j3;
                    final float f42 = f2;
                    j6 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Stroke stroke2 = new Stroke(((Density) consume2).mo630toPx0680j_4(f42), 0.0f, m2395getCircularIndeterminateStrokeCapKaPHkGw, 0, null, 26, null);
                    int i112 = m2395getCircularIndeterminateStrokeCapKaPHkGw;
                    InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                    Modifier modifier42 = companion;
                    boolean z22 = true;
                    final State<Integer> animateValue2 = InfiniteTransitionKt.animateValue(rememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                    final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((Object) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier m928size3ABfNKs2 = SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier42), CircularIndicatorDiameter);
                    startRestartGroup.startReplaceableGroup(821870113);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean changedInstance2 = ((i7 & 896) != 256) | ((((i7 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j6)) || (i7 & 3072) == 2048) | startRestartGroup.changedInstance(stroke2) | startRestartGroup.changed(animateValue2) | startRestartGroup.changed(animateFloat22) | startRestartGroup.changed(animateFloat32) | startRestartGroup.changed(animateFloat4);
                    if (((i7 & 112) ^ 48) > 32) {
                    }
                    z22 = false;
                    z = changedInstance2 | z22;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (z) {
                    }
                    j7 = j5;
                    j8 = j6;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j8, stroke2);
                            ProgressIndicatorKt.m2416drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat32.getValue().floatValue() + (((animateValue2.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat4.getValue().floatValue(), f42, Math.abs(animateFloat22.getValue().floatValue() - animateFloat32.getValue().floatValue()), j7, stroke2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m928size3ABfNKs2, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j9 = j8;
                    f3 = f42;
                    j10 = j7;
                    i8 = i112;
                    modifier3 = modifier42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    i8 = i6;
                    j10 = j3;
                    f3 = f2;
                    j9 = j4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i12) {
                            ProgressIndicatorKt.m2400CircularProgressIndicatorLxG7B9w(Modifier.this, j10, f3, j9, i8, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 2) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            i7 = i4;
            m2395getCircularIndeterminateStrokeCapKaPHkGw = i6;
            j5 = j3;
            final float f422 = f2;
            j6 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(localDensity22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Stroke stroke22 = new Stroke(((Density) consume22).mo630toPx0680j_4(f422), 0.0f, m2395getCircularIndeterminateStrokeCapKaPHkGw, 0, null, 26, null);
            int i1122 = m2395getCircularIndeterminateStrokeCapKaPHkGw;
            InfiniteTransition rememberInfiniteTransition22 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
            Modifier modifier422 = companion;
            boolean z222 = true;
            final State<Integer> animateValue22 = InfiniteTransitionKt.animateValue(rememberInfiniteTransition22, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
            final State<Float> animateFloat42 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> animateFloat222 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1332);
                    KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((Object) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> animateFloat322 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1332);
                    KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier m928size3ABfNKs22 = SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier422), CircularIndicatorDiameter);
            startRestartGroup.startReplaceableGroup(821870113);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean changedInstance22 = ((i7 & 896) != 256) | ((((i7 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j6)) || (i7 & 3072) == 2048) | startRestartGroup.changedInstance(stroke22) | startRestartGroup.changed(animateValue22) | startRestartGroup.changed(animateFloat222) | startRestartGroup.changed(animateFloat322) | startRestartGroup.changed(animateFloat42);
            if (((i7 & 112) ^ 48) > 32) {
            }
            z222 = false;
            z = changedInstance22 | z222;
            rememberedValue = startRestartGroup.rememberedValue();
            if (z) {
            }
            j7 = j5;
            j8 = j6;
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j8, stroke22);
                    ProgressIndicatorKt.m2416drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat322.getValue().floatValue() + (((animateValue22.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat42.getValue().floatValue(), f422, Math.abs(animateFloat222.getValue().floatValue() - animateFloat322.getValue().floatValue()), j7, stroke22);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m928size3ABfNKs22, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j9 = j8;
            f3 = f422;
            j10 = j7;
            i8 = i1122;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 2) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        i7 = i4;
        m2395getCircularIndeterminateStrokeCapKaPHkGw = i6;
        j5 = j3;
        final float f4222 = f2;
        j6 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(localDensity222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Stroke stroke222 = new Stroke(((Density) consume222).mo630toPx0680j_4(f4222), 0.0f, m2395getCircularIndeterminateStrokeCapKaPHkGw, 0, null, 26, null);
        int i11222 = m2395getCircularIndeterminateStrokeCapKaPHkGw;
        InfiniteTransition rememberInfiniteTransition222 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
        Modifier modifier4222 = companion;
        boolean z2222 = true;
        final State<Integer> animateValue222 = InfiniteTransitionKt.animateValue(rememberInfiniteTransition222, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
        final State<Float> animateFloat422 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition222, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat2222 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition222, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1332);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), 0);
                cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat3222 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition222, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                invoke2(keyframesSpecConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1332);
                KeyframeBaseEntity at = keyframesSpecConfig.at((Object) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                keyframesSpecConfig.using(at, cubicBezierEasing);
                keyframesSpecConfig.at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        Modifier m928size3ABfNKs222 = SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier4222), CircularIndicatorDiameter);
        startRestartGroup.startReplaceableGroup(821870113);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        boolean changedInstance222 = ((i7 & 896) != 256) | ((((i7 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j6)) || (i7 & 3072) == 2048) | startRestartGroup.changedInstance(stroke222) | startRestartGroup.changed(animateValue222) | startRestartGroup.changed(animateFloat2222) | startRestartGroup.changed(animateFloat3222) | startRestartGroup.changed(animateFloat422);
        if (((i7 & 112) ^ 48) > 32) {
        }
        z2222 = false;
        z = changedInstance222 | z2222;
        rememberedValue = startRestartGroup.rememberedValue();
        if (z) {
        }
        j7 = j5;
        j8 = j6;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                ProgressIndicatorKt.m2414drawCircularIndicatorTrackbw27NRU(drawScope, j8, stroke222);
                ProgressIndicatorKt.m2416drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat3222.getValue().floatValue() + (((animateValue222.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat422.getValue().floatValue(), f4222, Math.abs(animateFloat2222.getValue().floatValue() - animateFloat3222.getValue().floatValue()), j7, stroke222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m928size3ABfNKs222, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j9 = j8;
        f3 = f4222;
        j10 = j7;
        i8 = i11222;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0067  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2398CircularProgressIndicatorDUhRLBM(final float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        float f3;
        long j4;
        int i6;
        int i7;
        int m2394getCircularDeterminateStrokeCapKaPHkGw;
        float f4;
        long j5;
        int i8;
        Modifier modifier3;
        boolean z;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier4;
        final long j6;
        final float f5;
        final long j7;
        final int i9;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)487@19401L13,489@19535L18,492@19684L12,491@19642L188:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = 256;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = 128;
                i4 |= i11;
            } else {
                j3 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                f3 = f2;
                i4 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i10 = 16384;
                            i4 |= i10;
                        }
                    } else {
                        j4 = j2;
                    }
                    i10 = 8192;
                    i4 |= i10;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    if ((i4 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                f3 = ProgressIndicatorDefaults.INSTANCE.m2396getCircularStrokeWidthD9Ej5fM();
                            }
                            if ((i3 & 16) != 0) {
                                j4 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                                i4 &= -57345;
                            }
                            if (i6 != 0) {
                                m2394getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2394getCircularDeterminateStrokeCapKaPHkGw();
                                f4 = f3;
                                j5 = j4;
                                i8 = -1472321743;
                                modifier3 = modifier2;
                                long j8 = j3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:491)");
                                }
                                startRestartGroup.startReplaceableGroup(821871588);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                                z = (i4 & 14) == 4;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(f);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                composer2 = startRestartGroup;
                                m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier3, j8, f4, j5, m2394getCircularDeterminateStrokeCapKaPHkGw, composer2, i4 & 524272, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                j6 = j8;
                                f5 = f4;
                                j7 = j5;
                                i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        f4 = f3;
                        m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
                        i8 = -1472321743;
                        modifier3 = modifier2;
                        j5 = j4;
                        long j82 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(821871588);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(f);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        composer2 = startRestartGroup;
                        m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier3, j82, f4, j5, m2394getCircularDeterminateStrokeCapKaPHkGw, composer2, i4 & 524272, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        j6 = j82;
                        f5 = f4;
                        j7 = j5;
                        i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j6 = j3;
                        f5 = f3;
                        j7 = j4;
                        i9 = i7;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ProgressIndicatorKt.m2398CircularProgressIndicatorDUhRLBM(f, modifier4, j6, f5, j7, i9, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i;
                if ((i4 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                f4 = f3;
                m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
                i8 = -1472321743;
                modifier3 = modifier2;
                j5 = j4;
                long j822 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(821871588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i4 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(f);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier3, j822, f4, j5, m2394getCircularDeterminateStrokeCapKaPHkGw, composer2, i4 & 524272, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j6 = j822;
                f5 = f4;
                j7 = j5;
                i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f3 = f2;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            if ((i4 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            f4 = f3;
            m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
            i8 = -1472321743;
            modifier3 = modifier2;
            j5 = j4;
            long j8222 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(821871588);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i4 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(f);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier3, j8222, f4, j5, m2394getCircularDeterminateStrokeCapKaPHkGw, composer2, i4 & 524272, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j6 = j8222;
            f5 = f4;
            j7 = j5;
            i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f3 = f2;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        if ((i4 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        f4 = f3;
        m2394getCircularDeterminateStrokeCapKaPHkGw = i7;
        i8 = -1472321743;
        modifier3 = modifier2;
        j5 = j4;
        long j82222 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(821871588);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i4 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(f);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        composer2 = startRestartGroup;
        m2399CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier3, j82222, f4, j5, m2394getCircularDeterminateStrokeCapKaPHkGw, composer2, i4 & 524272, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j6 = j82222;
        f5 = f4;
        j7 = j5;
        i9 = m2394getCircularDeterminateStrokeCapKaPHkGw;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0061  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2401CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        float f3;
        int i3;
        Modifier modifier2;
        long j2;
        int i4;
        float f4;
        float m2396getCircularStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier3;
        final Modifier modifier4;
        final long j4;
        final float f5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)506@20085L13,513@20298L18,508@20172L219:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f3 = f;
        } else if ((i & 6) == 0) {
            f3 = f;
            i3 = (startRestartGroup.changed(f3) ? 4 : 2) | i;
        } else {
            f3 = f;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                f4 = f2;
                i3 |= startRestartGroup.changed(f4) ? 2048 : 1024;
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            j2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                            i3 &= -897;
                        }
                        m2396getCircularStrokeWidthD9Ej5fM = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2396getCircularStrokeWidthD9Ej5fM() : f4;
                        j3 = j2;
                        modifier3 = companion;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier3 = modifier2;
                        m2396getCircularStrokeWidthD9Ej5fM = f4;
                        j3 = j2;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402841196, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:508)");
                    }
                    float f6 = m2396getCircularStrokeWidthD9Ej5fM;
                    m2398CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, f6, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2394getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    j4 = j3;
                    f5 = f6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    j4 = j2;
                    f5 = f4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            ProgressIndicatorKt.m2401CircularProgressIndicatorMBs18nI(f, modifier4, j4, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f4 = f2;
            if ((i3 & 1171) == 1170) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            j3 = j2;
            modifier3 = companion;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f62 = m2396getCircularStrokeWidthD9Ej5fM;
            m2398CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, f62, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2394getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j4 = j3;
            f5 = f62;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        f4 = f2;
        if ((i3 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        j3 = j2;
        modifier3 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        float f622 = m2396getCircularStrokeWidthD9Ej5fM;
        m2398CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, f622, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2394getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j4 = j3;
        f5 = f622;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2402CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float f2;
        float m2396getCircularStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier3;
        final Modifier modifier4;
        final long j4;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)521@20600L13,527@20799L18,523@20687L207:ProgressIndicator.kt#uh7d8r");
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
        if ((i & 48) == 0) {
            j2 = j;
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j2)) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 256 : 128;
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                        i3 &= -113;
                    }
                    m2396getCircularStrokeWidthD9Ej5fM = i5 == 0 ? ProgressIndicatorDefaults.INSTANCE.m2396getCircularStrokeWidthD9Ej5fM() : f2;
                    j3 = j2;
                    modifier3 = companion;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    m2396getCircularStrokeWidthD9Ej5fM = f2;
                    j3 = j2;
                    modifier3 = modifier2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(947193756, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:523)");
                }
                m2400CircularProgressIndicatorLxG7B9w(modifier3, j3, m2396getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2395getCircularIndeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                j4 = j3;
                f3 = m2396getCircularStrokeWidthD9Ej5fM;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                j4 = j2;
                f3 = f2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ProgressIndicatorKt.m2402CircularProgressIndicatoraMcp0Q(Modifier.this, j4, f3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i3 & 147) == 146) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if (i5 == 0) {
        }
        j3 = j2;
        modifier3 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2400CircularProgressIndicatorLxG7B9w(modifier3, j3, m2396getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2395getCircularIndeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j4 = j3;
        f3 = m2396getCircularStrokeWidthD9Ej5fM;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m2413drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()) - (f3 * width);
        DrawScope.m4592drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.ui.geometry.SizeKt.Size(m3891getWidthimpl, m3891getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m2414drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m2413drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2415drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2413drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m2416drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m2413drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m4411equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m4415getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m6389constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    static {
        float m6389constructorimpl = Dp.m6389constructorimpl(10);
        SemanticsBoundsPadding = m6389constructorimpl;
        IncreaseSemanticsBounds = PaddingKt.m881paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2419invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2419invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                float f;
                f = ProgressIndicatorKt.SemanticsBoundsPadding;
                final int i = measureScope.mo624roundToPx0680j_4(f);
                int i2 = i * 2;
                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(j, 0, i2));
                return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight() - i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1.1
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
                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, -i, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }), 0.0f, m6389constructorimpl, 1, null);
        LinearIndicatorWidth = Dp.m6389constructorimpl(240);
        LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m3258getTrackHeightD9Ej5fM();
        CircularIndicatorDiameter = Dp.m6389constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m2992getSizeD9Ej5fM() - Dp.m6389constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m2991getActiveIndicatorWidthD9Ej5fM() * 2));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }
}
