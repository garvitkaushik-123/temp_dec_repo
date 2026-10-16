package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.o0;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes2.dex */
public class ImageViewUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, final k kVar, final ImageView imageView, Uri uri) {
        try {
            InputStream openStream = new URL(str).openStream();
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(openStream);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.a(k.this, decodeStream, imageView);
                    }
                });
                if (openStream != null) {
                    openStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            kVar.O();
            if (o.a()) {
                kVar.O().a("ImageViewUtils", "Failed to fetch image: " + uri, th);
            }
            kVar.O().a("ImageViewUtils", th);
            kVar.E().a("ImageViewUtils", "setImageUri", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView, Uri uri) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        imageView.setImageURI(uri);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public static void setAndDownscaleBitmap(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        k kVar = k.D0;
        if (kVar == null) {
            o.h("ImageViewUtils", "SDK has not been initialized");
        } else {
            kVar.r0().c().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.a(uri, imageView);
                }
            });
        }
    }

    public static void setAndDownscaleImageUri(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (imageView.getHeight() <= 0 || imageView.getWidth() <= 0) {
            imageView.post(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.setAndDownscaleBitmap(imageView, uri);
                }
            });
        } else {
            setAndDownscaleBitmap(imageView, uri);
        }
    }

    public static void setImageUri(final ImageView imageView, final Uri uri, final k kVar) {
        if (imageView == null || uri == null) {
            return;
        }
        final String uri2 = uri.toString();
        if (URLUtil.isFileUrl(uri2) || URLUtil.isContentUrl(uri2)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.b(imageView, uri);
                }
            });
        } else {
            if (kVar == null) {
                return;
            }
            kVar.O();
            if (o.a()) {
                kVar.O().a("ImageViewUtils", "Fetching image: " + uri);
            }
            kVar.r0().c().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.a(uri2, kVar, imageView, uri);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(k kVar, Bitmap bitmap, ImageView imageView) {
        kVar.O();
        if (o.a()) {
            kVar.O().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(k.o().getResources(), bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, final ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point b = o0.b(imageView.getContext());
            height = Math.min(b.x, b.y);
            width = height;
        }
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > height || i3 > width) {
            while (true) {
                int i4 = i * 2;
                if (i2 / i4 < height && i3 / i4 < width) {
                    break;
                } else {
                    i = i4;
                }
            }
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        k.D0.O();
        if (o.a()) {
            k.D0.O().a("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        final Bitmap decodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.ImageViewUtils$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(decodeFile);
            }
        });
    }
}
