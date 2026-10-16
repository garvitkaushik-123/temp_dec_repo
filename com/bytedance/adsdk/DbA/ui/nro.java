package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: classes3.dex */
public class nro implements FS<com.bytedance.adsdk.DbA.kb.Os> {
    public static final nro eli = new nro();

    private nro() {
    }

    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.DbA.kb.Os DbA(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.DbA.kb.Os((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
