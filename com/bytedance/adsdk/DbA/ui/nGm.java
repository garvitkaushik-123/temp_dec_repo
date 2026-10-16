package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class nGm implements FS<Integer> {
    public static final nGm eli = new nGm();

    private nGm() {
    }

    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public Integer DbA(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(QX.DbA(jsonReader) * f));
    }
}
