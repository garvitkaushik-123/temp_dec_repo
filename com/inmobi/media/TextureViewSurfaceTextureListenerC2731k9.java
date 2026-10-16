package com.inmobi.media;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class TextureViewSurfaceTextureListenerC2731k9 implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2747l9 f2622a;

    public TextureViewSurfaceTextureListenerC2731k9(C2747l9 c2747l9) {
        this.f2622a = c2747l9;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture texture, int i, int i2) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        this.f2622a.b = new Surface(texture);
        this.f2622a.e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        Surface surface = this.f2622a.b;
        if (surface != null) {
            surface.release();
        }
        C2747l9 c2747l9 = this.f2622a;
        c2747l9.b = null;
        C2631e9 c2631e9 = c2747l9.n;
        if (c2631e9 != null) {
            c2631e9.c();
        }
        this.f2622a.g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i, int i2) {
        G8 g8;
        Intrinsics.checkNotNullParameter(surface, "surface");
        G8 mediaPlayer = this.f2622a.getMediaPlayer();
        boolean z = mediaPlayer != null && mediaPlayer.b == 3;
        boolean z2 = i > 0 && i2 > 0;
        if (z && z2) {
            Object tag = this.f2622a.getTag();
            if (tag instanceof C2597c9) {
                Object obj = ((C2597c9) tag).t.get("seekPosition");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj).intValue();
                if (intValue != 0) {
                    C2747l9 c2747l9 = this.f2622a;
                    if (c2747l9.a() && (g8 = c2747l9.c) != null) {
                        g8.seekTo(intValue);
                    }
                }
            }
            this.f2622a.start();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
    }
}
