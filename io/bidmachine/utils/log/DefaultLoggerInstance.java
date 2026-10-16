package io.bidmachine.utils.log;

import android.util.Log;
import com.ironsource.C3040d4;
import io.bidmachine.utils.lazy.LazyValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes8.dex */
public class DefaultLoggerInstance implements LoggerInstance {
    private static final int MAX_CHAR_COUNT = 1000;
    private final String tag;

    protected boolean isLoggable(int priority) {
        return true;
    }

    public DefaultLoggerInstance(String tag) {
        this.tag = tag;
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(Object subTag, String message) {
        prepareAndLog(3, subTag, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(String message) {
        prepareAndLog(3, null, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(Object subTag, LazyValue<String> lazyMessage) {
        prepareAndLog(3, subTag, null, lazyMessage, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(LazyValue<String> lazyMessage) {
        prepareAndLog(3, null, null, lazyMessage, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Object subTag, String message) {
        prepareAndLog(5, subTag, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(String message) {
        prepareAndLog(5, null, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Object subTag, LazyValue<String> lazyMessage) {
        prepareAndLog(5, subTag, null, lazyMessage, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(LazyValue<String> lazyMessage) {
        prepareAndLog(5, null, null, lazyMessage, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Throwable throwable) {
        prepareAndLog(5, null, null, null, throwable);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(Object subTag, String message) {
        prepareAndLog(6, subTag, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(String message) {
        prepareAndLog(6, null, message, null, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(Object subTag, LazyValue<String> lazyMessage) {
        prepareAndLog(6, subTag, null, lazyMessage, null);
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(LazyValue<String> lazyMessage) {
        prepareAndLog(6, null, null, lazyMessage, null);
    }

    protected void prepareAndLog(int priority, Object subTag, String message, LazyValue<String> lazyMessage, Throwable throwable) {
        if (isLoggable(priority)) {
            log(priority, buildMessage(subTag, message, lazyMessage, throwable));
        }
    }

    protected void log(int priority, String message) {
        if (message.length() > 1000) {
            int length = (message.length() + 999) / 1000;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1000;
                printLog(priority, this.tag, message.substring(i2, Math.min(message.length(), i3)));
                i++;
                i2 = i3;
            }
            return;
        }
        printLog(priority, this.tag, message);
    }

    protected void printLog(int priority, String tag, String message) {
        Log.println(priority, tag, message);
    }

    protected String buildMessage(Object subTag, String message, LazyValue<String> lazyMessage, Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        if (subTag != null) {
            sb.append(C3040d4.i.d).append(subTag).append("] ");
        }
        if (message != null) {
            sb.append(message);
        } else if (lazyMessage != null) {
            sb.append(lazyMessage.get());
        }
        if (throwable != null) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(buildStackTraceString(throwable));
        }
        return sb.toString();
    }

    private static String buildStackTraceString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
