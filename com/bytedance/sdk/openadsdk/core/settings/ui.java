package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.component.utils.Xb;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ui {
    public static final DbA<JSONObject> eli = new DbA<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ui.1
        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public JSONObject DbA(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                Xb.eli("ISettingsDataRepository", "", e);
                return null;
            }
        }
    };
    public static final DbA<Set<String>> DbA = new DbA<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ui.2
        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Set<String> DbA(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                Xb.eli("ISettingsDataRepository", "", e);
            }
            return hashSet;
        }
    };

    public interface DbA<T> {
        T DbA(String str);
    }

    public interface eli {
        eli eli(String str);

        eli eli(String str, float f);

        eli eli(String str, int i);

        eli eli(String str, long j);

        eli eli(String str, String str2);

        eli eli(String str, boolean z);

        void eli();
    }

    void eli(JSONObject jSONObject);
}
