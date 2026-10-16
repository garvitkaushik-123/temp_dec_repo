package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;

/* renamed from: com.facebook.ads.redexgen.X.fe, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1863fe implements View.OnTouchListener {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC0929Cz A00;

    public ViewOnTouchListenerC1863fe(TextureViewSurfaceTextureListenerC0929Cz textureViewSurfaceTextureListenerC0929Cz) {
        this.A00 = textureViewSurfaceTextureListenerC0929Cz;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MediaController mediaController;
        MediaController mediaController2;
        MediaController mediaController3;
        MediaController mediaController4;
        mediaController = this.A00.A09;
        if (mediaController != null && motionEvent.getAction() == 1) {
            mediaController2 = this.A00.A09;
            if (mediaController2.isShowing()) {
                mediaController4 = this.A00.A09;
                mediaController4.hide();
            } else {
                mediaController3 = this.A00.A09;
                mediaController3.show();
            }
        }
        return true;
    }
}
