package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* loaded from: classes7.dex */
public final class C extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC3553w f6465a;
    public final /* synthetic */ D b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(D d, Context context, AbstractC3553w abstractC3553w) {
        super(context);
        this.b = d;
        this.f6465a = abstractC3553w;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        com.unity3d.player.a.x xVar;
        com.unity3d.player.a.w wVar;
        Runnable runnable;
        if (i == 4) {
            if (keyEvent.getAction() == 1 && (xVar = this.b.h.e) != null && (wVar = xVar.f6539a) != null && (runnable = wVar.f6538a) != null) {
                runnable.run();
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC3553w abstractC3553w = this.f6465a;
            abstractC3553w.a(abstractC3553w.b(), false);
            return true;
        }
        if (i == 111 && keyEvent.getAction() == 0) {
            AbstractC3553w abstractC3553w2 = this.f6465a;
            abstractC3553w2.a(abstractC3553w2.b(), true);
            return true;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.f6465a.c();
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f6465a.b.reportSoftInputSelection(i, i2 - i);
    }
}
