package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aT\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u001c\u0010I\u001a\u00020\b*\u00020\b2\u0006\u00100\u001a\u00020.2\u0006\u0010J\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", FirebaseAnalytics.Param.INDEX, "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m6389constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m6389constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function26, Composer composer, final int i, final int i2, final int i3) {
        final TextFieldType textFieldType2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean changed;
        Object rememberedValue;
        InputPhase inputPhase;
        Function3<InputPhase, Composer, Integer, Color> function3;
        final boolean z4;
        long m5918getColor0d7_KjU;
        long m5918getColor0d7_KjU2;
        Composer composer2;
        final boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)79@3096L105,83@3251L25,100@3861L10,107@4196L4572:TextFieldImpl.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            textFieldType2 = textFieldType;
        } else {
            textFieldType2 = textFieldType;
            if ((i & 14) == 0) {
                i4 = (startRestartGroup.changed(textFieldType2) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            function27 = function2;
            i4 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((57344 & i) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function28 = function23;
            } else {
                function28 = function23;
                if ((i & 458752) == 0) {
                    i4 |= startRestartGroup.changedInstance(function28) ? 131072 : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
                function29 = function24;
            } else {
                function29 = function24;
                if ((i & 3670016) == 0) {
                    i4 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
                }
            }
            i7 = i3 & 128;
            if (i7 == 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                i4 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
            }
            i8 = i3 & 256;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                i9 = i8;
                i4 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                i10 = i3 & 512;
                if (i10 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & 1879048192) == 0) {
                    i11 = i10;
                    i4 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                    i12 = i3 & 1024;
                    if (i12 == 0) {
                        i14 = i2 | 6;
                        i13 = i12;
                    } else if ((i2 & 14) == 0) {
                        i13 = i12;
                        i14 = i2 | (startRestartGroup.changed(z3) ? 4 : 2);
                    } else {
                        i13 = i12;
                        i14 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i14 |= 48;
                    } else if ((i2 & 112) == 0) {
                        i14 |= startRestartGroup.changed(interactionSource) ? 32 : 16;
                    }
                    int i18 = i14;
                    if ((i3 & 4096) == 0) {
                        i18 |= 384;
                    } else if ((i2 & 896) == 0) {
                        i18 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                        if ((i3 & 8192) != 0) {
                            i18 |= 3072;
                        } else if ((i2 & 7168) == 0) {
                            i18 |= startRestartGroup.changed(textFieldColors) ? 2048 : 1024;
                        }
                        i15 = i3 & 16384;
                        if (i15 != 0) {
                            i17 = i18 | 24576;
                        } else {
                            if ((i2 & 57344) == 0) {
                                i16 = i18 | (startRestartGroup.changedInstance(function26) ? 16384 : 8192);
                            } else {
                                i16 = i18;
                            }
                            i17 = i16;
                        }
                        if ((i4 & 1533916891) == 306783378 || (46811 & i17) != 9362 || !startRestartGroup.getSkipping()) {
                            if (i5 != 0) {
                                function28 = null;
                            }
                            if (i6 != 0) {
                                function29 = null;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function214 = i7 != 0 ? null : function25;
                            final boolean z8 = i9 != 0 ? false : z;
                            final boolean z9 = i11 != 0 ? true : z2;
                            final boolean z10 = i13 != 0 ? false : z3;
                            final Function2<? super Composer, ? super Integer, Unit> function215 = i15 != 0 ? null : function26;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-712568069, i4, i17, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
                            }
                            startRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final String text = ((TransformedText) rememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 3) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else {
                                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                            }
                            function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                                    return Color.m4053boximpl(m1835invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                                }

                                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                                public final long m1835invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i19) {
                                    composer3.startReplaceableGroup(697243846);
                                    ComposerKt.sourceInformation(composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(697243846, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                                    }
                                    long m4073unboximpl = TextFieldColors.this.labelColor(z9, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z10, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return m4073unboximpl;
                                }
                            };
                            Typography typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                            TextStyle subtitle1 = typography.getSubtitle1();
                            TextStyle caption = typography.getCaption();
                            final Function2<? super Composer, ? super Integer, Unit> function216 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function217 = function214;
                            z4 = !(Color.m4064equalsimpl0(subtitle1.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()) || Color.m4064equalsimpl0(caption.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) || (!Color.m4064equalsimpl0(subtitle1.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()) && Color.m4064equalsimpl0(caption.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()));
                            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                            startRestartGroup.startReplaceableGroup(2129140935);
                            ComposerKt.sourceInformation(startRestartGroup, "*109@4292L10,110@4384L22");
                            m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getCaption().m5918getColor0d7_KjU();
                            if (z4 && m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m5918getColor0d7_KjU = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                            }
                            long j = m5918getColor0d7_KjU;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(2129141126);
                            ComposerKt.sourceInformation(startRestartGroup, "*112@4483L10,113@4577L22");
                            m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getSubtitle1().m5918getColor0d7_KjU();
                            if (z4 && m5918getColor0d7_KjU2 == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m5918getColor0d7_KjU2 = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                            }
                            long j2 = m5918getColor0d7_KjU2;
                            startRestartGroup.endReplaceableGroup();
                            boolean z11 = function22 != null;
                            final boolean z12 = z9;
                            final Function2<? super Composer, ? super Integer, Unit> function218 = function27;
                            final boolean z13 = z10;
                            Function6<Float, Color, Color, Float, Composer, Integer, Unit> function6 = new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                                /* compiled from: TextFieldImpl.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                public /* synthetic */ class WhenMappings {
                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] iArr = new int[TextFieldType.values().length];
                                        try {
                                            iArr[TextFieldType.Filled.ordinal()] = 1;
                                        } catch (NoSuchFieldError unused) {
                                        }
                                        try {
                                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                                        } catch (NoSuchFieldError unused2) {
                                        }
                                        $EnumSwitchMapping$0 = iArr;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(6);
                                }

                                @Override // kotlin.jvm.functions.Function6
                                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                                    m1833invokeRIQooxk(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-RIQooxk, reason: not valid java name */
                                public final void m1833invokeRIQooxk(float f, long j3, final long j4, final float f2, Composer composer3, int i19) {
                                    int i20;
                                    long j5;
                                    ComposableLambda composableLambda;
                                    ComposableLambda composableLambda2;
                                    final float f3 = f;
                                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                                    if ((i19 & 14) == 0) {
                                        i20 = (composer3.changed(f3) ? 4 : 2) | i19;
                                    } else {
                                        i20 = i19;
                                    }
                                    if ((i19 & 112) == 0) {
                                        j5 = j3;
                                        i20 |= composer3.changed(j5) ? 32 : 16;
                                    } else {
                                        j5 = j3;
                                    }
                                    if ((i19 & 896) == 0) {
                                        i20 |= composer3.changed(j4) ? 256 : 128;
                                    }
                                    if ((i19 & 7168) == 0) {
                                        i20 |= composer3.changed(f2) ? 2048 : 1024;
                                    }
                                    int i21 = i20;
                                    if ((46811 & i21) != 9362 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(341865432, i21, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                                        }
                                        final Function2<Composer, Integer, Unit> function219 = function22;
                                        if (function219 != null) {
                                            final boolean z14 = z4;
                                            final long j6 = j5;
                                            Function2<Composer, Integer, Unit> function220 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                                public final void invoke(Composer composer4, int i22) {
                                                    ComposerKt.sourceInformation(composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                                    if ((i22 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(362863774, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                                        }
                                                        TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f3);
                                                        boolean z15 = z14;
                                                        long j7 = j6;
                                                        if (z15) {
                                                            lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                                        }
                                                        TextFieldImplKt.m1832DecorationeuL9pac(j4, lerp, null, function219, composer4, 384, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            };
                                            f3 = f3;
                                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, function220);
                                        } else {
                                            composableLambda = null;
                                        }
                                        if (function216 == null || text.length() != 0 || f2 <= 0.0f) {
                                            composableLambda2 = null;
                                        } else {
                                            final TextFieldColors textFieldColors2 = textFieldColors;
                                            final boolean z15 = z12;
                                            final Function2<Composer, Integer, Unit> function221 = function216;
                                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                                    invoke(modifier, composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                                    ComposerKt.sourceInformation(composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                                    if ((i22 & 14) == 0) {
                                                        i22 |= composer4.changed(modifier) ? 4 : 2;
                                                    }
                                                    if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                                        }
                                                        Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                        TextFieldColors textFieldColors3 = textFieldColors2;
                                                        boolean z16 = z15;
                                                        Function2<Composer, Integer, Unit> function222 = function221;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                                        TextFieldImplKt.m1832DecorationeuL9pac(textFieldColors3.placeholderColor(z16, composer4, 0).getValue().m4073unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, 0, 4);
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
                                        }
                                        final long m4073unboximpl = textFieldColors.leadingIconColor(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                        final Function2<Composer, Integer, Unit> function222 = function29;
                                        ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                            public final void invoke(Composer composer4, int i22) {
                                                ComposerKt.sourceInformation(composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1505327088, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                                                }
                                                TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl, null, null, function222, composer4, 0, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        final long m4073unboximpl2 = textFieldColors.trailingIconColor(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                        final Function2<Composer, Integer, Unit> function223 = function217;
                                        ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                            public final void invoke(Composer composer4, int i22) {
                                                ComposerKt.sourceInformation(composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1894727196, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                                                }
                                                TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl2, null, null, function223, composer4, 0, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        int i22 = WhenMappings.$EnumSwitchMapping$0[textFieldType2.ordinal()];
                                        if (i22 == 1) {
                                            composer3.startReplaceableGroup(-1083197552);
                                            ComposerKt.sourceInformation(composer3, "163@6763L472");
                                            TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function218, composableLambda, composableLambda2, composableLambda3, composableLambda4, z8, f, paddingValues, composer3, (29360128 & (i21 << 21)) | 6);
                                            composer3.endReplaceableGroup();
                                        } else if (i22 == 2) {
                                            composer3.startReplaceableGroup(-1083197009);
                                            ComposerKt.sourceInformation(composer3, "177@7357L38,187@7757L981");
                                            composer3.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            composer3.endReplaceableGroup();
                                            final MutableState mutableState = (MutableState) rememberedValue2;
                                            final PaddingValues paddingValues2 = paddingValues;
                                            final Function2<Composer, Integer, Unit> function224 = function215;
                                            ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                                public final void invoke(Composer composer4, int i23) {
                                                    ComposerKt.sourceInformation(composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                                    if ((i23 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(139886979, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                                        }
                                                        Modifier m1724outlineCutout12SF9DM = OutlinedTextFieldKt.m1724outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                        Function2<Composer, Integer, Unit> function225 = function224;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1724outlineCutout12SF9DM);
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
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                                        composer4.startReplaceableGroup(1661575907);
                                                        ComposerKt.sourceInformation(composer4, "183@7691L8");
                                                        if (function225 != null) {
                                                            function225.invoke(composer4, 0);
                                                        }
                                                        composer4.endReplaceableGroup();
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
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            Function2<Composer, Integer, Unit> function225 = function218;
                                            ComposableLambda composableLambda6 = composableLambda;
                                            boolean z16 = z8;
                                            composer3.startReplaceableGroup(-1004887033);
                                            boolean changed2 = composer3.changed(f3) | composer3.changed(mutableState);
                                            Object rememberedValue3 = composer3.rememberedValue();
                                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                        m1834invokeuvyYCjk(size.getPackedValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                    public final void m1834invokeuvyYCjk(long j7) {
                                                        float m3891getWidthimpl = Size.m3891getWidthimpl(j7) * f3;
                                                        float m3888getHeightimpl = Size.m3888getHeightimpl(j7) * f3;
                                                        if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                            return;
                                                        }
                                                        mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue3);
                                            }
                                            composer3.endReplaceableGroup();
                                            OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function225, composableLambda2, composableLambda6, composableLambda3, composableLambda4, z16, f3, (Function1) rememberedValue3, composableLambda5, paddingValues, composer3, (29360128 & (i21 << 21)) | 805306374, 0);
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-1083195535);
                                            composer3.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            };
                            Function2<? super Composer, ? super Integer, Unit> function219 = function29;
                            boolean z14 = z8;
                            Function2<? super Composer, ? super Integer, Unit> function220 = function215;
                            composer2 = startRestartGroup;
                            textFieldTransitionScope.m1840TransitionDTcfvLk(inputPhase, j, j2, function3, z11, ComposableLambdaKt.composableLambda(startRestartGroup, 341865432, true, function6), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z12;
                            z6 = z13;
                            function210 = function216;
                            function211 = function219;
                            function212 = function217;
                            z7 = z14;
                            function213 = function220;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function212 = function25;
                            z7 = z;
                            z6 = z3;
                            function213 = function26;
                            composer2 = startRestartGroup;
                            function210 = function28;
                            function211 = function29;
                            z5 = z2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
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
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.this, str, function2, visualTransformation, function22, function210, function211, function212, z7, z5, z6, interactionSource, paddingValues, textFieldColors, function213, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 8192) != 0) {
                    }
                    i15 = i3 & 16384;
                    if (i15 != 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    final String text2 = ((TransformedText) rememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 3) & 14).getValue().booleanValue()) {
                    }
                    function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                            return Color.m4053boximpl(m1835invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                        }

                        /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                        public final long m1835invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i19) {
                            composer3.startReplaceableGroup(697243846);
                            ComposerKt.sourceInformation(composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(697243846, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                            }
                            long m4073unboximpl = TextFieldColors.this.labelColor(z9, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z10, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return m4073unboximpl;
                        }
                    };
                    Typography typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    TextStyle subtitle12 = typography2.getSubtitle1();
                    TextStyle caption2 = typography2.getCaption();
                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function214;
                    if (Color.m4064equalsimpl0(subtitle12.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                    startRestartGroup.startReplaceableGroup(2129140935);
                    ComposerKt.sourceInformation(startRestartGroup, "*109@4292L10,110@4384L22");
                    m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getCaption().m5918getColor0d7_KjU();
                    if (z4) {
                        m5918getColor0d7_KjU = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                    }
                    long j3 = m5918getColor0d7_KjU;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(2129141126);
                    ComposerKt.sourceInformation(startRestartGroup, "*112@4483L10,113@4577L22");
                    m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getSubtitle1().m5918getColor0d7_KjU();
                    if (z4) {
                        m5918getColor0d7_KjU2 = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                    }
                    long j22 = m5918getColor0d7_KjU2;
                    startRestartGroup.endReplaceableGroup();
                    if (function22 != null) {
                    }
                    final boolean z122 = z9;
                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function27;
                    final boolean z132 = z10;
                    Function6<Float, Color, Color, Float, Composer, Integer, Unit> function62 = new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                        /* compiled from: TextFieldImpl.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[TextFieldType.values().length];
                                try {
                                    iArr[TextFieldType.Filled.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(6);
                        }

                        @Override // kotlin.jvm.functions.Function6
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                            m1833invokeRIQooxk(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-RIQooxk, reason: not valid java name */
                        public final void m1833invokeRIQooxk(float f, long j32, final long j4, final float f2, Composer composer3, int i19) {
                            int i20;
                            long j5;
                            ComposableLambda composableLambda;
                            ComposableLambda composableLambda2;
                            final float f3 = f;
                            ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                            if ((i19 & 14) == 0) {
                                i20 = (composer3.changed(f3) ? 4 : 2) | i19;
                            } else {
                                i20 = i19;
                            }
                            if ((i19 & 112) == 0) {
                                j5 = j32;
                                i20 |= composer3.changed(j5) ? 32 : 16;
                            } else {
                                j5 = j32;
                            }
                            if ((i19 & 896) == 0) {
                                i20 |= composer3.changed(j4) ? 256 : 128;
                            }
                            if ((i19 & 7168) == 0) {
                                i20 |= composer3.changed(f2) ? 2048 : 1024;
                            }
                            int i21 = i20;
                            if ((46811 & i21) != 9362 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(341865432, i21, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function2192 = function22;
                                if (function2192 != null) {
                                    final boolean z142 = z4;
                                    final long j6 = j5;
                                    Function2<Composer, Integer, Unit> function2202 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                        public final void invoke(Composer composer4, int i22) {
                                            ComposerKt.sourceInformation(composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                            if ((i22 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(362863774, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                                }
                                                TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f3);
                                                boolean z15 = z142;
                                                long j7 = j6;
                                                if (z15) {
                                                    lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                                }
                                                TextFieldImplKt.m1832DecorationeuL9pac(j4, lerp, null, function2192, composer4, 384, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    };
                                    f3 = f3;
                                    composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, function2202);
                                } else {
                                    composableLambda = null;
                                }
                                if (function2162 == null || text2.length() != 0 || f2 <= 0.0f) {
                                    composableLambda2 = null;
                                } else {
                                    final TextFieldColors textFieldColors2 = textFieldColors;
                                    final boolean z15 = z122;
                                    final Function2<? super Composer, ? super Integer, Unit> function221 = function2162;
                                    composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                            invoke(modifier, composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                            ComposerKt.sourceInformation(composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                            if ((i22 & 14) == 0) {
                                                i22 |= composer4.changed(modifier) ? 4 : 2;
                                            }
                                            if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                TextFieldColors textFieldColors3 = textFieldColors2;
                                                boolean z16 = z15;
                                                Function2<Composer, Integer, Unit> function222 = function221;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                                TextFieldImplKt.m1832DecorationeuL9pac(textFieldColors3.placeholderColor(z16, composer4, 0).getValue().m4073unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, 0, 4);
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
                                }
                                final long m4073unboximpl = textFieldColors.leadingIconColor(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function222 = function29;
                                ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                    public final void invoke(Composer composer4, int i22) {
                                        ComposerKt.sourceInformation(composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                                        if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1505327088, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                                        }
                                        TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl, null, null, function222, composer4, 0, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                final long m4073unboximpl2 = textFieldColors.trailingIconColor(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function223 = function2172;
                                ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                    public final void invoke(Composer composer4, int i22) {
                                        ComposerKt.sourceInformation(composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                                        if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1894727196, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                                        }
                                        TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl2, null, null, function223, composer4, 0, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                int i22 = WhenMappings.$EnumSwitchMapping$0[textFieldType2.ordinal()];
                                if (i22 == 1) {
                                    composer3.startReplaceableGroup(-1083197552);
                                    ComposerKt.sourceInformation(composer3, "163@6763L472");
                                    TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2182, composableLambda, composableLambda2, composableLambda3, composableLambda4, z8, f, paddingValues, composer3, (29360128 & (i21 << 21)) | 6);
                                    composer3.endReplaceableGroup();
                                } else if (i22 == 2) {
                                    composer3.startReplaceableGroup(-1083197009);
                                    ComposerKt.sourceInformation(composer3, "177@7357L38,187@7757L981");
                                    composer3.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function2<? super Composer, ? super Integer, Unit> function224 = function215;
                                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                        public final void invoke(Composer composer4, int i23) {
                                            ComposerKt.sourceInformation(composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                            if ((i23 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(139886979, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                                }
                                                Modifier m1724outlineCutout12SF9DM = OutlinedTextFieldKt.m1724outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                Function2<Composer, Integer, Unit> function225 = function224;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1724outlineCutout12SF9DM);
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
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                                composer4.startReplaceableGroup(1661575907);
                                                ComposerKt.sourceInformation(composer4, "183@7691L8");
                                                if (function225 != null) {
                                                    function225.invoke(composer4, 0);
                                                }
                                                composer4.endReplaceableGroup();
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
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Function2<Composer, Integer, Unit> function225 = function2182;
                                    ComposableLambda composableLambda6 = composableLambda;
                                    boolean z16 = z8;
                                    composer3.startReplaceableGroup(-1004887033);
                                    boolean changed2 = composer3.changed(f3) | composer3.changed(mutableState);
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                m1834invokeuvyYCjk(size.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                            public final void m1834invokeuvyYCjk(long j7) {
                                                float m3891getWidthimpl = Size.m3891getWidthimpl(j7) * f3;
                                                float m3888getHeightimpl = Size.m3888getHeightimpl(j7) * f3;
                                                if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                    return;
                                                }
                                                mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function225, composableLambda2, composableLambda6, composableLambda3, composableLambda4, z16, f3, (Function1) rememberedValue3, composableLambda5, paddingValues, composer3, (29360128 & (i21 << 21)) | 805306374, 0);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-1083195535);
                                    composer3.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    };
                    Function2<? super Composer, ? super Integer, Unit> function2192 = function29;
                    boolean z142 = z8;
                    Function2<? super Composer, ? super Integer, Unit> function2202 = function215;
                    composer2 = startRestartGroup;
                    textFieldTransitionScope2.m1840TransitionDTcfvLk(inputPhase, j3, j22, function3, z11, ComposableLambdaKt.composableLambda(startRestartGroup, 341865432, true, function62), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = z122;
                    z6 = z132;
                    function210 = function2162;
                    function211 = function2192;
                    function212 = function2172;
                    z7 = z142;
                    function213 = function2202;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i11 = i10;
                i12 = i3 & 1024;
                if (i12 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                int i182 = i14;
                if ((i3 & 4096) == 0) {
                }
                if ((i3 & 8192) != 0) {
                }
                i15 = i3 & 16384;
                if (i15 != 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                final String text22 = ((TransformedText) rememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 3) & 14).getValue().booleanValue()) {
                }
                function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                        return Color.m4053boximpl(m1835invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                    }

                    /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                    public final long m1835invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i19) {
                        composer3.startReplaceableGroup(697243846);
                        ComposerKt.sourceInformation(composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(697243846, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                        }
                        long m4073unboximpl = TextFieldColors.this.labelColor(z9, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z10, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                        return m4073unboximpl;
                    }
                };
                Typography typography22 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                TextStyle subtitle122 = typography22.getSubtitle1();
                TextStyle caption22 = typography22.getCaption();
                final Function2<? super Composer, ? super Integer, Unit> function21622 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function21722 = function214;
                if (Color.m4064equalsimpl0(subtitle122.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope22 = TextFieldTransitionScope.INSTANCE;
                startRestartGroup.startReplaceableGroup(2129140935);
                ComposerKt.sourceInformation(startRestartGroup, "*109@4292L10,110@4384L22");
                m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getCaption().m5918getColor0d7_KjU();
                if (z4) {
                }
                long j32 = m5918getColor0d7_KjU;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(2129141126);
                ComposerKt.sourceInformation(startRestartGroup, "*112@4483L10,113@4577L22");
                m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getSubtitle1().m5918getColor0d7_KjU();
                if (z4) {
                }
                long j222 = m5918getColor0d7_KjU2;
                startRestartGroup.endReplaceableGroup();
                if (function22 != null) {
                }
                final boolean z1222 = z9;
                final Function2<? super Composer, ? super Integer, Unit> function21822 = function27;
                final boolean z1322 = z10;
                Function6<Float, Color, Color, Float, Composer, Integer, Unit> function622 = new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                    /* compiled from: TextFieldImpl.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[TextFieldType.values().length];
                            try {
                                iArr[TextFieldType.Filled.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[TextFieldType.Outlined.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(6);
                    }

                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                        m1833invokeRIQooxk(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-RIQooxk, reason: not valid java name */
                    public final void m1833invokeRIQooxk(float f, long j322, final long j4, final float f2, Composer composer3, int i19) {
                        int i20;
                        long j5;
                        ComposableLambda composableLambda;
                        ComposableLambda composableLambda2;
                        final float f3 = f;
                        ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                        if ((i19 & 14) == 0) {
                            i20 = (composer3.changed(f3) ? 4 : 2) | i19;
                        } else {
                            i20 = i19;
                        }
                        if ((i19 & 112) == 0) {
                            j5 = j322;
                            i20 |= composer3.changed(j5) ? 32 : 16;
                        } else {
                            j5 = j322;
                        }
                        if ((i19 & 896) == 0) {
                            i20 |= composer3.changed(j4) ? 256 : 128;
                        }
                        if ((i19 & 7168) == 0) {
                            i20 |= composer3.changed(f2) ? 2048 : 1024;
                        }
                        int i21 = i20;
                        if ((46811 & i21) != 9362 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(341865432, i21, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function21922 = function22;
                            if (function21922 != null) {
                                final boolean z1422 = z4;
                                final long j6 = j5;
                                Function2<Composer, Integer, Unit> function22022 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                    public final void invoke(Composer composer4, int i22) {
                                        ComposerKt.sourceInformation(composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                        if ((i22 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(362863774, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                            }
                                            TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f3);
                                            boolean z15 = z1422;
                                            long j7 = j6;
                                            if (z15) {
                                                lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                            }
                                            TextFieldImplKt.m1832DecorationeuL9pac(j4, lerp, null, function21922, composer4, 384, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                };
                                f3 = f3;
                                composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, function22022);
                            } else {
                                composableLambda = null;
                            }
                            if (function21622 == null || text22.length() != 0 || f2 <= 0.0f) {
                                composableLambda2 = null;
                            } else {
                                final TextFieldColors textFieldColors2 = textFieldColors;
                                final boolean z15 = z1222;
                                final Function2<? super Composer, ? super Integer, Unit> function221 = function21622;
                                composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                        invoke(modifier, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                        ComposerKt.sourceInformation(composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                        if ((i22 & 14) == 0) {
                                            i22 |= composer4.changed(modifier) ? 4 : 2;
                                        }
                                        if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(modifier, f2);
                                            TextFieldColors textFieldColors3 = textFieldColors2;
                                            boolean z16 = z15;
                                            Function2<Composer, Integer, Unit> function222 = function221;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                            TextFieldImplKt.m1832DecorationeuL9pac(textFieldColors3.placeholderColor(z16, composer4, 0).getValue().m4073unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, 0, 4);
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
                            }
                            final long m4073unboximpl = textFieldColors.leadingIconColor(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function222 = function29;
                            ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                public final void invoke(Composer composer4, int i22) {
                                    ComposerKt.sourceInformation(composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                                    if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1505327088, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                                    }
                                    TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl, null, null, function222, composer4, 0, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            final long m4073unboximpl2 = textFieldColors.trailingIconColor(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function223 = function21722;
                            ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                public final void invoke(Composer composer4, int i22) {
                                    ComposerKt.sourceInformation(composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                                    if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1894727196, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                                    }
                                    TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl2, null, null, function223, composer4, 0, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            int i22 = WhenMappings.$EnumSwitchMapping$0[textFieldType2.ordinal()];
                            if (i22 == 1) {
                                composer3.startReplaceableGroup(-1083197552);
                                ComposerKt.sourceInformation(composer3, "163@6763L472");
                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function21822, composableLambda, composableLambda2, composableLambda3, composableLambda4, z8, f, paddingValues, composer3, (29360128 & (i21 << 21)) | 6);
                                composer3.endReplaceableGroup();
                            } else if (i22 == 2) {
                                composer3.startReplaceableGroup(-1083197009);
                                ComposerKt.sourceInformation(composer3, "177@7357L38,187@7757L981");
                                composer3.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function2<? super Composer, ? super Integer, Unit> function224 = function215;
                                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                    public final void invoke(Composer composer4, int i23) {
                                        ComposerKt.sourceInformation(composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                        if ((i23 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(139886979, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                            }
                                            Modifier m1724outlineCutout12SF9DM = OutlinedTextFieldKt.m1724outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                            Function2<Composer, Integer, Unit> function225 = function224;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1724outlineCutout12SF9DM);
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
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                            composer4.startReplaceableGroup(1661575907);
                                            ComposerKt.sourceInformation(composer4, "183@7691L8");
                                            if (function225 != null) {
                                                function225.invoke(composer4, 0);
                                            }
                                            composer4.endReplaceableGroup();
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
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Function2<Composer, Integer, Unit> function225 = function21822;
                                ComposableLambda composableLambda6 = composableLambda;
                                boolean z16 = z8;
                                composer3.startReplaceableGroup(-1004887033);
                                boolean changed2 = composer3.changed(f3) | composer3.changed(mutableState);
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                            m1834invokeuvyYCjk(size.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                        public final void m1834invokeuvyYCjk(long j7) {
                                            float m3891getWidthimpl = Size.m3891getWidthimpl(j7) * f3;
                                            float m3888getHeightimpl = Size.m3888getHeightimpl(j7) * f3;
                                            if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                return;
                                            }
                                            mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function225, composableLambda2, composableLambda6, composableLambda3, composableLambda4, z16, f3, (Function1) rememberedValue3, composableLambda5, paddingValues, composer3, (29360128 & (i21 << 21)) | 805306374, 0);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(-1083195535);
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                };
                Function2<? super Composer, ? super Integer, Unit> function21922 = function29;
                boolean z1422 = z8;
                Function2<? super Composer, ? super Integer, Unit> function22022 = function215;
                composer2 = startRestartGroup;
                textFieldTransitionScope22.m1840TransitionDTcfvLk(inputPhase, j32, j222, function3, z11, ComposableLambdaKt.composableLambda(startRestartGroup, 341865432, true, function622), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z1222;
                z6 = z1322;
                function210 = function21622;
                function211 = function21922;
                function212 = function21722;
                z7 = z1422;
                function213 = function22022;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            i11 = i10;
            i12 = i3 & 1024;
            if (i12 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            int i1822 = i14;
            if ((i3 & 4096) == 0) {
            }
            if ((i3 & 8192) != 0) {
            }
            i15 = i3 & 16384;
            if (i15 != 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            final String text222 = ((TransformedText) rememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 3) & 14).getValue().booleanValue()) {
            }
            function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                    return Color.m4053boximpl(m1835invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                }

                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m1835invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i19) {
                    composer3.startReplaceableGroup(697243846);
                    ComposerKt.sourceInformation(composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    long m4073unboximpl = TextFieldColors.this.labelColor(z9, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z10, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return m4073unboximpl;
                }
            };
            Typography typography222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
            TextStyle subtitle1222 = typography222.getSubtitle1();
            TextStyle caption222 = typography222.getCaption();
            final Function2<? super Composer, ? super Integer, Unit> function216222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function217222 = function214;
            if (Color.m4064equalsimpl0(subtitle1222.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
            }
            TextFieldTransitionScope textFieldTransitionScope222 = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(2129140935);
            ComposerKt.sourceInformation(startRestartGroup, "*109@4292L10,110@4384L22");
            m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getCaption().m5918getColor0d7_KjU();
            if (z4) {
            }
            long j322 = m5918getColor0d7_KjU;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2129141126);
            ComposerKt.sourceInformation(startRestartGroup, "*112@4483L10,113@4577L22");
            m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getSubtitle1().m5918getColor0d7_KjU();
            if (z4) {
            }
            long j2222 = m5918getColor0d7_KjU2;
            startRestartGroup.endReplaceableGroup();
            if (function22 != null) {
            }
            final boolean z12222 = z9;
            final Function2<? super Composer, ? super Integer, Unit> function218222 = function27;
            final boolean z13222 = z10;
            Function6<Float, Color, Color, Float, Composer, Integer, Unit> function6222 = new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                    m1833invokeRIQooxk(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-RIQooxk, reason: not valid java name */
                public final void m1833invokeRIQooxk(float f, long j3222, final long j4, final float f2, Composer composer3, int i19) {
                    int i20;
                    long j5;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    final float f3 = f;
                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                    if ((i19 & 14) == 0) {
                        i20 = (composer3.changed(f3) ? 4 : 2) | i19;
                    } else {
                        i20 = i19;
                    }
                    if ((i19 & 112) == 0) {
                        j5 = j3222;
                        i20 |= composer3.changed(j5) ? 32 : 16;
                    } else {
                        j5 = j3222;
                    }
                    if ((i19 & 896) == 0) {
                        i20 |= composer3.changed(j4) ? 256 : 128;
                    }
                    if ((i19 & 7168) == 0) {
                        i20 |= composer3.changed(f2) ? 2048 : 1024;
                    }
                    int i21 = i20;
                    if ((46811 & i21) != 9362 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(341865432, i21, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function219222 = function22;
                        if (function219222 != null) {
                            final boolean z14222 = z4;
                            final long j6 = j5;
                            Function2<Composer, Integer, Unit> function220222 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                public final void invoke(Composer composer4, int i22) {
                                    ComposerKt.sourceInformation(composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                    if ((i22 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(362863774, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                        }
                                        TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f3);
                                        boolean z15 = z14222;
                                        long j7 = j6;
                                        if (z15) {
                                            lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                        }
                                        TextFieldImplKt.m1832DecorationeuL9pac(j4, lerp, null, function219222, composer4, 384, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            };
                            f3 = f3;
                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, function220222);
                        } else {
                            composableLambda = null;
                        }
                        if (function216222 == null || text222.length() != 0 || f2 <= 0.0f) {
                            composableLambda2 = null;
                        } else {
                            final TextFieldColors textFieldColors2 = textFieldColors;
                            final boolean z15 = z12222;
                            final Function2<? super Composer, ? super Integer, Unit> function221 = function216222;
                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                    invoke(modifier, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                    ComposerKt.sourceInformation(composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                    if ((i22 & 14) == 0) {
                                        i22 |= composer4.changed(modifier) ? 4 : 2;
                                    }
                                    if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(modifier, f2);
                                        TextFieldColors textFieldColors3 = textFieldColors2;
                                        boolean z16 = z15;
                                        Function2<Composer, Integer, Unit> function222 = function221;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                        TextFieldImplKt.m1832DecorationeuL9pac(textFieldColors3.placeholderColor(z16, composer4, 0).getValue().m4073unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, 0, 4);
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
                        }
                        final long m4073unboximpl = textFieldColors.leadingIconColor(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function222 = function29;
                        ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                            public final void invoke(Composer composer4, int i22) {
                                ComposerKt.sourceInformation(composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1505327088, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                                }
                                TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl, null, null, function222, composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        final long m4073unboximpl2 = textFieldColors.trailingIconColor(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function223 = function217222;
                        ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                            public final void invoke(Composer composer4, int i22) {
                                ComposerKt.sourceInformation(composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1894727196, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                                }
                                TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl2, null, null, function223, composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        int i22 = WhenMappings.$EnumSwitchMapping$0[textFieldType2.ordinal()];
                        if (i22 == 1) {
                            composer3.startReplaceableGroup(-1083197552);
                            ComposerKt.sourceInformation(composer3, "163@6763L472");
                            TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function218222, composableLambda, composableLambda2, composableLambda3, composableLambda4, z8, f, paddingValues, composer3, (29360128 & (i21 << 21)) | 6);
                            composer3.endReplaceableGroup();
                        } else if (i22 == 2) {
                            composer3.startReplaceableGroup(-1083197009);
                            ComposerKt.sourceInformation(composer3, "177@7357L38,187@7757L981");
                            composer3.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function2<? super Composer, ? super Integer, Unit> function224 = function215;
                            ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                public final void invoke(Composer composer4, int i23) {
                                    ComposerKt.sourceInformation(composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                    if ((i23 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(139886979, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                        }
                                        Modifier m1724outlineCutout12SF9DM = OutlinedTextFieldKt.m1724outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                        Function2<Composer, Integer, Unit> function225 = function224;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1724outlineCutout12SF9DM);
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
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                        composer4.startReplaceableGroup(1661575907);
                                        ComposerKt.sourceInformation(composer4, "183@7691L8");
                                        if (function225 != null) {
                                            function225.invoke(composer4, 0);
                                        }
                                        composer4.endReplaceableGroup();
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
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Function2<Composer, Integer, Unit> function225 = function218222;
                            ComposableLambda composableLambda6 = composableLambda;
                            boolean z16 = z8;
                            composer3.startReplaceableGroup(-1004887033);
                            boolean changed2 = composer3.changed(f3) | composer3.changed(mutableState);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                        m1834invokeuvyYCjk(size.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                    public final void m1834invokeuvyYCjk(long j7) {
                                        float m3891getWidthimpl = Size.m3891getWidthimpl(j7) * f3;
                                        float m3888getHeightimpl = Size.m3888getHeightimpl(j7) * f3;
                                        if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                            return;
                                        }
                                        mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function225, composableLambda2, composableLambda6, composableLambda3, composableLambda4, z16, f3, (Function1) rememberedValue3, composableLambda5, paddingValues, composer3, (29360128 & (i21 << 21)) | 805306374, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1083195535);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            };
            Function2<? super Composer, ? super Integer, Unit> function219222 = function29;
            boolean z14222 = z8;
            Function2<? super Composer, ? super Integer, Unit> function220222 = function215;
            composer2 = startRestartGroup;
            textFieldTransitionScope222.m1840TransitionDTcfvLk(inputPhase, j322, j2222, function3, z11, ComposableLambdaKt.composableLambda(startRestartGroup, 341865432, true, function6222), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z12222;
            z6 = z13222;
            function210 = function216222;
            function211 = function219222;
            function212 = function217222;
            z7 = z14222;
            function213 = function220222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function27 = function2;
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        i11 = i10;
        i12 = i3 & 1024;
        if (i12 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        int i18222 = i14;
        if ((i3 & 4096) == 0) {
        }
        if ((i3 & 8192) != 0) {
        }
        i15 = i3 & 16384;
        if (i15 != 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        final String text2222 = ((TransformedText) rememberedValue).getText().getText();
        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 3) & 14).getValue().booleanValue()) {
        }
        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                return Color.m4053boximpl(m1835invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
            }

            /* renamed from: invoke-XeAY9LY, reason: not valid java name */
            public final long m1835invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i19) {
                composer3.startReplaceableGroup(697243846);
                ComposerKt.sourceInformation(composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(697243846, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                }
                long m4073unboximpl = TextFieldColors.this.labelColor(z9, inputPhase2 == InputPhase.UnfocusedEmpty ? false : z10, interactionSource, composer3, 0).getValue().m4073unboximpl();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceableGroup();
                return m4073unboximpl;
            }
        };
        Typography typography2222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
        TextStyle subtitle12222 = typography2222.getSubtitle1();
        TextStyle caption2222 = typography2222.getCaption();
        final Function2<? super Composer, ? super Integer, Unit> function2162222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2172222 = function214;
        if (Color.m4064equalsimpl0(subtitle12222.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
        }
        TextFieldTransitionScope textFieldTransitionScope2222 = TextFieldTransitionScope.INSTANCE;
        startRestartGroup.startReplaceableGroup(2129140935);
        ComposerKt.sourceInformation(startRestartGroup, "*109@4292L10,110@4384L22");
        m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getCaption().m5918getColor0d7_KjU();
        if (z4) {
        }
        long j3222 = m5918getColor0d7_KjU;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(2129141126);
        ComposerKt.sourceInformation(startRestartGroup, "*112@4483L10,113@4577L22");
        m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getSubtitle1().m5918getColor0d7_KjU();
        if (z4) {
        }
        long j22222 = m5918getColor0d7_KjU2;
        startRestartGroup.endReplaceableGroup();
        if (function22 != null) {
        }
        final boolean z122222 = z9;
        final Function2<? super Composer, ? super Integer, Unit> function2182222 = function27;
        final boolean z132222 = z10;
        Function6<Float, Color, Color, Float, Composer, Integer, Unit> function62222 = new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

            /* compiled from: TextFieldImpl.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TextFieldType.values().length];
                    try {
                        iArr[TextFieldType.Filled.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(6);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer3, Integer num) {
                m1833invokeRIQooxk(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), composer3, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-RIQooxk, reason: not valid java name */
            public final void m1833invokeRIQooxk(float f, long j32222, final long j4, final float f2, Composer composer3, int i19) {
                int i20;
                long j5;
                ComposableLambda composableLambda;
                ComposableLambda composableLambda2;
                final float f3 = f;
                ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                if ((i19 & 14) == 0) {
                    i20 = (composer3.changed(f3) ? 4 : 2) | i19;
                } else {
                    i20 = i19;
                }
                if ((i19 & 112) == 0) {
                    j5 = j32222;
                    i20 |= composer3.changed(j5) ? 32 : 16;
                } else {
                    j5 = j32222;
                }
                if ((i19 & 896) == 0) {
                    i20 |= composer3.changed(j4) ? 256 : 128;
                }
                if ((i19 & 7168) == 0) {
                    i20 |= composer3.changed(f2) ? 2048 : 1024;
                }
                int i21 = i20;
                if ((46811 & i21) != 9362 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(341865432, i21, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function2192222 = function22;
                    if (function2192222 != null) {
                        final boolean z142222 = z4;
                        final long j6 = j5;
                        Function2<Composer, Integer, Unit> function2202222 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                            public final void invoke(Composer composer4, int i22) {
                                ComposerKt.sourceInformation(composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                if ((i22 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(362863774, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                    }
                                    TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getCaption(), f3);
                                    boolean z15 = z142222;
                                    long j7 = j6;
                                    if (z15) {
                                        lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j7, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                    }
                                    TextFieldImplKt.m1832DecorationeuL9pac(j4, lerp, null, function2192222, composer4, 384, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        };
                        f3 = f3;
                        composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, function2202222);
                    } else {
                        composableLambda = null;
                    }
                    if (function2162222 == null || text2222.length() != 0 || f2 <= 0.0f) {
                        composableLambda2 = null;
                    } else {
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z15 = z122222;
                        final Function2<? super Composer, ? super Integer, Unit> function221 = function2162222;
                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer4, Integer num) {
                                invoke(modifier, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                ComposerKt.sourceInformation(composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                if ((i22 & 14) == 0) {
                                    i22 |= composer4.changed(modifier) ? 4 : 2;
                                }
                                if ((i22 & 91) != 18 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                    }
                                    Modifier alpha = AlphaKt.alpha(modifier, f2);
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    boolean z16 = z15;
                                    Function2<Composer, Integer, Unit> function222 = function221;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                    TextFieldImplKt.m1832DecorationeuL9pac(textFieldColors3.placeholderColor(z16, composer4, 0).getValue().m4073unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function222, composer4, 0, 4);
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
                    }
                    final long m4073unboximpl = textFieldColors.leadingIconColor(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function222 = function29;
                    ComposableLambda composableLambda3 = function222 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                        public final void invoke(Composer composer4, int i22) {
                            ComposerKt.sourceInformation(composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1505327088, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                            }
                            TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl, null, null, function222, composer4, 0, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null;
                    final long m4073unboximpl2 = textFieldColors.trailingIconColor(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function223 = function2172222;
                    ComposableLambda composableLambda4 = function223 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                        public final void invoke(Composer composer4, int i22) {
                            ComposerKt.sourceInformation(composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1894727196, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                            }
                            TextFieldImplKt.m1832DecorationeuL9pac(m4073unboximpl2, null, null, function223, composer4, 0, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null;
                    int i22 = WhenMappings.$EnumSwitchMapping$0[textFieldType2.ordinal()];
                    if (i22 == 1) {
                        composer3.startReplaceableGroup(-1083197552);
                        ComposerKt.sourceInformation(composer3, "163@6763L472");
                        TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2182222, composableLambda, composableLambda2, composableLambda3, composableLambda4, z8, f, paddingValues, composer3, (29360128 & (i21 << 21)) | 6);
                        composer3.endReplaceableGroup();
                    } else if (i22 == 2) {
                        composer3.startReplaceableGroup(-1083197009);
                        ComposerKt.sourceInformation(composer3, "177@7357L38,187@7757L981");
                        composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function2<? super Composer, ? super Integer, Unit> function224 = function215;
                        ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                            public final void invoke(Composer composer4, int i23) {
                                ComposerKt.sourceInformation(composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                if ((i23 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(139886979, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                    }
                                    Modifier m1724outlineCutout12SF9DM = OutlinedTextFieldKt.m1724outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), mutableState.getValue().getPackedValue(), paddingValues2);
                                    Function2<Composer, Integer, Unit> function225 = function224;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1724outlineCutout12SF9DM);
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
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                    composer4.startReplaceableGroup(1661575907);
                                    ComposerKt.sourceInformation(composer4, "183@7691L8");
                                    if (function225 != null) {
                                        function225.invoke(composer4, 0);
                                    }
                                    composer4.endReplaceableGroup();
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
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Function2<Composer, Integer, Unit> function225 = function2182222;
                        ComposableLambda composableLambda6 = composableLambda;
                        boolean z16 = z8;
                        composer3.startReplaceableGroup(-1004887033);
                        boolean changed2 = composer3.changed(f3) | composer3.changed(mutableState);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                    m1834invokeuvyYCjk(size.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                public final void m1834invokeuvyYCjk(long j7) {
                                    float m3891getWidthimpl = Size.m3891getWidthimpl(j7) * f3;
                                    float m3888getHeightimpl = Size.m3888getHeightimpl(j7) * f3;
                                    if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                        return;
                                    }
                                    mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function225, composableLambda2, composableLambda6, composableLambda3, composableLambda4, z16, f3, (Function1) rememberedValue3, composableLambda5, paddingValues, composer3, (29360128 & (i21 << 21)) | 805306374, 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-1083195535);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        };
        Function2<? super Composer, ? super Integer, Unit> function2192222 = function29;
        boolean z142222 = z8;
        Function2<? super Composer, ? super Integer, Unit> function2202222 = function215;
        composer2 = startRestartGroup;
        textFieldTransitionScope2222.m1840TransitionDTcfvLk(inputPhase, j3222, j22222, function3, z11, ComposableLambdaKt.composableLambda(startRestartGroup, 341865432, true, function62222), composer2, 1769472);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z122222;
        z6 = z132222;
        function210 = function2162222;
        function211 = function2192222;
        function212 = function2172222;
        z7 = z142222;
        function213 = function2202222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1832DecorationeuL9pac(final long j, TextStyle textStyle, Float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Float f2;
        Composer startRestartGroup = composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                textStyle = null;
            }
            final Float f3 = i5 == 0 ? f : null;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, i3, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:223)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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
                    ComposerKt.sourceInformation(composer2, "C225@9160L476:TextFieldImpl.kt#jmzs0o");
                    if ((i6 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(494684590, i6, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:225)");
                        }
                        ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j));
                        final Float f4 = f3;
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        final long j2 = j;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer2, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C:TextFieldImpl.kt#jmzs0o");
                                if ((i7 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1132188434, i7, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:226)");
                                    }
                                    if (f4 != null) {
                                        composer3.startReplaceableGroup(-452622690);
                                        ComposerKt.sourceInformation(composer3, "227@9284L142");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(f4), function22, composer3, ProvidedValue.$stable);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(-452622510);
                                        ComposerKt.sourceInformation(composer3, "232@9464L148");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j2))), function22, composer3, ProvidedValue.$stable);
                                        composer3.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (textStyle != null) {
                startRestartGroup.startReplaceableGroup(-2009953423);
                ComposerKt.sourceInformation(startRestartGroup, "239@9671L46");
                TextKt.ProvideTextStyle(textStyle, composableLambda, startRestartGroup, ((i3 >> 3) & 14) | 48);
            } else {
                startRestartGroup.startReplaceableGroup(-2009953371);
                ComposerKt.sourceInformation(startRestartGroup, "239@9723L18");
                composableLambda.invoke(startRestartGroup, 6);
            }
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f3;
        } else {
            startRestartGroup.skipToGroupEnd();
            f2 = f;
        }
        final TextStyle textStyle2 = textStyle;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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
                    TextFieldImplKt.m1832DecorationeuL9pac(j, textStyle2, f2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$defaultErrorSemantics$1
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
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 48;
        IconDefaultSizeModifier = androidx.compose.foundation.layout.SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
