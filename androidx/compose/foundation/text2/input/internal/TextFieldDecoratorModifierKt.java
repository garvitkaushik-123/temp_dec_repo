package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"withDefaultsFrom", "Landroidx/compose/foundation/text/KeyboardOptions;", "defaults", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierKt {
    public static final KeyboardOptions withDefaultsFrom(KeyboardOptions keyboardOptions, KeyboardOptions keyboardOptions2) {
        int capitalization;
        int keyboardType;
        int imeAction;
        if (keyboardOptions2 == null) {
            return keyboardOptions;
        }
        if (!KeyboardCapitalization.m6084equalsimpl0(keyboardOptions.getCapitalization(), KeyboardCapitalization.INSTANCE.m6093getNoneIUNYP9k())) {
            capitalization = keyboardOptions.getCapitalization();
        } else {
            capitalization = keyboardOptions2.getCapitalization();
        }
        boolean z = keyboardOptions.getAutoCorrect() && keyboardOptions2.getAutoCorrect();
        if (!KeyboardType.m6099equalsimpl0(keyboardOptions.getKeyboardType(), KeyboardType.INSTANCE.m6119getTextPjHm6EE())) {
            keyboardType = keyboardOptions.getKeyboardType();
        } else {
            keyboardType = keyboardOptions2.getKeyboardType();
        }
        if (!ImeAction.m6052equalsimpl0(keyboardOptions.getImeAction(), ImeAction.INSTANCE.m6064getDefaulteUduSuo())) {
            imeAction = keyboardOptions.getImeAction();
        } else {
            imeAction = keyboardOptions2.getImeAction();
        }
        return new KeyboardOptions(capitalization, z, keyboardType, imeAction, null, 16, null);
    }
}
