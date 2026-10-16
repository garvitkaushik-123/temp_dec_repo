package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class Cp implements FS<com.bytedance.adsdk.DbA.Os.DbA.nn> {
    public static final Cp eli = new Cp();

    private Cp() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        if (r5.equals("i") == false) goto L10;
     */
    @Override // com.bytedance.adsdk.DbA.ui.FS
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.adsdk.DbA.Os.DbA.nn DbA(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (true) {
            char c = 1;
            if (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case 99:
                        if (nextName.equals("c")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 105:
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                        if (nextName.equals("v")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        z = jsonReader.nextBoolean();
                        break;
                    case 1:
                        list2 = QX.eli(jsonReader, f);
                        break;
                    case 2:
                        list3 = QX.eli(jsonReader, f);
                        break;
                    case 3:
                        list = QX.eli(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (list == null || list2 == null || list3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (list.isEmpty()) {
                    return new com.bytedance.adsdk.DbA.Os.DbA.nn(new PointF(), false, Collections.emptyList());
                }
                int size = list.size();
                PointF pointF = list.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = list.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.DbA.Os.eli(com.bytedance.adsdk.DbA.MGA.ui.eli(list.get(i2), list3.get(i2)), com.bytedance.adsdk.DbA.MGA.ui.eli(pointF2, list2.get(i)), pointF2));
                }
                if (z) {
                    PointF pointF3 = list.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.DbA.Os.eli(com.bytedance.adsdk.DbA.MGA.ui.eli(list.get(i3), list3.get(i3)), com.bytedance.adsdk.DbA.MGA.ui.eli(pointF3, list2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.DbA.Os.DbA.nn(pointF, z, arrayList);
            }
        }
    }
}
