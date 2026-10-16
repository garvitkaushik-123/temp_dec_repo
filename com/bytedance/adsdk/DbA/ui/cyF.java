package com.bytedance.adsdk.DbA.ui;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes3.dex */
class cyF {
    static com.bytedance.adsdk.DbA.Os.DbA.Dfc eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.eli eliVar = null;
        boolean z = false;
        boolean z2 = false;
        int i = 1;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fillEnabled":
                    z = jsonReader.nextBoolean();
                    break;
                case "c":
                    eliVar = aGH.kb(jsonReader, kbVar);
                    break;
                case "o":
                    agh = aGH.DbA(jsonReader, kbVar);
                    break;
                case "r":
                    i = jsonReader.nextInt();
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
        if (agh == null) {
            agh = new com.bytedance.adsdk.DbA.Os.eli.aGH(Collections.singletonList(new com.bytedance.adsdk.DbA.kb.eli(100)));
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.Dfc(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, eliVar, agh, z2);
    }
}
