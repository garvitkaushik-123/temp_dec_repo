package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: AndroidMenu.android.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001aa\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0069  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1524DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function02;
        Modifier modifier2;
        int i4;
        long j2;
        int i5;
        PopupProperties popupProperties2;
        Function3 function32;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-840283139);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)59@2347L21,54@2203L219:AndroidMenu.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                j2 = j;
                i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    popupProperties2 = popupProperties;
                    i3 |= startRestartGroup.changed(popupProperties2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        function32 = function3;
                        i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                float f = 0;
                                j2 = DpKt.m6410DpOffsetYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
                            }
                            PopupProperties popupProperties4 = i5 != 0 ? new PopupProperties(true, false, false, null, false, false, 62, null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-840283139, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:54)");
                            }
                            int i7 = i3 & 8190;
                            int i8 = i3 << 3;
                            composer2 = startRestartGroup;
                            Modifier modifier4 = companion;
                            long j4 = j2;
                            m1523DropdownMenu4kj_NE(z2, function02, modifier4, j4, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i7 | (i8 & 458752) | (i8 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j3 = j4;
                            popupProperties3 = popupProperties4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            j3 = j2;
                            popupProperties3 = popupProperties2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
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

                                public final void invoke(Composer composer3, int i9) {
                                    AndroidMenu_androidKt.m1524DropdownMenuILWXrKs(z, function0, modifier3, j3, popupProperties3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function32 = function3;
                    if ((374491 & i3) == 74898) {
                    }
                    if (i6 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i72 = i3 & 8190;
                    int i82 = i3 << 3;
                    composer2 = startRestartGroup;
                    Modifier modifier42 = companion;
                    long j42 = j2;
                    m1523DropdownMenu4kj_NE(z2, function02, modifier42, j42, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i72 | (i82 & 458752) | (i82 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    j3 = j42;
                    popupProperties3 = popupProperties4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i2 & 32) == 0) {
                }
                function32 = function3;
                if ((374491 & i3) == 74898) {
                }
                if (i6 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i722 = i3 & 8190;
                int i822 = i3 << 3;
                composer2 = startRestartGroup;
                Modifier modifier422 = companion;
                long j422 = j2;
                m1523DropdownMenu4kj_NE(z2, function02, modifier422, j422, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i722 | (i822 & 458752) | (i822 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                j3 = j422;
                popupProperties3 = popupProperties4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            j2 = j;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 32) == 0) {
            }
            function32 = function3;
            if ((374491 & i3) == 74898) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i7222 = i3 & 8190;
            int i8222 = i3 << 3;
            composer2 = startRestartGroup;
            Modifier modifier4222 = companion;
            long j4222 = j2;
            m1523DropdownMenu4kj_NE(z2, function02, modifier4222, j4222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i7222 | (i8222 & 458752) | (i8222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            j3 = j4222;
            popupProperties3 = popupProperties4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        j2 = j;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 32) == 0) {
        }
        function32 = function3;
        if ((374491 & i3) == 74898) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i72222 = i3 & 8190;
        int i82222 = i3 << 3;
        composer2 = startRestartGroup;
        Modifier modifier42222 = companion;
        long j42222 = j2;
        m1523DropdownMenu4kj_NE(z2, function02, modifier42222, j42222, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), popupProperties4, function32, composer2, i72222 | (i82222 & 458752) | (i82222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        j3 = j42222;
        popupProperties3 = popupProperties4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a4  */
    /* renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1523DropdownMenu4kj_NE(boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        long j2;
        ScrollState scrollState2;
        int i6;
        PopupProperties popupProperties2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier3;
        long j3;
        PopupProperties popupProperties3;
        final ScrollState scrollState3;
        Object rememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        final PopupProperties popupProperties4;
        Composer composer2;
        final ScrollState scrollState4;
        final Modifier modifier4;
        final long j4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-2135362555);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)116@5501L21,120@5670L42,124@5860L51,125@5947L7,133@6212L443:AndroidMenu.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
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
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            scrollState2 = scrollState;
                            if (startRestartGroup.changed(scrollState2)) {
                                i7 = 16384;
                                i3 |= i7;
                            }
                        } else {
                            scrollState2 = scrollState;
                        }
                        i7 = 8192;
                        i3 |= i7;
                    } else {
                        scrollState2 = scrollState;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= startRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        float f = 0;
                                        j2 = DpKt.m6410DpOffsetYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                    }
                                    if (i6 != 0) {
                                        modifier3 = modifier2;
                                        j3 = j2;
                                        popupProperties3 = new PopupProperties(true, false, false, null, false, false, 62, null);
                                        scrollState3 = scrollState2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135362555, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:119)");
                                        }
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new MutableTransitionState(false);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableTransitionState = (MutableTransitionState) rememberedValue;
                                        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                                        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4440boximpl(TransformOrigin.INSTANCE.m4453getCenterSzJe1aQ()), null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final MutableState mutableState = (MutableState) rememberedValue2;
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Density density = (Density) consume;
                                            startRestartGroup.startReplaceableGroup(-1751434383);
                                            changed = startRestartGroup.changed(mutableState);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                                        invoke2(intRect, intRect2);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(IntRect intRect, IntRect intRect2) {
                                                        mutableState.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                                                public final void invoke(Composer composer3, int i8) {
                                                    ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                                                    if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                                                        }
                                                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState3, modifier3, function33, composer3, MutableTransitionState.$stable | 48, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        popupProperties4 = popupProperties3;
                                        composer2 = startRestartGroup;
                                        scrollState4 = scrollState3;
                                        modifier4 = modifier3;
                                        j4 = j3;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                }
                                modifier3 = modifier2;
                                j3 = j2;
                                scrollState3 = scrollState2;
                                popupProperties3 = popupProperties2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableTransitionState = (MutableTransitionState) rememberedValue;
                                mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                                if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState<TransformOrigin> mutableState2 = (MutableState) rememberedValue2;
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Density density2 = (Density) consume2;
                                startRestartGroup.startReplaceableGroup(-1751434383);
                                changed = startRestartGroup.changed(mutableState2);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                        invoke2(intRect, intRect2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(IntRect intRect, IntRect intRect2) {
                                        mutableState2.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                startRestartGroup.endReplaceableGroup();
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density2, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                                    public final void invoke(Composer composer3, int i8) {
                                        ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                                        if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                                            }
                                            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2, scrollState3, modifier3, function332, composer3, MutableTransitionState.$stable | 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                popupProperties4 = popupProperties3;
                                composer2 = startRestartGroup;
                                scrollState4 = scrollState3;
                                modifier4 = modifier3;
                                j4 = j3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer2 = startRestartGroup;
                                modifier4 = modifier2;
                                j4 = j2;
                                scrollState4 = scrollState2;
                                popupProperties4 = popupProperties2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                final boolean z3 = z2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$3
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

                                    public final void invoke(Composer composer3, int i8) {
                                        AndroidMenu_androidKt.m1523DropdownMenu4kj_NE(z3, function0, modifier4, j4, scrollState4, popupProperties4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 2995931) == 599186) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        modifier3 = modifier2;
                        j3 = j2;
                        scrollState3 = scrollState2;
                        popupProperties3 = popupProperties2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableTransitionState = (MutableTransitionState) rememberedValue;
                        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<TransformOrigin> mutableState22 = (MutableState) rememberedValue2;
                        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localDensity22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density22 = (Density) consume22;
                        startRestartGroup.startReplaceableGroup(-1751434383);
                        changed = startRestartGroup.changed(mutableState22);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                invoke2(intRect, intRect2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(IntRect intRect, IntRect intRect2) {
                                mutableState22.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322 = function32;
                        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density22, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                            public final void invoke(Composer composer3, int i8) {
                                ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                                if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                                    }
                                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState22, scrollState3, modifier3, function3322, composer3, MutableTransitionState.$stable | 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        popupProperties4 = popupProperties3;
                        composer2 = startRestartGroup;
                        scrollState4 = scrollState3;
                        modifier4 = modifier3;
                        j4 = j3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    popupProperties2 = popupProperties;
                    if ((i2 & 64) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 2995931) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = modifier2;
                    j3 = j2;
                    scrollState3 = scrollState2;
                    popupProperties3 = popupProperties2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    mutableTransitionState = (MutableTransitionState) rememberedValue;
                    mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<TransformOrigin> mutableState222 = (MutableState) rememberedValue2;
                    ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localDensity222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density222 = (Density) consume222;
                    startRestartGroup.startReplaceableGroup(-1751434383);
                    changed = startRestartGroup.changed(mutableState222);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                            invoke2(intRect, intRect2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IntRect intRect, IntRect intRect2) {
                            mutableState222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222 = function32;
                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density222, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                        public final void invoke(Composer composer3, int i8) {
                            ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                            if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                                }
                                MenuKt.DropdownMenuContent(mutableTransitionState, mutableState222, scrollState3, modifier3, function33222, composer3, MutableTransitionState.$stable | 48, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    popupProperties4 = popupProperties3;
                    composer2 = startRestartGroup;
                    scrollState4 = scrollState3;
                    modifier4 = modifier3;
                    j4 = j3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                j2 = j;
                if ((57344 & i) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                popupProperties2 = popupProperties;
                if ((i2 & 64) != 0) {
                }
                function32 = function3;
                if ((i3 & 2995931) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = modifier2;
                j3 = j2;
                scrollState3 = scrollState2;
                popupProperties3 = popupProperties2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                mutableTransitionState = (MutableTransitionState) rememberedValue;
                mutableTransitionState.setTargetState(Boolean.valueOf(z2));
                if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<TransformOrigin> mutableState2222 = (MutableState) rememberedValue2;
                ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localDensity2222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2222 = (Density) consume2222;
                startRestartGroup.startReplaceableGroup(-1751434383);
                changed = startRestartGroup.changed(mutableState2222);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                        invoke2(intRect, intRect2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IntRect intRect, IntRect intRect2) {
                        mutableState2222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332222 = function32;
                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density2222, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                    public final void invoke(Composer composer3, int i8) {
                        ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                        if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                            }
                            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState2222, scrollState3, modifier3, function332222, composer3, MutableTransitionState.$stable | 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                popupProperties4 = popupProperties3;
                composer2 = startRestartGroup;
                scrollState4 = scrollState3;
                modifier4 = modifier3;
                j4 = j3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            j2 = j;
            if ((57344 & i) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 64) != 0) {
            }
            function32 = function3;
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = modifier2;
            j3 = j2;
            scrollState3 = scrollState2;
            popupProperties3 = popupProperties2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableTransitionState = (MutableTransitionState) rememberedValue;
            mutableTransitionState.setTargetState(Boolean.valueOf(z2));
            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<TransformOrigin> mutableState22222 = (MutableState) rememberedValue2;
            ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localDensity22222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density22222 = (Density) consume22222;
            startRestartGroup.startReplaceableGroup(-1751434383);
            changed = startRestartGroup.changed(mutableState22222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                    invoke2(intRect, intRect2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntRect intRect, IntRect intRect2) {
                    mutableState22222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322222 = function32;
            AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density22222, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

                public final void invoke(Composer composer3, int i8) {
                    ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                    if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                        }
                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState22222, scrollState3, modifier3, function3322222, composer3, MutableTransitionState.$stable | 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            popupProperties4 = popupProperties3;
            composer2 = startRestartGroup;
            scrollState4 = scrollState3;
            modifier4 = modifier3;
            j4 = j3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        j2 = j;
        if ((57344 & i) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 64) != 0) {
        }
        function32 = function3;
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = modifier2;
        j3 = j2;
        scrollState3 = scrollState2;
        popupProperties3 = popupProperties2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableTransitionState = (MutableTransitionState) rememberedValue;
        mutableTransitionState.setTargetState(Boolean.valueOf(z2));
        if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TransformOrigin> mutableState222222 = (MutableState) rememberedValue2;
        ProvidableCompositionLocal<Density> localDensity222222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localDensity222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density222222 = (Density) consume222222;
        startRestartGroup.startReplaceableGroup(-1751434383);
        changed = startRestartGroup.changed(mutableState222222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                invoke2(intRect, intRect2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRect intRect, IntRect intRect2) {
                mutableState222222.setValue(TransformOrigin.m4440boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222222 = function32;
        AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(j3, density222222, (Function2) rememberedValue3, null), function0, popupProperties3, ComposableLambdaKt.composableLambda(startRestartGroup, -47803778, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
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

            public final void invoke(Composer composer3, int i8) {
                ComposerKt.sourceInformation(composer3, "C138@6387L258:AndroidMenu.android.kt#jmzs0o");
                if ((i8 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-47803778, i8, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:138)");
                    }
                    MenuKt.DropdownMenuContent(mutableTransitionState, mutableState222222, scrollState3, modifier3, function33222222, composer3, MutableTransitionState.$stable | 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 112) | 3072 | ((i3 >> 9) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        popupProperties4 = popupProperties3;
        composer2 = startRestartGroup;
        scrollState4 = scrollState3;
        modifier4 = modifier3;
        j4 = j3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function0<Unit> function0, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1988562892);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItem)P(5,4,2,1,3)172@7838L39,175@7932L227:AndroidMenu.android.kt#jmzs0o");
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
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((458752 & i) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            }
                        }
                        if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z4 = i4 != 0 ? true : z2;
                            if (i5 != 0) {
                                paddingValues2 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i6 != 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1988562892, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:174)");
                            }
                            boolean z5 = z4;
                            PaddingValues paddingValues4 = paddingValues2;
                            Modifier modifier4 = companion;
                            MenuKt.DropdownMenuItemContent(function02, modifier4, z5, paddingValues4, mutableInteractionSource3, function32, startRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z5;
                            paddingValues3 = paddingValues4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            paddingValues3 = paddingValues2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2
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
                                    AndroidMenu_androidKt.DropdownMenuItem(function0, modifier3, z3, paddingValues3, mutableInteractionSource4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) != 0) {
                    }
                    if ((374491 & i3) == 74898) {
                    }
                    if (i7 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    boolean z52 = z4;
                    PaddingValues paddingValues42 = paddingValues2;
                    Modifier modifier42 = companion;
                    MenuKt.DropdownMenuItemContent(function02, modifier42, z52, paddingValues42, mutableInteractionSource3, function32, startRestartGroup, i3 & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    z3 = z52;
                    paddingValues3 = paddingValues42;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                paddingValues2 = paddingValues;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                boolean z522 = z4;
                PaddingValues paddingValues422 = paddingValues2;
                Modifier modifier422 = companion;
                MenuKt.DropdownMenuItemContent(function02, modifier422, z522, paddingValues422, mutableInteractionSource3, function32, startRestartGroup, i3 & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                z3 = z522;
                paddingValues3 = paddingValues422;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            boolean z5222 = z4;
            PaddingValues paddingValues4222 = paddingValues2;
            Modifier modifier4222 = companion;
            MenuKt.DropdownMenuItemContent(function02, modifier4222, z5222, paddingValues4222, mutableInteractionSource3, function32, startRestartGroup, i3 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            z3 = z5222;
            paddingValues3 = paddingValues4222;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        boolean z52222 = z4;
        PaddingValues paddingValues42222 = paddingValues2;
        Modifier modifier42222 = companion;
        MenuKt.DropdownMenuItemContent(function02, modifier42222, z52222, paddingValues42222, mutableInteractionSource3, function32, startRestartGroup, i3 & 524286, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        z3 = z52222;
        paddingValues3 = paddingValues42222;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
