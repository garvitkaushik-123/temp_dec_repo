package com.bytedance.sdk.openadsdk.core.aAs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.du;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.sdk.component.ui.aAs;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.adsdk.ugeno.eli {

    /* renamed from: com.bytedance.sdk.openadsdk.core.aAs.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0183eli {
        void eli(Drawable drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.eli
    public void eli(du duVar, String str, ImageView imageView, int i, int i2, eli.InterfaceC0124eli interfaceC0124eli) {
        String eli = Os.eli(str);
        aAs Os = com.bytedance.sdk.openadsdk.FC.aGH.eli(eli).Os(1);
        eli(duVar, Os, eli);
        Os.eli(new DbA(imageView, this, i, i2), 4);
    }

    private static class DbA implements aqO {
        private final eli DbA;
        private final int Os;
        private final int aGH;
        private final WeakReference<ImageView> eli;

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
        }

        public DbA(ImageView imageView, eli eliVar, int i, int i2) {
            this.eli = new WeakReference<>(imageView);
            this.DbA = eliVar;
            this.Os = i;
            this.aGH = i2;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            try {
                final ImageView imageView = this.eli.get();
                if (imageView == null) {
                    return;
                }
                final Object DbA = duVar.DbA();
                if (DbA instanceof Drawable) {
                    cyF.eli((Runnable) new wC("load_draw_img") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj = DbA;
                            if (obj instanceof AnimatedImageDrawable) {
                                ((AnimatedImageDrawable) obj).start();
                            }
                            imageView.setImageDrawable((Drawable) DbA);
                        }
                    });
                    return;
                }
                if (DbA instanceof byte[]) {
                    if (duVar.ui()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.DbA.eli((byte[]) DbA, imageView);
                            return;
                        } else {
                            this.DbA.eli(imageView, (byte[]) DbA, this.Os, this.aGH);
                            return;
                        }
                    }
                    if (this.DbA.eli((byte[]) DbA)) {
                        this.DbA.eli(imageView, (byte[]) DbA, this.Os, this.aGH);
                        return;
                    }
                    final Bitmap eli = new com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA(this.Os, this.aGH, imageView.getScaleType(), Bitmap.Config.RGB_565, this.Os, this.aGH).eli((byte[]) DbA);
                    if (eli != null) {
                        cyF.eli((Runnable) new wC("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.2
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(eli);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (DbA instanceof Bitmap) {
                    cyF.eli((Runnable) new wC("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.3
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap((Bitmap) DbA);
                        }
                    });
                }
            } catch (Throwable th) {
                Xb.Os("ImageLoaderProvider", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            final Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(ByteBuffer.wrap(bArr)));
            if (decodeDrawable != null) {
                cyF.eli((Runnable) new wC("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable = decodeDrawable;
                        if (drawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                        imageView.setImageDrawable(decodeDrawable);
                    }
                });
            }
        } catch (IOException e) {
            Xb.Os("ImageLoaderProvider", e.getMessage());
        }
    }

    private void DbA(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap eli = new com.bytedance.sdk.component.ui.aGH.Os.DbA.DbA(i, i2, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i, i2).eli(bArr);
        if (eli != null) {
            cyF.eli((Runnable) new wC("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(eli);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(byte[] bArr, final ImageView imageView) {
        try {
            eli(bArr, new InterfaceC0183eli() { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.3
                @Override // com.bytedance.sdk.openadsdk.core.aAs.eli.InterfaceC0183eli
                public void eli(final Drawable drawable) {
                    cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Drawable drawable2 = drawable;
                            if (drawable2 instanceof AnimatedImageDrawable) {
                                ((AnimatedImageDrawable) drawable2).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            Xb.Os("ImageLoaderProvider", e.getMessage());
        }
    }

    private void eli(final byte[] bArr, final InterfaceC0183eli interfaceC0183eli) {
        cyF.DbA(new wC("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable DbA2 = eli.this.DbA(bArr);
                InterfaceC0183eli interfaceC0183eli2 = interfaceC0183eli;
                if (interfaceC0183eli2 != null) {
                    interfaceC0183eli2.eli(DbA2);
                }
            }
        });
    }

    public boolean eli(byte[] bArr) {
        return com.bytedance.sdk.component.utils.du.eli(bArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable DbA(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean Os = com.bytedance.sdk.openadsdk.multipro.DbA.Os();
            File eli = kb.eli(dV.eli(), Os, Os ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(eli);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(eli));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return decodeDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    Xb.eli("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli
    public void eli(du duVar, String str, eli.InterfaceC0124eli interfaceC0124eli) {
        DbA(duVar, Os.eli(str), interfaceC0124eli);
    }

    public void DbA(du duVar, String str, final eli.InterfaceC0124eli interfaceC0124eli) {
        aAs Os = com.bytedance.sdk.openadsdk.FC.aGH.eli(str).Os(2);
        eli(duVar, Os, str);
        Os.eli(new aqO() { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.5
            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(com.bytedance.sdk.component.ui.du duVar2) {
                if (duVar2 == null) {
                    interfaceC0124eli.eli(null);
                    return;
                }
                if (interfaceC0124eli != null) {
                    Object DbA2 = duVar2.DbA();
                    if (DbA2 instanceof Bitmap) {
                        interfaceC0124eli.eli((Bitmap) DbA2);
                        return;
                    }
                    if (duVar2.DbA() instanceof byte[]) {
                        try {
                            interfaceC0124eli.eli(BitmapFactory.decodeByteArray((byte[]) duVar2.DbA(), 0, ((byte[]) duVar2.DbA()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0124eli.eli(null);
                }
            }

            @Override // com.bytedance.sdk.component.ui.aqO
            public void eli(int i, String str2, Throwable th) {
                eli.InterfaceC0124eli interfaceC0124eli2 = interfaceC0124eli;
                if (interfaceC0124eli2 != null) {
                    interfaceC0124eli2.eli(null);
                }
            }
        }, 4);
    }

    private void eli(du duVar, aAs aas, String str) {
        Map<String, Object> DbA2;
        if (duVar == null || (DbA2 = duVar.DbA()) == null) {
            return;
        }
        Object obj = DbA2.get("image_info");
        if (obj instanceof Map) {
            aas.eli((String) ((Map) obj).get(str));
        }
        String str2 = (String) DbA2.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        aas.DbA(str2);
    }
}
