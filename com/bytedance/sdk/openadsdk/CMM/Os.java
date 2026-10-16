package com.bytedance.sdk.openadsdk.CMM;

import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.ironsource.D5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private DbA DbA;
    private aGH Os;
    private eli aGH;
    private final String eli = "StrategyCenter";
    private int ui = 0;
    private Runnable MGA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.CMM.Os.2
        @Override // java.lang.Runnable
        public void run() {
            Os.this.DbA();
        }
    };

    public Os(aGH agh) {
        this.DbA = null;
        ui uiVar = new ui(agh);
        this.Os = uiVar;
        String Os = uiVar.Os();
        if (!TextUtils.isEmpty(Os) && !Os.startsWith("pag")) {
            Os = "pag_".concat(String.valueOf(Os));
        }
        this.DbA = new DbA(this.Os.DbA(), Os);
    }

    public void eli(eli eliVar) {
        this.aGH = eliVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        aGH agh = this.Os;
        if (agh == null || agh.ui() == null || this.Os.MGA() == null) {
            return;
        }
        this.Os.eli().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.CMM.Os.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStream;
                Os.this.ui++;
                try {
                    if (Os.this.aGH != null) {
                        Os.this.aGH.eli();
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Os.this.Os.ui()).openConnection();
                    if (Os.this.Os.kb() != null && Os.this.Os.kb().size() > 0) {
                        for (Map.Entry<String, String> entry : Os.this.Os.kb().entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", D5.L);
                    try {
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            outputStream.write(Os.this.Os.MGA().toString().getBytes());
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            int responseCode = httpURLConnection.getResponseCode();
                            Log.i("StrategyCenter", "executing strategy fetch");
                            if (responseCode != 200) {
                                if (Os.this.aGH != null) {
                                    Os.this.aGH.eli(responseCode, httpURLConnection.getResponseMessage());
                                }
                            } else {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    } else {
                                        stringBuffer.append(readLine);
                                    }
                                }
                                bufferedReader.close();
                                JSONObject eli = Os.this.Os.eli(new JSONObject(stringBuffer.toString()));
                                Os.this.DbA.eli();
                                Os.this.DbA.eli(eli);
                                if (Os.this.aGH != null) {
                                    Os.this.aGH.DbA();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = null;
                    }
                } catch (Throwable th3) {
                    Log.e("StrategyCenter", th3.getMessage() == null ? "error " : th3.getMessage());
                    if (Os.this.aGH != null) {
                        Os.this.aGH.eli(-1, th3.getMessage());
                    }
                }
                Os.this.DbA.eli("local_last_update_time", System.currentTimeMillis());
                Os.this.eli();
            }
        });
    }

    public void eli() {
        if (this.Os != null) {
            DbA dbA = this.DbA;
            int i = Constants.ONE_HOUR;
            int eli = dbA.eli("req_interval", Constants.ONE_HOUR);
            long j = 0;
            long DbA = this.DbA.DbA("local_last_update_time", 0L);
            if (eli >= 600000 && eli <= 86400000) {
                i = eli;
            }
            long currentTimeMillis = System.currentTimeMillis() - DbA;
            Log.i("StrategyCenter", "before  realInterval=".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis >= 0) {
                long j2 = i;
                if (currentTimeMillis <= j2) {
                    j = j2 - currentTimeMillis;
                }
            }
            Log.i("StrategyCenter", "after  realInterval=".concat(String.valueOf(j)));
            this.Os.aGH().removeCallbacks(this.MGA);
            if (this.ui > 24) {
                return;
            }
            this.Os.aGH().postDelayed(this.MGA, j);
        }
    }

    public int eli(String str, int i) {
        DbA dbA = this.DbA;
        return dbA == null ? i : dbA.eli(str, i);
    }

    public String eli(String str, String str2) {
        DbA dbA = this.DbA;
        return dbA == null ? str2 : dbA.eli(str, str2);
    }

    public boolean eli(String str, boolean z) {
        DbA dbA = this.DbA;
        return dbA == null ? z : dbA.eli(str, z);
    }
}
