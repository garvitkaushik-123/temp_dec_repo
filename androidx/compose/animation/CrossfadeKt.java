package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Crossfade.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002X\u008a\u0084\u0002"}, d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossfadeKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String str, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        String str2;
        final Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec2;
        final String str3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-310686752);
        ComposerKt.sourceInformation(startRestartGroup, "C(Crossfade)P(4,3!1,2)55@2280L36,56@2332L53:Crossfade.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(t) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                str2 = str;
                i3 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    if (i4 == 4 || (46811 & i3) != 9362 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        TweenSpec tween$default = i4 == 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
                        String str4 = i5 == 0 ? "Crossfade" : str2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-310686752, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:54)");
                        }
                        Modifier modifier4 = companion;
                        FiniteAnimationSpec<Float> finiteAnimationSpec3 = tween$default;
                        Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, startRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpec3, (Function1) null, function3, startRestartGroup, (i3 & 112) | 512 | (i3 & 57344), 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        finiteAnimationSpec2 = finiteAnimationSpec3;
                        str3 = str4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        modifier3 = modifier2;
                        str3 = str2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$1
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

                            public final void invoke(Composer composer2, int i7) {
                                CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec2, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i4 == 4) {
                }
                if (i6 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier modifier42 = companion;
                FiniteAnimationSpec<Float> finiteAnimationSpec32 = tween$default;
                Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, startRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier42, finiteAnimationSpec32, (Function1) null, function3, startRestartGroup, (i3 & 112) | 512 | (i3 & 57344), 4);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
                finiteAnimationSpec2 = finiteAnimationSpec32;
                str3 = str4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            str2 = str;
            if ((i2 & 16) != 0) {
            }
            if (i4 == 4) {
            }
            if (i6 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier422 = companion;
            FiniteAnimationSpec<Float> finiteAnimationSpec322 = tween$default;
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, startRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier422, finiteAnimationSpec322, (Function1) null, function3, startRestartGroup, (i3 & 112) | 512 | (i3 & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            finiteAnimationSpec2 = finiteAnimationSpec322;
            str3 = str4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        str2 = str;
        if ((i2 & 16) != 0) {
        }
        if (i4 == 4) {
        }
        if (i6 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier4222 = companion;
        FiniteAnimationSpec<Float> finiteAnimationSpec3222 = tween$default;
        Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str4, startRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4222, finiteAnimationSpec3222, (Function1) null, function3, startRestartGroup, (i3 & 112) | 512 | (i3 & 57344), 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        finiteAnimationSpec2 = finiteAnimationSpec3222;
        str3 = str4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Function3 function32;
        final Modifier modifier2;
        final FiniteAnimationSpec finiteAnimationSpec2;
        Composer startRestartGroup = composer.startRestartGroup(523603005);
        ComposerKt.sourceInformation(startRestartGroup, "C(Crossfade)P(3,2)71@2743L29,72@2788L53:Crossfade.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            function32 = function3;
        } else {
            function32 = function3;
            if ((i & 7168) == 0) {
                i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
            }
        }
        if (i5 != 4 || (i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            FiniteAnimationSpec tween$default = i5 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(523603005, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:70)");
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(obj, (String) null, startRestartGroup, i3 & 14, 2), modifier3, (FiniteAnimationSpec<Float>) tween$default, (Function1) null, function32, startRestartGroup, (i3 & 112) | 512 | ((i3 << 3) & 57344), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            finiteAnimationSpec2 = tween$default;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            finiteAnimationSpec2 = finiteAnimationSpec;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$2
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
                    CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Function1<? super T, ? extends Object> function12;
        Object rememberedValue;
        SnapshotStateList snapshotStateList;
        LinkedHashMap rememberedValue2;
        Map map;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int size;
        int i6;
        final FiniteAnimationSpec<Float> finiteAnimationSpec2;
        final Function1<? super T, ? extends Object> function13;
        boolean changed;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(679005231);
        ComposerKt.sourceInformation(startRestartGroup, "C(Crossfade)P(3!1,2)103@4375L64,104@4461L66,138@5750L159:Crossfade.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                function12 = function1;
                i3 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                if ((i2 & 8) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                }
                if (i4 == 2 || (46811 & i3) != 9362 || !startRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    TweenSpec tween$default = i4 != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec;
                    CrossfadeKt$Crossfade$3 crossfadeKt$Crossfade$3 = i5 != 0 ? new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t) {
                            return t;
                        }
                    } : function12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(679005231, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    Object obj = rememberedValue;
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        SnapshotStateList mutableStateListOf = SnapshotStateKt.mutableStateListOf();
                        mutableStateListOf.add(transition.getCurrentState());
                        startRestartGroup.updateRememberedValue(mutableStateListOf);
                        obj = mutableStateListOf;
                    }
                    startRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) obj;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new LinkedHashMap();
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    map = (Map) rememberedValue2;
                    if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && (snapshotStateList.size() != 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition.getTargetState()))) {
                        SnapshotStateList snapshotStateList2 = snapshotStateList;
                        startRestartGroup.startReplaceableGroup(-928916520);
                        changed = startRestartGroup.changed(transition);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t, transition.getTargetState()));
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                                    return invoke((CrossfadeKt$Crossfade$4$1<T>) obj2);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        CollectionsKt.removeAll((List) snapshotStateList2, (Function1) rememberedValue3);
                        map.clear();
                    }
                    if (!map.containsKey(transition.getTargetState())) {
                        SnapshotStateList snapshotStateList3 = snapshotStateList;
                        Iterator<T> it = snapshotStateList3.iterator();
                        int i8 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i8 = -1;
                                break;
                            } else if (Intrinsics.areEqual(crossfadeKt$Crossfade$3.invoke(it.next()), crossfadeKt$Crossfade$3.invoke(transition.getTargetState()))) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                        if (i8 == -1) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i8, transition.getTargetState());
                        }
                        map.clear();
                        int size2 = snapshotStateList3.size();
                        for (int i9 = 0; i9 < size2; i9++) {
                            T t = snapshotStateList3.get(i9);
                            map.put(t, ComposableLambdaKt.composableLambda(startRestartGroup, -1426421288, true, new CrossfadeKt$Crossfade$5$1(transition, tween$default, t, function3)));
                        }
                    }
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
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
                    m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2072161918, "C:Crossfade.kt#xbi5r1");
                    startRestartGroup.startReplaceableGroup(-1621447954);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    SnapshotStateList snapshotStateList4 = snapshotStateList;
                    size = snapshotStateList4.size();
                    for (i6 = 0; i6 < size; i6++) {
                        Object obj2 = snapshotStateList4.get(i6);
                        startRestartGroup.startMovableGroup(-450541366, crossfadeKt$Crossfade$3.invoke(obj2));
                        ComposerKt.sourceInformation(startRestartGroup, "141@5871L8");
                        Function2 function2 = (Function2) map.get(obj2);
                        if (function2 != null) {
                            function2.invoke(startRestartGroup, 0);
                        }
                        startRestartGroup.endMovableGroup();
                    }
                    startRestartGroup.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    finiteAnimationSpec2 = tween$default;
                    function13 = crossfadeKt$Crossfade$3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    function13 = function12;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$7
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

                        public final void invoke(Composer composer2, int i10) {
                            CrossfadeKt.Crossfade(transition, modifier3, finiteAnimationSpec2, function13, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            function12 = function1;
            if ((i2 & 8) != 0) {
            }
            if (i4 == 2) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            Object obj3 = rememberedValue;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) obj3;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            map = (Map) rememberedValue2;
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                SnapshotStateList snapshotStateList22 = snapshotStateList;
                startRestartGroup.startReplaceableGroup(-928916520);
                changed = startRestartGroup.changed(transition);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t2) {
                        return Boolean.valueOf(!Intrinsics.areEqual(t2, transition.getTargetState()));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj22) {
                        return invoke((CrossfadeKt$Crossfade$4$1<T>) obj22);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                CollectionsKt.removeAll((List) snapshotStateList22, (Function1) rememberedValue3);
                map.clear();
            }
            if (!map.containsKey(transition.getTargetState())) {
            }
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2072161918, "C:Crossfade.kt#xbi5r1");
            startRestartGroup.startReplaceableGroup(-1621447954);
            ComposerKt.sourceInformation(startRestartGroup, "");
            SnapshotStateList snapshotStateList42 = snapshotStateList;
            size = snapshotStateList42.size();
            while (i6 < size) {
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            finiteAnimationSpec2 = tween$default;
            function13 = crossfadeKt$Crossfade$3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function12 = function1;
        if ((i2 & 8) != 0) {
        }
        if (i4 == 2) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        Object obj32 = rememberedValue;
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        snapshotStateList = (SnapshotStateList) obj32;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        map = (Map) rememberedValue2;
        if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (!map.containsKey(transition.getTargetState())) {
        }
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(modifier2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2072161918, "C:Crossfade.kt#xbi5r1");
        startRestartGroup.startReplaceableGroup(-1621447954);
        ComposerKt.sourceInformation(startRestartGroup, "");
        SnapshotStateList snapshotStateList422 = snapshotStateList;
        size = snapshotStateList422.size();
        while (i6 < size) {
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        finiteAnimationSpec2 = tween$default;
        function13 = crossfadeKt$Crossfade$3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
