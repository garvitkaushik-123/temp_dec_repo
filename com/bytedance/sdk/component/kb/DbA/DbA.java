package com.bytedance.sdk.component.kb.DbA;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.Dfc;
import com.bytedance.sdk.component.DbA.eli.MGA;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.eli;
import com.bytedance.sdk.component.DbA.eli.kb;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DbA extends Os {
    private com.bytedance.sdk.component.DbA.eli.eli aAs;
    private boolean du;
    private Map<String, String> nlS;
    public static final com.bytedance.sdk.component.DbA.eli.eli eli = new eli.C0130eli().eli().DbA();
    public static final com.bytedance.sdk.component.DbA.eli.eli DbA = new eli.C0130eli().DbA();

    public DbA(du duVar) {
        super(duVar);
        this.aAs = eli;
        this.du = false;
        this.nlS = new HashMap();
    }

    public void eli(boolean z) {
        this.du = z;
    }

    public void eli(final com.bytedance.sdk.component.kb.eli.eli eliVar) {
        try {
            nlS.eli eliVar2 = new nlS.eli();
            if (this.du) {
                eliVar2.DbA(this.wC);
            } else {
                kb.eli eliVar3 = new kb.eli();
                Uri parse = Uri.parse(this.wC);
                eliVar3.eli(parse.getScheme());
                eliVar3.DbA(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    eliVar3.Os(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.nlS.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.nlS.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        eliVar3.eli(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                eliVar2.eli(eliVar3.DbA());
            }
            eli(eliVar2);
            eliVar2.eli(this.aAs);
            eliVar2.eli((Object) Os());
            if (!TextUtils.isEmpty(this.ui)) {
                eliVar2.eli(this.ui);
            }
            if (this.MGA > 0) {
                eliVar2.eli(this.MGA);
            }
            this.Os.eli(eliVar2.eli().DbA()).eli(new com.bytedance.sdk.component.DbA.eli.Os() { // from class: com.bytedance.sdk.component.kb.DbA.DbA.1
                @Override // com.bytedance.sdk.component.DbA.eli.Os
                public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, IOException iOException) {
                    com.bytedance.sdk.component.kb.eli.eli eliVar4 = eliVar;
                    if (eliVar4 != null) {
                        eliVar4.eli(DbA.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.DbA.eli.Os
                public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, nn nnVar) throws IOException {
                    String DbA2;
                    if (eliVar != null) {
                        HashMap hashMap = new HashMap();
                        if (nnVar != null) {
                            MGA kb = nnVar.kb();
                            if (kb != null) {
                                for (int i = 0; i < kb.eli(); i++) {
                                    hashMap.put(kb.eli(i), kb.DbA(i));
                                }
                            }
                            Dfc MGA = nnVar.MGA();
                            if (MGA == null) {
                                DbA2 = "";
                            } else {
                                DbA2 = MGA.DbA();
                            }
                            eliVar.eli(DbA.this, new com.bytedance.sdk.component.kb.DbA(nnVar.aGH(), nnVar.Os(), nnVar.ui(), hashMap, DbA2, nnVar.DbA(), nnVar.eli()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (eliVar != null) {
                eliVar.eli(this, new IOException(th.getMessage()));
            }
        }
    }

    public com.bytedance.sdk.component.kb.DbA eli() {
        try {
            nlS.eli eliVar = new nlS.eli();
            String str = "";
            if (this.du) {
                eliVar.DbA(this.wC);
            } else {
                kb.eli eliVar2 = new kb.eli();
                Uri parse = Uri.parse(this.wC);
                eliVar2.eli(parse.getScheme());
                eliVar2.DbA(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    eliVar2.Os(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str2 : queryParameterNames) {
                        this.nlS.put(str2, parse.getQueryParameter(str2));
                    }
                }
                for (Map.Entry<String, String> entry : this.nlS.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        eliVar2.eli(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                eliVar.eli(eliVar2.DbA());
            }
            eli(eliVar);
            eliVar.eli(this.aAs);
            eliVar.eli((Object) Os());
            nn DbA2 = this.Os.eli(eliVar.eli().DbA()).DbA();
            if (DbA2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            MGA kb = DbA2.kb();
            if (kb != null) {
                for (int i = 0; i < kb.eli(); i++) {
                    hashMap.put(kb.eli(i), kb.DbA(i));
                }
            }
            Dfc MGA = DbA2.MGA();
            if (MGA != null) {
                str = MGA.DbA();
            }
            return new com.bytedance.sdk.component.kb.DbA(DbA2.aGH(), DbA2.Os(), DbA2.ui(), hashMap, str, DbA2.DbA(), DbA2.eli());
        } catch (Throwable unused) {
            return null;
        }
    }
}
