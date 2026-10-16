package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class NU {
    static com.bytedance.adsdk.DbA.Os.aGH eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d = 0.0d;
        String str = null;
        String str2 = null;
        char c = 0;
        double d2 = 0.0d;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fFamily":
                    str2 = jsonReader.nextString();
                    break;
                case "w":
                    d = jsonReader.nextDouble();
                    break;
                case "ch":
                    c = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.bytedance.adsdk.DbA.Os.DbA.aqO) wC.eli(jsonReader, kbVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    d2 = jsonReader.nextDouble();
                    break;
                case "style":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.DbA.Os.aGH(arrayList, c, d2, d, str, str2);
    }
}
