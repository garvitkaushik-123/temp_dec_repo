package com.bykv.vk.openvk.eli.eli.eli.MGA;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.eli.eli.eli.MGA.DbA;

/* loaded from: classes3.dex */
public class aGH extends TextureView implements TextureView.SurfaceTextureListener, DbA {
    private DbA.eli DbA;
    private eli eli;

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public aGH(Context context) {
        this(context, null);
    }

    public aGH(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public void eli(eli eliVar) {
        this.eli = eliVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public void eli(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        eli eliVar = this.eli;
        if (eliVar != null) {
            eliVar.eli(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        eli eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.eli(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        eli eliVar = this.eli;
        if (eliVar != null) {
            eliVar.DbA(surfaceTexture);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(DbA.eli eliVar) {
        this.DbA = eliVar;
    }
}
