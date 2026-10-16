package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldState.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0007\u001a6\u0010\r\u001a\u00020\u000e*\u00020\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010H\u0087@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"TextFieldState", "Landroidx/compose/foundation/text2/input/TextFieldState;", "initialValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "rememberTextFieldState", "initialText", "", "initialSelectionInChars", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text2/input/TextFieldState;", "clearText", "", "forEachTextValue", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/foundation/text2/input/TextFieldState;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTextAndPlaceCursorAtEnd", "text", "setTextAndSelectAll", "textAsFlow", "Lkotlinx/coroutines/flow/Flow;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldStateKt {
    public static final TextFieldState TextFieldState(TextFieldValue textFieldValue) {
        return new TextFieldState(textFieldValue.getText(), textFieldValue.getSelection(), (DefaultConstructorMarker) null);
    }

    public static final Flow<TextFieldCharSequence> textAsFlow(final TextFieldState textFieldState) {
        return SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text2.input.TextFieldStateKt$textAsFlow$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                return TextFieldState.this.getText();
            }
        });
    }

    /* renamed from: rememberTextFieldState-Le-punE, reason: not valid java name */
    public static final TextFieldState m1408rememberTextFieldStateLepunE(final String str, final long j, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-855595317);
        ComposerKt.sourceInformation(composer, "C(rememberTextFieldState)P(1,0:c#ui.text.TextRange)471@18563L107:TextFieldState.kt#b7kqo7");
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            j = TextRangeKt.TextRange(str.length());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-855595317, i, -1, "androidx.compose.foundation.text2.input.rememberTextFieldState (TextFieldState.kt:471)");
        }
        Object[] objArr = new Object[0];
        TextFieldState.Saver saver = TextFieldState.Saver.INSTANCE;
        composer.startReplaceableGroup(650674345);
        boolean changed = composer.changed(str) | composer.changed(j);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<TextFieldState>() { // from class: androidx.compose.foundation.text2.input.TextFieldStateKt$rememberTextFieldState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextFieldState invoke() {
                    return new TextFieldState(str, j, (DefaultConstructorMarker) null);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextFieldState textFieldState = (TextFieldState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 56, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textFieldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachTextValue(TextFieldState textFieldState, Function2<? super TextFieldCharSequence, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<?> continuation) {
        TextFieldStateKt$forEachTextValue$1 textFieldStateKt$forEachTextValue$1;
        int i;
        if (continuation instanceof TextFieldStateKt$forEachTextValue$1) {
            textFieldStateKt$forEachTextValue$1 = (TextFieldStateKt$forEachTextValue$1) continuation;
            if ((textFieldStateKt$forEachTextValue$1.label & Integer.MIN_VALUE) != 0) {
                textFieldStateKt$forEachTextValue$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldStateKt$forEachTextValue$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldStateKt$forEachTextValue$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<TextFieldCharSequence> textAsFlow = textAsFlow(textFieldState);
                    textFieldStateKt$forEachTextValue$1.label = 1;
                    if (FlowKt.collectLatest(textAsFlow, function2, textFieldStateKt$forEachTextValue$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("textAsFlow expected not to complete without exception".toString());
            }
        }
        textFieldStateKt$forEachTextValue$1 = new TextFieldStateKt$forEachTextValue$1(continuation);
        Object obj2 = textFieldStateKt$forEachTextValue$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldStateKt$forEachTextValue$1.label;
        if (i != 0) {
        }
        throw new IllegalStateException("textAsFlow expected not to complete without exception".toString());
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        startEdit.replace(0, startEdit.getLength(), str);
        TextFieldBufferKt.placeCursorAtEnd(startEdit);
        textFieldState.commitEdit(startEdit);
    }

    public static final void setTextAndSelectAll(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        startEdit.replace(0, startEdit.getLength(), str);
        TextFieldBufferKt.selectAll(startEdit);
        textFieldState.commitEdit(startEdit);
    }

    public static final void clearText(TextFieldState textFieldState) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        TextFieldBufferKt.delete(startEdit, 0, startEdit.getLength());
        TextFieldBufferKt.placeCursorAtEnd(startEdit);
        textFieldState.commitEdit(startEdit);
    }
}
