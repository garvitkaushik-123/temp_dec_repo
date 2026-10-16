package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u009a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001aZ\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aB\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m6389constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m6389constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m6389constructorimpl(2);

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d5, code lost:
    
        if (r3.changed(r119) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        boolean z7;
        KeyboardOptions keyboardOptions2;
        int i27;
        KeyboardActions keyboardActions2;
        int i28;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
        KeyboardActions keyboardActions3;
        boolean z8;
        boolean z9;
        TextStyle textStyle3;
        int i29;
        VisualTransformation visualTransformation2;
        boolean z10;
        int i30;
        int i31;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        int i32;
        boolean z11;
        long m5918getColor0d7_KjU;
        Composer composer3;
        final boolean z12;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle4;
        final TextFieldColors textFieldColors3;
        final boolean z13;
        final boolean z14;
        final int i33;
        final MutableInteractionSource mutableInteractionSource4;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Shape shape4;
        final KeyboardOptions keyboardOptions3;
        final int i34;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final KeyboardActions keyboardActions4;
        final boolean z15;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)166@8632L7,178@9232L39,180@9314L6,181@9439L17,193@9857L24,195@10012L38,204@10379L20,190@9759L1655:TextField.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i3 & 896) == 0) {
                modifier2 = modifier;
                i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i8 = i5 & 8;
                int i35 = 2048;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    z5 = z;
                    i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                        z6 = z2;
                    } else {
                        z6 = z2;
                        if ((i3 & 57344) == 0) {
                            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        }
                    }
                    if ((i3 & 458752) != 0) {
                        textStyle2 = textStyle;
                        i6 |= ((i5 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i3 & 3670016) == 0) {
                            i6 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i3 & 29360128) == 0) {
                            i6 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i13 = i12;
                        i6 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i6 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & 1879048192) == 0) {
                            i15 = i14;
                            i6 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 14) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i5 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 112) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i36 = i18;
                            i21 = i5 & 4096;
                            if (i21 == 0) {
                                i22 = i36 | 384;
                            } else {
                                i22 = i36;
                                if ((i4 & 896) == 0) {
                                    i22 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                    if ((i4 & 7168) == 0) {
                                        if ((i5 & 8192) != 0) {
                                        }
                                        i35 = 1024;
                                        i22 |= i35;
                                    }
                                    int i37 = i22;
                                    i23 = i5 & 16384;
                                    if (i23 != 0) {
                                        i37 |= 24576;
                                    } else if ((i4 & 57344) == 0) {
                                        i24 = i37 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                        if ((i4 & 458752) == 0) {
                                            i24 |= ((i5 & 32768) == 0 && startRestartGroup.changed(i)) ? 131072 : 65536;
                                        }
                                        i25 = i5 & 65536;
                                        if (i25 == 0) {
                                            i24 |= 1572864;
                                        } else if ((i4 & 3670016) == 0) {
                                            i24 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                                        }
                                        i26 = i5 & 131072;
                                        if (i26 == 0) {
                                            i24 |= 12582912;
                                        } else if ((i4 & 29360128) == 0) {
                                            i24 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                        }
                                        if ((i4 & 234881024) == 0) {
                                            i24 |= ((i5 & 262144) == 0 && startRestartGroup.changed(shape)) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & 1879048192) == 0) {
                                            i24 |= ((i5 & 524288) == 0 && startRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                                        }
                                        int i38 = i24;
                                        if ((i6 & 1533916891) == 306783378 || (1533916891 & i38) != 306783378 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                                boolean z16 = i8 == 0 ? true : z;
                                                boolean z17 = i9 == 0 ? false : z2;
                                                if ((i5 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i6 &= -458753;
                                                }
                                                int i39 = i6;
                                                TextStyle textStyle5 = textStyle2;
                                                Function2<? super Composer, ? super Integer, Unit> function214 = i10 == 0 ? null : function25;
                                                function27 = i11 == 0 ? null : function26;
                                                function28 = i13 == 0 ? null : function23;
                                                function29 = i15 == 0 ? null : function24;
                                                z7 = i17 == 0 ? false : z3;
                                                VisualTransformation none = i20 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                keyboardOptions2 = i21 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                if ((i5 & 8192) == 0) {
                                                    i27 = i38 & (-7169);
                                                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                                } else {
                                                    i27 = i38;
                                                    keyboardActions2 = keyboardActions;
                                                }
                                                boolean z18 = i23 == 0 ? false : z4;
                                                if ((32768 & i5) == 0) {
                                                    i27 &= -458753;
                                                    i28 = z18 ? 1 : Integer.MAX_VALUE;
                                                } else {
                                                    i28 = i;
                                                }
                                                int i40 = i25 == 0 ? 1 : i2;
                                                if (i26 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-492369756);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    startRestartGroup.endReplaceableGroup();
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((262144 & i5) == 0) {
                                                    i27 &= -234881025;
                                                    shape2 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i41 = i27;
                                                if ((i5 & 524288) == 0) {
                                                    TextFieldColors m1827textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1827textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, 48, 2097151);
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    i32 = i41 & (-1879048193);
                                                    z8 = z16;
                                                    z9 = z17;
                                                    textStyle3 = textStyle5;
                                                    i29 = i39;
                                                    function25 = function214;
                                                    visualTransformation2 = none;
                                                    z10 = z18;
                                                    i30 = i28;
                                                    i31 = i40;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    textFieldColors2 = m1827textFieldColorsdx8h9Zs;
                                                    shape3 = shape2;
                                                } else {
                                                    composer2 = startRestartGroup;
                                                    textFieldColors2 = textFieldColors;
                                                    keyboardActions3 = keyboardActions2;
                                                    z8 = z16;
                                                    z9 = z17;
                                                    textStyle3 = textStyle5;
                                                    i29 = i39;
                                                    function25 = function214;
                                                    visualTransformation2 = none;
                                                    z10 = z18;
                                                    i30 = i28;
                                                    i31 = i40;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                    i32 = i41;
                                                }
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i5 & 32) != 0) {
                                                    i6 &= -458753;
                                                }
                                                if ((i5 & 8192) != 0) {
                                                    i38 &= -7169;
                                                }
                                                if ((32768 & i5) != 0) {
                                                    i38 &= -458753;
                                                }
                                                if ((262144 & i5) != 0) {
                                                    i38 &= -234881025;
                                                }
                                                if ((i5 & 524288) != 0) {
                                                    i38 &= -1879048193;
                                                }
                                                TextStyle textStyle6 = textStyle2;
                                                i32 = i38;
                                                textStyle3 = textStyle6;
                                                z9 = z2;
                                                function28 = function23;
                                                function29 = function24;
                                                z7 = z3;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions3 = keyboardActions;
                                                z10 = z4;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                composer2 = startRestartGroup;
                                                i29 = i6;
                                                function27 = function26;
                                                companion = modifier2;
                                                z8 = z;
                                                i30 = i;
                                                i31 = i2;
                                            }
                                            composer2.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                z11 = z9;
                                            } else {
                                                z11 = z9;
                                                ComposerKt.traceEventStart(-1504264404, i29, i32, "androidx.compose.material.TextField (TextField.kt:182)");
                                            }
                                            composer2.startReplaceableGroup(-833027163);
                                            ComposerKt.sourceInformation(composer2, "*185@9608L18");
                                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                m5918getColor0d7_KjU = textFieldColors2.textColor(z8, composer2, ((i29 >> 9) & 14) | ((i32 >> 24) & 112)).getValue().m4073unboximpl();
                                            }
                                            composer2.endReplaceableGroup();
                                            TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                            int i42 = (i32 >> 24) & 112;
                                            TextStyle textStyle7 = textStyle3;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final boolean z19 = z8;
                                            final boolean z20 = z7;
                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42).getValue().m4073unboximpl(), shape3), z19, z20, mutableInteractionSource3, textFieldColors4, 0.0f, 0.0f, 48, null), z20, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                                            Modifier modifier4 = companion;
                                            SolidColor solidColor = new SolidColor(textFieldColors4.cursorColor(z20, composer2, (i32 & 14) | i42).getValue().m4073unboximpl(), null);
                                            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                            final boolean z21 = z10;
                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                            final Function2<? super Composer, ? super Integer, Unit> function216 = function27;
                                            final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                            int i43 = i32 << 12;
                                            boolean z22 = z11;
                                            Shape shape5 = shape3;
                                            Composer composer4 = composer2;
                                            KeyboardOptions keyboardOptions4 = keyboardOptions2;
                                            BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN4, z8, z22, merge, keyboardOptions4, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                                    int i45;
                                                    ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                                                    if ((i44 & 14) == 0) {
                                                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                                    } else {
                                                        i45 = i44;
                                                    }
                                                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                                                        }
                                                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z19, z21, visualTransformation4, mutableInteractionSource5, z20, function215, function216, function217, function218, textFieldColors4, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, (i29 & 64638) | (i43 & 3670016) | (i43 & 29360128) | (234881024 & i43) | (i43 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                                            composer3 = composer4;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            VisualTransformation visualTransformation5 = visualTransformation2;
                                            z12 = z10;
                                            visualTransformation3 = visualTransformation5;
                                            textStyle4 = textStyle7;
                                            textFieldColors3 = textFieldColors4;
                                            z13 = z8;
                                            z14 = z22;
                                            i33 = i30;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            function210 = function215;
                                            function211 = function27;
                                            function212 = function28;
                                            shape4 = shape5;
                                            keyboardOptions3 = keyboardOptions4;
                                            i34 = i31;
                                            function213 = function29;
                                            keyboardActions4 = keyboardActions3;
                                            z15 = z20;
                                            modifier3 = modifier4;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            z15 = z3;
                                            visualTransformation3 = visualTransformation;
                                            z12 = z4;
                                            i33 = i;
                                            i34 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer3 = startRestartGroup;
                                            z13 = z5;
                                            z14 = z6;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function26;
                                            modifier3 = modifier2;
                                            function212 = function23;
                                            function213 = function24;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions4 = keyboardActions;
                                        }
                                        endRestartGroup = composer3.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$3
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

                                                public final void invoke(Composer composer5, int i44) {
                                                    TextFieldKt.TextField(str, function1, modifier3, z13, z14, textStyle4, function210, function211, function212, function213, z15, visualTransformation3, keyboardOptions3, keyboardActions4, z12, i33, i34, mutableInteractionSource4, shape4, textFieldColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i24 = i37;
                                    if ((i4 & 458752) == 0) {
                                    }
                                    i25 = i5 & 65536;
                                    if (i25 == 0) {
                                    }
                                    i26 = i5 & 131072;
                                    if (i26 == 0) {
                                    }
                                    if ((i4 & 234881024) == 0) {
                                    }
                                    if ((i4 & 1879048192) == 0) {
                                    }
                                    int i382 = i24;
                                    if ((i6 & 1533916891) == 306783378) {
                                    }
                                    startRestartGroup.startDefaults();
                                    if ((i3 & 1) != 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i9 == 0) {
                                    }
                                    if ((i5 & 32) != 0) {
                                    }
                                    int i392 = i6;
                                    TextStyle textStyle52 = textStyle2;
                                    if (i10 == 0) {
                                    }
                                    if (i11 == 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if ((i5 & 8192) == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if ((32768 & i5) == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    if (i26 == 0) {
                                    }
                                    if ((262144 & i5) == 0) {
                                    }
                                    int i412 = i27;
                                    if ((i5 & 524288) == 0) {
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer2.startReplaceableGroup(-833027163);
                                    ComposerKt.sourceInformation(composer2, "*185@9608L18");
                                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                    }
                                    composer2.endReplaceableGroup();
                                    TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    int i422 = (i32 >> 24) & 112;
                                    TextStyle textStyle72 = textStyle3;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final boolean z192 = z8;
                                    final boolean z202 = z7;
                                    Modifier m912defaultMinSizeVpY3zN42 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422).getValue().m4073unboximpl(), shape3), z192, z202, mutableInteractionSource3, textFieldColors42, 0.0f, 0.0f, 48, null), z202, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                                    Modifier modifier42 = companion;
                                    SolidColor solidColor2 = new SolidColor(textFieldColors42.cursorColor(z202, composer2, (i32 & 14) | i422).getValue().m4073unboximpl(), null);
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final boolean z212 = z10;
                                    final VisualTransformation visualTransformation42 = visualTransformation2;
                                    final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                                    int i432 = i32 << 12;
                                    boolean z222 = z11;
                                    Shape shape52 = shape3;
                                    Composer composer42 = composer2;
                                    KeyboardOptions keyboardOptions42 = keyboardOptions2;
                                    BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN42, z8, z222, merge2, keyboardOptions42, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                            int i45;
                                            ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                                                }
                                                TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z192, z212, visualTransformation42, mutableInteractionSource52, z202, function2152, function2162, function2172, function2182, textFieldColors42, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer42, (i29 & 64638) | (i432 & 3670016) | (i432 & 29360128) | (234881024 & i432) | (i432 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                                    composer3 = composer42;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    VisualTransformation visualTransformation52 = visualTransformation2;
                                    z12 = z10;
                                    visualTransformation3 = visualTransformation52;
                                    textStyle4 = textStyle72;
                                    textFieldColors3 = textFieldColors42;
                                    z13 = z8;
                                    z14 = z222;
                                    i33 = i30;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    function210 = function2152;
                                    function211 = function27;
                                    function212 = function28;
                                    shape4 = shape52;
                                    keyboardOptions3 = keyboardOptions42;
                                    i34 = i31;
                                    function213 = function29;
                                    keyboardActions4 = keyboardActions3;
                                    z15 = z202;
                                    modifier3 = modifier42;
                                    endRestartGroup = composer3.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                            }
                            if ((i4 & 7168) == 0) {
                            }
                            int i372 = i22;
                            i23 = i5 & 16384;
                            if (i23 != 0) {
                            }
                            i24 = i372;
                            if ((i4 & 458752) == 0) {
                            }
                            i25 = i5 & 65536;
                            if (i25 == 0) {
                            }
                            i26 = i5 & 131072;
                            if (i26 == 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            if ((i4 & 1879048192) == 0) {
                            }
                            int i3822 = i24;
                            if ((i6 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            if ((i5 & 32) != 0) {
                            }
                            int i3922 = i6;
                            TextStyle textStyle522 = textStyle2;
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if ((i5 & 8192) == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if ((32768 & i5) == 0) {
                            }
                            if (i25 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if ((262144 & i5) == 0) {
                            }
                            int i4122 = i27;
                            if ((i5 & 524288) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(-833027163);
                            ComposerKt.sourceInformation(composer2, "*185@9608L18");
                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                            }
                            composer2.endReplaceableGroup();
                            TextStyle merge22 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            int i4222 = (i32 >> 24) & 112;
                            TextStyle textStyle722 = textStyle3;
                            final TextFieldColors textFieldColors422 = textFieldColors2;
                            final boolean z1922 = z8;
                            final boolean z2022 = z7;
                            Modifier m912defaultMinSizeVpY3zN422 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i4222).getValue().m4073unboximpl(), shape3), z1922, z2022, mutableInteractionSource3, textFieldColors422, 0.0f, 0.0f, 48, null), z2022, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                            Modifier modifier422 = companion;
                            SolidColor solidColor22 = new SolidColor(textFieldColors422.cursorColor(z2022, composer2, (i32 & 14) | i4222).getValue().m4073unboximpl(), null);
                            final Function2<? super Composer, ? super Integer, Unit> function21522 = function25;
                            final boolean z2122 = z10;
                            final VisualTransformation visualTransformation422 = visualTransformation2;
                            final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                            final Function2<? super Composer, ? super Integer, Unit> function21622 = function27;
                            final Function2<? super Composer, ? super Integer, Unit> function21722 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            int i4322 = i32 << 12;
                            boolean z2222 = z11;
                            Shape shape522 = shape3;
                            Composer composer422 = composer2;
                            KeyboardOptions keyboardOptions422 = keyboardOptions2;
                            BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN422, z8, z2222, merge22, keyboardOptions422, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor22, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                    int i45;
                                    ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                                    if ((i44 & 14) == 0) {
                                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                    } else {
                                        i45 = i44;
                                    }
                                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                                        }
                                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z1922, z2122, visualTransformation422, mutableInteractionSource522, z2022, function21522, function21622, function21722, function21822, textFieldColors422, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer422, (i29 & 64638) | (i4322 & 3670016) | (i4322 & 29360128) | (234881024 & i4322) | (i4322 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                            composer3 = composer422;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            VisualTransformation visualTransformation522 = visualTransformation2;
                            z12 = z10;
                            visualTransformation3 = visualTransformation522;
                            textStyle4 = textStyle722;
                            textFieldColors3 = textFieldColors422;
                            z13 = z8;
                            z14 = z2222;
                            i33 = i30;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function210 = function21522;
                            function211 = function27;
                            function212 = function28;
                            shape4 = shape522;
                            keyboardOptions3 = keyboardOptions422;
                            i34 = i31;
                            function213 = function29;
                            keyboardActions4 = keyboardActions3;
                            z15 = z2022;
                            modifier3 = modifier422;
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i5 & 2048;
                        if (i19 == 0) {
                        }
                        int i362 = i18;
                        i21 = i5 & 4096;
                        if (i21 == 0) {
                        }
                        if ((i4 & 7168) == 0) {
                        }
                        int i3722 = i22;
                        i23 = i5 & 16384;
                        if (i23 != 0) {
                        }
                        i24 = i3722;
                        if ((i4 & 458752) == 0) {
                        }
                        i25 = i5 & 65536;
                        if (i25 == 0) {
                        }
                        i26 = i5 & 131072;
                        if (i26 == 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        if ((i4 & 1879048192) == 0) {
                        }
                        int i38222 = i24;
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i5 & 32) != 0) {
                        }
                        int i39222 = i6;
                        TextStyle textStyle5222 = textStyle2;
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if ((i5 & 8192) == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if ((32768 & i5) == 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if ((262144 & i5) == 0) {
                        }
                        int i41222 = i27;
                        if ((i5 & 524288) == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2.startReplaceableGroup(-833027163);
                        ComposerKt.sourceInformation(composer2, "*185@9608L18");
                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        }
                        composer2.endReplaceableGroup();
                        TextStyle merge222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                        int i42222 = (i32 >> 24) & 112;
                        TextStyle textStyle7222 = textStyle3;
                        final TextFieldColors textFieldColors4222 = textFieldColors2;
                        final boolean z19222 = z8;
                        final boolean z20222 = z7;
                        Modifier m912defaultMinSizeVpY3zN4222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42222).getValue().m4073unboximpl(), shape3), z19222, z20222, mutableInteractionSource3, textFieldColors4222, 0.0f, 0.0f, 48, null), z20222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                        Modifier modifier4222 = companion;
                        SolidColor solidColor222 = new SolidColor(textFieldColors4222.cursorColor(z20222, composer2, (i32 & 14) | i42222).getValue().m4073unboximpl(), null);
                        final Function2<? super Composer, ? super Integer, Unit> function215222 = function25;
                        final boolean z21222 = z10;
                        final VisualTransformation visualTransformation4222 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                        final Function2<? super Composer, ? super Integer, Unit> function216222 = function27;
                        final Function2<? super Composer, ? super Integer, Unit> function217222 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                        int i43222 = i32 << 12;
                        boolean z22222 = z11;
                        Shape shape5222 = shape3;
                        Composer composer4222 = composer2;
                        KeyboardOptions keyboardOptions4222 = keyboardOptions2;
                        BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN4222, z8, z22222, merge222, keyboardOptions4222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor222, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                int i45;
                                ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                                if ((i44 & 14) == 0) {
                                    i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                } else {
                                    i45 = i44;
                                }
                                if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                                    }
                                    TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z19222, z21222, visualTransformation4222, mutableInteractionSource5222, z20222, function215222, function216222, function217222, function218222, textFieldColors4222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4222, (i29 & 64638) | (i43222 & 3670016) | (i43222 & 29360128) | (234881024 & i43222) | (i43222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                        composer3 = composer4222;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        VisualTransformation visualTransformation5222 = visualTransformation2;
                        z12 = z10;
                        visualTransformation3 = visualTransformation5222;
                        textStyle4 = textStyle7222;
                        textFieldColors3 = textFieldColors4222;
                        z13 = z8;
                        z14 = z22222;
                        i33 = i30;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function210 = function215222;
                        function211 = function27;
                        function212 = function28;
                        shape4 = shape5222;
                        keyboardOptions3 = keyboardOptions4222;
                        i34 = i31;
                        function213 = function29;
                        keyboardActions4 = keyboardActions3;
                        z15 = z20222;
                        modifier3 = modifier4222;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i13 = i12;
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i5 & 2048;
                    if (i19 == 0) {
                    }
                    int i3622 = i18;
                    i21 = i5 & 4096;
                    if (i21 == 0) {
                    }
                    if ((i4 & 7168) == 0) {
                    }
                    int i37222 = i22;
                    i23 = i5 & 16384;
                    if (i23 != 0) {
                    }
                    i24 = i37222;
                    if ((i4 & 458752) == 0) {
                    }
                    i25 = i5 & 65536;
                    if (i25 == 0) {
                    }
                    i26 = i5 & 131072;
                    if (i26 == 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    int i382222 = i24;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i5 & 32) != 0) {
                    }
                    int i392222 = i6;
                    TextStyle textStyle52222 = textStyle2;
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if ((i5 & 8192) == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if ((32768 & i5) == 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if ((262144 & i5) == 0) {
                    }
                    int i412222 = i27;
                    if ((i5 & 524288) == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2.startReplaceableGroup(-833027163);
                    ComposerKt.sourceInformation(composer2, "*185@9608L18");
                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    composer2.endReplaceableGroup();
                    TextStyle merge2222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                    int i422222 = (i32 >> 24) & 112;
                    TextStyle textStyle72222 = textStyle3;
                    final TextFieldColors textFieldColors42222 = textFieldColors2;
                    final boolean z192222 = z8;
                    final boolean z202222 = z7;
                    Modifier m912defaultMinSizeVpY3zN42222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422222).getValue().m4073unboximpl(), shape3), z192222, z202222, mutableInteractionSource3, textFieldColors42222, 0.0f, 0.0f, 48, null), z202222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                    Modifier modifier42222 = companion;
                    SolidColor solidColor2222 = new SolidColor(textFieldColors42222.cursorColor(z202222, composer2, (i32 & 14) | i422222).getValue().m4073unboximpl(), null);
                    final Function2<? super Composer, ? super Integer, Unit> function2152222 = function25;
                    final boolean z212222 = z10;
                    final VisualTransformation visualTransformation42222 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                    final Function2<? super Composer, ? super Integer, Unit> function2162222 = function27;
                    final Function2<? super Composer, ? super Integer, Unit> function2172222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                    int i432222 = i32 << 12;
                    boolean z222222 = z11;
                    Shape shape52222 = shape3;
                    Composer composer42222 = composer2;
                    KeyboardOptions keyboardOptions42222 = keyboardOptions2;
                    BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN42222, z8, z222222, merge2222, keyboardOptions42222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2222, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                            int i45;
                            ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                            if ((i44 & 14) == 0) {
                                i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                            } else {
                                i45 = i44;
                            }
                            if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                                }
                                TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z192222, z212222, visualTransformation42222, mutableInteractionSource52222, z202222, function2152222, function2162222, function2172222, function2182222, textFieldColors42222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer42222, (i29 & 64638) | (i432222 & 3670016) | (i432222 & 29360128) | (234881024 & i432222) | (i432222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                    composer3 = composer42222;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    VisualTransformation visualTransformation52222 = visualTransformation2;
                    z12 = z10;
                    visualTransformation3 = visualTransformation52222;
                    textStyle4 = textStyle72222;
                    textFieldColors3 = textFieldColors42222;
                    z13 = z8;
                    z14 = z222222;
                    i33 = i30;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function210 = function2152222;
                    function211 = function27;
                    function212 = function28;
                    shape4 = shape52222;
                    keyboardOptions3 = keyboardOptions42222;
                    i34 = i31;
                    function213 = function29;
                    keyboardActions4 = keyboardActions3;
                    z15 = z202222;
                    modifier3 = modifier42222;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                if ((i3 & 458752) != 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                i19 = i5 & 2048;
                if (i19 == 0) {
                }
                int i36222 = i18;
                i21 = i5 & 4096;
                if (i21 == 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                int i372222 = i22;
                i23 = i5 & 16384;
                if (i23 != 0) {
                }
                i24 = i372222;
                if ((i4 & 458752) == 0) {
                }
                i25 = i5 & 65536;
                if (i25 == 0) {
                }
                i26 = i5 & 131072;
                if (i26 == 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                int i3822222 = i24;
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i5 & 32) != 0) {
                }
                int i3922222 = i6;
                TextStyle textStyle522222 = textStyle2;
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i17 == 0) {
                }
                if (i20 == 0) {
                }
                if (i21 == 0) {
                }
                if ((i5 & 8192) == 0) {
                }
                if (i23 == 0) {
                }
                if ((32768 & i5) == 0) {
                }
                if (i25 == 0) {
                }
                if (i26 == 0) {
                }
                if ((262144 & i5) == 0) {
                }
                int i4122222 = i27;
                if ((i5 & 524288) == 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2.startReplaceableGroup(-833027163);
                ComposerKt.sourceInformation(composer2, "*185@9608L18");
                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                composer2.endReplaceableGroup();
                TextStyle merge22222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                int i4222222 = (i32 >> 24) & 112;
                TextStyle textStyle722222 = textStyle3;
                final TextFieldColors textFieldColors422222 = textFieldColors2;
                final boolean z1922222 = z8;
                final boolean z2022222 = z7;
                Modifier m912defaultMinSizeVpY3zN422222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i4222222).getValue().m4073unboximpl(), shape3), z1922222, z2022222, mutableInteractionSource3, textFieldColors422222, 0.0f, 0.0f, 48, null), z2022222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                Modifier modifier422222 = companion;
                SolidColor solidColor22222 = new SolidColor(textFieldColors422222.cursorColor(z2022222, composer2, (i32 & 14) | i4222222).getValue().m4073unboximpl(), null);
                final Function2<? super Composer, ? super Integer, Unit> function21522222 = function25;
                final boolean z2122222 = z10;
                final VisualTransformation visualTransformation422222 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function21622222 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function21722222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
                int i4322222 = i32 << 12;
                boolean z2222222 = z11;
                Shape shape522222 = shape3;
                Composer composer422222 = composer2;
                KeyboardOptions keyboardOptions422222 = keyboardOptions2;
                BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN422222, z8, z2222222, merge22222, keyboardOptions422222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor22222, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                        int i45;
                        ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                        if ((i44 & 14) == 0) {
                            i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                        } else {
                            i45 = i44;
                        }
                        if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                            }
                            TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z1922222, z2122222, visualTransformation422222, mutableInteractionSource522222, z2022222, function21522222, function21622222, function21722222, function21822222, textFieldColors422222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }), composer422222, (i29 & 64638) | (i4322222 & 3670016) | (i4322222 & 29360128) | (234881024 & i4322222) | (i4322222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                composer3 = composer422222;
                if (ComposerKt.isTraceInProgress()) {
                }
                VisualTransformation visualTransformation522222 = visualTransformation2;
                z12 = z10;
                visualTransformation3 = visualTransformation522222;
                textStyle4 = textStyle722222;
                textFieldColors3 = textFieldColors422222;
                z13 = z8;
                z14 = z2222222;
                i33 = i30;
                mutableInteractionSource4 = mutableInteractionSource3;
                function210 = function21522222;
                function211 = function27;
                function212 = function28;
                shape4 = shape522222;
                keyboardOptions3 = keyboardOptions422222;
                i34 = i31;
                function213 = function29;
                keyboardActions4 = keyboardActions3;
                z15 = z2022222;
                modifier3 = modifier422222;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
            int i352 = 2048;
            if (i8 != 0) {
            }
            z5 = z;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            if ((i3 & 458752) != 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            i19 = i5 & 2048;
            if (i19 == 0) {
            }
            int i362222 = i18;
            i21 = i5 & 4096;
            if (i21 == 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            int i3722222 = i22;
            i23 = i5 & 16384;
            if (i23 != 0) {
            }
            i24 = i3722222;
            if ((i4 & 458752) == 0) {
            }
            i25 = i5 & 65536;
            if (i25 == 0) {
            }
            i26 = i5 & 131072;
            if (i26 == 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            int i38222222 = i24;
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if ((i5 & 32) != 0) {
            }
            int i39222222 = i6;
            TextStyle textStyle5222222 = textStyle2;
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i17 == 0) {
            }
            if (i20 == 0) {
            }
            if (i21 == 0) {
            }
            if ((i5 & 8192) == 0) {
            }
            if (i23 == 0) {
            }
            if ((32768 & i5) == 0) {
            }
            if (i25 == 0) {
            }
            if (i26 == 0) {
            }
            if ((262144 & i5) == 0) {
            }
            int i41222222 = i27;
            if ((i5 & 524288) == 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2.startReplaceableGroup(-833027163);
            ComposerKt.sourceInformation(composer2, "*185@9608L18");
            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            composer2.endReplaceableGroup();
            TextStyle merge222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            int i42222222 = (i32 >> 24) & 112;
            TextStyle textStyle7222222 = textStyle3;
            final TextFieldColors textFieldColors4222222 = textFieldColors2;
            final boolean z19222222 = z8;
            final boolean z20222222 = z7;
            Modifier m912defaultMinSizeVpY3zN4222222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42222222).getValue().m4073unboximpl(), shape3), z19222222, z20222222, mutableInteractionSource3, textFieldColors4222222, 0.0f, 0.0f, 48, null), z20222222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
            Modifier modifier4222222 = companion;
            SolidColor solidColor222222 = new SolidColor(textFieldColors4222222.cursorColor(z20222222, composer2, (i32 & 14) | i42222222).getValue().m4073unboximpl(), null);
            final Function2<? super Composer, ? super Integer, Unit> function215222222 = function25;
            final boolean z21222222 = z10;
            final VisualTransformation visualTransformation4222222 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
            final Function2<? super Composer, ? super Integer, Unit> function216222222 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function217222222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
            int i43222222 = i32 << 12;
            boolean z22222222 = z11;
            Shape shape5222222 = shape3;
            Composer composer4222222 = composer2;
            KeyboardOptions keyboardOptions4222222 = keyboardOptions2;
            BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN4222222, z8, z22222222, merge222222, keyboardOptions4222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor222222, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                    int i45;
                    ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                    if ((i44 & 14) == 0) {
                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                    } else {
                        i45 = i44;
                    }
                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                        }
                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z19222222, z21222222, visualTransformation4222222, mutableInteractionSource5222222, z20222222, function215222222, function216222222, function217222222, function218222222, textFieldColors4222222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }), composer4222222, (i29 & 64638) | (i43222222 & 3670016) | (i43222222 & 29360128) | (234881024 & i43222222) | (i43222222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
            composer3 = composer4222222;
            if (ComposerKt.isTraceInProgress()) {
            }
            VisualTransformation visualTransformation5222222 = visualTransformation2;
            z12 = z10;
            visualTransformation3 = visualTransformation5222222;
            textStyle4 = textStyle7222222;
            textFieldColors3 = textFieldColors4222222;
            z13 = z8;
            z14 = z22222222;
            i33 = i30;
            mutableInteractionSource4 = mutableInteractionSource3;
            function210 = function215222222;
            function211 = function27;
            function212 = function28;
            shape4 = shape5222222;
            keyboardOptions3 = keyboardOptions4222222;
            i34 = i31;
            function213 = function29;
            keyboardActions4 = keyboardActions3;
            z15 = z20222222;
            modifier3 = modifier4222222;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
        int i3522 = 2048;
        if (i8 != 0) {
        }
        z5 = z;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        if ((i3 & 458752) != 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        i19 = i5 & 2048;
        if (i19 == 0) {
        }
        int i3622222 = i18;
        i21 = i5 & 4096;
        if (i21 == 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        int i37222222 = i22;
        i23 = i5 & 16384;
        if (i23 != 0) {
        }
        i24 = i37222222;
        if ((i4 & 458752) == 0) {
        }
        i25 = i5 & 65536;
        if (i25 == 0) {
        }
        i26 = i5 & 131072;
        if (i26 == 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        int i382222222 = i24;
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i5 & 32) != 0) {
        }
        int i392222222 = i6;
        TextStyle textStyle52222222 = textStyle2;
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i17 == 0) {
        }
        if (i20 == 0) {
        }
        if (i21 == 0) {
        }
        if ((i5 & 8192) == 0) {
        }
        if (i23 == 0) {
        }
        if ((32768 & i5) == 0) {
        }
        if (i25 == 0) {
        }
        if (i26 == 0) {
        }
        if ((262144 & i5) == 0) {
        }
        int i412222222 = i27;
        if ((i5 & 524288) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.startReplaceableGroup(-833027163);
        ComposerKt.sourceInformation(composer2, "*185@9608L18");
        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        composer2.endReplaceableGroup();
        TextStyle merge2222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        int i422222222 = (i32 >> 24) & 112;
        TextStyle textStyle72222222 = textStyle3;
        final TextFieldColors textFieldColors42222222 = textFieldColors2;
        final boolean z192222222 = z8;
        final boolean z202222222 = z7;
        Modifier m912defaultMinSizeVpY3zN42222222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422222222).getValue().m4073unboximpl(), shape3), z192222222, z202222222, mutableInteractionSource3, textFieldColors42222222, 0.0f, 0.0f, 48, null), z202222222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
        Modifier modifier42222222 = companion;
        SolidColor solidColor2222222 = new SolidColor(textFieldColors42222222.cursorColor(z202222222, composer2, (i32 & 14) | i422222222).getValue().m4073unboximpl(), null);
        final Function2<? super Composer, ? super Integer, Unit> function2152222222 = function25;
        final boolean z212222222 = z10;
        final VisualTransformation visualTransformation42222222 = visualTransformation2;
        final MutableInteractionSource mutableInteractionSource52222222 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2162222222 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function2172222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2182222222 = function29;
        int i432222222 = i32 << 12;
        boolean z222222222 = z11;
        Shape shape52222222 = shape3;
        Composer composer42222222 = composer2;
        KeyboardOptions keyboardOptions42222222 = keyboardOptions2;
        BasicTextFieldKt.BasicTextField(str, function1, m912defaultMinSizeVpY3zN42222222, z8, z222222222, merge2222222, keyboardOptions42222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2222222, ComposableLambdaKt.composableLambda(composer2, 989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                int i45;
                ComposerKt.sourceInformation(composer5, "C214@10860L538:TextField.kt#jmzs0o");
                if ((i44 & 14) == 0) {
                    i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                } else {
                    i45 = i44;
                }
                if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(989834338, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:214)");
                    }
                    TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function219, z192222222, z212222222, visualTransformation42222222, mutableInteractionSource52222222, z202222222, function2152222222, function2162222222, function2172222222, function2182222222, textFieldColors42222222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }), composer42222222, (i29 & 64638) | (i432222222 & 3670016) | (i432222222 & 29360128) | (234881024 & i432222222) | (i432222222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
        composer3 = composer42222222;
        if (ComposerKt.isTraceInProgress()) {
        }
        VisualTransformation visualTransformation52222222 = visualTransformation2;
        z12 = z10;
        visualTransformation3 = visualTransformation52222222;
        textStyle4 = textStyle72222222;
        textFieldColors3 = textFieldColors42222222;
        z13 = z8;
        z14 = z222222222;
        i33 = i30;
        mutableInteractionSource4 = mutableInteractionSource3;
        function210 = function2152222222;
        function211 = function27;
        function212 = function28;
        shape4 = shape52222222;
        keyboardOptions3 = keyboardOptions42222222;
        i34 = i31;
        function213 = function29;
        keyboardActions4 = keyboardActions3;
        z15 = z202222222;
        modifier3 = modifier42222222;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d3, code lost:
    
        if (r3.changed(r86) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2 function25;
        int i10;
        Function2 function26;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        TextStyle textStyle3;
        int i27;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
        KeyboardActions keyboardActions3;
        Modifier modifier3;
        boolean z7;
        boolean z8;
        int i28;
        Function2 function27;
        Function2 function28;
        Function2 function29;
        boolean z9;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean z10;
        int i29;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function210;
        final Function2 function211;
        final Function2 function212;
        final Function2 function213;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final boolean z14;
        final int i30;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)243@11767L7,254@12321L39,256@12403L6,257@12528L17,259@12554L408:TextField.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i7 = i4 & 8;
                int i31 = 2048;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    z5 = z;
                    i5 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        z6 = z2;
                    } else {
                        z6 = z2;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        }
                    }
                    if ((i2 & 458752) != 0) {
                        textStyle2 = textStyle;
                        i5 |= ((i4 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & 29360128) == 0) {
                            i5 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= C.ENCODING_PCM_32BIT;
                        } else if ((i2 & 1879048192) == 0) {
                            i14 = i13;
                            i5 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i15 = i4 & 1024;
                            if (i15 == 0) {
                                i17 = i3 | 6;
                                i16 = i15;
                            } else if ((i3 & 14) == 0) {
                                i16 = i15;
                                i17 = i3 | (startRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i3;
                            }
                            i18 = i4 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                                i19 = i18;
                            } else if ((i3 & 112) == 0) {
                                i19 = i18;
                                i17 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i19 = i18;
                            }
                            int i32 = i17;
                            i20 = i4 & 4096;
                            if (i20 == 0) {
                                i21 = i32 | 384;
                            } else {
                                i21 = i32;
                                if ((i3 & 896) == 0) {
                                    i21 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                    if ((i3 & 7168) == 0) {
                                        if ((i4 & 8192) != 0) {
                                        }
                                        i31 = 1024;
                                        i21 |= i31;
                                    }
                                    int i33 = i21;
                                    i22 = i4 & 16384;
                                    if (i22 != 0) {
                                        i33 |= 24576;
                                    } else if ((i3 & 57344) == 0) {
                                        i23 = i33 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                        i24 = i4 & 32768;
                                        if (i24 == 0) {
                                            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i3 & 458752) == 0) {
                                            i23 |= startRestartGroup.changed(i) ? 131072 : 65536;
                                        }
                                        i25 = i4 & 65536;
                                        if (i25 == 0) {
                                            i23 |= 1572864;
                                        } else if ((i3 & 3670016) == 0) {
                                            i23 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                        }
                                        if ((i3 & 29360128) == 0) {
                                            i23 |= ((i4 & 131072) == 0 && startRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                        }
                                        if ((i3 & 234881024) == 0) {
                                            i23 |= ((i4 & 262144) == 0 && startRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                        }
                                        i26 = i23;
                                        if ((i5 & 1533916891) == 306783378 || (191739611 & i26) != 38347922 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                                                boolean z15 = i7 == 0 ? true : z5;
                                                boolean z16 = i8 == 0 ? false : z6;
                                                if ((i4 & 32) == 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    i5 &= -458753;
                                                    textStyle3 = (TextStyle) consume;
                                                } else {
                                                    textStyle3 = textStyle2;
                                                }
                                                int i34 = i5;
                                                Function2 function214 = i9 == 0 ? null : function25;
                                                Function2 function215 = i10 == 0 ? null : function26;
                                                Function2 function216 = i12 == 0 ? null : function23;
                                                Function2 function217 = i14 == 0 ? null : function24;
                                                boolean z17 = i16 == 0 ? false : z3;
                                                VisualTransformation none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i20 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                if ((i4 & 8192) == 0) {
                                                    i27 = i26 & (-7169);
                                                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                                } else {
                                                    i27 = i26;
                                                    keyboardActions2 = keyboardActions;
                                                }
                                                boolean z18 = i22 == 0 ? false : z4;
                                                int i35 = i24 == 0 ? Integer.MAX_VALUE : i;
                                                if (i25 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-492369756);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    startRestartGroup.endReplaceableGroup();
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i4 & 131072) == 0) {
                                                    i27 &= -29360129;
                                                    shape2 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i36 = i27;
                                                if ((262144 & i4) == 0) {
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    modifier3 = companion;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.m1827textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
                                                    i26 = i36 & (-234881025);
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle2 = textStyle3;
                                                    i28 = i34;
                                                    function25 = function214;
                                                    function27 = function215;
                                                    function28 = function216;
                                                    function29 = function217;
                                                    z9 = z17;
                                                    visualTransformation2 = none;
                                                    keyboardOptions2 = keyboardOptions4;
                                                    z10 = z18;
                                                    i29 = i35;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                } else {
                                                    composer2 = startRestartGroup;
                                                    textFieldColors2 = textFieldColors;
                                                    keyboardActions3 = keyboardActions2;
                                                    modifier3 = companion;
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle2 = textStyle3;
                                                    i28 = i34;
                                                    function25 = function214;
                                                    function27 = function215;
                                                    function28 = function216;
                                                    function29 = function217;
                                                    z9 = z17;
                                                    visualTransformation2 = none;
                                                    keyboardOptions2 = keyboardOptions4;
                                                    z10 = z18;
                                                    i29 = i35;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                    i26 = i36;
                                                }
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i4 & 32) != 0) {
                                                    i5 &= -458753;
                                                }
                                                if ((i4 & 8192) != 0) {
                                                    i26 &= -7169;
                                                }
                                                if ((i4 & 131072) != 0) {
                                                    i26 &= -29360129;
                                                }
                                                if ((262144 & i4) != 0) {
                                                    i26 &= -234881025;
                                                }
                                                function28 = function23;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions3 = keyboardActions;
                                                z10 = z4;
                                                i29 = i;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                composer2 = startRestartGroup;
                                                z8 = z6;
                                                i28 = i5;
                                                function27 = function26;
                                                modifier3 = modifier2;
                                                function29 = function24;
                                                z9 = z3;
                                                z7 = z5;
                                            }
                                            composer2.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1690895095, i28, i26, "androidx.compose.material.TextField (TextField.kt:258)");
                                            }
                                            int i37 = i28 & 2147483646;
                                            int i38 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                                            int i39 = i26 << 3;
                                            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37, i38 | (29360128 & i39) | (234881024 & i39) | (i39 & 1879048192), 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z7;
                                            z12 = z8;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function27;
                                            function212 = function28;
                                            function213 = function29;
                                            z13 = z9;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions4 = keyboardActions3;
                                            z14 = z10;
                                            i30 = i29;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            z13 = z3;
                                            visualTransformation3 = visualTransformation;
                                            z14 = z4;
                                            i30 = i;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function26;
                                            modifier4 = modifier2;
                                            function212 = function23;
                                            function213 = function24;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions4 = keyboardActions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$5
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

                                                public final void invoke(Composer composer3, int i40) {
                                                    TextFieldKt.TextField(str, function1, modifier4, z11, z12, textStyle4, function210, function211, function212, function213, z13, visualTransformation3, keyboardOptions3, keyboardActions4, z14, i30, mutableInteractionSource4, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i23 = i33;
                                    i24 = i4 & 32768;
                                    if (i24 == 0) {
                                    }
                                    i25 = i4 & 65536;
                                    if (i25 == 0) {
                                    }
                                    if ((i3 & 29360128) == 0) {
                                    }
                                    if ((i3 & 234881024) == 0) {
                                    }
                                    i26 = i23;
                                    if ((i5 & 1533916891) == 306783378) {
                                    }
                                    startRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0) {
                                    }
                                    if (i6 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if ((i4 & 32) == 0) {
                                    }
                                    int i342 = i5;
                                    if (i9 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if ((i4 & 8192) == 0) {
                                    }
                                    if (i22 == 0) {
                                    }
                                    if (i24 == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    if ((i4 & 131072) == 0) {
                                    }
                                    int i362 = i27;
                                    if ((262144 & i4) == 0) {
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i372 = i28 & 2147483646;
                                    int i382 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                                    int i392 = i26 << 3;
                                    TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372, i382 | (29360128 & i392) | (234881024 & i392) | (i392 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier4 = modifier3;
                                    z11 = z7;
                                    z12 = z8;
                                    textStyle4 = textStyle2;
                                    function210 = function25;
                                    function211 = function27;
                                    function212 = function28;
                                    function213 = function29;
                                    z13 = z9;
                                    visualTransformation3 = visualTransformation2;
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActions4 = keyboardActions3;
                                    z14 = z10;
                                    i30 = i29;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    shape4 = shape3;
                                    textFieldColors3 = textFieldColors2;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                            }
                            if ((i3 & 7168) == 0) {
                            }
                            int i332 = i21;
                            i22 = i4 & 16384;
                            if (i22 != 0) {
                            }
                            i23 = i332;
                            i24 = i4 & 32768;
                            if (i24 == 0) {
                            }
                            i25 = i4 & 65536;
                            if (i25 == 0) {
                            }
                            if ((i3 & 29360128) == 0) {
                            }
                            if ((i3 & 234881024) == 0) {
                            }
                            i26 = i23;
                            if ((i5 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i4 & 32) == 0) {
                            }
                            int i3422 = i5;
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if ((i4 & 8192) == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i25 == 0) {
                            }
                            if ((i4 & 131072) == 0) {
                            }
                            int i3622 = i27;
                            if ((262144 & i4) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i3722 = i28 & 2147483646;
                            int i3822 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                            int i3922 = i26 << 3;
                            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722, i3822 | (29360128 & i3922) | (234881024 & i3922) | (i3922 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z7;
                            z12 = z8;
                            textStyle4 = textStyle2;
                            function210 = function25;
                            function211 = function27;
                            function212 = function28;
                            function213 = function29;
                            z13 = z9;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions4 = keyboardActions3;
                            z14 = z10;
                            i30 = i29;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i4 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i4 & 2048;
                        if (i18 == 0) {
                        }
                        int i322 = i17;
                        i20 = i4 & 4096;
                        if (i20 == 0) {
                        }
                        if ((i3 & 7168) == 0) {
                        }
                        int i3322 = i21;
                        i22 = i4 & 16384;
                        if (i22 != 0) {
                        }
                        i23 = i3322;
                        i24 = i4 & 32768;
                        if (i24 == 0) {
                        }
                        i25 = i4 & 65536;
                        if (i25 == 0) {
                        }
                        if ((i3 & 29360128) == 0) {
                        }
                        if ((i3 & 234881024) == 0) {
                        }
                        i26 = i23;
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i4 & 32) == 0) {
                        }
                        int i34222 = i5;
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if ((i4 & 8192) == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i25 == 0) {
                        }
                        if ((i4 & 131072) == 0) {
                        }
                        int i36222 = i27;
                        if ((262144 & i4) == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i37222 = i28 & 2147483646;
                        int i38222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                        int i39222 = i26 << 3;
                        TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222, i38222 | (29360128 & i39222) | (234881024 & i39222) | (i39222 & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z7;
                        z12 = z8;
                        textStyle4 = textStyle2;
                        function210 = function25;
                        function211 = function27;
                        function212 = function28;
                        function213 = function29;
                        z13 = z9;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions4 = keyboardActions3;
                        z14 = z10;
                        i30 = i29;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 == 0) {
                    }
                    int i3222 = i17;
                    i20 = i4 & 4096;
                    if (i20 == 0) {
                    }
                    if ((i3 & 7168) == 0) {
                    }
                    int i33222 = i21;
                    i22 = i4 & 16384;
                    if (i22 != 0) {
                    }
                    i23 = i33222;
                    i24 = i4 & 32768;
                    if (i24 == 0) {
                    }
                    i25 = i4 & 65536;
                    if (i25 == 0) {
                    }
                    if ((i3 & 29360128) == 0) {
                    }
                    if ((i3 & 234881024) == 0) {
                    }
                    i26 = i23;
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i4 & 32) == 0) {
                    }
                    int i342222 = i5;
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if ((i4 & 8192) == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i25 == 0) {
                    }
                    if ((i4 & 131072) == 0) {
                    }
                    int i362222 = i27;
                    if ((262144 & i4) == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i372222 = i28 & 2147483646;
                    int i382222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                    int i392222 = i26 << 3;
                    TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222, i382222 | (29360128 & i392222) | (234881024 & i392222) | (i392222 & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z7;
                    z12 = z8;
                    textStyle4 = textStyle2;
                    function210 = function25;
                    function211 = function27;
                    function212 = function28;
                    function213 = function29;
                    z13 = z9;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions4 = keyboardActions3;
                    z14 = z10;
                    i30 = i29;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                if ((i2 & 458752) != 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 == 0) {
                }
                i18 = i4 & 2048;
                if (i18 == 0) {
                }
                int i32222 = i17;
                i20 = i4 & 4096;
                if (i20 == 0) {
                }
                if ((i3 & 7168) == 0) {
                }
                int i332222 = i21;
                i22 = i4 & 16384;
                if (i22 != 0) {
                }
                i23 = i332222;
                i24 = i4 & 32768;
                if (i24 == 0) {
                }
                i25 = i4 & 65536;
                if (i25 == 0) {
                }
                if ((i3 & 29360128) == 0) {
                }
                if ((i3 & 234881024) == 0) {
                }
                i26 = i23;
                if ((i5 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i4 & 32) == 0) {
                }
                int i3422222 = i5;
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                if ((i4 & 8192) == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i25 == 0) {
                }
                if ((i4 & 131072) == 0) {
                }
                int i3622222 = i27;
                if ((262144 & i4) == 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i3722222 = i28 & 2147483646;
                int i3822222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                int i3922222 = i26 << 3;
                TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722222, i3822222 | (29360128 & i3922222) | (234881024 & i3922222) | (i3922222 & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z7;
                z12 = z8;
                textStyle4 = textStyle2;
                function210 = function25;
                function211 = function27;
                function212 = function28;
                function213 = function29;
                z13 = z9;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions4 = keyboardActions3;
                z14 = z10;
                i30 = i29;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 8;
            int i312 = 2048;
            if (i7 != 0) {
            }
            z5 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            if ((i2 & 458752) != 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 == 0) {
            }
            i18 = i4 & 2048;
            if (i18 == 0) {
            }
            int i322222 = i17;
            i20 = i4 & 4096;
            if (i20 == 0) {
            }
            if ((i3 & 7168) == 0) {
            }
            int i3322222 = i21;
            i22 = i4 & 16384;
            if (i22 != 0) {
            }
            i23 = i3322222;
            i24 = i4 & 32768;
            if (i24 == 0) {
            }
            i25 = i4 & 65536;
            if (i25 == 0) {
            }
            if ((i3 & 29360128) == 0) {
            }
            if ((i3 & 234881024) == 0) {
            }
            i26 = i23;
            if ((i5 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i4 & 32) == 0) {
            }
            int i34222222 = i5;
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            if ((i4 & 8192) == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i25 == 0) {
            }
            if ((i4 & 131072) == 0) {
            }
            int i36222222 = i27;
            if ((262144 & i4) == 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i37222222 = i28 & 2147483646;
            int i38222222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
            int i39222222 = i26 << 3;
            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222222, i38222222 | (29360128 & i39222222) | (234881024 & i39222222) | (i39222222 & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z7;
            z12 = z8;
            textStyle4 = textStyle2;
            function210 = function25;
            function211 = function27;
            function212 = function28;
            function213 = function29;
            z13 = z9;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            z14 = z10;
            i30 = i29;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 8;
        int i3122 = 2048;
        if (i7 != 0) {
        }
        z5 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        if ((i2 & 458752) != 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 == 0) {
        }
        i18 = i4 & 2048;
        if (i18 == 0) {
        }
        int i3222222 = i17;
        i20 = i4 & 4096;
        if (i20 == 0) {
        }
        if ((i3 & 7168) == 0) {
        }
        int i33222222 = i21;
        i22 = i4 & 16384;
        if (i22 != 0) {
        }
        i23 = i33222222;
        i24 = i4 & 32768;
        if (i24 == 0) {
        }
        i25 = i4 & 65536;
        if (i25 == 0) {
        }
        if ((i3 & 29360128) == 0) {
        }
        if ((i3 & 234881024) == 0) {
        }
        i26 = i23;
        if ((i5 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        int i342222222 = i5;
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        if ((i4 & 8192) == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i25 == 0) {
        }
        if ((i4 & 131072) == 0) {
        }
        int i362222222 = i27;
        if ((262144 & i4) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i372222222 = i28 & 2147483646;
        int i382222222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
        int i392222222 = i26 << 3;
        TextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222222, i382222222 | (29360128 & i392222222) | (234881024 & i392222222) | (i392222222 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z7;
        z12 = z8;
        textStyle4 = textStyle2;
        function210 = function25;
        function211 = function27;
        function212 = function28;
        function213 = function29;
        z13 = z9;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions4 = keyboardActions3;
        z14 = z10;
        i30 = i29;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d5, code lost:
    
        if (r3.changed(r119) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        boolean z7;
        KeyboardOptions keyboardOptions2;
        int i27;
        KeyboardActions keyboardActions2;
        int i28;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
        KeyboardActions keyboardActions3;
        boolean z8;
        boolean z9;
        TextStyle textStyle3;
        int i29;
        VisualTransformation visualTransformation2;
        boolean z10;
        int i30;
        int i31;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        int i32;
        boolean z11;
        long m5918getColor0d7_KjU;
        Composer composer3;
        final boolean z12;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle4;
        final TextFieldColors textFieldColors3;
        final boolean z13;
        final boolean z14;
        final int i33;
        final MutableInteractionSource mutableInteractionSource4;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Shape shape4;
        final KeyboardOptions keyboardOptions3;
        final int i34;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final KeyboardActions keyboardActions4;
        final boolean z15;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)356@17848L7,368@18448L39,369@18526L14,370@18590L17,382@19008L24,384@19163L38,393@19530L20,379@18910L1660:TextField.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i3 & 896) == 0) {
                modifier2 = modifier;
                i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i8 = i5 & 8;
                int i35 = 2048;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    z5 = z;
                    i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                        z6 = z2;
                    } else {
                        z6 = z2;
                        if ((i3 & 57344) == 0) {
                            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        }
                    }
                    if ((i3 & 458752) != 0) {
                        textStyle2 = textStyle;
                        i6 |= ((i5 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i3 & 3670016) == 0) {
                            i6 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i3 & 29360128) == 0) {
                            i6 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i13 = i12;
                        i6 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i6 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & 1879048192) == 0) {
                            i15 = i14;
                            i6 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 14) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i5 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 112) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i36 = i18;
                            i21 = i5 & 4096;
                            if (i21 == 0) {
                                i22 = i36 | 384;
                            } else {
                                i22 = i36;
                                if ((i4 & 896) == 0) {
                                    i22 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                    if ((i4 & 7168) == 0) {
                                        if ((i5 & 8192) != 0) {
                                        }
                                        i35 = 1024;
                                        i22 |= i35;
                                    }
                                    int i37 = i22;
                                    i23 = i5 & 16384;
                                    if (i23 != 0) {
                                        i37 |= 24576;
                                    } else if ((i4 & 57344) == 0) {
                                        i24 = i37 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                        if ((i4 & 458752) == 0) {
                                            i24 |= ((i5 & 32768) == 0 && startRestartGroup.changed(i)) ? 131072 : 65536;
                                        }
                                        i25 = i5 & 65536;
                                        if (i25 == 0) {
                                            i24 |= 1572864;
                                        } else if ((i4 & 3670016) == 0) {
                                            i24 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                                        }
                                        i26 = i5 & 131072;
                                        if (i26 == 0) {
                                            i24 |= 12582912;
                                        } else if ((i4 & 29360128) == 0) {
                                            i24 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                        }
                                        if ((i4 & 234881024) == 0) {
                                            i24 |= ((i5 & 262144) == 0 && startRestartGroup.changed(shape)) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & 1879048192) == 0) {
                                            i24 |= ((i5 & 524288) == 0 && startRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                                        }
                                        int i38 = i24;
                                        if ((i6 & 1533916891) == 306783378 || (1533916891 & i38) != 306783378 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                                boolean z16 = i8 == 0 ? true : z;
                                                boolean z17 = i9 == 0 ? false : z2;
                                                if ((i5 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i6 &= -458753;
                                                }
                                                int i39 = i6;
                                                TextStyle textStyle5 = textStyle2;
                                                Function2<? super Composer, ? super Integer, Unit> function214 = i10 == 0 ? null : function25;
                                                function27 = i11 == 0 ? null : function26;
                                                function28 = i13 == 0 ? null : function23;
                                                function29 = i15 == 0 ? null : function24;
                                                z7 = i17 == 0 ? false : z3;
                                                VisualTransformation none = i20 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                keyboardOptions2 = i21 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                if ((i5 & 8192) == 0) {
                                                    i27 = i38 & (-7169);
                                                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                                } else {
                                                    i27 = i38;
                                                    keyboardActions2 = keyboardActions;
                                                }
                                                boolean z18 = i23 == 0 ? false : z4;
                                                if ((32768 & i5) == 0) {
                                                    i27 &= -458753;
                                                    i28 = z18 ? 1 : Integer.MAX_VALUE;
                                                } else {
                                                    i28 = i;
                                                }
                                                int i40 = i25 == 0 ? 1 : i2;
                                                if (i26 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-492369756);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    startRestartGroup.endReplaceableGroup();
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((262144 & i5) == 0) {
                                                    i27 &= -234881025;
                                                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape(startRestartGroup, 6);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i41 = i27;
                                                if ((i5 & 524288) == 0) {
                                                    TextFieldColors m1827textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m1827textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, 48, 2097151);
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    i32 = i41 & (-1879048193);
                                                    z8 = z16;
                                                    z9 = z17;
                                                    textStyle3 = textStyle5;
                                                    i29 = i39;
                                                    function25 = function214;
                                                    visualTransformation2 = none;
                                                    z10 = z18;
                                                    i30 = i28;
                                                    i31 = i40;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    textFieldColors2 = m1827textFieldColorsdx8h9Zs;
                                                    shape3 = shape2;
                                                } else {
                                                    composer2 = startRestartGroup;
                                                    textFieldColors2 = textFieldColors;
                                                    keyboardActions3 = keyboardActions2;
                                                    z8 = z16;
                                                    z9 = z17;
                                                    textStyle3 = textStyle5;
                                                    i29 = i39;
                                                    function25 = function214;
                                                    visualTransformation2 = none;
                                                    z10 = z18;
                                                    i30 = i28;
                                                    i31 = i40;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                    i32 = i41;
                                                }
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i5 & 32) != 0) {
                                                    i6 &= -458753;
                                                }
                                                if ((i5 & 8192) != 0) {
                                                    i38 &= -7169;
                                                }
                                                if ((32768 & i5) != 0) {
                                                    i38 &= -458753;
                                                }
                                                if ((262144 & i5) != 0) {
                                                    i38 &= -234881025;
                                                }
                                                if ((i5 & 524288) != 0) {
                                                    i38 &= -1879048193;
                                                }
                                                TextStyle textStyle6 = textStyle2;
                                                i32 = i38;
                                                textStyle3 = textStyle6;
                                                z9 = z2;
                                                function28 = function23;
                                                function29 = function24;
                                                z7 = z3;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions3 = keyboardActions;
                                                z10 = z4;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                composer2 = startRestartGroup;
                                                i29 = i6;
                                                function27 = function26;
                                                companion = modifier2;
                                                z8 = z;
                                                i30 = i;
                                                i31 = i2;
                                            }
                                            composer2.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                z11 = z9;
                                            } else {
                                                z11 = z9;
                                                ComposerKt.traceEventStart(-359119489, i29, i32, "androidx.compose.material.TextField (TextField.kt:371)");
                                            }
                                            composer2.startReplaceableGroup(-833018012);
                                            ComposerKt.sourceInformation(composer2, "*374@18759L18");
                                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                m5918getColor0d7_KjU = textFieldColors2.textColor(z8, composer2, ((i29 >> 9) & 14) | ((i32 >> 24) & 112)).getValue().m4073unboximpl();
                                            }
                                            composer2.endReplaceableGroup();
                                            TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                            int i42 = (i32 >> 24) & 112;
                                            TextStyle textStyle7 = textStyle3;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final boolean z19 = z8;
                                            final boolean z20 = z7;
                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42).getValue().m4073unboximpl(), shape3), z19, z20, mutableInteractionSource3, textFieldColors4, 0.0f, 0.0f, 48, null), z20, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                                            Modifier modifier4 = companion;
                                            SolidColor solidColor = new SolidColor(textFieldColors4.cursorColor(z20, composer2, (i32 & 14) | i42).getValue().m4073unboximpl(), null);
                                            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                            final boolean z21 = z10;
                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                            final Function2<? super Composer, ? super Integer, Unit> function216 = function27;
                                            final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                            int i43 = i32 << 12;
                                            boolean z22 = z11;
                                            Shape shape5 = shape3;
                                            Composer composer4 = composer2;
                                            KeyboardOptions keyboardOptions4 = keyboardOptions2;
                                            BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN4, z8, z22, merge, keyboardOptions4, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                                    int i45;
                                                    ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                                                    if ((i44 & 14) == 0) {
                                                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                                    } else {
                                                        i45 = i44;
                                                    }
                                                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                                                        }
                                                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z19, z21, visualTransformation4, mutableInteractionSource5, z20, function215, function216, function217, function218, textFieldColors4, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, (i29 & 64638) | (i43 & 3670016) | (i43 & 29360128) | (234881024 & i43) | (i43 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                                            composer3 = composer4;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            VisualTransformation visualTransformation5 = visualTransformation2;
                                            z12 = z10;
                                            visualTransformation3 = visualTransformation5;
                                            textStyle4 = textStyle7;
                                            textFieldColors3 = textFieldColors4;
                                            z13 = z8;
                                            z14 = z22;
                                            i33 = i30;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            function210 = function215;
                                            function211 = function27;
                                            function212 = function28;
                                            shape4 = shape5;
                                            keyboardOptions3 = keyboardOptions4;
                                            i34 = i31;
                                            function213 = function29;
                                            keyboardActions4 = keyboardActions3;
                                            z15 = z20;
                                            modifier3 = modifier4;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            z15 = z3;
                                            visualTransformation3 = visualTransformation;
                                            z12 = z4;
                                            i33 = i;
                                            i34 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer3 = startRestartGroup;
                                            z13 = z5;
                                            z14 = z6;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function26;
                                            modifier3 = modifier2;
                                            function212 = function23;
                                            function213 = function24;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions4 = keyboardActions;
                                        }
                                        endRestartGroup = composer3.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$8
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

                                                public final void invoke(Composer composer5, int i44) {
                                                    TextFieldKt.TextField(TextFieldValue.this, function1, modifier3, z13, z14, textStyle4, function210, function211, function212, function213, z15, visualTransformation3, keyboardOptions3, keyboardActions4, z12, i33, i34, mutableInteractionSource4, shape4, textFieldColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i24 = i37;
                                    if ((i4 & 458752) == 0) {
                                    }
                                    i25 = i5 & 65536;
                                    if (i25 == 0) {
                                    }
                                    i26 = i5 & 131072;
                                    if (i26 == 0) {
                                    }
                                    if ((i4 & 234881024) == 0) {
                                    }
                                    if ((i4 & 1879048192) == 0) {
                                    }
                                    int i382 = i24;
                                    if ((i6 & 1533916891) == 306783378) {
                                    }
                                    startRestartGroup.startDefaults();
                                    if ((i3 & 1) != 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i9 == 0) {
                                    }
                                    if ((i5 & 32) != 0) {
                                    }
                                    int i392 = i6;
                                    TextStyle textStyle52 = textStyle2;
                                    if (i10 == 0) {
                                    }
                                    if (i11 == 0) {
                                    }
                                    if (i13 == 0) {
                                    }
                                    if (i15 == 0) {
                                    }
                                    if (i17 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if (i21 == 0) {
                                    }
                                    if ((i5 & 8192) == 0) {
                                    }
                                    if (i23 == 0) {
                                    }
                                    if ((32768 & i5) == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    if (i26 == 0) {
                                    }
                                    if ((262144 & i5) == 0) {
                                    }
                                    int i412 = i27;
                                    if ((i5 & 524288) == 0) {
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer2.startReplaceableGroup(-833018012);
                                    ComposerKt.sourceInformation(composer2, "*374@18759L18");
                                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                    }
                                    composer2.endReplaceableGroup();
                                    TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    int i422 = (i32 >> 24) & 112;
                                    TextStyle textStyle72 = textStyle3;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final boolean z192 = z8;
                                    final boolean z202 = z7;
                                    Modifier m912defaultMinSizeVpY3zN42 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422).getValue().m4073unboximpl(), shape3), z192, z202, mutableInteractionSource3, textFieldColors42, 0.0f, 0.0f, 48, null), z202, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                                    Modifier modifier42 = companion;
                                    SolidColor solidColor2 = new SolidColor(textFieldColors42.cursorColor(z202, composer2, (i32 & 14) | i422).getValue().m4073unboximpl(), null);
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final boolean z212 = z10;
                                    final VisualTransformation visualTransformation42 = visualTransformation2;
                                    final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                                    int i432 = i32 << 12;
                                    boolean z222 = z11;
                                    Shape shape52 = shape3;
                                    Composer composer42 = composer2;
                                    KeyboardOptions keyboardOptions42 = keyboardOptions2;
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN42, z8, z222, merge2, keyboardOptions42, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                            int i45;
                                            ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                                            if ((i44 & 14) == 0) {
                                                i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                            } else {
                                                i45 = i44;
                                            }
                                            if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                                                }
                                                TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z192, z212, visualTransformation42, mutableInteractionSource52, z202, function2152, function2162, function2172, function2182, textFieldColors42, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer42, (i29 & 64638) | (i432 & 3670016) | (i432 & 29360128) | (234881024 & i432) | (i432 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                                    composer3 = composer42;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    VisualTransformation visualTransformation52 = visualTransformation2;
                                    z12 = z10;
                                    visualTransformation3 = visualTransformation52;
                                    textStyle4 = textStyle72;
                                    textFieldColors3 = textFieldColors42;
                                    z13 = z8;
                                    z14 = z222;
                                    i33 = i30;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    function210 = function2152;
                                    function211 = function27;
                                    function212 = function28;
                                    shape4 = shape52;
                                    keyboardOptions3 = keyboardOptions42;
                                    i34 = i31;
                                    function213 = function29;
                                    keyboardActions4 = keyboardActions3;
                                    z15 = z202;
                                    modifier3 = modifier42;
                                    endRestartGroup = composer3.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                            }
                            if ((i4 & 7168) == 0) {
                            }
                            int i372 = i22;
                            i23 = i5 & 16384;
                            if (i23 != 0) {
                            }
                            i24 = i372;
                            if ((i4 & 458752) == 0) {
                            }
                            i25 = i5 & 65536;
                            if (i25 == 0) {
                            }
                            i26 = i5 & 131072;
                            if (i26 == 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            if ((i4 & 1879048192) == 0) {
                            }
                            int i3822 = i24;
                            if ((i6 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            if ((i5 & 32) != 0) {
                            }
                            int i3922 = i6;
                            TextStyle textStyle522 = textStyle2;
                            if (i10 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if ((i5 & 8192) == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if ((32768 & i5) == 0) {
                            }
                            if (i25 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if ((262144 & i5) == 0) {
                            }
                            int i4122 = i27;
                            if ((i5 & 524288) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(-833018012);
                            ComposerKt.sourceInformation(composer2, "*374@18759L18");
                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                            }
                            composer2.endReplaceableGroup();
                            TextStyle merge22 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            int i4222 = (i32 >> 24) & 112;
                            TextStyle textStyle722 = textStyle3;
                            final TextFieldColors textFieldColors422 = textFieldColors2;
                            final boolean z1922 = z8;
                            final boolean z2022 = z7;
                            Modifier m912defaultMinSizeVpY3zN422 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i4222).getValue().m4073unboximpl(), shape3), z1922, z2022, mutableInteractionSource3, textFieldColors422, 0.0f, 0.0f, 48, null), z2022, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                            Modifier modifier422 = companion;
                            SolidColor solidColor22 = new SolidColor(textFieldColors422.cursorColor(z2022, composer2, (i32 & 14) | i4222).getValue().m4073unboximpl(), null);
                            final Function2<? super Composer, ? super Integer, Unit> function21522 = function25;
                            final boolean z2122 = z10;
                            final VisualTransformation visualTransformation422 = visualTransformation2;
                            final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                            final Function2<? super Composer, ? super Integer, Unit> function21622 = function27;
                            final Function2<? super Composer, ? super Integer, Unit> function21722 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            int i4322 = i32 << 12;
                            boolean z2222 = z11;
                            Shape shape522 = shape3;
                            Composer composer422 = composer2;
                            KeyboardOptions keyboardOptions422 = keyboardOptions2;
                            BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN422, z8, z2222, merge22, keyboardOptions422, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor22, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                    int i45;
                                    ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                                    if ((i44 & 14) == 0) {
                                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                    } else {
                                        i45 = i44;
                                    }
                                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                                        }
                                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z1922, z2122, visualTransformation422, mutableInteractionSource522, z2022, function21522, function21622, function21722, function21822, textFieldColors422, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer422, (i29 & 64638) | (i4322 & 3670016) | (i4322 & 29360128) | (234881024 & i4322) | (i4322 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                            composer3 = composer422;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            VisualTransformation visualTransformation522 = visualTransformation2;
                            z12 = z10;
                            visualTransformation3 = visualTransformation522;
                            textStyle4 = textStyle722;
                            textFieldColors3 = textFieldColors422;
                            z13 = z8;
                            z14 = z2222;
                            i33 = i30;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function210 = function21522;
                            function211 = function27;
                            function212 = function28;
                            shape4 = shape522;
                            keyboardOptions3 = keyboardOptions422;
                            i34 = i31;
                            function213 = function29;
                            keyboardActions4 = keyboardActions3;
                            z15 = z2022;
                            modifier3 = modifier422;
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i5 & 2048;
                        if (i19 == 0) {
                        }
                        int i362 = i18;
                        i21 = i5 & 4096;
                        if (i21 == 0) {
                        }
                        if ((i4 & 7168) == 0) {
                        }
                        int i3722 = i22;
                        i23 = i5 & 16384;
                        if (i23 != 0) {
                        }
                        i24 = i3722;
                        if ((i4 & 458752) == 0) {
                        }
                        i25 = i5 & 65536;
                        if (i25 == 0) {
                        }
                        i26 = i5 & 131072;
                        if (i26 == 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        if ((i4 & 1879048192) == 0) {
                        }
                        int i38222 = i24;
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i5 & 32) != 0) {
                        }
                        int i39222 = i6;
                        TextStyle textStyle5222 = textStyle2;
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if ((i5 & 8192) == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if ((32768 & i5) == 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if ((262144 & i5) == 0) {
                        }
                        int i41222 = i27;
                        if ((i5 & 524288) == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2.startReplaceableGroup(-833018012);
                        ComposerKt.sourceInformation(composer2, "*374@18759L18");
                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        }
                        composer2.endReplaceableGroup();
                        TextStyle merge222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                        int i42222 = (i32 >> 24) & 112;
                        TextStyle textStyle7222 = textStyle3;
                        final TextFieldColors textFieldColors4222 = textFieldColors2;
                        final boolean z19222 = z8;
                        final boolean z20222 = z7;
                        Modifier m912defaultMinSizeVpY3zN4222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42222).getValue().m4073unboximpl(), shape3), z19222, z20222, mutableInteractionSource3, textFieldColors4222, 0.0f, 0.0f, 48, null), z20222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                        Modifier modifier4222 = companion;
                        SolidColor solidColor222 = new SolidColor(textFieldColors4222.cursorColor(z20222, composer2, (i32 & 14) | i42222).getValue().m4073unboximpl(), null);
                        final Function2<? super Composer, ? super Integer, Unit> function215222 = function25;
                        final boolean z21222 = z10;
                        final VisualTransformation visualTransformation4222 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                        final Function2<? super Composer, ? super Integer, Unit> function216222 = function27;
                        final Function2<? super Composer, ? super Integer, Unit> function217222 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                        int i43222 = i32 << 12;
                        boolean z22222 = z11;
                        Shape shape5222 = shape3;
                        Composer composer4222 = composer2;
                        KeyboardOptions keyboardOptions4222 = keyboardOptions2;
                        BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN4222, z8, z22222, merge222, keyboardOptions4222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor222, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                                int i45;
                                ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                                if ((i44 & 14) == 0) {
                                    i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                                } else {
                                    i45 = i44;
                                }
                                if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                                    }
                                    TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z19222, z21222, visualTransformation4222, mutableInteractionSource5222, z20222, function215222, function216222, function217222, function218222, textFieldColors4222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4222, (i29 & 64638) | (i43222 & 3670016) | (i43222 & 29360128) | (234881024 & i43222) | (i43222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                        composer3 = composer4222;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        VisualTransformation visualTransformation5222 = visualTransformation2;
                        z12 = z10;
                        visualTransformation3 = visualTransformation5222;
                        textStyle4 = textStyle7222;
                        textFieldColors3 = textFieldColors4222;
                        z13 = z8;
                        z14 = z22222;
                        i33 = i30;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function210 = function215222;
                        function211 = function27;
                        function212 = function28;
                        shape4 = shape5222;
                        keyboardOptions3 = keyboardOptions4222;
                        i34 = i31;
                        function213 = function29;
                        keyboardActions4 = keyboardActions3;
                        z15 = z20222;
                        modifier3 = modifier4222;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i13 = i12;
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i5 & 2048;
                    if (i19 == 0) {
                    }
                    int i3622 = i18;
                    i21 = i5 & 4096;
                    if (i21 == 0) {
                    }
                    if ((i4 & 7168) == 0) {
                    }
                    int i37222 = i22;
                    i23 = i5 & 16384;
                    if (i23 != 0) {
                    }
                    i24 = i37222;
                    if ((i4 & 458752) == 0) {
                    }
                    i25 = i5 & 65536;
                    if (i25 == 0) {
                    }
                    i26 = i5 & 131072;
                    if (i26 == 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    int i382222 = i24;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i5 & 32) != 0) {
                    }
                    int i392222 = i6;
                    TextStyle textStyle52222 = textStyle2;
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if ((i5 & 8192) == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if ((32768 & i5) == 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if ((262144 & i5) == 0) {
                    }
                    int i412222 = i27;
                    if ((i5 & 524288) == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2.startReplaceableGroup(-833018012);
                    ComposerKt.sourceInformation(composer2, "*374@18759L18");
                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    composer2.endReplaceableGroup();
                    TextStyle merge2222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                    int i422222 = (i32 >> 24) & 112;
                    TextStyle textStyle72222 = textStyle3;
                    final TextFieldColors textFieldColors42222 = textFieldColors2;
                    final boolean z192222 = z8;
                    final boolean z202222 = z7;
                    Modifier m912defaultMinSizeVpY3zN42222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422222).getValue().m4073unboximpl(), shape3), z192222, z202222, mutableInteractionSource3, textFieldColors42222, 0.0f, 0.0f, 48, null), z202222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                    Modifier modifier42222 = companion;
                    SolidColor solidColor2222 = new SolidColor(textFieldColors42222.cursorColor(z202222, composer2, (i32 & 14) | i422222).getValue().m4073unboximpl(), null);
                    final Function2<? super Composer, ? super Integer, Unit> function2152222 = function25;
                    final boolean z212222 = z10;
                    final VisualTransformation visualTransformation42222 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                    final Function2<? super Composer, ? super Integer, Unit> function2162222 = function27;
                    final Function2<? super Composer, ? super Integer, Unit> function2172222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                    int i432222 = i32 << 12;
                    boolean z222222 = z11;
                    Shape shape52222 = shape3;
                    Composer composer42222 = composer2;
                    KeyboardOptions keyboardOptions42222 = keyboardOptions2;
                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN42222, z8, z222222, merge2222, keyboardOptions42222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2222, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                            int i45;
                            ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                            if ((i44 & 14) == 0) {
                                i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                            } else {
                                i45 = i44;
                            }
                            if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                                }
                                TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z192222, z212222, visualTransformation42222, mutableInteractionSource52222, z202222, function2152222, function2162222, function2172222, function2182222, textFieldColors42222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer42222, (i29 & 64638) | (i432222 & 3670016) | (i432222 & 29360128) | (234881024 & i432222) | (i432222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                    composer3 = composer42222;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    VisualTransformation visualTransformation52222 = visualTransformation2;
                    z12 = z10;
                    visualTransformation3 = visualTransformation52222;
                    textStyle4 = textStyle72222;
                    textFieldColors3 = textFieldColors42222;
                    z13 = z8;
                    z14 = z222222;
                    i33 = i30;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function210 = function2152222;
                    function211 = function27;
                    function212 = function28;
                    shape4 = shape52222;
                    keyboardOptions3 = keyboardOptions42222;
                    i34 = i31;
                    function213 = function29;
                    keyboardActions4 = keyboardActions3;
                    z15 = z202222;
                    modifier3 = modifier42222;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                if ((i3 & 458752) != 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                i19 = i5 & 2048;
                if (i19 == 0) {
                }
                int i36222 = i18;
                i21 = i5 & 4096;
                if (i21 == 0) {
                }
                if ((i4 & 7168) == 0) {
                }
                int i372222 = i22;
                i23 = i5 & 16384;
                if (i23 != 0) {
                }
                i24 = i372222;
                if ((i4 & 458752) == 0) {
                }
                i25 = i5 & 65536;
                if (i25 == 0) {
                }
                i26 = i5 & 131072;
                if (i26 == 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                int i3822222 = i24;
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i5 & 32) != 0) {
                }
                int i3922222 = i6;
                TextStyle textStyle522222 = textStyle2;
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i17 == 0) {
                }
                if (i20 == 0) {
                }
                if (i21 == 0) {
                }
                if ((i5 & 8192) == 0) {
                }
                if (i23 == 0) {
                }
                if ((32768 & i5) == 0) {
                }
                if (i25 == 0) {
                }
                if (i26 == 0) {
                }
                if ((262144 & i5) == 0) {
                }
                int i4122222 = i27;
                if ((i5 & 524288) == 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2.startReplaceableGroup(-833018012);
                ComposerKt.sourceInformation(composer2, "*374@18759L18");
                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                composer2.endReplaceableGroup();
                TextStyle merge22222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                int i4222222 = (i32 >> 24) & 112;
                TextStyle textStyle722222 = textStyle3;
                final TextFieldColors textFieldColors422222 = textFieldColors2;
                final boolean z1922222 = z8;
                final boolean z2022222 = z7;
                Modifier m912defaultMinSizeVpY3zN422222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i4222222).getValue().m4073unboximpl(), shape3), z1922222, z2022222, mutableInteractionSource3, textFieldColors422222, 0.0f, 0.0f, 48, null), z2022222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
                Modifier modifier422222 = companion;
                SolidColor solidColor22222 = new SolidColor(textFieldColors422222.cursorColor(z2022222, composer2, (i32 & 14) | i4222222).getValue().m4073unboximpl(), null);
                final Function2<? super Composer, ? super Integer, Unit> function21522222 = function25;
                final boolean z2122222 = z10;
                final VisualTransformation visualTransformation422222 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function21622222 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function21722222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
                int i4322222 = i32 << 12;
                boolean z2222222 = z11;
                Shape shape522222 = shape3;
                Composer composer422222 = composer2;
                KeyboardOptions keyboardOptions422222 = keyboardOptions2;
                BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN422222, z8, z2222222, merge22222, keyboardOptions422222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor22222, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                        int i45;
                        ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                        if ((i44 & 14) == 0) {
                            i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                        } else {
                            i45 = i44;
                        }
                        if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                            }
                            TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z1922222, z2122222, visualTransformation422222, mutableInteractionSource522222, z2022222, function21522222, function21622222, function21722222, function21822222, textFieldColors422222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }), composer422222, (i29 & 64638) | (i4322222 & 3670016) | (i4322222 & 29360128) | (234881024 & i4322222) | (i4322222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
                composer3 = composer422222;
                if (ComposerKt.isTraceInProgress()) {
                }
                VisualTransformation visualTransformation522222 = visualTransformation2;
                z12 = z10;
                visualTransformation3 = visualTransformation522222;
                textStyle4 = textStyle722222;
                textFieldColors3 = textFieldColors422222;
                z13 = z8;
                z14 = z2222222;
                i33 = i30;
                mutableInteractionSource4 = mutableInteractionSource3;
                function210 = function21522222;
                function211 = function27;
                function212 = function28;
                shape4 = shape522222;
                keyboardOptions3 = keyboardOptions422222;
                i34 = i31;
                function213 = function29;
                keyboardActions4 = keyboardActions3;
                z15 = z2022222;
                modifier3 = modifier422222;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
            int i352 = 2048;
            if (i8 != 0) {
            }
            z5 = z;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            if ((i3 & 458752) != 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            i19 = i5 & 2048;
            if (i19 == 0) {
            }
            int i362222 = i18;
            i21 = i5 & 4096;
            if (i21 == 0) {
            }
            if ((i4 & 7168) == 0) {
            }
            int i3722222 = i22;
            i23 = i5 & 16384;
            if (i23 != 0) {
            }
            i24 = i3722222;
            if ((i4 & 458752) == 0) {
            }
            i25 = i5 & 65536;
            if (i25 == 0) {
            }
            i26 = i5 & 131072;
            if (i26 == 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            int i38222222 = i24;
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if ((i5 & 32) != 0) {
            }
            int i39222222 = i6;
            TextStyle textStyle5222222 = textStyle2;
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i17 == 0) {
            }
            if (i20 == 0) {
            }
            if (i21 == 0) {
            }
            if ((i5 & 8192) == 0) {
            }
            if (i23 == 0) {
            }
            if ((32768 & i5) == 0) {
            }
            if (i25 == 0) {
            }
            if (i26 == 0) {
            }
            if ((262144 & i5) == 0) {
            }
            int i41222222 = i27;
            if ((i5 & 524288) == 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2.startReplaceableGroup(-833018012);
            ComposerKt.sourceInformation(composer2, "*374@18759L18");
            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            composer2.endReplaceableGroup();
            TextStyle merge222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            int i42222222 = (i32 >> 24) & 112;
            TextStyle textStyle7222222 = textStyle3;
            final TextFieldColors textFieldColors4222222 = textFieldColors2;
            final boolean z19222222 = z8;
            final boolean z20222222 = z7;
            Modifier m912defaultMinSizeVpY3zN4222222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i42222222).getValue().m4073unboximpl(), shape3), z19222222, z20222222, mutableInteractionSource3, textFieldColors4222222, 0.0f, 0.0f, 48, null), z20222222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
            Modifier modifier4222222 = companion;
            SolidColor solidColor222222 = new SolidColor(textFieldColors4222222.cursorColor(z20222222, composer2, (i32 & 14) | i42222222).getValue().m4073unboximpl(), null);
            final Function2<? super Composer, ? super Integer, Unit> function215222222 = function25;
            final boolean z21222222 = z10;
            final VisualTransformation visualTransformation4222222 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
            final Function2<? super Composer, ? super Integer, Unit> function216222222 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function217222222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
            int i43222222 = i32 << 12;
            boolean z22222222 = z11;
            Shape shape5222222 = shape3;
            Composer composer4222222 = composer2;
            KeyboardOptions keyboardOptions4222222 = keyboardOptions2;
            BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN4222222, z8, z22222222, merge222222, keyboardOptions4222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor222222, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                    int i45;
                    ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                    if ((i44 & 14) == 0) {
                        i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                    } else {
                        i45 = i44;
                    }
                    if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                        }
                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z19222222, z21222222, visualTransformation4222222, mutableInteractionSource5222222, z20222222, function215222222, function216222222, function217222222, function218222222, textFieldColors4222222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }), composer4222222, (i29 & 64638) | (i43222222 & 3670016) | (i43222222 & 29360128) | (234881024 & i43222222) | (i43222222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
            composer3 = composer4222222;
            if (ComposerKt.isTraceInProgress()) {
            }
            VisualTransformation visualTransformation5222222 = visualTransformation2;
            z12 = z10;
            visualTransformation3 = visualTransformation5222222;
            textStyle4 = textStyle7222222;
            textFieldColors3 = textFieldColors4222222;
            z13 = z8;
            z14 = z22222222;
            i33 = i30;
            mutableInteractionSource4 = mutableInteractionSource3;
            function210 = function215222222;
            function211 = function27;
            function212 = function28;
            shape4 = shape5222222;
            keyboardOptions3 = keyboardOptions4222222;
            i34 = i31;
            function213 = function29;
            keyboardActions4 = keyboardActions3;
            z15 = z20222222;
            modifier3 = modifier4222222;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
        int i3522 = 2048;
        if (i8 != 0) {
        }
        z5 = z;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        if ((i3 & 458752) != 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        i19 = i5 & 2048;
        if (i19 == 0) {
        }
        int i3622222 = i18;
        i21 = i5 & 4096;
        if (i21 == 0) {
        }
        if ((i4 & 7168) == 0) {
        }
        int i37222222 = i22;
        i23 = i5 & 16384;
        if (i23 != 0) {
        }
        i24 = i37222222;
        if ((i4 & 458752) == 0) {
        }
        i25 = i5 & 65536;
        if (i25 == 0) {
        }
        i26 = i5 & 131072;
        if (i26 == 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        int i382222222 = i24;
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i5 & 32) != 0) {
        }
        int i392222222 = i6;
        TextStyle textStyle52222222 = textStyle2;
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i17 == 0) {
        }
        if (i20 == 0) {
        }
        if (i21 == 0) {
        }
        if ((i5 & 8192) == 0) {
        }
        if (i23 == 0) {
        }
        if ((32768 & i5) == 0) {
        }
        if (i25 == 0) {
        }
        if (i26 == 0) {
        }
        if ((262144 & i5) == 0) {
        }
        int i412222222 = i27;
        if ((i5 & 524288) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.startReplaceableGroup(-833018012);
        ComposerKt.sourceInformation(composer2, "*374@18759L18");
        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        composer2.endReplaceableGroup();
        TextStyle merge2222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        int i422222222 = (i32 >> 24) & 112;
        TextStyle textStyle72222222 = textStyle3;
        final TextFieldColors textFieldColors42222222 = textFieldColors2;
        final boolean z192222222 = z8;
        final boolean z202222222 = z7;
        Modifier m912defaultMinSizeVpY3zN42222222 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1815indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, BackgroundKt.m526backgroundbw27NRU(companion, textFieldColors2.backgroundColor(z8, composer2, ((i29 >> 9) & 14) | i422222222).getValue().m4073unboximpl(), shape3), z192222222, z202222222, mutableInteractionSource3, textFieldColors42222222, 0.0f, 0.0f, 48, null), z202222222, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM());
        Modifier modifier42222222 = companion;
        SolidColor solidColor2222222 = new SolidColor(textFieldColors42222222.cursorColor(z202222222, composer2, (i32 & 14) | i422222222).getValue().m4073unboximpl(), null);
        final Function2<? super Composer, ? super Integer, Unit> function2152222222 = function25;
        final boolean z212222222 = z10;
        final VisualTransformation visualTransformation42222222 = visualTransformation2;
        final MutableInteractionSource mutableInteractionSource52222222 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2162222222 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function2172222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2182222222 = function29;
        int i432222222 = i32 << 12;
        boolean z222222222 = z11;
        Shape shape52222222 = shape3;
        Composer composer42222222 = composer2;
        KeyboardOptions keyboardOptions42222222 = keyboardOptions2;
        BasicTextFieldKt.BasicTextField(textFieldValue, function1, m912defaultMinSizeVpY3zN42222222, z8, z222222222, merge2222222, keyboardOptions42222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, solidColor2222222, ComposableLambdaKt.composableLambda(composer2, -126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function219, Composer composer5, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function219, composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function219, Composer composer5, int i44) {
                int i45;
                ComposerKt.sourceInformation(composer5, "C403@20011L543:TextField.kt#jmzs0o");
                if ((i44 & 14) == 0) {
                    i45 = i44 | (composer5.changedInstance(function219) ? 4 : 2);
                } else {
                    i45 = i44;
                }
                if ((i45 & 91) != 18 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126640971, i45, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:403)");
                    }
                    TextFieldDefaults.INSTANCE.TextFieldDecorationBox(TextFieldValue.this.getText(), function219, z192222222, z212222222, visualTransformation42222222, mutableInteractionSource52222222, z202222222, function2152222222, function2162222222, function2172222222, function2182222222, textFieldColors42222222, null, composer5, (i45 << 3) & 112, 3072, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }), composer42222222, (i29 & 64638) | (i432222222 & 3670016) | (i432222222 & 29360128) | (234881024 & i432222222) | (i432222222 & 1879048192), ((i32 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i32 & 112) | ((i32 >> 12) & 7168), 4096);
        composer3 = composer42222222;
        if (ComposerKt.isTraceInProgress()) {
        }
        VisualTransformation visualTransformation52222222 = visualTransformation2;
        z12 = z10;
        visualTransformation3 = visualTransformation52222222;
        textStyle4 = textStyle72222222;
        textFieldColors3 = textFieldColors42222222;
        z13 = z8;
        z14 = z222222222;
        i33 = i30;
        mutableInteractionSource4 = mutableInteractionSource3;
        function210 = function2152222222;
        function211 = function27;
        function212 = function28;
        shape4 = shape52222222;
        keyboardOptions3 = keyboardOptions42222222;
        i34 = i31;
        function213 = function29;
        keyboardActions4 = keyboardActions3;
        z15 = z202222222;
        modifier3 = modifier42222222;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d3, code lost:
    
        if (r3.changed(r86) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        TextStyle textStyle2;
        int i9;
        Function2 function25;
        int i10;
        Function2 function26;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        TextStyle textStyle3;
        int i27;
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
        KeyboardActions keyboardActions3;
        Modifier modifier3;
        boolean z7;
        boolean z8;
        int i28;
        Function2 function27;
        Function2 function28;
        Function2 function29;
        boolean z9;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean z10;
        int i29;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function210;
        final Function2 function211;
        final Function2 function212;
        final Function2 function213;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final boolean z14;
        final int i30;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)432@20939L7,443@21493L39,444@21571L14,445@21635L17,447@21661L408:TextField.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i7 = i4 & 8;
                int i31 = 2048;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    z5 = z;
                    i5 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        z6 = z2;
                    } else {
                        z6 = z2;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        }
                    }
                    if ((i2 & 458752) != 0) {
                        textStyle2 = textStyle;
                        i5 |= ((i4 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & 29360128) == 0) {
                            i5 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= C.ENCODING_PCM_32BIT;
                        } else if ((i2 & 1879048192) == 0) {
                            i14 = i13;
                            i5 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i15 = i4 & 1024;
                            if (i15 == 0) {
                                i17 = i3 | 6;
                                i16 = i15;
                            } else if ((i3 & 14) == 0) {
                                i16 = i15;
                                i17 = i3 | (startRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i3;
                            }
                            i18 = i4 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                                i19 = i18;
                            } else if ((i3 & 112) == 0) {
                                i19 = i18;
                                i17 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i19 = i18;
                            }
                            int i32 = i17;
                            i20 = i4 & 4096;
                            if (i20 == 0) {
                                i21 = i32 | 384;
                            } else {
                                i21 = i32;
                                if ((i3 & 896) == 0) {
                                    i21 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                    if ((i3 & 7168) == 0) {
                                        if ((i4 & 8192) != 0) {
                                        }
                                        i31 = 1024;
                                        i21 |= i31;
                                    }
                                    int i33 = i21;
                                    i22 = i4 & 16384;
                                    if (i22 != 0) {
                                        i33 |= 24576;
                                    } else if ((i3 & 57344) == 0) {
                                        i23 = i33 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                        i24 = i4 & 32768;
                                        if (i24 == 0) {
                                            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i3 & 458752) == 0) {
                                            i23 |= startRestartGroup.changed(i) ? 131072 : 65536;
                                        }
                                        i25 = i4 & 65536;
                                        if (i25 == 0) {
                                            i23 |= 1572864;
                                        } else if ((i3 & 3670016) == 0) {
                                            i23 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                        }
                                        if ((i3 & 29360128) == 0) {
                                            i23 |= ((i4 & 131072) == 0 && startRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                        }
                                        if ((i3 & 234881024) == 0) {
                                            i23 |= ((i4 & 262144) == 0 && startRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                        }
                                        i26 = i23;
                                        if ((i5 & 1533916891) == 306783378 || (191739611 & i26) != 38347922 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                                                boolean z15 = i7 == 0 ? true : z5;
                                                boolean z16 = i8 == 0 ? false : z6;
                                                if ((i4 & 32) == 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    i5 &= -458753;
                                                    textStyle3 = (TextStyle) consume;
                                                } else {
                                                    textStyle3 = textStyle2;
                                                }
                                                int i34 = i5;
                                                Function2 function214 = i9 == 0 ? null : function25;
                                                Function2 function215 = i10 == 0 ? null : function26;
                                                Function2 function216 = i12 == 0 ? null : function23;
                                                Function2 function217 = i14 == 0 ? null : function24;
                                                boolean z17 = i16 == 0 ? false : z3;
                                                VisualTransformation none = i19 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i20 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                if ((i4 & 8192) == 0) {
                                                    i27 = i26 & (-7169);
                                                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                                } else {
                                                    i27 = i26;
                                                    keyboardActions2 = keyboardActions;
                                                }
                                                boolean z18 = i22 == 0 ? false : z4;
                                                int i35 = i24 == 0 ? Integer.MAX_VALUE : i;
                                                if (i25 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-492369756);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    startRestartGroup.endReplaceableGroup();
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i4 & 131072) == 0) {
                                                    i27 &= -29360129;
                                                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape(startRestartGroup, 6);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i36 = i27;
                                                if ((262144 & i4) == 0) {
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    modifier3 = companion;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.m1827textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
                                                    i26 = i36 & (-234881025);
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle2 = textStyle3;
                                                    i28 = i34;
                                                    function25 = function214;
                                                    function27 = function215;
                                                    function28 = function216;
                                                    function29 = function217;
                                                    z9 = z17;
                                                    visualTransformation2 = none;
                                                    keyboardOptions2 = keyboardOptions4;
                                                    z10 = z18;
                                                    i29 = i35;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                } else {
                                                    composer2 = startRestartGroup;
                                                    textFieldColors2 = textFieldColors;
                                                    keyboardActions3 = keyboardActions2;
                                                    modifier3 = companion;
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle2 = textStyle3;
                                                    i28 = i34;
                                                    function25 = function214;
                                                    function27 = function215;
                                                    function28 = function216;
                                                    function29 = function217;
                                                    z9 = z17;
                                                    visualTransformation2 = none;
                                                    keyboardOptions2 = keyboardOptions4;
                                                    z10 = z18;
                                                    i29 = i35;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                    i26 = i36;
                                                }
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i4 & 32) != 0) {
                                                    i5 &= -458753;
                                                }
                                                if ((i4 & 8192) != 0) {
                                                    i26 &= -7169;
                                                }
                                                if ((i4 & 131072) != 0) {
                                                    i26 &= -29360129;
                                                }
                                                if ((262144 & i4) != 0) {
                                                    i26 &= -234881025;
                                                }
                                                function28 = function23;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions3 = keyboardActions;
                                                z10 = z4;
                                                i29 = i;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                composer2 = startRestartGroup;
                                                z8 = z6;
                                                i28 = i5;
                                                function27 = function26;
                                                modifier3 = modifier2;
                                                function29 = function24;
                                                z9 = z3;
                                                z7 = z5;
                                            }
                                            composer2.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1576622884, i28, i26, "androidx.compose.material.TextField (TextField.kt:446)");
                                            }
                                            int i37 = i28 & 2147483646;
                                            int i38 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                                            int i39 = i26 << 3;
                                            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37, i38 | (29360128 & i39) | (234881024 & i39) | (i39 & 1879048192), 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z7;
                                            z12 = z8;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function27;
                                            function212 = function28;
                                            function213 = function29;
                                            z13 = z9;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions4 = keyboardActions3;
                                            z14 = z10;
                                            i30 = i29;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            z13 = z3;
                                            visualTransformation3 = visualTransformation;
                                            z14 = z4;
                                            i30 = i;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function210 = function25;
                                            function211 = function26;
                                            modifier4 = modifier2;
                                            function212 = function23;
                                            function213 = function24;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions4 = keyboardActions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextField$10
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

                                                public final void invoke(Composer composer3, int i40) {
                                                    TextFieldKt.TextField(TextFieldValue.this, function1, modifier4, z11, z12, textStyle4, function210, function211, function212, function213, z13, visualTransformation3, keyboardOptions3, keyboardActions4, z14, i30, mutableInteractionSource4, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i23 = i33;
                                    i24 = i4 & 32768;
                                    if (i24 == 0) {
                                    }
                                    i25 = i4 & 65536;
                                    if (i25 == 0) {
                                    }
                                    if ((i3 & 29360128) == 0) {
                                    }
                                    if ((i3 & 234881024) == 0) {
                                    }
                                    i26 = i23;
                                    if ((i5 & 1533916891) == 306783378) {
                                    }
                                    startRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0) {
                                    }
                                    if (i6 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if ((i4 & 32) == 0) {
                                    }
                                    int i342 = i5;
                                    if (i9 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    if (i14 == 0) {
                                    }
                                    if (i16 == 0) {
                                    }
                                    if (i19 == 0) {
                                    }
                                    if (i20 == 0) {
                                    }
                                    if ((i4 & 8192) == 0) {
                                    }
                                    if (i22 == 0) {
                                    }
                                    if (i24 == 0) {
                                    }
                                    if (i25 == 0) {
                                    }
                                    if ((i4 & 131072) == 0) {
                                    }
                                    int i362 = i27;
                                    if ((262144 & i4) == 0) {
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i372 = i28 & 2147483646;
                                    int i382 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                                    int i392 = i26 << 3;
                                    TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372, i382 | (29360128 & i392) | (234881024 & i392) | (i392 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    modifier4 = modifier3;
                                    z11 = z7;
                                    z12 = z8;
                                    textStyle4 = textStyle2;
                                    function210 = function25;
                                    function211 = function27;
                                    function212 = function28;
                                    function213 = function29;
                                    z13 = z9;
                                    visualTransformation3 = visualTransformation2;
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActions4 = keyboardActions3;
                                    z14 = z10;
                                    i30 = i29;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    shape4 = shape3;
                                    textFieldColors3 = textFieldColors2;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                            }
                            if ((i3 & 7168) == 0) {
                            }
                            int i332 = i21;
                            i22 = i4 & 16384;
                            if (i22 != 0) {
                            }
                            i23 = i332;
                            i24 = i4 & 32768;
                            if (i24 == 0) {
                            }
                            i25 = i4 & 65536;
                            if (i25 == 0) {
                            }
                            if ((i3 & 29360128) == 0) {
                            }
                            if ((i3 & 234881024) == 0) {
                            }
                            i26 = i23;
                            if ((i5 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i4 & 32) == 0) {
                            }
                            int i3422 = i5;
                            if (i9 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (i20 == 0) {
                            }
                            if ((i4 & 8192) == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i25 == 0) {
                            }
                            if ((i4 & 131072) == 0) {
                            }
                            int i3622 = i27;
                            if ((262144 & i4) == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i3722 = i28 & 2147483646;
                            int i3822 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                            int i3922 = i26 << 3;
                            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722, i3822 | (29360128 & i3922) | (234881024 & i3922) | (i3922 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z7;
                            z12 = z8;
                            textStyle4 = textStyle2;
                            function210 = function25;
                            function211 = function27;
                            function212 = function28;
                            function213 = function29;
                            z13 = z9;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions4 = keyboardActions3;
                            z14 = z10;
                            i30 = i29;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i4 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i4 & 2048;
                        if (i18 == 0) {
                        }
                        int i322 = i17;
                        i20 = i4 & 4096;
                        if (i20 == 0) {
                        }
                        if ((i3 & 7168) == 0) {
                        }
                        int i3322 = i21;
                        i22 = i4 & 16384;
                        if (i22 != 0) {
                        }
                        i23 = i3322;
                        i24 = i4 & 32768;
                        if (i24 == 0) {
                        }
                        i25 = i4 & 65536;
                        if (i25 == 0) {
                        }
                        if ((i3 & 29360128) == 0) {
                        }
                        if ((i3 & 234881024) == 0) {
                        }
                        i26 = i23;
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i4 & 32) == 0) {
                        }
                        int i34222 = i5;
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if ((i4 & 8192) == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i25 == 0) {
                        }
                        if ((i4 & 131072) == 0) {
                        }
                        int i36222 = i27;
                        if ((262144 & i4) == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i37222 = i28 & 2147483646;
                        int i38222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                        int i39222 = i26 << 3;
                        TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222, i38222 | (29360128 & i39222) | (234881024 & i39222) | (i39222 & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z7;
                        z12 = z8;
                        textStyle4 = textStyle2;
                        function210 = function25;
                        function211 = function27;
                        function212 = function28;
                        function213 = function29;
                        z13 = z9;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions4 = keyboardActions3;
                        z14 = z10;
                        i30 = i29;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 == 0) {
                    }
                    int i3222 = i17;
                    i20 = i4 & 4096;
                    if (i20 == 0) {
                    }
                    if ((i3 & 7168) == 0) {
                    }
                    int i33222 = i21;
                    i22 = i4 & 16384;
                    if (i22 != 0) {
                    }
                    i23 = i33222;
                    i24 = i4 & 32768;
                    if (i24 == 0) {
                    }
                    i25 = i4 & 65536;
                    if (i25 == 0) {
                    }
                    if ((i3 & 29360128) == 0) {
                    }
                    if ((i3 & 234881024) == 0) {
                    }
                    i26 = i23;
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i4 & 32) == 0) {
                    }
                    int i342222 = i5;
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if ((i4 & 8192) == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i25 == 0) {
                    }
                    if ((i4 & 131072) == 0) {
                    }
                    int i362222 = i27;
                    if ((262144 & i4) == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i372222 = i28 & 2147483646;
                    int i382222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                    int i392222 = i26 << 3;
                    TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222, i382222 | (29360128 & i392222) | (234881024 & i392222) | (i392222 & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z7;
                    z12 = z8;
                    textStyle4 = textStyle2;
                    function210 = function25;
                    function211 = function27;
                    function212 = function28;
                    function213 = function29;
                    z13 = z9;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions4 = keyboardActions3;
                    z14 = z10;
                    i30 = i29;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                if ((i2 & 458752) != 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 == 0) {
                }
                i18 = i4 & 2048;
                if (i18 == 0) {
                }
                int i32222 = i17;
                i20 = i4 & 4096;
                if (i20 == 0) {
                }
                if ((i3 & 7168) == 0) {
                }
                int i332222 = i21;
                i22 = i4 & 16384;
                if (i22 != 0) {
                }
                i23 = i332222;
                i24 = i4 & 32768;
                if (i24 == 0) {
                }
                i25 = i4 & 65536;
                if (i25 == 0) {
                }
                if ((i3 & 29360128) == 0) {
                }
                if ((i3 & 234881024) == 0) {
                }
                i26 = i23;
                if ((i5 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i4 & 32) == 0) {
                }
                int i3422222 = i5;
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                if ((i4 & 8192) == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i25 == 0) {
                }
                if ((i4 & 131072) == 0) {
                }
                int i3622222 = i27;
                if ((262144 & i4) == 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i3722222 = i28 & 2147483646;
                int i3822222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                int i3922222 = i26 << 3;
                TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722222, i3822222 | (29360128 & i3922222) | (234881024 & i3922222) | (i3922222 & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z7;
                z12 = z8;
                textStyle4 = textStyle2;
                function210 = function25;
                function211 = function27;
                function212 = function28;
                function213 = function29;
                z13 = z9;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions4 = keyboardActions3;
                z14 = z10;
                i30 = i29;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 8;
            int i312 = 2048;
            if (i7 != 0) {
            }
            z5 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            if ((i2 & 458752) != 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 == 0) {
            }
            i18 = i4 & 2048;
            if (i18 == 0) {
            }
            int i322222 = i17;
            i20 = i4 & 4096;
            if (i20 == 0) {
            }
            if ((i3 & 7168) == 0) {
            }
            int i3322222 = i21;
            i22 = i4 & 16384;
            if (i22 != 0) {
            }
            i23 = i3322222;
            i24 = i4 & 32768;
            if (i24 == 0) {
            }
            i25 = i4 & 65536;
            if (i25 == 0) {
            }
            if ((i3 & 29360128) == 0) {
            }
            if ((i3 & 234881024) == 0) {
            }
            i26 = i23;
            if ((i5 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i4 & 32) == 0) {
            }
            int i34222222 = i5;
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            if ((i4 & 8192) == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i25 == 0) {
            }
            if ((i4 & 131072) == 0) {
            }
            int i36222222 = i27;
            if ((262144 & i4) == 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i37222222 = i28 & 2147483646;
            int i38222222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
            int i39222222 = i26 << 3;
            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222222, i38222222 | (29360128 & i39222222) | (234881024 & i39222222) | (i39222222 & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z7;
            z12 = z8;
            textStyle4 = textStyle2;
            function210 = function25;
            function211 = function27;
            function212 = function28;
            function213 = function29;
            z13 = z9;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            z14 = z10;
            i30 = i29;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 8;
        int i3122 = 2048;
        if (i7 != 0) {
        }
        z5 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        if ((i2 & 458752) != 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 == 0) {
        }
        i18 = i4 & 2048;
        if (i18 == 0) {
        }
        int i3222222 = i17;
        i20 = i4 & 4096;
        if (i20 == 0) {
        }
        if ((i3 & 7168) == 0) {
        }
        int i33222222 = i21;
        i22 = i4 & 16384;
        if (i22 != 0) {
        }
        i23 = i33222222;
        i24 = i4 & 32768;
        if (i24 == 0) {
        }
        i25 = i4 & 65536;
        if (i25 == 0) {
        }
        if ((i3 & 29360128) == 0) {
        }
        if ((i3 & 234881024) == 0) {
        }
        i26 = i23;
        if ((i5 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        int i342222222 = i5;
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        if ((i4 & 8192) == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i25 == 0) {
        }
        if ((i4 & 131072) == 0) {
        }
        int i362222222 = i27;
        if ((262144 & i4) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i372222222 = i28 & 2147483646;
        int i382222222 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
        int i392222222 = i26 << 3;
        TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222222, i382222222 | (29360128 & i392222222) | (234881024 & i392222222) | (i392222222 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z7;
        z12 = z8;
        textStyle4 = textStyle2;
        function210 = function25;
        function211 = function27;
        function212 = function28;
        function213 = function29;
        z13 = z9;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions4 = keyboardActions3;
        z14 = z10;
        i30 = i29;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-2112507061);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)487@22599L139,490@22786L7,491@22798L1853:TextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= startRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112507061, i2, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:486)");
            }
            Boolean valueOf = Boolean.valueOf(z);
            Float valueOf2 = Float.valueOf(f);
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(valueOf2) | startRestartGroup.changed(paddingValues);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
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
            Updater.m3600setimpl(m3593constructorimpl, textFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 254819939, "C533@24413L183:TextField.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(254819939);
            ComposerKt.sourceInformation(startRestartGroup, "495@22906L219");
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
                i3 = i2;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1767364245, "C499@23098L9:TextField.kt#jmzs0o");
                function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i3 = i2;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(254820224);
            ComposerKt.sourceInformation(startRestartGroup, "503@23192L221");
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1767363958, "C507@23385L10:TextField.kt#jmzs0o");
                function24.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function23 != null) {
                i4 = 0;
                calculateStartPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(0)));
            } else {
                i4 = 0;
            }
            float f2 = calculateStartPadding;
            if (function24 != null) {
                calculateEndPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(i4)));
            }
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f2, 0.0f, calculateEndPadding, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(254821235);
            ComposerKt.sourceInformation(startRestartGroup, "528@24206L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(m883paddingqDBjuR0$default), startRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(254821364);
            ComposerKt.sourceInformation(startRestartGroup, "531@24329L57");
            if (function22 != null) {
                Modifier then3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label").then(m883paddingqDBjuR0$default);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(then3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1767362966, "C531@24377L7:TextField.kt#jmzs0o");
                function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(m883paddingqDBjuR0$default);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(then4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl5 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl5, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl5.getInserting() || !Intrinsics.areEqual(m3593constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3593constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3593constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            modifierMaterializerOf5.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1767362772, "C537@24571L11:TextField.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextFieldLayout$2
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
                    TextFieldKt.TextFieldLayout(Modifier.this, function2, function22, function3, function23, function24, z, f, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1839calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m6347getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1838calculateHeightO3s9Psw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        float f2 = TextFieldTopPadding * f;
        float top = paddingValues.getTop() * f;
        float bottom = paddingValues.getBottom() * f;
        int max = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? i2 + f2 + max + bottom : top + max + bottom), Math.max(Math.max(i3, i4), Constraints.m6346getMinHeightimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        int roundToInt;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            } else {
                roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt - MathKt.roundToInt((roundToInt - i3) * f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i2) : roundToInt, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), roundToInt, 0.0f, 4, null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke borderStroke) {
        final float width = borderStroke.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt$drawIndicatorLine$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                if (Dp.m6394equalsimpl0(width, Dp.INSTANCE.m6407getHairlineD9Ej5fM())) {
                    return;
                }
                float density = width * contentDrawScope.getDensity();
                float m3888getHeightimpl = Size.m3888getHeightimpl(contentDrawScope.mo4612getSizeNHjbRc()) - (density / 2);
                DrawScope.m4598drawLine1RTmtNc$default(contentDrawScope, borderStroke.getBrush(), OffsetKt.Offset(0.0f, m3888getHeightimpl), OffsetKt.Offset(Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()), m3888getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
