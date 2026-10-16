package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
class Xb {
    private static SparseArray<WeakReference<Interpolator>> DbA;
    private static final Interpolator eli = new LinearInterpolator();

    Xb() {
    }

    private static SparseArray<WeakReference<Interpolator>> eli() {
        if (DbA == null) {
            DbA = new SparseArray<>();
        }
        return DbA;
    }

    private static WeakReference<Interpolator> eli(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (Xb.class) {
            weakReference = eli().get(i);
        }
        return weakReference;
    }

    private static void eli(int i, WeakReference<Interpolator> weakReference) {
        synchronized (Xb.class) {
            DbA.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.DbA.kb.eli<T> eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, float f, FS<T> fs, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return DbA(kbVar, jsonReader, f, fs);
        }
        if (z) {
            return eli(kbVar, jsonReader, f, fs);
        }
        return eli(jsonReader, f, fs);
    }

    private static <T> com.bytedance.adsdk.DbA.kb.eli<T> eli(com.bytedance.adsdk.DbA.kb kbVar, JsonReader jsonReader, float f, FS<T> fs) throws IOException {
        Interpolator eli2;
        jsonReader.beginObject();
        PointF pointF = null;
        T t = null;
        T t2 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f2 = 0.0f;
        boolean z = false;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "e":
                    t = fs.DbA(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "i":
                    pointF4 = QX.DbA(jsonReader, 1.0f);
                    break;
                case "o":
                    pointF = QX.DbA(jsonReader, 1.0f);
                    break;
                case "s":
                    t2 = fs.DbA(jsonReader, f);
                    break;
                case "t":
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointF3 = QX.DbA(jsonReader, f);
                    break;
                case "to":
                    pointF2 = QX.DbA(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            t = t2;
        } else if (pointF != null && pointF4 != null) {
            eli2 = eli(pointF, pointF4);
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t2, t, eli2, f2, null);
            eliVar.wC = pointF2;
            eliVar.FC = pointF3;
            return eliVar;
        }
        eli2 = eli;
        com.bytedance.adsdk.DbA.kb.eli<T> eliVar2 = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t2, t, eli2, f2, null);
        eliVar2.wC = pointF2;
        eliVar2.FC = pointF3;
        return eliVar2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x024a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> com.bytedance.adsdk.DbA.kb.eli<T> DbA(com.bytedance.adsdk.DbA.kb kbVar, JsonReader jsonReader, float f, FS<T> fs) throws IOException {
        Interpolator eli2;
        Interpolator eli3;
        T t;
        Interpolator interpolator;
        Interpolator eli4;
        PointF pointF;
        PointF pointF2;
        com.bytedance.adsdk.DbA.kb.eli<T> eliVar;
        T t2;
        String str;
        float f2;
        float f3;
        jsonReader.beginObject();
        boolean z = false;
        PointF pointF3 = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        T t3 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f4 = 0.0f;
        T t4 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 1;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
                        c = 2;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3701:
                    if (nextName.equals("ti")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3707:
                    if (nextName.equals("to")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            String str2 = VastAttributes.VERTICAL_POSITION;
            switch (c) {
                case 0:
                    t4 = fs.DbA(jsonReader, f);
                    continue;
                case 1:
                    t2 = t3;
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 2:
                    boolean z2 = z;
                    t2 = t3;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals(VastAttributes.HORIZONTAL_POSITION)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    str = str2;
                                    f7 = (float) jsonReader.nextDouble();
                                    f5 = f7;
                                } else {
                                    str = str2;
                                    jsonReader.beginArray();
                                    float nextDouble = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        f2 = nextDouble;
                                        f3 = (float) jsonReader.nextDouble();
                                    } else {
                                        f2 = nextDouble;
                                        f3 = f2;
                                    }
                                    jsonReader.endArray();
                                    f5 = f2;
                                    f7 = f3;
                                }
                                str2 = str;
                            } else if (nextName2.equals(str2)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    f8 = (float) jsonReader.nextDouble();
                                    f6 = f8;
                                } else {
                                    jsonReader.beginArray();
                                    f6 = (float) jsonReader.nextDouble();
                                    f8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f6;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        PointF pointF11 = new PointF(f5, f6);
                        pointF8 = new PointF(f7, f8);
                        jsonReader.endObject();
                        pointF7 = pointF11;
                    } else {
                        pointF4 = QX.DbA(jsonReader, f);
                    }
                    z = z2;
                    break;
                case 3:
                    boolean z3 = z;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        while (jsonReader.hasNext()) {
                            T t5 = t3;
                            String nextName3 = jsonReader.nextName();
                            nextName3.hashCode();
                            if (nextName3.equals(VastAttributes.HORIZONTAL_POSITION)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    f11 = (float) jsonReader.nextDouble();
                                    f9 = f11;
                                } else {
                                    jsonReader.beginArray();
                                    f9 = (float) jsonReader.nextDouble();
                                    f11 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f9;
                                    jsonReader.endArray();
                                }
                            } else if (nextName3.equals(VastAttributes.VERTICAL_POSITION)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    f12 = (float) jsonReader.nextDouble();
                                    f10 = f12;
                                } else {
                                    jsonReader.beginArray();
                                    f10 = (float) jsonReader.nextDouble();
                                    f12 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f10;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            t3 = t5;
                        }
                        PointF pointF12 = new PointF(f9, f10);
                        PointF pointF13 = new PointF(f11, f12);
                        jsonReader.endObject();
                        pointF5 = pointF12;
                        pointF6 = pointF13;
                    } else {
                        pointF3 = QX.DbA(jsonReader, f);
                    }
                    z = z3;
                    continue;
                case 4:
                    t3 = fs.DbA(jsonReader, f);
                    continue;
                case 5:
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                case 6:
                    pointF10 = QX.DbA(jsonReader, f);
                    continue;
                case 7:
                    pointF9 = QX.DbA(jsonReader, f);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            t3 = t2;
        }
        boolean z4 = z;
        T t6 = t3;
        jsonReader.endObject();
        if (z4) {
            t4 = t6;
        } else {
            if (pointF3 != null && pointF4 != null) {
                eli4 = eli(pointF3, pointF4);
                interpolator = eli4;
                t = t4;
                eli2 = null;
                eli3 = null;
                if (eli2 == null) {
                }
                pointF = pointF9;
                pointF2 = pointF10;
                eliVar = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t6, t, interpolator, f4, null);
                eliVar.wC = pointF;
                eliVar.FC = pointF2;
                return eliVar;
            }
            if (pointF5 != null && pointF6 != null && pointF7 != null && pointF8 != null) {
                eli2 = eli(pointF5, pointF7);
                eli3 = eli(pointF6, pointF8);
                t = t4;
                interpolator = null;
                if (eli2 == null && eli3 != null) {
                    pointF2 = pointF10;
                    pointF = pointF9;
                    eliVar = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t6, t, eli2, eli3, f4, null);
                } else {
                    pointF = pointF9;
                    pointF2 = pointF10;
                    eliVar = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t6, t, interpolator, f4, null);
                }
                eliVar.wC = pointF;
                eliVar.FC = pointF2;
                return eliVar;
            }
        }
        eli4 = eli;
        interpolator = eli4;
        t = t4;
        eli2 = null;
        eli3 = null;
        if (eli2 == null) {
        }
        pointF = pointF9;
        pointF2 = pointF10;
        eliVar = new com.bytedance.adsdk.DbA.kb.eli<>(kbVar, t6, t, interpolator, f4, null);
        eliVar.wC = pointF;
        eliVar.FC = pointF2;
        return eliVar;
    }

    private static Interpolator eli(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.DbA.MGA.ui.DbA(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.DbA.MGA.ui.DbA(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.DbA.MGA.ui.DbA(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.DbA.MGA.ui.DbA(pointF2.y, -100.0f, 100.0f);
        int eli2 = com.bytedance.adsdk.DbA.MGA.MGA.eli(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> eli3 = com.bytedance.adsdk.DbA.ui.eli() ? null : eli(eli2);
        Interpolator interpolator = eli3 != null ? eli3.get() : null;
        if (eli3 != null && interpolator != null) {
            return interpolator;
        }
        try {
            linearInterpolator = com.bytedance.adsdk.DbA.dV.eli(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e) {
            if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                linearInterpolator = com.bytedance.adsdk.DbA.dV.eli(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            } else {
                linearInterpolator = new LinearInterpolator();
            }
        }
        if (!com.bytedance.adsdk.DbA.ui.eli()) {
            try {
                eli(eli2, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return linearInterpolator;
    }

    private static <T> com.bytedance.adsdk.DbA.kb.eli<T> eli(JsonReader jsonReader, float f, FS<T> fs) throws IOException {
        return new com.bytedance.adsdk.DbA.kb.eli<>(fs.DbA(jsonReader, f));
    }
}
