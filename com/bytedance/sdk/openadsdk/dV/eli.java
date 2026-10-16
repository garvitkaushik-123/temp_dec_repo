package com.bytedance.sdk.openadsdk.dV;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eli {
    private static Context aGH;
    private static final long ui = System.currentTimeMillis();
    private com.bytedance.sdk.openadsdk.dV.Os.eli DbA;
    private Boolean Os;
    private DbA eli;
    private int MGA = 0;
    private final ArrayList<aGH> kb = new ArrayList<>();
    private Runnable wC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dV.eli.2
        @Override // java.lang.Runnable
        public void run() {
            eli eliVar = eli.this;
            eliVar.Os = Boolean.valueOf(eliVar.eli.isMonitorOpen());
            if (eli.this.Os.booleanValue()) {
                eli eliVar2 = eli.this;
                eliVar2.eli(eliVar2.kb);
                eli.this.kb.clear();
            }
        }
    };
    private Runnable FC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dV.eli.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            String str3;
            ArrayList arrayList;
            AnonymousClass4 anonymousClass4 = this;
            String str4 = "is_init";
            String str5 = "mediation";
            try {
                SQLiteDatabase DbA = com.bytedance.sdk.openadsdk.dV.eli.eli.DbA();
                if (DbA != null) {
                    String[] strArr = new String[13];
                    try {
                        strArr[0] = "_id";
                        strArr[1] = BidTokenRepositoryKt.SDK_VERSION;
                        strArr[2] = "scene";
                        strArr[3] = "start_count";
                        strArr[4] = "success_count";
                        strArr[5] = "fail_count";
                        strArr[6] = "rit";
                        strArr[7] = "tag";
                        strArr[8] = "label";
                        strArr[9] = "timestamp";
                        strArr[10] = "mediation";
                        strArr[11] = "is_init";
                        strArr[12] = "extra";
                        String[] strArr2 = {String.valueOf(eli.ui)};
                        int max = Math.max(10, eli.this.eli.getOnceLogCount());
                        if (max > 100) {
                            max = 10;
                        }
                        Cursor query = DbA.query("monitor_table", strArr, "timestamp <= ?", strArr2, null, null, null, String.valueOf(max));
                        if (query != null) {
                            ArrayList arrayList2 = new ArrayList();
                            int i = max;
                            ArrayList arrayList3 = new ArrayList();
                            while (query.moveToNext()) {
                                try {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    if (query.getColumnIndex("_id") >= 0) {
                                        arrayList = arrayList2;
                                        str2 = str4;
                                        str3 = str5;
                                        long j = query.getLong(query.getColumnIndex("_id"));
                                        eliVar.eli(j);
                                        arrayList3.add(String.valueOf(j));
                                    } else {
                                        str2 = str4;
                                        str3 = str5;
                                        arrayList = arrayList2;
                                    }
                                    if (query.getColumnIndex(BidTokenRepositoryKt.SDK_VERSION) >= 0) {
                                        eliVar.eli(query.getString(query.getColumnIndex(BidTokenRepositoryKt.SDK_VERSION)));
                                    }
                                    if (query.getColumnIndex("scene") >= 0) {
                                        eliVar.DbA(query.getString(query.getColumnIndex("scene")));
                                    }
                                    if (query.getColumnIndex("start_count") >= 0) {
                                        eliVar.eli(query.getInt(query.getColumnIndex("start_count")));
                                    }
                                    if (query.getColumnIndex("success_count") >= 0) {
                                        eliVar.DbA(query.getInt(query.getColumnIndex("success_count")));
                                    }
                                    if (query.getColumnIndex("fail_count") >= 0) {
                                        eliVar.Os(query.getInt(query.getColumnIndex("fail_count")));
                                    }
                                    if (query.getColumnIndex("rit") >= 0) {
                                        eliVar.Os(query.getString(query.getColumnIndex("rit")));
                                    }
                                    if (query.getColumnIndex("tag") >= 0) {
                                        eliVar.aGH(query.getString(query.getColumnIndex("tag")));
                                    }
                                    if (query.getColumnIndex("label") >= 0) {
                                        eliVar.ui(query.getString(query.getColumnIndex("label")));
                                    }
                                    String str6 = str3;
                                    if (query.getColumnIndex(str6) >= 0) {
                                        eliVar.MGA(query.getString(query.getColumnIndex(str6)));
                                    }
                                    String str7 = str2;
                                    if (query.getColumnIndex(str7) >= 0) {
                                        eliVar.aGH(query.getInt(query.getColumnIndex(str7)));
                                    }
                                    if (query.getColumnIndex("extra") >= 0) {
                                        eliVar.kb(query.getString(query.getColumnIndex("extra")));
                                    }
                                    arrayList2 = arrayList;
                                    arrayList2.add(eliVar);
                                    str5 = str6;
                                    str4 = str7;
                                    anonymousClass4 = this;
                                } catch (Throwable th) {
                                    th = th;
                                    str = "BusMonitorCenter";
                                    Log.e(str, th.getMessage());
                                }
                            }
                            query.close();
                            str = "BusMonitorCenter";
                            try {
                                Log.i(str, "exec upload ...");
                                if (arrayList2.isEmpty()) {
                                    return;
                                }
                                try {
                                    eli.this.eli.onMonitorUpload(arrayList2);
                                    SQLiteDatabase eli = com.bytedance.sdk.openadsdk.dV.eli.eli.eli();
                                    if (eli != null && eli.isOpen()) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("_id IN (");
                                        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                                            sb.append("?");
                                            if (i2 < arrayList3.size() - 1) {
                                                sb.append(",");
                                            }
                                        }
                                        sb.append(")");
                                        eli.delete("monitor_table", sb.toString(), (String[]) arrayList3.toArray(new String[0]));
                                        if (eli.this.DbA != null) {
                                            eli.this.DbA.eli(eli.ui);
                                        }
                                    }
                                    if (arrayList2.size() < i || eli.this.MGA > 1000) {
                                        return;
                                    }
                                    eli.this.eli(false);
                                } catch (Throwable th2) {
                                    th = th2;
                                    Log.e(str, th.getMessage());
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                str = "BusMonitorCenter";
            }
        }
    };

    static /* synthetic */ int aGH(eli eliVar) {
        int i = eliVar.MGA;
        eliVar.MGA = i + 1;
        return i;
    }

    private eli(DbA dbA) {
        try {
            this.eli = new BusMonitorDependWrapper(dbA);
            this.DbA = new com.bytedance.sdk.openadsdk.dV.Os.eli(dbA.getContext());
            aGH = dbA.getContext();
        } catch (Throwable th) {
            Log.e("BusMonitorCenter", th.getMessage());
        }
    }

    public static eli eli(DbA dbA) {
        return new eli(dbA);
    }

    public static Context eli() {
        Context context = aGH;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public void eli(final aGH agh) {
        if (agh == null || !Os()) {
            return;
        }
        this.eli.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dV.eli.1
            @Override // java.lang.Runnable
            public void run() {
                eli eliVar = eli.this;
                eliVar.Os = Boolean.valueOf(eliVar.eli.isMonitorOpen());
                if (eli.this.Os.booleanValue()) {
                    eli.this.kb.add(agh);
                    if (eli.this.kb.size() >= 10) {
                        eli eliVar2 = eli.this;
                        eliVar2.eli(eliVar2.kb);
                        eli.this.kb.clear();
                    }
                }
            }
        });
        this.eli.getHandler().removeCallbacks(this.wC);
        this.eli.getHandler().postDelayed(this.wC, 5000L);
    }

    private boolean Os() {
        if (this.Os == null) {
            DbA dbA = this.eli;
            return (dbA == null || dbA.getContext() == null || this.eli.getHandler() == null) ? false : true;
        }
        DbA dbA2 = this.eli;
        return (dbA2 == null || dbA2.getContext() == null || !this.eli.isMonitorOpen() || this.eli.getHandler() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0230 A[Catch: all -> 0x0234, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0234, blocks: (B:46:0x0230, B:6:0x0252), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0252 A[Catch: all -> 0x0234, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0234, blocks: (B:46:0x0230, B:6:0x0252), top: B:2:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(List<aGH> list) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        int i;
        String str2;
        com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        String str3;
        SQLiteDatabase sQLiteDatabase3;
        List<aGH> list2 = list;
        String str4 = "mediation";
        String str5 = "label";
        try {
            if (list2 != null) {
                try {
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = null;
                }
                if (!list2.isEmpty()) {
                    SQLiteDatabase eli = com.bytedance.sdk.openadsdk.dV.eli.eli.eli();
                    if (eli != null) {
                        try {
                            eli.beginTransaction();
                            int i2 = 0;
                            while (i2 < list2.size()) {
                                aGH agh = list2.get(i2);
                                if (agh == null || (generatorModel = agh.generatorModel()) == null) {
                                    str = str5;
                                    i = i2;
                                    str2 = str4;
                                } else {
                                    i = i2;
                                    Cursor query = eli.query("monitor_table", new String[]{"_id", BidTokenRepositoryKt.SDK_VERSION, "scene", "start_count", "success_count", "fail_count", "rit", "tag", str5, "timestamp", str4, "is_init", "extra"}, new StringBuilder("sdk_version = ? AND scene = ? AND rit = ? AND tag = ? AND label = ? AND mediation = ? AND is_init = ? AND extra = ?").toString(), new String[]{generatorModel.DbA(), generatorModel.Os(), generatorModel.kb(), generatorModel.wC(), generatorModel.FC(), generatorModel.du(), String.valueOf(generatorModel.nlS()), generatorModel.NU()}, null, null, null);
                                    if (query != null) {
                                        try {
                                            if (query.moveToNext()) {
                                                int columnIndex = query.getColumnIndex("_id");
                                                if (columnIndex >= 0) {
                                                    sQLiteDatabase2 = eli;
                                                    try {
                                                        generatorModel.eli(query.getLong(columnIndex));
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        sQLiteDatabase = sQLiteDatabase2;
                                                        try {
                                                            Log.e("BusMonitorCenter", th.getMessage());
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                        } finally {
                                                        }
                                                    }
                                                } else {
                                                    sQLiteDatabase2 = eli;
                                                }
                                                int columnIndex2 = query.getColumnIndex("start_count");
                                                if (columnIndex2 >= 0) {
                                                    generatorModel.eli(query.getInt(columnIndex2) + generatorModel.aGH());
                                                }
                                                int columnIndex3 = query.getColumnIndex("success_count");
                                                if (columnIndex3 >= 0) {
                                                    generatorModel.DbA(query.getInt(columnIndex3) + generatorModel.ui());
                                                }
                                                int columnIndex4 = query.getColumnIndex("fail_count");
                                                if (columnIndex4 >= 0) {
                                                    generatorModel.Os(query.getInt(columnIndex4) + generatorModel.MGA());
                                                }
                                                int columnIndex5 = query.getColumnIndex("timestamp");
                                                if (columnIndex5 >= 0) {
                                                    cursor = query;
                                                    str3 = str4;
                                                    generatorModel.DbA(Math.min(query.getLong(columnIndex5), generatorModel.aAs()));
                                                } else {
                                                    cursor = query;
                                                    str3 = str4;
                                                }
                                            } else {
                                                cursor = query;
                                                str3 = str4;
                                                sQLiteDatabase2 = eli;
                                            }
                                            cursor.close();
                                        } catch (Throwable th3) {
                                            th = th3;
                                            sQLiteDatabase2 = eli;
                                        }
                                    } else {
                                        str3 = str4;
                                        sQLiteDatabase2 = eli;
                                    }
                                    try {
                                        ContentValues contentValues = new ContentValues();
                                        if (generatorModel.eli() > 0) {
                                            contentValues.put("_id", Long.valueOf(generatorModel.eli()));
                                        }
                                        contentValues.put(BidTokenRepositoryKt.SDK_VERSION, generatorModel.DbA());
                                        contentValues.put("scene", generatorModel.Os());
                                        contentValues.put("start_count", Integer.valueOf(generatorModel.aGH()));
                                        contentValues.put("success_count", Integer.valueOf(generatorModel.ui()));
                                        contentValues.put("fail_count", Integer.valueOf(generatorModel.MGA()));
                                        contentValues.put("rit", generatorModel.kb());
                                        contentValues.put("tag", generatorModel.wC());
                                        contentValues.put(str5, generatorModel.FC());
                                        contentValues.put("timestamp", Long.valueOf(generatorModel.aAs()));
                                        str2 = str3;
                                        contentValues.put(str2, generatorModel.du());
                                        contentValues.put("is_init", Integer.valueOf(generatorModel.nlS()));
                                        contentValues.put("extra", generatorModel.NU());
                                        eli = sQLiteDatabase2;
                                        str = str5;
                                        eli.insertWithOnConflict("monitor_table", null, contentValues, 5);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        eli = sQLiteDatabase2;
                                        sQLiteDatabase = eli;
                                        Log.e("BusMonitorCenter", th.getMessage());
                                        if (sQLiteDatabase == null) {
                                            sQLiteDatabase.endTransaction();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str4 = str2;
                                str5 = str;
                                i2 = i + 1;
                                list2 = list;
                            }
                            Log.i("BusMonitorCenter", "exec save size = " + list.size());
                            eli.setTransactionSuccessful();
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    sQLiteDatabase3 = eli;
                    if (sQLiteDatabase3 == null) {
                        sQLiteDatabase3.endTransaction();
                        return;
                    }
                    return;
                }
            }
            sQLiteDatabase3 = null;
            if (sQLiteDatabase3 == null) {
            }
        } catch (Throwable th6) {
            Log.e("BusMonitorCenter", th6.getMessage());
        }
    }

    public void eli(final boolean z) {
        DbA dbA = this.eli;
        if (dbA == null || dbA.getHandler() == null || this.eli.getContext() == null || this.DbA == null || !this.eli.isMonitorOpen()) {
            return;
        }
        this.eli.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dV.eli.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    eli.aGH(eli.this);
                    if (z) {
                        long eli = eli.this.DbA.eli();
                        if (eli == 0) {
                            eli.this.DbA.eli(System.currentTimeMillis());
                            return;
                        } else if (eli.ui - eli < eli.this.eli.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (eli.this.eli.getHandler() != null) {
                        eli.this.eli.getHandler().post(eli.this.FC);
                    }
                } catch (Throwable th) {
                    Log.e("BusMonitorCenter", th.getMessage());
                }
            }
        }, Math.max(this.eli.getOnceLogInterval(), 10000));
    }
}
