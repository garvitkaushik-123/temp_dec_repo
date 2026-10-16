package com.bytedance.adsdk.eli.DbA;

import com.bytedance.adsdk.eli.DbA.Os.eli.DbA;
import com.bytedance.adsdk.eli.DbA.Os.eli.FC;
import com.bytedance.adsdk.eli.DbA.Os.eli.MGA;
import com.bytedance.adsdk.eli.DbA.Os.eli.Os;
import com.bytedance.adsdk.eli.DbA.Os.eli.aAs;
import com.bytedance.adsdk.eli.DbA.Os.eli.aGH;
import com.bytedance.adsdk.eli.DbA.Os.eli.kb;
import com.bytedance.adsdk.eli.DbA.Os.eli.ui;
import com.bytedance.adsdk.eli.DbA.Os.eli.wC;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private static final com.bytedance.adsdk.eli.DbA.Os.eli eli;
    private final com.bytedance.adsdk.eli.DbA.Os.eli DbA;
    private com.bytedance.adsdk.eli.DbA.DbA.eli Os;
    private Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> aGH = new LinkedList();
    private String ui;

    static {
        int i = 8;
        MGA[] mgaArr = {new aAs(), new aGH(), new FC(), new DbA(), new ui(), new com.bytedance.adsdk.eli.DbA.Os.eli.eli(), new kb(), new Os(), new wC()};
        final com.bytedance.adsdk.eli.DbA.Os.eli eliVar = new com.bytedance.adsdk.eli.DbA.Os.eli() { // from class: com.bytedance.adsdk.eli.DbA.eli.1
            @Override // com.bytedance.adsdk.eli.DbA.Os.eli
            public int eli(String str, int i2, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final MGA mga = mgaArr[i];
            i--;
            eliVar = new com.bytedance.adsdk.eli.DbA.Os.eli() { // from class: com.bytedance.adsdk.eli.DbA.eli.2
                @Override // com.bytedance.adsdk.eli.DbA.Os.eli
                public int eli(String str, int i2, Deque<com.bytedance.adsdk.eli.DbA.DbA.eli> deque) {
                    return MGA.this.eli(str, i2, deque, eliVar);
                }
            };
        }
        eli = eliVar;
    }

    private eli(String str, com.bytedance.adsdk.eli.DbA.Os.eli eliVar) {
        this.DbA = eliVar;
        this.ui = str;
        try {
            eli();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.eli.eli.DbA(str, e);
        }
    }

    public static eli eli(String str) {
        return new eli(str, eli);
    }

    private void eli() {
        int length = this.ui.length();
        int i = 0;
        while (i < length) {
            int eli2 = this.DbA.eli(this.ui, i, this.aGH);
            if (eli2 == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.ui.substring(0, i));
            }
            i = eli2;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.eli.DbA.DbA.eli pollFirst = this.aGH.pollFirst();
            if (pollFirst != null) {
                arrayList.add(0, pollFirst);
            } else {
                this.Os = com.bytedance.adsdk.eli.DbA.ui.DbA.eli(arrayList, this.ui, i);
                this.aGH = null;
                return;
            }
        }
    }

    public <T> T eli(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("default_key", jSONObject);
        return (T) eli(hashMap);
    }

    public <T> T eli(Map<String, JSONObject> map) {
        return (T) this.Os.eli(map);
    }
}
