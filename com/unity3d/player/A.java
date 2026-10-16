package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* loaded from: classes7.dex */
public final class A extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC3553w f6462a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(Context context, AbstractC3553w abstractC3553w) {
        super(context);
        this.f6462a = abstractC3553w;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 1) {
                AbstractC3553w abstractC3553w = this.f6462a;
                abstractC3553w.a(abstractC3553w.b(), false);
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC3553w abstractC3553w2 = this.f6462a;
            abstractC3553w2.a(abstractC3553w2.b(), false);
            return true;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        if (i == 6) {
            AbstractC3553w abstractC3553w = this.f6462a;
            abstractC3553w.a(abstractC3553w.b(), false);
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f6462a.b.reportSoftInputSelection(i, i2 - i);
    }
}
