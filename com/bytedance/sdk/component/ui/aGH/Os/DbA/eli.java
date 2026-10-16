package com.bytedance.sdk.component.ui.aGH.Os.DbA;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bytedance.sdk.component.ui.aGH.Os.MGA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.kb;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class eli {

    /* renamed from: com.bytedance.sdk.component.ui.aGH.Os.DbA.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0149eli {
        void eli();

        void eli(Drawable drawable);

        void eli(byte[] bArr);
    }

    public void eli(byte[] bArr, MGA mga, InterfaceC0149eli interfaceC0149eli) {
        if (Build.VERSION.SDK_INT <= 30) {
            eli(bArr, interfaceC0149eli, mga);
        } else {
            eli(bArr, interfaceC0149eli);
        }
    }

    public void eli(byte[] bArr, InterfaceC0149eli interfaceC0149eli) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(ByteBuffer.wrap(bArr)));
            if (interfaceC0149eli != null) {
                interfaceC0149eli.eli(decodeDrawable);
            }
        } catch (Throwable th) {
            Xb.Os("PAGGifDefaultDecoder", th.getMessage());
            if (interfaceC0149eli != null) {
                interfaceC0149eli.eli();
            }
        }
    }

    private void eli(final byte[] bArr, final InterfaceC0149eli interfaceC0149eli, final MGA mga) {
        try {
            mga.wC().submit(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.DbA(bArr, mga, interfaceC0149eli);
                }
            });
        } catch (Throwable th) {
            Xb.Os("PAGGifDefaultDecoder", th.getMessage());
            if (interfaceC0149eli != null) {
                interfaceC0149eli.eli();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(byte[] bArr, MGA mga, InterfaceC0149eli interfaceC0149eli) {
        FileOutputStream fileOutputStream = null;
        try {
            boolean kb = mga.kb();
            File eli = kb.eli(mga.eli(), kb, kb ? "P_GIF_MUTIL_CACHE/" : "/P_GIF_CACHE/", "P_U_GIF_FILE");
            FileOutputStream fileOutputStream2 = new FileOutputStream(eli);
            try {
                fileOutputStream2.write(bArr, 0, bArr.length);
                Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(eli));
                if (interfaceC0149eli != null) {
                    interfaceC0149eli.eli(decodeDrawable);
                }
                try {
                    fileOutputStream2.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    Xb.eli("PAGGifDefaultDecoder", "Gif  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (interfaceC0149eli != null) {
                        interfaceC0149eli.eli();
                    }
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
        }
    }
}
