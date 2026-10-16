package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.unity3d.services.UnityAdsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a0\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aD\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a8\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aN\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a0\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a:\u00101\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a8\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aD\u00101\u001a\u00020\u001f2\b\b\u0001\u0010,\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020)H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a6\u0010:\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a&\u0010B\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a6\u0010E\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010A\u001a>\u0010G\u001a\u00020\u001f*\u00020;2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a>\u0010J\u001a\u00020\u001f*\u00020;2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a.\u0010O\u001a\u00020\u001f*\u00020;2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\f\u0010R\u001a\u00020!*\u00020!H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006S²\u0006\n\u0010T\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010W\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "backgroundColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", NotificationCompat.CATEGORY_PROGRESS, "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", VastAttributes.STROKE_COLOR, "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorBackground", "drawCircularIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "increaseSemanticsBounds", "material_release", "firstLineHead", "firstLineTail", "secondLineHead", "secondLineTail", "currentRotation", "baseRotation", "endAngle"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1725getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m6389constructorimpl(240);
    private static final float CircularIndicatorDiameter = Dp.m6389constructorimpl(40);
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x005e  */
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1732LinearProgressIndicator_5eSRE(final float f, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        Modifier.Companion companion;
        long j5;
        boolean changed;
        Object rememberedValue;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-531984864);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)106@4963L6,111@5159L385:ProgressIndicator.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = 256;
                        i4 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = 128;
                i4 |= i8;
            } else {
                j3 = j;
            }
            if ((i2 & 7168) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = 2048;
                        i4 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = 1024;
                i4 |= i7;
            } else {
                j4 = j2;
            }
            if ((57344 & i2) != 0) {
                if ((i3 & 16) == 0) {
                    i5 = i;
                    if (startRestartGroup.changed(i5)) {
                        i6 = 16384;
                        i4 |= i6;
                    }
                } else {
                    i5 = i;
                }
                i6 = 8192;
                i4 |= i6;
            } else {
                i5 = i;
            }
            if ((46811 & i4) == 9362 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 4) == 0) {
                        i4 &= -897;
                        j5 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                    } else {
                        j5 = j3;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                        j4 = Color.m4062copywmQWz5c$default(j5, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        i5 = StrokeCap.INSTANCE.m4415getButtKaPHkGw();
                    }
                    j3 = j5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    companion = modifier2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-531984864, i4, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:109)");
                }
                final float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                Modifier m930sizeVpY3zN4 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(increaseSemanticsBounds(companion), coerceIn, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
                startRestartGroup.startReplaceableGroup(-368649696);
                changed = startRestartGroup.changed(j4) | startRestartGroup.changed(i5) | startRestartGroup.changed(coerceIn) | startRestartGroup.changed(j3);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final long j6 = j3;
                    final long j7 = j4;
                    final int i10 = i5;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                            ProgressIndicatorKt.m1744drawLinearIndicatorBackgroundAZGd3zU(drawScope, j7, m3888getHeightimpl, i10);
                            ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope, 0.0f, coerceIn, j6, m3888getHeightimpl, i10);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(m930sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j8 = j3;
                final long j9 = j4;
                final int i11 = i5;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
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
                        ProgressIndicatorKt.m1732LinearProgressIndicator_5eSRE(f, modifier3, j8, j9, i11, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        if ((57344 & i2) != 0) {
        }
        if ((46811 & i4) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        j3 = j5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float coerceIn2 = RangesKt.coerceIn(f, 0.0f, 1.0f);
        Modifier m930sizeVpY3zN42 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics$default(increaseSemanticsBounds(companion), coerceIn2, null, 0, 6, null), LinearIndicatorWidth, LinearIndicatorHeight);
        startRestartGroup.startReplaceableGroup(-368649696);
        changed = startRestartGroup.changed(j4) | startRestartGroup.changed(i5) | startRestartGroup.changed(coerceIn2) | startRestartGroup.changed(j3);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        final long j62 = j3;
        final long j72 = j4;
        final int i102 = i5;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                ProgressIndicatorKt.m1744drawLinearIndicatorBackgroundAZGd3zU(drawScope, j72, m3888getHeightimpl, i102);
                ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope, 0.0f, coerceIn2, j62, m3888getHeightimpl, i102);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m930sizeVpY3zN42, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024e  */
    /* renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1730LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        long j4;
        final int i5;
        Modifier.Companion companion;
        int i6;
        long j5;
        boolean changed;
        Object rememberedValue;
        final long j6;
        final long j7;
        final int i7;
        final Modifier modifier3;
        final long j8;
        final long j9;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1501635280);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)139@6460L6,143@6629L28,147@6911L320,158@7276L320,169@7642L324,180@8012L324,191@8341L790:ProgressIndicator.kt#jmzs0o");
        int i10 = i3 & 1;
        if (i10 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i3 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i4 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i4 |= i9;
        } else {
            j3 = j;
        }
        if ((i2 & 896) == 0) {
            j4 = j2;
            i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        if ((i2 & 7168) == 0) {
            if ((i3 & 8) == 0) {
                i5 = i;
                if (startRestartGroup.changed(i5)) {
                    i8 = 2048;
                    i4 |= i8;
                }
            } else {
                i5 = i;
            }
            i8 = 1024;
            i4 |= i8;
        } else {
            i5 = i;
        }
        if ((i4 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i3 & 2) != 0) {
                    j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                    i4 &= -113;
                }
                long j10 = j3;
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    j4 = Color.m4062copywmQWz5c$default(j10, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    i5 = StrokeCap.INSTANCE.m4415getButtKaPHkGw();
                    j3 = j10;
                } else {
                    long j11 = j4;
                    i6 = i4;
                    j5 = j11;
                    j3 = j10;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1501635280, i6, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:142)");
                    }
                    InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                    final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1800);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 0);
                            cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1800);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 333);
                            cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1183);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier modifier4 = companion;
                    final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1800);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 1000);
                            cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1567);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1800);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 1267);
                            cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1800);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier m930sizeVpY3zN4 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(increaseSemanticsBounds(modifier4)), LinearIndicatorWidth, LinearIndicatorHeight);
                    startRestartGroup.startReplaceableGroup(-368646529);
                    changed = startRestartGroup.changed(j5) | startRestartGroup.changed(i5) | startRestartGroup.changed(animateFloat) | startRestartGroup.changed(animateFloat2) | startRestartGroup.changed(j3) | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat4);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        j6 = j5;
                        j7 = j3;
                        i7 = i5;
                        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                                float LinearProgressIndicator_2cYBFYY$lambda$1;
                                float LinearProgressIndicator_2cYBFYY$lambda$2;
                                DrawScope drawScope2;
                                float LinearProgressIndicator_2cYBFYY$lambda$3;
                                float LinearProgressIndicator_2cYBFYY$lambda$4;
                                float LinearProgressIndicator_2cYBFYY$lambda$32;
                                float LinearProgressIndicator_2cYBFYY$lambda$42;
                                float LinearProgressIndicator_2cYBFYY$lambda$12;
                                float LinearProgressIndicator_2cYBFYY$lambda$22;
                                float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                                ProgressIndicatorKt.m1744drawLinearIndicatorBackgroundAZGd3zU(drawScope, j6, m3888getHeightimpl, i7);
                                LinearProgressIndicator_2cYBFYY$lambda$1 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(animateFloat);
                                LinearProgressIndicator_2cYBFYY$lambda$2 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(animateFloat2);
                                if (LinearProgressIndicator_2cYBFYY$lambda$1 - LinearProgressIndicator_2cYBFYY$lambda$2 > 0.0f) {
                                    LinearProgressIndicator_2cYBFYY$lambda$12 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(animateFloat);
                                    LinearProgressIndicator_2cYBFYY$lambda$22 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(animateFloat2);
                                    drawScope2 = drawScope;
                                    ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope2, LinearProgressIndicator_2cYBFYY$lambda$12, LinearProgressIndicator_2cYBFYY$lambda$22, j7, m3888getHeightimpl, i7);
                                } else {
                                    drawScope2 = drawScope;
                                }
                                LinearProgressIndicator_2cYBFYY$lambda$3 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(animateFloat3);
                                LinearProgressIndicator_2cYBFYY$lambda$4 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(animateFloat4);
                                if (LinearProgressIndicator_2cYBFYY$lambda$3 - LinearProgressIndicator_2cYBFYY$lambda$4 > 0.0f) {
                                    LinearProgressIndicator_2cYBFYY$lambda$32 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(animateFloat3);
                                    LinearProgressIndicator_2cYBFYY$lambda$42 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(animateFloat4);
                                    ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope2, LinearProgressIndicator_2cYBFYY$lambda$32, LinearProgressIndicator_2cYBFYY$lambda$42, j7, m3888getHeightimpl, i7);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        j6 = j5;
                        j7 = j3;
                        i7 = i5;
                    }
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m930sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j8 = j6;
                    i5 = i7;
                    j9 = j7;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                }
                companion = modifier2;
            }
            long j12 = j4;
            i6 = i4;
            j5 = j12;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
            final State<Float> animateFloat5 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS);
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 333);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifier42 = companion;
            final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 1000);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State<Float> animateFloat42 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 1267);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                    keyframesSpecConfig.using(at, cubicBezierEasing);
                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier m930sizeVpY3zN42 = SizeKt.m930sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(increaseSemanticsBounds(modifier42)), LinearIndicatorWidth, LinearIndicatorHeight);
            startRestartGroup.startReplaceableGroup(-368646529);
            changed = startRestartGroup.changed(j5) | startRestartGroup.changed(i5) | startRestartGroup.changed(animateFloat5) | startRestartGroup.changed(animateFloat22) | startRestartGroup.changed(j3) | startRestartGroup.changed(animateFloat32) | startRestartGroup.changed(animateFloat42);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            j6 = j5;
            j7 = j3;
            i7 = i5;
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                    float LinearProgressIndicator_2cYBFYY$lambda$1;
                    float LinearProgressIndicator_2cYBFYY$lambda$2;
                    DrawScope drawScope2;
                    float LinearProgressIndicator_2cYBFYY$lambda$3;
                    float LinearProgressIndicator_2cYBFYY$lambda$4;
                    float LinearProgressIndicator_2cYBFYY$lambda$32;
                    float LinearProgressIndicator_2cYBFYY$lambda$42;
                    float LinearProgressIndicator_2cYBFYY$lambda$12;
                    float LinearProgressIndicator_2cYBFYY$lambda$22;
                    float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
                    ProgressIndicatorKt.m1744drawLinearIndicatorBackgroundAZGd3zU(drawScope, j6, m3888getHeightimpl, i7);
                    LinearProgressIndicator_2cYBFYY$lambda$1 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(animateFloat5);
                    LinearProgressIndicator_2cYBFYY$lambda$2 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(animateFloat22);
                    if (LinearProgressIndicator_2cYBFYY$lambda$1 - LinearProgressIndicator_2cYBFYY$lambda$2 > 0.0f) {
                        LinearProgressIndicator_2cYBFYY$lambda$12 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$1(animateFloat5);
                        LinearProgressIndicator_2cYBFYY$lambda$22 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$2(animateFloat22);
                        drawScope2 = drawScope;
                        ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope2, LinearProgressIndicator_2cYBFYY$lambda$12, LinearProgressIndicator_2cYBFYY$lambda$22, j7, m3888getHeightimpl, i7);
                    } else {
                        drawScope2 = drawScope;
                    }
                    LinearProgressIndicator_2cYBFYY$lambda$3 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(animateFloat32);
                    LinearProgressIndicator_2cYBFYY$lambda$4 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(animateFloat42);
                    if (LinearProgressIndicator_2cYBFYY$lambda$3 - LinearProgressIndicator_2cYBFYY$lambda$4 > 0.0f) {
                        LinearProgressIndicator_2cYBFYY$lambda$32 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$3(animateFloat32);
                        LinearProgressIndicator_2cYBFYY$lambda$42 = ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$4(animateFloat42);
                        ProgressIndicatorKt.m1743drawLinearIndicatorqYKTg0g(drawScope2, LinearProgressIndicator_2cYBFYY$lambda$32, LinearProgressIndicator_2cYBFYY$lambda$42, j7, m3888getHeightimpl, i7);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m930sizeVpY3zN42, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
            j8 = j6;
            i5 = i7;
            j9 = j7;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j9 = j3;
            j8 = j4;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    ProgressIndicatorKt.m1730LinearProgressIndicator2cYBFYY(Modifier.this, j9, j8, i5, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0060  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1733LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        float f2;
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Modifier modifier3;
        final Modifier modifier4;
        final long j8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-850309746);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)225@9349L6,227@9445L118:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(f2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
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
            if ((i & 7168) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) == 0) {
                        i3 &= -897;
                        j5 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                    } else {
                        j5 = j3;
                    }
                    if ((i2 & 8) == 0) {
                        i3 &= -7169;
                        modifier3 = companion;
                        j6 = Color.m4062copywmQWz5c$default(j5, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                        j7 = j5;
                    } else {
                        j6 = j4;
                        j7 = j5;
                        modifier3 = companion;
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
                    ComposerKt.traceEventStart(-850309746, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:227)");
                }
                m1732LinearProgressIndicator_5eSRE(f2, modifier3, j7, j6, StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, i3 & 8190, 0);
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
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$5
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
                        ProgressIndicatorKt.m1733LinearProgressIndicatoreaDK9VM(f, modifier4, j8, j9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i3 & 5851) == 1170) {
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
        m1732LinearProgressIndicator_5eSRE(f2, modifier3, j7, j6, StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, i3 & 8190, 0);
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
    public static final /* synthetic */ void m1731LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        long j5;
        long j6;
        Modifier modifier3;
        final Modifier modifier4;
        final long j7;
        final long j8;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)239@9758L6,241@9854L104:ProgressIndicator.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
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
        if ((i & 896) == 0) {
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
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            j7 = j3;
            j8 = j4;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                    i3 &= -113;
                }
                long j9 = j3;
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    modifier3 = companion;
                    j5 = Color.m4062copywmQWz5c$default(j9, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    j6 = j9;
                } else {
                    j5 = j4;
                    j6 = j9;
                    modifier3 = companion;
                }
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
                j6 = j3;
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, i3, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:241)");
            }
            m1730LinearProgressIndicator2cYBFYY(modifier3, j6, j5, StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, i3 & 1022, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            j7 = j6;
            j8 = j5;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$6
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
                    ProgressIndicatorKt.m1731LinearProgressIndicatorRIQooxk(Modifier.this, j7, j8, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m1743drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
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
    /* renamed from: drawLinearIndicatorBackground-AZGd3zU, reason: not valid java name */
    public static final void m1744drawLinearIndicatorBackgroundAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m1743drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x005e  */
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1726CircularProgressIndicatorDUhRLBM(final float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        float f3;
        int i6;
        long j4;
        int i7;
        long m4098getTransparent0d7_KjU;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1746618448);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(3,2,1:c#ui.graphics.Color,5:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.StrokeCap)321@13100L6,*327@13359L7,330@13440L375:ProgressIndicator.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 7168) == 0) {
                f3 = f2;
                i4 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((57344 & i2) == 0) {
                    j4 = j2;
                    i4 |= startRestartGroup.changed(j4) ? 16384 : 8192;
                    if ((458752 & i2) != 0) {
                        if ((i3 & 32) == 0) {
                            i7 = i;
                            if (startRestartGroup.changed(i7)) {
                                i8 = 131072;
                                i4 |= i8;
                            }
                        } else {
                            i7 = i;
                        }
                        i8 = 65536;
                        i4 |= i8;
                    } else {
                        i7 = i;
                    }
                    if ((374491 & i4) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                f3 = ProgressIndicatorDefaults.INSTANCE.m1725getStrokeWidthD9Ej5fM();
                            }
                            m4098getTransparent0d7_KjU = i6 == 0 ? Color.INSTANCE.m4098getTransparent0d7_KjU() : j4;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                i7 = StrokeCap.INSTANCE.m4415getButtKaPHkGw();
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                            m4098getTransparent0d7_KjU = j4;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1746618448, i4, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:325)");
                        }
                        final float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Stroke stroke = new Stroke(((Density) consume).mo630toPx0680j_4(f3), 0.0f, i7, 0, null, 26, null);
                        final long j7 = j3;
                        final long j8 = m4098getTransparent0d7_KjU;
                        CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, coerceIn, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
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
                                float f4 = coerceIn * 360.0f;
                                ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j8, stroke);
                                ProgressIndicatorKt.m1741drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, f4, j7, stroke);
                            }
                        }, startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j5 = j3;
                        j6 = m4098getTransparent0d7_KjU;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        j5 = j3;
                        j6 = j4;
                    }
                    final int i11 = i7;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final float f4 = f3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
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
                                ProgressIndicatorKt.m1726CircularProgressIndicatorDUhRLBM(f, modifier3, j5, f4, j6, i11, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                j4 = j2;
                if ((458752 & i2) != 0) {
                }
                if ((374491 & i4) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if ((i3 & 32) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float coerceIn2 = RangesKt.coerceIn(f, 0.0f, 1.0f);
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Stroke stroke2 = new Stroke(((Density) consume2).mo630toPx0680j_4(f3), 0.0f, i7, 0, null, 26, null);
                final long j72 = j3;
                final long j82 = m4098getTransparent0d7_KjU;
                CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, coerceIn2, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
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
                        float f42 = coerceIn2 * 360.0f;
                        ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j82, stroke2);
                        ProgressIndicatorKt.m1741drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, f42, j72, stroke2);
                    }
                }, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j5 = j3;
                j6 = m4098getTransparent0d7_KjU;
                final int i112 = i7;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f3 = f2;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            j4 = j2;
            if ((458752 & i2) != 0) {
            }
            if ((374491 & i4) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if ((i3 & 32) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final float coerceIn22 = RangesKt.coerceIn(f, 0.0f, 1.0f);
            ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(localDensity22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Stroke stroke22 = new Stroke(((Density) consume22).mo630toPx0680j_4(f3), 0.0f, i7, 0, null, 26, null);
            final long j722 = j3;
            final long j822 = m4098getTransparent0d7_KjU;
            CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, coerceIn22, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
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
                    float f42 = coerceIn22 * 360.0f;
                    ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j822, stroke22);
                    ProgressIndicatorKt.m1741drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, f42, j722, stroke22);
                }
            }, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j5 = j3;
            j6 = m4098getTransparent0d7_KjU;
            final int i1122 = i7;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f3 = f2;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        j4 = j2;
        if ((458752 & i2) != 0) {
        }
        if ((374491 & i4) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float coerceIn222 = RangesKt.coerceIn(f, 0.0f, 1.0f);
        ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(localDensity222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Stroke stroke222 = new Stroke(((Density) consume222).mo630toPx0680j_4(f3), 0.0f, i7, 0, null, 26, null);
        final long j7222 = j3;
        final long j8222 = m4098getTransparent0d7_KjU;
        CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier2, coerceIn222, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
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
                float f42 = coerceIn222 * 360.0f;
                ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j8222, stroke222);
                ProgressIndicatorKt.m1741drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, f42, j7222, stroke222);
            }
        }, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j5 = j3;
        j6 = m4098getTransparent0d7_KjU;
        final int i11222 = i7;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x006c  */
    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1727CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        float f2;
        int i5;
        long j4;
        int i6;
        final Modifier.Companion companion;
        long j5;
        final long j6;
        int i7;
        float f3;
        long j7;
        int i8;
        final int i9;
        final long j8;
        final float f4;
        final long j9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1119119072);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1:c#ui.graphics.Color,4:c#ui.unit.Dp,0:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)360@14808L6,*365@15017L7,369@15116L28,371@15274L278,383@15667L230,394@16015L346,406@16396L355,417@16756L647:ProgressIndicator.kt#jmzs0o");
        int i12 = i3 & 1;
        if (i12 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i3 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i11 = 32;
                    i4 |= i11;
                }
            } else {
                j3 = j;
            }
            i11 = 16;
            i4 |= i11;
        } else {
            j3 = j;
        }
        int i13 = i3 & 4;
        if (i13 != 0) {
            i4 |= 384;
        } else if ((i2 & 896) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 7168) == 0) {
                j4 = j2;
                i4 |= startRestartGroup.changed(j4) ? 2048 : 1024;
                if ((57344 & i2) == 0) {
                    if ((i3 & 16) == 0) {
                        i6 = i;
                        if (startRestartGroup.changed(i6)) {
                            i10 = 16384;
                            i4 |= i10;
                        }
                    } else {
                        i6 = i;
                    }
                    i10 = 8192;
                    i4 |= i10;
                } else {
                    i6 = i;
                }
                if ((46811 & i4) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            j5 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                            i4 &= -113;
                        } else {
                            j5 = j3;
                        }
                        if (i13 != 0) {
                            f2 = ProgressIndicatorDefaults.INSTANCE.m1725getStrokeWidthD9Ej5fM();
                        }
                        if (i5 != 0) {
                            j4 = Color.INSTANCE.m4098getTransparent0d7_KjU();
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            j6 = j5;
                            i8 = StrokeCap.INSTANCE.m4417getSquareKaPHkGw();
                            f3 = f2;
                        } else {
                            j6 = j5;
                            i7 = i4;
                            f3 = f2;
                            j7 = j4;
                            i8 = i6;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1119119072, i7, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:364)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Stroke stroke = new Stroke(((Density) consume).mo630toPx0680j_4(f3), 0.0f, i8, 0, null, 26, null);
                            int i14 = i8;
                            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                            final State animateValue = InfiniteTransitionKt.animateValue(rememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12), 16);
                            final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    invoke2(keyframesSpecConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 0);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(at, cubicBezierEasing);
                                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    invoke2(keyframesSpecConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(at, cubicBezierEasing);
                                    keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final float f5 = f3;
                            final long j10 = j7;
                            CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
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
                                    int CircularProgressIndicator_LxG7B9w$lambda$8;
                                    float CircularProgressIndicator_LxG7B9w$lambda$10;
                                    float CircularProgressIndicator_LxG7B9w$lambda$11;
                                    float CircularProgressIndicator_LxG7B9w$lambda$9;
                                    float CircularProgressIndicator_LxG7B9w$lambda$112;
                                    ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j10, stroke);
                                    CircularProgressIndicator_LxG7B9w$lambda$8 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$8(animateValue);
                                    CircularProgressIndicator_LxG7B9w$lambda$10 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$10(animateFloat2);
                                    CircularProgressIndicator_LxG7B9w$lambda$11 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(animateFloat3);
                                    float abs = Math.abs(CircularProgressIndicator_LxG7B9w$lambda$10 - CircularProgressIndicator_LxG7B9w$lambda$11);
                                    CircularProgressIndicator_LxG7B9w$lambda$9 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$9(animateFloat);
                                    float f6 = (((CircularProgressIndicator_LxG7B9w$lambda$8 * 216.0f) % 360.0f) - 90.0f) + CircularProgressIndicator_LxG7B9w$lambda$9;
                                    CircularProgressIndicator_LxG7B9w$lambda$112 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(animateFloat3);
                                    ProgressIndicatorKt.m1742drawIndeterminateCircularIndicatorhrjfTZI(drawScope, CircularProgressIndicator_LxG7B9w$lambda$112 + f6, f5, abs, j6, stroke);
                                }
                            }, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i9 = i14;
                            j8 = j10;
                            f4 = f5;
                            j9 = j6;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        companion = modifier2;
                        j6 = j3;
                        f3 = f2;
                        i8 = i6;
                    }
                    i7 = i4;
                    j7 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Stroke stroke2 = new Stroke(((Density) consume2).mo630toPx0680j_4(f3), 0.0f, i8, 0, null, 26, null);
                    int i142 = i8;
                    InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                    final State<Integer> animateValue2 = InfiniteTransitionKt.animateValue(rememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12), 16);
                    final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), 0);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(290.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m444infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            invoke2(keyframesSpecConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframesSpec.KeyframeEntity<Float> at = keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(0.0f), TTAdConstant.STYLE_SIZE_RADIO_2_3);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(at, cubicBezierEasing);
                            keyframesSpecConfig.at((KeyframesSpec.KeyframesSpecConfig<Float>) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final float f52 = f3;
                    final long j102 = j7;
                    CanvasKt.Canvas(SizeKt.m928size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
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
                            int CircularProgressIndicator_LxG7B9w$lambda$8;
                            float CircularProgressIndicator_LxG7B9w$lambda$10;
                            float CircularProgressIndicator_LxG7B9w$lambda$11;
                            float CircularProgressIndicator_LxG7B9w$lambda$9;
                            float CircularProgressIndicator_LxG7B9w$lambda$112;
                            ProgressIndicatorKt.m1740drawCircularIndicatorBackgroundbw27NRU(drawScope, j102, stroke2);
                            CircularProgressIndicator_LxG7B9w$lambda$8 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$8(animateValue2);
                            CircularProgressIndicator_LxG7B9w$lambda$10 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$10(animateFloat22);
                            CircularProgressIndicator_LxG7B9w$lambda$11 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(animateFloat32);
                            float abs = Math.abs(CircularProgressIndicator_LxG7B9w$lambda$10 - CircularProgressIndicator_LxG7B9w$lambda$11);
                            CircularProgressIndicator_LxG7B9w$lambda$9 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$9(animateFloat4);
                            float f6 = (((CircularProgressIndicator_LxG7B9w$lambda$8 * 216.0f) % 360.0f) - 90.0f) + CircularProgressIndicator_LxG7B9w$lambda$9;
                            CircularProgressIndicator_LxG7B9w$lambda$112 = ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(animateFloat32);
                            ProgressIndicatorKt.m1742drawIndeterminateCircularIndicatorhrjfTZI(drawScope, CircularProgressIndicator_LxG7B9w$lambda$112 + f6, f52, abs, j6, stroke2);
                        }
                    }, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i9 = i142;
                    j8 = j102;
                    f4 = f52;
                    j9 = j6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    j9 = j3;
                    f4 = f2;
                    j8 = j4;
                    i9 = i6;
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ProgressIndicatorKt.m1727CircularProgressIndicatorLxG7B9w(Modifier.this, j9, f4, j8, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            j4 = j2;
            if ((57344 & i2) == 0) {
            }
            if ((46811 & i4) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if ((i3 & 2) != 0) {
            }
            if (i13 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
        }
        f2 = f;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        j4 = j2;
        if ((57344 & i2) == 0) {
        }
        if ((46811 & i4) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if ((i3 & 2) != 0) {
        }
        if (i13 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0061  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1728CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        float f3;
        int i3;
        Modifier modifier2;
        long j2;
        int i4;
        float f4;
        float m1725getStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier3;
        final Modifier modifier4;
        final long j4;
        final float f5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-409649739);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)440@17623L6,442@17703L157:ProgressIndicator.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f3 = f;
        } else if ((i & 14) == 0) {
            f3 = f;
            i3 = (startRestartGroup.changed(f3) ? 4 : 2) | i;
        } else {
            f3 = f;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                f4 = f2;
                i3 |= startRestartGroup.changed(f4) ? 2048 : 1024;
                if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            j2 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                            i3 &= -897;
                        }
                        m1725getStrokeWidthD9Ej5fM = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1725getStrokeWidthD9Ej5fM() : f4;
                        j3 = j2;
                        modifier3 = companion;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        m1725getStrokeWidthD9Ej5fM = f4;
                        j3 = j2;
                        modifier3 = modifier2;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-409649739, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:442)");
                    }
                    m1726CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, m1725getStrokeWidthD9Ej5fM, Color.INSTANCE.m4098getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    j4 = j3;
                    f5 = m1725getStrokeWidthD9Ej5fM;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    j4 = j2;
                    f5 = f4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$5
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
                            ProgressIndicatorKt.m1728CircularProgressIndicatorMBs18nI(f, modifier4, j4, f5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f4 = f2;
            if ((i3 & 5851) == 1170) {
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
            m1726CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, m1725getStrokeWidthD9Ej5fM, Color.INSTANCE.m4098getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j4 = j3;
            f5 = m1725getStrokeWidthD9Ej5fM;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        f4 = f2;
        if ((i3 & 5851) == 1170) {
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
        m1726CircularProgressIndicatorDUhRLBM(f3, modifier3, j3, m1725getStrokeWidthD9Ej5fM, Color.INSTANCE.m4098getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4415getButtKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j4 = j3;
        f5 = m1725getStrokeWidthD9Ej5fM;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1729CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float f2;
        float m1725getStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier3;
        final Modifier modifier4;
        final long j4;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-392089979);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)455@18057L6,457@18137L145:ProgressIndicator.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            j2 = j;
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j2)) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 256 : 128;
            if ((i3 & 731) == 146 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j2 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                        i3 &= -113;
                    }
                    m1725getStrokeWidthD9Ej5fM = i5 == 0 ? ProgressIndicatorDefaults.INSTANCE.m1725getStrokeWidthD9Ej5fM() : f2;
                    j3 = j2;
                    modifier3 = companion;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    m1725getStrokeWidthD9Ej5fM = f2;
                    j3 = j2;
                    modifier3 = modifier2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-392089979, i3, -1, "androidx.compose.material.CircularProgressIndicator (ProgressIndicator.kt:457)");
                }
                m1727CircularProgressIndicatorLxG7B9w(modifier3, j3, m1725getStrokeWidthD9Ej5fM, Color.INSTANCE.m4098getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4417getSquareKaPHkGw(), startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                j4 = j3;
                f3 = m1725getStrokeWidthD9Ej5fM;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                j4 = j2;
                f3 = f2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$6
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
                        ProgressIndicatorKt.m1729CircularProgressIndicatoraMcp0Q(Modifier.this, j4, f3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i3 & 731) == 146) {
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
        m1727CircularProgressIndicatorLxG7B9w(modifier3, j3, m1725getStrokeWidthD9Ej5fM, Color.INSTANCE.m4098getTransparent0d7_KjU(), StrokeCap.INSTANCE.m4417getSquareKaPHkGw(), startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j4 = j3;
        f3 = m1725getStrokeWidthD9Ej5fM;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1739drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()) - (f3 * width);
        DrawScope.m4592drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.ui.geometry.SizeKt.Size(m3891getWidthimpl, m3891getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m1740drawCircularIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m1739drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1741drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1739drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1742drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1739drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m4411equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m4415getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m6389constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    public static final Modifier increaseSemanticsBounds(Modifier modifier) {
        final float m6389constructorimpl = Dp.m6389constructorimpl(10);
        return PaddingKt.m881paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m1745invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m1745invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                final int i = measureScope.mo624roundToPx0680j_4(m6389constructorimpl);
                int i2 = i * 2;
                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(j, 0, i2));
                return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight() - i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$1.1
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
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }), 0.0f, m6389constructorimpl, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_2cYBFYY$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CircularProgressIndicator_LxG7B9w$lambda$8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_LxG7B9w$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
