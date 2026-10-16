package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: classes3.dex */
class ujq {
    static com.bytedance.adsdk.DbA.eli.DbA.FC eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.eli.DbA.FC(kbVar, Xb.eli(jsonReader, kbVar, com.bytedance.adsdk.DbA.MGA.MGA.eli(), Ue.eli, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
