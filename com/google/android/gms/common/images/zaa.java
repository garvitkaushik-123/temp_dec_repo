package com.google.android.gms.common.images;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final AssetFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, AssetFileDescriptor assetFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = assetFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        AssetFileDescriptor assetFileDescriptor = this.zac;
        Bitmap bitmap = null;
        boolean z = false;
        if (assetFileDescriptor != null) {
            try {
                FileInputStream createInputStream = assetFileDescriptor.createInputStream();
                if (createInputStream != null) {
                    try {
                        bitmap = BitmapFactory.decodeStream(createInputStream);
                    } finally {
                    }
                }
                if (createInputStream != null) {
                    createInputStream.close();
                }
            } catch (IOException | OutOfMemoryError e) {
                Log.e("ImageManager", "Error loading bitmap for uri: ".concat(String.valueOf(String.valueOf(this.zab))), e);
                z = e instanceof OutOfMemoryError;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        Uri uri = this.zab;
        handler = imageManager.zae;
        handler.post(new zac(imageManager, uri, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(String.valueOf(this.zab))));
        }
    }
}
