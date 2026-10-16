package com.instagram.common.viewpoint.core;

import android.widget.MediaController;

/* renamed from: com.facebook.ads.redexgen.X.fd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1862fd implements MediaController.MediaPlayerControl {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC0929Cz A00;

    public C1862fd(TextureViewSurfaceTextureListenerC0929Cz textureViewSurfaceTextureListenerC0929Cz) {
        this.A00 = textureViewSurfaceTextureListenerC0929Cz;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        C1856fX c1856fX;
        C1856fX c1856fX2;
        c1856fX = this.A00.A0C;
        if (c1856fX == null) {
            return 0;
        }
        c1856fX2 = this.A00.A0C;
        return c1856fX2.A04();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        C1856fX c1856fX;
        C1856fX c1856fX2;
        c1856fX = this.A00.A0C;
        if (c1856fX == null) {
            return 0;
        }
        c1856fX2 = this.A00.A0C;
        return c1856fX2.A05();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.A00.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.A00.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        C1856fX c1856fX;
        C1856fX c1856fX2;
        c1856fX = this.A00.A0C;
        if (c1856fX != null) {
            c1856fX2 = this.A00.A0C;
            if (c1856fX2.A0J()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        InterfaceC1872fn interfaceC1872fn;
        InterfaceC1872fn interfaceC1872fn2;
        interfaceC1872fn = this.A00.A0F;
        if (interfaceC1872fn != null) {
            interfaceC1872fn2 = this.A00.A0F;
            interfaceC1872fn2.AEo();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        this.A00.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        InterfaceC1872fn interfaceC1872fn;
        InterfaceC1872fn interfaceC1872fn2;
        interfaceC1872fn = this.A00.A0F;
        if (interfaceC1872fn != null) {
            interfaceC1872fn2 = this.A00.A0F;
            interfaceC1872fn2.AEp();
        }
    }
}
