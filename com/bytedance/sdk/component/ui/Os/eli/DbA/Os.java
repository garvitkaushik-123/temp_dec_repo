package com.bytedance.sdk.component.ui.Os.eli.DbA;

import com.bytedance.sdk.component.ui.nGm;

/* loaded from: classes3.dex */
public class Os implements nGm {
    private int DbA;
    private com.bytedance.sdk.component.ui.Os.eli.Os<String, byte[]> Os;
    private int eli;

    public Os(int i, int i2) {
        this.DbA = i;
        this.eli = i2;
        this.Os = new com.bytedance.sdk.component.ui.Os.eli.Os<String, byte[]>(i) { // from class: com.bytedance.sdk.component.ui.Os.eli.DbA.Os.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ui.Os.eli.Os
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int DbA(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.Os.eli(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public byte[] eli(String str) {
        return this.Os.eli((com.bytedance.sdk.component.ui.Os.eli.Os<String, byte[]>) str);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean DbA(String str) {
        return this.Os.eli((com.bytedance.sdk.component.ui.Os.eli.Os<String, byte[]>) str) != null;
    }
}
