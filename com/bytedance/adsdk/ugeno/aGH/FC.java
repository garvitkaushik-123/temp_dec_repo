package com.bytedance.adsdk.ugeno.aGH;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.aGH.DbA.eli;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.aGH.aGH.Os;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC implements du {
    private Map<String, List<com.bytedance.adsdk.ugeno.aGH.aGH.Os>> DbA;
    private boolean MGA;
    private com.bytedance.adsdk.ugeno.DbA.Os Os;
    private com.bytedance.adsdk.ugeno.core.ui aGH;
    private eli eli;
    private boolean ui;

    public FC(com.bytedance.adsdk.ugeno.DbA.Os os, eli eliVar) {
        this.Os = os;
        this.eli = eliVar;
        if (eliVar != null) {
            this.DbA = eliVar.eli;
        }
    }

    public void eli(com.bytedance.adsdk.ugeno.core.ui uiVar) {
        this.aGH = uiVar;
    }

    public void eli() {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli2 = eli("shake");
        if (eli2 == null || eli2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : eli2) {
            if (os != null) {
                os.eli(this);
                os.eli(new Object[0]);
            }
        }
    }

    public void DbA() {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli2 = eli("twist");
        if (eli2 == null || eli2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : eli2) {
            if (os != null) {
                os.eli(this);
                os.eli(new Object[0]);
            }
        }
    }

    public void Os() {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> value;
        eli eliVar = this.eli;
        if (eliVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.aGH.aGH.Os>> entry : eliVar.eli.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : value) {
                    if (os instanceof com.bytedance.adsdk.ugeno.aGH.aGH.aGH) {
                        os.eli(this);
                        os.eli(new Object[0]);
                    }
                }
            }
        }
    }

    public void aGH() {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli2 = eli("animateState");
        if (eli2 == null || eli2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : eli2) {
            if (os != null) {
                os.eli(this);
                os.eli(new Object[0]);
            }
        }
    }

    public void ui() {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli2 = eli("timer");
        if (eli2 == null || eli2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : eli2) {
            if (os != null) {
                os.eli(this);
                os.eli(new Object[0]);
            }
        }
    }

    public boolean eli(MotionEvent motionEvent) {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli2 = eli("touchStart");
        if (eli2 != null && !eli2.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : eli2) {
                if (os instanceof com.bytedance.adsdk.ugeno.aGH.aGH.nlS) {
                    os.eli(this);
                    os.eli(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli3 = eli("touchEnd");
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli4 = eli("tap");
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli5 = eli("slide");
        if (eli2 != null && !eli2.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os2 : eli3) {
                if (os2 instanceof com.bytedance.adsdk.ugeno.aGH.aGH.du) {
                    os2.eli(this);
                    this.MGA = os2.eli(motionEvent);
                }
            }
        }
        if ((eli4 == null || eli4.isEmpty()) && (eli5 == null || eli5.isEmpty())) {
            return this.MGA;
        }
        if (this.MGA && motionEvent.getAction() == 1) {
            return true;
        }
        if (eli4 != null && !eli4.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os3 : eli4) {
                if (os3 instanceof com.bytedance.adsdk.ugeno.aGH.aGH.FC) {
                    os3.eli(this);
                    this.ui = os3.eli(motionEvent);
                }
            }
        }
        if (this.ui) {
            return true;
        }
        if (eli5 != null && !eli5.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os4 : eli5) {
                if (os4 instanceof com.bytedance.adsdk.ugeno.aGH.aGH.ui) {
                    os4.eli(this);
                    return os4.eli(motionEvent);
                }
            }
        }
        return this.ui;
    }

    private void eli(String str, List<MGA.eli> list) {
        com.bytedance.adsdk.ugeno.aGH.DbA.eli eli2;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (MGA.eli eliVar : list) {
            if (eliVar != null && (eli2 = eli.C0122eli.eli(this.Os, str, eliVar)) != null) {
                eli2.eli();
                eli2.DbA();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> eli(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.aGH.aGH.Os>> map = this.DbA;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.DbA.get(str);
    }

    public com.bytedance.adsdk.ugeno.aGH.aGH.Os DbA(String str) {
        Map<String, com.bytedance.adsdk.ugeno.aGH.aGH.Os> map;
        if (this.eli == null || TextUtils.isEmpty(str) || (map = this.eli.DbA) == null) {
            return null;
        }
        return map.get(str);
    }

    public void eli(String str, Object... objArr) {
        com.bytedance.adsdk.ugeno.aGH.aGH.Os DbA = DbA(str);
        if (DbA != null) {
            DbA.eli(this);
            DbA.eli(objArr);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.du
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, List<MGA.eli> list) {
        com.bytedance.adsdk.ugeno.core.ui uiVar = this.aGH;
        if (uiVar != null) {
            uiVar.eli(os, str, list);
        }
        eli(str, list);
    }

    public static FC eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str) {
        com.bytedance.adsdk.ugeno.aGH.aGH.Os eli2;
        if (os != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                eli eliVar = new eli(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && (eli2 = Os.eli.eli(os.du().getContext(), os, optJSONObject, os.nlS())) != null) {
                        if (eliVar.eli.containsKey(eli2.aGH())) {
                            List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> list = eliVar.eli.get(eli2.aGH());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(eli2);
                                eliVar.eli.put(eli2.aGH(), arrayList);
                            } else {
                                list.add(eli2);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(eli2);
                            eliVar.eli.put(eli2.aGH(), arrayList2);
                        }
                        eliVar.DbA.put(eli2.ui(), eli2);
                    }
                }
                return new FC(os, eliVar);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static class eli {
        public Map<String, com.bytedance.adsdk.ugeno.aGH.aGH.Os> DbA;
        public Map<String, List<com.bytedance.adsdk.ugeno.aGH.aGH.Os>> eli;

        public eli(Map<String, List<com.bytedance.adsdk.ugeno.aGH.aGH.Os>> map, Map<String, com.bytedance.adsdk.ugeno.aGH.aGH.Os> map2) {
            this.eli = map;
            this.DbA = map2;
        }
    }
}
