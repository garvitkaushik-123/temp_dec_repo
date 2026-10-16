package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import java.io.IOException;

/* loaded from: classes3.dex */
class Uv {
    static com.bytedance.adsdk.DbA.Os.DbA.QX eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        String str = null;
        QX.eli eliVar = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "e":
                    dbA2 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "m":
                    eliVar = QX.eli.eli(jsonReader.nextInt());
                    break;
                case "o":
                    dbA3 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "s":
                    dbA = aGH.eli(jsonReader, kbVar, false);
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
        return new com.bytedance.adsdk.DbA.Os.DbA.QX(str, eliVar, dbA, dbA2, dbA3, z);
    }
}
