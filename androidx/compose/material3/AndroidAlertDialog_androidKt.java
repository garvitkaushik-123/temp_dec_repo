package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aß\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\u001aB\u0010\u001e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = Dp.m6389constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.m6389constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e5  */
    /* renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1881AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape2;
        int i10;
        long j5;
        int i11;
        int i12;
        int i13;
        Function2<? super Composer, ? super Integer, Unit> function210;
        long j6;
        long j7;
        long j8;
        long j9;
        float m1876getTonalElevationD9Ej5fM;
        DialogProperties dialogProperties2;
        final long j10;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Shape shape3;
        final long j11;
        final long j12;
        final float f2;
        final Modifier modifier3;
        final long j13;
        final DialogProperties dialogProperties3;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final long j14;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)85@4239L5,86@4294L14,87@4360L16,88@4429L17,89@4498L16,92@4635L1119:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            function26 = function2;
            i4 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function27 = function23;
                        i4 |= startRestartGroup.changedInstance(function27) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function28 = function24;
                        } else {
                            function28 = function24;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= startRestartGroup.changedInstance(function28) ? 131072 : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                            function29 = function25;
                        } else {
                            function29 = function25;
                            if ((i & 1572864) == 0) {
                                i4 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
                            }
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0) {
                                shape2 = shape;
                                if (startRestartGroup.changed(shape2)) {
                                    i14 = 8388608;
                                    i4 |= i14;
                                }
                            } else {
                                shape2 = shape;
                            }
                            i14 = 4194304;
                            i4 |= i14;
                        } else {
                            shape2 = shape;
                        }
                        if ((i & 100663296) == 0) {
                            i4 |= ((i3 & 256) == 0 && startRestartGroup.changed(j)) ? 67108864 : 33554432;
                        }
                        if ((805306368 & i) == 0) {
                            i4 |= ((i3 & 512) == 0 && startRestartGroup.changed(j2)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (((i3 & 1024) == 0 && startRestartGroup.changed(j3)) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            j5 = j4;
                            i10 |= ((i3 & 2048) == 0 && startRestartGroup.changed(j5)) ? 32 : 16;
                        } else {
                            j5 = j4;
                        }
                        i11 = i3 & 4096;
                        if (i11 != 0) {
                            i10 |= 384;
                        } else if ((i2 & 384) == 0) {
                            i10 |= startRestartGroup.changed(f) ? 256 : 128;
                            i12 = i3 & 8192;
                            if (i12 == 0) {
                                i10 |= 3072;
                                i13 = i12;
                            } else {
                                i13 = i12;
                                if ((i2 & 3072) == 0) {
                                    i10 |= startRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                                    if ((i4 & 306783379) != 306783378 && (i10 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                                        startRestartGroup.skipToGroupEnd();
                                        f2 = f;
                                        dialogProperties3 = dialogProperties;
                                        composer2 = startRestartGroup;
                                        shape3 = shape2;
                                        modifier3 = modifier2;
                                        function212 = function22;
                                        j12 = j3;
                                        j13 = j5;
                                        function213 = function27;
                                        function211 = function28;
                                        function214 = function29;
                                        j11 = j;
                                        j14 = j2;
                                    } else {
                                        startRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i5 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            function210 = i6 != 0 ? null : function22;
                                            if (i7 != 0) {
                                                function27 = null;
                                            }
                                            if (i8 != 0) {
                                                function28 = null;
                                            }
                                            if (i9 != 0) {
                                                function29 = null;
                                            }
                                            if ((i3 & 128) != 0) {
                                                i4 &= -29360129;
                                                shape2 = AlertDialogDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                            }
                                            if ((i3 & 256) != 0) {
                                                j6 = AlertDialogDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                                i4 &= -234881025;
                                            } else {
                                                j6 = j;
                                            }
                                            if ((i3 & 512) != 0) {
                                                j7 = AlertDialogDefaults.INSTANCE.getIconContentColor(startRestartGroup, 6);
                                                i4 = (-1879048193) & i4;
                                            } else {
                                                j7 = j2;
                                            }
                                            if ((i3 & 1024) != 0) {
                                                j8 = AlertDialogDefaults.INSTANCE.getTitleContentColor(startRestartGroup, 6);
                                                i10 &= -15;
                                            } else {
                                                j8 = j3;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                j9 = AlertDialogDefaults.INSTANCE.getTextContentColor(startRestartGroup, 6);
                                                i10 &= -113;
                                            } else {
                                                j9 = j5;
                                            }
                                            m1876getTonalElevationD9Ej5fM = i11 != 0 ? AlertDialogDefaults.INSTANCE.m1876getTonalElevationD9Ej5fM() : f;
                                            if (i13 != 0) {
                                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    j10 = j9;
                                                } else {
                                                    j10 = j9;
                                                    ComposerKt.traceEventStart(-2081346864, i4, i10, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:92)");
                                                }
                                                final float f3 = m1876getTonalElevationD9Ej5fM;
                                                final Function2<? super Composer, ? super Integer, Unit> function215 = function27;
                                                final Function2<? super Composer, ? super Integer, Unit> function216 = function26;
                                                final Function2<? super Composer, ? super Integer, Unit> function217 = function28;
                                                final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                                final Function2<? super Composer, ? super Integer, Unit> function219 = function210;
                                                final Shape shape4 = shape2;
                                                final long j15 = j6;
                                                final long j16 = j7;
                                                final long j17 = j8;
                                                long j18 = j10;
                                                BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                                                    public final void invoke(Composer composer3, int i15) {
                                                        ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                                            }
                                                            final Function2<Composer, Integer, Unit> function220 = function219;
                                                            final Function2<Composer, Integer, Unit> function221 = function216;
                                                            AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                                                public final void invoke(Composer composer4, int i16) {
                                                                    float f4;
                                                                    float f5;
                                                                    ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                                                    if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                                        }
                                                                        f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                                        f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                                        final Function2<Composer, Integer, Unit> function222 = function220;
                                                                        final Function2<Composer, Integer, Unit> function223 = function221;
                                                                        AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                                                            public final void invoke(Composer composer5, int i17) {
                                                                                ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                                                if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                                                    }
                                                                                    Function2<Composer, Integer, Unit> function224 = function222;
                                                                                    composer5.startReplaceableGroup(-1969500671);
                                                                                    ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                                                    if (function224 != null) {
                                                                                        function224.invoke(composer5, 0);
                                                                                        Unit unit = Unit.INSTANCE;
                                                                                    }
                                                                                    composer5.endReplaceableGroup();
                                                                                    function223.invoke(composer5, 0);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                composer5.skipToGroupEnd();
                                                                            }
                                                                        }), composer4, 438);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), null, function215, function217, function218, shape4, j15, f3, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j16, j17, j10, composer3, 6, 0, 2);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                                                composer2 = startRestartGroup;
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                function211 = function28;
                                                function212 = function210;
                                                shape3 = shape2;
                                                j11 = j6;
                                                j12 = j8;
                                                f2 = m1876getTonalElevationD9Ej5fM;
                                                modifier3 = modifier2;
                                                j13 = j18;
                                                long j19 = j7;
                                                dialogProperties3 = dialogProperties2;
                                                function213 = function27;
                                                function214 = function29;
                                                j14 = j19;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i3 & 128) != 0) {
                                                i4 &= -29360129;
                                            }
                                            if ((i3 & 256) != 0) {
                                                i4 &= -234881025;
                                            }
                                            if ((i3 & 512) != 0) {
                                                i4 &= -1879048193;
                                            }
                                            if ((i3 & 1024) != 0) {
                                                i10 &= -15;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                i10 &= -113;
                                            }
                                            function210 = function22;
                                            j6 = j;
                                            j7 = j2;
                                            j8 = j3;
                                            m1876getTonalElevationD9Ej5fM = f;
                                            j9 = j5;
                                        }
                                        dialogProperties2 = dialogProperties;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        final float f32 = m1876getTonalElevationD9Ej5fM;
                                        final Function2<? super Composer, ? super Integer, Unit> function2152 = function27;
                                        final Function2<? super Composer, ? super Integer, Unit> function2162 = function26;
                                        final Function2<? super Composer, ? super Integer, Unit> function2172 = function28;
                                        final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                                        final Function2<? super Composer, ? super Integer, Unit> function2192 = function210;
                                        final Shape shape42 = shape2;
                                        final long j152 = j6;
                                        final long j162 = j7;
                                        final long j172 = j8;
                                        long j182 = j10;
                                        BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                                            public final void invoke(Composer composer3, int i15) {
                                                ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                                if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                                    }
                                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2192;
                                                    final Function2<? super Composer, ? super Integer, Unit> function221 = function2162;
                                                    AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                                        public final void invoke(Composer composer4, int i16) {
                                                            float f4;
                                                            float f5;
                                                            ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                                            if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                                }
                                                                f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                                f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                                final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                                final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                                                AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                                                    public final void invoke(Composer composer5, int i17) {
                                                                        ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                                        if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                                            }
                                                                            Function2<Composer, Integer, Unit> function224 = function222;
                                                                            composer5.startReplaceableGroup(-1969500671);
                                                                            ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                                            if (function224 != null) {
                                                                                function224.invoke(composer5, 0);
                                                                                Unit unit = Unit.INSTANCE;
                                                                            }
                                                                            composer5.endReplaceableGroup();
                                                                            function223.invoke(composer5, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }), composer4, 438);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), null, function2152, function2172, function2182, shape42, j152, f32, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j162, j172, j10, composer3, 6, 0, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                                        composer2 = startRestartGroup;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        function211 = function28;
                                        function212 = function210;
                                        shape3 = shape2;
                                        j11 = j6;
                                        j12 = j8;
                                        f2 = m1876getTonalElevationD9Ej5fM;
                                        modifier3 = modifier2;
                                        j13 = j182;
                                        long j192 = j7;
                                        dialogProperties3 = dialogProperties2;
                                        function213 = function27;
                                        function214 = function29;
                                        j14 = j192;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$2
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

                                            public final void invoke(Composer composer3, int i15) {
                                                AndroidAlertDialog_androidKt.m1881AlertDialogOix01E0(function0, function2, modifier3, function212, function213, function211, function214, shape3, j11, j14, j12, j13, f2, dialogProperties3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if ((i4 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i3 & 128) != 0) {
                            }
                            if ((i3 & 256) != 0) {
                            }
                            if ((i3 & 512) != 0) {
                            }
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i3 & 2048) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            dialogProperties2 = dialogProperties;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final float f322 = m1876getTonalElevationD9Ej5fM;
                            final Function2<? super Composer, ? super Integer, Unit> function21522 = function27;
                            final Function2<? super Composer, ? super Integer, Unit> function21622 = function26;
                            final Function2<? super Composer, ? super Integer, Unit> function21722 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            final Function2<? super Composer, ? super Integer, Unit> function21922 = function210;
                            final Shape shape422 = shape2;
                            final long j1522 = j6;
                            final long j1622 = j7;
                            final long j1722 = j8;
                            long j1822 = j10;
                            BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                                public final void invoke(Composer composer3, int i15) {
                                    ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                    if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function21922;
                                        final Function2<? super Composer, ? super Integer, Unit> function221 = function21622;
                                        AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                            public final void invoke(Composer composer4, int i16) {
                                                float f4;
                                                float f5;
                                                ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                                if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                    }
                                                    f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                    f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                    final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                                    AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                                        public final void invoke(Composer composer5, int i17) {
                                                            ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                            if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                                }
                                                                Function2<Composer, Integer, Unit> function224 = function222;
                                                                composer5.startReplaceableGroup(-1969500671);
                                                                ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                                if (function224 != null) {
                                                                    function224.invoke(composer5, 0);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                function223.invoke(composer5, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, 438);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), null, function21522, function21722, function21822, shape422, j1522, f322, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j1622, j1722, j10, composer3, 6, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function211 = function28;
                            function212 = function210;
                            shape3 = shape2;
                            j11 = j6;
                            j12 = j8;
                            f2 = m1876getTonalElevationD9Ej5fM;
                            modifier3 = modifier2;
                            j13 = j1822;
                            long j1922 = j7;
                            dialogProperties3 = dialogProperties2;
                            function213 = function27;
                            function214 = function29;
                            j14 = j1922;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i12 = i3 & 8192;
                        if (i12 == 0) {
                        }
                        if ((i4 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i3 & 128) != 0) {
                        }
                        if ((i3 & 256) != 0) {
                        }
                        if ((i3 & 512) != 0) {
                        }
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        dialogProperties2 = dialogProperties;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final float f3222 = m1876getTonalElevationD9Ej5fM;
                        final Function2<? super Composer, ? super Integer, Unit> function215222 = function27;
                        final Function2<? super Composer, ? super Integer, Unit> function216222 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function217222 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                        final Function2<? super Composer, ? super Integer, Unit> function219222 = function210;
                        final Shape shape4222 = shape2;
                        final long j15222 = j6;
                        final long j16222 = j7;
                        final long j17222 = j8;
                        long j18222 = j10;
                        BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                            public final void invoke(Composer composer3, int i15) {
                                ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function219222;
                                    final Function2<? super Composer, ? super Integer, Unit> function221 = function216222;
                                    AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                        public final void invoke(Composer composer4, int i16) {
                                            float f4;
                                            float f5;
                                            ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                            if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                }
                                                f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                                AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                                    public final void invoke(Composer composer5, int i17) {
                                                        ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                        if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function224 = function222;
                                                            composer5.startReplaceableGroup(-1969500671);
                                                            ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                            if (function224 != null) {
                                                                function224.invoke(composer5, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            function223.invoke(composer5, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 438);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), null, function215222, function217222, function218222, shape4222, j15222, f3222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j16222, j17222, j10, composer3, 6, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function211 = function28;
                        function212 = function210;
                        shape3 = shape2;
                        j11 = j6;
                        j12 = j8;
                        f2 = m1876getTonalElevationD9Ej5fM;
                        modifier3 = modifier2;
                        j13 = j18222;
                        long j19222 = j7;
                        dialogProperties3 = dialogProperties2;
                        function213 = function27;
                        function214 = function29;
                        j14 = j19222;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function27 = function23;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((805306368 & i) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    i11 = i3 & 4096;
                    if (i11 != 0) {
                    }
                    i12 = i3 & 8192;
                    if (i12 == 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    dialogProperties2 = dialogProperties;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final float f32222 = m1876getTonalElevationD9Ej5fM;
                    final Function2<? super Composer, ? super Integer, Unit> function2152222 = function27;
                    final Function2<? super Composer, ? super Integer, Unit> function2162222 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function2172222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                    final Function2<? super Composer, ? super Integer, Unit> function2192222 = function210;
                    final Shape shape42222 = shape2;
                    final long j152222 = j6;
                    final long j162222 = j7;
                    final long j172222 = j8;
                    long j182222 = j10;
                    BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                        public final void invoke(Composer composer3, int i15) {
                            ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function220 = function2192222;
                                final Function2<? super Composer, ? super Integer, Unit> function221 = function2162222;
                                AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                    public final void invoke(Composer composer4, int i16) {
                                        float f4;
                                        float f5;
                                        ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                        if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                            }
                                            f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                            f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                            final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                            final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                            AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                                public final void invoke(Composer composer5, int i17) {
                                                    ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                    if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                        }
                                                        Function2<Composer, Integer, Unit> function224 = function222;
                                                        composer5.startReplaceableGroup(-1969500671);
                                                        ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                        if (function224 != null) {
                                                            function224.invoke(composer5, 0);
                                                            Unit unit = Unit.INSTANCE;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        function223.invoke(composer5, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 438);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), null, function2152222, function2172222, function2182222, shape42222, j152222, f32222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j162222, j172222, j10, composer3, 6, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function211 = function28;
                    function212 = function210;
                    shape3 = shape2;
                    j11 = j6;
                    j12 = j8;
                    f2 = m1876getTonalElevationD9Ej5fM;
                    modifier3 = modifier2;
                    j13 = j182222;
                    long j192222 = j7;
                    dialogProperties3 = dialogProperties2;
                    function213 = function27;
                    function214 = function29;
                    j14 = j192222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                function27 = function23;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((805306368 & i) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i11 = i3 & 4096;
                if (i11 != 0) {
                }
                i12 = i3 & 8192;
                if (i12 == 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                dialogProperties2 = dialogProperties;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float f322222 = m1876getTonalElevationD9Ej5fM;
                final Function2<? super Composer, ? super Integer, Unit> function21522222 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function21622222 = function26;
                final Function2<? super Composer, ? super Integer, Unit> function21722222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
                final Function2<? super Composer, ? super Integer, Unit> function21922222 = function210;
                final Shape shape422222 = shape2;
                final long j1522222 = j6;
                final long j1622222 = j7;
                final long j1722222 = j8;
                long j1822222 = j10;
                BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                    public final void invoke(Composer composer3, int i15) {
                        ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function220 = function21922222;
                            final Function2<? super Composer, ? super Integer, Unit> function221 = function21622222;
                            AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                                public final void invoke(Composer composer4, int i16) {
                                    float f4;
                                    float f5;
                                    ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                        }
                                        f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                        f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                        final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                        final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                        AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                            public final void invoke(Composer composer5, int i17) {
                                                ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                    }
                                                    Function2<Composer, Integer, Unit> function224 = function222;
                                                    composer5.startReplaceableGroup(-1969500671);
                                                    ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                    if (function224 != null) {
                                                        function224.invoke(composer5, 0);
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    function223.invoke(composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 438);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), null, function21522222, function21722222, function21822222, shape422222, j1522222, f322222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j1622222, j1722222, j10, composer3, 6, 0, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                function211 = function28;
                function212 = function210;
                shape3 = shape2;
                j11 = j6;
                j12 = j8;
                f2 = m1876getTonalElevationD9Ej5fM;
                modifier3 = modifier2;
                j13 = j1822222;
                long j1922222 = j7;
                dialogProperties3 = dialogProperties2;
                function213 = function27;
                function214 = function29;
                j14 = j1922222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            function27 = function23;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((805306368 & i) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i11 = i3 & 4096;
            if (i11 != 0) {
            }
            i12 = i3 & 8192;
            if (i12 == 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            dialogProperties2 = dialogProperties;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final float f3222222 = m1876getTonalElevationD9Ej5fM;
            final Function2<? super Composer, ? super Integer, Unit> function215222222 = function27;
            final Function2<? super Composer, ? super Integer, Unit> function216222222 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function217222222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
            final Function2<? super Composer, ? super Integer, Unit> function219222222 = function210;
            final Shape shape4222222 = shape2;
            final long j15222222 = j6;
            final long j16222222 = j7;
            final long j17222222 = j8;
            long j18222222 = j10;
            BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

                public final void invoke(Composer composer3, int i15) {
                    ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                    if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function220 = function219222222;
                        final Function2<? super Composer, ? super Integer, Unit> function221 = function216222222;
                        AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                            public final void invoke(Composer composer4, int i16) {
                                float f4;
                                float f5;
                                ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                    }
                                    f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                    f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                    final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                    final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                    AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                        public final void invoke(Composer composer5, int i17) {
                                            ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                            if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                }
                                                Function2<Composer, Integer, Unit> function224 = function222;
                                                composer5.startReplaceableGroup(-1969500671);
                                                ComposerKt.sourceInformation(composer5, "103@4991L8");
                                                if (function224 != null) {
                                                    function224.invoke(composer5, 0);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer5.endReplaceableGroup();
                                                function223.invoke(composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 438);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), null, function215222222, function217222222, function218222222, shape4222222, j15222222, f3222222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j16222222, j17222222, j10, composer3, 6, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            function211 = function28;
            function212 = function210;
            shape3 = shape2;
            j11 = j6;
            j12 = j8;
            f2 = m1876getTonalElevationD9Ej5fM;
            modifier3 = modifier2;
            j13 = j18222222;
            long j19222222 = j7;
            dialogProperties3 = dialogProperties2;
            function213 = function27;
            function214 = function29;
            j14 = j19222222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function26 = function2;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        function27 = function23;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((805306368 & i) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i11 = i3 & 4096;
        if (i11 != 0) {
        }
        i12 = i3 & 8192;
        if (i12 == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        dialogProperties2 = dialogProperties;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float f32222222 = m1876getTonalElevationD9Ej5fM;
        final Function2<? super Composer, ? super Integer, Unit> function2152222222 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function2162222222 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function2172222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2182222222 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function2192222222 = function210;
        final Shape shape42222222 = shape2;
        final long j152222222 = j6;
        final long j162222222 = j7;
        final long j172222222 = j8;
        long j182222222 = j10;
        BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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

            public final void invoke(Composer composer3, int i15) {
                ComposerKt.sourceInformation(composer3, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2192222222;
                    final Function2<? super Composer, ? super Integer, Unit> function221 = function2162222222;
                    AlertDialogKt.m1877AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer3, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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

                        public final void invoke(Composer composer4, int i16) {
                            float f4;
                            float f5;
                            ComposerKt.sourceInformation(composer4, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                }
                                f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                final Function2<? super Composer, ? super Integer, Unit> function223 = function221;
                                AlertDialogKt.m1878AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer4, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                    public final void invoke(Composer composer5, int i17) {
                                        ComposerKt.sourceInformation(composer5, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                        if ((i17 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                            }
                                            Function2<Composer, Integer, Unit> function224 = function222;
                                            composer5.startReplaceableGroup(-1969500671);
                                            ComposerKt.sourceInformation(composer5, "103@4991L8");
                                            if (function224 != null) {
                                                function224.invoke(composer5, 0);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer5.endReplaceableGroup();
                                            function223.invoke(composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, 438);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), null, function2152222222, function2172222222, function2182222222, shape42222222, j152222222, f32222222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), j162222222, j172222222, j10, composer3, 6, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        function211 = function28;
        function212 = function210;
        shape3 = shape2;
        j11 = j6;
        j12 = j8;
        f2 = m1876getTonalElevationD9Ej5fM;
        modifier3 = modifier2;
        j13 = j182222222;
        long j192222222 = j7;
        dialogProperties3 = dialogProperties2;
        function213 = function27;
        function214 = function29;
        j14 = j192222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-543157267);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicAlertDialog)P(2,1,3)156@7271L452:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= startRestartGroup.changed(dialogProperties2) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    final Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    DialogProperties dialogProperties4 = i4 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543157267, i3, -1, "androidx.compose.material3.BasicAlertDialog (AndroidAlertDialog.android.kt:155)");
                    }
                    AndroidDialog_androidKt.Dialog(function02, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
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
                            ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                                }
                                Strings.Companion companion2 = Strings.INSTANCE;
                                final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dialog), composer2, 0);
                                Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                composer2.startReplaceableGroup(-874813489);
                                ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                                boolean changed = composer2.changed(m2623getStringNWtq28);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                Modifier then = m932sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue, 1, null));
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    dialogProperties3 = dialogProperties4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$2
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
                            AndroidAlertDialog_androidKt.BasicAlertDialog(function0, modifier3, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
            }
            if ((i3 & 1171) == 1170) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            AndroidDialog_androidKt.Dialog(function02, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
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
                    ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                        }
                        Strings.Companion companion2 = Strings.INSTANCE;
                        final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dialog), composer2, 0);
                        Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        composer2.startReplaceableGroup(-874813489);
                        ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                        boolean changed = composer2.changed(m2623getStringNWtq28);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
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
                                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        Modifier then = m932sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue, 1, null));
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
            dialogProperties3 = dialogProperties4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AndroidDialog_androidKt.Dialog(function02, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
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
                ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                    }
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dialog), composer2, 0);
                    Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    composer2.startReplaceableGroup(-874813489);
                    ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                    boolean changed = composer2.changed(m2623getStringNWtq28);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    Modifier then = m932sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue, 1, null));
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        dialogProperties3 = dialogProperties4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0051  */
    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(2,1,3)209@9397L65:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= startRestartGroup.changed(dialogProperties2) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                    function22 = function2;
                } else {
                    function22 = function2;
                    if ((i & 3072) == 0) {
                        i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    }
                }
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    DialogProperties dialogProperties4 = i4 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:209)");
                    }
                    Modifier modifier4 = companion;
                    BasicAlertDialog(function02, modifier4, dialogProperties4, function22, startRestartGroup, i3 & 8190, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    dialogProperties3 = dialogProperties4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$3
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
                            AndroidAlertDialog_androidKt.AlertDialog(function0, modifier3, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
            }
            if ((i3 & 1171) == 1170) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier42 = companion;
            BasicAlertDialog(function02, modifier42, dialogProperties4, function22, startRestartGroup, i3 & 8190, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
            dialogProperties3 = dialogProperties4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier422 = companion;
        BasicAlertDialog(function02, modifier422, dialogProperties4, function22, startRestartGroup, i3 & 8190, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422;
        dialogProperties3 = dialogProperties4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
