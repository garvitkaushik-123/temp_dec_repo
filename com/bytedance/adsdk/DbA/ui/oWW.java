package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class oWW {
    static com.bytedance.adsdk.DbA.Os.DbA.nlS eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.eli.nlS nls = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "c":
                    dbA = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "o":
                    dbA2 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "tr":
                    nls = Os.eli(jsonReader, kbVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.nlS(str, dbA, dbA2, nls, z);
    }
}
