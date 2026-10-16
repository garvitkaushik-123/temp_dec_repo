package com.bytedance.sdk.component.ui.aGH.DbA;

import com.bytedance.sdk.component.ui.QX;
import com.bytedance.sdk.component.ui.nGm;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Os implements MGA {
    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, QX qx, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        com.bytedance.sdk.component.ui.DbA nGm = os.nGm();
        com.bytedance.sdk.component.ui.aGH.Os.MGA dV = os.dV();
        if (nGm != null && dV != null) {
            if (nGm.MGA()) {
                if (qx != null) {
                    qx.eli("data_cache", os);
                }
                nGm DbA = dV.DbA(nGm);
                r7 = DbA != null ? DbA.eli(os.FC()) : null;
                if (qx != null) {
                    qx.DbA("data_cache", os);
                }
                new Object[]{"step 4-1 Read memory-level data key is", os.FC(), "url is ", os.eli(), "imageData is null  ", Boolean.valueOf(r7 == null)};
            }
            if (nGm.kb() && r7 == null) {
                if (qx != null) {
                    qx.eli("disk_cache", os);
                }
                byte[] eli = eli(nGm, dV, os.FC());
                if (eli != null) {
                    eli(os.nGm(), dV, os.FC(), eli);
                }
                if (qx != null) {
                    qx.DbA("disk_cache", os);
                }
                new Object[]{"step 4-2 Read disk cache key is ", os.FC(), "url is ", os.eli(), "imageData is null  ", Boolean.valueOf(eli == null)};
                r7 = eli;
            }
        }
        if (dV != null && r7 == null) {
            if (qx != null) {
                qx.eli("net_request", os);
            }
            r7 = eli(dV, os, eliVar);
            new Object[]{"step 4-3 net request cache key is  ", os.FC(), "url is ", os.eli(), " imageData is null ", Boolean.valueOf(r7 == null)};
            if (qx != null) {
                qx.DbA("net_request", os);
            }
        }
        if (r7 == null) {
            new Object[]{"step 4-4 net fail cache key is  ", os.FC(), "url is ", os.eli(), " imageData is null ", Boolean.valueOf(r7 == null)};
            return false;
        }
        os.eli(r7);
        return true;
    }

    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public String eli() {
        return "data_intercept";
    }

    private byte[] eli(com.bytedance.sdk.component.ui.aGH.Os.MGA mga, com.bytedance.sdk.component.ui.aGH.Os.Os os, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        com.bytedance.sdk.component.ui.aGH aGH = mga.aGH();
        os.eli(false);
        try {
            com.bytedance.sdk.component.ui.MGA eli = aGH.eli(new com.bytedance.sdk.component.ui.DbA.DbA(os.eli(), false, false, os.QX()));
            if (eli == null) {
                eliVar.eli(1004, "call is empty", new Exception("call is empty"));
                return null;
            }
            int DbA = eli.DbA();
            if (DbA == 200) {
                byte[] bArr = (byte[]) eli.Os();
                if (bArr == null) {
                    eliVar.eli(DbA, eli.aGH(), new Exception("net data is empty"));
                    return null;
                }
                eli(os.nGm(), mga, os.FC(), bArr);
                DbA(os.nGm(), mga, os.FC(), bArr);
                return bArr;
            }
            Object Os = eli.Os();
            eliVar.eli(DbA, eli.aGH(), Os instanceof Throwable ? (Throwable) Os : null);
            return null;
        } catch (Throwable th) {
            eliVar.eli(1004, "net request failed!", th);
            return null;
        }
    }

    private byte[] eli(com.bytedance.sdk.component.ui.DbA dbA, com.bytedance.sdk.component.ui.aGH.Os.MGA mga, String str) {
        mga.Os(dbA);
        Collection<com.bytedance.sdk.component.ui.Os> Os = mga.Os();
        if (Os == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.ui.Os> it = Os.iterator();
        while (it.hasNext()) {
            byte[] eli = it.next().eli((com.bytedance.sdk.component.ui.Os) str);
            if (eli != null) {
                return eli;
            }
        }
        return null;
    }

    private void eli(com.bytedance.sdk.component.ui.DbA dbA, com.bytedance.sdk.component.ui.aGH.Os.MGA mga, String str, byte[] bArr) {
        if (dbA == null || !dbA.MGA()) {
            return;
        }
        mga.DbA(dbA).eli(str, bArr);
    }

    private void DbA(final com.bytedance.sdk.component.ui.DbA dbA, final com.bytedance.sdk.component.ui.aGH.Os.MGA mga, final String str, final byte[] bArr) {
        if (dbA == null || !dbA.kb()) {
            return;
        }
        mga.wC().submit(new Runnable() { // from class: com.bytedance.sdk.component.ui.aGH.DbA.Os.1
            @Override // java.lang.Runnable
            public void run() {
                mga.Os(dbA).eli(str, bArr);
            }
        });
    }
}
