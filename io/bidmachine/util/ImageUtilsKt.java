package io.bidmachine.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import io.bidmachine.util.file.FileUtilsKt;
import java.io.File;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUtils.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0002*\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0012\u0010\u0011\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0002\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b¨\u0006\u001c"}, d2 = {"compressSafely", "", "Landroid/graphics/Bitmap;", "outputStream", "Ljava/io/OutputStream;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "createDownscaledBitmapSafely", "downscaleFactor", "", "decodeBytesToBitmap", "", "bitmapFactoryOptions", "Landroid/graphics/BitmapFactory$Options;", "decodeBytesToBitmapSafely", "decodeToBitmap", "Ljava/io/File;", "decodeToBitmapSafely", "recycleSafely", "", "toBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class ImageUtilsKt {
    public static final Bitmap decodeToBitmap(File file, BitmapFactory.Options bitmapFactoryOptions) throws Throwable {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath(), bitmapFactoryOptions);
        Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(path, bitmapFactoryOptions)");
        return decodeFile;
    }

    public static final Bitmap decodeToBitmapSafely(File file, BitmapFactory.Options bitmapFactoryOptions) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(bitmapFactoryOptions, "bitmapFactoryOptions");
        if (!FileUtilsKt.hasContent(file)) {
            return null;
        }
        try {
            return decodeToBitmap(file, bitmapFactoryOptions);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ boolean compressSafely$default(Bitmap bitmap, OutputStream outputStream, Bitmap.CompressFormat compressFormat, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        if ((i2 & 4) != 0) {
            i = 85;
        }
        return compressSafely(bitmap, outputStream, compressFormat, i);
    }

    public static final boolean compressSafely(Bitmap bitmap, OutputStream outputStream, Bitmap.CompressFormat compressFormat, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        try {
            bitmap.compress(compressFormat, i, outputStream);
            recycleSafely(bitmap);
            return true;
        } catch (Throwable unused) {
            recycleSafely(bitmap);
            return false;
        }
    }

    public static final void recycleSafely(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        try {
            bitmap.recycle();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    public static final Bitmap createDownscaledBitmapSafely(Bitmap bitmap, double d) {
        Bitmap bitmap2;
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        if (d <= 1.0d) {
            return bitmap;
        }
        try {
            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / d), (int) (bitmap.getHeight() / d), true);
        } catch (Throwable unused) {
            bitmap2 = null;
        }
        return bitmap2 == null ? bitmap : bitmap2;
    }

    public static final BitmapDrawable toBitmapDrawable(Bitmap bitmap, Context context) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return toBitmapDrawable(bitmap, resources);
    }

    public static final BitmapDrawable toBitmapDrawable(Bitmap bitmap, Resources resources) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }

    public static /* synthetic */ Bitmap decodeBytesToBitmap$default(byte[] bArr, BitmapFactory.Options options, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            options = null;
        }
        return decodeBytesToBitmap(bArr, options);
    }

    public static final Bitmap decodeBytesToBitmap(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static /* synthetic */ Bitmap decodeBytesToBitmapSafely$default(byte[] bArr, BitmapFactory.Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            options = null;
        }
        return decodeBytesToBitmapSafely(bArr, options);
    }

    public static final Bitmap decodeBytesToBitmapSafely(byte[] bArr, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return decodeBytesToBitmap(bArr, options);
        } catch (Throwable unused) {
            return null;
        }
    }
}
