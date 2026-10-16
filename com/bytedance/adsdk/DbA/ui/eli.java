package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class eli {
    public static com.bytedance.adsdk.DbA.Os.eli.ui eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(ujq.eli(jsonReader, kbVar));
            }
            jsonReader.endArray();
            bf.eli(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.DbA.kb.eli(QX.DbA(jsonReader, com.bytedance.adsdk.DbA.MGA.MGA.eli())));
        }
        return new com.bytedance.adsdk.DbA.Os.eli.ui(arrayList);
    }

    static com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> DbA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.DbA.Os.eli.ui uiVar = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "k":
                    uiVar = eli(jsonReader, kbVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        dbA = aGH.eli(jsonReader, kbVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        dbA2 = aGH.eli(jsonReader, kbVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            kbVar.eli("Lottie doesn't support expressions.");
        }
        return uiVar != null ? uiVar : new com.bytedance.adsdk.DbA.Os.eli.FC(dbA, dbA2);
    }
}
