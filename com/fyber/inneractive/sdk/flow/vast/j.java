package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.N6;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class j {
    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(19:3|(1:5)|108|109|(5:8|(1:10)(1:15)|11|(1:13)|14)|16|(9:20|(1:22)(1:58)|23|(14:26|27|28|29|(1:31)(1:46)|32|(1:34)|35|(1:37)|(1:39)|40|(2:42|43)(1:45)|44|24)|51|52|53|54|55)|59|(1:61)(1:107)|62|(1:64)|65|(1:67)(1:106)|68|69|70|71|(2:73|(9:75|(1:77)(1:101)|78|(7:81|82|83|(1:85)|(3:87|88|89)(1:91)|90|79)|94|95|96|97|98))|102)(19:110|(2:112|(19:118|(8:121|122|123|(1:125)(1:133)|126|(2:128|129)(2:131|132)|130|119)|136|137|(0)|16|(10:18|20|(0)(0)|23|(1:24)|51|52|53|54|55)|59|(0)(0)|62|(0)|65|(0)(0)|68|69|70|71|(0)|102))(2:138|(1:140)(2:141|(1:143)(2:144|(1:146)(2:147|(1:149)(17:150|109|(0)|16|(0)|59|(0)(0)|62|(0)|65|(0)(0)|68|69|70|71|(0)|102)))))|108|109|(0)|16|(0)|59|(0)(0)|62|(0)|65|(0)(0)|68|69|70|71|(0)|102)|6|(0)|16|(0)|59|(0)(0)|62|(0)|65|(0)(0)|68|69|70|71|(0)|102) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0243, code lost:
    
        com.fyber.inneractive.sdk.util.IAlog.f("Got exception adding param to json object: %s, %s", "number_of_endcards", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.g gVar, r rVar) {
        t tVar;
        InneractiveErrorCode inneractiveErrorCode;
        InneractiveErrorCode inneractiveErrorCode2;
        t tVar2;
        x a2;
        Set<com.fyber.inneractive.sdk.model.vast.r> keySet;
        ArrayList arrayList;
        JSONArray jSONArray;
        Iterator it;
        String str;
        String str2 = gVar.i;
        if ("VastErrorInvalidFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            tVar2 = t.VAST_ERROR_INVALID_RESPONSE;
            if (gVar.j != null) {
                a2 = new x().a(gVar.j, "exception");
            }
            t tVar3 = tVar2;
            inneractiveErrorCode = inneractiveErrorCode2;
            tVar = tVar3;
            a2 = null;
            if (tVar != null) {
                JSONArray b = rVar == null ? null : rVar.b();
                w wVar = new w(gVar);
                wVar.b = tVar;
                wVar.f1340a = inneractiveAdRequest;
                wVar.d = b;
                if (a2 != null) {
                    wVar.f.put(a2.f1342a);
                }
                wVar.a((String) null);
            }
            arrayList = gVar.Q;
            if (arrayList != null && arrayList.size() > 0) {
                u uVar = u.VAST_EVENT_COMPANION_FILTERED;
                JSONArray b2 = rVar != null ? null : rVar.b();
                w wVar2 = new w(gVar);
                wVar2.c = uVar;
                wVar2.f1340a = inneractiveAdRequest;
                wVar2.d = b2;
                JSONObject jSONObject = new JSONObject();
                jSONArray = new JSONArray();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    com.fyber.inneractive.sdk.model.vast.h hVar = (com.fyber.inneractive.sdk.model.vast.h) it.next();
                    hVar.getClass();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("w", hVar.f1286a);
                        jSONObject2.put("h", hVar.b);
                        jSONObject2.put(N6.I0, hVar.g);
                        jSONObject2.put("clt", hVar.h);
                        String str3 = hVar.f;
                        if (str3 != null) {
                            jSONObject2.put("content", str3);
                            str = "HTMLResource";
                        } else {
                            str = null;
                        }
                        l lVar = hVar.d;
                        if (lVar != null) {
                            jSONObject2.put("content", lVar.b);
                            jSONObject2.put("creativeType", hVar.d.f1288a);
                            str = "StaticResource";
                        }
                        if (!TextUtils.isEmpty(hVar.e)) {
                            jSONObject2.put("content", hVar.e);
                            str = "iFrameResource";
                        }
                        if (str != null) {
                            jSONObject2.put("type", str);
                        }
                        b bVar = hVar.i;
                        if (bVar != null) {
                            jSONObject2.put("reason", bVar.f1244a);
                            jSONObject2.put("exception", hVar.i.getMessage());
                        }
                    } catch (JSONException e) {
                        IAlog.a("Failed creating Companion json object: %s", e.getMessage());
                        jSONObject2 = null;
                    }
                    jSONArray.put(jSONObject2);
                }
                try {
                    jSONObject.put("companion_data", jSONArray);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONArray);
                }
                wVar2.f.put(jSONObject);
                wVar2.a((String) null);
            }
            com.fyber.inneractive.sdk.model.vast.b bVar2 = gVar.O;
            int size = bVar2 != null ? bVar2.g.size() : 0;
            ArrayList arrayList2 = gVar.Q;
            int size2 = arrayList2 != null ? arrayList2.size() : 0;
            u uVar2 = u.NUMBER_OF_COMPANIONS;
            JSONArray b3 = rVar == null ? null : rVar.b();
            w wVar3 = new w(gVar);
            wVar3.c = uVar2;
            wVar3.f1340a = inneractiveAdRequest;
            wVar3.d = b3;
            JSONObject jSONObject3 = new JSONObject();
            Integer valueOf = Integer.valueOf(size + size2);
            jSONObject3.put("number_of_endcards", valueOf);
            wVar3.f.put(jSONObject3);
            wVar3.a((String) null);
            if (gVar.O != null) {
                i iVar = new i(gVar);
                if (iVar.size() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    u uVar3 = u.OMID_VAST_DETECTION;
                    JSONArray b4 = rVar == null ? null : rVar.b();
                    w wVar4 = new w(gVar);
                    wVar4.c = uVar3;
                    wVar4.f1340a = inneractiveAdRequest;
                    wVar4.d = b4;
                    Iterator it2 = iVar.iterator();
                    while (it2.hasNext()) {
                        com.fyber.inneractive.sdk.measurement.h hVar2 = (com.fyber.inneractive.sdk.measurement.h) it2.next();
                        hVar2.getClass();
                        JSONObject jSONObject5 = new JSONObject();
                        try {
                            jSONObject5.put("success", String.valueOf(hVar2.b()));
                            if (!hVar2.b()) {
                                jSONObject5.put("error_reason", hVar2.a());
                            }
                        } catch (JSONException unused2) {
                            jSONObject5 = null;
                        }
                        if (jSONObject5 != null) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    try {
                        jSONObject4.put("verifications", jSONArray2);
                    } catch (Exception unused3) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "verifications", jSONArray2);
                    }
                    wVar4.f.put(jSONObject4);
                    wVar4.a((String) null);
                }
            }
            return inneractiveErrorCode;
        }
        if ("ErrorNoCompatibleMediaFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            tVar2 = t.VAST_ERROR_NO_COMPATIBLE_MEDIA_FILE;
            LinkedHashMap linkedHashMap = gVar.P;
            if (linkedHashMap != null && (keySet = linkedHashMap.keySet()) != null && keySet.size() > 0) {
                x xVar = new x();
                JSONArray jSONArray3 = new JSONArray();
                for (com.fyber.inneractive.sdk.model.vast.r rVar2 : keySet) {
                    try {
                        f fVar = (f) linkedHashMap.get(rVar2);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("url", rVar2.g);
                        jSONObject6.put(VastAttributes.BITRATE, rVar2.e);
                        jSONObject6.put("mime", TextUtils.isEmpty(rVar2.d) ? "na" : rVar2.d);
                        jSONObject6.put("delivery", rVar2.f1293a);
                        e eVar = fVar.f1247a;
                        jSONObject6.put("reason", eVar != null ? eVar.value : 0);
                        jSONObject6.put("required_value", fVar.b);
                        jSONArray3.put(jSONObject6);
                    } catch (JSONException unused4) {
                        IAlog.a("VastResponseValidator: Failed converting media file data to Extra data json!", new Object[0]);
                    }
                }
                xVar.a(jSONArray3, "media_files");
                inneractiveErrorCode = inneractiveErrorCode2;
                tVar = tVar2;
                a2 = xVar;
                if (tVar != null) {
                }
                arrayList = gVar.Q;
                if (arrayList != null) {
                    u uVar4 = u.VAST_EVENT_COMPANION_FILTERED;
                    if (rVar != null) {
                    }
                    w wVar22 = new w(gVar);
                    wVar22.c = uVar4;
                    wVar22.f1340a = inneractiveAdRequest;
                    wVar22.d = b2;
                    JSONObject jSONObject7 = new JSONObject();
                    jSONArray = new JSONArray();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                    }
                    jSONObject7.put("companion_data", jSONArray);
                    wVar22.f.put(jSONObject7);
                    wVar22.a((String) null);
                }
                com.fyber.inneractive.sdk.model.vast.b bVar22 = gVar.O;
                if (bVar22 != null) {
                }
                ArrayList arrayList22 = gVar.Q;
                if (arrayList22 != null) {
                }
                u uVar22 = u.NUMBER_OF_COMPANIONS;
                if (rVar == null) {
                }
                w wVar32 = new w(gVar);
                wVar32.c = uVar22;
                wVar32.f1340a = inneractiveAdRequest;
                wVar32.d = b3;
                JSONObject jSONObject32 = new JSONObject();
                Integer valueOf2 = Integer.valueOf(size + size2);
                jSONObject32.put("number_of_endcards", valueOf2);
                wVar32.f.put(jSONObject32);
                wVar32.a((String) null);
                if (gVar.O != null) {
                }
                return inneractiveErrorCode;
            }
        } else if ("VastErrorTooManyWrappers".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            tVar2 = t.VAST_ERROR_TOO_MANY_WRAPPERS;
            a2 = new x().a(Integer.valueOf(IAConfigManager.O.i.b), "max");
        } else if ("ErrorNoMediaFiles".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            tVar2 = t.VAST_ERROR_NO_MEDIA_FILES;
        } else if ("ErrorConfigurationMismatch".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
            tVar2 = t.INTERNAL_CONFIG_MISMATCH;
        } else {
            if (!"VastErrorUnsecure".equals(str2)) {
                tVar = null;
                inneractiveErrorCode = null;
                a2 = null;
                if (tVar != null) {
                }
                arrayList = gVar.Q;
                if (arrayList != null) {
                }
                com.fyber.inneractive.sdk.model.vast.b bVar222 = gVar.O;
                if (bVar222 != null) {
                }
                ArrayList arrayList222 = gVar.Q;
                if (arrayList222 != null) {
                }
                u uVar222 = u.NUMBER_OF_COMPANIONS;
                if (rVar == null) {
                }
                w wVar322 = new w(gVar);
                wVar322.c = uVar222;
                wVar322.f1340a = inneractiveAdRequest;
                wVar322.d = b3;
                JSONObject jSONObject322 = new JSONObject();
                Integer valueOf22 = Integer.valueOf(size + size2);
                jSONObject322.put("number_of_endcards", valueOf22);
                wVar322.f.put(jSONObject322);
                wVar322.a((String) null);
                if (gVar.O != null) {
                }
                return inneractiveErrorCode;
            }
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            tVar2 = t.VAST_ERROR_UNSECURE_URL;
        }
        t tVar32 = tVar2;
        inneractiveErrorCode = inneractiveErrorCode2;
        tVar = tVar32;
        a2 = null;
        if (tVar != null) {
        }
        arrayList = gVar.Q;
        if (arrayList != null) {
        }
        com.fyber.inneractive.sdk.model.vast.b bVar2222 = gVar.O;
        if (bVar2222 != null) {
        }
        ArrayList arrayList2222 = gVar.Q;
        if (arrayList2222 != null) {
        }
        u uVar2222 = u.NUMBER_OF_COMPANIONS;
        if (rVar == null) {
        }
        w wVar3222 = new w(gVar);
        wVar3222.c = uVar2222;
        wVar3222.f1340a = inneractiveAdRequest;
        wVar3222.d = b3;
        JSONObject jSONObject3222 = new JSONObject();
        Integer valueOf222 = Integer.valueOf(size + size2);
        jSONObject3222.put("number_of_endcards", valueOf222);
        wVar3222.f.put(jSONObject3222);
        wVar3222.a((String) null);
        if (gVar.O != null) {
        }
        return inneractiveErrorCode;
        t tVar4 = tVar2;
        inneractiveErrorCode = inneractiveErrorCode2;
        tVar = tVar4;
        if (tVar != null) {
        }
        arrayList = gVar.Q;
        if (arrayList != null) {
        }
        com.fyber.inneractive.sdk.model.vast.b bVar22222 = gVar.O;
        if (bVar22222 != null) {
        }
        ArrayList arrayList22222 = gVar.Q;
        if (arrayList22222 != null) {
        }
        u uVar22222 = u.NUMBER_OF_COMPANIONS;
        if (rVar == null) {
        }
        w wVar32222 = new w(gVar);
        wVar32222.c = uVar22222;
        wVar32222.f1340a = inneractiveAdRequest;
        wVar32222.d = b3;
        JSONObject jSONObject32222 = new JSONObject();
        Integer valueOf2222 = Integer.valueOf(size + size2);
        jSONObject32222.put("number_of_endcards", valueOf2222);
        wVar32222.f.put(jSONObject32222);
        wVar32222.a((String) null);
        if (gVar.O != null) {
        }
        return inneractiveErrorCode;
    }
}
