package io.bidmachine.rendering.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class ImageUtils {
    public static void compressBitmap(Bitmap bitmap, OutputStream outputStream) {
        if (bitmap == null) {
            return;
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 85, outputStream);
        bitmap.recycle();
    }

    public static BitmapFactory.Options createDefaultBitmapFactoryOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return options;
    }

    public static Bitmap getImageByFile(File file, BitmapFactory.Options bitmapFactoryOptions) {
        if (FileUtils.isEmpty(file)) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getPath(), bitmapFactoryOptions);
    }

    public static void saveImage(File file, byte[] byteImage) {
        saveImage(file, byteImage, createDefaultBitmapFactoryOptions());
    }

    public static Bitmap toBitmap(byte[] byteImage) {
        return toBitmap(byteImage, createDefaultBitmapFactoryOptions());
    }

    public static void writeBitmap(byte[] byteImage, OutputStream outputStream) {
        writeBitmap(byteImage, outputStream, createDefaultBitmapFactoryOptions());
    }

    public static void saveImage(File file, byte[] byteImage, BitmapFactory.Options bitmapFactoryOptions) {
        bitmapFactoryOptions.inJustDecodeBounds = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                writeBitmap(byteImage, fileOutputStream2, bitmapFactoryOptions);
                io.bidmachine.iab.utils.Utils.flush(fileOutputStream2);
                io.bidmachine.iab.utils.Utils.close(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                io.bidmachine.iab.utils.Utils.flush(fileOutputStream);
                io.bidmachine.iab.utils.Utils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap toBitmap(byte[] byteImage, BitmapFactory.Options bitmapFactoryOptions) {
        bitmapFactoryOptions.inJustDecodeBounds = false;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(byteImage.length);
            try {
                writeBitmap(byteImage, byteArrayOutputStream2, bitmapFactoryOptions);
                Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
                io.bidmachine.iab.utils.Utils.flush(byteArrayOutputStream2);
                io.bidmachine.iab.utils.Utils.close(byteArrayOutputStream2);
                return decodeStream;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                io.bidmachine.iab.utils.Utils.flush(byteArrayOutputStream);
                io.bidmachine.iab.utils.Utils.close(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void writeBitmap(byte[] byteImage, OutputStream outputStream, BitmapFactory.Options bitmapFactoryOptions) {
        compressBitmap(BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length, bitmapFactoryOptions), outputStream);
    }

    public static Bitmap toBitmap(File file, BitmapFactory.Options bitmapFactoryOptions) {
        return BitmapFactory.decodeFile(file.getPath(), bitmapFactoryOptions);
    }
}
