package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DbA {
    public static com.bytedance.adsdk.DbA.Os.eli.du eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.DbA.Os.eli.du duVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("a")) {
                duVar = DbA(jsonReader, kbVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return duVar == null ? new com.bytedance.adsdk.DbA.Os.eli.du(null, null, null, null) : duVar;
    }

    private static com.bytedance.adsdk.DbA.Os.eli.du DbA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.DbA.Os.eli.eli eliVar = null;
        com.bytedance.adsdk.DbA.Os.eli.eli eliVar2 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "t":
                    dbA2 = aGH.eli(jsonReader, kbVar);
                    break;
                case "fc":
                    eliVar = aGH.kb(jsonReader, kbVar);
                    break;
                case "sc":
                    eliVar2 = aGH.kb(jsonReader, kbVar);
                    break;
                case "sw":
                    dbA = aGH.eli(jsonReader, kbVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.DbA.Os.eli.du(eliVar, eliVar2, dbA, dbA2);
    }
}
