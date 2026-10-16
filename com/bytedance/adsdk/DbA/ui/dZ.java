package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class dZ {
    static com.bytedance.adsdk.DbA.Os.DbA.dV eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.wC wCVar = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ks":
                    wCVar = aGH.ui(jsonReader, kbVar);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "ind":
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.dV(str, i, wCVar, z);
    }
}
