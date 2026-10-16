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
public class eli extends Os {
    private final Context Os;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aGH;
    protected List<String> eli;

    public byte Os() {
        return (byte) 2;
    }

    public byte aGH() {
        return (byte) 0;
    }

    public eli(Context context, com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        super(context);
        this.eli = new ArrayList();
        this.Os = context;
        this.aGH = eliVar;
        if (eliVar == null) {
            this.aGH = com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli.Os();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r1 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int eli() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), new String[]{"count(1)"}, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                i = cursor.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        return i;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    public String DbA() {
        com.bytedance.sdk.component.MGA.eli.eli.ui aGH = wC.kb().aGH();
        if (aGH != null) {
            return aGH.DbA();
        }
        return null;
    }

    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, String str) {
        String str2;
        String[] strArr;
        int i2;
        int i3;
        String str3;
        byte b;
        Cursor eli;
        int i4;
        long eli2 = com.bytedance.sdk.component.MGA.eli.DbA.eli.eli(i, ui());
        DbA();
        if (eli2 <= 0) {
            eli2 = 1;
        } else if (eli2 > 100) {
            eli2 = 100;
        }
        String str4 = str + " DESC limit " + eli2;
        ArrayList arrayList = new ArrayList();
        this.eli.clear();
        long dV = wC.kb().dV();
        if (dV > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - dV)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        if (com.bytedance.sdk.component.MGA.eli.Os.eli.aGH() && aGH() == 3) {
            i2 = 0;
            i3 = 1;
            str3 = "id";
            b = 3;
            eli = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), new String[]{"id", "value", "encrypt", "channel"}, str2, strArr, null, null, str4);
        } else {
            i2 = 0;
            i3 = 1;
            str3 = "id";
            b = 3;
            eli = com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), new String[]{str3, "value", "encrypt"}, str2, strArr, null, null, str4);
        }
        Cursor cursor = eli;
        if (cursor != null) {
            try {
                com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
                while (cursor.moveToNext()) {
                    try {
                        String string = cursor.getString(cursor.getColumnIndex(str3));
                        String string2 = cursor.getString(cursor.getColumnIndex("value"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("encrypt"));
                        int i6 = (com.bytedance.sdk.component.MGA.eli.Os.eli.aGH() && aGH() == b) ? cursor.getInt(cursor.getColumnIndex("channel")) : i2;
                        i4 = i3;
                        if (i5 == i4) {
                            try {
                                string2 = aqO.eli(string2);
                            } catch (Throwable th) {
                                th = th;
                                th.getMessage();
                                i3 = i4;
                            }
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.eli.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            com.bytedance.sdk.component.MGA.eli.aGH.eli.eli eliVar = new com.bytedance.sdk.component.MGA.eli.aGH.eli.eli(string, jSONObject);
                            eliVar.eli(aGH());
                            eliVar.DbA(Os());
                            if (com.bytedance.sdk.component.MGA.eli.Os.eli.aGH() && aGH() == b) {
                                eliVar.eli(i6);
                            }
                            com.bytedance.sdk.component.MGA.eli.Os.eli.eli(jSONObject, eliVar);
                            arrayList.add(eliVar);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = i3;
                    }
                    i3 = i4;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                        if (!this.eli.isEmpty()) {
                            eli(this.eli);
                            this.eli.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th3) {
                if (cursor != null) {
                    try {
                        cursor.close();
                        if (!this.eli.isEmpty()) {
                            eli(this.eli);
                            this.eli.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th3;
            }
        }
        DbA();
        arrayList.size();
        return arrayList;
    }

    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(String str) {
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar = this.aGH;
        if (eliVar == null) {
            return new ArrayList();
        }
        return eli(eliVar.DbA(), str);
    }

    protected void eli(List<String> list) {
        DbA();
        list.size();
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), "DELETE FROM " + DbA() + " WHERE " + eli("id", list, 1000, true));
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.rQ(), list.size());
        Os(list);
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
        if (j > 0 || i > 0) {
            com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i)});
            DbA();
        }
    }

    public boolean eli(int i) {
        if (this.aGH == null) {
            return false;
        }
        int eli = eli();
        int eli2 = this.aGH.eli();
        DbA();
        return (com.bytedance.sdk.component.MGA.eli.Os.eli.Os() && (i == 1 || i == 2)) ? eli > 0 : eli >= eli2;
    }

    public static String DbA(String str) {
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
