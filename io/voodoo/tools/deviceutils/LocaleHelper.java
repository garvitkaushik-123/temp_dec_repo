package io.voodoo.tools.deviceutils;

import android.content.res.Resources;
import java.util.Locale;

/* loaded from: classes8.dex */
public class LocaleHelper {
    public static String getCurrentLocaleString() {
        try {
            Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Exception unused) {
            return "";
        }
    }
}
