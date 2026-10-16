package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class MGA {
    static com.bytedance.adsdk.DbA.Os.DbA.DbA eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, int i) throws IOException {
        boolean z = i == 3;
        boolean z2 = false;
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "p":
                    nu = eli.DbA(jsonReader, kbVar);
                    break;
                case "s":
                    mga = aGH.Os(jsonReader, kbVar);
                    break;
                case "hd":
                    z2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.DbA(str, nu, mga, z, z2);
    }
}
