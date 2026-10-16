package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.aAs;
import java.io.IOException;

/* loaded from: classes3.dex */
class VM {
    static com.bytedance.adsdk.DbA.Os.DbA.aAs eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, int i) throws IOException {
        boolean z = false;
        boolean z2 = i == 3;
        String str = null;
        aAs.eli eliVar = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA3 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA4 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA5 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case "p":
                    nu = eli.DbA(jsonReader, kbVar);
                    break;
                case "r":
                    dbA2 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ir":
                    dbA3 = aGH.eli(jsonReader, kbVar);
                    break;
                case "is":
                    dbA5 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "or":
                    dbA4 = aGH.eli(jsonReader, kbVar);
                    break;
                case "os":
                    dbA6 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "pt":
                    dbA = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "sy":
                    eliVar = aAs.eli.eli(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.aAs(str, eliVar, dbA, nu, dbA2, dbA3, dbA4, dbA5, dbA6, z, z2);
    }
}
