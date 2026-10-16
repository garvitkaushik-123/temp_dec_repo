package androidx.compose.material3;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u001e\u001a0\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010!\u001a\u00020\"H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a-\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\"2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0\u0018H\u0007¢\u0006\u0002\u0010)\u001a\f\u0010*\u001a\u00020\"*\u00020+H\u0002\u001a\u001c\u0010,\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0003\u001a\u0014\u0010/\u001a\u00020\"*\u0002002\u0006\u00101\u001a\u00020\"H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062²\u0006\n\u00103\u001a\u00020.X\u008a\u0084\u0002²\u0006\u0015\u00104\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetPopup", "(Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", VastAttributes.VISIBLE, "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "isFlagSecureEnabled", "Landroid/view/View;", "modalBottomSheetAnchors", "fullHeight", "", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "alpha", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheet_androidKt {

    /* compiled from: ModalBottomSheet.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c9  */
    /* renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2328ModalBottomSheetdYc4hso(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, ModalBottomSheetProperties modalBottomSheetProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final SheetState sheetState2;
        int i5;
        Shape shape2;
        long j4;
        int i6;
        final long j5;
        int i7;
        float f3;
        int i8;
        int i9;
        int i10;
        int i11;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        int i12;
        int i13;
        long j6;
        long j7;
        float f4;
        final WindowInsets windowInsets2;
        int i14;
        final float f5;
        ModalBottomSheetProperties modalBottomSheetProperties2;
        final Modifier modifier2;
        final long j8;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Shape shape3;
        final long j9;
        final float f6;
        final long j10;
        int i15;
        boolean changed;
        Object rememberedValue;
        Object rememberedValue2;
        boolean changedInstance;
        Object rememberedValue3;
        boolean changedInstance2;
        Object rememberedValue4;
        boolean changedInstance3;
        Object rememberedValue5;
        Composer composer2;
        final ModalBottomSheetProperties modalBottomSheetProperties3;
        final SheetState sheetState3;
        final long j11;
        final Modifier modifier3;
        final float f7;
        final Shape shape4;
        final long j12;
        final float f8;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(944867294);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)139@6724L31,141@6855L13,142@6918L14,143@6960L31,145@7093L10,147@7240L12,152@7505L7,153@7528L44,153@7517L55,156@7589L24,157@7653L277,166@7984L143,174@8216L350,172@8133L5284,280@13492L41,280@13465L68:ModalBottomSheet.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i22 = i3 & 2;
        if (i22 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    sheetState2 = sheetState;
                    if (startRestartGroup.changed(sheetState2)) {
                        i21 = 256;
                        i4 |= i21;
                    }
                } else {
                    sheetState2 = sheetState;
                }
                i21 = 128;
                i4 |= i21;
            } else {
                sheetState2 = sheetState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i20 = 16384;
                            i4 |= i20;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i20 = 8192;
                    i4 |= i20;
                } else {
                    shape2 = shape;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    j4 = j;
                    i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                } else {
                    j4 = j;
                }
                if ((i & 1572864) == 0) {
                    i6 = i22;
                    j5 = j2;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                } else {
                    i6 = i22;
                    j5 = j2;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    f3 = f2;
                } else {
                    f3 = f2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changed(f3) ? 8388608 : 4194304;
                    }
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        i18 = i4;
                        if (startRestartGroup.changed(j3)) {
                            i19 = 67108864;
                            i8 = i18 | i19;
                        }
                    } else {
                        i18 = i4;
                    }
                    i19 = 33554432;
                    i8 = i18 | i19;
                } else {
                    i8 = i4;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i8 |= C.ENCODING_PCM_32BIT;
                } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                    i10 = i9;
                    i8 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(windowInsets)) {
                            i17 = 4;
                            i11 = i2 | i17;
                        }
                        i17 = 2;
                        i11 = i2 | i17;
                    } else {
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(modalBottomSheetProperties)) {
                            i16 = 32;
                            i11 |= i16;
                        }
                        i16 = 16;
                        i11 |= i16;
                    }
                    int i23 = i11;
                    if ((i3 & 4096) == 0) {
                        i23 |= 384;
                    } else if ((i2 & 384) == 0) {
                        function32 = function3;
                        i23 |= startRestartGroup.changedInstance(function32) ? 256 : 128;
                        if ((306783379 & i8) == 306783378 || (i23 & 147) != 146 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    i12 = i23;
                                    sheetState2 = rememberModalBottomSheetState(false, null, startRestartGroup, 0, 3);
                                    i8 &= -897;
                                } else {
                                    i12 = i23;
                                }
                                float m1905getSheetMaxWidthD9Ej5fM = i5 != 0 ? BottomSheetDefaults.INSTANCE.m1905getSheetMaxWidthD9Ej5fM() : f;
                                if ((i3 & 16) != 0) {
                                    i13 = 6;
                                    shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                    i8 &= -57345;
                                } else {
                                    i13 = 6;
                                }
                                if ((i3 & 32) != 0) {
                                    j4 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, i13);
                                    i8 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    j6 = ColorSchemeKt.m2049contentColorForek8zF_U(j4, startRestartGroup, (i8 >> 15) & 14);
                                    i8 &= -3670017;
                                } else {
                                    j6 = j5;
                                }
                                if (i7 != 0) {
                                    f3 = BottomSheetDefaults.INSTANCE.m1904getElevationD9Ej5fM();
                                }
                                if ((i3 & 256) != 0) {
                                    j7 = BottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i8 &= -234881025;
                                } else {
                                    j7 = j3;
                                }
                                Function2<? super Composer, ? super Integer, Unit> m2082getLambda1$material3_release = i10 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m2082getLambda1$material3_release() : function2;
                                if ((i3 & 1024) != 0) {
                                    f4 = m1905getSheetMaxWidthD9Ej5fM;
                                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i14 = i12 & (-15);
                                } else {
                                    f4 = m1905getSheetMaxWidthD9Ej5fM;
                                    windowInsets2 = windowInsets;
                                    i14 = i12;
                                }
                                int i24 = i14;
                                if ((i3 & 2048) != 0) {
                                    modalBottomSheetProperties2 = ModalBottomSheetDefaults.properties$default(ModalBottomSheetDefaults.INSTANCE, null, false, false, 7, null);
                                    f5 = f4;
                                    modifier2 = companion;
                                    j8 = j6;
                                    function22 = m2082getLambda1$material3_release;
                                    shape3 = shape2;
                                    j9 = j4;
                                    f6 = f3;
                                    i15 = i24 & (-113);
                                    j10 = j7;
                                } else {
                                    f5 = f4;
                                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                                    modifier2 = companion;
                                    j8 = j6;
                                    function22 = m2082getLambda1$material3_release;
                                    shape3 = shape2;
                                    j9 = j4;
                                    f6 = f3;
                                    j10 = j7;
                                    i15 = i24;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i8 &= -897;
                                }
                                if ((i3 & 16) != 0) {
                                    i8 &= -57345;
                                }
                                if ((i3 & 32) != 0) {
                                    i8 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i8 &= -3670017;
                                }
                                if ((i3 & 256) != 0) {
                                    i8 &= -234881025;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                }
                                if ((i3 & 2048) != 0) {
                                    i23 &= -113;
                                }
                                modifier2 = modifier;
                                f5 = f;
                                j10 = j3;
                                function22 = function2;
                                windowInsets2 = windowInsets;
                                i15 = i23;
                                j8 = j5;
                                shape3 = shape2;
                                j9 = j4;
                                f6 = f3;
                                modalBottomSheetProperties2 = modalBottomSheetProperties;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(944867294, i8, i15, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:150)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density = (Density) consume;
                            startRestartGroup.startReplaceableGroup(-203430466);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                            int i25 = (i8 & 896) ^ 384;
                            changed = ((i25 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changed(density);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        SheetState.this.setDensity$material3_release(density);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-203430341);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                            int i26 = i8 & 14;
                            changedInstance = (i26 == 4) | ((i25 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* compiled from: ModalBottomSheet.android.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ SheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = sheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$sheetState.hide(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        Job launch$default;
                                        if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                            final SheetState sheetState4 = SheetState.this;
                                            final Function0<Unit> function02 = function0;
                                            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                                    invoke2(th);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Throwable th) {
                                                    if (SheetState.this.isVisible()) {
                                                        return;
                                                    }
                                                    function02.invoke();
                                                }
                                            });
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            final Function0 function02 = (Function0) rememberedValue3;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-203430010);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                            changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | ((i25 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | (i26 == 4);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* compiled from: ModalBottomSheet.android.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ float $it;
                                        final /* synthetic */ SheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = sheetState;
                                            this.$it = f;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, this.$it, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                                        invoke(f9.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f9) {
                                        Job launch$default;
                                        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState2, f9, null), 3, null);
                                        final SheetState sheetState4 = sheetState2;
                                        final Function0<Unit> function03 = function0;
                                        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                                invoke2(th);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Throwable th) {
                                                if (SheetState.this.isVisible()) {
                                                    return;
                                                }
                                                function03.invoke();
                                            }
                                        });
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            final Function1 function1 = (Function1) rememberedValue4;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-203429778);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                            changedInstance3 = ((i25 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope) | (i26 == 4);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* compiled from: ModalBottomSheet.android.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ SheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = sheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        Job launch$default;
                                        if (SheetState.this.getCurrentValue() != SheetValue.Expanded || !SheetState.this.getHasPartiallyExpandedState()) {
                                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(SheetState.this, null), 3, null);
                                            final Function0<Unit> function03 = function0;
                                            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                                    invoke2(th);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Throwable th) {
                                                    function03.invoke();
                                                }
                                            });
                                            return;
                                        }
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                    }

                                    /* compiled from: ModalBottomSheet.android.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", f = "ModalBottomSheet.android.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2, reason: invalid class name */
                                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ SheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass2(SheetState sheetState, Continuation<? super AnonymousClass2> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = sheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass2(this.$sheetState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$sheetState.hide(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                            final SheetState sheetState4 = sheetState2;
                            ModalBottomSheetProperties modalBottomSheetProperties4 = modalBottomSheetProperties2;
                            ModalBottomSheetPopup(modalBottomSheetProperties4, (Function0) rememberedValue5, windowInsets2, ComposableLambdaKt.composableLambda(startRestartGroup, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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

                                public final void invoke(Composer composer3, int i27) {
                                    ComposerKt.sourceInformation(composer3, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                                    if ((i27 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1311525899, i27, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                                        }
                                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        final long j13 = j10;
                                        final Function0<Unit> function03 = function02;
                                        final SheetState sheetState5 = sheetState4;
                                        final Modifier modifier4 = modifier2;
                                        final float f9 = f5;
                                        final Function1<Float, Unit> function12 = function1;
                                        final Shape shape5 = shape3;
                                        final long j14 = j9;
                                        final long j15 = j8;
                                        final float f10 = f6;
                                        final Function2<Composer, Integer, Unit> function24 = function22;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final Function3<ColumnScope, Composer, Integer, Unit> function34 = function33;
                                        BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer3, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, Integer num) {
                                                invoke(boxWithConstraintsScope, composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, int i28) {
                                                int i29;
                                                Modifier modalBottomSheetAnchors;
                                                ComposerKt.sourceInformation(composer4, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                                                if ((i28 & 6) == 0) {
                                                    i29 = i28 | (composer4.changed(boxWithConstraintsScope) ? 4 : 2);
                                                } else {
                                                    i29 = i28;
                                                }
                                                if ((i29 & 19) != 18 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2008499679, i29, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                                    }
                                                    int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                                    ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j13, function03, sheetState5.getTargetValue() != SheetValue.Hidden, composer4, 0);
                                                    Strings.Companion companion2 = Strings.INSTANCE;
                                                    final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_pane_title), composer4, 0);
                                                    Modifier align = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, f9, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                                    composer4.startReplaceableGroup(-1482644208);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                    boolean changed2 = composer4.changed(m2623getStringNWtq28);
                                                    Object rememberedValue6 = composer4.rememberedValue();
                                                    if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
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
                                                        composer4.updateRememberedValue(rememberedValue6);
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    Modifier semantics$default = SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue6, 1, null);
                                                    composer4.startReplaceableGroup(-1482644143);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                    boolean changed3 = composer4.changed(sheetState5);
                                                    final SheetState sheetState6 = sheetState5;
                                                    Object rememberedValue7 = composer4.rememberedValue();
                                                    if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                                                return IntOffset.m6508boximpl(m2331invokeBjo55l4(density2));
                                                            }

                                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                            public final long m2331invokeBjo55l4(Density density2) {
                                                                return IntOffsetKt.IntOffset(0, (int) SheetState.this.requireOffset());
                                                            }
                                                        };
                                                        composer4.updateRememberedValue(rememberedValue7);
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    Modifier offset = OffsetKt.offset(semantics$default, (Function1) rememberedValue7);
                                                    composer4.startReplaceableGroup(-1482643839);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                    boolean changed4 = composer4.changed(sheetState5);
                                                    SheetState sheetState7 = sheetState5;
                                                    Function1<Float, Unit> function13 = function12;
                                                    Object rememberedValue8 = composer4.rememberedValue();
                                                    if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function13);
                                                        composer4.updateRememberedValue(rememberedValue8);
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(offset, (NestedScrollConnection) rememberedValue8, null, 2, null);
                                                    DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                                    Orientation orientation = Orientation.Vertical;
                                                    boolean isVisible = sheetState5.isVisible();
                                                    boolean isAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                                    composer4.startReplaceableGroup(-1482643097);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                    boolean changed5 = composer4.changed(function12);
                                                    Function1<Float, Unit> function14 = function12;
                                                    Object rememberedValue9 = composer4.rememberedValue();
                                                    if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue9 = (Function3) new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function14, null);
                                                        composer4.updateRememberedValue(rememberedValue9);
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    modalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable$default(nestedScroll$default, draggableState, orientation, isVisible, null, isAnimationRunning, null, (Function3) rememberedValue9, false, 168, null), sheetState5, m6344getMaxHeightimpl);
                                                    Shape shape6 = shape5;
                                                    long j16 = j14;
                                                    long j17 = j15;
                                                    float f11 = f10;
                                                    final Function2<Composer, Integer, Unit> function25 = function24;
                                                    final SheetState sheetState8 = sheetState5;
                                                    final Function0<Unit> function04 = function03;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    final Function3<ColumnScope, Composer, Integer, Unit> function35 = function34;
                                                    SurfaceKt.m2633SurfaceT9BRK9s(modalBottomSheetAnchors, shape6, j16, j17, f11, 0.0f, null, ComposableLambdaKt.composableLambda(composer4, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                                        public final void invoke(Composer composer5, int i30) {
                                                            ComposerKt.sourceInformation(composer5, "C230@10738L2649:ModalBottomSheet.android.kt#uh7d8r");
                                                            if ((i30 & 3) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1096570852, i30, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:230)");
                                                                }
                                                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                                Function2<Composer, Integer, Unit> function26 = function25;
                                                                final SheetState sheetState9 = sheetState8;
                                                                final Function0<Unit> function05 = function04;
                                                                final CoroutineScope coroutineScope4 = coroutineScope3;
                                                                Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                                                composer5.startReplaceableGroup(-483455358);
                                                                ComposerKt.sourceInformation(composer5, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                                                                composer5.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                composer5.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer5, -11289086, "C274@13360L9:ModalBottomSheet.android.kt#uh7d8r");
                                                                composer5.startReplaceableGroup(-11289086);
                                                                ComposerKt.sourceInformation(composer5, "233@10896L54,234@11000L48,235@11097L47,239@11348L1874,236@11169L2148");
                                                                if (function26 != null) {
                                                                    Strings.Companion companion3 = Strings.INSTANCE;
                                                                    final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer5, 0);
                                                                    Strings.Companion companion4 = Strings.INSTANCE;
                                                                    final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer5, 0);
                                                                    Strings.Companion companion5 = Strings.INSTANCE;
                                                                    final String m2623getStringNWtq284 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer5, 0);
                                                                    Modifier align2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                                                                    composer5.startReplaceableGroup(-11288530);
                                                                    ComposerKt.sourceInformation(composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                                    boolean changed6 = composer5.changed(sheetState9) | composer5.changed(m2623getStringNWtq283) | composer5.changed(function05) | composer5.changed(m2623getStringNWtq284) | composer5.changedInstance(coroutineScope4) | composer5.changed(m2623getStringNWtq282);
                                                                    Object rememberedValue10 = composer5.rememberedValue();
                                                                    if (changed6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1
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
                                                                                final SheetState sheetState10 = SheetState.this;
                                                                                String str = m2623getStringNWtq283;
                                                                                String str2 = m2623getStringNWtq284;
                                                                                String str3 = m2623getStringNWtq282;
                                                                                final Function0<Unit> function06 = function05;
                                                                                final CoroutineScope coroutineScope5 = coroutineScope4;
                                                                                SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Boolean invoke() {
                                                                                        function06.invoke();
                                                                                        return true;
                                                                                    }
                                                                                });
                                                                                if (sheetState10.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                                                                    SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Boolean invoke() {
                                                                                            if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(sheetState10, null), 3, null);
                                                                                            }
                                                                                            return true;
                                                                                        }

                                                                                        /* compiled from: ModalBottomSheet.android.kt */
                                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1", f = "ModalBottomSheet.android.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
                                                                                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1, reason: invalid class name */
                                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                            final /* synthetic */ SheetState $sheetState;
                                                                                            int label;

                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                                super(2, continuation);
                                                                                                this.$sheetState = sheetState;
                                                                                            }

                                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                                return new AnonymousClass1(this.$sheetState, continuation);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function2
                                                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                            }

                                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                            public final Object invokeSuspend(Object obj) {
                                                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                                int i = this.label;
                                                                                                if (i == 0) {
                                                                                                    ResultKt.throwOnFailure(obj);
                                                                                                    this.label = 1;
                                                                                                    if (this.$sheetState.expand(this) == coroutine_suspended) {
                                                                                                        return coroutine_suspended;
                                                                                                    }
                                                                                                } else {
                                                                                                    if (i != 1) {
                                                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                                    }
                                                                                                    ResultKt.throwOnFailure(obj);
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                } else if (sheetState10.getHasPartiallyExpandedState()) {
                                                                                    SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final Boolean invoke() {
                                                                                            if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                                                                            }
                                                                                            return true;
                                                                                        }

                                                                                        /* compiled from: ModalBottomSheet.android.kt */
                                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1", f = "ModalBottomSheet.android.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
                                                                                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1, reason: invalid class name */
                                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                            final /* synthetic */ SheetState $this_with;
                                                                                            int label;

                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                                super(2, continuation);
                                                                                                this.$this_with = sheetState;
                                                                                            }

                                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                                return new AnonymousClass1(this.$this_with, continuation);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function2
                                                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                            }

                                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                            public final Object invokeSuspend(Object obj) {
                                                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                                int i = this.label;
                                                                                                if (i == 0) {
                                                                                                    ResultKt.throwOnFailure(obj);
                                                                                                    this.label = 1;
                                                                                                    if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                                                        return coroutine_suspended;
                                                                                                    }
                                                                                                } else {
                                                                                                    if (i != 1) {
                                                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                                    }
                                                                                                    ResultKt.throwOnFailure(obj);
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        }
                                                                                    });
                                                                                }
                                                                            }
                                                                        };
                                                                        composer5.updateRememberedValue(rememberedValue10);
                                                                    }
                                                                    composer5.endReplaceableGroup();
                                                                    Modifier semantics = SemanticsModifierKt.semantics(align2, true, (Function1) rememberedValue10);
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor2);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                    }
                                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                    composer5.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1407593766, "C271@13279L12:ModalBottomSheet.android.kt#uh7d8r");
                                                                    function26.invoke(composer5, 0);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endNode();
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endReplaceableGroup();
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                function36.invoke(columnScopeInstance, composer5, 6);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                composer5.endReplaceableGroup();
                                                                composer5.endNode();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, 12582912, 96);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 3078, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, ((i15 << 6) & 896) | ((i15 >> 3) & 14) | 3072);
                            composer2 = startRestartGroup;
                            if (sheetState2.getHasExpandedState()) {
                                composer2.startReplaceableGroup(-203424502);
                                ComposerKt.sourceInformation(composer2, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                boolean z = (i25 > 256 && composer2.changed(sheetState2)) || (i8 & 384) == 256;
                                Object rememberedValue6 = composer2.rememberedValue();
                                if (z || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = (Function2) new ModalBottomSheet_androidKt$ModalBottomSheet$4$1(sheetState2, null);
                                    composer2.updateRememberedValue(rememberedValue6);
                                }
                                composer2.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(sheetState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, composer2, (i8 >> 6) & 14);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modalBottomSheetProperties3 = modalBottomSheetProperties4;
                            sheetState3 = sheetState2;
                            j11 = j10;
                            modifier3 = modifier2;
                            f7 = f5;
                            shape4 = shape3;
                            j12 = j9;
                            j5 = j8;
                            f8 = f6;
                            function23 = function22;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            f7 = f;
                            windowInsets2 = windowInsets;
                            composer2 = startRestartGroup;
                            shape4 = shape2;
                            j12 = j4;
                            sheetState3 = sheetState2;
                            f8 = f3;
                            j11 = j3;
                            function23 = function2;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5
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

                                public final void invoke(Composer composer3, int i27) {
                                    ModalBottomSheet_androidKt.m2328ModalBottomSheetdYc4hso(function0, modifier3, sheetState3, f7, shape4, j12, j5, f8, j11, function23, windowInsets2, modalBottomSheetProperties3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function32 = function3;
                    if ((306783379 & i8) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    int i242 = i14;
                    if ((i3 & 2048) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density2 = (Density) consume2;
                    startRestartGroup.startReplaceableGroup(-203430466);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    int i252 = (i8 & 896) ^ 384;
                    changed = ((i252 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changed(density2);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SheetState.this.setDensity$material3_release(density2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-203430341);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    int i262 = i8 & 14;
                    changedInstance = (i262 == 4) | ((i252 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* compiled from: ModalBottomSheet.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ SheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = sheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Job launch$default;
                            if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                final SheetState sheetState42 = SheetState.this;
                                final Function0<Unit> function022 = function0;
                                launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                        invoke2(th);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th) {
                                        if (SheetState.this.isVisible()) {
                                            return;
                                        }
                                        function022.invoke();
                                    }
                                });
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    final Function0<Unit> function022 = (Function0) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-203430010);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    changedInstance2 = startRestartGroup.changedInstance(coroutineScope2) | ((i252 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | (i262 == 4);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance2) {
                    }
                    rememberedValue4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* compiled from: ModalBottomSheet.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ float $it;
                            final /* synthetic */ SheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = sheetState;
                                this.$it = f;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, this.$it, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                            invoke(f9.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f9) {
                            Job launch$default;
                            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState2, f9, null), 3, null);
                            final SheetState sheetState42 = sheetState2;
                            final Function0<Unit> function03 = function0;
                            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th) {
                                    if (SheetState.this.isVisible()) {
                                        return;
                                    }
                                    function03.invoke();
                                }
                            });
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    final Function1<? super Float, Unit> function12 = (Function1) rememberedValue4;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-203429778);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    changedInstance3 = ((i252 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2) | (i262 == 4);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changedInstance3) {
                    }
                    rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* compiled from: ModalBottomSheet.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ SheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = sheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Job launch$default;
                            if (SheetState.this.getCurrentValue() != SheetValue.Expanded || !SheetState.this.getHasPartiallyExpandedState()) {
                                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass2(SheetState.this, null), 3, null);
                                final Function0<Unit> function03 = function0;
                                launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                        invoke2(th);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th) {
                                        function03.invoke();
                                    }
                                });
                                return;
                            }
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                        }

                        /* compiled from: ModalBottomSheet.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", f = "ModalBottomSheet.android.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2, reason: invalid class name */
                        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ SheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass2(SheetState sheetState, Continuation<? super AnonymousClass2> continuation) {
                                super(2, continuation);
                                this.$sheetState = sheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass2(this.$sheetState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                    final SheetState sheetState42 = sheetState2;
                    ModalBottomSheetProperties modalBottomSheetProperties42 = modalBottomSheetProperties2;
                    ModalBottomSheetPopup(modalBottomSheetProperties42, (Function0) rememberedValue5, windowInsets2, ComposableLambdaKt.composableLambda(startRestartGroup, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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

                        public final void invoke(Composer composer3, int i27) {
                            ComposerKt.sourceInformation(composer3, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                            if ((i27 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1311525899, i27, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                                }
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                final long j13 = j10;
                                final Function0<Unit> function03 = function022;
                                final SheetState sheetState5 = sheetState42;
                                final Modifier modifier4 = modifier2;
                                final float f9 = f5;
                                final Function1<? super Float, Unit> function122 = function12;
                                final Shape shape5 = shape3;
                                final long j14 = j9;
                                final long j15 = j8;
                                final float f10 = f6;
                                final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                final CoroutineScope coroutineScope22 = coroutineScope2;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34 = function332;
                                BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer3, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, Integer num) {
                                        invoke(boxWithConstraintsScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, int i28) {
                                        int i29;
                                        Modifier modalBottomSheetAnchors;
                                        ComposerKt.sourceInformation(composer4, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                                        if ((i28 & 6) == 0) {
                                            i29 = i28 | (composer4.changed(boxWithConstraintsScope) ? 4 : 2);
                                        } else {
                                            i29 = i28;
                                        }
                                        if ((i29 & 19) != 18 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2008499679, i29, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                            }
                                            int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                            ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j13, function03, sheetState5.getTargetValue() != SheetValue.Hidden, composer4, 0);
                                            Strings.Companion companion2 = Strings.INSTANCE;
                                            final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_pane_title), composer4, 0);
                                            Modifier align = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, f9, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                            composer4.startReplaceableGroup(-1482644208);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                            boolean changed2 = composer4.changed(m2623getStringNWtq28);
                                            Object rememberedValue62 = composer4.rememberedValue();
                                            if (changed2 || rememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue62 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
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
                                                composer4.updateRememberedValue(rememberedValue62);
                                            }
                                            composer4.endReplaceableGroup();
                                            Modifier semantics$default = SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue62, 1, null);
                                            composer4.startReplaceableGroup(-1482644143);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                            boolean changed3 = composer4.changed(sheetState5);
                                            final SheetState sheetState6 = sheetState5;
                                            Object rememberedValue7 = composer4.rememberedValue();
                                            if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density22) {
                                                        return IntOffset.m6508boximpl(m2331invokeBjo55l4(density22));
                                                    }

                                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                    public final long m2331invokeBjo55l4(Density density22) {
                                                        return IntOffsetKt.IntOffset(0, (int) SheetState.this.requireOffset());
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue7);
                                            }
                                            composer4.endReplaceableGroup();
                                            Modifier offset = OffsetKt.offset(semantics$default, (Function1) rememberedValue7);
                                            composer4.startReplaceableGroup(-1482643839);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                            boolean changed4 = composer4.changed(sheetState5);
                                            SheetState sheetState7 = sheetState5;
                                            Function1<Float, Unit> function13 = function122;
                                            Object rememberedValue8 = composer4.rememberedValue();
                                            if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function13);
                                                composer4.updateRememberedValue(rememberedValue8);
                                            }
                                            composer4.endReplaceableGroup();
                                            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(offset, (NestedScrollConnection) rememberedValue8, null, 2, null);
                                            DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                            Orientation orientation = Orientation.Vertical;
                                            boolean isVisible = sheetState5.isVisible();
                                            boolean isAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                            composer4.startReplaceableGroup(-1482643097);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                            boolean changed5 = composer4.changed(function122);
                                            Function1<Float, Unit> function14 = function122;
                                            Object rememberedValue9 = composer4.rememberedValue();
                                            if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue9 = (Function3) new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function14, null);
                                                composer4.updateRememberedValue(rememberedValue9);
                                            }
                                            composer4.endReplaceableGroup();
                                            modalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable$default(nestedScroll$default, draggableState, orientation, isVisible, null, isAnimationRunning, null, (Function3) rememberedValue9, false, 168, null), sheetState5, m6344getMaxHeightimpl);
                                            Shape shape6 = shape5;
                                            long j16 = j14;
                                            long j17 = j15;
                                            float f11 = f10;
                                            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                            final SheetState sheetState8 = sheetState5;
                                            final Function0<Unit> function04 = function03;
                                            final CoroutineScope coroutineScope3 = coroutineScope22;
                                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = function34;
                                            SurfaceKt.m2633SurfaceT9BRK9s(modalBottomSheetAnchors, shape6, j16, j17, f11, 0.0f, null, ComposableLambdaKt.composableLambda(composer4, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                                public final void invoke(Composer composer5, int i30) {
                                                    ComposerKt.sourceInformation(composer5, "C230@10738L2649:ModalBottomSheet.android.kt#uh7d8r");
                                                    if ((i30 & 3) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1096570852, i30, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:230)");
                                                        }
                                                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                        Function2<Composer, Integer, Unit> function26 = function25;
                                                        final SheetState sheetState9 = sheetState8;
                                                        final Function0<Unit> function05 = function04;
                                                        final CoroutineScope coroutineScope4 = coroutineScope3;
                                                        Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                                        composer5.startReplaceableGroup(-483455358);
                                                        ComposerKt.sourceInformation(composer5, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -11289086, "C274@13360L9:ModalBottomSheet.android.kt#uh7d8r");
                                                        composer5.startReplaceableGroup(-11289086);
                                                        ComposerKt.sourceInformation(composer5, "233@10896L54,234@11000L48,235@11097L47,239@11348L1874,236@11169L2148");
                                                        if (function26 != null) {
                                                            Strings.Companion companion3 = Strings.INSTANCE;
                                                            final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer5, 0);
                                                            Strings.Companion companion4 = Strings.INSTANCE;
                                                            final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer5, 0);
                                                            Strings.Companion companion5 = Strings.INSTANCE;
                                                            final String m2623getStringNWtq284 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer5, 0);
                                                            Modifier align2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                                                            composer5.startReplaceableGroup(-11288530);
                                                            ComposerKt.sourceInformation(composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                            boolean changed6 = composer5.changed(sheetState9) | composer5.changed(m2623getStringNWtq283) | composer5.changed(function05) | composer5.changed(m2623getStringNWtq284) | composer5.changedInstance(coroutineScope4) | composer5.changed(m2623getStringNWtq282);
                                                            Object rememberedValue10 = composer5.rememberedValue();
                                                            if (changed6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1
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
                                                                        final SheetState sheetState10 = SheetState.this;
                                                                        String str = m2623getStringNWtq283;
                                                                        String str2 = m2623getStringNWtq284;
                                                                        String str3 = m2623getStringNWtq282;
                                                                        final Function0<Unit> function06 = function05;
                                                                        final CoroutineScope coroutineScope5 = coroutineScope4;
                                                                        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Boolean invoke() {
                                                                                function06.invoke();
                                                                                return true;
                                                                            }
                                                                        });
                                                                        if (sheetState10.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                                                            SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final Boolean invoke() {
                                                                                    if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(sheetState10, null), 3, null);
                                                                                    }
                                                                                    return true;
                                                                                }

                                                                                /* compiled from: ModalBottomSheet.android.kt */
                                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1", f = "ModalBottomSheet.android.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
                                                                                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1, reason: invalid class name */
                                                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                    final /* synthetic */ SheetState $sheetState;
                                                                                    int label;

                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                        super(2, continuation);
                                                                                        this.$sheetState = sheetState;
                                                                                    }

                                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                        return new AnonymousClass1(this.$sheetState, continuation);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function2
                                                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                    }

                                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                    public final Object invokeSuspend(Object obj) {
                                                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                        int i = this.label;
                                                                                        if (i == 0) {
                                                                                            ResultKt.throwOnFailure(obj);
                                                                                            this.label = 1;
                                                                                            if (this.$sheetState.expand(this) == coroutine_suspended) {
                                                                                                return coroutine_suspended;
                                                                                            }
                                                                                        } else {
                                                                                            if (i != 1) {
                                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                            }
                                                                                            ResultKt.throwOnFailure(obj);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }
                                                                            });
                                                                        } else if (sheetState10.getHasPartiallyExpandedState()) {
                                                                            SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final Boolean invoke() {
                                                                                    if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                                                                    }
                                                                                    return true;
                                                                                }

                                                                                /* compiled from: ModalBottomSheet.android.kt */
                                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1", f = "ModalBottomSheet.android.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
                                                                                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1, reason: invalid class name */
                                                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                    final /* synthetic */ SheetState $this_with;
                                                                                    int label;

                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                        super(2, continuation);
                                                                                        this.$this_with = sheetState;
                                                                                    }

                                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                        return new AnonymousClass1(this.$this_with, continuation);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function2
                                                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                    }

                                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                    public final Object invokeSuspend(Object obj) {
                                                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                        int i = this.label;
                                                                                        if (i == 0) {
                                                                                            ResultKt.throwOnFailure(obj);
                                                                                            this.label = 1;
                                                                                            if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                                                return coroutine_suspended;
                                                                                            }
                                                                                        } else {
                                                                                            if (i != 1) {
                                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                            }
                                                                                            ResultKt.throwOnFailure(obj);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }
                                                                            });
                                                                        }
                                                                    }
                                                                };
                                                                composer5.updateRememberedValue(rememberedValue10);
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            Modifier semantics = SemanticsModifierKt.semantics(align2, true, (Function1) rememberedValue10);
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor2);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                            }
                                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1407593766, "C271@13279L12:ModalBottomSheet.android.kt#uh7d8r");
                                                            function26.invoke(composer5, 0);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        function36.invoke(columnScopeInstance, composer5, 6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 12582912, 96);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 3078, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, ((i15 << 6) & 896) | ((i15 >> 3) & 14) | 3072);
                    composer2 = startRestartGroup;
                    if (sheetState2.getHasExpandedState()) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modalBottomSheetProperties3 = modalBottomSheetProperties42;
                    sheetState3 = sheetState2;
                    j11 = j10;
                    modifier3 = modifier2;
                    f7 = f5;
                    shape4 = shape3;
                    j12 = j9;
                    j5 = j8;
                    f8 = f6;
                    function23 = function22;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i9;
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i232 = i11;
                if ((i3 & 4096) == 0) {
                }
                function32 = function3;
                if ((306783379 & i8) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                int i2422 = i14;
                if ((i3 & 2048) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density22 = (Density) consume22;
                startRestartGroup.startReplaceableGroup(-203430466);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                int i2522 = (i8 & 896) ^ 384;
                changed = ((i2522 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changed(density22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SheetState.this.setDensity$material3_release(density22);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-203430341);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                int i2622 = i8 & 14;
                changedInstance = (i2622 == 4) | ((i2522 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$sheetState.hide(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Job launch$default;
                        if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                            final SheetState sheetState422 = SheetState.this;
                            final Function0<Unit> function0222 = function0;
                            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th) {
                                    if (SheetState.this.isVisible()) {
                                        return;
                                    }
                                    function0222.invoke();
                                }
                            });
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                final Function0<Unit> function0222 = (Function0) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-203430010);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                changedInstance2 = startRestartGroup.changedInstance(coroutineScope22) | ((i2522 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | (i2622 == 4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                }
                rememberedValue4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$sheetState, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                        invoke(f9.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f9) {
                        Job launch$default;
                        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState2, f9, null), 3, null);
                        final SheetState sheetState422 = sheetState2;
                        final Function0<Unit> function03 = function0;
                        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                if (SheetState.this.isVisible()) {
                                    return;
                                }
                                function03.invoke();
                            }
                        });
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                final Function1<? super Float, Unit> function122 = (Function1) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-203429778);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                changedInstance3 = ((i2522 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22) | (i2622 == 4);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changedInstance3) {
                }
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Job launch$default;
                        if (SheetState.this.getCurrentValue() != SheetValue.Expanded || !SheetState.this.getHasPartiallyExpandedState()) {
                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass2(SheetState.this, null), 3, null);
                            final Function0<Unit> function03 = function0;
                            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th) {
                                    function03.invoke();
                                }
                            });
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", f = "ModalBottomSheet.android.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(SheetState sheetState, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$sheetState.hide(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322 = function32;
                final SheetState sheetState422 = sheetState2;
                ModalBottomSheetProperties modalBottomSheetProperties422 = modalBottomSheetProperties2;
                ModalBottomSheetPopup(modalBottomSheetProperties422, (Function0) rememberedValue5, windowInsets2, ComposableLambdaKt.composableLambda(startRestartGroup, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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

                    public final void invoke(Composer composer3, int i27) {
                        ComposerKt.sourceInformation(composer3, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                        if ((i27 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1311525899, i27, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                            }
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            final long j13 = j10;
                            final Function0<Unit> function03 = function0222;
                            final SheetState sheetState5 = sheetState422;
                            final Modifier modifier4 = modifier2;
                            final float f9 = f5;
                            final Function1<? super Float, Unit> function1222 = function122;
                            final Shape shape5 = shape3;
                            final long j14 = j9;
                            final long j15 = j8;
                            final float f10 = f6;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                            final CoroutineScope coroutineScope222 = coroutineScope22;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34 = function3322;
                            BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer3, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, Integer num) {
                                    invoke(boxWithConstraintsScope, composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, int i28) {
                                    int i29;
                                    Modifier modalBottomSheetAnchors;
                                    ComposerKt.sourceInformation(composer4, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                                    if ((i28 & 6) == 0) {
                                        i29 = i28 | (composer4.changed(boxWithConstraintsScope) ? 4 : 2);
                                    } else {
                                        i29 = i28;
                                    }
                                    if ((i29 & 19) != 18 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2008499679, i29, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                        }
                                        int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                        ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j13, function03, sheetState5.getTargetValue() != SheetValue.Hidden, composer4, 0);
                                        Strings.Companion companion2 = Strings.INSTANCE;
                                        final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_pane_title), composer4, 0);
                                        Modifier align = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, f9, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                        composer4.startReplaceableGroup(-1482644208);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                        boolean changed2 = composer4.changed(m2623getStringNWtq28);
                                        Object rememberedValue62 = composer4.rememberedValue();
                                        if (changed2 || rememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue62 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
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
                                            composer4.updateRememberedValue(rememberedValue62);
                                        }
                                        composer4.endReplaceableGroup();
                                        Modifier semantics$default = SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue62, 1, null);
                                        composer4.startReplaceableGroup(-1482644143);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                        boolean changed3 = composer4.changed(sheetState5);
                                        final SheetState sheetState6 = sheetState5;
                                        Object rememberedValue7 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density222) {
                                                    return IntOffset.m6508boximpl(m2331invokeBjo55l4(density222));
                                                }

                                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                public final long m2331invokeBjo55l4(Density density222) {
                                                    return IntOffsetKt.IntOffset(0, (int) SheetState.this.requireOffset());
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue7);
                                        }
                                        composer4.endReplaceableGroup();
                                        Modifier offset = OffsetKt.offset(semantics$default, (Function1) rememberedValue7);
                                        composer4.startReplaceableGroup(-1482643839);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                        boolean changed4 = composer4.changed(sheetState5);
                                        SheetState sheetState7 = sheetState5;
                                        Function1<Float, Unit> function13 = function1222;
                                        Object rememberedValue8 = composer4.rememberedValue();
                                        if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function13);
                                            composer4.updateRememberedValue(rememberedValue8);
                                        }
                                        composer4.endReplaceableGroup();
                                        Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(offset, (NestedScrollConnection) rememberedValue8, null, 2, null);
                                        DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                        Orientation orientation = Orientation.Vertical;
                                        boolean isVisible = sheetState5.isVisible();
                                        boolean isAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                        composer4.startReplaceableGroup(-1482643097);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                        boolean changed5 = composer4.changed(function1222);
                                        Function1<Float, Unit> function14 = function1222;
                                        Object rememberedValue9 = composer4.rememberedValue();
                                        if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue9 = (Function3) new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function14, null);
                                            composer4.updateRememberedValue(rememberedValue9);
                                        }
                                        composer4.endReplaceableGroup();
                                        modalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable$default(nestedScroll$default, draggableState, orientation, isVisible, null, isAnimationRunning, null, (Function3) rememberedValue9, false, 168, null), sheetState5, m6344getMaxHeightimpl);
                                        Shape shape6 = shape5;
                                        long j16 = j14;
                                        long j17 = j15;
                                        float f11 = f10;
                                        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                        final SheetState sheetState8 = sheetState5;
                                        final Function0<Unit> function04 = function03;
                                        final CoroutineScope coroutineScope3 = coroutineScope222;
                                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = function34;
                                        SurfaceKt.m2633SurfaceT9BRK9s(modalBottomSheetAnchors, shape6, j16, j17, f11, 0.0f, null, ComposableLambdaKt.composableLambda(composer4, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                            public final void invoke(Composer composer5, int i30) {
                                                ComposerKt.sourceInformation(composer5, "C230@10738L2649:ModalBottomSheet.android.kt#uh7d8r");
                                                if ((i30 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1096570852, i30, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:230)");
                                                    }
                                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    Function2<Composer, Integer, Unit> function26 = function25;
                                                    final SheetState sheetState9 = sheetState8;
                                                    final Function0<Unit> function05 = function04;
                                                    final CoroutineScope coroutineScope4 = coroutineScope3;
                                                    Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                                    composer5.startReplaceableGroup(-483455358);
                                                    ComposerKt.sourceInformation(composer5, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -11289086, "C274@13360L9:ModalBottomSheet.android.kt#uh7d8r");
                                                    composer5.startReplaceableGroup(-11289086);
                                                    ComposerKt.sourceInformation(composer5, "233@10896L54,234@11000L48,235@11097L47,239@11348L1874,236@11169L2148");
                                                    if (function26 != null) {
                                                        Strings.Companion companion3 = Strings.INSTANCE;
                                                        final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer5, 0);
                                                        Strings.Companion companion4 = Strings.INSTANCE;
                                                        final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer5, 0);
                                                        Strings.Companion companion5 = Strings.INSTANCE;
                                                        final String m2623getStringNWtq284 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer5, 0);
                                                        Modifier align2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                                                        composer5.startReplaceableGroup(-11288530);
                                                        ComposerKt.sourceInformation(composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                        boolean changed6 = composer5.changed(sheetState9) | composer5.changed(m2623getStringNWtq283) | composer5.changed(function05) | composer5.changed(m2623getStringNWtq284) | composer5.changedInstance(coroutineScope4) | composer5.changed(m2623getStringNWtq282);
                                                        Object rememberedValue10 = composer5.rememberedValue();
                                                        if (changed6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1
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
                                                                    final SheetState sheetState10 = SheetState.this;
                                                                    String str = m2623getStringNWtq283;
                                                                    String str2 = m2623getStringNWtq284;
                                                                    String str3 = m2623getStringNWtq282;
                                                                    final Function0<Unit> function06 = function05;
                                                                    final CoroutineScope coroutineScope5 = coroutineScope4;
                                                                    SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Boolean invoke() {
                                                                            function06.invoke();
                                                                            return true;
                                                                        }
                                                                    });
                                                                    if (sheetState10.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                                                        SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Boolean invoke() {
                                                                                if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(sheetState10, null), 3, null);
                                                                                }
                                                                                return true;
                                                                            }

                                                                            /* compiled from: ModalBottomSheet.android.kt */
                                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1", f = "ModalBottomSheet.android.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
                                                                            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1, reason: invalid class name */
                                                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                final /* synthetic */ SheetState $sheetState;
                                                                                int label;

                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                    super(2, continuation);
                                                                                    this.$sheetState = sheetState;
                                                                                }

                                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                    return new AnonymousClass1(this.$sheetState, continuation);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                }

                                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                public final Object invokeSuspend(Object obj) {
                                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                    int i = this.label;
                                                                                    if (i == 0) {
                                                                                        ResultKt.throwOnFailure(obj);
                                                                                        this.label = 1;
                                                                                        if (this.$sheetState.expand(this) == coroutine_suspended) {
                                                                                            return coroutine_suspended;
                                                                                        }
                                                                                    } else {
                                                                                        if (i != 1) {
                                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                        }
                                                                                        ResultKt.throwOnFailure(obj);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }
                                                                        });
                                                                    } else if (sheetState10.getHasPartiallyExpandedState()) {
                                                                        SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Boolean invoke() {
                                                                                if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                                                                }
                                                                                return true;
                                                                            }

                                                                            /* compiled from: ModalBottomSheet.android.kt */
                                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1", f = "ModalBottomSheet.android.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
                                                                            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1, reason: invalid class name */
                                                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                                final /* synthetic */ SheetState $this_with;
                                                                                int label;

                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                    super(2, continuation);
                                                                                    this.$this_with = sheetState;
                                                                                }

                                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                    return new AnonymousClass1(this.$this_with, continuation);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                                }

                                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                                public final Object invokeSuspend(Object obj) {
                                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                    int i = this.label;
                                                                                    if (i == 0) {
                                                                                        ResultKt.throwOnFailure(obj);
                                                                                        this.label = 1;
                                                                                        if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                                            return coroutine_suspended;
                                                                                        }
                                                                                    } else {
                                                                                        if (i != 1) {
                                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                        }
                                                                                        ResultKt.throwOnFailure(obj);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }
                                                                        });
                                                                    }
                                                                }
                                                            };
                                                            composer5.updateRememberedValue(rememberedValue10);
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Modifier semantics = SemanticsModifierKt.semantics(align2, true, (Function1) rememberedValue10);
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor2);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1407593766, "C271@13279L12:ModalBottomSheet.android.kt#uh7d8r");
                                                        function26.invoke(composer5, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    function36.invoke(columnScopeInstance, composer5, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 12582912, 96);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 3078, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i15 << 6) & 896) | ((i15 >> 3) & 14) | 3072);
                composer2 = startRestartGroup;
                if (sheetState2.getHasExpandedState()) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modalBottomSheetProperties3 = modalBottomSheetProperties422;
                sheetState3 = sheetState2;
                j11 = j10;
                modifier3 = modifier2;
                f7 = f5;
                shape4 = shape3;
                j12 = j9;
                j5 = j8;
                f8 = f6;
                function23 = function22;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i & 24576) == 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2322 = i11;
            if ((i3 & 4096) == 0) {
            }
            function32 = function3;
            if ((306783379 & i8) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            int i24222 = i14;
            if ((i3 & 2048) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density222 = (Density) consume222;
            startRestartGroup.startReplaceableGroup(-203430466);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            int i25222 = (i8 & 896) ^ 384;
            changed = ((i25222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changed(density222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SheetState.this.setDensity$material3_release(density222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-203430341);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            int i26222 = i8 & 14;
            changedInstance = (i26222 == 4) | ((i25222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* compiled from: ModalBottomSheet.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ SheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$sheetState = sheetState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$sheetState.hide(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job launch$default;
                    if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                        final SheetState sheetState4222 = SheetState.this;
                        final Function0<Unit> function02222 = function0;
                        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                if (SheetState.this.isVisible()) {
                                    return;
                                }
                                function02222.invoke();
                            }
                        });
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final Function0<Unit> function02222 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-203430010);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            changedInstance2 = startRestartGroup.changedInstance(coroutineScope222) | ((i25222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | (i26222 == 4);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* compiled from: ModalBottomSheet.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ float $it;
                    final /* synthetic */ SheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$sheetState = sheetState;
                        this.$it = f;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, this.$it, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                    invoke(f9.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f9) {
                    Job launch$default;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState2, f9, null), 3, null);
                    final SheetState sheetState4222 = sheetState2;
                    final Function0<Unit> function03 = function0;
                    launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            if (SheetState.this.isVisible()) {
                                return;
                            }
                            function03.invoke();
                        }
                    });
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            final Function1<? super Float, Unit> function1222 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-203429778);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            changedInstance3 = ((i25222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope222) | (i26222 == 4);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
            }
            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* compiled from: ModalBottomSheet.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ SheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$sheetState = sheetState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$sheetState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job launch$default;
                    if (SheetState.this.getCurrentValue() != SheetValue.Expanded || !SheetState.this.getHasPartiallyExpandedState()) {
                        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass2(SheetState.this, null), 3, null);
                        final Function0<Unit> function03 = function0;
                        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                function03.invoke();
                            }
                        });
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                }

                /* compiled from: ModalBottomSheet.android.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", f = "ModalBottomSheet.android.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ SheetState $sheetState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(SheetState sheetState, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$sheetState = sheetState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$sheetState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$sheetState.hide(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222 = function32;
            final SheetState sheetState4222 = sheetState2;
            ModalBottomSheetProperties modalBottomSheetProperties4222 = modalBottomSheetProperties2;
            ModalBottomSheetPopup(modalBottomSheetProperties4222, (Function0) rememberedValue5, windowInsets2, ComposableLambdaKt.composableLambda(startRestartGroup, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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

                public final void invoke(Composer composer3, int i27) {
                    ComposerKt.sourceInformation(composer3, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                    if ((i27 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1311525899, i27, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                        }
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final long j13 = j10;
                        final Function0<Unit> function03 = function02222;
                        final SheetState sheetState5 = sheetState4222;
                        final Modifier modifier4 = modifier2;
                        final float f9 = f5;
                        final Function1<? super Float, Unit> function12222 = function1222;
                        final Shape shape5 = shape3;
                        final long j14 = j9;
                        final long j15 = j8;
                        final float f10 = f6;
                        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                        final CoroutineScope coroutineScope2222 = coroutineScope222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34 = function33222;
                        BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer3, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, Integer num) {
                                invoke(boxWithConstraintsScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, int i28) {
                                int i29;
                                Modifier modalBottomSheetAnchors;
                                ComposerKt.sourceInformation(composer4, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                                if ((i28 & 6) == 0) {
                                    i29 = i28 | (composer4.changed(boxWithConstraintsScope) ? 4 : 2);
                                } else {
                                    i29 = i28;
                                }
                                if ((i29 & 19) != 18 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2008499679, i29, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                    }
                                    int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                    ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j13, function03, sheetState5.getTargetValue() != SheetValue.Hidden, composer4, 0);
                                    Strings.Companion companion2 = Strings.INSTANCE;
                                    final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_pane_title), composer4, 0);
                                    Modifier align = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, f9, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                    composer4.startReplaceableGroup(-1482644208);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean changed2 = composer4.changed(m2623getStringNWtq28);
                                    Object rememberedValue62 = composer4.rememberedValue();
                                    if (changed2 || rememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue62 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
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
                                        composer4.updateRememberedValue(rememberedValue62);
                                    }
                                    composer4.endReplaceableGroup();
                                    Modifier semantics$default = SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue62, 1, null);
                                    composer4.startReplaceableGroup(-1482644143);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean changed3 = composer4.changed(sheetState5);
                                    final SheetState sheetState6 = sheetState5;
                                    Object rememberedValue7 = composer4.rememberedValue();
                                    if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density2222) {
                                                return IntOffset.m6508boximpl(m2331invokeBjo55l4(density2222));
                                            }

                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m2331invokeBjo55l4(Density density2222) {
                                                return IntOffsetKt.IntOffset(0, (int) SheetState.this.requireOffset());
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue7);
                                    }
                                    composer4.endReplaceableGroup();
                                    Modifier offset = OffsetKt.offset(semantics$default, (Function1) rememberedValue7);
                                    composer4.startReplaceableGroup(-1482643839);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean changed4 = composer4.changed(sheetState5);
                                    SheetState sheetState7 = sheetState5;
                                    Function1<Float, Unit> function13 = function12222;
                                    Object rememberedValue8 = composer4.rememberedValue();
                                    if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function13);
                                        composer4.updateRememberedValue(rememberedValue8);
                                    }
                                    composer4.endReplaceableGroup();
                                    Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(offset, (NestedScrollConnection) rememberedValue8, null, 2, null);
                                    DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                    Orientation orientation = Orientation.Vertical;
                                    boolean isVisible = sheetState5.isVisible();
                                    boolean isAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                    composer4.startReplaceableGroup(-1482643097);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean changed5 = composer4.changed(function12222);
                                    Function1<Float, Unit> function14 = function12222;
                                    Object rememberedValue9 = composer4.rememberedValue();
                                    if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue9 = (Function3) new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function14, null);
                                        composer4.updateRememberedValue(rememberedValue9);
                                    }
                                    composer4.endReplaceableGroup();
                                    modalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable$default(nestedScroll$default, draggableState, orientation, isVisible, null, isAnimationRunning, null, (Function3) rememberedValue9, false, 168, null), sheetState5, m6344getMaxHeightimpl);
                                    Shape shape6 = shape5;
                                    long j16 = j14;
                                    long j17 = j15;
                                    float f11 = f10;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                    final SheetState sheetState8 = sheetState5;
                                    final Function0<Unit> function04 = function03;
                                    final CoroutineScope coroutineScope3 = coroutineScope2222;
                                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = function34;
                                    SurfaceKt.m2633SurfaceT9BRK9s(modalBottomSheetAnchors, shape6, j16, j17, f11, 0.0f, null, ComposableLambdaKt.composableLambda(composer4, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                        public final void invoke(Composer composer5, int i30) {
                                            ComposerKt.sourceInformation(composer5, "C230@10738L2649:ModalBottomSheet.android.kt#uh7d8r");
                                            if ((i30 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1096570852, i30, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:230)");
                                                }
                                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                Function2<Composer, Integer, Unit> function26 = function25;
                                                final SheetState sheetState9 = sheetState8;
                                                final Function0<Unit> function05 = function04;
                                                final CoroutineScope coroutineScope4 = coroutineScope3;
                                                Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                                composer5.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer5, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, -11289086, "C274@13360L9:ModalBottomSheet.android.kt#uh7d8r");
                                                composer5.startReplaceableGroup(-11289086);
                                                ComposerKt.sourceInformation(composer5, "233@10896L54,234@11000L48,235@11097L47,239@11348L1874,236@11169L2148");
                                                if (function26 != null) {
                                                    Strings.Companion companion3 = Strings.INSTANCE;
                                                    final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer5, 0);
                                                    Strings.Companion companion4 = Strings.INSTANCE;
                                                    final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer5, 0);
                                                    Strings.Companion companion5 = Strings.INSTANCE;
                                                    final String m2623getStringNWtq284 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer5, 0);
                                                    Modifier align2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                                                    composer5.startReplaceableGroup(-11288530);
                                                    ComposerKt.sourceInformation(composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                    boolean changed6 = composer5.changed(sheetState9) | composer5.changed(m2623getStringNWtq283) | composer5.changed(function05) | composer5.changed(m2623getStringNWtq284) | composer5.changedInstance(coroutineScope4) | composer5.changed(m2623getStringNWtq282);
                                                    Object rememberedValue10 = composer5.rememberedValue();
                                                    if (changed6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1
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
                                                                final SheetState sheetState10 = SheetState.this;
                                                                String str = m2623getStringNWtq283;
                                                                String str2 = m2623getStringNWtq284;
                                                                String str3 = m2623getStringNWtq282;
                                                                final Function0<Unit> function06 = function05;
                                                                final CoroutineScope coroutineScope5 = coroutineScope4;
                                                                SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        function06.invoke();
                                                                        return true;
                                                                    }
                                                                });
                                                                if (sheetState10.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                                                    SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Boolean invoke() {
                                                                            if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(sheetState10, null), 3, null);
                                                                            }
                                                                            return true;
                                                                        }

                                                                        /* compiled from: ModalBottomSheet.android.kt */
                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1", f = "ModalBottomSheet.android.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
                                                                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1, reason: invalid class name */
                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                            final /* synthetic */ SheetState $sheetState;
                                                                            int label;

                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                super(2, continuation);
                                                                                this.$sheetState = sheetState;
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                return new AnonymousClass1(this.$sheetState, continuation);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Object invokeSuspend(Object obj) {
                                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                int i = this.label;
                                                                                if (i == 0) {
                                                                                    ResultKt.throwOnFailure(obj);
                                                                                    this.label = 1;
                                                                                    if (this.$sheetState.expand(this) == coroutine_suspended) {
                                                                                        return coroutine_suspended;
                                                                                    }
                                                                                } else {
                                                                                    if (i != 1) {
                                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                    }
                                                                                    ResultKt.throwOnFailure(obj);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                    });
                                                                } else if (sheetState10.getHasPartiallyExpandedState()) {
                                                                    SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Boolean invoke() {
                                                                            if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                                                            }
                                                                            return true;
                                                                        }

                                                                        /* compiled from: ModalBottomSheet.android.kt */
                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                        @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1", f = "ModalBottomSheet.android.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
                                                                        /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1, reason: invalid class name */
                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                            final /* synthetic */ SheetState $this_with;
                                                                            int label;

                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                                super(2, continuation);
                                                                                this.$this_with = sheetState;
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                return new AnonymousClass1(this.$this_with, continuation);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Object invokeSuspend(Object obj) {
                                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                int i = this.label;
                                                                                if (i == 0) {
                                                                                    ResultKt.throwOnFailure(obj);
                                                                                    this.label = 1;
                                                                                    if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                                        return coroutine_suspended;
                                                                                    }
                                                                                } else {
                                                                                    if (i != 1) {
                                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                    }
                                                                                    ResultKt.throwOnFailure(obj);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(rememberedValue10);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    Modifier semantics = SemanticsModifierKt.semantics(align2, true, (Function1) rememberedValue10);
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor2);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1407593766, "C271@13279L12:ModalBottomSheet.android.kt#uh7d8r");
                                                    function26.invoke(composer5, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                }
                                                composer5.endReplaceableGroup();
                                                function36.invoke(columnScopeInstance, composer5, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 3078, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, ((i15 << 6) & 896) | ((i15 >> 3) & 14) | 3072);
            composer2 = startRestartGroup;
            if (sheetState2.getHasExpandedState()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modalBottomSheetProperties3 = modalBottomSheetProperties4222;
            sheetState3 = sheetState2;
            j11 = j10;
            modifier3 = modifier2;
            f7 = f5;
            shape4 = shape3;
            j12 = j9;
            j5 = j8;
            f8 = f6;
            function23 = function22;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i23222 = i11;
        if ((i3 & 4096) == 0) {
        }
        function32 = function3;
        if ((306783379 & i8) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        int i242222 = i14;
        if ((i3 & 2048) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density2222 = (Density) consume2222;
        startRestartGroup.startReplaceableGroup(-203430466);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
        int i252222 = (i8 & 896) ^ 384;
        changed = ((i252222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changed(density2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SheetState.this.setDensity$material3_release(density2222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-203430341);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
        int i262222 = i8 & 14;
        changedInstance = (i262222 == 4) | ((i252222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$sheetState = sheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$sheetState.hide(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Job launch$default;
                if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                    final SheetState sheetState42222 = SheetState.this;
                    final Function0<Unit> function022222 = function0;
                    launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            if (SheetState.this.isVisible()) {
                                return;
                            }
                            function022222.invoke();
                        }
                    });
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final Function0<Unit> function022222 = (Function0) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-203430010);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
        changedInstance2 = startRestartGroup.changedInstance(coroutineScope2222) | ((i252222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | (i262222 == 4);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue4 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $it;
                final /* synthetic */ SheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$sheetState = sheetState;
                    this.$it = f;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$sheetState.settle$material3_release(this.$it, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f9) {
                invoke(f9.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f9) {
                Job launch$default;
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState2, f9, null), 3, null);
                final SheetState sheetState42222 = sheetState2;
                final Function0<Unit> function03 = function0;
                launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        if (SheetState.this.isVisible()) {
                            return;
                        }
                        function03.invoke();
                    }
                });
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        final Function1<? super Float, Unit> function12222 = (Function1) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-203429778);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
        changedInstance3 = ((i252222 <= 256 && startRestartGroup.changed(sheetState2)) || (i8 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2222) | (i262222 == 4);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", f = "ModalBottomSheet.android.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$sheetState = sheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$sheetState.partialExpand(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Job launch$default;
                if (SheetState.this.getCurrentValue() != SheetValue.Expanded || !SheetState.this.getHasPartiallyExpandedState()) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass2(SheetState.this, null), 3, null);
                    final Function0<Unit> function03 = function0;
                    launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            function03.invoke();
                        }
                    });
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
            }

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", f = "ModalBottomSheet.android.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SheetState sheetState, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$sheetState = sheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$sheetState, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$sheetState.hide(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332222 = function32;
        final SheetState sheetState42222 = sheetState2;
        ModalBottomSheetProperties modalBottomSheetProperties42222 = modalBottomSheetProperties2;
        ModalBottomSheetPopup(modalBottomSheetProperties42222, (Function0) rememberedValue5, windowInsets2, ComposableLambdaKt.composableLambda(startRestartGroup, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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

            public final void invoke(Composer composer3, int i27) {
                ComposerKt.sourceInformation(composer3, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                if ((i27 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311525899, i27, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                    }
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    final long j13 = j10;
                    final Function0<Unit> function03 = function022222;
                    final SheetState sheetState5 = sheetState42222;
                    final Modifier modifier4 = modifier2;
                    final float f9 = f5;
                    final Function1<? super Float, Unit> function122222 = function12222;
                    final Shape shape5 = shape3;
                    final long j14 = j9;
                    final long j15 = j8;
                    final float f10 = f6;
                    final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                    final CoroutineScope coroutineScope22222 = coroutineScope2222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34 = function332222;
                    BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, null, false, ComposableLambdaKt.composableLambda(composer3, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, Integer num) {
                            invoke(boxWithConstraintsScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer4, int i28) {
                            int i29;
                            Modifier modalBottomSheetAnchors;
                            ComposerKt.sourceInformation(composer4, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                            if ((i28 & 6) == 0) {
                                i29 = i28 | (composer4.changed(boxWithConstraintsScope) ? 4 : 2);
                            } else {
                                i29 = i28;
                            }
                            if ((i29 & 19) != 18 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2008499679, i29, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                }
                                int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j13, function03, sheetState5.getTargetValue() != SheetValue.Hidden, composer4, 0);
                                Strings.Companion companion2 = Strings.INSTANCE;
                                final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_pane_title), composer4, 0);
                                Modifier align = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, f9, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                composer4.startReplaceableGroup(-1482644208);
                                ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                boolean changed2 = composer4.changed(m2623getStringNWtq28);
                                Object rememberedValue62 = composer4.rememberedValue();
                                if (changed2 || rememberedValue62 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue62 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
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
                                    composer4.updateRememberedValue(rememberedValue62);
                                }
                                composer4.endReplaceableGroup();
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue62, 1, null);
                                composer4.startReplaceableGroup(-1482644143);
                                ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                boolean changed3 = composer4.changed(sheetState5);
                                final SheetState sheetState6 = sheetState5;
                                Object rememberedValue7 = composer4.rememberedValue();
                                if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density22222) {
                                            return IntOffset.m6508boximpl(m2331invokeBjo55l4(density22222));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m2331invokeBjo55l4(Density density22222) {
                                            return IntOffsetKt.IntOffset(0, (int) SheetState.this.requireOffset());
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue7);
                                }
                                composer4.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(semantics$default, (Function1) rememberedValue7);
                                composer4.startReplaceableGroup(-1482643839);
                                ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                boolean changed4 = composer4.changed(sheetState5);
                                SheetState sheetState7 = sheetState5;
                                Function1<Float, Unit> function13 = function122222;
                                Object rememberedValue8 = composer4.rememberedValue();
                                if (changed4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function13);
                                    composer4.updateRememberedValue(rememberedValue8);
                                }
                                composer4.endReplaceableGroup();
                                Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(offset, (NestedScrollConnection) rememberedValue8, null, 2, null);
                                DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                Orientation orientation = Orientation.Vertical;
                                boolean isVisible = sheetState5.isVisible();
                                boolean isAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                composer4.startReplaceableGroup(-1482643097);
                                ComposerKt.sourceInformation(composer4, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                boolean changed5 = composer4.changed(function122222);
                                Function1<Float, Unit> function14 = function122222;
                                Object rememberedValue9 = composer4.rememberedValue();
                                if (changed5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue9 = (Function3) new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function14, null);
                                    composer4.updateRememberedValue(rememberedValue9);
                                }
                                composer4.endReplaceableGroup();
                                modalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable$default(nestedScroll$default, draggableState, orientation, isVisible, null, isAnimationRunning, null, (Function3) rememberedValue9, false, 168, null), sheetState5, m6344getMaxHeightimpl);
                                Shape shape6 = shape5;
                                long j16 = j14;
                                long j17 = j15;
                                float f11 = f10;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                final SheetState sheetState8 = sheetState5;
                                final Function0<Unit> function04 = function03;
                                final CoroutineScope coroutineScope3 = coroutineScope22222;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = function34;
                                SurfaceKt.m2633SurfaceT9BRK9s(modalBottomSheetAnchors, shape6, j16, j17, f11, 0.0f, null, ComposableLambdaKt.composableLambda(composer4, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                    public final void invoke(Composer composer5, int i30) {
                                        ComposerKt.sourceInformation(composer5, "C230@10738L2649:ModalBottomSheet.android.kt#uh7d8r");
                                        if ((i30 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1096570852, i30, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:230)");
                                            }
                                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Function2<Composer, Integer, Unit> function26 = function25;
                                            final SheetState sheetState9 = sheetState8;
                                            final Function0<Unit> function05 = function04;
                                            final CoroutineScope coroutineScope4 = coroutineScope3;
                                            Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                                            composer5.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer5, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer5, 0);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -11289086, "C274@13360L9:ModalBottomSheet.android.kt#uh7d8r");
                                            composer5.startReplaceableGroup(-11289086);
                                            ComposerKt.sourceInformation(composer5, "233@10896L54,234@11000L48,235@11097L47,239@11348L1874,236@11169L2148");
                                            if (function26 != null) {
                                                Strings.Companion companion3 = Strings.INSTANCE;
                                                final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer5, 0);
                                                Strings.Companion companion4 = Strings.INSTANCE;
                                                final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer5, 0);
                                                Strings.Companion companion5 = Strings.INSTANCE;
                                                final String m2623getStringNWtq284 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer5, 0);
                                                Modifier align2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                                                composer5.startReplaceableGroup(-11288530);
                                                ComposerKt.sourceInformation(composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                                boolean changed6 = composer5.changed(sheetState9) | composer5.changed(m2623getStringNWtq283) | composer5.changed(function05) | composer5.changed(m2623getStringNWtq284) | composer5.changedInstance(coroutineScope4) | composer5.changed(m2623getStringNWtq282);
                                                Object rememberedValue10 = composer5.rememberedValue();
                                                if (changed6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue10 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1
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
                                                            final SheetState sheetState10 = SheetState.this;
                                                            String str = m2623getStringNWtq283;
                                                            String str2 = m2623getStringNWtq284;
                                                            String str3 = m2623getStringNWtq282;
                                                            final Function0<Unit> function06 = function05;
                                                            final CoroutineScope coroutineScope5 = coroutineScope4;
                                                            SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Boolean invoke() {
                                                                    function06.invoke();
                                                                    return true;
                                                                }
                                                            });
                                                            if (sheetState10.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                                                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(sheetState10, null), 3, null);
                                                                        }
                                                                        return true;
                                                                    }

                                                                    /* compiled from: ModalBottomSheet.android.kt */
                                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1", f = "ModalBottomSheet.android.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
                                                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$2$1, reason: invalid class name */
                                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                        final /* synthetic */ SheetState $sheetState;
                                                                        int label;

                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                            super(2, continuation);
                                                                            this.$sheetState = sheetState;
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                            return new AnonymousClass1(this.$sheetState, continuation);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Object invokeSuspend(Object obj) {
                                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                            int i = this.label;
                                                                            if (i == 0) {
                                                                                ResultKt.throwOnFailure(obj);
                                                                                this.label = 1;
                                                                                if (this.$sheetState.expand(this) == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                            } else {
                                                                                if (i != 1) {
                                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                }
                                                                                ResultKt.throwOnFailure(obj);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }
                                                                });
                                                            } else if (sheetState10.getHasPartiallyExpandedState()) {
                                                                SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        if (SheetState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(SheetState.this, null), 3, null);
                                                                        }
                                                                        return true;
                                                                    }

                                                                    /* compiled from: ModalBottomSheet.android.kt */
                                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                    @DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1", f = "ModalBottomSheet.android.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
                                                                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$5$1$1$1$1$3$1, reason: invalid class name */
                                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                        final /* synthetic */ SheetState $this_with;
                                                                        int label;

                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                            super(2, continuation);
                                                                            this.$this_with = sheetState;
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                            return new AnonymousClass1(this.$this_with, continuation);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                        }

                                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                        public final Object invokeSuspend(Object obj) {
                                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                            int i = this.label;
                                                                            if (i == 0) {
                                                                                ResultKt.throwOnFailure(obj);
                                                                                this.label = 1;
                                                                                if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                            } else {
                                                                                if (i != 1) {
                                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                                }
                                                                                ResultKt.throwOnFailure(obj);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue10);
                                                }
                                                composer5.endReplaceableGroup();
                                                Modifier semantics = SemanticsModifierKt.semantics(align2, true, (Function1) rememberedValue10);
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor2);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1407593766, "C271@13279L12:ModalBottomSheet.android.kt#uh7d8r");
                                                function26.invoke(composer5, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                            }
                                            composer5.endReplaceableGroup();
                                            function36.invoke(columnScopeInstance, composer5, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endReplaceableGroup();
                                            composer5.endNode();
                                            composer5.endReplaceableGroup();
                                            composer5.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, 12582912, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 3078, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, ((i15 << 6) & 896) | ((i15 >> 3) & 14) | 3072);
        composer2 = startRestartGroup;
        if (sheetState2.getHasExpandedState()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modalBottomSheetProperties3 = modalBottomSheetProperties42222;
        sheetState3 = sheetState2;
        j11 = j10;
        modifier3 = modifier2;
        f7 = f5;
        shape4 = shape3;
        j12 = j9;
        j5 = j8;
        f8 = f6;
        function23 = function22;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(1)363@16906L69:ModalBottomSheet.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue sheetValue) {
                    return true;
                }
            };
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:363)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(z2, function12, SheetValue.Hidden, false, composer, (i & 14) | 384 | (i & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m2329Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)372@17135L121,391@17696L62,387@17590L168:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053897700, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:370)");
            }
            if (j != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                int i3 = i2;
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
                startRestartGroup.startReplaceableGroup(-1858718943);
                ComposerKt.sourceInformation(startRestartGroup, "378@17368L124");
                if (z) {
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1858718859);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    boolean z2 = (i3 & 112) == 32;
                    ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    companion = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$dismissSheet$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    companion = Modifier.INSTANCE;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companion);
                startRestartGroup.startReplaceableGroup(-1858718531);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean changed = startRestartGroup.changed(animateFloatAsState) | ((i3 & 14) == 4);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$1$1
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
                            float Scrim_3J_VO9M$lambda$5;
                            long j2 = j;
                            Scrim_3J_VO9M$lambda$5 = ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$5(animateFloatAsState);
                            DrawScope.m4607drawRectnJ9OG0$default(drawScope, j2, 0L, 0L, Scrim_3J_VO9M$lambda$5, null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ModalBottomSheet_androidKt.m2329Scrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier modalBottomSheetAnchors(Modifier modifier, final SheetState sheetState, final float f) {
        return OnRemeasuredModifierKt.onSizeChanged(modifier, new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetAnchors$1

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m2333invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m2333invokeozmzZPI(final long j) {
                SheetValue sheetValue;
                final float f2 = f;
                final SheetState sheetState2 = SheetState.this;
                DraggableAnchors<SheetValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(SheetValue.Hidden, f2);
                        if (IntSize.m6558getHeightimpl(j) > f2 / 2 && !sheetState2.getSkipPartiallyExpanded()) {
                            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f2 / 2.0f);
                        }
                        if (IntSize.m6558getHeightimpl(j) != 0) {
                            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, f2 - IntSize.m6558getHeightimpl(j)));
                        }
                    }
                });
                int i = WhenMappings.$EnumSwitchMapping$0[SheetState.this.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()];
                if (i == 1) {
                    sheetValue = SheetValue.Hidden;
                } else if (i == 2 || i == 3) {
                    if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                        sheetValue = SheetValue.PartiallyExpanded;
                    } else {
                        sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                SheetState.this.getAnchoredDraggableState$material3_release().updateAnchors(DraggableAnchors, sheetValue);
            }
        });
    }

    public static final void ModalBottomSheetPopup(final ModalBottomSheetProperties modalBottomSheetProperties, final Function0<Unit> function0, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(738805080);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheetPopup)P(2,1,3)437@19070L7,438@19091L38,439@19158L28,440@19213L29,441@19290L7,442@19331L941,470@20319L248,470@20278L289:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modalBottomSheetProperties) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(windowInsets) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(738805080, i3, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:436)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            UUID uuid = (UUID) RememberSaveableKt.m3680rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, startRestartGroup, 3072, 6);
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i3 >> 9) & 14);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) consume2;
            startRestartGroup.startReplaceableGroup(173201889);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Object obj = rememberedValue;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                ModalBottomSheetWindow modalBottomSheetWindow = new ModalBottomSheetWindow(modalBottomSheetProperties, function0, view, uuid);
                modalBottomSheetWindow.setCustomContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-114385661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1
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

                    public final void invoke(Composer composer2, int i4) {
                        Modifier.Companion companion;
                        Function2 ModalBottomSheetPopup$lambda$8;
                        ComposerKt.sourceInformation(composer2, "C452@19656L568:ModalBottomSheet.android.kt#uh7d8r");
                        if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-114385661, i4, -1, "androidx.compose.material3.ModalBottomSheetPopup.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:452)");
                            }
                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                }
                            }, 1, null), WindowInsets.this);
                            if (Build.VERSION.SDK_INT >= 33) {
                                companion = WindowInsetsPadding_androidKt.imePadding(Modifier.INSTANCE);
                            } else {
                                companion = Modifier.INSTANCE;
                            }
                            Modifier then = windowInsetsPadding.then(companion);
                            State<Function2<Composer, Integer, Unit>> state = rememberUpdatedState;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 321878204, "C463@20186L16:ModalBottomSheet.android.kt#uh7d8r");
                            ModalBottomSheetPopup$lambda$8 = ModalBottomSheet_androidKt.ModalBottomSheetPopup$lambda$8(state);
                            ModalBottomSheetPopup$lambda$8.invoke(composer2, 0);
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
                }));
                startRestartGroup.updateRememberedValue(modalBottomSheetWindow);
                obj = modalBottomSheetWindow;
            }
            final ModalBottomSheetWindow modalBottomSheetWindow2 = (ModalBottomSheetWindow) obj;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(173202877);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(modalBottomSheetWindow2) | startRestartGroup.changed(layoutDirection);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        ModalBottomSheetWindow.this.show();
                        ModalBottomSheetWindow.this.superSetLayoutDirection(layoutDirection);
                        final ModalBottomSheetWindow modalBottomSheetWindow3 = ModalBottomSheetWindow.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                ModalBottomSheetWindow.this.disposeComposition();
                                ModalBottomSheetWindow.this.dismiss();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(modalBottomSheetWindow2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$2
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

                public final void invoke(Composer composer2, int i4) {
                    ModalBottomSheet_androidKt.ModalBottomSheetPopup(ModalBottomSheetProperties.this, function0, windowInsets, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$8(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
