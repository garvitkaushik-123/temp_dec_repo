package com.bytedance.sdk.component.DbA.eli.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.NU;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.DbA.eli.wC;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class DbA implements com.bytedance.sdk.component.DbA.eli.DbA {
    private static List<Object> aGH;
    com.bytedance.sdk.component.DbA.eli.aGH DbA;
    private AtomicBoolean Os = new AtomicBoolean(false);
    nlS eli;

    static {
        try {
            aGH = new ArrayList();
            Class<?> cls = Class.forName("com.android.okhttp.Protocol");
            Enum valueOf = Enum.valueOf(cls, "HTTP_1_1");
            if (valueOf != null) {
                aGH.add(valueOf);
            }
            Enum valueOf2 = Enum.valueOf(cls, "HTTP_2");
            if (valueOf2 != null) {
                aGH.add(valueOf2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    DbA(nlS nls, com.bytedance.sdk.component.DbA.eli.aGH agh) {
        this.eli = nls;
        this.DbA = agh;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA
    public nlS eli() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA
    public nn DbA() throws IOException {
        nlS nls = this.eli;
        if (nls != null && nls.DbA != null) {
            if (this.eli.DbA.nn() == 0) {
                this.eli.DbA.Dfc();
            }
            this.eli.DbA.eli();
        }
        this.DbA.Os().remove(this);
        this.DbA.aGH().add(this);
        com.bytedance.sdk.component.DbA.eli.aGH agh = this.DbA;
        if ((agh instanceof MGA) && (agh.Os().size() + this.DbA.aGH().size() > this.DbA.eli() || this.Os.get())) {
            this.DbA.aGH().remove(this);
            return new wC(wC.eli, "Maximum number of requests exceeded", this.eli);
        }
        try {
            if (this.eli.eli != null && this.eli.eli.eli != null && this.eli.eli.eli.size() > 0) {
                ArrayList arrayList = new ArrayList(this.eli.eli.eli);
                arrayList.add(new com.bytedance.sdk.component.DbA.eli.wC() { // from class: com.bytedance.sdk.component.DbA.eli.eli.eli.DbA.1
                    @Override // com.bytedance.sdk.component.DbA.eli.wC
                    public nn eli(wC.eli eliVar) throws IOException {
                        return DbA.this.eli(eliVar.eli());
                    }
                });
                return ((com.bytedance.sdk.component.DbA.eli.wC) arrayList.get(0)).eli(new Os(arrayList, this.eli));
            }
            return eli(this.eli);
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    private boolean eli(NU nu) {
        nlS nls;
        return nu != null && (nls = this.eli) != null && "POST".equalsIgnoreCase(nls.Os()) && nu.MGA == NU.eli.BYTE_ARRAY_TYPE && nu.ui != null && nu.ui.length > 0;
    }

    private boolean DbA(NU nu) {
        nlS nls;
        return (nu == null || (nls = this.eli) == null || !"POST".equalsIgnoreCase(nls.Os()) || nu.MGA != NU.eli.STRING_TYPE || TextUtils.isEmpty(nu.aGH)) ? false : true;
    }

    public nn eli(nlS nls) throws IOException {
        return eli(nls, com.bytedance.sdk.component.kb.eli.ui());
    }

    public nn eli(nlS nls, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        IOException e;
        String eli;
        int i = wC.eli;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(nls.DbA().eli().toString()).openConnection();
                if (z) {
                    try {
                        if (!"setting".equals(nls.MGA()) && !"gecko".equals(nls.MGA()) && !"load_ug_t".equals(nls.MGA())) {
                            eli(httpURLConnection);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (i == -1 && z) {
                            return eli(nls, false);
                        }
                        eli = eli(httpURLConnection, e);
                        return new wC(i, eli, nls);
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection2 = httpURLConnection;
                        eli = eli(httpURLConnection2, e);
                        return new wC(i, eli, nls);
                    }
                }
                if (nls.aGH() != null && nls.aGH().size() > 0) {
                    for (Map.Entry<String, List<String>> entry : nls.aGH().entrySet()) {
                        String key = entry.getKey();
                        for (String str : entry.getValue()) {
                            if ("_disable_retry".equals(key) && "1".equals(str)) {
                                DbA(httpURLConnection);
                            } else {
                                httpURLConnection.addRequestProperty(key, str);
                            }
                        }
                    }
                }
                if (nls.eli != null) {
                    if (nls.eli.Os != null) {
                        httpURLConnection.setConnectTimeout((int) nls.eli.Os.toMillis(nls.eli.DbA));
                    }
                    if (nls.eli.Os != null) {
                        httpURLConnection.setReadTimeout((int) nls.eli.ui.toMillis(nls.eli.aGH));
                    }
                }
                if (nls.wC() == null) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    if (!ui() && nls.wC().Os != null) {
                        httpURLConnection.addRequestProperty("Content-Type", nls.wC().Os.eli());
                    }
                    httpURLConnection.setRequestMethod(nls.Os());
                    if ("POST".equalsIgnoreCase(nls.Os())) {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        if (eli(nls.wC())) {
                            outputStream.write(nls.wC().ui);
                        } else if (DbA(nls.wC())) {
                            outputStream.write(nls.wC().aGH.getBytes());
                        }
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                if (nls != null && nls.DbA != null) {
                    nls.DbA.DbA();
                }
                httpURLConnection.connect();
                if (nls != null && nls.DbA != null) {
                    nls.DbA.Os();
                }
                i = httpURLConnection.getResponseCode();
                if (nls != null && nls.DbA != null) {
                    nls.DbA.ui();
                }
            } finally {
                this.DbA.aGH().remove(this);
            }
        } catch (IOException e4) {
            httpURLConnection = null;
            e = e4;
        } catch (Exception e5) {
            e = e5;
        }
        if (!this.Os.get()) {
            return new wC(httpURLConnection, nls);
        }
        httpURLConnection.disconnect();
        this.DbA.aGH().remove(this);
        eli = "internal error";
        return new wC(i, eli, nls);
    }

    private static String eli(HttpURLConnection httpURLConnection, Exception exc) {
        try {
            return httpURLConnection.getErrorStream().toString();
        } catch (Throwable unused) {
            return exc.getMessage();
        }
    }

    private static void eli(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (aGH.size() == 2) {
                obj2.getClass().getDeclaredMethod("setProtocols", List.class).invoke(obj2, aGH);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void DbA(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            obj2.getClass().getDeclaredMethod("setRetryOnConnectionFailure", Boolean.TYPE).invoke(obj2, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    private boolean ui() {
        if (this.eli.aGH() == null) {
            return false;
        }
        return this.eli.aGH().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA
    public void eli(final com.bytedance.sdk.component.DbA.eli.Os os) {
        nlS nls = this.eli;
        if (nls != null && nls.DbA != null) {
            this.eli.DbA.Dfc();
        }
        this.DbA.DbA().submit(new com.bytedance.sdk.component.wC.Os.DbA(this.eli.kb(), this.eli.MGA()) { // from class: com.bytedance.sdk.component.DbA.eli.eli.eli.DbA.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nn DbA = DbA.this.DbA();
                    if (DbA == null) {
                        os.eli(DbA.this, new IOException("response is null"));
                    } else {
                        os.eli(DbA.this, DbA);
                    }
                } catch (IOException e) {
                    os.eli(DbA.this, e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.DbA.eli.DbA
    public void Os() {
        this.Os.set(true);
    }

    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.DbA.eli.DbA clone() {
        return new DbA(this.eli, this.DbA);
    }
}
