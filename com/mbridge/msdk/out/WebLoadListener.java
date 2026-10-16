package com.mbridge.msdk.out;

/* loaded from: classes6.dex */
public interface WebLoadListener {
    void onFailed(String str, int i, int i2, int i3, String str2, String str3);

    void onProgress(String str, int i, int i2, int i3, String str2, String str3);

    void onSucess(String str, int i, int i2, int i3, String str2, String str3);
}
