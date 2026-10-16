package com.unity3d.player.a;

import android.view.KeyEvent;
import android.view.View;

/* renamed from: com.unity3d.player.a.b, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class ViewOnKeyListenerC3494b implements View.OnKeyListener {
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return i == 4 && keyEvent.getAction() == 1;
    }
}
