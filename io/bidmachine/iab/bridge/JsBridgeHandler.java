package io.bidmachine.iab.bridge;

import android.text.TextUtils;
import com.ironsource.sdk.controller.f;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.mraid.MraidUtils;
import io.bidmachine.iab.mraid.MraidWebView;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class JsBridgeHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final List<JsBridge> f6794a = new CopyOnWriteArrayList();

    private static JsBridge a(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        for (JsBridge jsBridge : f6794a) {
            if (jsBridge.isHandled(url)) {
                return jsBridge;
            }
        }
        return null;
    }

    public static boolean addBridge(JsBridge bridge) {
        List<JsBridge> list = f6794a;
        return !list.contains(bridge) && list.add(bridge);
    }

    public static void handleJsCommand(MraidWebView webView, String commandUrl) {
        Map<String, String> parseCommandUrl;
        MraidLog.d("JsBridgeHandler", "handleJsCommand - %s", commandUrl);
        try {
            JsBridge a2 = a(commandUrl);
            if (a2 != null && (parseCommandUrl = MraidUtils.parseCommandUrl(commandUrl, a2.getJsValidator())) != null) {
                String str = parseCommandUrl.get(f.b.g);
                if (str == null) {
                    MraidLog.w("JsBridgeHandler", "handleJsCommand not found", new Object[0]);
                } else {
                    a2.runJsCommand(webView, str, parseCommandUrl);
                }
            }
        } catch (Throwable th) {
            MraidLog.e("JsBridgeHandler", th);
        }
    }

    public static boolean isHandled(String commandUrl) {
        return a(commandUrl) != null;
    }

    public static String obtainJs() {
        StringBuilder sb = new StringBuilder();
        for (JsBridge jsBridge : f6794a) {
            sb.append("<script type='application/javascript'>");
            sb.append(jsBridge.getJs());
            sb.append("</script>");
        }
        return sb.toString();
    }

    public static boolean removeBridge(JsBridge bridge) {
        List<JsBridge> list = f6794a;
        return list.contains(bridge) && list.remove(bridge);
    }
}
