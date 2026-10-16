package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: classes3.dex */
public class KM implements FS<PointF> {
    public static final KM eli = new KM();

    private KM() {
    }

    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public PointF DbA(JsonReader jsonReader, float f) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return QX.DbA(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return QX.DbA(jsonReader, f);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(peek)));
    }
}
