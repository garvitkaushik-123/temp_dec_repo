package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.unity3d.player.v, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3551v implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC3553w f6580a;

    public C3551v(AbstractC3553w abstractC3553w) {
        this.f6580a = abstractC3553w;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            AbstractC3553w abstractC3553w = this.f6580a;
            abstractC3553w.a(abstractC3553w.b(), false);
        }
        return false;
    }
}
