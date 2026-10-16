package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* loaded from: classes7.dex */
public final class D extends AbstractC3553w {
    public DialogC3557y h;

    @Override // com.unity3d.player.AbstractC3553w, com.unity3d.player.a.r
    public final void setHideInputField(boolean z) {
        this.d = z;
        this.h.a(z);
    }

    public D(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context, unityPlayerForActivityOrService);
    }

    @Override // com.unity3d.player.AbstractC3553w, com.unity3d.player.a.r
    public final void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        DialogC3557y dialogC3557y = new DialogC3557y(this.f6582a, this.b);
        this.h = dialogC3557y;
        dialogC3557y.a(this, z5, z6);
        this.h.setOnDismissListener(new com.unity3d.player.a.H(this));
        this.e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        setHideInputField(z5);
        this.b.getFrameLayout().getViewTreeObserver().addOnGlobalLayoutListener(new com.unity3d.player.a.I(this));
        this.c.requestFocus();
        this.h.setOnCancelListener(new com.unity3d.player.a.J(this));
    }

    public void reportSoftInputArea() {
        if (this.h.isShowing()) {
            this.b.reportSoftInputArea(this.h.a());
        }
    }

    @Override // com.unity3d.player.a.r
    public final void a() {
        this.h.show();
    }

    @Override // com.unity3d.player.a.r
    public final void hide() {
        this.h.dismiss();
    }

    @Override // com.unity3d.player.AbstractC3553w
    public EditText createEditText(AbstractC3553w abstractC3553w) {
        return new C(this, this.f6582a, abstractC3553w);
    }
}
