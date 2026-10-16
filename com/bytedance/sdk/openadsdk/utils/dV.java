package com.bytedance.sdk.openadsdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.nGm.eli.eli;

/* loaded from: classes3.dex */
public class dV {

    public interface eli {
        void eli();

        void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA);
    }

    public static void eli(com.bytedance.sdk.openadsdk.nGm.eli eliVar, int i, int i2, eli eliVar2, String str) {
        eli(eliVar, i, i2, eliVar2, str, 0);
    }

    public static void eli(com.bytedance.sdk.openadsdk.nGm.eli eliVar, int i, int i2, final eli eliVar2, String str, int i3) {
        new StringBuilder(" getImageBytes url ").append(eliVar);
        com.bytedance.sdk.openadsdk.nGm.DbA.DbA().aGH().eli(eliVar, new eli.InterfaceC0211eli() { // from class: com.bytedance.sdk.openadsdk.utils.dV.1
            @Override // com.bytedance.sdk.openadsdk.nGm.eli.eli.InterfaceC0211eli
            public void eli(String str2, com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
                eli eliVar3;
                if (dbA.ui() && (eliVar3 = eli.this) != null) {
                    eliVar3.eli(dbA);
                    return;
                }
                eli eliVar4 = eli.this;
                if (eliVar4 != null) {
                    eliVar4.eli();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.nGm.eli.eli.InterfaceC0211eli
            public void eli(int i4, String str2, Throwable th) {
                eli eliVar3 = eli.this;
                if (eliVar3 != null) {
                    eliVar3.eli();
                }
            }
        }, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, null);
    }

    public static Drawable eli(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
