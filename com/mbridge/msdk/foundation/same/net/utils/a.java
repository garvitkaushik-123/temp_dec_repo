package com.mbridge.msdk.foundation.same.net.utils;

/* compiled from: CommonHttpConfig.java */
/* loaded from: classes6.dex */
public class a {
    public static String a(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i = aVar.f4288a;
            com.mbridge.msdk.foundation.same.net.toolbox.a aVar2 = aVar.c;
            int i2 = aVar2 != null ? aVar2.d : 0;
            if (i == -2) {
                return "Network is canceled";
            }
            if (i == 15) {
                return "Network error,I/O exception contents null";
            }
            if (i == 880023) {
                return "timeout";
            }
            if (i == 880041) {
                return "Network error,UnknownHostException";
            }
            switch (i) {
                case 1:
                    return "Network error,Load failed";
                case 2:
                    return "Network error,I/O exception";
                case 3:
                    return "Network error,timeout exception";
                case 4:
                    return "Network unknown error";
                case 5:
                    return "Network error，https is not work,please check your phone time";
                case 6:
                    return i2 != 0 ? "Network error,please check state code " + i2 : "Network error,please check ";
                case 7:
                    return i2 != 0 ? "The server returns an exception state code " + i2 : "The server returns an exception ";
                case 8:
                    return "Cast exception, return data can not be casted correctly";
                default:
                    switch (i) {
                        case 10:
                            return "Network error,socket timeout exception";
                        case 11:
                            return "Network error，sslp exception";
                        case 12:
                            return "Network error,ConnectException";
                        case 13:
                            if (aVar2 == null) {
                                return "Unknown socket exception";
                            }
                            byte[] bArr = aVar2.f4296a;
                            return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                        default:
                            return "Network error,unknown";
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
