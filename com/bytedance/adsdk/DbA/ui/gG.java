package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.FC;
import java.io.IOException;

/* loaded from: classes3.dex */
class gG {
    static com.bytedance.adsdk.DbA.Os.DbA.FC eli(JsonReader jsonReader) throws IOException {
        String str = null;
        FC.eli eliVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "mm":
                    eliVar = FC.eli.eli(jsonReader.nextInt());
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.FC(str, eliVar, z);
    }
}
