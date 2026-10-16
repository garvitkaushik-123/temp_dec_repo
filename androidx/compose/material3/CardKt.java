package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001au\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        Shape shape3;
        CardColors cardColors3;
        InteractionSource interactionSource;
        Modifier modifier3;
        CardElevation cardElevation3;
        BorderStroke borderStroke3;
        Shape shape4;
        final CardColors cardColors4;
        final Modifier modifier4;
        final Shape shape5;
        final BorderStroke borderStroke4;
        final CardElevation cardElevation4;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1179621553);
        ComposerKt.sourceInformation(startRestartGroup, "C(Card)P(4,5,1,3)78@3662L5,79@3707L12,80@3765L15,90@4151L57,84@3872L416:Card.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                if (startRestartGroup.changed(cardColors2)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                cardColors2 = cardColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed(cardElevation2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            cardElevation2 = cardElevation;
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            borderStroke2 = borderStroke;
            i3 |= startRestartGroup.changed(borderStroke2) ? 16384 : 8192;
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        shape3 = CardDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 4) == 0) {
                        cardColors3 = CardDefaults.INSTANCE.cardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = cardColors2;
                    }
                    if ((i2 & 8) == 0) {
                        interactionSource = null;
                        cardElevation2 = CardDefaults.INSTANCE.m1945cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        interactionSource = null;
                    }
                    CardElevation cardElevation5 = cardElevation2;
                    modifier3 = companion;
                    cardElevation3 = cardElevation5;
                    if (i8 == 0) {
                        shape4 = shape3;
                        borderStroke3 = interactionSource;
                    } else {
                        borderStroke3 = borderStroke;
                        shape4 = shape3;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    cardElevation3 = cardElevation2;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    shape4 = shape2;
                    cardColors3 = cardColors2;
                    interactionSource = null;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1179621553, i3, -1, "androidx.compose.material3.Card (Card.kt:83)");
                }
                CardElevation cardElevation6 = cardElevation3;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier3, shape4, cardColors3.m1937containerColorvNxB06k$material3_release(true), cardColors3.m1938contentColorvNxB06k$material3_release(true), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(true), cardElevation3.shadowElevation$material3_release(true, interactionSource, startRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m6403unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(startRestartGroup, 664103990, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$1
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
                        ComposerKt.sourceInformation(composer2, "C93@4257L25:Card.kt#uh7d8r");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(664103990, i9, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:93)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 0);
                startRestartGroup = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors4 = cardColors3;
                modifier4 = modifier3;
                shape5 = shape4;
                borderStroke4 = borderStroke3;
                cardElevation4 = cardElevation6;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                shape5 = shape2;
                cardColors4 = cardColors2;
                cardElevation4 = cardElevation2;
                borderStroke4 = borderStroke2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$2
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
                        CardKt.Card(Modifier.this, shape5, cardColors4, cardElevation4, borderStroke4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        borderStroke2 = borderStroke;
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        CardElevation cardElevation52 = cardElevation2;
        modifier3 = companion;
        cardElevation3 = cardElevation52;
        if (i8 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        CardElevation cardElevation62 = cardElevation3;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier3, shape4, cardColors3.m1937containerColorvNxB06k$material3_release(true), cardColors3.m1938contentColorvNxB06k$material3_release(true), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(true), cardElevation3.shadowElevation$material3_release(true, interactionSource, startRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m6403unboximpl(), borderStroke3, ComposableLambdaKt.composableLambda(startRestartGroup, 664103990, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$1
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
                ComposerKt.sourceInformation(composer2, "C93@4257L25:Card.kt#uh7d8r");
                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(664103990, i9, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:93)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                composer2.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 0);
        startRestartGroup = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        cardColors4 = cardColors3;
        modifier4 = modifier3;
        shape5 = shape4;
        borderStroke4 = borderStroke3;
        cardElevation4 = cardElevation62;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        CardColors cardColors3;
        Composer composer2;
        boolean z3;
        int i7;
        CardElevation cardElevation3;
        MutableInteractionSource mutableInteractionSource2;
        boolean z4;
        Shape shape3;
        BorderStroke borderStroke3;
        Modifier modifier3;
        int i8;
        Composer composer3;
        final CardColors cardColors4;
        final CardElevation cardElevation4;
        final Modifier modifier4;
        final boolean z5;
        final Shape shape4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-2024281376);
        ComposerKt.sourceInformation(startRestartGroup, "C(Card)P(7,6,4,8,1,3!1,5)135@6329L5,136@6374L12,137@6432L15,139@6533L39,150@6942L43,142@6630L482:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        if (startRestartGroup.changed(cardColors2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        cardColors2 = cardColors;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        if (startRestartGroup.changed(cardElevation2)) {
                            i9 = 131072;
                            i3 |= i9;
                        }
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i9 = 65536;
                    i3 |= i9;
                } else {
                    cardElevation2 = cardElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    borderStroke2 = borderStroke;
                    i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                    }
                    if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = CardDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            }
                            if ((i2 & 16) == 0) {
                                cardColors3 = CardDefaults.INSTANCE.cardColors(startRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                cardColors3 = cardColors2;
                            }
                            if ((i2 & 32) == 0) {
                                z3 = true;
                                i7 = i6;
                                cardElevation3 = CardDefaults.INSTANCE.m1945cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                composer2 = startRestartGroup;
                                i3 &= -458753;
                            } else {
                                composer2 = startRestartGroup;
                                z3 = true;
                                i7 = i6;
                                cardElevation3 = cardElevation;
                            }
                            BorderStroke borderStroke5 = i5 == 0 ? null : borderStroke;
                            if (i7 == 0) {
                                composer2.startReplaceableGroup(63758450);
                                ComposerKt.sourceInformation(composer2, "CC(remember):Card.kt#9igjgp");
                                Object rememberedValue = composer2.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            z4 = z2;
                            shape3 = shape2;
                            borderStroke3 = borderStroke5;
                            modifier3 = modifier2;
                            i8 = -2024281376;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            shape3 = shape2;
                            cardColors3 = cardColors2;
                            z3 = true;
                            borderStroke3 = borderStroke2;
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            z4 = z2;
                            i8 = -2024281376;
                            cardElevation3 = cardElevation;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.Card (Card.kt:141)");
                        }
                        int i13 = i3 << 6;
                        composer3 = composer2;
                        SurfaceKt.m2636Surfaceo_FOJdg(function0, modifier3, z4, shape3, cardColors3.m1937containerColorvNxB06k$material3_release(z4), cardColors3.m1938contentColorvNxB06k$material3_release(z4), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(z4), cardElevation3.shadowElevation$material3_release(z4, mutableInteractionSource2, composer2, ((i3 >> 6) & 14) | ((i3 >> 18) & 112) | ((i3 >> 9) & 896)).getValue().m6403unboximpl(), borderStroke3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composer2, 776921067, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$4
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

                            public final void invoke(Composer composer4, int i14) {
                                ComposerKt.sourceInformation(composer4, "C154@7081L25:Card.kt#uh7d8r");
                                if ((i14 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(776921067, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:154)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, (234881024 & i13) | (i3 & 8190) | (i13 & 1879048192), 6, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        cardColors4 = cardColors3;
                        cardElevation4 = cardElevation3;
                        modifier4 = modifier3;
                        z5 = z4;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer3 = startRestartGroup;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape4 = shape2;
                        cardColors4 = cardColors2;
                        cardElevation4 = cardElevation2;
                        borderStroke4 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$5
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

                            public final void invoke(Composer composer4, int i14) {
                                CardKt.Card(function0, modifier4, z5, shape4, cardColors4, cardElevation4, borderStroke4, mutableInteractionSource3, function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                if ((38347923 & i3) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if (i5 == 0) {
                }
                if (i7 == 0) {
                }
                z4 = z2;
                shape3 = shape2;
                borderStroke3 = borderStroke5;
                modifier3 = modifier2;
                i8 = -2024281376;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = i3 << 6;
                composer3 = composer2;
                SurfaceKt.m2636Surfaceo_FOJdg(function0, modifier3, z4, shape3, cardColors3.m1937containerColorvNxB06k$material3_release(z4), cardColors3.m1938contentColorvNxB06k$material3_release(z4), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(z4), cardElevation3.shadowElevation$material3_release(z4, mutableInteractionSource2, composer2, ((i3 >> 6) & 14) | ((i3 >> 18) & 112) | ((i3 >> 9) & 896)).getValue().m6403unboximpl(), borderStroke3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composer2, 776921067, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$4
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

                    public final void invoke(Composer composer4, int i14) {
                        ComposerKt.sourceInformation(composer4, "C154@7081L25:Card.kt#uh7d8r");
                        if ((i14 & 3) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(776921067, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:154)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer4.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                        composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceableGroup();
                        composer4.endNode();
                        composer4.endReplaceableGroup();
                        composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer3, (234881024 & i132) | (i3 & 8190) | (i132 & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                cardColors4 = cardColors3;
                cardElevation4 = cardElevation3;
                modifier4 = modifier3;
                z5 = z4;
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            if ((38347923 & i3) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if (i5 == 0) {
            }
            if (i7 == 0) {
            }
            z4 = z2;
            shape3 = shape2;
            borderStroke3 = borderStroke5;
            modifier3 = modifier2;
            i8 = -2024281376;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1322 = i3 << 6;
            composer3 = composer2;
            SurfaceKt.m2636Surfaceo_FOJdg(function0, modifier3, z4, shape3, cardColors3.m1937containerColorvNxB06k$material3_release(z4), cardColors3.m1938contentColorvNxB06k$material3_release(z4), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(z4), cardElevation3.shadowElevation$material3_release(z4, mutableInteractionSource2, composer2, ((i3 >> 6) & 14) | ((i3 >> 18) & 112) | ((i3 >> 9) & 896)).getValue().m6403unboximpl(), borderStroke3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composer2, 776921067, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$4
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

                public final void invoke(Composer composer4, int i14) {
                    ComposerKt.sourceInformation(composer4, "C154@7081L25:Card.kt#uh7d8r");
                    if ((i14 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(776921067, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:154)");
                    }
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer4.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer3, (234881024 & i1322) | (i3 & 8190) | (i1322 & 1879048192), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            cardColors4 = cardColors3;
            cardElevation4 = cardElevation3;
            modifier4 = modifier3;
            z5 = z4;
            shape4 = shape3;
            borderStroke4 = borderStroke3;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if (i5 == 0) {
        }
        if (i7 == 0) {
        }
        z4 = z2;
        shape3 = shape2;
        borderStroke3 = borderStroke5;
        modifier3 = modifier2;
        i8 = -2024281376;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i13222 = i3 << 6;
        composer3 = composer2;
        SurfaceKt.m2636Surfaceo_FOJdg(function0, modifier3, z4, shape3, cardColors3.m1937containerColorvNxB06k$material3_release(z4), cardColors3.m1938contentColorvNxB06k$material3_release(z4), cardElevation3.m1950tonalElevationu2uoSUM$material3_release(z4), cardElevation3.shadowElevation$material3_release(z4, mutableInteractionSource2, composer2, ((i3 >> 6) & 14) | ((i3 >> 18) & 112) | ((i3 >> 9) & 896)).getValue().m6403unboximpl(), borderStroke3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composer2, 776921067, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$Card$4
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

            public final void invoke(Composer composer4, int i14) {
                ComposerKt.sourceInformation(composer4, "C154@7081L25:Card.kt#uh7d8r");
                if ((i14 & 3) == 2 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(776921067, i14, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:154)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                composer4.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                composer4.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endReplaceableGroup();
                composer4.endNode();
                composer4.endReplaceableGroup();
                composer4.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer3, (234881024 & i13222) | (i3 & 8190) | (i13222 & 1879048192), 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        cardColors4 = cardColors3;
        cardElevation4 = cardElevation3;
        modifier4 = modifier3;
        z5 = z4;
        shape4 = shape3;
        borderStroke4 = borderStroke3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        Shape shape3;
        CardColors cardColors3;
        Composer composer2;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation3;
        Modifier modifier3;
        Composer composer3;
        final Modifier modifier4;
        final Shape shape5;
        final CardColors cardColors5;
        final CardElevation cardElevation4;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(895940201);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedCard)P(3,4!1,2)185@8559L13,186@8612L20,187@8678L23,189@8755L140:Card.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                if (startRestartGroup.changed(cardColors2)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                cardColors2 = cardColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed(cardElevation2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
            if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        shape3 = CardDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 4) == 0) {
                        cardColors3 = CardDefaults.INSTANCE.elevatedCardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = cardColors2;
                    }
                    if ((i2 & 8) == 0) {
                        composer2 = startRestartGroup;
                        i3 &= -7169;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation3 = CardDefaults.INSTANCE.m1947elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                    } else {
                        composer2 = startRestartGroup;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation3 = cardElevation2;
                        modifier3 = companion;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    shape4 = shape2;
                    cardColors4 = cardColors2;
                    cardElevation3 = cardElevation2;
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895940201, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:189)");
                }
                Composer composer4 = composer2;
                Card(modifier3, shape4, cardColors4, cardElevation3, null, function3, composer4, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                composer3 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                cardColors5 = cardColors4;
                cardElevation4 = cardElevation3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                shape5 = shape2;
                cardColors5 = cardColors2;
                cardElevation4 = cardElevation2;
                composer3 = startRestartGroup;
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$ElevatedCard$1
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

                    public final void invoke(Composer composer5, int i8) {
                        CardKt.ElevatedCard(Modifier.this, shape5, cardColors5, cardElevation4, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Composer composer42 = composer2;
        Card(modifier3, shape4, cardColors4, cardElevation3, null, function3, composer42, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
        composer3 = composer42;
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        shape5 = shape4;
        cardColors5 = cardColors4;
        cardElevation4 = cardElevation3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        CardColors cardColors3;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource3;
        CardColors cardColors4;
        boolean z3;
        Shape shape3;
        CardElevation cardElevation3;
        Modifier modifier3;
        Composer composer3;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        final boolean z4;
        final Shape shape4;
        final CardColors cardColors5;
        final CardElevation cardElevation4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1850977784);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedCard)P(6,5,3,7!1,2,4)233@10876L13,234@10929L20,235@10995L23,236@11070L39,238@11163L229:Card.kt#uh7d8r");
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
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        if (startRestartGroup.changed(cardColors2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        cardColors2 = cardColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        if (startRestartGroup.changed(cardElevation2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    cardElevation2 = cardElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape2 = CardDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    cardColors3 = CardDefaults.INSTANCE.elevatedCardColors(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    cardColors3 = cardColors2;
                                }
                                if ((i2 & 32) != 0) {
                                    composer2 = startRestartGroup;
                                    i3 &= -458753;
                                    cardElevation2 = CardDefaults.INSTANCE.m1947elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    composer2 = startRestartGroup;
                                }
                                if (i5 != 0) {
                                    composer2.startReplaceableGroup(1166350241);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):Card.kt#9igjgp");
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    cardColors4 = cardColors3;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    cardColors4 = cardColors3;
                                }
                                z3 = z2;
                                shape3 = shape2;
                                cardElevation3 = cardElevation2;
                                modifier3 = modifier2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                composer2 = startRestartGroup;
                                shape3 = shape2;
                                cardColors4 = cardColors2;
                                cardElevation3 = cardElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                z3 = z2;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1850977784, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:238)");
                            }
                            int i10 = i3 << 3;
                            Composer composer4 = composer2;
                            Card(function02, modifier3, z3, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer4, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i10) | (i10 & 234881024), 0);
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource5;
                            modifier4 = modifier3;
                            z4 = z3;
                            shape4 = shape3;
                            cardColors5 = cardColors4;
                            cardElevation4 = cardElevation3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer3 = startRestartGroup;
                            modifier4 = modifier2;
                            z4 = z2;
                            shape4 = shape2;
                            cardColors5 = cardColors2;
                            cardElevation4 = cardElevation2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$ElevatedCard$3
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

                                public final void invoke(Composer composer5, int i11) {
                                    CardKt.ElevatedCard(function0, modifier4, z4, shape4, cardColors5, cardElevation4, mutableInteractionSource4, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((4793491 & i3) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    z3 = z2;
                    shape3 = shape2;
                    cardElevation3 = cardElevation2;
                    modifier3 = modifier2;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i102 = i3 << 3;
                    Composer composer42 = composer2;
                    Card(function02, modifier3, z3, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer42, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i102) | (i102 & 234881024), 0);
                    MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                    composer3 = composer42;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource4 = mutableInteractionSource52;
                    modifier4 = modifier3;
                    z4 = z3;
                    shape4 = shape3;
                    cardColors5 = cardColors4;
                    cardElevation4 = cardElevation3;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) == 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                z3 = z2;
                shape3 = shape2;
                cardElevation3 = cardElevation2;
                modifier3 = modifier2;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1022 = i3 << 3;
                Composer composer422 = composer2;
                Card(function02, modifier3, z3, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer422, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i1022) | (i1022 & 234881024), 0);
                MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                composer3 = composer422;
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource4 = mutableInteractionSource522;
                modifier4 = modifier3;
                z4 = z3;
                shape4 = shape3;
                cardColors5 = cardColors4;
                cardElevation4 = cardElevation3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) == 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            z3 = z2;
            shape3 = shape2;
            cardElevation3 = cardElevation2;
            modifier3 = modifier2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i10222 = i3 << 3;
            Composer composer4222 = composer2;
            Card(function02, modifier3, z3, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer4222, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i10222) | (i10222 & 234881024), 0);
            MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
            composer3 = composer4222;
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource5222;
            modifier4 = modifier3;
            z4 = z3;
            shape4 = shape3;
            cardColors5 = cardColors4;
            cardElevation4 = cardElevation3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        z3 = z2;
        shape3 = shape2;
        cardElevation3 = cardElevation2;
        modifier3 = modifier2;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i102222 = i3 << 3;
        Composer composer42222 = composer2;
        Card(function02, modifier3, z3, shape3, cardColors4, cardElevation3, null, mutableInteractionSource3, function3, composer42222, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i102222) | (i102222 & 234881024), 0);
        MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
        composer3 = composer42222;
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource52222;
        modifier4 = modifier3;
        z4 = z3;
        shape4 = shape3;
        cardColors5 = cardColors4;
        cardElevation4 = cardElevation3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        Shape shape3;
        CardColors cardColors3;
        Composer composer2;
        CardElevation cardElevation3;
        BorderStroke borderStroke3;
        Modifier modifier3;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation4;
        Composer composer3;
        final Modifier modifier4;
        final Shape shape5;
        final CardColors cardColors5;
        final CardElevation cardElevation5;
        final BorderStroke borderStroke4;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(740336179);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedCard)P(4,5,1,3)278@12927L13,279@12980L20,280@13046L23,281@13111L20,283@13185L142:Card.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i7 = 32;
                    i3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 16;
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                if (startRestartGroup.changed(cardColors2)) {
                    i6 = 256;
                    i3 |= i6;
                }
            } else {
                cardColors2 = cardColors;
            }
            i6 = 128;
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed(cardElevation2)) {
                    i5 = 2048;
                    i3 |= i5;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i5 = 1024;
            i3 |= i5;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                borderStroke2 = borderStroke;
                if (startRestartGroup.changed(borderStroke2)) {
                    i4 = 16384;
                    i3 |= i4;
                }
            } else {
                borderStroke2 = borderStroke;
            }
            i4 = 8192;
            i3 |= i4;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        shape3 = CardDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 4) == 0) {
                        cardColors3 = CardDefaults.INSTANCE.outlinedCardColors(startRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors3 = cardColors2;
                    }
                    if ((i2 & 8) == 0) {
                        composer2 = startRestartGroup;
                        cardElevation3 = CardDefaults.INSTANCE.m1949outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        composer2 = startRestartGroup;
                        cardElevation3 = cardElevation2;
                    }
                    if ((i2 & 16) == 0) {
                        i3 &= -57345;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation4 = cardElevation3;
                        borderStroke3 = CardDefaults.INSTANCE.outlinedCardBorder(false, composer2, 48, 1);
                    } else {
                        borderStroke3 = borderStroke;
                        modifier3 = companion;
                        shape4 = shape3;
                        cardColors4 = cardColors3;
                        cardElevation4 = cardElevation3;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    shape4 = shape2;
                    cardColors4 = cardColors2;
                    cardElevation4 = cardElevation2;
                    borderStroke3 = borderStroke2;
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(740336179, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:283)");
                }
                Composer composer4 = composer2;
                Card(modifier3, shape4, cardColors4, cardElevation4, borderStroke3, function3, composer4, 524286 & i3, 0);
                composer3 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape5 = shape4;
                cardColors5 = cardColors4;
                cardElevation5 = cardElevation4;
                borderStroke4 = borderStroke3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                shape5 = shape2;
                cardColors5 = cardColors2;
                cardElevation5 = cardElevation2;
                borderStroke4 = borderStroke2;
                composer3 = startRestartGroup;
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$OutlinedCard$1
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

                    public final void invoke(Composer composer5, int i9) {
                        CardKt.OutlinedCard(Modifier.this, shape5, cardColors5, cardElevation5, borderStroke4, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Composer composer42 = composer2;
        Card(modifier3, shape4, cardColors4, cardElevation4, borderStroke3, function3, composer42, 524286 & i3, 0);
        composer3 = composer42;
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        shape5 = shape4;
        cardColors5 = cardColors4;
        cardElevation5 = cardElevation4;
        borderStroke4 = borderStroke3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        int i6;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke4;
        Modifier modifier3;
        boolean z3;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevation3;
        Composer composer3;
        final Modifier modifier4;
        final boolean z4;
        final Shape shape4;
        final CardColors cardColors4;
        final CardElevation cardElevation4;
        final BorderStroke borderStroke5;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-727137250);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedCard)P(7,6,4,8,1,3!1,5)328@15398L13,329@15451L20,330@15517L23,331@15582L27,332@15661L39,334@15754L231:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i10 = 2048;
                            i3 |= i10;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i10 = 1024;
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        if (startRestartGroup.changed(cardColors2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        cardColors2 = cardColors;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevation2 = cardElevation;
                        if (startRestartGroup.changed(cardElevation2)) {
                            i8 = 131072;
                            i3 |= i8;
                        }
                    } else {
                        cardElevation2 = cardElevation;
                    }
                    i8 = 65536;
                    i3 |= i8;
                } else {
                    cardElevation2 = cardElevation;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        borderStroke2 = borderStroke;
                        if (startRestartGroup.changed(borderStroke2)) {
                            i7 = 1048576;
                            i3 |= i7;
                        }
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i7 = 524288;
                    i3 |= i7;
                } else {
                    borderStroke2 = borderStroke;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else if ((12582912 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape2 = CardDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    cardColors2 = CardDefaults.INSTANCE.outlinedCardColors(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i6 = i5;
                                    composer2 = startRestartGroup;
                                    i3 &= -458753;
                                    cardElevation2 = CardDefaults.INSTANCE.m1949outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    composer2 = startRestartGroup;
                                    i6 = i5;
                                }
                                if ((i2 & 64) != 0) {
                                    borderStroke3 = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer2, ((i3 >> 6) & 14) | 48, 0);
                                    i3 = (-3670017) & i3;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i6 != 0) {
                                    composer2.startReplaceableGroup(1028043736);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):Card.kt#9igjgp");
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                borderStroke4 = borderStroke3;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape3 = shape2;
                                cardColors3 = cardColors2;
                                cardElevation3 = cardElevation2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                composer2 = startRestartGroup;
                                z3 = z2;
                                cardColors3 = cardColors2;
                                cardElevation3 = cardElevation2;
                                borderStroke4 = borderStroke2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                shape3 = shape2;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-727137250, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:334)");
                            }
                            Card(function0, modifier3, z3, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3 = composer2;
                            modifier4 = modifier3;
                            z4 = z3;
                            shape4 = shape3;
                            cardColors4 = cardColors3;
                            cardElevation4 = cardElevation3;
                            borderStroke5 = borderStroke4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer3 = startRestartGroup;
                            modifier4 = modifier2;
                            z4 = z2;
                            shape4 = shape2;
                            cardColors4 = cardColors2;
                            cardElevation4 = cardElevation2;
                            borderStroke5 = borderStroke2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt$OutlinedCard$3
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

                                public final void invoke(Composer composer4, int i12) {
                                    CardKt.OutlinedCard(function0, modifier4, z4, shape4, cardColors4, cardElevation4, borderStroke5, mutableInteractionSource4, function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    borderStroke4 = borderStroke3;
                    modifier3 = modifier2;
                    z3 = z2;
                    shape3 = shape2;
                    cardColors3 = cardColors2;
                    cardElevation3 = cardElevation2;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Card(function0, modifier3, z3, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer3 = composer2;
                    modifier4 = modifier3;
                    z4 = z3;
                    shape4 = shape3;
                    cardColors4 = cardColors3;
                    cardElevation4 = cardElevation3;
                    borderStroke5 = borderStroke4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 256) == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i6 != 0) {
                }
                borderStroke4 = borderStroke3;
                modifier3 = modifier2;
                z3 = z2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                cardElevation3 = cardElevation2;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Card(function0, modifier3, z3, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer3 = composer2;
                modifier4 = modifier3;
                z4 = z3;
                shape4 = shape3;
                cardColors4 = cardColors3;
                cardElevation4 = cardElevation3;
                borderStroke5 = borderStroke4;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 256) == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i6 != 0) {
            }
            borderStroke4 = borderStroke3;
            modifier3 = modifier2;
            z3 = z2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            cardElevation3 = cardElevation2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Card(function0, modifier3, z3, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer3 = composer2;
            modifier4 = modifier3;
            z4 = z3;
            shape4 = shape3;
            cardColors4 = cardColors3;
            cardElevation4 = cardElevation3;
            borderStroke5 = borderStroke4;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 256) == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i6 != 0) {
        }
        borderStroke4 = borderStroke3;
        modifier3 = modifier2;
        z3 = z2;
        shape3 = shape2;
        cardColors3 = cardColors2;
        cardElevation3 = cardElevation2;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Card(function0, modifier3, z3, shape3, cardColors3, cardElevation3, borderStroke4, mutableInteractionSource3, function3, composer2, i3 & 268435454, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer3 = composer2;
        modifier4 = modifier3;
        z4 = z3;
        shape4 = shape3;
        cardColors4 = cardColors3;
        cardElevation4 = cardElevation3;
        borderStroke5 = borderStroke4;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
