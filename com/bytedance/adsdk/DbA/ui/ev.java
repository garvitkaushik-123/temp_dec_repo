package com.bytedance.adsdk.DbA.ui;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.adsdk.DbA.Os.Os.ui;
import com.bytedance.adsdk.DbA.aAs;
import com.bytedance.adsdk.DbA.kb;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import io.bidmachine.media3.exoplayer.upstream.CmcdConfiguration;
import io.ktor.http.LinkHeader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ev {
    public static com.bytedance.adsdk.DbA.kb eli(JsonReader jsonReader) throws IOException {
        float f;
        float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
        LongSparseArray<com.bytedance.adsdk.DbA.Os.Os.ui> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.DbA.Os.aGH> sparseArray = new SparseArray<>();
        kb.Os os = new kb.Os();
        kb.eli eliVar = new kb.eli();
        kb.DbA dbA = new kb.DbA();
        com.bytedance.adsdk.DbA.kb kbVar = new com.bytedance.adsdk.DbA.kb();
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        String str = null;
        int i = 0;
        int i2 = 0;
        float f4 = 0.0f;
        while (jsonReader.hasNext()) {
            float f5 = f2;
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    f = f4;
                    if (nextName.equals("assets")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    f = f4;
                    if (nextName.equals("layers")) {
                        c = 1;
                        break;
                    }
                    break;
                case -865448777:
                    f = f4;
                    if (nextName.equals("globalEvent")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104:
                    f = f4;
                    if (nextName.equals("h")) {
                        c = 3;
                        break;
                    }
                    break;
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    f = f4;
                    if (nextName.equals("v")) {
                        c = 4;
                        break;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    f = f4;
                    if (nextName.equals("w")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3208:
                    f = f4;
                    if (nextName.equals(CmcdConfiguration.KEY_DEADLINE)) {
                        c = 6;
                        break;
                    }
                    break;
                case 3276:
                    f = f4;
                    if (nextName.equals("fr")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3292:
                    f = f4;
                    if (nextName.equals("gc")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3367:
                    f = f4;
                    if (nextName.equals("ip")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3553:
                    f = f4;
                    if (nextName.equals("op")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 94623709:
                    f = f4;
                    if (nextName.equals("chars")) {
                        c = 11;
                        break;
                    }
                    break;
                case 97615364:
                    f = f4;
                    if (nextName.equals("fonts")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 110364485:
                    f = f4;
                    if (nextName.equals("timer")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 839250809:
                    f = f4;
                    if (nextName.equals("markers")) {
                        c = 14;
                        break;
                    }
                    break;
                default:
                    f = f4;
                    break;
            }
            switch (c) {
                case 0:
                    eli(jsonReader, kbVar, hashMap, hashMap2);
                    f2 = f5;
                    f4 = f;
                    break;
                case 1:
                    eli(jsonReader, kbVar, arrayList, longSparseArray);
                    f2 = f5;
                    f4 = f;
                    break;
                case 2:
                    eli(jsonReader, dbA);
                    f2 = f5;
                    f4 = f;
                    break;
                case 3:
                    i = jsonReader.nextInt();
                    f2 = f5;
                    f4 = f;
                    break;
                case 4:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.DbA.MGA.MGA.eli(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        kbVar.eli("Lottie only supports bodymovin >= 4.4.0");
                    }
                    f2 = f5;
                    f4 = f;
                    break;
                case 5:
                    i2 = jsonReader.nextInt();
                    f2 = f5;
                    f4 = f;
                    break;
                case 6:
                    str = jsonReader.nextString();
                    f2 = f5;
                    f4 = f;
                    break;
                case 7:
                    f3 = (float) jsonReader.nextDouble();
                    f2 = f5;
                    f4 = f;
                    break;
                case '\b':
                    eli(jsonReader, eliVar);
                    f2 = f5;
                    f4 = f;
                    break;
                case '\t':
                    f2 = (float) jsonReader.nextDouble();
                    f4 = f;
                    break;
                case '\n':
                    f4 = ((float) jsonReader.nextDouble()) - 0.01f;
                    f2 = f5;
                    break;
                case 11:
                    eli(jsonReader, kbVar, sparseArray);
                    f2 = f5;
                    f4 = f;
                    break;
                case '\f':
                    eli(jsonReader, hashMap3);
                    f2 = f5;
                    f4 = f;
                    break;
                case '\r':
                    eli(jsonReader, os);
                    f2 = f5;
                    f4 = f;
                    break;
                case 14:
                    eli(jsonReader, arrayList2);
                    f2 = f5;
                    f4 = f;
                    break;
                default:
                    jsonReader.skipValue();
                    f2 = f5;
                    f4 = f;
                    break;
            }
        }
        jsonReader.endObject();
        kbVar.eli(new Rect(0, 0, (int) (i2 * eli), (int) (i * eli)), f2, f4, f3, arrayList, longSparseArray, hashMap, hashMap2, sparseArray, hashMap3, arrayList2, os, str, eliVar, dbA);
        return kbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void eli(JsonReader jsonReader, kb.DbA dbA) {
        char c;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == 3239) {
                    if (nextName.equals("el")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != 107027) {
                    if (hashCode == 3237004 && nextName.equals("inel")) {
                        c = 0;
                        if (c != 0) {
                            dbA.DbA = new int[][]{new int[]{-1, -1}};
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                jsonReader.beginArray();
                                for (int i = 0; i < 2; i++) {
                                    if (jsonReader.hasNext()) {
                                        dbA.DbA[0][i] = jsonReader.nextInt();
                                    }
                                }
                                jsonReader.endArray();
                            }
                            jsonReader.endArray();
                        } else if (c == 1) {
                            dbA.eli = jsonReader.nextString();
                        } else if (c == 2) {
                            dbA.Os = Os(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (nextName.equals("lel")) {
                        c = 2;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void eli(JsonReader jsonReader, kb.eli eliVar) {
        char c;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == 3139) {
                    if (nextName.equals("be")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode == 3232) {
                    if (nextName.equals("ee")) {
                        c = 2;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode == 3571) {
                    if (nextName.equals("pc")) {
                        c = 3;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != 3666) {
                    if (hashCode == 98713 && nextName.equals("cpf")) {
                        c = 4;
                        if (c != 0) {
                            eliVar.eli = jsonReader.nextInt();
                        } else if (c == 1) {
                            eliVar.DbA = DbA(jsonReader);
                        } else if (c == 2) {
                            eliVar.Os = DbA(jsonReader);
                        } else if (c == 3) {
                            eliVar.aGH = jsonReader.nextInt();
                        } else if (c == 4) {
                            DbA(jsonReader, eliVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (nextName.equals("se")) {
                        c = 0;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void DbA(JsonReader jsonReader, kb.eli eliVar) {
        char c;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == 3239) {
                    if (nextName.equals("el")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != 3276) {
                    if (hashCode == 107027 && nextName.equals("lel")) {
                        c = 2;
                        if (c != 0) {
                            eliVar.ui = jsonReader.nextInt();
                        } else if (c == 1) {
                            eliVar.MGA = jsonReader.nextString();
                        } else if (c == 2) {
                            eliVar.kb = Os(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (nextName.equals("fr")) {
                        c = 0;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    private static Map<String, Object> DbA(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("lel")) {
                hashMap.put("lel", Os(jsonReader));
            } else if (nextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                hashMap.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    nextName2.hashCode();
                    if (nextName2.equals("hd")) {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object remove = hashMap.remove("lottie_back");
        if (remove instanceof JSONObject) {
            Object obj = hashMap.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(remove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(remove);
                hashMap.put("lel", jSONArray);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void eli(JsonReader jsonReader, kb.Os os) {
        char c;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == 3123) {
                    if (nextName.equals("at")) {
                        c = 3;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else if (hashCode == 3239) {
                    if (nextName.equals("el")) {
                        c = 5;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else if (hashCode == 3355) {
                    if (nextName.equals("id")) {
                        c = 1;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else if (hashCode == 3418) {
                    if (nextName.equals("ke")) {
                        c = 0;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else if (hashCode == 3704) {
                    if (nextName.equals("tl")) {
                        c = 2;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else if (hashCode != 107027) {
                    if (hashCode == 3237004 && nextName.equals("inel")) {
                        c = 4;
                        switch (c) {
                            case 0:
                                os.eli = jsonReader.nextInt();
                                break;
                            case 1:
                                os.DbA = jsonReader.nextString();
                                break;
                            case 2:
                                os.Os = jsonReader.nextString();
                                break;
                            case 3:
                                os.aGH = jsonReader.nextString();
                                break;
                            case 4:
                                os.ui = new int[]{-1, -1};
                                jsonReader.beginArray();
                                for (int i = 0; i < 2; i++) {
                                    if (jsonReader.hasNext()) {
                                        os.ui[i] = jsonReader.nextInt();
                                    }
                                }
                                jsonReader.endArray();
                                break;
                            case 5:
                                os.MGA = jsonReader.nextString();
                                break;
                            case 6:
                                os.kb = Os(jsonReader);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else {
                    if (nextName.equals("lel")) {
                        c = 6;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, List<com.bytedance.adsdk.DbA.Os.Os.ui> list, LongSparseArray<com.bytedance.adsdk.DbA.Os.Os.ui> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.DbA.Os.Os.ui eli = CMM.eli(jsonReader, kbVar);
            eli.du();
            ui.eli eliVar = ui.eli.IMAGE;
            list.add(eli);
            longSparseArray.put(eli.ui(), eli);
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, Map<String, List<com.bytedance.adsdk.DbA.Os.Os.ui>> map, Map<String, com.bytedance.adsdk.DbA.aAs> map2) throws IOException {
        char c;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            List<aAs.eli> list = null;
            String str5 = null;
            int[][] iArr = null;
            JSONArray jSONArray = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case ASSET_FAILED_STATUS_CODE_VALUE:
                        if (nextName.equals("u")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case JSON_ENCODE_ERROR_VALUE:
                        if (nextName.equals("w")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3239:
                        if (nextName.equals("el")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3695:
                        if (nextName.equals("tc")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 107027:
                        if (nextName.equals("lel")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 112793:
                        if (nextName.equals(LinkHeader.Parameters.Rel)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 3237004:
                        if (nextName.equals("inel")) {
                            c = '\n';
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
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.DbA.Os.Os.ui eli = CMM.eli(jsonReader, kbVar);
                            longSparseArray.put(eli.ui(), eli);
                            arrayList.add(eli);
                        }
                        jsonReader.endArray();
                        break;
                    case 1:
                        i2 = jsonReader.nextInt();
                        break;
                    case 2:
                        str2 = jsonReader.nextString();
                        break;
                    case 3:
                        str3 = jsonReader.nextString();
                        break;
                    case 4:
                        i = jsonReader.nextInt();
                        break;
                    case 5:
                        str5 = jsonReader.nextString();
                        break;
                    case 6:
                        str = jsonReader.nextString();
                        break;
                    case 7:
                        jsonReader.beginArray();
                        list = aGH(jsonReader);
                        jsonReader.endArray();
                        break;
                    case '\b':
                        jSONArray = Os(jsonReader);
                        break;
                    case '\t':
                        str4 = jsonReader.nextString();
                        break;
                    case '\n':
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i3 = 0; i3 < 2; i3++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i3] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.bytedance.adsdk.DbA.aAs aas = new com.bytedance.adsdk.DbA.aAs(i, i2, str, str2, str3, str4, list, str5, iArr, jSONArray);
                map2.put(aas.wC(), aas);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static JSONArray Os(JsonReader jsonReader) {
        char c;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode != 3324) {
                        if (hashCode == 116753 && nextName.equals("vid")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (nextName.equals("hd")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                    if (c == 0) {
                        jSONObject.put("vid", jsonReader.nextString());
                    } else if (c == 1) {
                        try {
                            jSONObject.put("hd", jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<aAs.eli> aGH(JsonReader jsonReader) {
        char c;
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                aAs.eli eliVar = new aAs.eli();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode == 99) {
                        if (nextName.equals("c")) {
                            c = 3;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode == 102) {
                        if (nextName.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                            c = 4;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode == 108) {
                        if (nextName.equals("l")) {
                            c = 0;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode == 115) {
                        if (nextName.equals("s")) {
                            c = 2;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode == 3153) {
                        if (nextName.equals(CmcdConfiguration.KEY_BUFFER_STARVATION)) {
                            c = 5;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode != 3449) {
                        if (hashCode == 96670 && nextName.equals("ali")) {
                            c = 6;
                            switch (c) {
                                case 0:
                                    eliVar.eli = jsonReader.nextInt();
                                    break;
                                case 1:
                                    eliVar.DbA = jsonReader.nextInt();
                                    break;
                                case 2:
                                    eliVar.ui = jsonReader.nextInt();
                                    break;
                                case 3:
                                    eliVar.Os = jsonReader.nextString();
                                    break;
                                case 4:
                                    eliVar.aGH = jsonReader.nextString();
                                    break;
                                case 5:
                                    eliVar.MGA = jsonReader.nextInt();
                                    break;
                                case 6:
                                    eliVar.kb = jsonReader.nextString();
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else {
                        if (nextName.equals("le")) {
                            c = 1;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    }
                }
                jsonReader.endObject();
                arrayList.add(eliVar);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void eli(JsonReader jsonReader, Map<String, com.bytedance.adsdk.DbA.Os.Os> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.DbA.Os.Os eli = nn.eli(jsonReader);
                    map.put(eli.DbA(), eli);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, SparseArray<com.bytedance.adsdk.DbA.Os.aGH> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.DbA.Os.aGH eli = NU.eli(jsonReader, kbVar);
            sparseArray.put(eli.hashCode(), eli);
        }
        jsonReader.endArray();
    }

    private static void eli(JsonReader jsonReader, List<com.bytedance.adsdk.DbA.Os.MGA> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float f = 0.0f;
            String str = null;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "cm":
                        str = jsonReader.nextString();
                        break;
                    case "dr":
                        f2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        f = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.DbA.Os.MGA(str, f, f2));
        }
        jsonReader.endArray();
    }
}
