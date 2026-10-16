package com.bykv.vk.openvk.eli.eli.eli.Os;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os implements Serializable {
    public String DbA;
    private int Dfc;
    private boolean FC;
    private DbA MGA;
    private String NU;
    public int Os;
    private boolean QX;
    private int Xb;
    private String aqO;
    private int bf;
    private long dV;
    private DbA kb;
    private boolean nGm;
    private int nn;
    private int ujq;
    private String wC;
    private int aAs = 204800;
    private int du = 0;
    private int nlS = 0;
    protected float eli = -1.0f;
    public final HashMap<String, Object> aGH = new HashMap<>();
    private int CMM = 10000;
    private int ev = 10000;
    private int Vy = 10000;
    private int gG = 0;
    public int ui = 1;
    private JSONObject Ue = new JSONObject();

    public Os(String str, DbA dbA, DbA dbA2, int i, int i2) {
        this.Xb = 0;
        this.bf = 0;
        this.wC = str;
        this.MGA = dbA;
        this.kb = dbA2;
        this.Xb = i;
        this.bf = i2;
    }

    public void eli(int i) {
        this.ujq = i;
    }

    public boolean eli() {
        int i = this.ujq;
        return i == 1 || i == 2;
    }

    public boolean DbA() {
        return this.ujq == 2;
    }

    public JSONObject Os() {
        return this.Ue;
    }

    public int aGH() {
        return this.Ue.optInt("pitaya_cache_size", 0);
    }

    public String ui() {
        return this.wC;
    }

    public void eli(String str) {
        this.wC = str;
    }

    public int MGA() {
        if (nn()) {
            return this.kb.Dfc();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.Dfc();
        }
        return 0;
    }

    public boolean kb() {
        return this.QX;
    }

    public void DbA(String str) {
        this.NU = str;
    }

    public int wC() {
        return this.nn;
    }

    public void DbA(int i) {
        this.nn = i;
    }

    public int FC() {
        return this.Dfc;
    }

    public void Os(int i) {
        this.Dfc = i;
    }

    public void Os(String str) {
        this.aqO = str;
    }

    public long aAs() {
        return this.dV;
    }

    public void eli(long j) {
        this.dV = j;
    }

    public boolean du() {
        return this.nGm;
    }

    public void eli(boolean z) {
        this.nGm = z;
    }

    public long nlS() {
        if (nn()) {
            return this.kb.ui();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.ui();
        }
        return 0L;
    }

    public boolean NU() {
        if (nn()) {
            return this.kb.bf();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.bf();
        }
        return true;
    }

    public void aGH(String str) {
        this.DbA = str;
    }

    public void aGH(int i) {
        this.Os = i;
    }

    public boolean nn() {
        DbA dbA;
        if (this.bf != 1 || (dbA = this.kb) == null || TextUtils.isEmpty(dbA.du())) {
            return false;
        }
        return com.bykv.vk.openvk.eli.eli.eli.Os.MGA() == 2 || this.Xb == 1;
    }

    public float Dfc() {
        float f = this.eli;
        if (f != -1.0f) {
            return f;
        }
        if (nn()) {
            return this.kb.wC();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.wC();
        }
        return -1.0f;
    }

    public String aqO() {
        if (nn()) {
            return this.kb.du();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.du();
        }
        return null;
    }

    public String dV() {
        if (nn()) {
            return this.kb.nn();
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            return dbA.nn();
        }
        return null;
    }

    public int nGm() {
        return this.Xb;
    }

    public synchronized void eli(String str, Object obj) {
        this.aGH.put(str, obj);
    }

    public synchronized Object ui(String str) {
        return this.aGH.get(str);
    }

    public int QX() {
        return this.CMM;
    }

    public void ui(int i) {
        this.CMM = i;
    }

    public int Xb() {
        return this.ev;
    }

    public void MGA(int i) {
        this.ev = i;
    }

    public int bf() {
        return this.Vy;
    }

    public void kb(int i) {
        this.Vy = i;
    }

    public int CMM() {
        return this.gG;
    }

    public void wC(int i) {
        this.gG = i;
    }

    public DbA ev() {
        return this.MGA;
    }

    public DbA Vy() {
        return this.kb;
    }

    public void DbA(boolean z) {
        this.FC = z;
    }

    public boolean gG() {
        return this.FC;
    }
}
