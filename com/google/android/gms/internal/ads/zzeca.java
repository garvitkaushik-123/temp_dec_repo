package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.ironsource.C3040d4;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeca extends zzfqw {
    private final Context zza;
    private final zzgdy zzb;

    public zzeca(Context context, zzgdy zzgdyVar) {
        super(context, "AdMobOfflineBufferedPings.db", null, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziL)).intValue(), zzfqy.zza);
        this.zza = context;
        this.zzb = zzgdyVar;
    }

    public static /* synthetic */ Void zza(zzeca zzecaVar, zzecc zzeccVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzeccVar.zza));
        contentValues.put("gws_query_id", zzeccVar.zzb);
        contentValues.put("url", zzeccVar.zzc);
        contentValues.put("event_state", Integer.valueOf(zzeccVar.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = zzecaVar.zza;
        com.google.android.gms.ads.internal.util.zzbr zzA = com.google.android.gms.ads.internal.util.zzs.zzA(context);
        if (zzA != null) {
            try {
                zzA.zze(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    static /* synthetic */ Void zzb(com.google.android.gms.ads.internal.util.client.zzu zzuVar, SQLiteDatabase sQLiteDatabase) throws Exception {
        zzj(sQLiteDatabase, zzuVar);
        return null;
    }

    static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, com.google.android.gms.ads.internal.util.client.zzu zzuVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzuVar);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, com.google.android.gms.ads.internal.util.client.zzu zzuVar) {
        String str;
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"timestamp", "url"}, "event_state = 1", null, null, null, "timestamp ASC", null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("timestamp");
                int columnIndex2 = query.getColumnIndex("url");
                if (columnIndex2 != -1) {
                    long j = query.getLong(columnIndex);
                    String string = query.getString(columnIndex2);
                    if (string == null) {
                        str = "";
                    } else {
                        Uri parse = Uri.parse(string);
                        long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - j;
                        String encodedQuery = parse.getEncodedQuery();
                        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                        clearQuery.appendQueryParameter("bd", Long.toString(currentTimeMillis));
                        str = String.valueOf(clearQuery.build()) + C3040d4.i.c + encodedQuery;
                    }
                    strArr[i] = str;
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzuVar.zza(strArr[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void zzc(final String str) {
        zze(new zzfge(this) { // from class: com.google.android.gms.internal.ads.zzeby
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzeca.zzi((SQLiteDatabase) obj, str);
                return null;
            }
        });
    }

    public final void zzd(final zzecc zzeccVar) {
        zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebu
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzeca.zza(zzeca.this, zzeccVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    final void zze(zzfge zzfgeVar) {
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzebw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeca.this.getWritableDatabase();
            }
        };
        zzgdy zzgdyVar = this.zzb;
        zzgdn.zzr(zzgdyVar.zzb(callable), new zzebz(this, zzfgeVar), zzgdyVar);
    }

    final void zzg(final SQLiteDatabase sQLiteDatabase, final com.google.android.gms.ads.internal.util.client.zzu zzuVar, final String str) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebx
            @Override // java.lang.Runnable
            public final void run() {
                zzeca.zzf(sQLiteDatabase, str, zzuVar);
            }
        });
    }

    public final void zzh(final com.google.android.gms.ads.internal.util.client.zzu zzuVar, final String str) {
        zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebv
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzeca.this.zzg((SQLiteDatabase) obj, zzuVar, str);
                return null;
            }
        });
    }
}
