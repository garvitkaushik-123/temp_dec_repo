package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class qj {
    static com.bytedance.adsdk.DbA.Os.DbA.NU eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "r":
                    dbA = aGH.eli(jsonReader, kbVar, true);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (z) {
            return null;
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.NU(str, dbA);
    }
}
