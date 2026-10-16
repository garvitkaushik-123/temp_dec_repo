package com.bytedance.sdk.component.MGA.eli.eli.eli.eli;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb extends Os {
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli Os;
    protected List<String> eli;

    public byte Os() {
        return (byte) 2;
    }

    public byte eli() {
        return (byte) 1;
    }

    public kb(Context context, com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        super(context);
        this.eli = new ArrayList();
        this.Os = eliVar;
        if (eliVar == null) {
            this.Os = com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli.Os();
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    protected long MGA() {
        return com.bytedance.sdk.component.MGA.eli.kb.eli.DbA();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    public String DbA() {
        return wC.kb().aGH().aGH();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int aGH() {
        Cursor cursor;
        int i = 0;
        try {
            cursor = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    i = cursor.getInt(0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        return i;
    }

    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, String str) {
        long eli = com.bytedance.sdk.component.MGA.eli.DbA.eli.eli(i, ui());
        if (eli <= 0) {
            eli = 1;
        } else if (eli > 100) {
            eli = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.eli.clear();
        Cursor eli2 = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str + " DESC limit " + eli);
        if (eli2 != null) {
            while (eli2.moveToNext()) {
                try {
                    try {
                        String string = eli2.getString(eli2.getColumnIndex("id"));
                        String string2 = eli2.getString(eli2.getColumnIndex("value"));
                        if (eli2.getInt(eli2.getColumnIndex("encrypt")) == 1) {
                            string2 = wC.kb().aqO().eli(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.eli.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.MGA.eli.aGH.eli.eli eliVar = new com.bytedance.sdk.component.MGA.eli.aGH.eli.eli(string, new JSONObject(string2));
                            eliVar.DbA(Os());
                            eliVar.eli(eli());
                            arrayList.add(eliVar);
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
                }
            }
            if (eli2 != null) {
                try {
                    eli2.close();
                    if (!this.eli.isEmpty()) {
                        eli(this.eli);
                        this.eli.clear();
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return arrayList;
    }

    protected void eli(List<String> list) {
        DbA();
        list.size();
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), "DELETE FROM " + DbA() + " WHERE " + eli("id", list, 1000, true));
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.rQ(), list.size());
        Os(list);
    }

    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA(String str) {
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar = this.Os;
        if (eliVar == null) {
            return new ArrayList();
        }
        return eli(eliVar.DbA(), str);
    }

    public void DbA(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar : list) {
            linkedList.add(eliVar.Os());
            com.bytedance.sdk.component.MGA.eli.Os.eli.aAs(eliVar);
        }
        DbA();
        linkedList.size();
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), "DELETE FROM " + DbA() + " WHERE " + eli("id", linkedList, 1000, true));
        Os(linkedList);
    }

    public void eli(int i, long j) {
        DbA(i, j);
    }

    private void DbA(int i, long j) {
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
    }

    public boolean eli(int i) {
        return this.Os != null && aGH() >= this.Os.eli();
    }

    public static String Os(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private static String eli(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String eli = eli(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(eli).append("')");
        }
        return eli(sb.toString(), str + str2 + "('')");
    }

    private static String eli(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
