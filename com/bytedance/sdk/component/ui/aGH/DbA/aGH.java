package com.bytedance.sdk.component.ui.aGH.DbA;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.ui.QX;
import com.bytedance.sdk.component.ui.aGH.Os.DbA.eli;
import com.bytedance.sdk.component.utils.du;

/* loaded from: classes3.dex */
public class aGH<T> implements MGA {
    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, QX qx, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        byte[] nn = os.nn();
        if (nn == null) {
            eliVar.eli(2000, "imageData is empty", new Exception("imageData is empty"));
            return false;
        }
        int nlS = os.nlS();
        os.eli(nn.length);
        if (nlS == 2) {
            boolean z = (com.bytedance.sdk.component.utils.MGA.DbA(nn) || du.eli(nn, 0)) ? false : true;
            if (com.bytedance.sdk.component.utils.MGA.eli(nn)) {
                eli(os, nn, z, eliVar);
            } else {
                eliVar.eli(1001, "result type is bit but data not image", new Exception("not image format"));
            }
        } else if (nlS == 3) {
            eliVar.eli(new com.bytedance.sdk.component.ui.aGH.Os.aGH().eli(os, nn, null, com.bytedance.sdk.component.utils.MGA.DbA(nn)));
        } else if (com.bytedance.sdk.component.utils.MGA.DbA(nn)) {
            DbA(os, nn, eliVar);
        } else if (du.eli(nn, 0)) {
            eli(os, nn, eliVar);
        } else if (com.bytedance.sdk.component.utils.MGA.eli(nn)) {
            eli(os, nn, true, eliVar);
        } else {
            eliVar.eli(1001, "is not supprot image type", new Exception("not supprot image type"));
        }
        return false;
    }

    private void eli(final com.bytedance.sdk.component.ui.aGH.Os.Os os, final byte[] bArr, final com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        try {
            new com.bytedance.sdk.component.ui.aGH.Os.DbA.eli().eli(bArr, new eli.InterfaceC0149eli() { // from class: com.bytedance.sdk.component.ui.aGH.DbA.aGH.1
                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli(Drawable drawable) {
                    eliVar.eli(new com.bytedance.sdk.component.ui.aGH.Os.aGH().eli(os, drawable, null, false));
                }

                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli() {
                    eliVar.eli(1002, "decode webp animate fail", new Exception("decode webp animate fail"));
                }

                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli(byte[] bArr2) {
                    if (com.bytedance.sdk.component.utils.MGA.eli(bArr)) {
                        aGH.this.eli(os, bArr, true, eliVar);
                    } else {
                        eliVar.eli(1001, "result type is webp animated but data not image", new Exception("webp animated not image format"));
                    }
                }
            });
        } catch (Throwable th) {
            eliVar.eli(2000, "decode webp animation error", th);
        }
    }

    private void DbA(final com.bytedance.sdk.component.ui.aGH.Os.Os os, final byte[] bArr, final com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        try {
            new com.bytedance.sdk.component.ui.aGH.Os.DbA.eli().eli(bArr, os.dV(), new eli.InterfaceC0149eli() { // from class: com.bytedance.sdk.component.ui.aGH.DbA.aGH.2
                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli(Drawable drawable) {
                    eliVar.eli(new com.bytedance.sdk.component.ui.aGH.Os.aGH().eli(os, drawable, null, true));
                }

                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli() {
                    eliVar.eli(1002, "decode gif fail", new Exception("decode gif fail"));
                }

                @Override // com.bytedance.sdk.component.ui.aGH.Os.DbA.eli.InterfaceC0149eli
                public void eli(byte[] bArr2) {
                    if (com.bytedance.sdk.component.utils.MGA.eli(bArr)) {
                        aGH.this.eli(os, bArr, true, eliVar);
                    } else {
                        eliVar.eli(1001, "result type is gif but data not image", new Exception("gif not image format"));
                    }
                }
            });
        } catch (Throwable th) {
            eliVar.eli(2000, "decode gif error", th);
        }
    }

    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public String eli() {
        return "decode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, byte[] bArr, boolean z, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        try {
            com.bytedance.sdk.component.ui.aGH.Os.MGA dV = os.dV();
            Bitmap eli = dV.eli(os).eli(bArr);
            if (eli != null) {
                os.aAs();
                os.eli();
                eli.getWidth();
                eli.getHeight();
                eli.getByteCount();
                eliVar.eli(new com.bytedance.sdk.component.ui.aGH.Os.aGH().eli(os, eli, null, false));
                if (z) {
                    eli(os.nGm(), dV, os.aAs(), eli);
                    return;
                }
                return;
            }
            os.aAs();
            os.eli();
            eliVar.eli(1002, "decode failed bitmap null", new Exception("decode failed bitmap null"));
        } catch (Throwable th) {
            os.aAs();
            os.eli();
            eliVar.eli(1002, "decode failed:" + th.getMessage(), th);
        }
    }

    private void eli(com.bytedance.sdk.component.ui.DbA dbA, com.bytedance.sdk.component.ui.aGH.Os.MGA mga, String str, Bitmap bitmap) {
        if (dbA == null || mga == null || !dbA.ui()) {
            return;
        }
        mga.eli(dbA).eli(str, bitmap);
    }
}
