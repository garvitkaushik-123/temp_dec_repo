package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ClickableText.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClickableTextKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x008a  */
    /* renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1162ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function12, Composer composer, final int i3, final int i4) {
        AnnotatedString annotatedString2;
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        final ClickableTextKt$ClickableText$1 clickableTextKt$ClickableText$1;
        Object rememberedValue;
        boolean changed;
        ClickableTextKt$ClickableText$pressIndicator$1$1 rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final TextStyle textStyle3;
        final boolean z3;
        final int i12;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)79@3637L52,88@3936L297:ClickableText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i3 & 14) == 0) {
                i5 = (startRestartGroup.changed(annotatedString2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        int i14 = i4 & 2;
        if (i14 != 0) {
            i5 |= 48;
        } else if ((i3 & 112) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 896) == 0) {
                textStyle2 = textStyle;
                i5 |= startRestartGroup.changed(textStyle2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    z2 = z;
                    i5 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 3670016) == 0) {
                            i5 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                        }
                        if ((i4 & 128) == 0) {
                            i13 = (29360128 & i3) == 0 ? startRestartGroup.changedInstance(function12) ? 8388608 : 4194304 : 12582912;
                            if ((23967451 & i5) == 4793490 || !startRestartGroup.getSkipping()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                if (i8 != 0) {
                                    i9 = TextOverflow.INSTANCE.m6330getClipgIe3tQ8();
                                }
                                int i15 = i10 == 0 ? Integer.MAX_VALUE : i2;
                                clickableTextKt$ClickableText$1 = i11 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function1;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:78)");
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                startRestartGroup.startReplaceableGroup(-797094589);
                                changed = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(function12);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier then = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
                                startRestartGroup.startReplaceableGroup(-797094184);
                                changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextLayoutResult textLayoutResult) {
                                            mutableState.setValue(textLayoutResult);
                                            clickableTextKt$ClickableText$1.invoke(textLayoutResult);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i16 = i15;
                                composer2 = startRestartGroup;
                                boolean z4 = z2;
                                TextStyle textStyle4 = textStyle2;
                                BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then, textStyle4, (Function1) rememberedValue3, i9, z4, i16, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function13 = clickableTextKt$ClickableText$1;
                                textStyle3 = textStyle4;
                                z3 = z4;
                                i12 = i16;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i12 = i2;
                                composer2 = startRestartGroup;
                                textStyle3 = textStyle2;
                                z3 = z2;
                                function13 = function1;
                            }
                            final Modifier modifier3 = modifier2;
                            final int i17 = i9;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
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

                                    public final void invoke(Composer composer3, int i18) {
                                        ClickableTextKt.m1162ClickableText4YKlhWE(AnnotatedString.this, modifier3, textStyle3, z3, i17, i12, function13, function12, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= i13;
                        if ((23967451 & i5) == 4793490) {
                        }
                        if (i14 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<TextLayoutResult> mutableState2 = (MutableState) rememberedValue;
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        startRestartGroup.startReplaceableGroup(-797094589);
                        changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(function12);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState2, function12, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        Modifier then2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
                        startRestartGroup.startReplaceableGroup(-797094184);
                        changed2 = startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                mutableState2.setValue(textLayoutResult);
                                clickableTextKt$ClickableText$1.invoke(textLayoutResult);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        int i162 = i15;
                        composer2 = startRestartGroup;
                        boolean z42 = z2;
                        TextStyle textStyle42 = textStyle2;
                        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then2, textStyle42, (Function1) rememberedValue3, i9, z42, i162, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function13 = clickableTextKt$ClickableText$1;
                        textStyle3 = textStyle42;
                        z3 = z42;
                        i12 = i162;
                        final Modifier modifier32 = modifier2;
                        final int i172 = i9;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i4 & 128) == 0) {
                    }
                    i5 |= i13;
                    if ((23967451 & i5) == 4793490) {
                    }
                    if (i14 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<TextLayoutResult> mutableState22 = (MutableState) rememberedValue;
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-797094589);
                    changed = startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(function12);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState22, function12, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    Modifier then22 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
                    startRestartGroup.startReplaceableGroup(-797094184);
                    changed2 = startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult textLayoutResult) {
                            mutableState22.setValue(textLayoutResult);
                            clickableTextKt$ClickableText$1.invoke(textLayoutResult);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    int i1622 = i15;
                    composer2 = startRestartGroup;
                    boolean z422 = z2;
                    TextStyle textStyle422 = textStyle2;
                    BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then22, textStyle422, (Function1) rememberedValue3, i9, z422, i1622, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function13 = clickableTextKt$ClickableText$1;
                    textStyle3 = textStyle422;
                    z3 = z422;
                    i12 = i1622;
                    final Modifier modifier322 = modifier2;
                    final int i1722 = i9;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z2 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i4 & 128) == 0) {
                }
                i5 |= i13;
                if ((23967451 & i5) == 4793490) {
                }
                if (i14 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<TextLayoutResult> mutableState222 = (MutableState) rememberedValue;
                Modifier.Companion companion222 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(-797094589);
                changed = startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(function12);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState222, function12, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                Modifier then222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion222, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
                startRestartGroup.startReplaceableGroup(-797094184);
                changed2 = startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult textLayoutResult) {
                        mutableState222.setValue(textLayoutResult);
                        clickableTextKt$ClickableText$1.invoke(textLayoutResult);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                int i16222 = i15;
                composer2 = startRestartGroup;
                boolean z4222 = z2;
                TextStyle textStyle4222 = textStyle2;
                BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then222, textStyle4222, (Function1) rememberedValue3, i9, z4222, i16222, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                function13 = clickableTextKt$ClickableText$1;
                textStyle3 = textStyle4222;
                z3 = z4222;
                i12 = i16222;
                final Modifier modifier3222 = modifier2;
                final int i17222 = i9;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z2 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i4 & 128) == 0) {
            }
            i5 |= i13;
            if ((23967451 & i5) == 4793490) {
            }
            if (i14 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<TextLayoutResult> mutableState2222 = (MutableState) rememberedValue;
            Modifier.Companion companion2222 = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(-797094589);
            changed = startRestartGroup.changed(mutableState2222) | startRestartGroup.changedInstance(function12);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState2222, function12, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            Modifier then2222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2222, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
            startRestartGroup.startReplaceableGroup(-797094184);
            changed2 = startRestartGroup.changed(mutableState2222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult textLayoutResult) {
                    mutableState2222.setValue(textLayoutResult);
                    clickableTextKt$ClickableText$1.invoke(textLayoutResult);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            int i162222 = i15;
            composer2 = startRestartGroup;
            boolean z42222 = z2;
            TextStyle textStyle42222 = textStyle2;
            BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then2222, textStyle42222, (Function1) rememberedValue3, i9, z42222, i162222, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            function13 = clickableTextKt$ClickableText$1;
            textStyle3 = textStyle42222;
            z3 = z42222;
            i12 = i162222;
            final Modifier modifier32222 = modifier2;
            final int i172222 = i9;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z2 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i4 & 128) == 0) {
        }
        i5 |= i13;
        if ((23967451 & i5) == 4793490) {
        }
        if (i14 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TextLayoutResult> mutableState22222 = (MutableState) rememberedValue;
        Modifier.Companion companion22222 = Modifier.INSTANCE;
        startRestartGroup.startReplaceableGroup(-797094589);
        changed = startRestartGroup.changed(mutableState22222) | startRestartGroup.changedInstance(function12);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState22222, function12, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        Modifier then22222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22222, function12, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2));
        startRestartGroup.startReplaceableGroup(-797094184);
        changed2 = startRestartGroup.changed(mutableState22222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$1);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                invoke2(textLayoutResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextLayoutResult textLayoutResult) {
                mutableState22222.setValue(textLayoutResult);
                clickableTextKt$ClickableText$1.invoke(textLayoutResult);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        int i1622222 = i15;
        composer2 = startRestartGroup;
        boolean z422222 = z2;
        TextStyle textStyle422222 = textStyle2;
        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then22222, textStyle422222, (Function1) rememberedValue3, i9, z422222, i1622222, 0, null, null, composer2, (58254 & i5) | ((i5 << 6) & 458752) | ((i5 << 3) & 3670016), 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        function13 = clickableTextKt$ClickableText$1;
        textStyle3 = textStyle422222;
        z3 = z422222;
        i12 = i1622222;
        final Modifier modifier322222 = modifier2;
        final int i1722222 = i9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00af  */
    /* renamed from: ClickableText-03UYbkw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1161ClickableText03UYbkw(final AnnotatedString annotatedString, Function1<? super Integer, Unit> function1, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function12, final Function1<? super Integer, Unit> function13, Composer composer, final int i3, final int i4) {
        AnnotatedString annotatedString2;
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final ClickableTextKt$ClickableText$4 clickableTextKt$ClickableText$4;
        Object rememberedValue;
        Object rememberedValue2;
        final Function1<? super Integer, Unit> function14;
        boolean changed;
        Object rememberedValue3;
        Composer composer2;
        final Function1<? super TextLayoutResult, Unit> function15;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final int i15;
        final boolean z3;
        final int i16;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1020774372);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)156@7018L52,157@7096L24,179@7815L303:ClickableText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i3 & 14) == 0) {
                i5 = (startRestartGroup.changed(annotatedString2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 112) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i18 = i4 & 4;
        if (i18 != 0) {
            i5 |= 384;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i3 & 7168) == 0) {
                textStyle2 = textStyle;
                i5 |= startRestartGroup.changed(textStyle2) ? 2048 : 1024;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    z2 = z;
                    i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i9 = 57344;
                        i10 = i;
                    } else {
                        i9 = 57344;
                        i10 = i;
                        if ((i3 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(i10) ? 131072 : 65536;
                        }
                    }
                    i11 = i4 & 64;
                    if (i11 == 0) {
                        i5 |= 1572864;
                        i12 = i2;
                    } else {
                        i12 = i2;
                        if ((i3 & 3670016) == 0) {
                            i5 |= startRestartGroup.changed(i12) ? 1048576 : 524288;
                        }
                    }
                    i13 = i4 & 128;
                    if (i13 == 0) {
                        i5 |= 12582912;
                    } else if ((i3 & 29360128) == 0) {
                        i14 = i13;
                        i5 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                        if ((i4 & 256) == 0) {
                            i17 = (234881024 & i3) == 0 ? startRestartGroup.changedInstance(function13) ? 67108864 : 33554432 : 100663296;
                            if ((191739611 & i5) == 38347922 || !startRestartGroup.getSkipping()) {
                                if (i18 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                int m6330getClipgIe3tQ8 = i8 == 0 ? TextOverflow.INSTANCE.m6330getClipgIe3tQ8() : i10;
                                int i19 = i11 == 0 ? Integer.MAX_VALUE : i12;
                                clickableTextKt$ClickableText$4 = i14 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$4
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1020774372, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:155)");
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue;
                                startRestartGroup.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                                }
                                startRestartGroup.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$1 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope, function1, mutableState, function13, null);
                                function14 = function1;
                                Modifier then = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$1));
                                startRestartGroup.startReplaceableGroup(-797090299);
                                changed = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextLayoutResult textLayoutResult) {
                                            mutableState.setValue(textLayoutResult);
                                            clickableTextKt$ClickableText$4.invoke(textLayoutResult);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i20 = i5 >> 3;
                                composer2 = startRestartGroup;
                                TextStyle textStyle4 = textStyle2;
                                boolean z4 = z2;
                                BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then, textStyle4, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z4, i19, 0, null, null, composer2, (i5 & 14) | (i20 & 896) | (i20 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function15 = clickableTextKt$ClickableText$4;
                                modifier3 = modifier2;
                                textStyle3 = textStyle4;
                                i15 = m6330getClipgIe3tQ8;
                                z3 = z4;
                                i16 = i19;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function14 = function1;
                                composer2 = startRestartGroup;
                                i16 = i12;
                                modifier3 = modifier2;
                                textStyle3 = textStyle2;
                                i15 = i10;
                                z3 = z2;
                                function15 = function12;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
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

                                    public final void invoke(Composer composer3, int i21) {
                                        ClickableTextKt.m1161ClickableText03UYbkw(AnnotatedString.this, function14, modifier3, textStyle3, z3, i15, i16, function15, function13, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= i17;
                        if ((191739611 & i5) == 38347922) {
                        }
                        if (i18 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<TextLayoutResult> mutableState2 = (MutableState) rememberedValue;
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$12 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope2, function1, mutableState2, function13, null);
                        function14 = function1;
                        Modifier then2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$12));
                        startRestartGroup.startReplaceableGroup(-797090299);
                        changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                mutableState2.setValue(textLayoutResult);
                                clickableTextKt$ClickableText$4.invoke(textLayoutResult);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        int i202 = i5 >> 3;
                        composer2 = startRestartGroup;
                        TextStyle textStyle42 = textStyle2;
                        boolean z42 = z2;
                        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then2, textStyle42, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z42, i19, 0, null, null, composer2, (i5 & 14) | (i202 & 896) | (i202 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function15 = clickableTextKt$ClickableText$4;
                        modifier3 = modifier2;
                        textStyle3 = textStyle42;
                        i15 = m6330getClipgIe3tQ8;
                        z3 = z42;
                        i16 = i19;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i14 = i13;
                    if ((i4 & 256) == 0) {
                    }
                    i5 |= i17;
                    if ((191739611 & i5) == 38347922) {
                    }
                    if (i18 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<TextLayoutResult> mutableState22 = (MutableState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$122 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope22, function1, mutableState22, function13, null);
                    function14 = function1;
                    Modifier then22 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$122));
                    startRestartGroup.startReplaceableGroup(-797090299);
                    changed = startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult textLayoutResult) {
                            mutableState22.setValue(textLayoutResult);
                            clickableTextKt$ClickableText$4.invoke(textLayoutResult);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    int i2022 = i5 >> 3;
                    composer2 = startRestartGroup;
                    TextStyle textStyle422 = textStyle2;
                    boolean z422 = z2;
                    BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then22, textStyle422, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z422, i19, 0, null, null, composer2, (i5 & 14) | (i2022 & 896) | (i2022 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function15 = clickableTextKt$ClickableText$4;
                    modifier3 = modifier2;
                    textStyle3 = textStyle422;
                    i15 = m6330getClipgIe3tQ8;
                    z3 = z422;
                    i16 = i19;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z2 = z;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i11 = i4 & 64;
                if (i11 == 0) {
                }
                i13 = i4 & 128;
                if (i13 == 0) {
                }
                i14 = i13;
                if ((i4 & 256) == 0) {
                }
                i5 |= i17;
                if ((191739611 & i5) == 38347922) {
                }
                if (i18 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 == 0) {
                }
                if (i11 == 0) {
                }
                if (i14 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<TextLayoutResult> mutableState222 = (MutableState) rememberedValue;
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                Modifier.Companion companion222 = Modifier.INSTANCE;
                ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$1222 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope222, function1, mutableState222, function13, null);
                function14 = function1;
                Modifier then222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion222, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$1222));
                startRestartGroup.startReplaceableGroup(-797090299);
                changed = startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult textLayoutResult) {
                        mutableState222.setValue(textLayoutResult);
                        clickableTextKt$ClickableText$4.invoke(textLayoutResult);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                int i20222 = i5 >> 3;
                composer2 = startRestartGroup;
                TextStyle textStyle4222 = textStyle2;
                boolean z4222 = z2;
                BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then222, textStyle4222, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z4222, i19, 0, null, null, composer2, (i5 & 14) | (i20222 & 896) | (i20222 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                function15 = clickableTextKt$ClickableText$4;
                modifier3 = modifier2;
                textStyle3 = textStyle4222;
                i15 = m6330getClipgIe3tQ8;
                z3 = z4222;
                i16 = i19;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            z2 = z;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i11 = i4 & 64;
            if (i11 == 0) {
            }
            i13 = i4 & 128;
            if (i13 == 0) {
            }
            i14 = i13;
            if ((i4 & 256) == 0) {
            }
            i5 |= i17;
            if ((191739611 & i5) == 38347922) {
            }
            if (i18 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 == 0) {
            }
            if (i11 == 0) {
            }
            if (i14 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<TextLayoutResult> mutableState2222 = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2222 = Modifier.INSTANCE;
            ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$12222 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope2222, function1, mutableState2222, function13, null);
            function14 = function1;
            Modifier then2222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2222, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$12222));
            startRestartGroup.startReplaceableGroup(-797090299);
            changed = startRestartGroup.changed(mutableState2222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult textLayoutResult) {
                    mutableState2222.setValue(textLayoutResult);
                    clickableTextKt$ClickableText$4.invoke(textLayoutResult);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            int i202222 = i5 >> 3;
            composer2 = startRestartGroup;
            TextStyle textStyle42222 = textStyle2;
            boolean z42222 = z2;
            BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then2222, textStyle42222, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z42222, i19, 0, null, null, composer2, (i5 & 14) | (i202222 & 896) | (i202222 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            function15 = clickableTextKt$ClickableText$4;
            modifier3 = modifier2;
            textStyle3 = textStyle42222;
            i15 = m6330getClipgIe3tQ8;
            z3 = z42222;
            i16 = i19;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        z2 = z;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i11 = i4 & 64;
        if (i11 == 0) {
        }
        i13 = i4 & 128;
        if (i13 == 0) {
        }
        i14 = i13;
        if ((i4 & 256) == 0) {
        }
        i5 |= i17;
        if ((191739611 & i5) == 38347922) {
        }
        if (i18 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        if (i11 == 0) {
        }
        if (i14 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TextLayoutResult> mutableState22222 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Modifier.Companion companion22222 = Modifier.INSTANCE;
        ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$122222 = new ClickableTextKt$ClickableText$pointerInputModifier$1(coroutineScope22222, function1, mutableState22222, function13, null);
        function14 = function1;
        Modifier then22222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22222, function13, function14, clickableTextKt$ClickableText$pointerInputModifier$122222));
        startRestartGroup.startReplaceableGroup(-797090299);
        changed = startRestartGroup.changed(mutableState22222) | startRestartGroup.changedInstance(clickableTextKt$ClickableText$4);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                invoke2(textLayoutResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextLayoutResult textLayoutResult) {
                mutableState22222.setValue(textLayoutResult);
                clickableTextKt$ClickableText$4.invoke(textLayoutResult);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        int i2022222 = i5 >> 3;
        composer2 = startRestartGroup;
        TextStyle textStyle422222 = textStyle2;
        boolean z422222 = z2;
        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString2, then22222, textStyle422222, (Function1) rememberedValue3, m6330getClipgIe3tQ8, z422222, i19, 0, null, null, composer2, (i5 & 14) | (i2022222 & 896) | (i2022222 & i9) | ((i5 << 3) & 458752) | (i5 & 3670016), 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        function15 = clickableTextKt$ClickableText$4;
        modifier3 = modifier2;
        textStyle3 = textStyle422222;
        i15 = m6330getClipgIe3tQ8;
        z3 = z422222;
        i16 = i19;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long j) {
        MultiParagraph multiParagraph;
        TextLayoutResult value = mutableState.getValue();
        if (value != null && (multiParagraph = value.getMultiParagraph()) != null) {
            if (!m1163containsWithinBoundsUv8p0NA(multiParagraph, j)) {
                multiParagraph = null;
            }
            if (multiParagraph != null) {
                return Integer.valueOf(multiParagraph.m5765getOffsetForPositionk4lQ0M(j));
            }
        }
        return null;
    }

    /* renamed from: containsWithinBounds-Uv8p0NA, reason: not valid java name */
    private static final boolean m1163containsWithinBoundsUv8p0NA(MultiParagraph multiParagraph, long j) {
        float m3812component1impl = Offset.m3812component1impl(j);
        float m3813component2impl = Offset.m3813component2impl(j);
        return m3812component1impl > 0.0f && m3813component2impl >= 0.0f && m3812component1impl <= multiParagraph.getWidth() && m3813component2impl <= multiParagraph.getHeight();
    }
}
