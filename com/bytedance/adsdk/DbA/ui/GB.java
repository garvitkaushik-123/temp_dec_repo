package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class GB {
    static com.bytedance.adsdk.DbA.Os.DbA.du eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "p":
                    nu = eli.DbA(jsonReader, kbVar);
                    break;
                case "r":
                    dbA = aGH.eli(jsonReader, kbVar);
                    break;
                case "s":
                    mga = aGH.Os(jsonReader, kbVar);
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
        return new com.bytedance.adsdk.DbA.Os.DbA.du(str, nu, mga, dbA, z);
    }
}
