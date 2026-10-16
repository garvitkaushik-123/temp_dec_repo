package com.tiktok.appevents;

import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.HttpRequestUtil;
import com.tiktok.util.TTLogger;
import com.tiktok.util.TTUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTCrashHandler {
    private static final String CRASH_REPORT_FILE = "tt_crash_log";
    private static final int MONITOR_BATCH_MAX = 5;
    private static final int MONITOR_RETRY_LIMIT = 2;
    private static final String TAG = "com.tiktok.appevents.TTCrashHandler";
    private static final TTLogger ttLogger = new TTLogger(TTCrashHandler.class.getCanonicalName(), TikTokBusinessSdk.getLogLevel());
    static TTCrashReport crashReport = new TTCrashReport();

    public static void handleCrash(String originTag, Throwable ex, int type) {
        ttLogger.error(ex, "Error caused by sdk at " + originTag + "\n" + ex.getMessage() + "\n" + getStackTrace(ex), new Object[0]);
        persistException(ex, type);
    }

    public static void retryLater(JSONObject monitor) {
        crashReport.addReport(monitor.toString(), System.currentTimeMillis(), 0);
        if (crashReport.reports.size() >= 5) {
            initCrashReporter();
        }
    }

    public static void persistToFile() {
        Iterator<TTCrashReport.Monitor> it = crashReport.reports.iterator();
        while (it.hasNext()) {
            ttLogger.info("persistToFile %s", it.next().monitor);
        }
        saveToFile(crashReport);
        crashReport = new TTCrashReport();
    }

    public static void initCrashReporter() {
        TTCrashReport readFromFile = readFromFile();
        if (readFromFile != null) {
            crashReport.reports.addAll(readFromFile.reports);
            try {
                File file = new File(TikTokBusinessSdk.getApplicationContext().getFilesDir(), CRASH_REPORT_FILE);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
        TTCrashReport reportMonitor = reportMonitor(crashReport);
        crashReport = reportMonitor;
        saveToFile(reportMonitor);
        crashReport = new TTCrashReport();
    }

    private static TTCrashReport reportMonitor(TTCrashReport cr) {
        if (cr.reports.size() == 0) {
            return cr;
        }
        TTCrashReport tTCrashReport = new TTCrashReport();
        int i = 0;
        while (i < cr.reports.size()) {
            int i2 = i + 5;
            List<TTCrashReport.Monitor> subList = cr.reports.subList(i, i2 > cr.reports.size() ? cr.reports.size() : i2);
            ArrayList arrayList = new ArrayList();
            Iterator<TTCrashReport.Monitor> it = subList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new JSONObject(it.next().monitor));
                } catch (Exception unused) {
                }
            }
            JSONObject basePayload = TTRequestBuilder.getBasePayload();
            try {
                basePayload.put("batch", new JSONArray((Collection) arrayList));
            } catch (Exception unused2) {
            }
            if (HttpRequestUtil.getCodeFromApi(TTRequest.reportMonitorEvent(basePayload)) != 0) {
                for (TTCrashReport.Monitor monitor : subList) {
                    tTCrashReport.addReport(monitor.monitor, System.currentTimeMillis(), monitor.attempt + 1);
                }
            }
            i = i2;
        }
        return tTCrashReport;
    }

    static class TTCrashReport implements Serializable {
        List<Monitor> reports = new ArrayList();

        TTCrashReport() {
        }

        static class Monitor implements Serializable {
            public int attempt;
            public final String monitor;
            public long ts;

            public Monitor(String o, long t, int a2) {
                this.monitor = o;
                this.ts = t;
                this.attempt = a2;
            }
        }

        public void addReport(String o, long t, int a2) {
            if (a2 < 2) {
                this.reports.add(new Monitor(o, t, a2));
            }
        }
    }

    private static void persistException(Throwable ex, int type) {
        JSONObject healthMonitorBase;
        JSONObject jSONObject = null;
        try {
            healthMonitorBase = TTRequestBuilder.getHealthMonitorBase();
        } catch (Exception unused) {
        }
        try {
            healthMonitorBase.put("monitor", TTUtil.getMonitorException(ex, null, type));
            crashReport.addReport(healthMonitorBase.toString(), System.currentTimeMillis(), 0);
            saveToFile(crashReport);
            crashReport = new TTCrashReport();
        } catch (Exception unused2) {
            jSONObject = healthMonitorBase;
            if (jSONObject != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(jSONObject);
                JSONObject basePayload = TTRequestBuilder.getBasePayload();
                try {
                    basePayload.put("batch", new JSONArray((Collection) arrayList));
                } catch (Exception unused3) {
                }
                TTRequest.reportMonitorEvent(basePayload);
            }
        }
    }

    private static void saveToFile(TTCrashReport cr) {
        try {
            FileOutputStream openFileOutput = TikTokBusinessSdk.getApplicationContext().openFileOutput(CRASH_REPORT_FILE, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);
            objectOutputStream.writeObject(cr);
            objectOutputStream.close();
            openFileOutput.close();
        } catch (Exception unused) {
            reportMonitor(cr);
        }
    }

    private static TTCrashReport readFromFile() {
        TTCrashReport tTCrashReport = new TTCrashReport();
        try {
            FileInputStream openFileInput = TikTokBusinessSdk.getApplicationContext().openFileInput(CRASH_REPORT_FILE);
            tTCrashReport = TTSafeReadObjectUtil.safeReadTTCrashHandler(openFileInput);
            openFileInput.close();
            return tTCrashReport;
        } catch (Exception unused) {
            return tTCrashReport;
        }
    }

    private static String getStackTrace(Throwable t) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : t.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        return sb.toString();
    }

    public static boolean isTTSDKRelatedException(Throwable e) {
        if (e == null) {
            return false;
        }
        Throwable th = null;
        while (e != null && e != th) {
            if (isTTSDKRelatedException(e.getStackTrace())) {
                return true;
            }
            th = e;
            e = e.getCause();
        }
        return false;
    }

    public static boolean isTTSDKRelatedException(StackTraceElement[] elts) {
        if (elts == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : elts) {
            if (stackTraceElement.getClassName().startsWith("com.tiktok")) {
                return true;
            }
        }
        return false;
    }
}
