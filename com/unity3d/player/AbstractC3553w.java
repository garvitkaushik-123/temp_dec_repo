package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* renamed from: com.unity3d.player.w, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3553w implements TextWatcher, com.unity3d.player.a.r {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6582a;
    public final UnityPlayerForActivityOrService b;
    public final EditText c = createEditText(this);
    public boolean d;
    public boolean e;
    public M0 f;
    public C3544r0 g;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract EditText createEditText(AbstractC3553w abstractC3553w);

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract void setHideInputField(boolean z);

    public AbstractC3553w(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6582a = context;
        this.b = unityPlayerForActivityOrService;
    }

    public void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        this.e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        setHideInputField(z5);
    }

    public void invokeOnClose() {
        C3544r0 c3544r0 = this.g;
        if (c3544r0 != null) {
            RunnableC3546s0 runnableC3546s0 = c3544r0.f6573a;
            runnableC3546s0.f6575a = true;
            if (runnableC3546s0.b) {
                runnableC3546s0.c.release();
            }
        }
    }

    @Override // com.unity3d.player.a.r
    public final void a(M0 m0) {
        this.f = m0;
    }

    @Override // com.unity3d.player.a.r
    public final void a(C3544r0 c3544r0) {
        this.g = c3544r0;
    }

    public void setupTextInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        this.c.setOnEditorActionListener(new C3551v(this));
        this.c.setBackgroundColor(-1);
        this.c.setImeOptions(6);
        this.c.setText(str);
        this.c.setHint(str2);
        this.c.setHintTextColor(1627389952);
        EditText editText = this.c;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i >= 0 && i <= 11) {
            int i4 = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194}[i];
            if ((i4 & 2) != 0) {
                i3 = (z3 ? 16 : 0) | i4;
            } else {
                i3 |= i4;
            }
        }
        editText.setInputType(i3);
        this.c.setImeOptions(33554432);
        if (i2 > 0) {
            this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        this.c.addTextChangedListener(this);
        EditText editText2 = this.c;
        editText2.setSelection(editText2.getText().length());
        this.c.setClickable(true);
    }

    public boolean isConsumeOutsideTouchesEnabled() {
        return this.e;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.b.reportSoftInputStr(editable.toString(), 0, false);
        int selectionStart = this.c.getSelectionStart();
        this.b.reportSoftInputSelection(selectionStart, this.c.getSelectionEnd() - selectionStart);
    }

    public final void a(String str, boolean z) {
        this.c.setSelection(0, 0);
        this.b.reportSoftInputStr(str, 1, z);
    }

    public final void c() {
        ((InputMethodManager) this.f6582a.getSystemService(InputMethodManager.class)).showSoftInput(this.c, 0);
    }

    public final String b() {
        EditText editText = this.c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    @Override // com.unity3d.player.a.r
    public final void setText(String str) {
        EditText editText = this.c;
        if (editText != null) {
            editText.setText(str);
            this.c.setSelection(str.length());
        }
    }

    @Override // com.unity3d.player.a.r
    public final void setCharacterLimit(int i) {
        EditText editText = this.c;
        if (editText != null) {
            if (i > 0) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            } else {
                editText.setFilters(new InputFilter[0]);
            }
        }
    }

    @Override // com.unity3d.player.a.r
    public final void setSelection(int i, int i2) {
        int i3;
        EditText editText = this.c;
        if (editText == null || editText.getText().length() < (i3 = i2 + i)) {
            return;
        }
        this.c.setSelection(i, i3);
    }
}
