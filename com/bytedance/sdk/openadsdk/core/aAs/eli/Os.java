package com.bytedance.sdk.openadsdk.core.aAs.eli;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.dV;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class Os {
    private static volatile Os DbA = null;
    public static int eli = 20;
    private final Object Os = new Object();
    private final LruCache<String, eli> aGH = new LruCache<String, eli>(eli) { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.Os.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, eli eliVar) {
            return 1;
        }
    };

    private Os() {
    }

    public static Os eli() {
        if (DbA == null) {
            synchronized (Os.class) {
                if (DbA == null) {
                    DbA = new Os();
                }
            }
        }
        return DbA;
    }

    eli eli(String str, String str2) {
        eli eliVar;
        eli eli2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.Os) {
            eliVar = this.aGH.get(str);
        }
        if (eliVar != null) {
            if (TextUtils.equals(str2, eliVar.DbA())) {
                return eliVar;
            }
            DbA(str2);
            return null;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.Os os = new com.bytedance.sdk.openadsdk.multipro.aidl.Os(com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null));
        try {
            if (os.moveToFirst()) {
                do {
                    int columnIndex = os.getColumnIndex("id");
                    int columnIndex2 = os.getColumnIndex("md5");
                    int columnIndex3 = os.getColumnIndex("url");
                    int columnIndex4 = os.getColumnIndex("data");
                    int columnIndex5 = os.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = os.getColumnIndex("rit");
                        String string = os.getString(columnIndex);
                        String string2 = os.getString(columnIndex2);
                        String string3 = os.getString(columnIndex3);
                        String string4 = os.getString(columnIndex4);
                        if (TextUtils.isEmpty(string4)) {
                            return null;
                        }
                        eli2 = new eli().eli(string).DbA(string2).aGH(string4).Os(string3).ui(columnIndex6 != -1 ? os.getString(columnIndex6) : null).eli(Long.valueOf(os.getLong(columnIndex5)));
                        synchronized (this.Os) {
                            this.aGH.put(string, eli2);
                        }
                    }
                    return null;
                } while (os.moveToNext());
                return eli2;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    void eli(eli eliVar) {
        if (eliVar == null || TextUtils.isEmpty(eliVar.eli())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.Os os = new com.bytedance.sdk.openadsdk.multipro.aidl.Os(com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", null, "id=?", new String[]{eliVar.eli()}, null, null, null));
        boolean z = os.getCount() > 0;
        try {
            os.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", eliVar.eli());
            contentValues.put("md5", eliVar.DbA());
            contentValues.put("url", eliVar.Os());
            contentValues.put("data", eliVar.ui());
            contentValues.put("rit", eliVar.MGA());
            contentValues.put("update_time", eliVar.aGH());
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", contentValues, "id=?", new String[]{eliVar.eli()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", contentValues);
            }
            synchronized (this.Os) {
                this.aGH.put(eliVar.eli(), eliVar);
            }
        } catch (Throwable unused) {
        }
    }

    List<eli> DbA() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.sdk.openadsdk.multipro.aidl.Os os = new com.bytedance.sdk.openadsdk.multipro.aidl.Os(com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", null, null, null, null, null, null));
        try {
            if (os.moveToFirst()) {
                do {
                    int columnIndex = os.getColumnIndex("id");
                    int columnIndex2 = os.getColumnIndex("md5");
                    int columnIndex3 = os.getColumnIndex("url");
                    int columnIndex4 = os.getColumnIndex("data");
                    int columnIndex5 = os.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = os.getColumnIndex("rit");
                        String string = columnIndex6 != -1 ? os.getString(columnIndex6) : null;
                        String string2 = os.getString(columnIndex);
                        String string3 = os.getString(columnIndex2);
                        String string4 = os.getString(columnIndex3);
                        eli eli2 = new eli().eli(string2).DbA(string3).Os(string4).aGH(os.getString(columnIndex4)).ui(string).eli(Long.valueOf(os.getLong(columnIndex5)));
                        arrayList.add(eli2);
                        synchronized (this.Os) {
                            this.aGH.put(string2, eli2);
                        }
                    }
                } while (os.moveToNext());
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                Xb.eli("UGTmplDbHelper", "getUgenTemplate error", th);
                return arrayList;
            } finally {
                os.close();
            }
        }
    }

    Set<eli> eli(String str) {
        eli eliVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        com.bytedance.sdk.openadsdk.multipro.aidl.Os os = new com.bytedance.sdk.openadsdk.multipro.aidl.Os(com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null));
        try {
            if (os.moveToFirst()) {
                do {
                    int columnIndex = os.getColumnIndex("id");
                    if (columnIndex != -1) {
                        String string = os.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.Os) {
                                eliVar = this.aGH.get(string);
                            }
                            if (eliVar != null) {
                                hashSet.add(eliVar);
                            } else {
                                eli eliVar2 = new eli();
                                int columnIndex2 = os.getColumnIndex("data");
                                if (columnIndex2 != -1) {
                                    String string2 = os.getString(columnIndex2);
                                    if (!TextUtils.isEmpty(string2)) {
                                        eliVar2.aGH(string2);
                                        eliVar2.eli(string);
                                        eliVar2.ui(str);
                                        int columnIndex3 = os.getColumnIndex("md5");
                                        int columnIndex4 = os.getColumnIndex("url");
                                        int columnIndex5 = os.getColumnIndex("update_time");
                                        if (columnIndex3 != -1) {
                                            eliVar2.DbA(os.getString(columnIndex3));
                                        }
                                        if (columnIndex4 != -1) {
                                            eliVar2.Os(os.getString(columnIndex4));
                                        }
                                        if (columnIndex5 != -1) {
                                            eliVar2.eli(Long.valueOf(os.getLong(columnIndex5)));
                                        }
                                        hashSet.add(eliVar2);
                                        synchronized (this.Os) {
                                            this.aGH.put(string, eliVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (os.moveToNext());
            }
            return hashSet;
        } catch (Throwable th) {
            try {
                Xb.eli("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                return hashSet;
            } finally {
                os.close();
            }
        }
    }

    void eli(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                DbA(str);
                com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }

    private void DbA(String str) {
        if (!TextUtils.isEmpty(str) && this.aGH.size() > 0) {
            synchronized (this.Os) {
                this.aGH.remove(str);
            }
        }
    }

    public static String Os() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    public static String aGH() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }
}
