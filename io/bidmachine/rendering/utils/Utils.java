package io.bidmachine.rendering.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* loaded from: classes8.dex */
public class Utils {
    public static Handler createHandlerWithMyOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return new Handler(myLooper);
    }

    public static Date getDate(int daysAgo) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, -daysAgo);
        return calendar.getTime();
    }

    public static byte[] getMD5(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bytes);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void set(Collection<T> main, Collection<T> source) {
        main.clear();
        if (source != 0) {
            main.addAll(source);
        }
    }

    public static Boolean toBoolean(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Boolean) {
            return (Boolean) object;
        }
        if (object instanceof String) {
            return Boolean.valueOf(Boolean.parseBoolean((String) object));
        }
        return null;
    }

    public static Integer toIntOrNull(String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(value));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer toInteger(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Integer) {
            return (Integer) object;
        }
        if (object instanceof Long) {
            return Integer.valueOf(((Long) object).intValue());
        }
        if (object instanceof Float) {
            return Integer.valueOf(((Float) object).intValue());
        }
        if (object instanceof Double) {
            return Integer.valueOf(((Double) object).intValue());
        }
        if (object instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) object));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Long toLong(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Long) {
            return (Long) object;
        }
        if (object instanceof Integer) {
            return Long.valueOf(((Integer) object).longValue());
        }
        if (object instanceof Float) {
            return Long.valueOf(((Float) object).longValue());
        }
        if (object instanceof Double) {
            return Long.valueOf(((Double) object).longValue());
        }
        if (object instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) object));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object instanceof String ? (String) object : String.valueOf(object);
    }

    public static long write(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, V> void set(Map<T, V> main, Map<T, V> source) {
        main.clear();
        if (source != 0) {
            main.putAll(source);
        }
    }
}
