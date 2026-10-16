package com.bytedance.adsdk.DbA.ui;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* loaded from: classes3.dex */
public class Os {
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.adsdk.DbA.Os.eli.nlS eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        com.bytedance.adsdk.DbA.Os.eli.DbA eli;
        com.bytedance.adsdk.DbA.kb kbVar2 = kbVar;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.ui uiVar = null;
        com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu = null;
        com.bytedance.adsdk.DbA.Os.eli.kb kbVar3 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA3 = null;
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA4 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA5 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            uiVar = eli.eli(jsonReader, kbVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    kbVar2 = kbVar;
                    break;
                case "o":
                    agh = aGH.DbA(jsonReader, kbVar);
                    kbVar2 = kbVar;
                    break;
                case "p":
                    nu = eli.DbA(jsonReader, kbVar);
                    kbVar2 = kbVar;
                    break;
                case "r":
                    eli = aGH.eli(jsonReader, kbVar2, false);
                    if (!eli.Os().isEmpty()) {
                        eli.Os().add(new com.bytedance.adsdk.DbA.kb.eli(kbVar2, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(kbVar2.kb())));
                    } else if (((com.bytedance.adsdk.DbA.kb.eli) eli.Os().get(0)).eli != 0) {
                        dbA = eli;
                        kbVar2 = kbVar;
                        break;
                    } else {
                        eli.Os().set(0, new com.bytedance.adsdk.DbA.kb.eli(kbVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(kbVar.kb())));
                    }
                    kbVar2 = kbVar;
                    dbA = eli;
                    break;
                case "s":
                    kbVar3 = aGH.aGH(jsonReader, kbVar);
                    break;
                case "eo":
                    dbA5 = aGH.eli(jsonReader, kbVar2, false);
                    break;
                case "rz":
                    kbVar2.eli("Lottie doesn't support 3D layers.");
                    eli = aGH.eli(jsonReader, kbVar2, false);
                    if (!eli.Os().isEmpty()) {
                    }
                    kbVar2 = kbVar;
                    dbA = eli;
                    break;
                case "sa":
                    dbA3 = aGH.eli(jsonReader, kbVar2, false);
                    break;
                case "sk":
                    dbA2 = aGH.eli(jsonReader, kbVar2, false);
                    break;
                case "so":
                    dbA4 = aGH.eli(jsonReader, kbVar2, false);
                    break;
                default:
                    jsonReader.skipValue();
                    kbVar2 = kbVar;
                    break;
            }
        }
        if (z) {
            jsonReader.endObject();
        }
        return new com.bytedance.adsdk.DbA.Os.eli.nlS(eli(uiVar) ? null : uiVar, eli(nu) ? null : nu, eli(kbVar3) ? null : kbVar3, eli(dbA) ? null : dbA, agh, dbA4, dbA5, DbA(dbA2) ? null : dbA2, Os(dbA3) ? null : dbA3);
    }

    private static boolean eli(com.bytedance.adsdk.DbA.Os.eli.ui uiVar) {
        if (uiVar != null) {
            return uiVar.DbA() && uiVar.Os().get(0).eli.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean eli(com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu) {
        if (nu != null) {
            return !(nu instanceof com.bytedance.adsdk.DbA.Os.eli.FC) && nu.DbA() && nu.Os().get(0).eli.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean eli(com.bytedance.adsdk.DbA.Os.eli.DbA dbA) {
        if (dbA != null) {
            return dbA.DbA() && ((Float) ((com.bytedance.adsdk.DbA.kb.eli) dbA.Os().get(0)).eli).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean eli(com.bytedance.adsdk.DbA.Os.eli.kb kbVar) {
        if (kbVar != null) {
            return kbVar.DbA() && ((com.bytedance.adsdk.DbA.kb.Os) ((com.bytedance.adsdk.DbA.kb.eli) kbVar.Os().get(0)).eli).DbA(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean DbA(com.bytedance.adsdk.DbA.Os.eli.DbA dbA) {
        if (dbA != null) {
            return dbA.DbA() && ((Float) ((com.bytedance.adsdk.DbA.kb.eli) dbA.Os().get(0)).eli).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean Os(com.bytedance.adsdk.DbA.Os.eli.DbA dbA) {
        if (dbA != null) {
            return dbA.DbA() && ((Float) ((com.bytedance.adsdk.DbA.kb.eli) dbA.Os().get(0)).eli).floatValue() == 0.0f;
        }
        return true;
    }
}
