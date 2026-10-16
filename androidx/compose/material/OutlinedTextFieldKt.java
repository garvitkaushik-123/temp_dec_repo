package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
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

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÁ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001aZ\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aZ\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010F\u001a&\u0010N\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a|\u0010R\u001a\u00020\t*\u00020S2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010\\\u001a\u00020W2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m6389constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m6389constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:102:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
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
        int i27;
        int i28;
        Modifier.Companion companion;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        KeyboardOptions keyboardOptions2;
        int i29;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        int i30;
        Composer composer2;
        TextFieldColors textFieldColors2;
        boolean z7;
        boolean z8;
        TextStyle textStyle4;
        int i31;
        boolean z9;
        VisualTransformation visualTransformation2;
        KeyboardActions keyboardActions2;
        boolean z10;
        int i32;
        int i33;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        int i34;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        long m5918getColor0d7_KjU;
        int i35;
        Modifier modifier3;
        Composer composer3;
        final boolean z11;
        final VisualTransformation visualTransformation3;
        final TextFieldColors textFieldColors3;
        final boolean z12;
        final boolean z13;
        final int i36;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        final TextStyle textStyle5;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Shape shape4;
        final KeyboardOptions keyboardOptions3;
        final int i37;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)141@7857L7,153@8463L39,154@8537L6,155@8599L25,175@9370L24,176@9453L38,185@9820L20,164@8927L2135:OutlinedTextField.kt#jmzs0o");
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
                            int i38 = i18;
                            i21 = i5 & 4096;
                            if (i21 == 0) {
                                i22 = i38 | 384;
                            } else {
                                int i39 = i38;
                                if ((i4 & 896) == 0) {
                                    i39 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i22 = i39;
                            }
                            i23 = i5 & 8192;
                            if (i23 == 0) {
                                i24 = i22 | 3072;
                            } else {
                                int i40 = i22;
                                if ((i4 & 7168) == 0) {
                                    i24 = i40 | (startRestartGroup.changed(keyboardActions) ? 2048 : 1024);
                                } else {
                                    i24 = i40;
                                }
                            }
                            i25 = i5 & 16384;
                            if (i25 == 0) {
                                i24 |= 24576;
                            } else if ((i4 & 57344) == 0) {
                                i26 = i24 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                if ((i4 & 458752) == 0) {
                                    i26 |= ((i5 & 32768) == 0 && startRestartGroup.changed(i)) ? 131072 : 65536;
                                }
                                i27 = i5 & 65536;
                                if (i27 != 0) {
                                    i26 |= 1572864;
                                } else if ((i4 & 3670016) == 0) {
                                    i26 |= startRestartGroup.changed(i2) ? 1048576 : 524288;
                                }
                                i28 = i5 & 131072;
                                if (i28 != 0) {
                                    i26 |= 12582912;
                                } else if ((i4 & 29360128) == 0) {
                                    i26 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                }
                                if ((i4 & 234881024) == 0) {
                                    i26 |= ((i5 & 262144) == 0 && startRestartGroup.changed(shape)) ? 67108864 : 33554432;
                                }
                                if ((i4 & 1879048192) == 0) {
                                    i26 |= ((i5 & 524288) == 0 && startRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                                }
                                if ((i6 & 1533916891) == 306783378 || (i26 & 1533916891) != 306783378 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z15 = i8 != 0 ? true : z;
                                        if (i9 != 0) {
                                            z6 = false;
                                        }
                                        boolean z16 = z6;
                                        if ((i5 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i6 &= -458753;
                                            textStyle3 = (TextStyle) consume;
                                        } else {
                                            textStyle3 = textStyle2;
                                        }
                                        int i41 = i6;
                                        Function2<? super Composer, ? super Integer, Unit> function215 = i10 != 0 ? null : function25;
                                        function27 = i11 != 0 ? null : function26;
                                        function28 = i13 != 0 ? null : function23;
                                        function29 = i15 != 0 ? null : function24;
                                        boolean z17 = i17 != 0 ? false : z3;
                                        VisualTransformation none = i20 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        keyboardOptions2 = i21 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i23 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z18 = i25 != 0 ? false : z4;
                                        if ((32768 & i5) != 0) {
                                            i26 &= -458753;
                                            i29 = z18 ? 1 : Integer.MAX_VALUE;
                                        } else {
                                            i29 = i;
                                        }
                                        int i42 = i27 != 0 ? 1 : i2;
                                        if (i28 != 0) {
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
                                        if ((262144 & i5) != 0) {
                                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                                            i30 = i26 & (-234881025);
                                        } else {
                                            shape2 = shape;
                                            i30 = i26;
                                        }
                                        if ((i5 & 524288) != 0) {
                                            composer2 = startRestartGroup;
                                            textFieldColors2 = TextFieldDefaults.INSTANCE.m1825outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, 48, 2097151);
                                            i34 = i30 & (-1879048193);
                                            z7 = z15;
                                            z8 = z16;
                                            textStyle4 = textStyle3;
                                            i31 = i41;
                                            function25 = function215;
                                            z9 = z17;
                                            visualTransformation2 = none;
                                            keyboardActions2 = keyboardActions4;
                                            z10 = z18;
                                            i32 = i29;
                                            i33 = i42;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            shape3 = shape2;
                                        } else {
                                            composer2 = startRestartGroup;
                                            textFieldColors2 = textFieldColors;
                                            z7 = z15;
                                            z8 = z16;
                                            textStyle4 = textStyle3;
                                            i31 = i41;
                                            function25 = function215;
                                            z9 = z17;
                                            visualTransformation2 = none;
                                            keyboardActions2 = keyboardActions4;
                                            z10 = z18;
                                            i32 = i29;
                                            i33 = i42;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            shape3 = shape2;
                                            i34 = i30;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32) != 0) {
                                            i6 &= -458753;
                                        }
                                        if ((32768 & i5) != 0) {
                                            i26 &= -458753;
                                        }
                                        if ((262144 & i5) != 0) {
                                            i26 &= -234881025;
                                        }
                                        if ((i5 & 524288) != 0) {
                                            i26 &= -1879048193;
                                        }
                                        function28 = function23;
                                        function29 = function24;
                                        visualTransformation2 = visualTransformation;
                                        keyboardOptions2 = keyboardOptions;
                                        keyboardActions2 = keyboardActions;
                                        z10 = z4;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        textFieldColors2 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z8 = z6;
                                        i31 = i6;
                                        textStyle4 = textStyle2;
                                        function27 = function26;
                                        companion = modifier2;
                                        i34 = i26;
                                        z7 = z;
                                        z9 = z3;
                                        i32 = i;
                                        i33 = i2;
                                        shape3 = shape;
                                    }
                                    composer2.endDefaults();
                                    boolean z19 = z8;
                                    if (ComposerKt.isTraceInProgress()) {
                                        function210 = function25;
                                        ComposerKt.traceEventStart(-621914704, i31, i34, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:156)");
                                    } else {
                                        function210 = function25;
                                    }
                                    composer2.startReplaceableGroup(1961395303);
                                    ComposerKt.sourceInformation(composer2, "*159@8776L18");
                                    m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
                                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                        m5918getColor0d7_KjU = textFieldColors2.textColor(z7, composer2, ((i31 >> 9) & 14) | ((i34 >> 24) & 112)).getValue().m4073unboximpl();
                                    }
                                    composer2.endReplaceableGroup();
                                    TextStyle merge = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    if (function210 != null) {
                                        i35 = i34;
                                        modifier3 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$2
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                                    } else {
                                        i35 = i34;
                                        modifier3 = companion;
                                    }
                                    int i43 = (i35 >> 24) & 112;
                                    int i44 = i31;
                                    TextStyle textStyle6 = textStyle4;
                                    Modifier modifier5 = companion;
                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                    final boolean z20 = z9;
                                    final boolean z21 = z7;
                                    final Shape shape5 = shape3;
                                    final boolean z22 = z10;
                                    final VisualTransformation visualTransformation4 = visualTransformation2;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                    Function2<? super Composer, ? super Integer, Unit> function219 = function210;
                                    int i45 = i35 << 12;
                                    Composer composer4 = composer2;
                                    KeyboardOptions keyboardOptions4 = keyboardOptions2;
                                    BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i43).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19, merge, keyboardOptions4, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i43).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                            int i47;
                                            ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                                            if ((i46 & 14) == 0) {
                                                i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                            } else {
                                                i47 = i46;
                                            }
                                            if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                                                }
                                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                int i48 = i47;
                                                String str2 = str;
                                                boolean z23 = z21;
                                                boolean z24 = z22;
                                                VisualTransformation visualTransformation5 = visualTransformation4;
                                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                boolean z25 = z20;
                                                Function2<Composer, Integer, Unit> function221 = function210;
                                                Function2<Composer, Integer, Unit> function222 = function216;
                                                Function2<Composer, Integer, Unit> function223 = function217;
                                                Function2<Composer, Integer, Unit> function224 = function218;
                                                TextFieldColors textFieldColors5 = textFieldColors4;
                                                final boolean z26 = z21;
                                                final boolean z27 = z20;
                                                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                                final TextFieldColors textFieldColors6 = textFieldColors4;
                                                final Shape shape6 = shape5;
                                                textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation5, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                        invoke(composer6, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer6, int i49) {
                                                        ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                                        if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                                            }
                                                            TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer6.skipToGroupEnd();
                                                    }
                                                }), composer5, (i48 << 3) & 112, 27648, 4096);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, (i44 & 64638) | (i45 & 3670016) | (i45 & 29360128) | (234881024 & i45) | (i45 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
                                    composer3 = composer4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    VisualTransformation visualTransformation5 = visualTransformation2;
                                    z11 = z10;
                                    visualTransformation3 = visualTransformation5;
                                    textFieldColors3 = textFieldColors4;
                                    z12 = z7;
                                    z13 = z19;
                                    i36 = i32;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    modifier4 = modifier5;
                                    textStyle5 = textStyle6;
                                    function211 = function219;
                                    function212 = function27;
                                    function213 = function28;
                                    shape4 = shape5;
                                    keyboardOptions3 = keyboardOptions4;
                                    i37 = i33;
                                    function214 = function29;
                                    keyboardActions3 = keyboardActions2;
                                    z14 = z20;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z14 = z3;
                                    visualTransformation3 = visualTransformation;
                                    z11 = z4;
                                    i36 = i;
                                    i37 = i2;
                                    mutableInteractionSource4 = mutableInteractionSource;
                                    shape4 = shape;
                                    textFieldColors3 = textFieldColors;
                                    composer3 = startRestartGroup;
                                    z12 = z5;
                                    z13 = z6;
                                    textStyle5 = textStyle2;
                                    function211 = function25;
                                    function212 = function26;
                                    modifier4 = modifier2;
                                    function213 = function23;
                                    function214 = function24;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                }
                                endRestartGroup = composer3.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$4
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

                                        public final void invoke(Composer composer5, int i46) {
                                            OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier4, z12, z13, textStyle5, function211, function212, function213, function214, z14, visualTransformation3, keyboardOptions3, keyboardActions3, z11, i36, i37, mutableInteractionSource4, shape4, textFieldColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i26 = i24;
                            if ((i4 & 458752) == 0) {
                            }
                            i27 = i5 & 65536;
                            if (i27 != 0) {
                            }
                            i28 = i5 & 131072;
                            if (i28 != 0) {
                            }
                            if ((i4 & 234881024) == 0) {
                            }
                            if ((i4 & 1879048192) == 0) {
                            }
                            if ((i6 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            boolean z162 = z6;
                            if ((i5 & 32) != 0) {
                            }
                            int i412 = i6;
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            if (i25 != 0) {
                            }
                            if ((32768 & i5) != 0) {
                            }
                            if (i27 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if ((262144 & i5) != 0) {
                            }
                            if ((i5 & 524288) != 0) {
                            }
                            composer2.endDefaults();
                            boolean z192 = z8;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(1961395303);
                            ComposerKt.sourceInformation(composer2, "*159@8776L18");
                            m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                            }
                            composer2.endReplaceableGroup();
                            TextStyle merge2 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            if (function210 != null) {
                            }
                            int i432 = (i35 >> 24) & 112;
                            int i442 = i31;
                            TextStyle textStyle62 = textStyle4;
                            Modifier modifier52 = companion;
                            final TextFieldColors textFieldColors42 = textFieldColors2;
                            final boolean z202 = z9;
                            final boolean z212 = z7;
                            final Shape shape52 = shape3;
                            final boolean z222 = z10;
                            final VisualTransformation visualTransformation42 = visualTransformation2;
                            final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                            final Function2<? super Composer, ? super Integer, Unit> function2162 = function27;
                            final Function2<? super Composer, ? super Integer, Unit> function2172 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                            Function2<? super Composer, ? super Integer, Unit> function2192 = function210;
                            int i452 = i35 << 12;
                            Composer composer42 = composer2;
                            KeyboardOptions keyboardOptions42 = keyboardOptions2;
                            BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i432).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z192, merge2, keyboardOptions42, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i432).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                    int i47;
                                    ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                                    if ((i46 & 14) == 0) {
                                        i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                    } else {
                                        i47 = i46;
                                    }
                                    if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                                        }
                                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                        int i48 = i47;
                                        String str2 = str;
                                        boolean z23 = z212;
                                        boolean z24 = z222;
                                        VisualTransformation visualTransformation52 = visualTransformation42;
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52;
                                        boolean z25 = z202;
                                        Function2<Composer, Integer, Unit> function221 = function210;
                                        Function2<Composer, Integer, Unit> function222 = function2162;
                                        Function2<Composer, Integer, Unit> function223 = function2172;
                                        Function2<Composer, Integer, Unit> function224 = function2182;
                                        TextFieldColors textFieldColors5 = textFieldColors42;
                                        final boolean z26 = z212;
                                        final boolean z27 = z202;
                                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource52;
                                        final TextFieldColors textFieldColors6 = textFieldColors42;
                                        final Shape shape6 = shape52;
                                        textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation52, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i49) {
                                                ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                                if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer6.skipToGroupEnd();
                                            }
                                        }), composer5, (i48 << 3) & 112, 27648, 4096);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer42, (i442 & 64638) | (i452 & 3670016) | (i452 & 29360128) | (234881024 & i452) | (i452 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            VisualTransformation visualTransformation52 = visualTransformation2;
                            z11 = z10;
                            visualTransformation3 = visualTransformation52;
                            textFieldColors3 = textFieldColors42;
                            z12 = z7;
                            z13 = z192;
                            i36 = i32;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier52;
                            textStyle5 = textStyle62;
                            function211 = function2192;
                            function212 = function27;
                            function213 = function28;
                            shape4 = shape52;
                            keyboardOptions3 = keyboardOptions42;
                            i37 = i33;
                            function214 = function29;
                            keyboardActions3 = keyboardActions2;
                            z14 = z202;
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i5 & 2048;
                        if (i19 == 0) {
                        }
                        int i382 = i18;
                        i21 = i5 & 4096;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 8192;
                        if (i23 == 0) {
                        }
                        i25 = i5 & 16384;
                        if (i25 == 0) {
                        }
                        i26 = i24;
                        if ((i4 & 458752) == 0) {
                        }
                        i27 = i5 & 65536;
                        if (i27 != 0) {
                        }
                        i28 = i5 & 131072;
                        if (i28 != 0) {
                        }
                        if ((i4 & 234881024) == 0) {
                        }
                        if ((i4 & 1879048192) == 0) {
                        }
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        boolean z1622 = z6;
                        if ((i5 & 32) != 0) {
                        }
                        int i4122 = i6;
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (i25 != 0) {
                        }
                        if ((32768 & i5) != 0) {
                        }
                        if (i27 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if ((262144 & i5) != 0) {
                        }
                        if ((i5 & 524288) != 0) {
                        }
                        composer2.endDefaults();
                        boolean z1922 = z8;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2.startReplaceableGroup(1961395303);
                        ComposerKt.sourceInformation(composer2, "*159@8776L18");
                        m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        }
                        composer2.endReplaceableGroup();
                        TextStyle merge22 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                        if (function210 != null) {
                        }
                        int i4322 = (i35 >> 24) & 112;
                        int i4422 = i31;
                        TextStyle textStyle622 = textStyle4;
                        Modifier modifier522 = companion;
                        final TextFieldColors textFieldColors422 = textFieldColors2;
                        final boolean z2022 = z9;
                        final boolean z2122 = z7;
                        final Shape shape522 = shape3;
                        final boolean z2222 = z10;
                        final VisualTransformation visualTransformation422 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                        final Function2<? super Composer, ? super Integer, Unit> function21622 = function27;
                        final Function2<? super Composer, ? super Integer, Unit> function21722 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                        Function2<? super Composer, ? super Integer, Unit> function21922 = function210;
                        int i4522 = i35 << 12;
                        Composer composer422 = composer2;
                        KeyboardOptions keyboardOptions422 = keyboardOptions2;
                        BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i4322).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z1922, merge22, keyboardOptions422, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i4322).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                int i47;
                                ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                                if ((i46 & 14) == 0) {
                                    i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                } else {
                                    i47 = i46;
                                }
                                if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                                    }
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    int i48 = i47;
                                    String str2 = str;
                                    boolean z23 = z2122;
                                    boolean z24 = z2222;
                                    VisualTransformation visualTransformation522 = visualTransformation422;
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522;
                                    boolean z25 = z2022;
                                    Function2<Composer, Integer, Unit> function221 = function210;
                                    Function2<Composer, Integer, Unit> function222 = function21622;
                                    Function2<Composer, Integer, Unit> function223 = function21722;
                                    Function2<Composer, Integer, Unit> function224 = function21822;
                                    TextFieldColors textFieldColors5 = textFieldColors422;
                                    final boolean z26 = z2122;
                                    final boolean z27 = z2022;
                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource522;
                                    final TextFieldColors textFieldColors6 = textFieldColors422;
                                    final Shape shape6 = shape522;
                                    textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation522, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i49) {
                                            ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                            if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                                }
                                                TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer6.skipToGroupEnd();
                                        }
                                    }), composer5, (i48 << 3) & 112, 27648, 4096);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer422, (i4422 & 64638) | (i4522 & 3670016) | (i4522 & 29360128) | (234881024 & i4522) | (i4522 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
                        composer3 = composer422;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        VisualTransformation visualTransformation522 = visualTransformation2;
                        z11 = z10;
                        visualTransformation3 = visualTransformation522;
                        textFieldColors3 = textFieldColors422;
                        z12 = z7;
                        z13 = z1922;
                        i36 = i32;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier522;
                        textStyle5 = textStyle622;
                        function211 = function21922;
                        function212 = function27;
                        function213 = function28;
                        shape4 = shape522;
                        keyboardOptions3 = keyboardOptions422;
                        i37 = i33;
                        function214 = function29;
                        keyboardActions3 = keyboardActions2;
                        z14 = z2022;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
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
                    int i3822 = i18;
                    i21 = i5 & 4096;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 8192;
                    if (i23 == 0) {
                    }
                    i25 = i5 & 16384;
                    if (i25 == 0) {
                    }
                    i26 = i24;
                    if ((i4 & 458752) == 0) {
                    }
                    i27 = i5 & 65536;
                    if (i27 != 0) {
                    }
                    i28 = i5 & 131072;
                    if (i28 != 0) {
                    }
                    if ((i4 & 234881024) == 0) {
                    }
                    if ((i4 & 1879048192) == 0) {
                    }
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    boolean z16222 = z6;
                    if ((i5 & 32) != 0) {
                    }
                    int i41222 = i6;
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i25 != 0) {
                    }
                    if ((32768 & i5) != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if ((262144 & i5) != 0) {
                    }
                    if ((i5 & 524288) != 0) {
                    }
                    composer2.endDefaults();
                    boolean z19222 = z8;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2.startReplaceableGroup(1961395303);
                    ComposerKt.sourceInformation(composer2, "*159@8776L18");
                    m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    composer2.endReplaceableGroup();
                    TextStyle merge222 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                    if (function210 != null) {
                    }
                    int i43222 = (i35 >> 24) & 112;
                    int i44222 = i31;
                    TextStyle textStyle6222 = textStyle4;
                    Modifier modifier5222 = companion;
                    final TextFieldColors textFieldColors4222 = textFieldColors2;
                    final boolean z20222 = z9;
                    final boolean z21222 = z7;
                    final Shape shape5222 = shape3;
                    final boolean z22222 = z10;
                    final VisualTransformation visualTransformation4222 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                    final Function2<? super Composer, ? super Integer, Unit> function216222 = function27;
                    final Function2<? super Composer, ? super Integer, Unit> function217222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                    Function2<? super Composer, ? super Integer, Unit> function219222 = function210;
                    int i45222 = i35 << 12;
                    Composer composer4222 = composer2;
                    KeyboardOptions keyboardOptions4222 = keyboardOptions2;
                    BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i43222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19222, merge222, keyboardOptions4222, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i43222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                            int i47;
                            ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                            if ((i46 & 14) == 0) {
                                i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                            } else {
                                i47 = i46;
                            }
                            if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                                }
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                int i48 = i47;
                                String str2 = str;
                                boolean z23 = z21222;
                                boolean z24 = z22222;
                                VisualTransformation visualTransformation5222 = visualTransformation4222;
                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5222;
                                boolean z25 = z20222;
                                Function2<Composer, Integer, Unit> function221 = function210;
                                Function2<Composer, Integer, Unit> function222 = function216222;
                                Function2<Composer, Integer, Unit> function223 = function217222;
                                Function2<Composer, Integer, Unit> function224 = function218222;
                                TextFieldColors textFieldColors5 = textFieldColors4222;
                                final boolean z26 = z21222;
                                final boolean z27 = z20222;
                                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5222;
                                final TextFieldColors textFieldColors6 = textFieldColors4222;
                                final Shape shape6 = shape5222;
                                textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation5222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                        invoke(composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer6, int i49) {
                                        ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                        if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                            }
                                            TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer6.skipToGroupEnd();
                                    }
                                }), composer5, (i48 << 3) & 112, 27648, 4096);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer4222, (i44222 & 64638) | (i45222 & 3670016) | (i45222 & 29360128) | (234881024 & i45222) | (i45222 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
                    composer3 = composer4222;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    VisualTransformation visualTransformation5222 = visualTransformation2;
                    z11 = z10;
                    visualTransformation3 = visualTransformation5222;
                    textFieldColors3 = textFieldColors4222;
                    z12 = z7;
                    z13 = z19222;
                    i36 = i32;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier5222;
                    textStyle5 = textStyle6222;
                    function211 = function219222;
                    function212 = function27;
                    function213 = function28;
                    shape4 = shape5222;
                    keyboardOptions3 = keyboardOptions4222;
                    i37 = i33;
                    function214 = function29;
                    keyboardActions3 = keyboardActions2;
                    z14 = z20222;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
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
                int i38222 = i18;
                i21 = i5 & 4096;
                if (i21 == 0) {
                }
                i23 = i5 & 8192;
                if (i23 == 0) {
                }
                i25 = i5 & 16384;
                if (i25 == 0) {
                }
                i26 = i24;
                if ((i4 & 458752) == 0) {
                }
                i27 = i5 & 65536;
                if (i27 != 0) {
                }
                i28 = i5 & 131072;
                if (i28 != 0) {
                }
                if ((i4 & 234881024) == 0) {
                }
                if ((i4 & 1879048192) == 0) {
                }
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                boolean z162222 = z6;
                if ((i5 & 32) != 0) {
                }
                int i412222 = i6;
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i21 != 0) {
                }
                if (i23 != 0) {
                }
                if (i25 != 0) {
                }
                if ((32768 & i5) != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 != 0) {
                }
                if ((262144 & i5) != 0) {
                }
                if ((i5 & 524288) != 0) {
                }
                composer2.endDefaults();
                boolean z192222 = z8;
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2.startReplaceableGroup(1961395303);
                ComposerKt.sourceInformation(composer2, "*159@8776L18");
                m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                composer2.endReplaceableGroup();
                TextStyle merge2222 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                if (function210 != null) {
                }
                int i432222 = (i35 >> 24) & 112;
                int i442222 = i31;
                TextStyle textStyle62222 = textStyle4;
                Modifier modifier52222 = companion;
                final TextFieldColors textFieldColors42222 = textFieldColors2;
                final boolean z202222 = z9;
                final boolean z212222 = z7;
                final Shape shape52222 = shape3;
                final boolean z222222 = z10;
                final VisualTransformation visualTransformation42222 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function2162222 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function2172222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                Function2<? super Composer, ? super Integer, Unit> function2192222 = function210;
                int i452222 = i35 << 12;
                Composer composer42222 = composer2;
                KeyboardOptions keyboardOptions42222 = keyboardOptions2;
                BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i432222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z192222, merge2222, keyboardOptions42222, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i432222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                        int i47;
                        ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                        if ((i46 & 14) == 0) {
                            i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                        } else {
                            i47 = i46;
                        }
                        if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                            }
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            int i48 = i47;
                            String str2 = str;
                            boolean z23 = z212222;
                            boolean z24 = z222222;
                            VisualTransformation visualTransformation52222 = visualTransformation42222;
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52222;
                            boolean z25 = z202222;
                            Function2<Composer, Integer, Unit> function221 = function210;
                            Function2<Composer, Integer, Unit> function222 = function2162222;
                            Function2<Composer, Integer, Unit> function223 = function2172222;
                            Function2<Composer, Integer, Unit> function224 = function2182222;
                            TextFieldColors textFieldColors5 = textFieldColors42222;
                            final boolean z26 = z212222;
                            final boolean z27 = z202222;
                            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource52222;
                            final TextFieldColors textFieldColors6 = textFieldColors42222;
                            final Shape shape6 = shape52222;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation52222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer6, int i49) {
                                    ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                        }
                                        TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer6.skipToGroupEnd();
                                }
                            }), composer5, (i48 << 3) & 112, 27648, 4096);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }), composer42222, (i442222 & 64638) | (i452222 & 3670016) | (i452222 & 29360128) | (234881024 & i452222) | (i452222 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
                composer3 = composer42222;
                if (ComposerKt.isTraceInProgress()) {
                }
                VisualTransformation visualTransformation52222 = visualTransformation2;
                z11 = z10;
                visualTransformation3 = visualTransformation52222;
                textFieldColors3 = textFieldColors42222;
                z12 = z7;
                z13 = z192222;
                i36 = i32;
                mutableInteractionSource4 = mutableInteractionSource3;
                modifier4 = modifier52222;
                textStyle5 = textStyle62222;
                function211 = function2192222;
                function212 = function27;
                function213 = function28;
                shape4 = shape52222;
                keyboardOptions3 = keyboardOptions42222;
                i37 = i33;
                function214 = function29;
                keyboardActions3 = keyboardActions2;
                z14 = z202222;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
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
            int i382222 = i18;
            i21 = i5 & 4096;
            if (i21 == 0) {
            }
            i23 = i5 & 8192;
            if (i23 == 0) {
            }
            i25 = i5 & 16384;
            if (i25 == 0) {
            }
            i26 = i24;
            if ((i4 & 458752) == 0) {
            }
            i27 = i5 & 65536;
            if (i27 != 0) {
            }
            i28 = i5 & 131072;
            if (i28 != 0) {
            }
            if ((i4 & 234881024) == 0) {
            }
            if ((i4 & 1879048192) == 0) {
            }
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            boolean z1622222 = z6;
            if ((i5 & 32) != 0) {
            }
            int i4122222 = i6;
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i21 != 0) {
            }
            if (i23 != 0) {
            }
            if (i25 != 0) {
            }
            if ((32768 & i5) != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 != 0) {
            }
            if ((262144 & i5) != 0) {
            }
            if ((i5 & 524288) != 0) {
            }
            composer2.endDefaults();
            boolean z1922222 = z8;
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2.startReplaceableGroup(1961395303);
            ComposerKt.sourceInformation(composer2, "*159@8776L18");
            m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            composer2.endReplaceableGroup();
            TextStyle merge22222 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            if (function210 != null) {
            }
            int i4322222 = (i35 >> 24) & 112;
            int i4422222 = i31;
            TextStyle textStyle622222 = textStyle4;
            Modifier modifier522222 = companion;
            final TextFieldColors textFieldColors422222 = textFieldColors2;
            final boolean z2022222 = z9;
            final boolean z2122222 = z7;
            final Shape shape522222 = shape3;
            final boolean z2222222 = z10;
            final VisualTransformation visualTransformation422222 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
            final Function2<? super Composer, ? super Integer, Unit> function21622222 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function21722222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
            Function2<? super Composer, ? super Integer, Unit> function21922222 = function210;
            int i4522222 = i35 << 12;
            Composer composer422222 = composer2;
            KeyboardOptions keyboardOptions422222 = keyboardOptions2;
            BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i4322222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z1922222, merge22222, keyboardOptions422222, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i4322222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                    int i47;
                    ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                    if ((i46 & 14) == 0) {
                        i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                    } else {
                        i47 = i46;
                    }
                    if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        int i48 = i47;
                        String str2 = str;
                        boolean z23 = z2122222;
                        boolean z24 = z2222222;
                        VisualTransformation visualTransformation522222 = visualTransformation422222;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522222;
                        boolean z25 = z2022222;
                        Function2<Composer, Integer, Unit> function221 = function210;
                        Function2<Composer, Integer, Unit> function222 = function21622222;
                        Function2<Composer, Integer, Unit> function223 = function21722222;
                        Function2<Composer, Integer, Unit> function224 = function21822222;
                        TextFieldColors textFieldColors5 = textFieldColors422222;
                        final boolean z26 = z2122222;
                        final boolean z27 = z2022222;
                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource522222;
                        final TextFieldColors textFieldColors6 = textFieldColors422222;
                        final Shape shape6 = shape522222;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation522222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                invoke(composer6, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer6, int i49) {
                                ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer6.skipToGroupEnd();
                            }
                        }), composer5, (i48 << 3) & 112, 27648, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }), composer422222, (i4422222 & 64638) | (i4522222 & 3670016) | (i4522222 & 29360128) | (234881024 & i4522222) | (i4522222 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
            composer3 = composer422222;
            if (ComposerKt.isTraceInProgress()) {
            }
            VisualTransformation visualTransformation522222 = visualTransformation2;
            z11 = z10;
            visualTransformation3 = visualTransformation522222;
            textFieldColors3 = textFieldColors422222;
            z12 = z7;
            z13 = z1922222;
            i36 = i32;
            mutableInteractionSource4 = mutableInteractionSource3;
            modifier4 = modifier522222;
            textStyle5 = textStyle622222;
            function211 = function21922222;
            function212 = function27;
            function213 = function28;
            shape4 = shape522222;
            keyboardOptions3 = keyboardOptions422222;
            i37 = i33;
            function214 = function29;
            keyboardActions3 = keyboardActions2;
            z14 = z2022222;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
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
        int i3822222 = i18;
        i21 = i5 & 4096;
        if (i21 == 0) {
        }
        i23 = i5 & 8192;
        if (i23 == 0) {
        }
        i25 = i5 & 16384;
        if (i25 == 0) {
        }
        i26 = i24;
        if ((i4 & 458752) == 0) {
        }
        i27 = i5 & 65536;
        if (i27 != 0) {
        }
        i28 = i5 & 131072;
        if (i28 != 0) {
        }
        if ((i4 & 234881024) == 0) {
        }
        if ((i4 & 1879048192) == 0) {
        }
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        boolean z16222222 = z6;
        if ((i5 & 32) != 0) {
        }
        int i41222222 = i6;
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i21 != 0) {
        }
        if (i23 != 0) {
        }
        if (i25 != 0) {
        }
        if ((32768 & i5) != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 != 0) {
        }
        if ((262144 & i5) != 0) {
        }
        if ((i5 & 524288) != 0) {
        }
        composer2.endDefaults();
        boolean z19222222 = z8;
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.startReplaceableGroup(1961395303);
        ComposerKt.sourceInformation(composer2, "*159@8776L18");
        m5918getColor0d7_KjU = textStyle4.m5918getColor0d7_KjU();
        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        composer2.endReplaceableGroup();
        TextStyle merge222222 = textStyle4.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        if (function210 != null) {
        }
        int i43222222 = (i35 >> 24) & 112;
        int i44222222 = i31;
        TextStyle textStyle6222222 = textStyle4;
        Modifier modifier5222222 = companion;
        final TextFieldColors textFieldColors4222222 = textFieldColors2;
        final boolean z20222222 = z9;
        final boolean z21222222 = z7;
        final Shape shape5222222 = shape3;
        final boolean z22222222 = z10;
        final VisualTransformation visualTransformation4222222 = visualTransformation2;
        final MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function216222222 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function217222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
        Function2<? super Composer, ? super Integer, Unit> function219222222 = function210;
        int i45222222 = i35 << 12;
        Composer composer4222222 = composer2;
        KeyboardOptions keyboardOptions4222222 = keyboardOptions2;
        BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i31 >> 9) & 14) | i43222222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19222222, merge222222, keyboardOptions4222222, keyboardActions2, z10, i32, i33, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i35 & 14) | i43222222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                int i47;
                ComposerKt.sourceInformation(composer5, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                if ((i46 & 14) == 0) {
                    i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                } else {
                    i47 = i46;
                }
                if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1710364390, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    int i48 = i47;
                    String str2 = str;
                    boolean z23 = z21222222;
                    boolean z24 = z22222222;
                    VisualTransformation visualTransformation5222222 = visualTransformation4222222;
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5222222;
                    boolean z25 = z20222222;
                    Function2<Composer, Integer, Unit> function221 = function210;
                    Function2<Composer, Integer, Unit> function222 = function216222222;
                    Function2<Composer, Integer, Unit> function223 = function217222222;
                    Function2<Composer, Integer, Unit> function224 = function218222222;
                    TextFieldColors textFieldColors5 = textFieldColors4222222;
                    final boolean z26 = z21222222;
                    final boolean z27 = z20222222;
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5222222;
                    final TextFieldColors textFieldColors6 = textFieldColors4222222;
                    final Shape shape6 = shape5222222;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(str2, function220, z23, z24, visualTransformation5222222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                            invoke(composer6, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer6, int i49) {
                            ComposerKt.sourceInformation(composer6, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                            if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1823843281, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                }
                                TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer6.skipToGroupEnd();
                        }
                    }), composer5, (i48 << 3) & 112, 27648, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }), composer4222222, (i44222222 & 64638) | (i45222222 & 3670016) | (i45222222 & 29360128) | (234881024 & i45222222) | (i45222222 & 1879048192), ((i35 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i35 & 112) | ((i35 >> 12) & 7168), 4096);
        composer3 = composer4222222;
        if (ComposerKt.isTraceInProgress()) {
        }
        VisualTransformation visualTransformation5222222 = visualTransformation2;
        z11 = z10;
        visualTransformation3 = visualTransformation5222222;
        textFieldColors3 = textFieldColors4222222;
        z12 = z7;
        z13 = z19222222;
        i36 = i32;
        mutableInteractionSource4 = mutableInteractionSource3;
        modifier4 = modifier5222222;
        textStyle5 = textStyle6222222;
        function211 = function219222222;
        function212 = function27;
        function213 = function28;
        shape4 = shape5222222;
        keyboardOptions3 = keyboardOptions4222222;
        i37 = i33;
        function214 = function29;
        keyboardActions3 = keyboardActions2;
        z14 = z20222222;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c7  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void OutlinedTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        int i27;
        TextStyle textStyle3;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
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
        KeyboardActions keyboardActions2;
        boolean z10;
        int i29;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        int i30;
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
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i31;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)232@11423L7,243@11983L39,244@12057L6,245@12119L25,247@12153L416:OutlinedTextField.kt#jmzs0o");
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
                                int i33 = i32;
                                if ((i3 & 896) == 0) {
                                    i33 |= startRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i21 = i33;
                            }
                            i22 = i4 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i34 = i21;
                                if ((i3 & 7168) == 0) {
                                    i23 = i34 | (startRestartGroup.changed(keyboardActions) ? 2048 : 1024);
                                } else {
                                    i23 = i34;
                                }
                            }
                            i24 = i4 & 16384;
                            if (i24 == 0) {
                                i23 |= 24576;
                            } else if ((i3 & 57344) == 0) {
                                i25 = i23 | (startRestartGroup.changed(z4) ? 16384 : 8192);
                                i26 = i4 & 32768;
                                if (i26 != 0) {
                                    i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i3 & 458752) == 0) {
                                    i25 |= startRestartGroup.changed(i) ? 131072 : 65536;
                                }
                                i27 = i4 & 65536;
                                if (i27 != 0) {
                                    i25 |= 1572864;
                                } else if ((i3 & 3670016) == 0) {
                                    i25 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                }
                                if ((i3 & 29360128) == 0) {
                                    i25 |= ((i4 & 131072) == 0 && startRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                }
                                if ((i3 & 234881024) == 0) {
                                    i25 |= ((i4 & 262144) == 0 && startRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                }
                                if ((i5 & 1533916891) == 306783378 || (i25 & 191739611) != 38347922 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z15 = i7 != 0 ? true : z5;
                                        boolean z16 = i8 != 0 ? false : z6;
                                        if ((i4 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i5 &= -458753;
                                            textStyle3 = (TextStyle) consume;
                                        } else {
                                            textStyle3 = textStyle2;
                                        }
                                        int i35 = i5;
                                        Function2 function214 = i9 != 0 ? null : function25;
                                        Function2 function215 = i10 != 0 ? null : function26;
                                        Function2 function216 = i12 != 0 ? null : function23;
                                        Function2 function217 = i14 != 0 ? null : function24;
                                        boolean z17 = i16 != 0 ? false : z3;
                                        VisualTransformation none = i19 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i20 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i22 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z18 = i24 != 0 ? false : z4;
                                        int i36 = i26 != 0 ? Integer.MAX_VALUE : i;
                                        if (i27 != 0) {
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
                                        if ((i4 & 131072) != 0) {
                                            i25 &= -29360129;
                                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                                        } else {
                                            shape2 = shape;
                                        }
                                        int i37 = i25;
                                        if ((262144 & i4) != 0) {
                                            composer2 = startRestartGroup;
                                            modifier3 = companion;
                                            z7 = z15;
                                            textFieldColors2 = TextFieldDefaults.INSTANCE.m1825outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
                                            i30 = i37 & (-234881025);
                                            z8 = z16;
                                            textStyle2 = textStyle3;
                                            i28 = i35;
                                            function25 = function214;
                                            function27 = function215;
                                            function28 = function216;
                                            function29 = function217;
                                            z9 = z17;
                                            visualTransformation2 = none;
                                            keyboardOptions2 = keyboardOptions4;
                                            keyboardActions2 = keyboardActions4;
                                            z10 = z18;
                                            i29 = i36;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            shape3 = shape2;
                                        } else {
                                            composer2 = startRestartGroup;
                                            textFieldColors2 = textFieldColors;
                                            modifier3 = companion;
                                            z7 = z15;
                                            z8 = z16;
                                            textStyle2 = textStyle3;
                                            i28 = i35;
                                            function25 = function214;
                                            function27 = function215;
                                            function28 = function216;
                                            function29 = function217;
                                            z9 = z17;
                                            visualTransformation2 = none;
                                            keyboardOptions2 = keyboardOptions4;
                                            keyboardActions2 = keyboardActions4;
                                            z10 = z18;
                                            i29 = i36;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            shape3 = shape2;
                                            i30 = i37;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & 32) != 0) {
                                            i5 &= -458753;
                                        }
                                        if ((i4 & 131072) != 0) {
                                            i25 &= -29360129;
                                        }
                                        if ((262144 & i4) != 0) {
                                            i25 &= -234881025;
                                        }
                                        function28 = function23;
                                        visualTransformation2 = visualTransformation;
                                        keyboardActions2 = keyboardActions;
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
                                        i30 = i25;
                                        function29 = function24;
                                        z9 = z3;
                                        keyboardOptions2 = keyboardOptions;
                                        z7 = z5;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2099955827, i28, i30, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:246)");
                                    }
                                    int i38 = i28 & 2147483646;
                                    int i39 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
                                    int i40 = i30 << 3;
                                    OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i38, i39 | (29360128 & i40) | (234881024 & i40) | (i40 & 1879048192), 0);
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
                                    keyboardActions3 = keyboardActions2;
                                    z14 = z10;
                                    i31 = i29;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    shape4 = shape3;
                                    textFieldColors3 = textFieldColors2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z13 = z3;
                                    visualTransformation3 = visualTransformation;
                                    z14 = z4;
                                    i31 = i;
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
                                    keyboardActions3 = keyboardActions;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$6
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

                                        public final void invoke(Composer composer3, int i41) {
                                            OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier4, z11, z12, textStyle4, function210, function211, function212, function213, z13, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i31, mutableInteractionSource4, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i25 = i23;
                            i26 = i4 & 32768;
                            if (i26 != 0) {
                            }
                            i27 = i4 & 65536;
                            if (i27 != 0) {
                            }
                            if ((i3 & 29360128) == 0) {
                            }
                            if ((i3 & 234881024) == 0) {
                            }
                            if ((i5 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if ((i4 & 32) != 0) {
                            }
                            int i352 = i5;
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i27 != 0) {
                            }
                            if ((i4 & 131072) != 0) {
                            }
                            int i372 = i25;
                            if ((262144 & i4) != 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i382 = i28 & 2147483646;
                            int i392 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
                            int i402 = i30 << 3;
                            OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i382, i392 | (29360128 & i402) | (234881024 & i402) | (i402 & 1879048192), 0);
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
                            keyboardActions3 = keyboardActions2;
                            z14 = z10;
                            i31 = i29;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
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
                        i22 = i4 & 8192;
                        if (i22 == 0) {
                        }
                        i24 = i4 & 16384;
                        if (i24 == 0) {
                        }
                        i25 = i23;
                        i26 = i4 & 32768;
                        if (i26 != 0) {
                        }
                        i27 = i4 & 65536;
                        if (i27 != 0) {
                        }
                        if ((i3 & 29360128) == 0) {
                        }
                        if ((i3 & 234881024) == 0) {
                        }
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if ((i4 & 32) != 0) {
                        }
                        int i3522 = i5;
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i27 != 0) {
                        }
                        if ((i4 & 131072) != 0) {
                        }
                        int i3722 = i25;
                        if ((262144 & i4) != 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i3822 = i28 & 2147483646;
                        int i3922 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
                        int i4022 = i30 << 3;
                        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3822, i3922 | (29360128 & i4022) | (234881024 & i4022) | (i4022 & 1879048192), 0);
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
                        keyboardActions3 = keyboardActions2;
                        z14 = z10;
                        i31 = i29;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
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
                    i22 = i4 & 8192;
                    if (i22 == 0) {
                    }
                    i24 = i4 & 16384;
                    if (i24 == 0) {
                    }
                    i25 = i23;
                    i26 = i4 & 32768;
                    if (i26 != 0) {
                    }
                    i27 = i4 & 65536;
                    if (i27 != 0) {
                    }
                    if ((i3 & 29360128) == 0) {
                    }
                    if ((i3 & 234881024) == 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i4 & 32) != 0) {
                    }
                    int i35222 = i5;
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if ((i4 & 131072) != 0) {
                    }
                    int i37222 = i25;
                    if ((262144 & i4) != 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i38222 = i28 & 2147483646;
                    int i39222 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
                    int i40222 = i30 << 3;
                    OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i38222, i39222 | (29360128 & i40222) | (234881024 & i40222) | (i40222 & 1879048192), 0);
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
                    keyboardActions3 = keyboardActions2;
                    z14 = z10;
                    i31 = i29;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
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
                i22 = i4 & 8192;
                if (i22 == 0) {
                }
                i24 = i4 & 16384;
                if (i24 == 0) {
                }
                i25 = i23;
                i26 = i4 & 32768;
                if (i26 != 0) {
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                }
                if ((i3 & 29360128) == 0) {
                }
                if ((i3 & 234881024) == 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i4 & 32) != 0) {
                }
                int i352222 = i5;
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if ((i4 & 131072) != 0) {
                }
                int i372222 = i25;
                if ((262144 & i4) != 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i382222 = i28 & 2147483646;
                int i392222 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
                int i402222 = i30 << 3;
                OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i382222, i392222 | (29360128 & i402222) | (234881024 & i402222) | (i402222 & 1879048192), 0);
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
                keyboardActions3 = keyboardActions2;
                z14 = z10;
                i31 = i29;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 8;
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
            i22 = i4 & 8192;
            if (i22 == 0) {
            }
            i24 = i4 & 16384;
            if (i24 == 0) {
            }
            i25 = i23;
            i26 = i4 & 32768;
            if (i26 != 0) {
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
            }
            if ((i3 & 29360128) == 0) {
            }
            if ((i3 & 234881024) == 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i4 & 32) != 0) {
            }
            int i3522222 = i5;
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if ((i4 & 131072) != 0) {
            }
            int i3722222 = i25;
            if ((262144 & i4) != 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3822222 = i28 & 2147483646;
            int i3922222 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
            int i4022222 = i30 << 3;
            OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3822222, i3922222 | (29360128 & i4022222) | (234881024 & i4022222) | (i4022222 & 1879048192), 0);
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
            keyboardActions3 = keyboardActions2;
            z14 = z10;
            i31 = i29;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 8;
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
        i22 = i4 & 8192;
        if (i22 == 0) {
        }
        i24 = i4 & 16384;
        if (i24 == 0) {
        }
        i25 = i23;
        i26 = i4 & 32768;
        if (i26 != 0) {
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
        }
        if ((i3 & 29360128) == 0) {
        }
        if ((i3 & 234881024) == 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i4 & 32) != 0) {
        }
        int i35222222 = i5;
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if ((i4 & 131072) != 0) {
        }
        int i37222222 = i25;
        if ((262144 & i4) != 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i38222222 = i28 & 2147483646;
        int i39222222 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (i30 & 57344) | (i30 & 458752);
        int i40222222 = i30 << 3;
        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i38222222, i39222222 | (29360128 & i40222222) | (234881024 & i40222222) | (i40222222 & 1879048192), 0);
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
        keyboardActions3 = keyboardActions2;
        z14 = z10;
        i31 = i29;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01d5, code lost:
    
        if (r3.changed(r87) == false) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0055  */
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
    public static final void OutlinedTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
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
        KeyboardOptions keyboardOptions2;
        int i27;
        KeyboardActions keyboardActions2;
        int i28;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        Composer composer2;
        TextFieldColors textFieldColors2;
        KeyboardActions keyboardActions3;
        boolean z7;
        boolean z8;
        TextStyle textStyle3;
        int i29;
        boolean z9;
        VisualTransformation visualTransformation2;
        boolean z10;
        int i30;
        int i31;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        int i32;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        long m5918getColor0d7_KjU;
        TextStyle textStyle4;
        Modifier modifier3;
        Composer composer3;
        final boolean z11;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle5;
        final TextFieldColors textFieldColors3;
        final boolean z12;
        final boolean z13;
        final int i33;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Shape shape4;
        final KeyboardOptions keyboardOptions3;
        final int i34;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final KeyboardActions keyboardActions4;
        final boolean z14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)343@17493L7,355@18093L39,356@18171L22,357@18243L25,377@19014L24,378@19097L38,387@19464L20,366@18571L2140:OutlinedTextField.kt#jmzs0o");
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
                                                boolean z15 = i8 == 0 ? true : z;
                                                boolean z16 = i9 == 0 ? false : z2;
                                                if ((i5 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i6 &= -458753;
                                                }
                                                int i39 = i6;
                                                TextStyle textStyle6 = textStyle2;
                                                Function2<? super Composer, ? super Integer, Unit> function215 = i10 == 0 ? null : function25;
                                                function27 = i11 == 0 ? null : function26;
                                                function28 = i13 == 0 ? null : function23;
                                                function29 = i15 == 0 ? null : function24;
                                                boolean z17 = i17 == 0 ? false : z3;
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
                                                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(startRestartGroup, 6);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i41 = i27;
                                                if ((i5 & 524288) == 0) {
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.m1825outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, 48, 2097151);
                                                    i32 = i41 & (-1879048193);
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle3 = textStyle6;
                                                    i29 = i39;
                                                    function25 = function215;
                                                    z9 = z17;
                                                    visualTransformation2 = none;
                                                    z10 = z18;
                                                    i30 = i28;
                                                    i31 = i40;
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    shape3 = shape2;
                                                } else {
                                                    composer2 = startRestartGroup;
                                                    textFieldColors2 = textFieldColors;
                                                    keyboardActions3 = keyboardActions2;
                                                    z7 = z15;
                                                    z8 = z16;
                                                    textStyle3 = textStyle6;
                                                    i29 = i39;
                                                    function25 = function215;
                                                    z9 = z17;
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
                                                z8 = z2;
                                                function28 = function23;
                                                function29 = function24;
                                                z9 = z3;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions3 = keyboardActions;
                                                z10 = z4;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                shape3 = shape;
                                                composer2 = startRestartGroup;
                                                i29 = i6;
                                                function27 = function26;
                                                companion = modifier2;
                                                z7 = z;
                                                i30 = i;
                                                i31 = i2;
                                                i32 = i38;
                                                textStyle3 = textStyle2;
                                                textFieldColors2 = textFieldColors;
                                            }
                                            composer2.endDefaults();
                                            boolean z19 = z8;
                                            if (ComposerKt.isTraceInProgress()) {
                                                function210 = function25;
                                            } else {
                                                function210 = function25;
                                                ComposerKt.traceEventStart(237745923, i29, i32, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:358)");
                                            }
                                            composer2.startReplaceableGroup(1961404947);
                                            ComposerKt.sourceInformation(composer2, "*361@18420L18");
                                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                m5918getColor0d7_KjU = textFieldColors2.textColor(z7, composer2, ((i29 >> 9) & 14) | ((i32 >> 24) & 112)).getValue().m4073unboximpl();
                                            }
                                            composer2.endReplaceableGroup();
                                            TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                            if (function210 == null) {
                                                textStyle4 = textStyle3;
                                                modifier3 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$8
                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        invoke2(semanticsPropertyReceiver);
                                                        return Unit.INSTANCE;
                                                    }
                                                }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null);
                                            } else {
                                                textStyle4 = textStyle3;
                                                modifier3 = companion;
                                            }
                                            int i42 = (i32 >> 24) & 112;
                                            Modifier modifier5 = companion;
                                            int i43 = i32;
                                            final boolean z20 = z9;
                                            final Shape shape5 = shape3;
                                            final boolean z21 = z7;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final boolean z22 = z10;
                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                            final Function2<? super Composer, ? super Integer, Unit> function216 = function27;
                                            final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                            Function2<? super Composer, ? super Integer, Unit> function219 = function210;
                                            int i44 = i43 << 12;
                                            int i45 = ((i43 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i43 & 112) | ((i43 >> 12) & 7168);
                                            Composer composer4 = composer2;
                                            KeyboardOptions keyboardOptions4 = keyboardOptions2;
                                            BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i42).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19, merge, keyboardOptions4, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i42).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                                    int i47;
                                                    ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                                                    if ((i46 & 14) == 0) {
                                                        i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                                    } else {
                                                        i47 = i46;
                                                    }
                                                    if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                                                        }
                                                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                        String text = TextFieldValue.this.getText();
                                                        boolean z23 = z21;
                                                        int i48 = i47;
                                                        boolean z24 = z22;
                                                        VisualTransformation visualTransformation5 = visualTransformation4;
                                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                                        boolean z25 = z20;
                                                        Function2<Composer, Integer, Unit> function221 = function210;
                                                        Function2<Composer, Integer, Unit> function222 = function216;
                                                        Function2<Composer, Integer, Unit> function223 = function217;
                                                        Function2<Composer, Integer, Unit> function224 = function218;
                                                        TextFieldColors textFieldColors5 = textFieldColors4;
                                                        final boolean z26 = z21;
                                                        final boolean z27 = z20;
                                                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                                        final TextFieldColors textFieldColors6 = textFieldColors4;
                                                        final Shape shape6 = shape5;
                                                        textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation5, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                invoke(composer6, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer6, int i49) {
                                                                ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                                                if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                                                    }
                                                                    TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer6.skipToGroupEnd();
                                                            }
                                                        }), composer5, (i48 << 3) & 112, 27648, 4096);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, (i29 & 64638) | (i44 & 3670016) | (i44 & 29360128) | (234881024 & i44) | (i44 & 1879048192), i45, 4096);
                                            composer3 = composer4;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            VisualTransformation visualTransformation5 = visualTransformation2;
                                            z11 = z10;
                                            visualTransformation3 = visualTransformation5;
                                            textStyle5 = textStyle4;
                                            textFieldColors3 = textFieldColors4;
                                            z12 = z7;
                                            z13 = z19;
                                            i33 = i30;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            modifier4 = modifier5;
                                            function211 = function219;
                                            function212 = function27;
                                            function213 = function28;
                                            shape4 = shape5;
                                            keyboardOptions3 = keyboardOptions4;
                                            i34 = i31;
                                            function214 = function29;
                                            keyboardActions4 = keyboardActions3;
                                            z14 = z20;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            z14 = z3;
                                            visualTransformation3 = visualTransformation;
                                            z11 = z4;
                                            i33 = i;
                                            i34 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer3 = startRestartGroup;
                                            z12 = z5;
                                            z13 = z6;
                                            textStyle5 = textStyle2;
                                            function211 = function25;
                                            function212 = function26;
                                            modifier4 = modifier2;
                                            function213 = function23;
                                            function214 = function24;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions4 = keyboardActions;
                                        }
                                        endRestartGroup = composer3.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$10
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

                                                public final void invoke(Composer composer5, int i46) {
                                                    OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, function1, modifier4, z12, z13, textStyle5, function211, function212, function213, function214, z14, visualTransformation3, keyboardOptions3, keyboardActions4, z11, i33, i34, mutableInteractionSource4, shape4, textFieldColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
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
                                    TextStyle textStyle62 = textStyle2;
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
                                    boolean z192 = z8;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composer2.startReplaceableGroup(1961404947);
                                    ComposerKt.sourceInformation(composer2, "*361@18420L18");
                                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                    }
                                    composer2.endReplaceableGroup();
                                    TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    if (function210 == null) {
                                    }
                                    int i422 = (i32 >> 24) & 112;
                                    Modifier modifier52 = companion;
                                    int i432 = i32;
                                    final boolean z202 = z9;
                                    final Shape shape52 = shape3;
                                    final boolean z212 = z7;
                                    final TextFieldColors textFieldColors42 = textFieldColors2;
                                    final boolean z222 = z10;
                                    final VisualTransformation visualTransformation42 = visualTransformation2;
                                    final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function27;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                                    Function2<? super Composer, ? super Integer, Unit> function2192 = function210;
                                    int i442 = i432 << 12;
                                    int i452 = ((i432 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i432 & 112) | ((i432 >> 12) & 7168);
                                    Composer composer42 = composer2;
                                    KeyboardOptions keyboardOptions42 = keyboardOptions2;
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i422).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z192, merge2, keyboardOptions42, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i422).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                            int i47;
                                            ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                                            if ((i46 & 14) == 0) {
                                                i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                            } else {
                                                i47 = i46;
                                            }
                                            if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                                                }
                                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                String text = TextFieldValue.this.getText();
                                                boolean z23 = z212;
                                                int i48 = i47;
                                                boolean z24 = z222;
                                                VisualTransformation visualTransformation52 = visualTransformation42;
                                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52;
                                                boolean z25 = z202;
                                                Function2<Composer, Integer, Unit> function221 = function210;
                                                Function2<Composer, Integer, Unit> function222 = function2162;
                                                Function2<Composer, Integer, Unit> function223 = function2172;
                                                Function2<Composer, Integer, Unit> function224 = function2182;
                                                TextFieldColors textFieldColors5 = textFieldColors42;
                                                final boolean z26 = z212;
                                                final boolean z27 = z202;
                                                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource52;
                                                final TextFieldColors textFieldColors6 = textFieldColors42;
                                                final Shape shape6 = shape52;
                                                textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation52, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                        invoke(composer6, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer6, int i49) {
                                                        ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                                        if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                                            }
                                                            TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer6.skipToGroupEnd();
                                                    }
                                                }), composer5, (i48 << 3) & 112, 27648, 4096);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer42, (i29 & 64638) | (i442 & 3670016) | (i442 & 29360128) | (234881024 & i442) | (i442 & 1879048192), i452, 4096);
                                    composer3 = composer42;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    VisualTransformation visualTransformation52 = visualTransformation2;
                                    z11 = z10;
                                    visualTransformation3 = visualTransformation52;
                                    textStyle5 = textStyle4;
                                    textFieldColors3 = textFieldColors42;
                                    z12 = z7;
                                    z13 = z192;
                                    i33 = i30;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    modifier4 = modifier52;
                                    function211 = function2192;
                                    function212 = function27;
                                    function213 = function28;
                                    shape4 = shape52;
                                    keyboardOptions3 = keyboardOptions42;
                                    i34 = i31;
                                    function214 = function29;
                                    keyboardActions4 = keyboardActions3;
                                    z14 = z202;
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
                            TextStyle textStyle622 = textStyle2;
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
                            boolean z1922 = z8;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceableGroup(1961404947);
                            ComposerKt.sourceInformation(composer2, "*361@18420L18");
                            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                            }
                            composer2.endReplaceableGroup();
                            TextStyle merge22 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            if (function210 == null) {
                            }
                            int i4222 = (i32 >> 24) & 112;
                            Modifier modifier522 = companion;
                            int i4322 = i32;
                            final boolean z2022 = z9;
                            final Shape shape522 = shape3;
                            final boolean z2122 = z7;
                            final TextFieldColors textFieldColors422 = textFieldColors2;
                            final boolean z2222 = z10;
                            final VisualTransformation visualTransformation422 = visualTransformation2;
                            final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                            final Function2<? super Composer, ? super Integer, Unit> function21622 = function27;
                            final Function2<? super Composer, ? super Integer, Unit> function21722 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            Function2<? super Composer, ? super Integer, Unit> function21922 = function210;
                            int i4422 = i4322 << 12;
                            int i4522 = ((i4322 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i4322 & 112) | ((i4322 >> 12) & 7168);
                            Composer composer422 = composer2;
                            KeyboardOptions keyboardOptions422 = keyboardOptions2;
                            BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i4222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z1922, merge22, keyboardOptions422, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i4222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                    int i47;
                                    ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                                    if ((i46 & 14) == 0) {
                                        i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                    } else {
                                        i47 = i46;
                                    }
                                    if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                                        }
                                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                        String text = TextFieldValue.this.getText();
                                        boolean z23 = z2122;
                                        int i48 = i47;
                                        boolean z24 = z2222;
                                        VisualTransformation visualTransformation522 = visualTransformation422;
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522;
                                        boolean z25 = z2022;
                                        Function2<Composer, Integer, Unit> function221 = function210;
                                        Function2<Composer, Integer, Unit> function222 = function21622;
                                        Function2<Composer, Integer, Unit> function223 = function21722;
                                        Function2<Composer, Integer, Unit> function224 = function21822;
                                        TextFieldColors textFieldColors5 = textFieldColors422;
                                        final boolean z26 = z2122;
                                        final boolean z27 = z2022;
                                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource522;
                                        final TextFieldColors textFieldColors6 = textFieldColors422;
                                        final Shape shape6 = shape522;
                                        textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation522, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i49) {
                                                ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                                if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer6.skipToGroupEnd();
                                            }
                                        }), composer5, (i48 << 3) & 112, 27648, 4096);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer422, (i29 & 64638) | (i4422 & 3670016) | (i4422 & 29360128) | (234881024 & i4422) | (i4422 & 1879048192), i4522, 4096);
                            composer3 = composer422;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            VisualTransformation visualTransformation522 = visualTransformation2;
                            z11 = z10;
                            visualTransformation3 = visualTransformation522;
                            textStyle5 = textStyle4;
                            textFieldColors3 = textFieldColors422;
                            z12 = z7;
                            z13 = z1922;
                            i33 = i30;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier522;
                            function211 = function21922;
                            function212 = function27;
                            function213 = function28;
                            shape4 = shape522;
                            keyboardOptions3 = keyboardOptions422;
                            i34 = i31;
                            function214 = function29;
                            keyboardActions4 = keyboardActions3;
                            z14 = z2022;
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
                        TextStyle textStyle6222 = textStyle2;
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
                        boolean z19222 = z8;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2.startReplaceableGroup(1961404947);
                        ComposerKt.sourceInformation(composer2, "*361@18420L18");
                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        }
                        composer2.endReplaceableGroup();
                        TextStyle merge222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                        if (function210 == null) {
                        }
                        int i42222 = (i32 >> 24) & 112;
                        Modifier modifier5222 = companion;
                        int i43222 = i32;
                        final boolean z20222 = z9;
                        final Shape shape5222 = shape3;
                        final boolean z21222 = z7;
                        final TextFieldColors textFieldColors4222 = textFieldColors2;
                        final boolean z22222 = z10;
                        final VisualTransformation visualTransformation4222 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                        final Function2<? super Composer, ? super Integer, Unit> function216222 = function27;
                        final Function2<? super Composer, ? super Integer, Unit> function217222 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                        Function2<? super Composer, ? super Integer, Unit> function219222 = function210;
                        int i44222 = i43222 << 12;
                        int i45222 = ((i43222 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i43222 & 112) | ((i43222 >> 12) & 7168);
                        Composer composer4222 = composer2;
                        KeyboardOptions keyboardOptions4222 = keyboardOptions2;
                        BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i42222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19222, merge222, keyboardOptions4222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i42222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                                int i47;
                                ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                                if ((i46 & 14) == 0) {
                                    i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                                } else {
                                    i47 = i46;
                                }
                                if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                                    }
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    String text = TextFieldValue.this.getText();
                                    boolean z23 = z21222;
                                    int i48 = i47;
                                    boolean z24 = z22222;
                                    VisualTransformation visualTransformation5222 = visualTransformation4222;
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5222;
                                    boolean z25 = z20222;
                                    Function2<Composer, Integer, Unit> function221 = function210;
                                    Function2<Composer, Integer, Unit> function222 = function216222;
                                    Function2<Composer, Integer, Unit> function223 = function217222;
                                    Function2<Composer, Integer, Unit> function224 = function218222;
                                    TextFieldColors textFieldColors5 = textFieldColors4222;
                                    final boolean z26 = z21222;
                                    final boolean z27 = z20222;
                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5222;
                                    final TextFieldColors textFieldColors6 = textFieldColors4222;
                                    final Shape shape6 = shape5222;
                                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation5222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i49) {
                                            ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                            if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                                }
                                                TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer6.skipToGroupEnd();
                                        }
                                    }), composer5, (i48 << 3) & 112, 27648, 4096);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4222, (i29 & 64638) | (i44222 & 3670016) | (i44222 & 29360128) | (234881024 & i44222) | (i44222 & 1879048192), i45222, 4096);
                        composer3 = composer4222;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        VisualTransformation visualTransformation5222 = visualTransformation2;
                        z11 = z10;
                        visualTransformation3 = visualTransformation5222;
                        textStyle5 = textStyle4;
                        textFieldColors3 = textFieldColors4222;
                        z12 = z7;
                        z13 = z19222;
                        i33 = i30;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        modifier4 = modifier5222;
                        function211 = function219222;
                        function212 = function27;
                        function213 = function28;
                        shape4 = shape5222;
                        keyboardOptions3 = keyboardOptions4222;
                        i34 = i31;
                        function214 = function29;
                        keyboardActions4 = keyboardActions3;
                        z14 = z20222;
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
                    TextStyle textStyle62222 = textStyle2;
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
                    boolean z192222 = z8;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2.startReplaceableGroup(1961404947);
                    ComposerKt.sourceInformation(composer2, "*361@18420L18");
                    m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                    if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    composer2.endReplaceableGroup();
                    TextStyle merge2222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                    if (function210 == null) {
                    }
                    int i422222 = (i32 >> 24) & 112;
                    Modifier modifier52222 = companion;
                    int i432222 = i32;
                    final boolean z202222 = z9;
                    final Shape shape52222 = shape3;
                    final boolean z212222 = z7;
                    final TextFieldColors textFieldColors42222 = textFieldColors2;
                    final boolean z222222 = z10;
                    final VisualTransformation visualTransformation42222 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                    final Function2<? super Composer, ? super Integer, Unit> function2162222 = function27;
                    final Function2<? super Composer, ? super Integer, Unit> function2172222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                    Function2<? super Composer, ? super Integer, Unit> function2192222 = function210;
                    int i442222 = i432222 << 12;
                    int i452222 = ((i432222 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i432222 & 112) | ((i432222 >> 12) & 7168);
                    Composer composer42222 = composer2;
                    KeyboardOptions keyboardOptions42222 = keyboardOptions2;
                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i422222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z192222, merge2222, keyboardOptions42222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i422222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                            int i47;
                            ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                            if ((i46 & 14) == 0) {
                                i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                            } else {
                                i47 = i46;
                            }
                            if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                                }
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                String text = TextFieldValue.this.getText();
                                boolean z23 = z212222;
                                int i48 = i47;
                                boolean z24 = z222222;
                                VisualTransformation visualTransformation52222 = visualTransformation42222;
                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52222;
                                boolean z25 = z202222;
                                Function2<Composer, Integer, Unit> function221 = function210;
                                Function2<Composer, Integer, Unit> function222 = function2162222;
                                Function2<Composer, Integer, Unit> function223 = function2172222;
                                Function2<Composer, Integer, Unit> function224 = function2182222;
                                TextFieldColors textFieldColors5 = textFieldColors42222;
                                final boolean z26 = z212222;
                                final boolean z27 = z202222;
                                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource52222;
                                final TextFieldColors textFieldColors6 = textFieldColors42222;
                                final Shape shape6 = shape52222;
                                textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation52222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                        invoke(composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer6, int i49) {
                                        ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                        if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                            }
                                            TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer6.skipToGroupEnd();
                                    }
                                }), composer5, (i48 << 3) & 112, 27648, 4096);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer42222, (i29 & 64638) | (i442222 & 3670016) | (i442222 & 29360128) | (234881024 & i442222) | (i442222 & 1879048192), i452222, 4096);
                    composer3 = composer42222;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    VisualTransformation visualTransformation52222 = visualTransformation2;
                    z11 = z10;
                    visualTransformation3 = visualTransformation52222;
                    textStyle5 = textStyle4;
                    textFieldColors3 = textFieldColors42222;
                    z12 = z7;
                    z13 = z192222;
                    i33 = i30;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier4 = modifier52222;
                    function211 = function2192222;
                    function212 = function27;
                    function213 = function28;
                    shape4 = shape52222;
                    keyboardOptions3 = keyboardOptions42222;
                    i34 = i31;
                    function214 = function29;
                    keyboardActions4 = keyboardActions3;
                    z14 = z202222;
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
                TextStyle textStyle622222 = textStyle2;
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
                boolean z1922222 = z8;
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2.startReplaceableGroup(1961404947);
                ComposerKt.sourceInformation(composer2, "*361@18420L18");
                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                composer2.endReplaceableGroup();
                TextStyle merge22222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                if (function210 == null) {
                }
                int i4222222 = (i32 >> 24) & 112;
                Modifier modifier522222 = companion;
                int i4322222 = i32;
                final boolean z2022222 = z9;
                final Shape shape522222 = shape3;
                final boolean z2122222 = z7;
                final TextFieldColors textFieldColors422222 = textFieldColors2;
                final boolean z2222222 = z10;
                final VisualTransformation visualTransformation422222 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function21622222 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function21722222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
                Function2<? super Composer, ? super Integer, Unit> function21922222 = function210;
                int i4422222 = i4322222 << 12;
                int i4522222 = ((i4322222 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i4322222 & 112) | ((i4322222 >> 12) & 7168);
                Composer composer422222 = composer2;
                KeyboardOptions keyboardOptions422222 = keyboardOptions2;
                BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i4222222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z1922222, merge22222, keyboardOptions422222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i4222222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                        int i47;
                        ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                        if ((i46 & 14) == 0) {
                            i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                        } else {
                            i47 = i46;
                        }
                        if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                            }
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String text = TextFieldValue.this.getText();
                            boolean z23 = z2122222;
                            int i48 = i47;
                            boolean z24 = z2222222;
                            VisualTransformation visualTransformation522222 = visualTransformation422222;
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522222;
                            boolean z25 = z2022222;
                            Function2<Composer, Integer, Unit> function221 = function210;
                            Function2<Composer, Integer, Unit> function222 = function21622222;
                            Function2<Composer, Integer, Unit> function223 = function21722222;
                            Function2<Composer, Integer, Unit> function224 = function21822222;
                            TextFieldColors textFieldColors5 = textFieldColors422222;
                            final boolean z26 = z2122222;
                            final boolean z27 = z2022222;
                            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource522222;
                            final TextFieldColors textFieldColors6 = textFieldColors422222;
                            final Shape shape6 = shape522222;
                            textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation522222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                    invoke(composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer6, int i49) {
                                    ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                    if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                        }
                                        TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer6.skipToGroupEnd();
                                }
                            }), composer5, (i48 << 3) & 112, 27648, 4096);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }), composer422222, (i29 & 64638) | (i4422222 & 3670016) | (i4422222 & 29360128) | (234881024 & i4422222) | (i4422222 & 1879048192), i4522222, 4096);
                composer3 = composer422222;
                if (ComposerKt.isTraceInProgress()) {
                }
                VisualTransformation visualTransformation522222 = visualTransformation2;
                z11 = z10;
                visualTransformation3 = visualTransformation522222;
                textStyle5 = textStyle4;
                textFieldColors3 = textFieldColors422222;
                z12 = z7;
                z13 = z1922222;
                i33 = i30;
                mutableInteractionSource4 = mutableInteractionSource3;
                modifier4 = modifier522222;
                function211 = function21922222;
                function212 = function27;
                function213 = function28;
                shape4 = shape522222;
                keyboardOptions3 = keyboardOptions422222;
                i34 = i31;
                function214 = function29;
                keyboardActions4 = keyboardActions3;
                z14 = z2022222;
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
            TextStyle textStyle6222222 = textStyle2;
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
            boolean z19222222 = z8;
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2.startReplaceableGroup(1961404947);
            ComposerKt.sourceInformation(composer2, "*361@18420L18");
            m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
            if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            composer2.endReplaceableGroup();
            TextStyle merge222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            if (function210 == null) {
            }
            int i42222222 = (i32 >> 24) & 112;
            Modifier modifier5222222 = companion;
            int i43222222 = i32;
            final boolean z20222222 = z9;
            final Shape shape5222222 = shape3;
            final boolean z21222222 = z7;
            final TextFieldColors textFieldColors4222222 = textFieldColors2;
            final boolean z22222222 = z10;
            final VisualTransformation visualTransformation4222222 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
            final Function2<? super Composer, ? super Integer, Unit> function216222222 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function217222222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
            Function2<? super Composer, ? super Integer, Unit> function219222222 = function210;
            int i44222222 = i43222222 << 12;
            int i45222222 = ((i43222222 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i43222222 & 112) | ((i43222222 >> 12) & 7168);
            Composer composer4222222 = composer2;
            KeyboardOptions keyboardOptions4222222 = keyboardOptions2;
            BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i42222222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z19222222, merge222222, keyboardOptions4222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i42222222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                    int i47;
                    ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                    if ((i46 & 14) == 0) {
                        i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                    } else {
                        i47 = i46;
                    }
                    if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = TextFieldValue.this.getText();
                        boolean z23 = z21222222;
                        int i48 = i47;
                        boolean z24 = z22222222;
                        VisualTransformation visualTransformation5222222 = visualTransformation4222222;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5222222;
                        boolean z25 = z20222222;
                        Function2<Composer, Integer, Unit> function221 = function210;
                        Function2<Composer, Integer, Unit> function222 = function216222222;
                        Function2<Composer, Integer, Unit> function223 = function217222222;
                        Function2<Composer, Integer, Unit> function224 = function218222222;
                        TextFieldColors textFieldColors5 = textFieldColors4222222;
                        final boolean z26 = z21222222;
                        final boolean z27 = z20222222;
                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5222222;
                        final TextFieldColors textFieldColors6 = textFieldColors4222222;
                        final Shape shape6 = shape5222222;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation5222222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                invoke(composer6, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer6, int i49) {
                                ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                                if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer6.skipToGroupEnd();
                            }
                        }), composer5, (i48 << 3) & 112, 27648, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }), composer4222222, (i29 & 64638) | (i44222222 & 3670016) | (i44222222 & 29360128) | (234881024 & i44222222) | (i44222222 & 1879048192), i45222222, 4096);
            composer3 = composer4222222;
            if (ComposerKt.isTraceInProgress()) {
            }
            VisualTransformation visualTransformation5222222 = visualTransformation2;
            z11 = z10;
            visualTransformation3 = visualTransformation5222222;
            textStyle5 = textStyle4;
            textFieldColors3 = textFieldColors4222222;
            z12 = z7;
            z13 = z19222222;
            i33 = i30;
            mutableInteractionSource4 = mutableInteractionSource3;
            modifier4 = modifier5222222;
            function211 = function219222222;
            function212 = function27;
            function213 = function28;
            shape4 = shape5222222;
            keyboardOptions3 = keyboardOptions4222222;
            i34 = i31;
            function214 = function29;
            keyboardActions4 = keyboardActions3;
            z14 = z20222222;
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
        TextStyle textStyle62222222 = textStyle2;
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
        boolean z192222222 = z8;
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.startReplaceableGroup(1961404947);
        ComposerKt.sourceInformation(composer2, "*361@18420L18");
        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        composer2.endReplaceableGroup();
        TextStyle merge2222222 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        if (function210 == null) {
        }
        int i422222222 = (i32 >> 24) & 112;
        Modifier modifier52222222 = companion;
        int i432222222 = i32;
        final boolean z202222222 = z9;
        final Shape shape52222222 = shape3;
        final boolean z212222222 = z7;
        final TextFieldColors textFieldColors42222222 = textFieldColors2;
        final boolean z222222222 = z10;
        final VisualTransformation visualTransformation42222222 = visualTransformation2;
        final MutableInteractionSource mutableInteractionSource52222222 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2162222222 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function2172222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2182222222 = function29;
        Function2<? super Composer, ? super Integer, Unit> function2192222222 = function210;
        int i442222222 = i432222222 << 12;
        int i452222222 = ((i432222222 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i432222222 & 112) | ((i432222222 >> 12) & 7168);
        Composer composer42222222 = composer2;
        KeyboardOptions keyboardOptions42222222 = keyboardOptions2;
        BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m526backgroundbw27NRU(modifier3, textFieldColors2.backgroundColor(z7, composer2, ((i29 >> 9) & 14) | i422222222).getValue().m4073unboximpl(), shape3), z9, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1775getDefaultErrorMessageUdPEhr4(), composer2, 6)), TextFieldDefaults.INSTANCE.m1822getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1821getMinHeightD9Ej5fM()), z7, z192222222, merge2222222, keyboardOptions42222222, keyboardActions3, z10, i30, i31, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, new SolidColor(textFieldColors2.cursorColor(z9, composer2, (i32 & 14) | i422222222).getValue().m4073unboximpl(), null), ComposableLambdaKt.composableLambda(composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function220, Composer composer5, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function220, composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function220, Composer composer5, int i46) {
                int i47;
                ComposerKt.sourceInformation(composer5, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                if ((i46 & 14) == 0) {
                    i47 = i46 | (composer5.changedInstance(function220) ? 4 : 2);
                } else {
                    i47 = i46;
                }
                if ((i47 & 91) != 18 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1001528775, i47, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = TextFieldValue.this.getText();
                    boolean z23 = z212222222;
                    int i48 = i47;
                    boolean z24 = z222222222;
                    VisualTransformation visualTransformation52222222 = visualTransformation42222222;
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52222222;
                    boolean z25 = z202222222;
                    Function2<Composer, Integer, Unit> function221 = function210;
                    Function2<Composer, Integer, Unit> function222 = function2162222222;
                    Function2<Composer, Integer, Unit> function223 = function2172222222;
                    Function2<Composer, Integer, Unit> function224 = function2182222222;
                    TextFieldColors textFieldColors5 = textFieldColors42222222;
                    final boolean z26 = z212222222;
                    final boolean z27 = z202222222;
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource52222222;
                    final TextFieldColors textFieldColors6 = textFieldColors42222222;
                    final Shape shape6 = shape52222222;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, function220, z23, z24, visualTransformation52222222, mutableInteractionSource6, z25, function221, function222, function223, function224, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer5, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$9.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                            invoke(composer6, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer6, int i49) {
                            ComposerKt.sourceInformation(composer6, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                            if ((i49 & 11) != 2 || !composer6.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-753611134, i49, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                }
                                TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z26, z27, mutableInteractionSource7, textFieldColors6, shape6, 0.0f, 0.0f, composer6, 12582912, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer6.skipToGroupEnd();
                        }
                    }), composer5, (i48 << 3) & 112, 27648, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }), composer42222222, (i29 & 64638) | (i442222222 & 3670016) | (i442222222 & 29360128) | (234881024 & i442222222) | (i442222222 & 1879048192), i452222222, 4096);
        composer3 = composer42222222;
        if (ComposerKt.isTraceInProgress()) {
        }
        VisualTransformation visualTransformation52222222 = visualTransformation2;
        z11 = z10;
        visualTransformation3 = visualTransformation52222222;
        textStyle5 = textStyle4;
        textFieldColors3 = textFieldColors42222222;
        z12 = z7;
        z13 = z192222222;
        i33 = i30;
        mutableInteractionSource4 = mutableInteractionSource3;
        modifier4 = modifier52222222;
        function211 = function2192222222;
        function212 = function27;
        function213 = function28;
        shape4 = shape52222222;
        keyboardOptions3 = keyboardOptions42222222;
        i34 = i31;
        function214 = function29;
        keyboardActions4 = keyboardActions3;
        z14 = z202222222;
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
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
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
        Composer startRestartGroup = composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@21088L7,445@21642L39,446@21720L22,447@21792L25,449@21826L416:OutlinedTextField.kt#jmzs0o");
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
                                                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(startRestartGroup, 6);
                                                } else {
                                                    shape2 = shape;
                                                }
                                                int i36 = i27;
                                                if ((262144 & i4) == 0) {
                                                    composer2 = startRestartGroup;
                                                    keyboardActions3 = keyboardActions2;
                                                    modifier3 = companion;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.m1825outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
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
                                                ComposerKt.traceEventStart(-288998816, i28, i26, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:448)");
                                            }
                                            int i37 = i28 & 2147483646;
                                            int i38 = (i26 & 14) | 1572864 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (i26 & 57344) | (i26 & 458752);
                                            int i39 = i26 << 3;
                                            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37, i38 | (29360128 & i39) | (234881024 & i39) | (i39 & 1879048192), 0);
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
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$12
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
                                                    OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, function1, modifier4, z11, z12, textStyle4, function210, function211, function212, function213, z13, visualTransformation3, keyboardOptions3, keyboardActions4, z14, i30, mutableInteractionSource4, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
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
                                    OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372, i382 | (29360128 & i392) | (234881024 & i392) | (i392 & 1879048192), 0);
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
                            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722, i3822 | (29360128 & i3922) | (234881024 & i3922) | (i3922 & 1879048192), 0);
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
                        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222, i38222 | (29360128 & i39222) | (234881024 & i39222) | (i39222 & 1879048192), 0);
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
                    OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222, i382222 | (29360128 & i392222) | (234881024 & i392222) | (i392222 & 1879048192), 0);
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
                OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i3722222, i3822222 | (29360128 & i3922222) | (234881024 & i3922222) | (i3922222 & 1879048192), 0);
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
            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i37222222, i38222222 | (29360128 & i39222222) | (234881024 & i39222222) | (i39222222 & 1879048192), 0);
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
        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z7, z8, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function27, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function29, z9, visualTransformation2, keyboardOptions2, keyboardActions3, z10, i29, 1, mutableInteractionSource3, shape3, textFieldColors2, composer2, i372222222, i382222222 | (29360128 & i392222222) | (234881024 & i392222222) | (i392222222 & 1879048192), 0);
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

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function25, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)493@22963L239,501@23250L7,502@23262L2308:OutlinedTextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = i | (startRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i3 |= startRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 536870912 : 268435456;
        }
        int i6 = i3;
        int i7 = (i2 & 14) == 0 ? i2 | (startRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i6 & 1533916891) != 306783378 || (i7 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, i6, i7, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:492)");
            }
            Object[] objArr = {function1, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean z2 = false;
            for (int i8 = 0; i8 < 4; i8++) {
                z2 |= startRestartGroup.changed(objArr[i8]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
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
            Updater.m3600setimpl(m3593constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1169918312, "C510@23766L8,549@25214L182:OutlinedTextField.kt#jmzs0o");
            function25.invoke(startRestartGroup, Integer.valueOf((i6 >> 27) & 14));
            startRestartGroup.startReplaceableGroup(1169918334);
            ComposerKt.sourceInformation(startRestartGroup, "513@23827L219");
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
                i4 = i6;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -905297530, "C517@24019L9:OutlinedTextField.kt#jmzs0o");
                function23.invoke(startRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i4 = i6;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1169918619);
            ComposerKt.sourceInformation(startRestartGroup, "521@24113L221");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -905297243, "C525@24306L10:OutlinedTextField.kt#jmzs0o");
                function24.invoke(startRestartGroup, Integer.valueOf((i4 >> 15) & 14));
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
                i5 = 0;
                calculateStartPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(0)));
            } else {
                i5 = 0;
            }
            float f2 = calculateStartPadding;
            if (function24 != null) {
                calculateEndPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(i5)));
            }
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f2, 0.0f, calculateEndPadding, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(1169919630);
            ComposerKt.sourceInformation(startRestartGroup, "546@25127L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(m883paddingqDBjuR0$default), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(m883paddingqDBjuR0$default);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -905296178, "C553@25371L11:OutlinedTextField.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-614207693);
            ComposerKt.sourceInformation(startRestartGroup, "557@25447L54");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(layoutId);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -905296057, "C557@25492L7:OutlinedTextField.kt#jmzs0o");
                function22.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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

                public final void invoke(Composer composer2, int i9) {
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, function2, function3, function22, function23, function24, z, f, function1, function25, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1723calculateWidthO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        return Math.max(i + Math.max(i3, Math.max(MathHelpersKt.lerp(i4, 0, f), i5)) + i2, Math.max(MathKt.roundToInt((i4 + (Dp.m6389constructorimpl(paddingValues.mo830calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo831calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f), Constraints.m6347getMinWidthimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1722calculateHeightO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        int max = Math.max(i3, Math.max(i5, MathHelpersKt.lerp(i4, 0, f)));
        float top = paddingValues.getTop() * f2;
        return Math.max(Constraints.m6346getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(top, Math.max(top, i4 / 2.0f), f) + max + (paddingValues.getBottom() * f2)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f)) + roundToInt2, MathHelpersKt.lerp(z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i) : roundToInt, -(placeable4.getHeight() / 2), f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i) : roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                roundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), Math.max(roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m5384place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m6527getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1724outlineCutout12SF9DM(Modifier modifier, final long j, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float f;
                float coerceAtLeast;
                float m3891getWidthimpl = Size.m3891getWidthimpl(j);
                if (m3891getWidthimpl > 0.0f) {
                    f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float f2 = contentDrawScope.mo630toPx0680j_4(f);
                    float f3 = contentDrawScope.mo630toPx0680j_4(paddingValues.mo830calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - f2;
                    float f4 = 2;
                    float f5 = m3891getWidthimpl + f3 + (f2 * f4);
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        coerceAtLeast = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f5;
                    } else {
                        coerceAtLeast = RangesKt.coerceAtLeast(f3, 0.0f);
                    }
                    float f6 = coerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        f5 = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - RangesKt.coerceAtLeast(f3, 0.0f);
                    }
                    float f7 = f5;
                    float m3888getHeightimpl = Size.m3888getHeightimpl(j);
                    float f8 = (-m3888getHeightimpl) / f4;
                    float f9 = m3888getHeightimpl / f4;
                    int m4051getDifferencertfAjoo = ClipOp.INSTANCE.m4051getDifferencertfAjoo();
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo4540clipRectN_I0leg(f6, f8, f7, f9, m4051getDifferencertfAjoo);
                    contentDrawScope.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
                    return;
                }
                contentDrawScope.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
