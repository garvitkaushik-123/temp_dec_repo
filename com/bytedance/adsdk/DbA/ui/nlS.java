package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class nlS implements FS<Float> {
    public static final nlS eli = new nlS();

    private nlS() {
    }

    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public Float DbA(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(QX.DbA(jsonReader) * f);
    }
}
