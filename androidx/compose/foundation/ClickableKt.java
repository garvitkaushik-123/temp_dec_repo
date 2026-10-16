package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001al\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\b\u0010\u001aT\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0015\u001aB\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0016\u001a\u0086\u0001\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0018\u001at\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0019\u001a\u009e\u0001\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\b$\u001a=\u0010%\u001a\u00020\u0004*\u00020&2\u0006\u0010'\u001a\u00020#2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"CombinedClickableNode", "Landroidx/compose/foundation/CombinedClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "CombinedClickableNode-xpl5gLE", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m561clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m560clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m559clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m558clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: combinedClickable-cJG_KMw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m565combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Function0 function05;
        String str3;
        Function0 function06;
        String str4;
        Role role2;
        Modifier modifier2;
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function04 = null;
            str3 = str2;
            function05 = function03;
            str4 = str;
            function06 = function0;
            modifier2 = modifier;
            role2 = role;
        } else {
            function04 = function02;
            function05 = function03;
            str3 = str2;
            function06 = function0;
            str4 = str;
            role2 = role;
            modifier2 = modifier;
        }
        return m564combinedClickablecJG_KMw(modifier2, z, str4, role2, str3, function06, function04, function05);
    }

    /* renamed from: combinedClickable-XVZzFYc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m563combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        Function0 function05;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        String str3 = (i & 8) != 0 ? null : str;
        Role role2 = (i & 16) != 0 ? null : role;
        String str4 = (i & 32) != 0 ? null : str2;
        Function0 function06 = (i & 64) != 0 ? null : function0;
        if ((i & 128) != 0) {
            function04 = null;
            modifier2 = modifier;
            indication2 = indication;
            function05 = function03;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            function04 = function02;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            function05 = function03;
        }
        return m562combinedClickableXVZzFYc(modifier2, mutableInteractionSource2, indication2, z2, str3, role2, str4, function06, function04, function05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m568handlePressInteractionEPk0efs(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, interactionData, function0, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m567genericClickableWithoutGestureKqvBsg$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map map, State state, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        Function0 function03;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        CoroutineScope coroutineScope2;
        Map map2;
        State state2;
        Function0 function04;
        boolean z2 = (i & 32) != 0 ? true : z;
        String str3 = (i & 64) != 0 ? null : str;
        Role role2 = (i & 128) != 0 ? null : role;
        String str4 = (i & 256) != 0 ? null : str2;
        if ((i & 512) != 0) {
            function03 = null;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            coroutineScope2 = coroutineScope;
            map2 = map;
            state2 = state;
            function04 = function02;
            modifier2 = modifier;
        } else {
            function03 = function0;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            coroutineScope2 = coroutineScope;
            map2 = map;
            state2 = state;
            function04 = function02;
        }
        return m566genericClickableWithoutGestureKqvBsg(modifier2, mutableInteractionSource2, indication2, coroutineScope2, map2, state2, z2, str3, role2, str4, function03, function04);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, final boolean z, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final CoroutineScope coroutineScope, final Function0<Unit> function0, final MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m569invokeZmokQxo(keyEvent.m5060unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m569invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z2 = true;
                if (z && Clickable_androidKt.m576isPressZmokQxo(keyEvent)) {
                    if (!map.containsKey(Key.m4760boximpl(KeyEvent_androidKt.m5071getKeyZmokQxo(keyEvent)))) {
                        PressInteraction.Press press = new PressInteraction.Press(state.getValue().getPackedValue(), null);
                        map.put(Key.m4760boximpl(KeyEvent_androidKt.m5071getKeyZmokQxo(keyEvent)), press);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutableInteractionSource, press, null), 3, null);
                    }
                    z2 = false;
                } else {
                    if (z && Clickable_androidKt.m574isClickZmokQxo(keyEvent)) {
                        PressInteraction.Press remove = map.remove(Key.m4760boximpl(KeyEvent_androidKt.m5071getKeyZmokQxo(keyEvent)));
                        if (remove != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(mutableInteractionSource, remove, null), 3, null);
                        }
                        function0.invoke();
                    }
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            /* compiled from: Clickable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$interactionSource, this.$press, continuation);
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
                        if (this.$interactionSource.emit(this.$press, this) == coroutine_suspended) {
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

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg, reason: not valid java name */
    public static final Modifier m566genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z, role, str2, function0, str, function02, null), z, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource));
    }

    /* renamed from: CombinedClickableNode-xpl5gLE, reason: not valid java name */
    public static final CombinedClickableNode m556CombinedClickableNodexpl5gLE(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role) {
        return new CombinedClickableNodeImpl(function0, str, function02, function03, mutableInteractionSource, z, str2, role, null);
    }

    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m560clickableXHw0xAI(Modifier modifier, final boolean z, final String str, final Role role, final Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceableGroup(-756081143);
                ComposerKt.sourceInformation(composer, "C103@4435L7,104@4472L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:98)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m558clickableO2vRcR0 = ClickableKt.m558clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m558clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m558clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0<Unit> function0) {
        final MutableInteractionSource mutableInteractionSource2;
        final Indication indication2;
        final boolean z2;
        final String str2;
        final Role role2;
        final Function0<Unit> function02;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            z2 = z;
            str2 = str;
            role2 = role;
            function02 = function0;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("clickable");
                    inspectorInfo.getProperties().set("interactionSource", MutableInteractionSource.this);
                    inspectorInfo.getProperties().set("indication", indication2);
                    inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
                    inspectorInfo.getProperties().set("onClickLabel", str2);
                    inspectorInfo.getProperties().set("role", role2);
                    inspectorInfo.getProperties().set("onClick", function02);
                }
            };
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            z2 = z;
            str2 = str;
            role2 = role;
            function02 = function0;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        return InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication2), mutableInteractionSource2, z2), z2, mutableInteractionSource2).then(new ClickableElement(mutableInteractionSource2, z2, str2, role2, function02, null)));
    }

    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m564combinedClickablecJG_KMw(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceableGroup(1969174843);
                ComposerKt.sourceInformation(composer, "C212@9177L7,213@9214L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:204)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) consume;
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m562combinedClickableXVZzFYc = ClickableKt.m562combinedClickableXVZzFYc(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, str2, function0, function02, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m562combinedClickableXVZzFYc;
            }
        });
    }

    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m562combinedClickableXVZzFYc(Modifier modifier, final MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("indication", Indication.this);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        return InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(new CombinedClickableElement(mutableInteractionSource, z, str, role, function03, str2, function0, function02, null)));
    }
}
