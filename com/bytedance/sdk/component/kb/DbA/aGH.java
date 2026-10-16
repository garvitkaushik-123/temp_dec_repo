package com.bytedance.sdk.component.kb.DbA;

import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.Dfc;
import com.bytedance.sdk.component.DbA.eli.FC;
import com.bytedance.sdk.component.DbA.eli.MGA;
import com.bytedance.sdk.component.DbA.eli.NU;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.google.common.net.HttpHeaders;
import com.ironsource.D5;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends Os {
    NU eli;

    public aGH(du duVar) {
        super(duVar);
        this.eli = null;
    }

    public void aGH(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.eli = NU.eli(FC.eli("application/json; charset=utf-8"), str);
    }

    public void eli(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            str = "{}";
        } else {
            str = jSONObject.toString();
        }
        this.eli = NU.eli(FC.eli("application/json; charset=utf-8"), str);
    }

    public void eli(String str, byte[] bArr) {
        this.eli = NU.eli(FC.eli(str), bArr);
    }

    public void eli(final com.bytedance.sdk.component.kb.eli.eli eliVar) {
        try {
            nlS.eli eliVar2 = new nlS.eli();
            if (TextUtils.isEmpty(this.wC)) {
                eliVar.eli(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.ui)) {
                eliVar2.eli(this.ui);
            }
            if (this.MGA > 0) {
                eliVar2.eli(this.MGA);
            }
            eliVar2.DbA(this.wC);
            if (this.eli == null) {
                if (eliVar != null) {
                    eliVar.eli(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                eli(eliVar2);
                eliVar2.eli((Object) Os());
                this.Os.eli(eliVar2.eli(this.eli).DbA()).eli(new com.bytedance.sdk.component.DbA.eli.Os() { // from class: com.bytedance.sdk.component.kb.DbA.aGH.1
                    @Override // com.bytedance.sdk.component.DbA.eli.Os
                    public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, IOException iOException) {
                        com.bytedance.sdk.component.kb.eli.eli eliVar3 = eliVar;
                        if (eliVar3 != null) {
                            eliVar3.eli(aGH.this, iOException);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x00fa  */
                    /* JADX WARN: Type inference failed for: r13v6, types: [com.bytedance.sdk.component.kb.eli.eli] */
                    /* JADX WARN: Type inference failed for: r2v0 */
                    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.sdk.component.kb.DbA] */
                    /* JADX WARN: Type inference failed for: r2v11 */
                    /* JADX WARN: Type inference failed for: r2v12 */
                    /* JADX WARN: Type inference failed for: r2v13 */
                    /* JADX WARN: Type inference failed for: r2v14 */
                    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r2v5 */
                    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.sdk.component.kb.DbA] */
                    @Override // com.bytedance.sdk.component.DbA.eli.Os
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, nn nnVar) throws IOException {
                        Throwable th;
                        ?? r2;
                        String str;
                        String lowerCase;
                        com.bytedance.sdk.component.kb.eli.eli eliVar3 = eliVar;
                        if (eliVar3 != null) {
                            if (nnVar == null) {
                                eliVar3.eli(aGH.this, new IOException("No response"));
                                return;
                            }
                            IOException iOException = null;
                            try {
                                HashMap hashMap = new HashMap();
                                MGA kb = nnVar.kb();
                                ?? r22 = "";
                                if (kb != null) {
                                    for (int i = 0; i < kb.eli(); i++) {
                                        String eli = kb.eli(i);
                                        String DbA = kb.DbA(i);
                                        hashMap.put(eli, DbA);
                                        if (eli != null && eli.equalsIgnoreCase("content-type")) {
                                            if (DbA == null) {
                                                lowerCase = "";
                                            } else {
                                                lowerCase = DbA.toLowerCase();
                                            }
                                            hashMap.put("content-type", lowerCase);
                                        }
                                    }
                                }
                                Dfc MGA = nnVar.MGA();
                                try {
                                    if (com.bytedance.sdk.component.kb.Os.eli.eli(hashMap)) {
                                        byte[] aGH = MGA.aGH();
                                        com.bytedance.sdk.component.kb.DbA dbA2 = new com.bytedance.sdk.component.kb.DbA(nnVar.aGH(), nnVar.Os(), nnVar.ui(), hashMap, null, nnVar.DbA(), nnVar.eli());
                                        dbA2.eli(aGH);
                                        r22 = dbA2;
                                    } else if (aGH.this.FC) {
                                        byte[] aGH2 = MGA.aGH();
                                        aGH agh = aGH.this;
                                        com.bytedance.sdk.component.kb.DbA dbA3 = new com.bytedance.sdk.component.kb.DbA(nnVar.aGH(), nnVar.Os(), nnVar.ui(), hashMap, new String(aGH2, agh.eli(agh.eli(MGA))), nnVar.DbA(), nnVar.eli());
                                        dbA3.eli(aGH2);
                                        r22 = dbA3;
                                    } else {
                                        if (MGA == null) {
                                            throw new IOException(nnVar.ui());
                                        }
                                        boolean aGH3 = nnVar.aGH();
                                        int Os = nnVar.Os();
                                        String ui = nnVar.ui();
                                        if (MGA == null) {
                                            str = "";
                                        } else {
                                            str = MGA.DbA();
                                        }
                                        r22 = new com.bytedance.sdk.component.kb.DbA(aGH3, Os, ui, hashMap, str, nnVar.DbA(), nnVar.eli());
                                    }
                                    aGH.this.eli((com.bytedance.sdk.component.kb.DbA) r22, nnVar);
                                    r2 = r22;
                                } catch (Throwable th2) {
                                    th = th2;
                                    iOException = r22;
                                    r2 = iOException;
                                    iOException = new IOException(th);
                                    if (r2 == 0) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            if (r2 == 0) {
                                eliVar.eli(aGH.this, r2);
                                return;
                            }
                            com.bytedance.sdk.component.kb.eli.eli eliVar4 = eliVar;
                            if (eliVar4 instanceof com.bytedance.sdk.component.kb.eli.DbA) {
                                com.bytedance.sdk.component.kb.eli.DbA dbA4 = (com.bytedance.sdk.component.kb.eli.DbA) eliVar4;
                                aGH agh2 = aGH.this;
                                if (iOException == null) {
                                    iOException = new IOException("Unexpected exception");
                                }
                                dbA4.eli(agh2, iOException, new com.bytedance.sdk.component.kb.DbA(nnVar.aGH(), nnVar.Os(), nnVar.ui(), null, null, nnVar.DbA(), nnVar.eli()));
                                return;
                            }
                            aGH agh3 = aGH.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                            eliVar4.eli(agh3, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            eliVar.eli(this, new IOException(th.getMessage()));
        }
    }

    public com.bytedance.sdk.component.kb.DbA eli() {
        com.bytedance.sdk.component.kb.DbA dbA;
        String lowerCase;
        try {
            nlS.eli eliVar = new nlS.eli();
            if (TextUtils.isEmpty(this.wC)) {
                return new com.bytedance.sdk.component.kb.DbA(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            eliVar.DbA(this.wC);
            if (this.eli == null) {
                return new com.bytedance.sdk.component.kb.DbA(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            eli(eliVar);
            eliVar.eli((Object) Os());
            nn DbA = this.Os.eli(eliVar.eli(this.eli).DbA()).DbA();
            if (DbA == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            MGA kb = DbA.kb();
            if (kb != null) {
                for (int i = 0; i < kb.eli(); i++) {
                    String eli = kb.eli(i);
                    String DbA2 = kb.DbA(i);
                    hashMap.put(eli, DbA2);
                    if (eli != null && eli.equalsIgnoreCase("content-type")) {
                        if (DbA2 == null) {
                            lowerCase = "";
                        } else {
                            lowerCase = DbA2.toLowerCase();
                        }
                        hashMap.put("content-type", lowerCase);
                    }
                }
            }
            Dfc MGA = DbA.MGA();
            if (com.bytedance.sdk.component.kb.Os.eli.eli(hashMap)) {
                byte[] aGH = MGA.aGH();
                dbA = new com.bytedance.sdk.component.kb.DbA(DbA.aGH(), DbA.Os(), DbA.ui(), hashMap, null, DbA.DbA(), DbA.eli());
                dbA.eli(aGH);
            } else if (this.FC) {
                byte[] aGH2 = MGA.aGH();
                dbA = new com.bytedance.sdk.component.kb.DbA(DbA.aGH(), DbA.Os(), DbA.ui(), hashMap, new String(aGH2, eli(eli(MGA))), DbA.DbA(), DbA.eli());
                dbA.eli(aGH2);
            } else if (MGA != null) {
                boolean aGH3 = DbA.aGH();
                int Os = DbA.Os();
                String str = "";
                String ui = DbA.ui();
                if (MGA != null) {
                    str = MGA.DbA();
                }
                dbA = new com.bytedance.sdk.component.kb.DbA(aGH3, Os, ui, hashMap, str, DbA.DbA(), DbA.eli());
            } else {
                throw new IOException(DbA.ui());
            }
            eli(dbA, DbA);
            return dbA;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.kb.DbA(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public void eli(String str, boolean z) {
        if (z) {
            eli("application/json; charset=utf-8", ui(str));
            DbA(HttpHeaders.CONTENT_ENCODING, "gzip");
        } else {
            aGH(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r2 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] ui(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(str.getBytes(D5.N));
            try {
                gZIPOutputStream.close();
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused6) {
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException unused7) {
                    throw th;
                }
            }
            throw th;
        }
        bArr = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused8) {
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset eli(FC fc) {
        try {
            return fc != null ? fc.eli(com.bytedance.sdk.component.DbA.eli.DbA.FC.eli) : com.bytedance.sdk.component.DbA.eli.DbA.FC.eli;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.DbA.eli.DbA.FC.eli;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FC eli(Dfc dfc) {
        try {
            return dfc.ui();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.kb.DbA dbA, nn nnVar) {
        if (dbA == null || nnVar == null) {
            return;
        }
        dbA.eli(nnVar.wC());
    }
}
