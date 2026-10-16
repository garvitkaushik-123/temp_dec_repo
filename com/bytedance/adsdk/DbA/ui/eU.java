package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class eU {
    static com.bytedance.adsdk.DbA.Os.DbA.aqO eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.DbA.Os.DbA.Os eli = wC.eli(jsonReader, kbVar);
                        if (eli != null) {
                            arrayList.add(eli);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.aqO(str, arrayList, z);
    }
}
