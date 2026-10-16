package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: TextFieldFocusModifier.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final TextFieldState textFieldState, final FocusManager focusManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1233invokeZmokQxo(keyEvent.m5060unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1233invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean m1232isKeyCodeYhN2O0w;
                boolean m1232isKeyCodeYhN2O0w2;
                boolean m1232isKeyCodeYhN2O0w3;
                boolean m1232isKeyCodeYhN2O0w4;
                boolean m1232isKeyCodeYhN2O0w5;
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device != null && device.supportsSource(513) && !device.isVirtual() && KeyEventType.m5064equalsimpl0(KeyEvent_androidKt.m5072getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5068getKeyDownCS__XNY())) {
                    m1232isKeyCodeYhN2O0w = TextFieldFocusModifier_androidKt.m1232isKeyCodeYhN2O0w(keyEvent, 19);
                    if (m1232isKeyCodeYhN2O0w) {
                        z = FocusManager.this.mo3756moveFocus3ESFkO8(FocusDirection.INSTANCE.m3755getUpdhqQ8s());
                    } else {
                        m1232isKeyCodeYhN2O0w2 = TextFieldFocusModifier_androidKt.m1232isKeyCodeYhN2O0w(keyEvent, 20);
                        if (m1232isKeyCodeYhN2O0w2) {
                            z = FocusManager.this.mo3756moveFocus3ESFkO8(FocusDirection.INSTANCE.m3748getDowndhqQ8s());
                        } else {
                            m1232isKeyCodeYhN2O0w3 = TextFieldFocusModifier_androidKt.m1232isKeyCodeYhN2O0w(keyEvent, 21);
                            if (m1232isKeyCodeYhN2O0w3) {
                                z = FocusManager.this.mo3756moveFocus3ESFkO8(FocusDirection.INSTANCE.m3751getLeftdhqQ8s());
                            } else {
                                m1232isKeyCodeYhN2O0w4 = TextFieldFocusModifier_androidKt.m1232isKeyCodeYhN2O0w(keyEvent, 22);
                                if (m1232isKeyCodeYhN2O0w4) {
                                    z = FocusManager.this.mo3756moveFocus3ESFkO8(FocusDirection.INSTANCE.m3754getRightdhqQ8s());
                                } else {
                                    m1232isKeyCodeYhN2O0w5 = TextFieldFocusModifier_androidKt.m1232isKeyCodeYhN2O0w(keyEvent, 23);
                                    if (m1232isKeyCodeYhN2O0w5) {
                                        SoftwareKeyboardController keyboardController = textFieldState.getKeyboardController();
                                        if (keyboardController != null) {
                                            keyboardController.show();
                                        }
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m1232isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m5078getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m5071getKeyZmokQxo(keyEvent)) == i;
    }
}
