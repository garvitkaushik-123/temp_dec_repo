package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.Strings;
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
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001ar\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001aR\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a\u0014\u0010T\u001a\u00020\f*\u00020\f2\u0006\u0010U\u001a\u00020VH\u0000\u001a\u009a\u0001\u0010W\u001a\u00020\u0006*\u00020X2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010^\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010\\2\b\u0010`\u001a\u0004\u0018\u00010\\2\b\u0010a\u001a\u0004\u0018\u00010\\2\b\u0010b\u001a\u0004\u0018\u00010\\2\u0006\u0010c\u001a\u00020\\2\b\u0010d\u001a\u0004\u0018\u00010\\2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010G\u001a\u000206H\u0002\u001a\u0080\u0001\u0010g\u001a\u00020\u0006*\u00020X2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010h\u001a\u00020\\2\b\u0010^\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010\\2\b\u0010`\u001a\u0004\u0018\u00010\\2\b\u0010a\u001a\u0004\u0018\u00010\\2\b\u0010b\u001a\u0004\u0018\u00010\\2\u0006\u0010c\u001a\u00020\\2\b\u0010d\u001a\u0004\u0018\u00010\\2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010G\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\u001a\u0014\u0010i\u001a\u00020$*\u00020$2\u0006\u0010j\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", Constants.MessagePayloadKeys.FROM, "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m6389constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final String str2;
        int i7;
        final Function1<? super String, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
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
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i36;
        Shape shape2;
        int i37;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i38;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        int i39;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final KeyboardActions keyboardActions2;
        final boolean z7;
        final int i40;
        final TextFieldColors textFieldColors2;
        final VisualTransformation visualTransformation2;
        final boolean z8;
        final boolean z9;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final boolean z10;
        final KeyboardOptions keyboardOptions2;
        final int i41;
        int i42;
        final MutableInteractionSource mutableInteractionSource4;
        long m5918getColor0d7_KjU;
        final TextStyle textStyle4;
        Composer composer2;
        final boolean z11;
        final boolean z12;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z13;
        final int i43;
        final int i44;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource mutableInteractionSource5;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Shape shape4;
        final boolean z14;
        final TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        int i45;
        Composer startRestartGroup = composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)174@9072L7,189@9824L39,190@9902L5,191@9957L8,199@10319L15,199@10253L1913:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i46 = i6 & 4;
        if (i46 != 0) {
            i7 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i47 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i47 | 384;
                            } else {
                                int i48 = i47;
                                if ((i4 & 384) == 0) {
                                    i48 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i48;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i49 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i49 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i49;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= C.ENCODING_PCM_32BIT;
                                    } else if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? 536870912 : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & 384) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i45 = 256;
                                            i33 |= i45;
                                        }
                                        i45 = 128;
                                        i33 |= i45;
                                    }
                                    int i50 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i50 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i46 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(localTextStyle);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textStyle2 = (TextStyle) consume;
                                                i21 &= -458753;
                                            }
                                            if (i10 != 0) {
                                                function28 = null;
                                            }
                                            if (i11 != 0) {
                                                function29 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function227 = i22 == 0 ? function27 : null;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i34 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i34 = i;
                                            }
                                            int i51 = i31 != 0 ? 1 : i2;
                                            if (i32 != 0) {
                                                startRestartGroup.startReplaceableGroup(-1263331754);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextField.kt#9igjgp");
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                i35 = i50;
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                startRestartGroup.endReplaceableGroup();
                                            } else {
                                                i35 = i50;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                i37 = i35 & (-113);
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = shape;
                                                i37 = i35;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function228 = function227;
                                            if ((i6 & 4194304) != 0) {
                                                function210 = function228;
                                                shape3 = shape2;
                                                function211 = function223;
                                                function212 = function224;
                                                function213 = function29;
                                                function214 = function225;
                                                i39 = i27;
                                                function215 = function226;
                                                keyboardActions2 = keyboardActions4;
                                                z7 = z16;
                                                i40 = i51;
                                                textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, i36);
                                                visualTransformation2 = none;
                                                z8 = z5;
                                                function216 = function28;
                                                z10 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i41 = i34;
                                                i42 = i21;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                i38 = i37 & (-897);
                                                textStyle3 = textStyle2;
                                                modifier3 = modifier2;
                                            } else {
                                                function210 = function228;
                                                i38 = i37;
                                                shape3 = shape2;
                                                function211 = function223;
                                                textStyle3 = textStyle2;
                                                function212 = function224;
                                                function213 = function29;
                                                modifier3 = modifier2;
                                                function214 = function225;
                                                i39 = i27;
                                                function215 = function226;
                                                keyboardActions2 = keyboardActions4;
                                                z7 = z16;
                                                i40 = i51;
                                                textFieldColors2 = textFieldColors;
                                                visualTransformation2 = none;
                                                z8 = z5;
                                                z9 = z6;
                                                function216 = function28;
                                                z10 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i41 = i34;
                                                i42 = i21;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-676242365, i42, i39, "androidx.compose.material3.TextField (TextField.kt:192)");
                                                }
                                                startRestartGroup.startReplaceableGroup(-1263331489);
                                                ComposerKt.sourceInformation(startRestartGroup, "*195@10117L46");
                                                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                    m5918getColor0d7_KjU = textFieldColors2.textColor$material3_release(z8, z10, mutableInteractionSource4, startRestartGroup, ((i39 >> 6) & 112) | ((i42 >> 9) & 14) | ((i38 << 6) & 896) | ((i38 << 3) & 7168)).getValue().m4073unboximpl();
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                final TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, 1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2
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

                                                    public final void invoke(Composer composer3, int i52) {
                                                        ComposerKt.sourceInformation(composer3, "C203@10469L38,212@10872L20,200@10346L1814:TextField.kt#uh7d8r");
                                                        if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1859145987, i52, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:200)");
                                                            }
                                                            Modifier modifier4 = Modifier.this;
                                                            boolean z17 = z10;
                                                            Strings.Companion companion = Strings.INSTANCE;
                                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2757getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2756getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z10, composer3, 0).getValue().m4073unboximpl(), null);
                                                            String str3 = str2;
                                                            Function1<String, Unit> function13 = function12;
                                                            boolean z18 = z8;
                                                            boolean z19 = z9;
                                                            TextStyle textStyle5 = merge;
                                                            KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                            KeyboardActions keyboardActions5 = keyboardActions2;
                                                            boolean z20 = z7;
                                                            int i53 = i41;
                                                            int i54 = i40;
                                                            VisualTransformation visualTransformation4 = visualTransformation2;
                                                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                            SolidColor solidColor2 = solidColor;
                                                            final String str4 = str2;
                                                            final boolean z21 = z8;
                                                            final boolean z22 = z7;
                                                            final VisualTransformation visualTransformation5 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                                                            final boolean z23 = z10;
                                                            final Function2<Composer, Integer, Unit> function229 = function216;
                                                            final Function2<Composer, Integer, Unit> function230 = function213;
                                                            final Function2<Composer, Integer, Unit> function231 = function211;
                                                            final Function2<Composer, Integer, Unit> function232 = function212;
                                                            final Function2<Composer, Integer, Unit> function233 = function214;
                                                            final Function2<Composer, Integer, Unit> function234 = function215;
                                                            final Function2<Composer, Integer, Unit> function235 = function210;
                                                            final Shape shape5 = shape3;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            BasicTextFieldKt.BasicTextField(str3, function13, m912defaultMinSizeVpY3zN4, z18, z19, textStyle5, keyboardOptions5, keyboardActions5, z20, i53, i54, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource6, solidColor2, ComposableLambdaKt.composableLambda(composer3, -288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i55) {
                                                                    int i56;
                                                                    ComposerKt.sourceInformation(composer4, "C222@11393L743:TextField.kt#uh7d8r");
                                                                    if ((i55 & 6) == 0) {
                                                                        i56 = i55 | (composer4.changedInstance(function236) ? 4 : 2);
                                                                    } else {
                                                                        i56 = i55;
                                                                    }
                                                                    if ((i56 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-288211827, i56, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:222)");
                                                                        }
                                                                        TextFieldDefaults.INSTANCE.DecorationBox(str4, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors4, null, null, composer4, (i56 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle4 = textStyle3;
                                                composer2 = startRestartGroup;
                                                z11 = z8;
                                                z12 = z9;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z13 = z7;
                                                i43 = i41;
                                                i44 = i40;
                                                visualTransformation3 = visualTransformation2;
                                                mutableInteractionSource5 = mutableInteractionSource4;
                                                function217 = function216;
                                                function218 = function213;
                                                function219 = function215;
                                                function220 = function210;
                                                shape4 = shape3;
                                                z14 = z10;
                                                textFieldColors3 = textFieldColors2;
                                                function221 = function212;
                                                function222 = function214;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i42 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                i50 &= -113;
                                            }
                                            if ((i6 & 4194304) != 0) {
                                                i50 &= -897;
                                            }
                                            function211 = function23;
                                            function212 = function24;
                                            function214 = function25;
                                            function215 = function26;
                                            function210 = function27;
                                            visualTransformation2 = visualTransformation;
                                            keyboardOptions2 = keyboardOptions;
                                            z7 = z4;
                                            i41 = i;
                                            i40 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape3 = shape;
                                            textFieldColors2 = textFieldColors;
                                            i38 = i50;
                                            textStyle3 = textStyle2;
                                            function216 = function28;
                                            function213 = function29;
                                            modifier3 = modifier2;
                                            i39 = i27;
                                            z10 = z3;
                                            keyboardActions2 = keyboardActions;
                                            z8 = z5;
                                        }
                                        z9 = z6;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceableGroup(-1263331489);
                                        ComposerKt.sourceInformation(startRestartGroup, "*195@10117L46");
                                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, 1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2
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

                                            public final void invoke(Composer composer3, int i52) {
                                                ComposerKt.sourceInformation(composer3, "C203@10469L38,212@10872L20,200@10346L1814:TextField.kt#uh7d8r");
                                                if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1859145987, i52, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:200)");
                                                    }
                                                    Modifier modifier4 = Modifier.this;
                                                    boolean z17 = z10;
                                                    Strings.Companion companion = Strings.INSTANCE;
                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2757getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2756getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z10, composer3, 0).getValue().m4073unboximpl(), null);
                                                    String str3 = str2;
                                                    Function1<String, Unit> function13 = function12;
                                                    boolean z18 = z8;
                                                    boolean z19 = z9;
                                                    TextStyle textStyle5 = merge2;
                                                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                    KeyboardActions keyboardActions5 = keyboardActions2;
                                                    boolean z20 = z7;
                                                    int i53 = i41;
                                                    int i54 = i40;
                                                    VisualTransformation visualTransformation4 = visualTransformation2;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                    SolidColor solidColor2 = solidColor;
                                                    final String str4 = str2;
                                                    final boolean z21 = z8;
                                                    final boolean z22 = z7;
                                                    final VisualTransformation visualTransformation5 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                                                    final boolean z23 = z10;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function216;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function211;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function233 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function234 = function215;
                                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function210;
                                                    final Shape shape5 = shape3;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    BasicTextFieldKt.BasicTextField(str3, function13, m912defaultMinSizeVpY3zN4, z18, z19, textStyle5, keyboardOptions5, keyboardActions5, z20, i53, i54, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource6, solidColor2, ComposableLambdaKt.composableLambda(composer3, -288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i55) {
                                                            int i56;
                                                            ComposerKt.sourceInformation(composer4, "C222@11393L743:TextField.kt#uh7d8r");
                                                            if ((i55 & 6) == 0) {
                                                                i56 = i55 | (composer4.changedInstance(function236) ? 4 : 2);
                                                            } else {
                                                                i56 = i55;
                                                            }
                                                            if ((i56 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-288211827, i56, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:222)");
                                                                }
                                                                TextFieldDefaults.INSTANCE.DecorationBox(str4, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors4, null, null, composer4, (i56 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle4 = textStyle3;
                                        composer2 = startRestartGroup;
                                        z11 = z8;
                                        z12 = z9;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z13 = z7;
                                        i43 = i41;
                                        i44 = i40;
                                        visualTransformation3 = visualTransformation2;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        function217 = function216;
                                        function218 = function213;
                                        function219 = function215;
                                        function220 = function210;
                                        shape4 = shape3;
                                        z14 = z10;
                                        textFieldColors3 = textFieldColors2;
                                        function221 = function212;
                                        function222 = function214;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function211 = function23;
                                        function222 = function25;
                                        function219 = function26;
                                        function220 = function27;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z13 = z4;
                                        i43 = i;
                                        i44 = i2;
                                        mutableInteractionSource5 = mutableInteractionSource;
                                        shape4 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z11 = z5;
                                        z12 = z6;
                                        textStyle4 = textStyle2;
                                        function217 = function28;
                                        function218 = function29;
                                        modifier3 = modifier2;
                                        function221 = function24;
                                        z14 = z3;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier4 = modifier3;
                                        final Function2<? super Composer, ? super Integer, Unit> function229 = function211;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$3
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

                                            public final void invoke(Composer composer3, int i52) {
                                                TextFieldKt.TextField(str, function1, modifier4, z11, z12, textStyle4, function217, function218, function229, function221, function222, function219, function220, z14, visualTransformation3, keyboardOptions3, keyboardActions3, z13, i43, i44, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            int i502 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
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
                            if (i22 == 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 != 0) {
                            }
                            if ((2097152 & i6) != 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function2282 = function227;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i472 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        int i5022 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i46 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
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
                        if (i22 == 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 != 0) {
                        }
                        if ((2097152 & i6) != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function22822 = function227;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4722 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    int i50222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
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
                    if (i22 == 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 != 0) {
                    }
                    if ((2097152 & i6) != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function228222 = function227;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i47222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                int i502222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i46 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
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
                if (i22 == 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 != 0) {
                }
                if ((2097152 & i6) != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2282222 = function227;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i472222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            int i5022222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i46 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
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
            if (i22 == 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 != 0) {
            }
            if ((2097152 & i6) != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function22822222 = function227;
            if ((i6 & 4194304) != 0) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4722222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        int i50222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i46 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
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
        if (i22 == 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 != 0) {
        }
        if ((2097152 & i6) != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function228222222 = function227;
        if ((i6 & 4194304) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final TextFieldValue textFieldValue2;
        int i7;
        final Function1<? super TextFieldValue, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
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
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i36;
        Shape shape2;
        int i37;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i38;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        int i39;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final KeyboardActions keyboardActions2;
        final boolean z7;
        final int i40;
        final TextFieldColors textFieldColors2;
        final VisualTransformation visualTransformation2;
        final boolean z8;
        final boolean z9;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final boolean z10;
        final KeyboardOptions keyboardOptions2;
        final int i41;
        int i42;
        final MutableInteractionSource mutableInteractionSource4;
        long m5918getColor0d7_KjU;
        final TextStyle textStyle4;
        Composer composer2;
        final boolean z11;
        final boolean z12;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z13;
        final int i43;
        final int i44;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource mutableInteractionSource5;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Shape shape4;
        final boolean z14;
        final TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        int i45;
        Composer startRestartGroup = composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)320@17250L7,335@18002L39,336@18080L5,337@18135L8,345@18497L15,345@18431L1918:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(textFieldValue2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i46 = i6 & 4;
        if (i46 != 0) {
            i7 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i47 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i47 | 384;
                            } else {
                                int i48 = i47;
                                if ((i4 & 384) == 0) {
                                    i48 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i48;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i49 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i49 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i49;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= C.ENCODING_PCM_32BIT;
                                    } else if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? 536870912 : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & 384) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i45 = 256;
                                            i33 |= i45;
                                        }
                                        i45 = 128;
                                        i33 |= i45;
                                    }
                                    int i50 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i50 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i46 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(localTextStyle);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textStyle2 = (TextStyle) consume;
                                                i21 &= -458753;
                                            }
                                            if (i10 != 0) {
                                                function28 = null;
                                            }
                                            if (i11 != 0) {
                                                function29 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function227 = i22 == 0 ? function27 : null;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i34 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i34 = i;
                                            }
                                            int i51 = i31 != 0 ? 1 : i2;
                                            if (i32 != 0) {
                                                startRestartGroup.startReplaceableGroup(-1263323576);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextField.kt#9igjgp");
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                i35 = i50;
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                startRestartGroup.endReplaceableGroup();
                                            } else {
                                                i35 = i50;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                i37 = i35 & (-113);
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = shape;
                                                i37 = i35;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function228 = function227;
                                            if ((i6 & 4194304) != 0) {
                                                function210 = function228;
                                                shape3 = shape2;
                                                function211 = function223;
                                                function212 = function224;
                                                function213 = function29;
                                                function214 = function225;
                                                i39 = i27;
                                                function215 = function226;
                                                keyboardActions2 = keyboardActions4;
                                                z7 = z16;
                                                i40 = i51;
                                                textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, i36);
                                                visualTransformation2 = none;
                                                z8 = z5;
                                                function216 = function28;
                                                z10 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i41 = i34;
                                                i42 = i21;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                i38 = i37 & (-897);
                                                textStyle3 = textStyle2;
                                                modifier3 = modifier2;
                                            } else {
                                                function210 = function228;
                                                i38 = i37;
                                                shape3 = shape2;
                                                function211 = function223;
                                                textStyle3 = textStyle2;
                                                function212 = function224;
                                                function213 = function29;
                                                modifier3 = modifier2;
                                                function214 = function225;
                                                i39 = i27;
                                                function215 = function226;
                                                keyboardActions2 = keyboardActions4;
                                                z7 = z16;
                                                i40 = i51;
                                                textFieldColors2 = textFieldColors;
                                                visualTransformation2 = none;
                                                z8 = z5;
                                                z9 = z6;
                                                function216 = function28;
                                                z10 = z15;
                                                keyboardOptions2 = keyboardOptions4;
                                                i41 = i34;
                                                i42 = i21;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1268528240, i42, i39, "androidx.compose.material3.TextField (TextField.kt:338)");
                                                }
                                                startRestartGroup.startReplaceableGroup(-1263323311);
                                                ComposerKt.sourceInformation(startRestartGroup, "*341@18295L46");
                                                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                    m5918getColor0d7_KjU = textFieldColors2.textColor$material3_release(z8, z10, mutableInteractionSource4, startRestartGroup, ((i39 >> 6) & 112) | ((i42 >> 9) & 14) | ((i38 << 6) & 896) | ((i38 << 3) & 7168)).getValue().m4073unboximpl();
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                final TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, -1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5
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

                                                    public final void invoke(Composer composer3, int i52) {
                                                        ComposerKt.sourceInformation(composer3, "C349@18647L38,358@19050L20,346@18524L1819:TextField.kt#uh7d8r");
                                                        if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1163788208, i52, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:346)");
                                                            }
                                                            Modifier modifier4 = Modifier.this;
                                                            boolean z17 = z10;
                                                            Strings.Companion companion = Strings.INSTANCE;
                                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2757getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2756getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z10, composer3, 0).getValue().m4073unboximpl(), null);
                                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                                            Function1<TextFieldValue, Unit> function13 = function12;
                                                            boolean z18 = z8;
                                                            boolean z19 = z9;
                                                            TextStyle textStyle5 = merge;
                                                            KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                            KeyboardActions keyboardActions5 = keyboardActions2;
                                                            boolean z20 = z7;
                                                            int i53 = i41;
                                                            int i54 = i40;
                                                            VisualTransformation visualTransformation4 = visualTransformation2;
                                                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                            SolidColor solidColor2 = solidColor;
                                                            final TextFieldValue textFieldValue4 = textFieldValue2;
                                                            final boolean z21 = z8;
                                                            final boolean z22 = z7;
                                                            final VisualTransformation visualTransformation5 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                                                            final boolean z23 = z10;
                                                            final Function2<Composer, Integer, Unit> function229 = function216;
                                                            final Function2<Composer, Integer, Unit> function230 = function213;
                                                            final Function2<Composer, Integer, Unit> function231 = function211;
                                                            final Function2<Composer, Integer, Unit> function232 = function212;
                                                            final Function2<Composer, Integer, Unit> function233 = function214;
                                                            final Function2<Composer, Integer, Unit> function234 = function215;
                                                            final Function2<Composer, Integer, Unit> function235 = function210;
                                                            final Shape shape5 = shape3;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            BasicTextFieldKt.BasicTextField(textFieldValue3, function13, m912defaultMinSizeVpY3zN4, z18, z19, textStyle5, keyboardOptions5, keyboardActions5, z20, i53, i54, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource6, solidColor2, ComposableLambdaKt.composableLambda(composer3, 1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i55) {
                                                                    int i56;
                                                                    ComposerKt.sourceInformation(composer4, "C368@19571L748:TextField.kt#uh7d8r");
                                                                    if ((i55 & 6) == 0) {
                                                                        i56 = i55 | (composer4.changedInstance(function236) ? 4 : 2);
                                                                    } else {
                                                                        i56 = i55;
                                                                    }
                                                                    if ((i56 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1751957978, i56, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:368)");
                                                                        }
                                                                        TextFieldDefaults.INSTANCE.DecorationBox(TextFieldValue.this.getText(), function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors4, null, null, composer4, (i56 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle4 = textStyle3;
                                                composer2 = startRestartGroup;
                                                z11 = z8;
                                                z12 = z9;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z13 = z7;
                                                i43 = i41;
                                                i44 = i40;
                                                visualTransformation3 = visualTransformation2;
                                                mutableInteractionSource5 = mutableInteractionSource4;
                                                function217 = function216;
                                                function218 = function213;
                                                function219 = function215;
                                                function220 = function210;
                                                shape4 = shape3;
                                                z14 = z10;
                                                textFieldColors3 = textFieldColors2;
                                                function221 = function212;
                                                function222 = function214;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i42 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                i50 &= -113;
                                            }
                                            if ((i6 & 4194304) != 0) {
                                                i50 &= -897;
                                            }
                                            function211 = function23;
                                            function212 = function24;
                                            function214 = function25;
                                            function215 = function26;
                                            function210 = function27;
                                            visualTransformation2 = visualTransformation;
                                            keyboardOptions2 = keyboardOptions;
                                            z7 = z4;
                                            i41 = i;
                                            i40 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape3 = shape;
                                            textFieldColors2 = textFieldColors;
                                            i38 = i50;
                                            textStyle3 = textStyle2;
                                            function216 = function28;
                                            function213 = function29;
                                            modifier3 = modifier2;
                                            i39 = i27;
                                            z10 = z3;
                                            keyboardActions2 = keyboardActions;
                                            z8 = z5;
                                        }
                                        z9 = z6;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceableGroup(-1263323311);
                                        ComposerKt.sourceInformation(startRestartGroup, "*341@18295L46");
                                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, -1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5
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

                                            public final void invoke(Composer composer3, int i52) {
                                                ComposerKt.sourceInformation(composer3, "C349@18647L38,358@19050L20,346@18524L1819:TextField.kt#uh7d8r");
                                                if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1163788208, i52, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:346)");
                                                    }
                                                    Modifier modifier4 = Modifier.this;
                                                    boolean z17 = z10;
                                                    Strings.Companion companion = Strings.INSTANCE;
                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2757getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2756getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z10, composer3, 0).getValue().m4073unboximpl(), null);
                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                    Function1<TextFieldValue, Unit> function13 = function12;
                                                    boolean z18 = z8;
                                                    boolean z19 = z9;
                                                    TextStyle textStyle5 = merge2;
                                                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                                    KeyboardActions keyboardActions5 = keyboardActions2;
                                                    boolean z20 = z7;
                                                    int i53 = i41;
                                                    int i54 = i40;
                                                    VisualTransformation visualTransformation4 = visualTransformation2;
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                    SolidColor solidColor2 = solidColor;
                                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                                    final boolean z21 = z8;
                                                    final boolean z22 = z7;
                                                    final VisualTransformation visualTransformation5 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                                                    final boolean z23 = z10;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function216;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function211;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function233 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function234 = function215;
                                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function210;
                                                    final Shape shape5 = shape3;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    BasicTextFieldKt.BasicTextField(textFieldValue3, function13, m912defaultMinSizeVpY3zN4, z18, z19, textStyle5, keyboardOptions5, keyboardActions5, z20, i53, i54, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource6, solidColor2, ComposableLambdaKt.composableLambda(composer3, 1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i55) {
                                                            int i56;
                                                            ComposerKt.sourceInformation(composer4, "C368@19571L748:TextField.kt#uh7d8r");
                                                            if ((i55 & 6) == 0) {
                                                                i56 = i55 | (composer4.changedInstance(function236) ? 4 : 2);
                                                            } else {
                                                                i56 = i55;
                                                            }
                                                            if ((i56 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1751957978, i56, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:368)");
                                                                }
                                                                TextFieldDefaults.INSTANCE.DecorationBox(TextFieldValue.this.getText(), function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors4, null, null, composer4, (i56 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle4 = textStyle3;
                                        composer2 = startRestartGroup;
                                        z11 = z8;
                                        z12 = z9;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z13 = z7;
                                        i43 = i41;
                                        i44 = i40;
                                        visualTransformation3 = visualTransformation2;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        function217 = function216;
                                        function218 = function213;
                                        function219 = function215;
                                        function220 = function210;
                                        shape4 = shape3;
                                        z14 = z10;
                                        textFieldColors3 = textFieldColors2;
                                        function221 = function212;
                                        function222 = function214;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function211 = function23;
                                        function222 = function25;
                                        function219 = function26;
                                        function220 = function27;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z13 = z4;
                                        i43 = i;
                                        i44 = i2;
                                        mutableInteractionSource5 = mutableInteractionSource;
                                        shape4 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z11 = z5;
                                        z12 = z6;
                                        textStyle4 = textStyle2;
                                        function217 = function28;
                                        function218 = function29;
                                        modifier3 = modifier2;
                                        function221 = function24;
                                        z14 = z3;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier4 = modifier3;
                                        final Function2<? super Composer, ? super Integer, Unit> function229 = function211;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$6
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

                                            public final void invoke(Composer composer3, int i52) {
                                                TextFieldKt.TextField(TextFieldValue.this, function1, modifier4, z11, z12, textStyle4, function217, function218, function229, function221, function222, function219, function220, z14, visualTransformation3, keyboardOptions3, keyboardActions3, z13, i43, i44, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            int i502 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
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
                            if (i22 == 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 != 0) {
                            }
                            if ((2097152 & i6) != 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function2282 = function227;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i472 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        int i5022 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i46 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
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
                        if (i22 == 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 != 0) {
                        }
                        if ((2097152 & i6) != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function22822 = function227;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4722 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    int i50222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
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
                    if (i22 == 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 != 0) {
                    }
                    if ((2097152 & i6) != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function228222 = function227;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i47222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                int i502222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i46 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
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
                if (i22 == 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 != 0) {
                }
                if ((2097152 & i6) != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2282222 = function227;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i472222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            int i5022222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i46 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
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
            if (i22 == 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 != 0) {
            }
            if ((2097152 & i6) != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function22822222 = function227;
            if ((i6 & 4194304) != 0) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4722222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        int i50222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i46 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
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
        if (i22 == 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 != 0) {
        }
        if ((2097152 & i6) != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function228222222 = function227;
        if ((i6 & 4194304) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        boolean z5;
        int i10;
        boolean z6;
        TextStyle textStyle2;
        int i11;
        Function2 function26;
        int i12;
        Function2 function27;
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
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i34;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        TextFieldColors textFieldColors2;
        int i35;
        boolean z7;
        TextStyle textStyle3;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        int i36;
        boolean z8;
        boolean z9;
        VisualTransformation visualTransformation2;
        int i37;
        int i38;
        KeyboardActions keyboardActions2;
        boolean z10;
        KeyboardOptions keyboardOptions2;
        Function2 function211;
        Function2 function212;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function213;
        final Function2 function214;
        final Function2 function215;
        final Function2 function216;
        final Function2 function217;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i39;
        final int i40;
        final MutableInteractionSource mutableInteractionSource5;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1500728277);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)400@20694L7,413@21354L39,414@21432L5,415@21487L8,417@21504L763:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i7 = i3;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i3 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            textStyle2 = textStyle;
                            i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                            function26 = function2;
                        } else {
                            function26 = function2;
                            if ((i3 & 1572864) == 0) {
                                i7 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                            }
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 12582912;
                            function27 = function22;
                        } else {
                            function27 = function22;
                            if ((i3 & 12582912) == 0) {
                                i7 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i6 & 256;
                        if (i13 != 0) {
                            i7 |= 100663296;
                        } else if ((i3 & 100663296) == 0) {
                            i14 = i13;
                            i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                            i15 = i6 & 512;
                            if (i15 == 0) {
                                i7 |= C.ENCODING_PCM_32BIT;
                            } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                                i16 = i15;
                                i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                                i17 = i6 & 1024;
                                if (i17 != 0) {
                                    i19 = i4 | 6;
                                    i18 = i17;
                                } else if ((i4 & 6) == 0) {
                                    i18 = i17;
                                    i19 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                    i19 = i4;
                                }
                                i20 = i6 & 2048;
                                if (i20 != 0) {
                                    i19 |= 48;
                                    i21 = i20;
                                } else if ((i4 & 48) == 0) {
                                    i21 = i20;
                                    i19 |= startRestartGroup.changed(z3) ? 32 : 16;
                                } else {
                                    i21 = i20;
                                }
                                int i41 = i19;
                                i22 = i6 & 4096;
                                if (i22 != 0) {
                                    i23 = i41 | 384;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & 384) == 0) {
                                        i42 |= startRestartGroup.changed(visualTransformation) ? 256 : 128;
                                    }
                                    i23 = i42;
                                }
                                i24 = i6 & 8192;
                                if (i24 != 0) {
                                    i25 = i23 | 3072;
                                } else {
                                    int i43 = i23;
                                    if ((i4 & 3072) == 0) {
                                        i25 = i43 | (startRestartGroup.changed(keyboardOptions) ? 2048 : 1024);
                                    } else {
                                        i25 = i43;
                                    }
                                }
                                i26 = i6 & 16384;
                                if (i26 != 0) {
                                    i27 = i25 | 24576;
                                } else {
                                    i27 = i25;
                                    if ((i4 & 24576) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 16384 : 8192;
                                        i28 = i6 & 32768;
                                        if (i28 == 0) {
                                            i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                            i27 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                                        }
                                        if ((i4 & 1572864) == 0) {
                                            i27 |= ((i6 & 65536) == 0 && startRestartGroup.changed(i)) ? 1048576 : 524288;
                                        }
                                        i29 = i6 & 131072;
                                        if (i29 == 0) {
                                            i27 |= 12582912;
                                        } else if ((i4 & 12582912) == 0) {
                                            i27 |= startRestartGroup.changed(i2) ? 8388608 : 4194304;
                                        }
                                        i30 = i6 & 262144;
                                        if (i30 == 0) {
                                            i27 |= 100663296;
                                        } else if ((i4 & 100663296) == 0) {
                                            i27 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                            i27 |= ((i6 & 524288) == 0 && startRestartGroup.changed(shape)) ? 536870912 : 268435456;
                                        }
                                        if ((i5 & 6) != 0) {
                                            i31 = i5 | (((i6 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                        } else {
                                            i31 = i5;
                                        }
                                        if ((i7 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i31 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                if (i8 != 0) {
                                                    modifier2 = Modifier.INSTANCE;
                                                }
                                                if (i9 != 0) {
                                                    z5 = true;
                                                }
                                                if (i10 != 0) {
                                                    z6 = false;
                                                }
                                                if ((i6 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i7 &= -458753;
                                                }
                                                if (i11 != 0) {
                                                    function26 = null;
                                                }
                                                if (i12 != 0) {
                                                    function27 = null;
                                                }
                                                Function2 function218 = i14 == 0 ? null : function23;
                                                Function2 function219 = i16 == 0 ? null : function24;
                                                Function2 function220 = i18 == 0 ? function25 : null;
                                                boolean z15 = i21 == 0 ? false : z3;
                                                VisualTransformation none = i22 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i24 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                KeyboardActions keyboardActions4 = i26 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                                boolean z16 = i28 == 0 ? false : z4;
                                                if ((i6 & 65536) == 0) {
                                                    i32 = z16 ? 1 : Integer.MAX_VALUE;
                                                    i27 &= -3670017;
                                                } else {
                                                    i32 = i;
                                                }
                                                int i44 = i29 == 0 ? i2 : 1;
                                                if (i30 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-1263320224);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    i33 = i44;
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                    startRestartGroup.endReplaceableGroup();
                                                } else {
                                                    i33 = i44;
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i6 & 524288) == 0) {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                    i27 &= -1879048193;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = shape;
                                                }
                                                Shape shape5 = shape2;
                                                if ((i6 & 1048576) == 0) {
                                                    i31 &= -15;
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, i34);
                                                } else {
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = textFieldColors;
                                                }
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                function29 = function218;
                                                function210 = function219;
                                                i36 = i27;
                                                z8 = z15;
                                                z9 = z16;
                                                visualTransformation2 = none;
                                                i37 = i32;
                                                i38 = i33;
                                                keyboardActions2 = keyboardActions4;
                                                z10 = z5;
                                                keyboardOptions2 = keyboardOptions4;
                                                function211 = function220;
                                                function212 = function27;
                                                modifier3 = modifier2;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i6 & 32) != 0) {
                                                    i7 &= -458753;
                                                }
                                                if ((i6 & 65536) != 0) {
                                                    i27 &= -3670017;
                                                }
                                                if ((i6 & 524288) != 0) {
                                                    i27 &= -1879048193;
                                                }
                                                if ((i6 & 1048576) != 0) {
                                                    i31 &= -15;
                                                }
                                                function210 = function24;
                                                function211 = function25;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions2 = keyboardActions;
                                                z9 = z4;
                                                i37 = i;
                                                i38 = i2;
                                                mutableInteractionSource4 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                function212 = function27;
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                modifier3 = modifier2;
                                                i36 = i27;
                                                function29 = function23;
                                                z8 = z3;
                                                z10 = z5;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1500728277, i35, i36, "androidx.compose.material3.TextField (TextField.kt:416)");
                                            }
                                            int i45 = i35 & 2147483646;
                                            int i46 = i36 << 6;
                                            int i47 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                            composer2 = startRestartGroup;
                                            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45, (i46 & 896) | 54 | (i46 & 7168) | (57344 & i46) | (458752 & i46) | (3670016 & i46) | (29360128 & i46) | (234881024 & i46) | (i46 & 1879048192), i47, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z10;
                                            z12 = z7;
                                            textStyle4 = textStyle3;
                                            function213 = function28;
                                            function214 = function212;
                                            function215 = function29;
                                            function216 = function210;
                                            function217 = function211;
                                            z13 = z8;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions3 = keyboardActions2;
                                            z14 = z9;
                                            i39 = i37;
                                            i40 = i38;
                                            mutableInteractionSource5 = mutableInteractionSource4;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            function217 = function25;
                                            visualTransformation3 = visualTransformation;
                                            keyboardActions3 = keyboardActions;
                                            z14 = z4;
                                            i39 = i;
                                            i40 = i2;
                                            mutableInteractionSource5 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            function214 = function27;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function213 = function26;
                                            modifier4 = modifier2;
                                            function215 = function23;
                                            function216 = function24;
                                            z13 = z3;
                                            keyboardOptions3 = keyboardOptions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$8
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

                                                public final void invoke(Composer composer3, int i48) {
                                                    TextFieldKt.TextField(str, function1, modifier4, z11, z12, textStyle4, function213, function214, function215, function216, function217, z13, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i39, i40, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i28 = i6 & 32768;
                                if (i28 == 0) {
                                }
                                if ((i4 & 1572864) == 0) {
                                }
                                i29 = i6 & 131072;
                                if (i29 == 0) {
                                }
                                i30 = i6 & 262144;
                                if (i30 == 0) {
                                }
                                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                }
                                if ((i5 & 6) != 0) {
                                }
                                if ((i7 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if ((i6 & 32) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                if (i28 == 0) {
                                }
                                if ((i6 & 65536) == 0) {
                                }
                                if (i29 == 0) {
                                }
                                if (i30 == 0) {
                                }
                                if ((i6 & 524288) == 0) {
                                }
                                Shape shape52 = shape2;
                                if ((i6 & 1048576) == 0) {
                                }
                                i35 = i7;
                                z7 = z6;
                                textStyle3 = textStyle2;
                                function28 = function26;
                                function29 = function218;
                                function210 = function219;
                                i36 = i27;
                                z8 = z15;
                                z9 = z16;
                                visualTransformation2 = none;
                                i37 = i32;
                                i38 = i33;
                                keyboardActions2 = keyboardActions4;
                                z10 = z5;
                                keyboardOptions2 = keyboardOptions4;
                                function211 = function220;
                                function212 = function27;
                                modifier3 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i452 = i35 & 2147483646;
                                int i462 = i36 << 6;
                                int i472 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                composer2 = startRestartGroup;
                                TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452, (i462 & 896) | 54 | (i462 & 7168) | (57344 & i462) | (458752 & i462) | (3670016 & i462) | (29360128 & i462) | (234881024 & i462) | (i462 & 1879048192), i472, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                z11 = z10;
                                z12 = z7;
                                textStyle4 = textStyle3;
                                function213 = function28;
                                function214 = function212;
                                function215 = function29;
                                function216 = function210;
                                function217 = function211;
                                z13 = z8;
                                visualTransformation3 = visualTransformation2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                z14 = z9;
                                i39 = i37;
                                i40 = i38;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                shape4 = shape3;
                                textFieldColors3 = textFieldColors2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i6 & 1024;
                            if (i17 != 0) {
                            }
                            i20 = i6 & 2048;
                            if (i20 != 0) {
                            }
                            int i412 = i19;
                            i22 = i6 & 4096;
                            if (i22 != 0) {
                            }
                            i24 = i6 & 8192;
                            if (i24 != 0) {
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                            }
                            i28 = i6 & 32768;
                            if (i28 == 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            i29 = i6 & 131072;
                            if (i29 == 0) {
                            }
                            i30 = i6 & 262144;
                            if (i30 == 0) {
                            }
                            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                            }
                            if ((i5 & 6) != 0) {
                            }
                            if ((i7 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i6 & 65536) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i30 == 0) {
                            }
                            if ((i6 & 524288) == 0) {
                            }
                            Shape shape522 = shape2;
                            if ((i6 & 1048576) == 0) {
                            }
                            i35 = i7;
                            z7 = z6;
                            textStyle3 = textStyle2;
                            function28 = function26;
                            function29 = function218;
                            function210 = function219;
                            i36 = i27;
                            z8 = z15;
                            z9 = z16;
                            visualTransformation2 = none;
                            i37 = i32;
                            i38 = i33;
                            keyboardActions2 = keyboardActions4;
                            z10 = z5;
                            keyboardOptions2 = keyboardOptions4;
                            function211 = function220;
                            function212 = function27;
                            modifier3 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i4522 = i35 & 2147483646;
                            int i4622 = i36 << 6;
                            int i4722 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                            composer2 = startRestartGroup;
                            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522, (i4622 & 896) | 54 | (i4622 & 7168) | (57344 & i4622) | (458752 & i4622) | (3670016 & i4622) | (29360128 & i4622) | (234881024 & i4622) | (i4622 & 1879048192), i4722, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z10;
                            z12 = z7;
                            textStyle4 = textStyle3;
                            function213 = function28;
                            function214 = function212;
                            function215 = function29;
                            function216 = function210;
                            function217 = function211;
                            z13 = z8;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            z14 = z9;
                            i39 = i37;
                            i40 = i38;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i6 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i6 & 1024;
                        if (i17 != 0) {
                        }
                        i20 = i6 & 2048;
                        if (i20 != 0) {
                        }
                        int i4122 = i19;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 == 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        i29 = i6 & 131072;
                        if (i29 == 0) {
                        }
                        i30 = i6 & 262144;
                        if (i30 == 0) {
                        }
                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                        }
                        if ((i5 & 6) != 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if ((i6 & 65536) == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i30 == 0) {
                        }
                        if ((i6 & 524288) == 0) {
                        }
                        Shape shape5222 = shape2;
                        if ((i6 & 1048576) == 0) {
                        }
                        i35 = i7;
                        z7 = z6;
                        textStyle3 = textStyle2;
                        function28 = function26;
                        function29 = function218;
                        function210 = function219;
                        i36 = i27;
                        z8 = z15;
                        z9 = z16;
                        visualTransformation2 = none;
                        i37 = i32;
                        i38 = i33;
                        keyboardActions2 = keyboardActions4;
                        z10 = z5;
                        keyboardOptions2 = keyboardOptions4;
                        function211 = function220;
                        function212 = function27;
                        modifier3 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i45222 = i35 & 2147483646;
                        int i46222 = i36 << 6;
                        int i47222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                        composer2 = startRestartGroup;
                        TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222, (i46222 & 896) | 54 | (i46222 & 7168) | (57344 & i46222) | (458752 & i46222) | (3670016 & i46222) | (29360128 & i46222) | (234881024 & i46222) | (i46222 & 1879048192), i47222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z10;
                        z12 = z7;
                        textStyle4 = textStyle3;
                        function213 = function28;
                        function214 = function212;
                        function215 = function29;
                        function216 = function210;
                        function217 = function211;
                        z13 = z8;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions3 = keyboardActions2;
                        z14 = z9;
                        i39 = i37;
                        i40 = i38;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z6 = z2;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 1024;
                    if (i17 != 0) {
                    }
                    i20 = i6 & 2048;
                    if (i20 != 0) {
                    }
                    int i41222 = i19;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 == 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    i29 = i6 & 131072;
                    if (i29 == 0) {
                    }
                    i30 = i6 & 262144;
                    if (i30 == 0) {
                    }
                    if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                    }
                    if ((i5 & 6) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i6 & 65536) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i30 == 0) {
                    }
                    if ((i6 & 524288) == 0) {
                    }
                    Shape shape52222 = shape2;
                    if ((i6 & 1048576) == 0) {
                    }
                    i35 = i7;
                    z7 = z6;
                    textStyle3 = textStyle2;
                    function28 = function26;
                    function29 = function218;
                    function210 = function219;
                    i36 = i27;
                    z8 = z15;
                    z9 = z16;
                    visualTransformation2 = none;
                    i37 = i32;
                    i38 = i33;
                    keyboardActions2 = keyboardActions4;
                    z10 = z5;
                    keyboardOptions2 = keyboardOptions4;
                    function211 = function220;
                    function212 = function27;
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i452222 = i35 & 2147483646;
                    int i462222 = i36 << 6;
                    int i472222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                    composer2 = startRestartGroup;
                    TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222, (i462222 & 896) | 54 | (i462222 & 7168) | (57344 & i462222) | (458752 & i462222) | (3670016 & i462222) | (29360128 & i462222) | (234881024 & i462222) | (i462222 & 1879048192), i472222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z10;
                    z12 = z7;
                    textStyle4 = textStyle3;
                    function213 = function28;
                    function214 = function212;
                    function215 = function29;
                    function216 = function210;
                    function217 = function211;
                    z13 = z8;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z14 = z9;
                    i39 = i37;
                    i40 = i38;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                i13 = i6 & 256;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i6 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 != 0) {
                }
                i20 = i6 & 2048;
                if (i20 != 0) {
                }
                int i412222 = i19;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 == 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                i29 = i6 & 131072;
                if (i29 == 0) {
                }
                i30 = i6 & 262144;
                if (i30 == 0) {
                }
                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                }
                if ((i5 & 6) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if (i28 == 0) {
                }
                if ((i6 & 65536) == 0) {
                }
                if (i29 == 0) {
                }
                if (i30 == 0) {
                }
                if ((i6 & 524288) == 0) {
                }
                Shape shape522222 = shape2;
                if ((i6 & 1048576) == 0) {
                }
                i35 = i7;
                z7 = z6;
                textStyle3 = textStyle2;
                function28 = function26;
                function29 = function218;
                function210 = function219;
                i36 = i27;
                z8 = z15;
                z9 = z16;
                visualTransformation2 = none;
                i37 = i32;
                i38 = i33;
                keyboardActions2 = keyboardActions4;
                z10 = z5;
                keyboardOptions2 = keyboardOptions4;
                function211 = function220;
                function212 = function27;
                modifier3 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i4522222 = i35 & 2147483646;
                int i4622222 = i36 << 6;
                int i4722222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                composer2 = startRestartGroup;
                TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522222, (i4622222 & 896) | 54 | (i4622222 & 7168) | (57344 & i4622222) | (458752 & i4622222) | (3670016 & i4622222) | (29360128 & i4622222) | (234881024 & i4622222) | (i4622222 & 1879048192), i4722222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z10;
                z12 = z7;
                textStyle4 = textStyle3;
                function213 = function28;
                function214 = function212;
                function215 = function29;
                function216 = function210;
                function217 = function211;
                z13 = z8;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z14 = z9;
                i39 = i37;
                i40 = i38;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            z5 = z;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i6 & 256;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i6 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i20 = i6 & 2048;
            if (i20 != 0) {
            }
            int i4122222 = i19;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 == 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            i29 = i6 & 131072;
            if (i29 == 0) {
            }
            i30 = i6 & 262144;
            if (i30 == 0) {
            }
            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
            }
            if ((i5 & 6) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i21 == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if (i28 == 0) {
            }
            if ((i6 & 65536) == 0) {
            }
            if (i29 == 0) {
            }
            if (i30 == 0) {
            }
            if ((i6 & 524288) == 0) {
            }
            Shape shape5222222 = shape2;
            if ((i6 & 1048576) == 0) {
            }
            i35 = i7;
            z7 = z6;
            textStyle3 = textStyle2;
            function28 = function26;
            function29 = function218;
            function210 = function219;
            i36 = i27;
            z8 = z15;
            z9 = z16;
            visualTransformation2 = none;
            i37 = i32;
            i38 = i33;
            keyboardActions2 = keyboardActions4;
            z10 = z5;
            keyboardOptions2 = keyboardOptions4;
            function211 = function220;
            function212 = function27;
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i45222222 = i35 & 2147483646;
            int i46222222 = i36 << 6;
            int i47222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
            composer2 = startRestartGroup;
            TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222222, (i46222222 & 896) | 54 | (i46222222 & 7168) | (57344 & i46222222) | (458752 & i46222222) | (3670016 & i46222222) | (29360128 & i46222222) | (234881024 & i46222222) | (i46222222 & 1879048192), i47222222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z10;
            z12 = z7;
            textStyle4 = textStyle3;
            function213 = function28;
            function214 = function212;
            function215 = function29;
            function216 = function210;
            function217 = function211;
            z13 = z8;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z14 = z9;
            i39 = i37;
            i40 = i38;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        z5 = z;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i6 & 256;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i20 = i6 & 2048;
        if (i20 != 0) {
        }
        int i41222222 = i19;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 == 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        i29 = i6 & 131072;
        if (i29 == 0) {
        }
        i30 = i6 & 262144;
        if (i30 == 0) {
        }
        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
        }
        if ((i5 & 6) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i21 == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if (i28 == 0) {
        }
        if ((i6 & 65536) == 0) {
        }
        if (i29 == 0) {
        }
        if (i30 == 0) {
        }
        if ((i6 & 524288) == 0) {
        }
        Shape shape52222222 = shape2;
        if ((i6 & 1048576) == 0) {
        }
        i35 = i7;
        z7 = z6;
        textStyle3 = textStyle2;
        function28 = function26;
        function29 = function218;
        function210 = function219;
        i36 = i27;
        z8 = z15;
        z9 = z16;
        visualTransformation2 = none;
        i37 = i32;
        i38 = i33;
        keyboardActions2 = keyboardActions4;
        z10 = z5;
        keyboardOptions2 = keyboardOptions4;
        function211 = function220;
        function212 = function27;
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i452222222 = i35 & 2147483646;
        int i462222222 = i36 << 6;
        int i472222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
        composer2 = startRestartGroup;
        TextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222222, (i462222222 & 896) | 54 | (i462222222 & 7168) | (57344 & i462222222) | (458752 & i462222222) | (3670016 & i462222222) | (29360128 & i462222222) | (234881024 & i462222222) | (i462222222 & 1879048192), i472222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z10;
        z12 = z7;
        textStyle4 = textStyle3;
        function213 = function28;
        function214 = function212;
        function215 = function29;
        function216 = function210;
        function217 = function211;
        z13 = z8;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions3 = keyboardActions2;
        z14 = z9;
        i39 = i37;
        i40 = i38;
        mutableInteractionSource5 = mutableInteractionSource4;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        boolean z5;
        int i10;
        boolean z6;
        TextStyle textStyle2;
        int i11;
        Function2 function26;
        int i12;
        Function2 function27;
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
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i34;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        TextFieldColors textFieldColors2;
        int i35;
        boolean z7;
        TextStyle textStyle3;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        int i36;
        boolean z8;
        boolean z9;
        VisualTransformation visualTransformation2;
        int i37;
        int i38;
        KeyboardActions keyboardActions2;
        boolean z10;
        KeyboardOptions keyboardOptions2;
        Function2 function211;
        Function2 function212;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function213;
        final Function2 function214;
        final Function2 function215;
        final Function2 function216;
        final Function2 function217;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i39;
        final int i40;
        final MutableInteractionSource mutableInteractionSource5;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1523846136);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)453@22628L7,466@23288L39,467@23366L5,468@23421L8,470@23438L763:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i7 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i7 = i3;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i3 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            textStyle2 = textStyle;
                            i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                            function26 = function2;
                        } else {
                            function26 = function2;
                            if ((i3 & 1572864) == 0) {
                                i7 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                            }
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 12582912;
                            function27 = function22;
                        } else {
                            function27 = function22;
                            if ((i3 & 12582912) == 0) {
                                i7 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i6 & 256;
                        if (i13 != 0) {
                            i7 |= 100663296;
                        } else if ((i3 & 100663296) == 0) {
                            i14 = i13;
                            i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                            i15 = i6 & 512;
                            if (i15 == 0) {
                                i7 |= C.ENCODING_PCM_32BIT;
                            } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                                i16 = i15;
                                i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                                i17 = i6 & 1024;
                                if (i17 != 0) {
                                    i19 = i4 | 6;
                                    i18 = i17;
                                } else if ((i4 & 6) == 0) {
                                    i18 = i17;
                                    i19 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                    i19 = i4;
                                }
                                i20 = i6 & 2048;
                                if (i20 != 0) {
                                    i19 |= 48;
                                    i21 = i20;
                                } else if ((i4 & 48) == 0) {
                                    i21 = i20;
                                    i19 |= startRestartGroup.changed(z3) ? 32 : 16;
                                } else {
                                    i21 = i20;
                                }
                                int i41 = i19;
                                i22 = i6 & 4096;
                                if (i22 != 0) {
                                    i23 = i41 | 384;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & 384) == 0) {
                                        i42 |= startRestartGroup.changed(visualTransformation) ? 256 : 128;
                                    }
                                    i23 = i42;
                                }
                                i24 = i6 & 8192;
                                if (i24 != 0) {
                                    i25 = i23 | 3072;
                                } else {
                                    int i43 = i23;
                                    if ((i4 & 3072) == 0) {
                                        i25 = i43 | (startRestartGroup.changed(keyboardOptions) ? 2048 : 1024);
                                    } else {
                                        i25 = i43;
                                    }
                                }
                                i26 = i6 & 16384;
                                if (i26 != 0) {
                                    i27 = i25 | 24576;
                                } else {
                                    i27 = i25;
                                    if ((i4 & 24576) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 16384 : 8192;
                                        i28 = i6 & 32768;
                                        if (i28 == 0) {
                                            i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                            i27 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                                        }
                                        if ((i4 & 1572864) == 0) {
                                            i27 |= ((i6 & 65536) == 0 && startRestartGroup.changed(i)) ? 1048576 : 524288;
                                        }
                                        i29 = i6 & 131072;
                                        if (i29 == 0) {
                                            i27 |= 12582912;
                                        } else if ((i4 & 12582912) == 0) {
                                            i27 |= startRestartGroup.changed(i2) ? 8388608 : 4194304;
                                        }
                                        i30 = i6 & 262144;
                                        if (i30 == 0) {
                                            i27 |= 100663296;
                                        } else if ((i4 & 100663296) == 0) {
                                            i27 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                            i27 |= ((i6 & 524288) == 0 && startRestartGroup.changed(shape)) ? 536870912 : 268435456;
                                        }
                                        if ((i5 & 6) != 0) {
                                            i31 = i5 | (((i6 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                        } else {
                                            i31 = i5;
                                        }
                                        if ((i7 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i31 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                if (i8 != 0) {
                                                    modifier2 = Modifier.INSTANCE;
                                                }
                                                if (i9 != 0) {
                                                    z5 = true;
                                                }
                                                if (i10 != 0) {
                                                    z6 = false;
                                                }
                                                if ((i6 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i7 &= -458753;
                                                }
                                                if (i11 != 0) {
                                                    function26 = null;
                                                }
                                                if (i12 != 0) {
                                                    function27 = null;
                                                }
                                                Function2 function218 = i14 == 0 ? null : function23;
                                                Function2 function219 = i16 == 0 ? null : function24;
                                                Function2 function220 = i18 == 0 ? function25 : null;
                                                boolean z15 = i21 == 0 ? false : z3;
                                                VisualTransformation none = i22 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i24 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                KeyboardActions keyboardActions4 = i26 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                                boolean z16 = i28 == 0 ? false : z4;
                                                if ((i6 & 65536) == 0) {
                                                    i32 = z16 ? 1 : Integer.MAX_VALUE;
                                                    i27 &= -3670017;
                                                } else {
                                                    i32 = i;
                                                }
                                                int i44 = i29 == 0 ? i2 : 1;
                                                if (i30 == 0) {
                                                    startRestartGroup.startReplaceableGroup(-1263318290);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    i33 = i44;
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                    startRestartGroup.endReplaceableGroup();
                                                } else {
                                                    i33 = i44;
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i6 & 524288) == 0) {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                    i27 &= -1879048193;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = shape;
                                                }
                                                Shape shape5 = shape2;
                                                if ((i6 & 1048576) == 0) {
                                                    i31 &= -15;
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, i34);
                                                } else {
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = textFieldColors;
                                                }
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                function29 = function218;
                                                function210 = function219;
                                                i36 = i27;
                                                z8 = z15;
                                                z9 = z16;
                                                visualTransformation2 = none;
                                                i37 = i32;
                                                i38 = i33;
                                                keyboardActions2 = keyboardActions4;
                                                z10 = z5;
                                                keyboardOptions2 = keyboardOptions4;
                                                function211 = function220;
                                                function212 = function27;
                                                modifier3 = modifier2;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i6 & 32) != 0) {
                                                    i7 &= -458753;
                                                }
                                                if ((i6 & 65536) != 0) {
                                                    i27 &= -3670017;
                                                }
                                                if ((i6 & 524288) != 0) {
                                                    i27 &= -1879048193;
                                                }
                                                if ((i6 & 1048576) != 0) {
                                                    i31 &= -15;
                                                }
                                                function210 = function24;
                                                function211 = function25;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions2 = keyboardActions;
                                                z9 = z4;
                                                i37 = i;
                                                i38 = i2;
                                                mutableInteractionSource4 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                function212 = function27;
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                modifier3 = modifier2;
                                                i36 = i27;
                                                function29 = function23;
                                                z8 = z3;
                                                z10 = z5;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1523846136, i35, i36, "androidx.compose.material3.TextField (TextField.kt:469)");
                                            }
                                            int i45 = i35 & 2147483646;
                                            int i46 = i36 << 6;
                                            int i47 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                            composer2 = startRestartGroup;
                                            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45, (i46 & 896) | 54 | (i46 & 7168) | (57344 & i46) | (458752 & i46) | (3670016 & i46) | (29360128 & i46) | (234881024 & i46) | (i46 & 1879048192), i47, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z10;
                                            z12 = z7;
                                            textStyle4 = textStyle3;
                                            function213 = function28;
                                            function214 = function212;
                                            function215 = function29;
                                            function216 = function210;
                                            function217 = function211;
                                            z13 = z8;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions3 = keyboardActions2;
                                            z14 = z9;
                                            i39 = i37;
                                            i40 = i38;
                                            mutableInteractionSource5 = mutableInteractionSource4;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            function217 = function25;
                                            visualTransformation3 = visualTransformation;
                                            keyboardActions3 = keyboardActions;
                                            z14 = z4;
                                            i39 = i;
                                            i40 = i2;
                                            mutableInteractionSource5 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            function214 = function27;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function213 = function26;
                                            modifier4 = modifier2;
                                            function215 = function23;
                                            function216 = function24;
                                            z13 = z3;
                                            keyboardOptions3 = keyboardOptions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$10
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

                                                public final void invoke(Composer composer3, int i48) {
                                                    TextFieldKt.TextField(TextFieldValue.this, function1, modifier4, z11, z12, textStyle4, function213, function214, function215, function216, function217, z13, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i39, i40, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i28 = i6 & 32768;
                                if (i28 == 0) {
                                }
                                if ((i4 & 1572864) == 0) {
                                }
                                i29 = i6 & 131072;
                                if (i29 == 0) {
                                }
                                i30 = i6 & 262144;
                                if (i30 == 0) {
                                }
                                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                }
                                if ((i5 & 6) != 0) {
                                }
                                if ((i7 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if ((i6 & 32) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                if (i28 == 0) {
                                }
                                if ((i6 & 65536) == 0) {
                                }
                                if (i29 == 0) {
                                }
                                if (i30 == 0) {
                                }
                                if ((i6 & 524288) == 0) {
                                }
                                Shape shape52 = shape2;
                                if ((i6 & 1048576) == 0) {
                                }
                                i35 = i7;
                                z7 = z6;
                                textStyle3 = textStyle2;
                                function28 = function26;
                                function29 = function218;
                                function210 = function219;
                                i36 = i27;
                                z8 = z15;
                                z9 = z16;
                                visualTransformation2 = none;
                                i37 = i32;
                                i38 = i33;
                                keyboardActions2 = keyboardActions4;
                                z10 = z5;
                                keyboardOptions2 = keyboardOptions4;
                                function211 = function220;
                                function212 = function27;
                                modifier3 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i452 = i35 & 2147483646;
                                int i462 = i36 << 6;
                                int i472 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                composer2 = startRestartGroup;
                                TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452, (i462 & 896) | 54 | (i462 & 7168) | (57344 & i462) | (458752 & i462) | (3670016 & i462) | (29360128 & i462) | (234881024 & i462) | (i462 & 1879048192), i472, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                z11 = z10;
                                z12 = z7;
                                textStyle4 = textStyle3;
                                function213 = function28;
                                function214 = function212;
                                function215 = function29;
                                function216 = function210;
                                function217 = function211;
                                z13 = z8;
                                visualTransformation3 = visualTransformation2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                z14 = z9;
                                i39 = i37;
                                i40 = i38;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                shape4 = shape3;
                                textFieldColors3 = textFieldColors2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i6 & 1024;
                            if (i17 != 0) {
                            }
                            i20 = i6 & 2048;
                            if (i20 != 0) {
                            }
                            int i412 = i19;
                            i22 = i6 & 4096;
                            if (i22 != 0) {
                            }
                            i24 = i6 & 8192;
                            if (i24 != 0) {
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                            }
                            i28 = i6 & 32768;
                            if (i28 == 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            i29 = i6 & 131072;
                            if (i29 == 0) {
                            }
                            i30 = i6 & 262144;
                            if (i30 == 0) {
                            }
                            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                            }
                            if ((i5 & 6) != 0) {
                            }
                            if ((i7 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i6 & 65536) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i30 == 0) {
                            }
                            if ((i6 & 524288) == 0) {
                            }
                            Shape shape522 = shape2;
                            if ((i6 & 1048576) == 0) {
                            }
                            i35 = i7;
                            z7 = z6;
                            textStyle3 = textStyle2;
                            function28 = function26;
                            function29 = function218;
                            function210 = function219;
                            i36 = i27;
                            z8 = z15;
                            z9 = z16;
                            visualTransformation2 = none;
                            i37 = i32;
                            i38 = i33;
                            keyboardActions2 = keyboardActions4;
                            z10 = z5;
                            keyboardOptions2 = keyboardOptions4;
                            function211 = function220;
                            function212 = function27;
                            modifier3 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i4522 = i35 & 2147483646;
                            int i4622 = i36 << 6;
                            int i4722 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                            composer2 = startRestartGroup;
                            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522, (i4622 & 896) | 54 | (i4622 & 7168) | (57344 & i4622) | (458752 & i4622) | (3670016 & i4622) | (29360128 & i4622) | (234881024 & i4622) | (i4622 & 1879048192), i4722, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z10;
                            z12 = z7;
                            textStyle4 = textStyle3;
                            function213 = function28;
                            function214 = function212;
                            function215 = function29;
                            function216 = function210;
                            function217 = function211;
                            z13 = z8;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            z14 = z9;
                            i39 = i37;
                            i40 = i38;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i6 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i6 & 1024;
                        if (i17 != 0) {
                        }
                        i20 = i6 & 2048;
                        if (i20 != 0) {
                        }
                        int i4122 = i19;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 == 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        i29 = i6 & 131072;
                        if (i29 == 0) {
                        }
                        i30 = i6 & 262144;
                        if (i30 == 0) {
                        }
                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                        }
                        if ((i5 & 6) != 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if ((i6 & 65536) == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i30 == 0) {
                        }
                        if ((i6 & 524288) == 0) {
                        }
                        Shape shape5222 = shape2;
                        if ((i6 & 1048576) == 0) {
                        }
                        i35 = i7;
                        z7 = z6;
                        textStyle3 = textStyle2;
                        function28 = function26;
                        function29 = function218;
                        function210 = function219;
                        i36 = i27;
                        z8 = z15;
                        z9 = z16;
                        visualTransformation2 = none;
                        i37 = i32;
                        i38 = i33;
                        keyboardActions2 = keyboardActions4;
                        z10 = z5;
                        keyboardOptions2 = keyboardOptions4;
                        function211 = function220;
                        function212 = function27;
                        modifier3 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i45222 = i35 & 2147483646;
                        int i46222 = i36 << 6;
                        int i47222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                        composer2 = startRestartGroup;
                        TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222, (i46222 & 896) | 54 | (i46222 & 7168) | (57344 & i46222) | (458752 & i46222) | (3670016 & i46222) | (29360128 & i46222) | (234881024 & i46222) | (i46222 & 1879048192), i47222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z10;
                        z12 = z7;
                        textStyle4 = textStyle3;
                        function213 = function28;
                        function214 = function212;
                        function215 = function29;
                        function216 = function210;
                        function217 = function211;
                        z13 = z8;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions3 = keyboardActions2;
                        z14 = z9;
                        i39 = i37;
                        i40 = i38;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z6 = z2;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 1024;
                    if (i17 != 0) {
                    }
                    i20 = i6 & 2048;
                    if (i20 != 0) {
                    }
                    int i41222 = i19;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 == 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    i29 = i6 & 131072;
                    if (i29 == 0) {
                    }
                    i30 = i6 & 262144;
                    if (i30 == 0) {
                    }
                    if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                    }
                    if ((i5 & 6) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i6 & 65536) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i30 == 0) {
                    }
                    if ((i6 & 524288) == 0) {
                    }
                    Shape shape52222 = shape2;
                    if ((i6 & 1048576) == 0) {
                    }
                    i35 = i7;
                    z7 = z6;
                    textStyle3 = textStyle2;
                    function28 = function26;
                    function29 = function218;
                    function210 = function219;
                    i36 = i27;
                    z8 = z15;
                    z9 = z16;
                    visualTransformation2 = none;
                    i37 = i32;
                    i38 = i33;
                    keyboardActions2 = keyboardActions4;
                    z10 = z5;
                    keyboardOptions2 = keyboardOptions4;
                    function211 = function220;
                    function212 = function27;
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i452222 = i35 & 2147483646;
                    int i462222 = i36 << 6;
                    int i472222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                    composer2 = startRestartGroup;
                    TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222, (i462222 & 896) | 54 | (i462222 & 7168) | (57344 & i462222) | (458752 & i462222) | (3670016 & i462222) | (29360128 & i462222) | (234881024 & i462222) | (i462222 & 1879048192), i472222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z10;
                    z12 = z7;
                    textStyle4 = textStyle3;
                    function213 = function28;
                    function214 = function212;
                    function215 = function29;
                    function216 = function210;
                    function217 = function211;
                    z13 = z8;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z14 = z9;
                    i39 = i37;
                    i40 = i38;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                i13 = i6 & 256;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i6 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 != 0) {
                }
                i20 = i6 & 2048;
                if (i20 != 0) {
                }
                int i412222 = i19;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 == 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                i29 = i6 & 131072;
                if (i29 == 0) {
                }
                i30 = i6 & 262144;
                if (i30 == 0) {
                }
                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                }
                if ((i5 & 6) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if (i28 == 0) {
                }
                if ((i6 & 65536) == 0) {
                }
                if (i29 == 0) {
                }
                if (i30 == 0) {
                }
                if ((i6 & 524288) == 0) {
                }
                Shape shape522222 = shape2;
                if ((i6 & 1048576) == 0) {
                }
                i35 = i7;
                z7 = z6;
                textStyle3 = textStyle2;
                function28 = function26;
                function29 = function218;
                function210 = function219;
                i36 = i27;
                z8 = z15;
                z9 = z16;
                visualTransformation2 = none;
                i37 = i32;
                i38 = i33;
                keyboardActions2 = keyboardActions4;
                z10 = z5;
                keyboardOptions2 = keyboardOptions4;
                function211 = function220;
                function212 = function27;
                modifier3 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i4522222 = i35 & 2147483646;
                int i4622222 = i36 << 6;
                int i4722222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                composer2 = startRestartGroup;
                TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522222, (i4622222 & 896) | 54 | (i4622222 & 7168) | (57344 & i4622222) | (458752 & i4622222) | (3670016 & i4622222) | (29360128 & i4622222) | (234881024 & i4622222) | (i4622222 & 1879048192), i4722222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z10;
                z12 = z7;
                textStyle4 = textStyle3;
                function213 = function28;
                function214 = function212;
                function215 = function29;
                function216 = function210;
                function217 = function211;
                z13 = z8;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z14 = z9;
                i39 = i37;
                i40 = i38;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            z5 = z;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i6 & 256;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i6 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i20 = i6 & 2048;
            if (i20 != 0) {
            }
            int i4122222 = i19;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 == 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            i29 = i6 & 131072;
            if (i29 == 0) {
            }
            i30 = i6 & 262144;
            if (i30 == 0) {
            }
            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
            }
            if ((i5 & 6) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i21 == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if (i28 == 0) {
            }
            if ((i6 & 65536) == 0) {
            }
            if (i29 == 0) {
            }
            if (i30 == 0) {
            }
            if ((i6 & 524288) == 0) {
            }
            Shape shape5222222 = shape2;
            if ((i6 & 1048576) == 0) {
            }
            i35 = i7;
            z7 = z6;
            textStyle3 = textStyle2;
            function28 = function26;
            function29 = function218;
            function210 = function219;
            i36 = i27;
            z8 = z15;
            z9 = z16;
            visualTransformation2 = none;
            i37 = i32;
            i38 = i33;
            keyboardActions2 = keyboardActions4;
            z10 = z5;
            keyboardOptions2 = keyboardOptions4;
            function211 = function220;
            function212 = function27;
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i45222222 = i35 & 2147483646;
            int i46222222 = i36 << 6;
            int i47222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
            composer2 = startRestartGroup;
            TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222222, (i46222222 & 896) | 54 | (i46222222 & 7168) | (57344 & i46222222) | (458752 & i46222222) | (3670016 & i46222222) | (29360128 & i46222222) | (234881024 & i46222222) | (i46222222 & 1879048192), i47222222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z10;
            z12 = z7;
            textStyle4 = textStyle3;
            function213 = function28;
            function214 = function212;
            function215 = function29;
            function216 = function210;
            function217 = function211;
            z13 = z8;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z14 = z9;
            i39 = i37;
            i40 = i38;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        z5 = z;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i6 & 256;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i20 = i6 & 2048;
        if (i20 != 0) {
        }
        int i41222222 = i19;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 == 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        i29 = i6 & 131072;
        if (i29 == 0) {
        }
        i30 = i6 & 262144;
        if (i30 == 0) {
        }
        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
        }
        if ((i5 & 6) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i21 == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if (i28 == 0) {
        }
        if ((i6 & 65536) == 0) {
        }
        if (i29 == 0) {
        }
        if (i30 == 0) {
        }
        if ((i6 & 524288) == 0) {
        }
        Shape shape52222222 = shape2;
        if ((i6 & 1048576) == 0) {
        }
        i35 = i7;
        z7 = z6;
        textStyle3 = textStyle2;
        function28 = function26;
        function29 = function218;
        function210 = function219;
        i36 = i27;
        z8 = z15;
        z9 = z16;
        visualTransformation2 = none;
        i37 = i32;
        i38 = i33;
        keyboardActions2 = keyboardActions4;
        z10 = z5;
        keyboardOptions2 = keyboardOptions4;
        function211 = function220;
        function212 = function27;
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i452222222 = i35 & 2147483646;
        int i462222222 = i36 << 6;
        int i472222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
        composer2 = startRestartGroup;
        TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222222, (i462222222 & 896) | 54 | (i462222222 & 7168) | (57344 & i462222222) | (458752 & i462222222) | (3670016 & i462222222) | (29360128 & i462222222) | (234881024 & i462222222) | (i462222222 & 1879048192), i472222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z10;
        z12 = z7;
        textStyle4 = textStyle3;
        function213 = function28;
        function214 = function212;
        function215 = function29;
        function216 = function210;
        function217 = function211;
        z13 = z8;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions3 = keyboardActions2;
        z14 = z9;
        i39 = i37;
        i40 = i38;
        mutableInteractionSource5 = mutableInteractionSource4;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void TextFieldLayout(final Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z, final float f, final Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        float f2;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210 = function2;
        Composer startRestartGroup = composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)517@24891L139,520@25078L7,521@25090L3994:TextField.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function210) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        int i6 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function27) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function28) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        int i7 = i4;
        if ((i6 & 306783379) != 306783378 || (i7 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i6, i7, "androidx.compose.material3.TextFieldLayout (TextField.kt:516)");
            }
            startRestartGroup.startReplaceableGroup(243139239);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextField.kt#9igjgp");
            boolean z2 = ((i6 & 1879048192) == 536870912) | ((234881024 & i6) == 67108864) | ((i7 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -95271730, "C527@25409L11,610@28405L229:TextField.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf(i7 & 14));
            startRestartGroup.startReplaceableGroup(-95271705);
            ComposerKt.sourceInformation(startRestartGroup, "530@25473L269");
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219124385, "C536@25715L9:TextField.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf((i6 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95271370);
            ComposerKt.sourceInformation(startRestartGroup, "540@25809L271");
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219124722, "C546@26052L10:TextField.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i6 >> 15) & 14));
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
            if (function23 != null) {
                i5 = 0;
                calculateStartPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(0)));
            } else {
                i5 = 0;
            }
            float f3 = calculateStartPadding;
            if (function24 != null) {
                calculateEndPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(i5)));
            }
            startRestartGroup.startReplaceableGroup(-95270430);
            ComposerKt.sourceInformation(startRestartGroup, "565@26747L334");
            if (function25 != null) {
                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), f3, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219125725, "C572@27055L8:TextField.kt#uh7d8r");
                function25.invoke(startRestartGroup, Integer.valueOf((i6 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95270031);
            ComposerKt.sourceInformation(startRestartGroup, "576@27146L332");
            if (function26 != null) {
                float f4 = calculateEndPadding;
                Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f4, 0.0f, 10, null);
                f2 = f4;
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default2);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219126122, "C583@27452L8:TextField.kt#uh7d8r");
                function26.invoke(startRestartGroup, Integer.valueOf((i6 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f2 = calculateEndPadding;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95269633);
            ComposerKt.sourceInformation(startRestartGroup, "588@27543L347");
            if (function22 != null) {
                Modifier m883paddingqDBjuR0$default3 = PaddingKt.m883paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Label"), DpKt.m6432lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), f3, 0.0f, f2, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl6 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl6, rememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl6.getInserting() || !Intrinsics.areEqual(m3593constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    m3593constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    m3593constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                modifierMaterializerOf6.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219126551, "C594@27881L7:TextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                f3 = Dp.m6389constructorimpl(0);
            }
            Modifier m883paddingqDBjuR0$default4 = PaddingKt.m883paddingqDBjuR0$default(wrapContentHeight$default, f3, 0.0f, function26 == null ? f2 : Dp.m6389constructorimpl(0), 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(-95268909);
            ComposerKt.sourceInformation(startRestartGroup, "606@28273L105");
            if (function3 != null) {
                function32 = function3;
                function32.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(m883paddingqDBjuR0$default4), startRestartGroup, Integer.valueOf((i6 >> 6) & 112));
            } else {
                function32 = function3;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(m883paddingqDBjuR0$default4);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl7 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl7, rememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl7.getInserting() || !Intrinsics.areEqual(m3593constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m3593constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m3593constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            modifierMaterializerOf7.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219127279, "C616@28609L11:TextField.kt#uh7d8r");
            function210 = function2;
            function210.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(243142996);
            ComposerKt.sourceInformation(startRestartGroup, "621@28746L269");
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2747supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(padding);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl8 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl8, rememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl8.getInserting() || !Intrinsics.areEqual(m3593constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m3593constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m3593constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                modifierMaterializerOf8.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219127671, "C626@29001L12:TextField.kt#uh7d8r");
                function29 = function28;
                function29.invoke(startRestartGroup, Integer.valueOf((i7 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                function29 = function28;
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
            function29 = function28;
            function32 = function3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function32;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextFieldLayout$2
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

                public final void invoke(Composer composer2, int i8) {
                    TextFieldKt.TextFieldLayout(Modifier.this, function210, function22, function33, function23, function24, function25, function26, z, f, function27, function29, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m2778calculateWidthyeHjK3Y(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, i6)) + i2, Constraints.m6347getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2777calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        boolean z = i2 > 0;
        float m6389constructorimpl = Dp.m6389constructorimpl(paddingValues.getTop() + paddingValues.getBottom()) * f2;
        if (z) {
            m6389constructorimpl = MathHelpersKt.lerp(Dp.m6389constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2) * f2, m6389constructorimpl, f);
        }
        return Math.max(Constraints.m6346getMinHeightimpl(j), Math.max(i3, Math.max(i4, MathKt.roundToInt(m6389constructorimpl + MathHelpersKt.lerp(0, i2, f) + ComparisonsKt.maxOf(i, i7, i5, i6, MathHelpersKt.lerp(i2, 0, f))))) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z, int i3, int i4, float f, float f2) {
        int roundToInt;
        Placeable.PlacementScope.m5384place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m6527getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), heightOrZero);
            } else {
                roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt - MathKt.roundToInt((roundToInt - i3) * f), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i4, 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, i4, 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z, float f, PaddingValues paddingValues) {
        Placeable.PlacementScope.m5384place70tqf50$default(placementScope, placeable7, IntOffset.INSTANCE.m6527getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable8);
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable5), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable5) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable) {
        return z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke borderStroke) {
        final float width = borderStroke.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
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

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
