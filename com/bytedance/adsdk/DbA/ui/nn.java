package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class nn {
    static com.bytedance.adsdk.DbA.Os.Os eli(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        float f = 0.0f;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fFamily":
                    str = jsonReader.nextString();
                    break;
                case "ascent":
                    f = (float) jsonReader.nextDouble();
                    break;
                case "fStyle":
                    str2 = jsonReader.nextString();
                    break;
                case "fName":
                    str3 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.DbA.Os.Os(str, str3, str2, f);
    }
}
