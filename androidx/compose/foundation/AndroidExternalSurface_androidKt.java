package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidExternalSurface.android.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidExternalSurface_androidKt {
    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        composer.startReplaceableGroup(-873615933);
        ComposerKt.sourceInformation(composer, "C(rememberAndroidExternalSurfaceState)190@7150L24,191@7186L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidExternalSurfaceState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0063  */
    /* renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m523AndroidExternalSurface58FFMhA(Modifier modifier, boolean z, long j, int i, boolean z2, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z3;
        long j2;
        int i5;
        int i6;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        Modifier modifier3;
        int i9;
        long j3;
        boolean changed;
        final int i10;
        final boolean z6;
        Object obj;
        final long j4;
        final boolean z7;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(640888974);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidExternalSurface)P(2!1,4:c#ui.unit.IntSize,5:c#foundation.AndroidExternalSurfaceZOrder)288@12167L37,290@12210L1032:AndroidExternalSurface.android.kt#71ulvw");
        int i11 = i3 & 1;
        if (i11 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            z3 = z;
            i4 |= startRestartGroup.changed(z3) ? 32 : 16;
            if ((i2 & 896) != 0) {
                j2 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? 2048 : 1024;
                i7 = i3 & 16;
                if (i7 != 0) {
                    i4 |= 24576;
                } else if ((57344 & i2) == 0) {
                    z4 = z2;
                    i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                    if ((i3 & 32) != 0) {
                        if ((458752 & i2) == 0) {
                            i8 = startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                        }
                        if ((374491 & i4) == 74898 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i11 != 0 ? Modifier.INSTANCE : modifier2;
                                z5 = i12 != 0 ? true : z3;
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    j2 = IntSize.INSTANCE.m6564getZeroYbymL2g();
                                }
                                if (i5 != 0) {
                                    i6 = AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc();
                                }
                                modifier3 = companion;
                                i9 = i4;
                                j3 = j2;
                                if (i7 != 0) {
                                    z4 = false;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                i9 = i4;
                                z5 = z3;
                                modifier3 = modifier2;
                                j3 = j2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(640888974, i9, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)");
                            }
                            final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
                            Function1<Context, SurfaceView> function12 = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final SurfaceView invoke(Context context) {
                                    SurfaceView surfaceView = new SurfaceView(context);
                                    Function1<AndroidExternalSurfaceScope, Unit> function13 = function1;
                                    AndroidExternalSurfaceState androidExternalSurfaceState = rememberAndroidExternalSurfaceState;
                                    function13.invoke(androidExternalSurfaceState);
                                    surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                                    return surfaceView;
                                }
                            };
                            AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SurfaceView surfaceView) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                    invoke2(surfaceView);
                                    return Unit.INSTANCE;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1909066533);
                            changed = startRestartGroup.changed(j3) | startRestartGroup.changed(z5) | startRestartGroup.changed(i6) | startRestartGroup.changed(z4);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                final boolean z8 = z5;
                                final long j5 = j3;
                                final int i13 = i6;
                                final boolean z9 = z4;
                                i10 = i13;
                                z6 = z9;
                                obj = (Function1) new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                                        invoke2(surfaceView);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SurfaceView surfaceView) {
                                        if (!IntSize.m6557equalsimpl0(j5, IntSize.INSTANCE.m6564getZeroYbymL2g())) {
                                            surfaceView.getHolder().setFixedSize(IntSize.m6559getWidthimpl(j5), IntSize.m6558getHeightimpl(j5));
                                        } else {
                                            surfaceView.getHolder().setSizeFromLayout();
                                        }
                                        surfaceView.getHolder().setFormat(z8 ? -1 : -3);
                                        int i14 = i13;
                                        if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc())) {
                                            surfaceView.setZOrderOnTop(false);
                                        } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m520getMediaOverlayB_4ceCc())) {
                                            surfaceView.setZOrderMediaOverlay(true);
                                        } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m521getOnTopB_4ceCc())) {
                                            surfaceView.setZOrderOnTop(true);
                                        }
                                        surfaceView.setSecure(z9);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(obj);
                            } else {
                                i10 = i6;
                                obj = rememberedValue;
                                z6 = z4;
                            }
                            startRestartGroup.endReplaceableGroup();
                            AndroidView_androidKt.AndroidView(function12, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$2, null, (Function1) obj, startRestartGroup, ((i9 << 3) & 112) | 384, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j3;
                            z7 = z5;
                            modifier4 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z7 = z3;
                            j4 = j2;
                            i10 = i6;
                            z6 = z4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4
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

                                public final void invoke(Composer composer2, int i14) {
                                    AndroidExternalSurface_androidKt.m523AndroidExternalSurface58FFMhA(Modifier.this, z7, j4, i10, z6, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i4 |= i8;
                    if ((374491 & i4) == 74898) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    modifier3 = companion;
                    i9 = i4;
                    j3 = j2;
                    if (i7 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState2 = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
                    Function1<Context, SurfaceView> function122 = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final SurfaceView invoke(Context context) {
                            SurfaceView surfaceView = new SurfaceView(context);
                            Function1<AndroidExternalSurfaceScope, Unit> function13 = function1;
                            AndroidExternalSurfaceState androidExternalSurfaceState = rememberAndroidExternalSurfaceState2;
                            function13.invoke(androidExternalSurfaceState);
                            surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                            return surfaceView;
                        }
                    };
                    AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$22 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SurfaceView surfaceView) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                            invoke2(surfaceView);
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1909066533);
                    changed = startRestartGroup.changed(j3) | startRestartGroup.changed(z5) | startRestartGroup.changed(i6) | startRestartGroup.changed(z4);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    final boolean z82 = z5;
                    final long j52 = j3;
                    final int i132 = i6;
                    final boolean z92 = z4;
                    i10 = i132;
                    z6 = z92;
                    obj = (Function1) new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                            invoke2(surfaceView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SurfaceView surfaceView) {
                            if (!IntSize.m6557equalsimpl0(j52, IntSize.INSTANCE.m6564getZeroYbymL2g())) {
                                surfaceView.getHolder().setFixedSize(IntSize.m6559getWidthimpl(j52), IntSize.m6558getHeightimpl(j52));
                            } else {
                                surfaceView.getHolder().setSizeFromLayout();
                            }
                            surfaceView.getHolder().setFormat(z82 ? -1 : -3);
                            int i14 = i132;
                            if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc())) {
                                surfaceView.setZOrderOnTop(false);
                            } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m520getMediaOverlayB_4ceCc())) {
                                surfaceView.setZOrderMediaOverlay(true);
                            } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m521getOnTopB_4ceCc())) {
                                surfaceView.setZOrderOnTop(true);
                            }
                            surfaceView.setSecure(z92);
                        }
                    };
                    startRestartGroup.updateRememberedValue(obj);
                    startRestartGroup.endReplaceableGroup();
                    AndroidView_androidKt.AndroidView(function122, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$22, null, (Function1) obj, startRestartGroup, ((i9 << 3) & 112) | 384, 8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j4 = j3;
                    z7 = z5;
                    modifier4 = modifier3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z2;
                if ((i3 & 32) != 0) {
                }
                i4 |= i8;
                if ((374491 & i4) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                modifier3 = companion;
                i9 = i4;
                j3 = j2;
                if (i7 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState22 = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
                Function1<Context, SurfaceView> function1222 = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final SurfaceView invoke(Context context) {
                        SurfaceView surfaceView = new SurfaceView(context);
                        Function1<AndroidExternalSurfaceScope, Unit> function13 = function1;
                        AndroidExternalSurfaceState androidExternalSurfaceState = rememberAndroidExternalSurfaceState22;
                        function13.invoke(androidExternalSurfaceState);
                        surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                        return surfaceView;
                    }
                };
                AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$222 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SurfaceView surfaceView) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                        invoke2(surfaceView);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.startReplaceableGroup(-1909066533);
                changed = startRestartGroup.changed(j3) | startRestartGroup.changed(z5) | startRestartGroup.changed(i6) | startRestartGroup.changed(z4);
                Object rememberedValue22 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                final boolean z822 = z5;
                final long j522 = j3;
                final int i1322 = i6;
                final boolean z922 = z4;
                i10 = i1322;
                z6 = z922;
                obj = (Function1) new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                        invoke2(surfaceView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SurfaceView surfaceView) {
                        if (!IntSize.m6557equalsimpl0(j522, IntSize.INSTANCE.m6564getZeroYbymL2g())) {
                            surfaceView.getHolder().setFixedSize(IntSize.m6559getWidthimpl(j522), IntSize.m6558getHeightimpl(j522));
                        } else {
                            surfaceView.getHolder().setSizeFromLayout();
                        }
                        surfaceView.getHolder().setFormat(z822 ? -1 : -3);
                        int i14 = i1322;
                        if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc())) {
                            surfaceView.setZOrderOnTop(false);
                        } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m520getMediaOverlayB_4ceCc())) {
                            surfaceView.setZOrderMediaOverlay(true);
                        } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m521getOnTopB_4ceCc())) {
                            surfaceView.setZOrderOnTop(true);
                        }
                        surfaceView.setSecure(z922);
                    }
                };
                startRestartGroup.updateRememberedValue(obj);
                startRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView(function1222, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$222, null, (Function1) obj, startRestartGroup, ((i9 << 3) & 112) | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                j4 = j3;
                z7 = z5;
                modifier4 = modifier3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i6 = i;
            i7 = i3 & 16;
            if (i7 != 0) {
            }
            z4 = z2;
            if ((i3 & 32) != 0) {
            }
            i4 |= i8;
            if ((374491 & i4) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            modifier3 = companion;
            i9 = i4;
            j3 = j2;
            if (i7 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState222 = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
            Function1<Context, SurfaceView> function12222 = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SurfaceView invoke(Context context) {
                    SurfaceView surfaceView = new SurfaceView(context);
                    Function1<AndroidExternalSurfaceScope, Unit> function13 = function1;
                    AndroidExternalSurfaceState androidExternalSurfaceState = rememberAndroidExternalSurfaceState222;
                    function13.invoke(androidExternalSurfaceState);
                    surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                    return surfaceView;
                }
            };
            AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$2222 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SurfaceView surfaceView) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                    invoke2(surfaceView);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.startReplaceableGroup(-1909066533);
            changed = startRestartGroup.changed(j3) | startRestartGroup.changed(z5) | startRestartGroup.changed(i6) | startRestartGroup.changed(z4);
            Object rememberedValue222 = startRestartGroup.rememberedValue();
            if (changed) {
            }
            final boolean z8222 = z5;
            final long j5222 = j3;
            final int i13222 = i6;
            final boolean z9222 = z4;
            i10 = i13222;
            z6 = z9222;
            obj = (Function1) new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                    invoke2(surfaceView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SurfaceView surfaceView) {
                    if (!IntSize.m6557equalsimpl0(j5222, IntSize.INSTANCE.m6564getZeroYbymL2g())) {
                        surfaceView.getHolder().setFixedSize(IntSize.m6559getWidthimpl(j5222), IntSize.m6558getHeightimpl(j5222));
                    } else {
                        surfaceView.getHolder().setSizeFromLayout();
                    }
                    surfaceView.getHolder().setFormat(z8222 ? -1 : -3);
                    int i14 = i13222;
                    if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc())) {
                        surfaceView.setZOrderOnTop(false);
                    } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m520getMediaOverlayB_4ceCc())) {
                        surfaceView.setZOrderMediaOverlay(true);
                    } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m521getOnTopB_4ceCc())) {
                        surfaceView.setZOrderOnTop(true);
                    }
                    surfaceView.setSecure(z9222);
                }
            };
            startRestartGroup.updateRememberedValue(obj);
            startRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView(function12222, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$2222, null, (Function1) obj, startRestartGroup, ((i9 << 3) & 112) | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j3;
            z7 = z5;
            modifier4 = modifier3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z3 = z;
        if ((i2 & 896) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        i6 = i;
        i7 = i3 & 16;
        if (i7 != 0) {
        }
        z4 = z2;
        if ((i3 & 32) != 0) {
        }
        i4 |= i8;
        if ((374491 & i4) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        modifier3 = companion;
        i9 = i4;
        j3 = j2;
        if (i7 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState2222 = rememberAndroidExternalSurfaceState(startRestartGroup, 0);
        Function1<Context, SurfaceView> function122222 = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SurfaceView invoke(Context context) {
                SurfaceView surfaceView = new SurfaceView(context);
                Function1<AndroidExternalSurfaceScope, Unit> function13 = function1;
                AndroidExternalSurfaceState androidExternalSurfaceState = rememberAndroidExternalSurfaceState2222;
                function13.invoke(androidExternalSurfaceState);
                surfaceView.getHolder().addCallback(androidExternalSurfaceState);
                return surfaceView;
            }
        };
        AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$22222 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurfaceView surfaceView) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                invoke2(surfaceView);
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.startReplaceableGroup(-1909066533);
        changed = startRestartGroup.changed(j3) | startRestartGroup.changed(z5) | startRestartGroup.changed(i6) | startRestartGroup.changed(z4);
        Object rememberedValue2222 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        final boolean z82222 = z5;
        final long j52222 = j3;
        final int i132222 = i6;
        final boolean z92222 = z4;
        i10 = i132222;
        z6 = z92222;
        obj = (Function1) new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                invoke2(surfaceView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurfaceView surfaceView) {
                if (!IntSize.m6557equalsimpl0(j52222, IntSize.INSTANCE.m6564getZeroYbymL2g())) {
                    surfaceView.getHolder().setFixedSize(IntSize.m6559getWidthimpl(j52222), IntSize.m6558getHeightimpl(j52222));
                } else {
                    surfaceView.getHolder().setSizeFromLayout();
                }
                surfaceView.getHolder().setFormat(z82222 ? -1 : -3);
                int i14 = i132222;
                if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m519getBehindB_4ceCc())) {
                    surfaceView.setZOrderOnTop(false);
                } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m520getMediaOverlayB_4ceCc())) {
                    surfaceView.setZOrderMediaOverlay(true);
                } else if (AndroidExternalSurfaceZOrder.m515equalsimpl0(i14, AndroidExternalSurfaceZOrder.INSTANCE.m521getOnTopB_4ceCc())) {
                    surfaceView.setZOrderOnTop(true);
                }
                surfaceView.setSecure(z92222);
            }
        };
        startRestartGroup.updateRememberedValue(obj);
        startRestartGroup.endReplaceableGroup();
        AndroidView_androidKt.AndroidView(function122222, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$22222, null, (Function1) obj, startRestartGroup, ((i9 << 3) & 112) | 384, 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        j4 = j3;
        z7 = z5;
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        composer.startReplaceableGroup(-1057437053);
        ComposerKt.sourceInformation(composer, "C(rememberAndroidEmbeddedExternalSurfaceState)384@15036L24,385@15072L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0065  */
    /* renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m522AndroidEmbeddedExternalSurfacesv6N_fY(Modifier modifier, boolean z, long j, float[] fArr, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        long j2;
        int i4;
        final float[] fArr2;
        final boolean z3;
        Modifier modifier3;
        final long j3;
        final long j4;
        final Modifier modifier4;
        final boolean z4;
        final float[] fArr3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(217541314);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidEmbeddedExternalSurface)P(1!1,3:c#ui.unit.IntSize,4:c#ui.graphics.Matrix)455@18917L45,457@18968L796:AndroidExternalSurface.android.kt#71ulvw");
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
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    if (startRestartGroup.changed(j2)) {
                        i5 = 256;
                        i3 |= i5;
                    }
                } else {
                    j2 = j;
                }
                i5 = 128;
                i3 |= i5;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
            }
            if (i4 == 8 || (46811 & i3) != 9362 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    boolean z5 = i7 == 0 ? true : z2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        j2 = IntSize.INSTANCE.m6564getZeroYbymL2g();
                    }
                    if (i4 == 0) {
                        z3 = z5;
                        fArr2 = null;
                    } else {
                        fArr2 = fArr;
                        z3 = z5;
                    }
                    modifier3 = companion;
                    j3 = j2;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    modifier3 = modifier2;
                    j3 = j2;
                    fArr2 = fArr;
                    z3 = z2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(217541314, i3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)");
                }
                final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(startRestartGroup, 0);
                final long j5 = j3;
                AndroidView_androidKt.AndroidView(new Function1<Context, TextureView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TextureView invoke(Context context) {
                        TextureView textureView = new TextureView(context);
                        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = AndroidEmbeddedExternalSurfaceState.this;
                        long j6 = j3;
                        Function1<AndroidExternalSurfaceScope, Unit> function12 = function1;
                        androidEmbeddedExternalSurfaceState.m511setSurfaceSizeozmzZPI(j6);
                        function12.invoke(androidEmbeddedExternalSurfaceState);
                        textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
                        return textureView;
                    }
                }, modifier3, new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextureView textureView) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                        invoke2(textureView);
                        return Unit.INSTANCE;
                    }
                }, null, new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                        invoke2(textureView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextureView textureView) {
                        Matrix matrix;
                        SurfaceTexture surfaceTexture;
                        if (!IntSize.m6557equalsimpl0(j5, IntSize.INSTANCE.m6564getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
                            surfaceTexture.setDefaultBufferSize(IntSize.m6559getWidthimpl(j5), IntSize.m6558getHeightimpl(j5));
                        }
                        rememberAndroidEmbeddedExternalSurfaceState.m511setSurfaceSizeozmzZPI(j5);
                        textureView.setOpaque(z3);
                        float[] fArr4 = fArr2;
                        if (fArr4 != null) {
                            matrix = rememberAndroidEmbeddedExternalSurfaceState.getMatrix();
                            AndroidMatrixConversions_androidKt.m3933setFromEL8BTi8(matrix, fArr4);
                        } else {
                            matrix = null;
                        }
                        textureView.setTransform(matrix);
                    }
                }, startRestartGroup, ((i3 << 3) & 112) | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j5;
                modifier4 = modifier3;
                z4 = z3;
                fArr3 = fArr2;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                z4 = z2;
                j4 = j2;
                fArr3 = fArr;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4
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
                        AndroidExternalSurface_androidKt.m522AndroidEmbeddedExternalSurfacesv6N_fY(Modifier.this, z4, j4, fArr3, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        z2 = z;
        if ((i & 896) != 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i4 == 8) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 == 0) {
        }
        modifier3 = companion;
        j3 = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState2 = rememberAndroidEmbeddedExternalSurfaceState(startRestartGroup, 0);
        final long j52 = j3;
        AndroidView_androidKt.AndroidView(new Function1<Context, TextureView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TextureView invoke(Context context) {
                TextureView textureView = new TextureView(context);
                AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = AndroidEmbeddedExternalSurfaceState.this;
                long j6 = j3;
                Function1<AndroidExternalSurfaceScope, Unit> function12 = function1;
                androidEmbeddedExternalSurfaceState.m511setSurfaceSizeozmzZPI(j6);
                function12.invoke(androidEmbeddedExternalSurfaceState);
                textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
                return textureView;
            }
        }, modifier3, new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextureView textureView) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                invoke2(textureView);
                return Unit.INSTANCE;
            }
        }, null, new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                invoke2(textureView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextureView textureView) {
                Matrix matrix;
                SurfaceTexture surfaceTexture;
                if (!IntSize.m6557equalsimpl0(j52, IntSize.INSTANCE.m6564getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
                    surfaceTexture.setDefaultBufferSize(IntSize.m6559getWidthimpl(j52), IntSize.m6558getHeightimpl(j52));
                }
                rememberAndroidEmbeddedExternalSurfaceState2.m511setSurfaceSizeozmzZPI(j52);
                textureView.setOpaque(z3);
                float[] fArr4 = fArr2;
                if (fArr4 != null) {
                    matrix = rememberAndroidEmbeddedExternalSurfaceState2.getMatrix();
                    AndroidMatrixConversions_androidKt.m3933setFromEL8BTi8(matrix, fArr4);
                } else {
                    matrix = null;
                }
                textureView.setTransform(matrix);
            }
        }, startRestartGroup, ((i3 << 3) & 112) | 384, 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        j4 = j52;
        modifier4 = modifier3;
        z4 = z3;
        fArr3 = fArr2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
