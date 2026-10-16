package io.bidmachine.rendering.internal.adform.video.player;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* loaded from: classes8.dex */
public interface e extends TextureView.SurfaceTextureListener {
    @Override // android.view.TextureView.SurfaceTextureListener
    default void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    default void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
}
