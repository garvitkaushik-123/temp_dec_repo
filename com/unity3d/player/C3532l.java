package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.l, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3532l implements ImageReader.OnImageAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3538o f6565a;

    public C3532l(C3538o c3538o) {
        this.f6565a = c3538o;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Semaphore semaphore = C3538o.D;
        if (semaphore.tryAcquire()) {
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                Image.Plane[] planes = acquireNextImage.getPlanes();
                if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    ((Camera2Wrapper) this.f6565a.f6569a).a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    com.unity3d.player.a.t.Log(6, "Camera2: Wrong image format.");
                }
                Image image = this.f6565a.p;
                if (image != null) {
                    image.close();
                }
                this.f6565a.p = acquireNextImage;
            }
            semaphore.release();
        }
    }
}
