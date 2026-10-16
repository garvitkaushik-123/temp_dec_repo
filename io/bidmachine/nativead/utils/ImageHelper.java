package io.bidmachine.nativead.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class ImageHelper {
    private static final int MAX_IMAGE_HEIGHT = 700;
    private static final int MAX_IMAGE_WIDTH = 1200;

    public interface OnImageHelperListener {
        void onError(String errorMessage);

        void onImagePrepared(ImageView targetView, Drawable image);
    }

    public static int calculateReqHeight(int maxWidth) {
        if (maxWidth > 700) {
            return 700;
        }
        return maxWidth;
    }

    private static void loadImageByPath(Context context, Uri imageUri, ImageView targetImageView, OnImageHelperListener onImageHelperListener) {
        if (onImageHelperListener == null) {
            return;
        }
        if (imageUri == null || TextUtils.isEmpty(imageUri.getPath())) {
            onImageHelperListener.onError("ImagePath is invalid");
        } else if (targetImageView == null) {
            onImageHelperListener.onError("Target ImageView is null");
        } else {
            NativeNetworkExecutor.getInstance().execute(new ImagePreparation(context, imageUri, targetImageView, onImageHelperListener));
        }
    }

    public static int calculateReqWidth(Context context) {
        Point screenSize = Utils.getScreenSize(context);
        return Math.min(1200, Math.min(screenSize.x, screenSize.y));
    }

    public static int calculateInSamplesSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outWidth;
        int i2 = options.outHeight;
        int i3 = 1;
        while (true) {
            if (i / i3 <= reqWidth && i2 / i3 <= reqHeight) {
                return i3;
            }
            i3 *= 2;
        }
    }

    public static void fillImageView(Context context, ImageView imageView, Uri imageUri, Drawable imageDrawable) {
        if (imageDrawable != null) {
            imageView.setImageDrawable(imageDrawable);
        } else {
            loadImageByPath(context, imageUri, imageView, new OnImageHelperListener() { // from class: io.bidmachine.nativead.utils.ImageHelper.1
                @Override // io.bidmachine.nativead.utils.ImageHelper.OnImageHelperListener
                public void onImagePrepared(ImageView targetView, Drawable image) {
                    targetView.setImageDrawable(image);
                }

                @Override // io.bidmachine.nativead.utils.ImageHelper.OnImageHelperListener
                public void onError(String errorMessage) {
                    Logger.d(errorMessage);
                }
            });
        }
    }

    private static class ImagePreparation implements Runnable {
        private final Context context;
        private Drawable image;
        private final Uri imageUri;
        private final OnImageHelperListener onImageHelperListener;
        private final WeakReference<ImageView> weakTargetImageView;

        ImagePreparation(Context context, Uri imageUri, ImageView targetImageView, OnImageHelperListener onImageHelperListener) {
            this.context = context;
            this.imageUri = imageUri;
            this.weakTargetImageView = new WeakReference<>(targetImageView);
            this.onImageHelperListener = onImageHelperListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream openInputStream = this.context.getContentResolver().openInputStream(this.imageUri);
                try {
                    BitmapFactory.decodeStream(openInputStream, null, options);
                    Utils.close(openInputStream);
                    if (options.outWidth != 0 && options.outHeight != 0) {
                        int calculateReqWidth = ImageHelper.calculateReqWidth(this.context);
                        options.inSampleSize = ImageHelper.calculateInSamplesSize(options, calculateReqWidth, ImageHelper.calculateReqHeight(calculateReqWidth));
                        options.inJustDecodeBounds = false;
                        openInputStream = this.context.getContentResolver().openInputStream(this.imageUri);
                        try {
                            this.image = new BitmapDrawable(this.context.getResources(), BitmapFactory.decodeStream(openInputStream, null, options));
                            Utils.close(openInputStream);
                            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.nativead.utils.ImageHelper.ImagePreparation.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView = (ImageView) ImagePreparation.this.weakTargetImageView.get();
                                    if (imageView == null || ImagePreparation.this.image == null) {
                                        ImagePreparation.this.onImageHelperListener.onError("Target ImageView or Bitmap is invalid");
                                    } else {
                                        ImagePreparation.this.onImageHelperListener.onImagePrepared(imageView, ImagePreparation.this.image);
                                    }
                                }
                            });
                            return;
                        } finally {
                        }
                    }
                    this.onImageHelperListener.onError("Image size is (0;0)");
                } finally {
                }
            } catch (Throwable th) {
                String message = th.getMessage();
                OnImageHelperListener onImageHelperListener = this.onImageHelperListener;
                if (message == null) {
                    message = "ImagePreparation error";
                }
                onImageHelperListener.onError(message);
            }
        }
    }
}
