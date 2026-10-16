package com.bytedance.sdk.component.ui.ui;

/* loaded from: classes3.dex */
public class du extends eli {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.sdk.component.ui.Os.Os] */
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        final com.bytedance.sdk.component.ui.Os.Os os2;
        final com.bytedance.sdk.component.ui.Os.MGA nGm = os.nGm();
        com.bytedance.sdk.component.ui.aGH aGH = nGm.aGH();
        os.eli(false);
        try {
            com.bytedance.sdk.component.ui.MGA eli = aGH.eli(new com.bytedance.sdk.component.ui.DbA.DbA(os.eli(), os.NU(), os.nn(), os.bf()));
            int DbA = eli.DbA();
            os.eli(eli.eli());
            os2 = 200;
            try {
                if (eli.DbA() == 200) {
                    final byte[] bArr = (byte[]) eli.Os();
                    os.eli(new DbA(bArr, eli));
                    final String FC = os.FC();
                    final com.bytedance.sdk.component.ui.DbA QX = os.QX();
                    if (QX.ui()) {
                        nGm.DbA(os.QX()).eli(FC, bArr);
                    }
                    os2 = os;
                    try {
                        nGm.kb().submit(new Runnable() { // from class: com.bytedance.sdk.component.ui.ui.du.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QX.kb()) {
                                    nGm.Os(os2.QX()).eli(FC, bArr);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        th = th;
                        eli(1004, "net request failed!", th, os2);
                        return;
                    }
                }
                String.valueOf(eli);
                Object Os = eli.Os();
                eli(DbA, eli.aGH(), Os instanceof Throwable ? (Throwable) Os : null, os);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            os2 = os;
        }
    }

    private void eli(int i, String str, Throwable th, com.bytedance.sdk.component.ui.Os.Os os) {
        os.eli(new wC(i, str, th));
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "net_request";
    }
}
