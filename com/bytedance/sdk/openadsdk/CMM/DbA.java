package com.bytedance.sdk.openadsdk.CMM;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private final Context DbA;
    private final String Os;
    private SharedPreferences eli;

    public DbA(Context context, String str) {
        this.DbA = context;
        this.Os = str;
    }

    private SharedPreferences DbA() {
        Context context;
        SharedPreferences sharedPreferences = this.eli;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        if (TextUtils.isEmpty(this.Os) || (context = this.DbA) == null) {
            return null;
        }
        try {
            this.eli = context.getSharedPreferences(this.Os, 0);
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
        return this.eli;
    }

    public void eli(JSONObject jSONObject) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null) {
                SharedPreferences.Editor edit = DbA.edit();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            Object obj = jSONObject.get(next);
                            if (obj instanceof Integer) {
                                edit.putInt(next, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(next, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                edit.putString(next, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                edit.putFloat(next, ((Float) obj).floatValue());
                            } else if (obj instanceof Double) {
                                edit.putFloat(next, Double.valueOf(((Double) obj).doubleValue()).floatValue());
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("SPUnit", th.getMessage());
                    }
                }
                edit.apply();
            }
        } catch (Throwable th2) {
            Log.e("SPUnit", th2.getMessage());
        }
    }

    public void eli(String str, long j) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null) {
                SharedPreferences.Editor edit = DbA.edit();
                edit.putLong(str, j);
                edit.apply();
            }
        } catch (Throwable th) {
            Log.e("SPUnit", th.getMessage());
        }
    }

    public int eli(String str, int i) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null && DbA.contains(str)) {
                return DbA.getInt(str, i);
            }
            return i;
        } catch (Throwable th) {
            Log.i("SPUnit", this.Os + th.getMessage());
            return i;
        }
    }

    public long DbA(String str, long j) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null && DbA.contains(str)) {
                return DbA.getLong(str, j);
            }
            return j;
        } catch (Throwable th) {
            Log.i("SPUnit", this.Os + th.getMessage());
            return j;
        }
    }

    public String eli(String str, String str2) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null && DbA.contains(str)) {
                return DbA.getString(str, str2);
            }
            return str2;
        } catch (Throwable th) {
            Log.i("SPUnit", this.Os + th.getMessage());
            return str2;
        }
    }

    public boolean eli(String str, boolean z) {
        try {
            SharedPreferences DbA = DbA();
            if (DbA != null && DbA.contains(str)) {
                return DbA.getBoolean(str, z);
            }
            return z;
        } catch (Throwable th) {
            Log.i("SPUnit", this.Os + th.getMessage());
            return z;
        }
    }

    public void eli() {
        SharedPreferences DbA = DbA();
        if (DbA != null) {
            SharedPreferences.Editor edit = DbA.edit();
            edit.clear();
            edit.commit();
        }
    }
}
