package com.instagram.common.viewpoint.core;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.facebook.ads.redexgen.X.f6, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1829f6 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ C07063r A00;

    public C1829f6(C07063r c07063r) {
        this.A00 = c07063r;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        new Handler(Looper.getMainLooper()).post(new C0941Dl(this, i));
    }
}
