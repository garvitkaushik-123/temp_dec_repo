package io.bidmachine.iab.mraid;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.ironsource.C3040d4;
import com.ironsource.sdk.controller.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class MraidUtils {
    public static final String ARG_OPEN_PRIVACY_SHEET_DATA = "data";
    public static final String COMMAND_URL_PREFIX = "mraid://";
    public static final int DEFAULT_CLOSE_TIME_SEC = 3;
    static String d;
    public static String dynamicMraidJs;
    public static final long MAX_ON_SCREEN_TIME_MS = TimeUnit.SECONDS.toMillis(30);
    public static final String COMMAND_OPEN_PRIVACY_SHEET = "openPrivacySheet";

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f6818a = Arrays.asList("close", n.e, "open", "playVideo", n.g, "setOrientationProperties", "setResizeProperties", "useCustomClose", "noFill", C3040d4.h.r, "AdStarted", "AdStopped", "AdSkipped", "AdSkippableStateChange", "AdVideoStart", "AdVideoFirstQuartile", "AdVideoMidpoint", "AdVideoThirdQuartile", "AdVideoComplete", "AdUserClose", "AdPaused", "AdPlaying", "AdClickThru", "AdLog", "AdError", "createCalendarEvent", "storePicture", COMMAND_OPEN_PRIVACY_SHEET);
    private static final char[] b = {'\"', '\''};
    private static final MraidJsValidator c = new b();

    private static class b implements MraidJsValidator {
        private b() {
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public boolean checkParamsForCommand(String command, Map<String, String> params) {
            return MraidUtils.b(command, params);
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public boolean isValidCommand(String command) {
            return MraidUtils.b(command);
        }

        @Override // io.bidmachine.iab.mraid.MraidJsValidator
        public String removePrefix(String commandUrl) {
            return commandUrl.substring(8);
        }
    }

    static String b() {
        String str = dynamicMraidJs;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (d == null) {
            d = new String(Base64.decode(MraidJs.JS, 0)).replace("%%VERSION%%", "");
        }
        return d;
    }

    public static View getRootViewFromActivity(final Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View getRootViewFromView(final View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(R.id.content);
        return findViewById != null ? findViewById : rootView;
    }

    public static View getTopmostView(final Context context, final View view) {
        View rootViewFromActivity = getRootViewFromActivity(context);
        return rootViewFromActivity != null ? rootViewFromActivity : getRootViewFromView(view);
    }

    public static View obtainRootView(Context context, View view) {
        View topmostView = getTopmostView(context, view);
        return topmostView instanceof ViewGroup ? (ViewGroup) topmostView : view;
    }

    public static Map<String, String> parseCommandUrl(String commandUrl) {
        return parseCommandUrl(commandUrl, c);
    }

    public static String processRawHtml(String rawHtml) {
        StringBuffer stringBuffer = new StringBuffer(rawHtml);
        List<Pair<Integer, Integer>> a2 = a(rawHtml, b);
        boolean b2 = b(rawHtml, AnalyticsConstants.CREATIVE_TYPE_HTML, a2);
        boolean b3 = b(rawHtml, "head", a2);
        boolean b4 = b(rawHtml, "body", a2);
        if ((!b2 && (b3 || b4)) || (b2 && !b4)) {
            return rawHtml;
        }
        if (!b2) {
            stringBuffer.insert(0, "<html><head></head><body><div align=\"center\">");
            stringBuffer.append("</div></body></html>");
        } else if (!b3) {
            Matcher matcher = Pattern.compile("<html[^>]*>", 2).matcher(stringBuffer);
            for (int i = 0; matcher.find(i); i = matcher.end()) {
                stringBuffer.insert(matcher.end(), "<head></head>");
            }
        }
        a(stringBuffer);
        return stringBuffer.toString();
    }

    public static Map<String, String> parseCommandUrl(String commandUrl, MraidJsValidator validator) {
        MraidLog.d("parseCommandUrl", commandUrl, new Object[0]);
        String removePrefix = validator.removePrefix(commandUrl);
        HashMap hashMap = new HashMap();
        int indexOf = removePrefix.indexOf(63);
        if (indexOf != -1) {
            String substring = removePrefix.substring(0, indexOf);
            for (String str : removePrefix.substring(indexOf + 1).split(C3040d4.i.c)) {
                int indexOf2 = str.indexOf(61);
                hashMap.put(str.substring(0, indexOf2), str.substring(indexOf2 + 1));
            }
            removePrefix = substring;
        }
        if (!validator.isValidCommand(removePrefix)) {
            MraidLog.w(f.b.g, "%s is unknown", removePrefix);
            return null;
        }
        if (!validator.checkParamsForCommand(removePrefix, hashMap)) {
            MraidLog.w(f.b.g, "URL %s is missing parameters", commandUrl);
            return null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(f.b.g, removePrefix);
        hashMap2.putAll(hashMap);
        return hashMap2;
    }

    static int a(String where, String tag, List<Pair<Integer, Integer>> restrictedRangeList) {
        if (!TextUtils.isEmpty(where) && !TextUtils.isEmpty(tag)) {
            if (restrictedRangeList == null) {
                restrictedRangeList = a(where, b);
            }
            Matcher matcher = Pattern.compile(String.format("<%s[^>]*>", tag), 2).matcher(where);
            while (matcher.find()) {
                int end = matcher.end();
                if (a(end, restrictedRangeList)) {
                    return end;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String command) {
        return f6818a.contains(command);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String command, Map<String, String> params) {
        command.hashCode();
        command.hashCode();
        switch (command) {
            case "playVideo":
            case "open":
            case "storePicture":
                return params.containsKey("url");
            case "openPrivacySheet":
                return params.containsKey("data");
            case "createCalendarEvent":
                return params.containsKey("eventJSON");
            case "setOrientationProperties":
                return params.containsKey("allowOrientationChange") && params.containsKey("forceOrientation");
            case "setResizeProperties":
                return params.containsKey("width") && params.containsKey("height") && params.containsKey("offsetX") && params.containsKey("offsetY") && params.containsKey("customClosePosition") && params.containsKey("allowOffscreen");
            case "useCustomClose":
                return params.containsKey("useCustomClose");
            default:
                return true;
        }
    }

    static void a(StringBuffer processedHtml) {
        int a2;
        if (!TextUtils.isEmpty(processedHtml) && (a2 = a(processedHtml.toString(), "head", null)) > -1) {
            processedHtml.insert(a2, a());
        }
    }

    static List<Pair<Integer, Integer>> a(String where, char... searchChars) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(where) && searchChars != null) {
            try {
                int[] iArr = new int[searchChars.length];
                Arrays.fill(iArr, -1);
                for (int i = 0; i < where.length(); i++) {
                    char charAt = where.charAt(i);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= searchChars.length) {
                            break;
                        }
                        if (charAt == searchChars[i2]) {
                            int i3 = iArr[i2];
                            if (i3 > -1) {
                                arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
                                iArr[i2] = -1;
                            } else {
                                iArr[i2] = i;
                            }
                        } else {
                            i2++;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private static boolean a(int position, List<Pair<Integer, Integer>> restrictedRangeList) {
        for (Pair<Integer, Integer> pair : restrictedRangeList) {
            if (position >= ((Integer) pair.first).intValue() && position <= ((Integer) pair.second).intValue()) {
                return false;
            }
        }
        return true;
    }

    static String a() {
        return "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\" /><style>body { margin:0; padding:0;}*:not(input) { -webkit-touch-callout:none; -webkit-user-select:none; -webkit-text-size-adjust:none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); }</style>";
    }

    private static boolean b(String where, String tag, List<Pair<Integer, Integer>> restrictedRangeList) {
        return a(where, tag, restrictedRangeList) > -1;
    }
}
