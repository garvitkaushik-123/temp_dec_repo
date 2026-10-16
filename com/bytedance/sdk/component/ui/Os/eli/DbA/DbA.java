package com.bytedance.sdk.component.ui.Os.eli.DbA;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ui.dV;

/* loaded from: classes3.dex */
public class DbA implements dV {
    private int DbA;
    private com.bytedance.sdk.component.ui.Os.eli.Os<String, Bitmap> Os;
    private int eli;

    public DbA(int i, int i2) {
        this.DbA = i;
        this.eli = i2;
        this.Os = new com.bytedance.sdk.component.ui.Os.eli.Os<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.ui.Os.eli.DbA.DbA.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ui.Os.eli.Os
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int DbA(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return DbA.eli(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.Os.eli(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public Bitmap eli(String str) {
        return this.Os.eli((com.bytedance.sdk.component.ui.Os.eli.Os<String, Bitmap>) str);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean DbA(String str) {
        return this.Os.eli((com.bytedance.sdk.component.ui.Os.eli.Os<String, Bitmap>) str) != null;
    }

    public static int eli(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
