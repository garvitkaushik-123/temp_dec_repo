package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class ui {
    static com.bytedance.adsdk.DbA.Os.DbA.eli eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        com.bytedance.adsdk.DbA.Os.DbA.eli eliVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.DbA.Os.DbA.eli DbA = DbA(jsonReader, kbVar);
                    if (DbA != null) {
                        eliVar = DbA;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return eliVar;
    }

    private static com.bytedance.adsdk.DbA.Os.DbA.eli DbA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.DbA.Os.DbA.eli eliVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("v")) {
                    if (z) {
                        eliVar = new com.bytedance.adsdk.DbA.Os.DbA.eli(aGH.eli(jsonReader, kbVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (nextName.equals("ty")) {
                    if (jsonReader.nextInt() == 0) {
                        z = true;
                    }
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return eliVar;
        }
    }
}
