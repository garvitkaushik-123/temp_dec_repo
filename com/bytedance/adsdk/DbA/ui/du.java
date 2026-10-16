package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class du {
    private com.bytedance.adsdk.DbA.Os.eli.DbA DbA;
    private com.bytedance.adsdk.DbA.Os.eli.DbA Os;
    private com.bytedance.adsdk.DbA.Os.eli.DbA aGH;
    private com.bytedance.adsdk.DbA.Os.eli.eli eli;
    private com.bytedance.adsdk.DbA.Os.eli.DbA ui;

    aAs eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    DbA(jsonReader, kbVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.eli == null || this.DbA == null || this.Os == null || this.aGH == null || this.ui == null) {
            return null;
        }
        return new aAs(this.eli, this.DbA, this.Os, this.aGH, this.ui);
    }

    private void DbA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("v")) {
                str.hashCode();
                switch (str) {
                    case "Distance":
                        this.aGH = aGH.eli(jsonReader, kbVar);
                        break;
                    case "Opacity":
                        this.DbA = aGH.eli(jsonReader, kbVar, false);
                        break;
                    case "Direction":
                        this.Os = aGH.eli(jsonReader, kbVar, false);
                        break;
                    case "Shadow Color":
                        this.eli = aGH.kb(jsonReader, kbVar);
                        break;
                    case "Softness":
                        this.ui = aGH.eli(jsonReader, kbVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (nextName.equals("nm")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
