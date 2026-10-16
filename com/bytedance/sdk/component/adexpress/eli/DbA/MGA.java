package com.bytedance.sdk.component.adexpress.eli.DbA;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class MGA {
    private static volatile MGA DbA = null;
    public static int eli = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.eli.Os.Os> ui;
    private final Object aGH = new Object();
    private AtomicBoolean MGA = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.eli.Os.DbA> kb = new LruCache<String, com.bytedance.sdk.component.adexpress.eli.Os.DbA>(eli) { // from class: com.bytedance.sdk.component.adexpress.eli.DbA.MGA.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA) {
            return 1;
        }
    };
    private Set<String> Os = Collections.synchronizedSet(new HashSet());

    public static void eli(int i) {
        eli = i;
    }

    public static MGA eli() {
        if (DbA == null) {
            synchronized (MGA.class) {
                if (DbA == null) {
                    DbA = new MGA();
                }
            }
        }
        return DbA;
    }

    private MGA() {
    }

    com.bytedance.sdk.component.adexpress.eli.Os.DbA eli(String str) {
        com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA;
        com.bytedance.sdk.component.adexpress.eli.Os.DbA eli2;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA() == null) {
            return null;
        }
        synchronized (this.aGH) {
            dbA = this.kb.get(String.valueOf(str));
        }
        if (dbA != null) {
            return dbA;
        }
        Cursor eli3 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (eli3 != null) {
            try {
                if (eli3.moveToFirst()) {
                    do {
                        String string = eli3.getString(eli3.getColumnIndex("rit"));
                        String string2 = eli3.getString(eli3.getColumnIndex("id"));
                        String string3 = eli3.getString(eli3.getColumnIndex("md5"));
                        String string4 = eli3.getString(eli3.getColumnIndex("url"));
                        String string5 = eli3.getString(eli3.getColumnIndex("data"));
                        eli2 = new com.bytedance.sdk.component.adexpress.eli.Os.DbA().eli(string).DbA(string2).Os(string3).aGH(string4).ui(string5).MGA(eli3.getString(eli3.getColumnIndex("version"))).eli(Long.valueOf(eli3.getLong(eli3.getColumnIndex("update_time"))));
                        synchronized (this.aGH) {
                            this.kb.put(string2, eli2);
                        }
                        this.Os.add(string2);
                    } while (eli3.moveToNext());
                    eli3.close();
                    return eli2;
                }
            } catch (Throwable unused) {
            }
            eli3.close();
        }
        return null;
    }

    Set<String> DbA(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA() != null) {
            HashSet hashSet = new HashSet();
            Cursor eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            try {
                if (eli2 != null) {
                    try {
                        if (eli2.moveToFirst()) {
                            do {
                                hashSet.add(eli2.getString(eli2.getColumnIndex("id")));
                            } while (eli2.moveToNext());
                            return hashSet;
                        }
                    } catch (Exception e) {
                        Log.e("TmplDbHelper", "", e);
                    }
                }
            } finally {
                eli2.close();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    List<com.bytedance.sdk.component.adexpress.eli.Os.DbA> DbA() {
        if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA() == null) {
            return null;
        }
        boolean z = this.MGA.get();
        this.MGA.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", null, null, null, null, null, null);
        if (eli2 != null) {
            while (eli2.moveToNext()) {
                try {
                    String string = eli2.getString(eli2.getColumnIndex("rit"));
                    String string2 = eli2.getString(eli2.getColumnIndex("id"));
                    String string3 = eli2.getString(eli2.getColumnIndex("md5"));
                    String string4 = eli2.getString(eli2.getColumnIndex("url"));
                    String string5 = eli2.getString(eli2.getColumnIndex("data"));
                    String string6 = eli2.getString(eli2.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.eli.Os.DbA().eli(string).DbA(string2).Os(string3).aGH(string4).ui(string5).MGA(string6).eli(Long.valueOf(eli2.getLong(eli2.getColumnIndex("update_time")))));
                    synchronized (this.aGH) {
                        this.kb.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.Os.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA() != null) {
                        if (this.ui == null) {
                            this.ui = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.ui.contains(string2)) {
                            this.ui.put(string2, new com.bytedance.sdk.component.adexpress.eli.Os.Os(string, string2, string3));
                        }
                    }
                } catch (Throwable unused) {
                    if (eli2 != null) {
                        eli2.close();
                    }
                }
            }
            if (eli2 != null) {
                eli2.close();
                return arrayList;
            }
        }
        return arrayList;
    }

    void eli(com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA, boolean z) {
        if (dbA == null || com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA() == null || TextUtils.isEmpty(dbA.DbA())) {
            return;
        }
        Cursor eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", null, "id=?", new String[]{dbA.DbA()}, null, null, null);
        boolean z2 = eli2 != null && eli2.getCount() > 0;
        if (eli2 != null) {
            try {
                r3 = eli2.moveToFirst() ? eli2.getString(eli2.getColumnIndex("rit")) : null;
                eli2.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", dbA.eli());
        contentValues.put("id", dbA.DbA());
        contentValues.put("md5", dbA.Os());
        contentValues.put("url", dbA.aGH());
        contentValues.put("data", dbA.ui());
        contentValues.put("version", dbA.MGA());
        contentValues.put("update_time", dbA.kb());
        if (z2) {
            com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", contentValues, "id=?", new String[]{dbA.DbA()});
        } else {
            com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", contentValues);
        }
        synchronized (this.aGH) {
            this.kb.put(dbA.DbA(), dbA);
        }
        this.Os.add(dbA.DbA());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA() == null) {
                return;
            }
            if (this.ui == null) {
                this.ui = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.eli.Os.Os os = new com.bytedance.sdk.component.adexpress.eli.Os.Os(dbA.eli(), dbA.DbA(), dbA.Os());
            this.ui.put(dbA.DbA(), os);
            if (r3 != null) {
                com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA();
                os.DbA();
            }
            com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA();
            dbA.eli();
        } catch (Throwable unused2) {
        }
    }

    void eli(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                aGH(strArr[i]);
                com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().DbA().eli("template_diff_new", "id=?", new String[]{strArr[i]});
                Os(strArr[i]);
            }
        }
    }

    void Os(String str) {
        com.bytedance.sdk.component.adexpress.eli.Os.Os os;
        try {
            if (this.ui != null && !this.ui.isEmpty() && (os = this.ui.get(str)) != null) {
                if (!TextUtils.isEmpty(os.eli()) && com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA() != null) {
                    com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().MGA();
                }
                this.ui.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    private void aGH(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.eli.Os.DbA> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.kb) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.aGH) {
            this.kb.remove(str);
        }
    }

    public static String Os() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }
}
