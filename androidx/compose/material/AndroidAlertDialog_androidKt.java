package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01de  */
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1521AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Shape shape2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        long j3;
        long j4;
        int i14;
        long j5;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i15;
        int i16;
        long j6;
        int i17;
        DialogProperties dialogProperties2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Shape shape3;
        final long j7;
        final long j8;
        final DialogProperties dialogProperties3;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i20 = i2 & 4;
        if (i20 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                function25 = function22;
                i3 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    function26 = function23;
                    i3 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i7 = 57344;
                        function27 = function24;
                    } else {
                        i7 = 57344;
                        function27 = function24;
                        if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changedInstance(function27) ? 131072 : 65536;
                        }
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i8 = 458752;
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i19 = 1048576;
                                i3 |= i19;
                            }
                        } else {
                            i8 = 458752;
                            shape2 = shape;
                        }
                        i19 = 524288;
                        i3 |= i19;
                    } else {
                        i8 = 458752;
                        shape2 = shape;
                    }
                    if ((i & 29360128) != 0) {
                        int i21 = i3;
                        if ((i2 & 128) == 0) {
                            i10 = i20;
                            if (startRestartGroup.changed(j)) {
                                i18 = 8388608;
                                i9 = i21 | i18;
                            }
                        } else {
                            i10 = i20;
                        }
                        i18 = 4194304;
                        i9 = i21 | i18;
                    } else {
                        i9 = i3;
                        i10 = i20;
                    }
                    if ((i & 234881024) != 0) {
                        i11 = i10;
                        i9 |= ((i2 & 256) == 0 && startRestartGroup.changed(j2)) ? 67108864 : 33554432;
                    } else {
                        i11 = i10;
                    }
                    i12 = i2 & 512;
                    if (i12 == 0) {
                        i9 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & 1879048192) == 0) {
                        i13 = i12;
                        i9 |= startRestartGroup.changed(dialogProperties) ? 536870912 : 268435456;
                        if ((i9 & 1533916891) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function25 = null;
                                }
                                if (i5 != 0) {
                                    function26 = null;
                                }
                                if (i6 != 0) {
                                    function27 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                    shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                    j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                } else {
                                    j3 = j;
                                }
                                if ((i2 & 256) != 0) {
                                    j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i9 >> 21) & 14);
                                    i9 &= -234881025;
                                } else {
                                    j4 = j2;
                                }
                                if (i13 != 0) {
                                    long j9 = j3;
                                    i14 = 234881024;
                                    j5 = j9;
                                    function28 = function27;
                                    i15 = 29360128;
                                    j6 = j4;
                                    i17 = -606536823;
                                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                                    function29 = function26;
                                    i16 = i9;
                                    Shape shape4 = shape2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i17, i16, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
                                    }
                                    int i22 = (i16 & 14) | 48 | (i16 & 896);
                                    int i23 = i16 >> 3;
                                    int i24 = (i15 & i23) | i22 | (i23 & 7168) | (i23 & i7) | (i23 & i8) | (i23 & 3670016) | (i23 & i14);
                                    composer2 = startRestartGroup;
                                    Modifier modifier4 = modifier2;
                                    m1522AlertDialogwqdebIU(function02, ComposableLambdaKt.composableLambda(startRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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

                                        public final void invoke(Composer composer3, int i25) {
                                            ComposerKt.sourceInformation(composer3, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i25 & 11) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1849673151, i25, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:79)");
                                                }
                                                float f = 8;
                                                Modifier m880paddingVpY3zN4 = PaddingKt.m880paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(2));
                                                final Function2<Composer, Integer, Unit> function213 = function25;
                                                final Function2<Composer, Integer, Unit> function214 = function2;
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m880paddingVpY3zN4);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 350577093, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                                AlertDialogKt.m1520AlertDialogFlowRowixp7dh8(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(12), ComposableLambdaKt.composableLambda(composer3, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                                    public final void invoke(Composer composer4, int i26) {
                                                        ComposerKt.sourceInformation(composer4, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                                        if ((i26 & 11) != 2 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1789213604, i26, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:84)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function215 = function213;
                                                            composer4.startReplaceableGroup(-1046483318);
                                                            ComposerKt.sourceInformation(composer4, "84@4101L8");
                                                            if (function215 != null) {
                                                                function215.invoke(composer4, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            function214.invoke(composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), composer3, 438);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), modifier4, function29, function28, shape4, j5, j6, dialogProperties2, composer2, i24, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function210 = function25;
                                    modifier3 = modifier4;
                                    function211 = function29;
                                    function212 = function28;
                                    shape3 = shape4;
                                    j7 = j5;
                                    j8 = j6;
                                    dialogProperties3 = dialogProperties2;
                                } else {
                                    long j10 = j3;
                                    i14 = 234881024;
                                    j5 = j10;
                                    function28 = function27;
                                    i15 = 29360128;
                                    i16 = i9;
                                    j6 = j4;
                                    i17 = -606536823;
                                    dialogProperties2 = dialogProperties;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i9 &= -234881025;
                                }
                                j6 = j2;
                                dialogProperties2 = dialogProperties;
                                function28 = function27;
                                i15 = 29360128;
                                i16 = i9;
                                i14 = 234881024;
                                i17 = -606536823;
                                j5 = j;
                            }
                            function29 = function26;
                            Shape shape42 = shape2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i222 = (i16 & 14) | 48 | (i16 & 896);
                            int i232 = i16 >> 3;
                            int i242 = (i15 & i232) | i222 | (i232 & 7168) | (i232 & i7) | (i232 & i8) | (i232 & 3670016) | (i232 & i14);
                            composer2 = startRestartGroup;
                            Modifier modifier42 = modifier2;
                            m1522AlertDialogwqdebIU(function02, ComposableLambdaKt.composableLambda(startRestartGroup, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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

                                public final void invoke(Composer composer3, int i25) {
                                    ComposerKt.sourceInformation(composer3, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i25 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1849673151, i25, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:79)");
                                        }
                                        float f = 8;
                                        Modifier m880paddingVpY3zN4 = PaddingKt.m880paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(2));
                                        final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
                                        final Function2<? super Composer, ? super Integer, Unit> function214 = function2;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m880paddingVpY3zN4);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 350577093, "C80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                                        AlertDialogKt.m1520AlertDialogFlowRowixp7dh8(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(12), ComposableLambdaKt.composableLambda(composer3, 1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                                                if ((i26 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1789213604, i26, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:84)");
                                                    }
                                                    Function2<Composer, Integer, Unit> function215 = function213;
                                                    composer4.startReplaceableGroup(-1046483318);
                                                    ComposerKt.sourceInformation(composer4, "84@4101L8");
                                                    if (function215 != null) {
                                                        function215.invoke(composer4, 0);
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    function214.invoke(composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 438);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), modifier42, function29, function28, shape42, j5, j6, dialogProperties2, composer2, i242, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function210 = function25;
                            modifier3 = modifier42;
                            function211 = function29;
                            function212 = function28;
                            shape3 = shape42;
                            j7 = j5;
                            j8 = j6;
                            dialogProperties3 = dialogProperties2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            function210 = function25;
                            function212 = function27;
                            function211 = function26;
                            shape3 = shape2;
                            j7 = j;
                            j8 = j2;
                            dialogProperties3 = dialogProperties;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

                                public final void invoke(Composer composer3, int i25) {
                                    AndroidAlertDialog_androidKt.m1521AlertDialog6oU6zVQ(function0, function2, modifier3, function210, function211, function212, shape3, j7, j8, dialogProperties3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i13 = i12;
                    if ((i9 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if (i13 != 0) {
                    }
                }
                function26 = function23;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) != 0) {
                }
                if ((i & 234881024) != 0) {
                }
                i12 = i2 & 512;
                if (i12 == 0) {
                }
                i13 = i12;
                if ((i9 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if (i13 != 0) {
                }
            }
            function25 = function22;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function26 = function23;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) != 0) {
            }
            if ((i & 234881024) != 0) {
            }
            i12 = i2 & 512;
            if (i12 == 0) {
            }
            i13 = i12;
            if ((i9 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (i13 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function26 = function23;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) != 0) {
        }
        i12 = i2 & 512;
        if (i12 == 0) {
        }
        i13 = i12;
        if ((i9 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (i13 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c6  */
    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1522AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape2;
        long j3;
        int i7;
        int i8;
        int i9;
        int i10;
        long j4;
        DialogProperties dialogProperties2;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape3;
        final long j5;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            function24 = function2;
            i3 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    function25 = function22;
                    i3 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        function26 = function23;
                        i3 |= startRestartGroup.changedInstance(function26) ? 16384 : 8192;
                        if ((458752 & i) == 0) {
                            if ((i2 & 32) == 0) {
                                shape2 = shape;
                                if (startRestartGroup.changed(shape2)) {
                                    i12 = 131072;
                                    i3 |= i12;
                                }
                            } else {
                                shape2 = shape;
                            }
                            i12 = 65536;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        if ((3670016 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                j3 = j;
                                if (startRestartGroup.changed(j3)) {
                                    i11 = 1048576;
                                    i3 |= i11;
                                }
                            } else {
                                j3 = j;
                            }
                            i11 = 524288;
                            i3 |= i11;
                        } else {
                            j3 = j;
                        }
                        if ((i & 29360128) == 0) {
                            i7 = i3 | (((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304);
                        } else {
                            i7 = i3;
                        }
                        int i13 = i7;
                        i8 = i2 & 256;
                        if (i8 != 0) {
                            i10 = i13 | 100663296;
                            i9 = i8;
                        } else if ((i & 234881024) == 0) {
                            i9 = i8;
                            i10 = i13 | (startRestartGroup.changed(dialogProperties) ? 67108864 : 33554432);
                        } else {
                            i9 = i8;
                            i10 = i13;
                        }
                        if ((i10 & 191739611) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function25 = null;
                                }
                                if (i6 != 0) {
                                    function26 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    i10 &= -458753;
                                    shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 64) != 0) {
                                    j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    i10 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i10 >> 18) & 14);
                                    i10 &= -29360129;
                                } else {
                                    j4 = j2;
                                }
                                if (i9 != 0) {
                                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                                    int i14 = i10;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1035523925, i14, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                                    final Modifier modifier4 = modifier2;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function26;
                                    final Shape shape4 = shape2;
                                    final long j6 = j3;
                                    final long j7 = j4;
                                    DialogProperties dialogProperties4 = dialogProperties2;
                                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                                            ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                                            if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                                                }
                                                AlertDialogKt.m1519AlertDialogContentWMdw5o4(function28, modifier4, function29, function210, shape4, j6, j7, composer3, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, ((i14 >> 21) & 112) | (i14 & 14) | 384, 0);
                                    composer2 = startRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    function27 = function26;
                                    shape3 = shape2;
                                    j5 = j4;
                                    dialogProperties3 = dialogProperties4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i10 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                }
                                j4 = j2;
                            }
                            dialogProperties2 = dialogProperties;
                            int i142 = i10;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                            final Modifier modifier42 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function292 = function25;
                            final Function2<? super Composer, ? super Integer, Unit> function2102 = function26;
                            final Shape shape42 = shape2;
                            final long j62 = j3;
                            final long j72 = j4;
                            DialogProperties dialogProperties42 = dialogProperties2;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties42, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                                    ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                                    if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                                        }
                                        AlertDialogKt.m1519AlertDialogContentWMdw5o4(function282, modifier42, function292, function2102, shape42, j62, j72, composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, ((i142 >> 21) & 112) | (i142 & 14) | 384, 0);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            function27 = function26;
                            shape3 = shape2;
                            j5 = j4;
                            dialogProperties3 = dialogProperties42;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            function27 = function26;
                            shape3 = shape2;
                            j5 = j2;
                            dialogProperties3 = dialogProperties;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                        final long j8 = j3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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
                                    AndroidAlertDialog_androidKt.m1522AlertDialogwqdebIU(function0, function2, modifier3, function211, function27, shape3, j8, j5, dialogProperties3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function26 = function23;
                    if ((458752 & i) == 0) {
                    }
                    if ((3670016 & i) == 0) {
                    }
                    if ((i & 29360128) == 0) {
                    }
                    int i132 = i7;
                    i8 = i2 & 256;
                    if (i8 != 0) {
                    }
                    if ((i10 & 191739611) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    dialogProperties2 = dialogProperties;
                    int i1422 = i10;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
                    final Modifier modifier422 = modifier2;
                    final Function2<? super Composer, ? super Integer, Unit> function2922 = function25;
                    final Function2<? super Composer, ? super Integer, Unit> function21022 = function26;
                    final Shape shape422 = shape2;
                    final long j622 = j3;
                    final long j722 = j4;
                    DialogProperties dialogProperties422 = dialogProperties2;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties422, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                            ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                            if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                                }
                                AlertDialogKt.m1519AlertDialogContentWMdw5o4(function2822, modifier422, function2922, function21022, shape422, j622, j722, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, ((i1422 >> 21) & 112) | (i1422 & 14) | 384, 0);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    function27 = function26;
                    shape3 = shape2;
                    j5 = j4;
                    dialogProperties3 = dialogProperties422;
                    final Function2<? super Composer, ? super Integer, Unit> function2112 = function25;
                    final long j82 = j3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function25 = function22;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function26 = function23;
                if ((458752 & i) == 0) {
                }
                if ((3670016 & i) == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                int i1322 = i7;
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                if ((i10 & 191739611) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i9 != 0) {
                }
                dialogProperties2 = dialogProperties;
                int i14222 = i10;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function28222 = function24;
                final Modifier modifier4222 = modifier2;
                final Function2<? super Composer, ? super Integer, Unit> function29222 = function25;
                final Function2<? super Composer, ? super Integer, Unit> function210222 = function26;
                final Shape shape4222 = shape2;
                final long j6222 = j3;
                final long j7222 = j4;
                DialogProperties dialogProperties4222 = dialogProperties2;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties4222, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                        ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                        if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                            }
                            AlertDialogKt.m1519AlertDialogContentWMdw5o4(function28222, modifier4222, function29222, function210222, shape4222, j6222, j7222, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i14222 >> 21) & 112) | (i14222 & 14) | 384, 0);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                function27 = function26;
                shape3 = shape2;
                j5 = j4;
                dialogProperties3 = dialogProperties4222;
                final Function2<? super Composer, ? super Integer, Unit> function21122 = function25;
                final long j822 = j3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function25 = function22;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function26 = function23;
            if ((458752 & i) == 0) {
            }
            if ((3670016 & i) == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            int i13222 = i7;
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            if ((i10 & 191739611) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i9 != 0) {
            }
            dialogProperties2 = dialogProperties;
            int i142222 = i10;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function282222 = function24;
            final Modifier modifier42222 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function292222 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function2102222 = function26;
            final Shape shape42222 = shape2;
            final long j62222 = j3;
            final long j72222 = j4;
            DialogProperties dialogProperties42222 = dialogProperties2;
            AndroidDialog_androidKt.Dialog(function0, dialogProperties42222, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                        }
                        AlertDialogKt.m1519AlertDialogContentWMdw5o4(function282222, modifier42222, function292222, function2102222, shape42222, j62222, j72222, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, ((i142222 >> 21) & 112) | (i142222 & 14) | 384, 0);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            function27 = function26;
            shape3 = shape2;
            j5 = j4;
            dialogProperties3 = dialogProperties42222;
            final Function2<? super Composer, ? super Integer, Unit> function211222 = function25;
            final long j8222 = j3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function24 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function25 = function22;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function26 = function23;
        if ((458752 & i) == 0) {
        }
        if ((3670016 & i) == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        int i132222 = i7;
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        if ((i10 & 191739611) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i9 != 0) {
        }
        dialogProperties2 = dialogProperties;
        int i1422222 = i10;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function2822222 = function24;
        final Modifier modifier422222 = modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function2922222 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function21022222 = function26;
        final Shape shape422222 = shape2;
        final long j622222 = j3;
        final long j722222 = j4;
        DialogProperties dialogProperties422222 = dialogProperties2;
        AndroidDialog_androidKt.Dialog(function0, dialogProperties422222, ComposableLambdaKt.composableLambda(startRestartGroup, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                ComposerKt.sourceInformation(composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1787418772, i15, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                    }
                    AlertDialogKt.m1519AlertDialogContentWMdw5o4(function2822222, modifier422222, function2922222, function21022222, shape422222, j622222, j722222, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, ((i1422222 >> 21) & 112) | (i1422222 & 14) | 384, 0);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        function27 = function26;
        shape3 = shape2;
        j5 = j4;
        dialogProperties3 = dialogProperties422222;
        final Function2<? super Composer, ? super Integer, Unit> function2112222 = function25;
        final long j82222 = j3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
