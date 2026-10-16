package com.mbridge.msdk.util;

import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: AllTypeErrorMsgToCodeUtils.java */
/* loaded from: classes6.dex */
public class a {
    public static int a(int i, String str) {
        int i2;
        try {
            if (!TextUtils.isEmpty(str)) {
                int i3 = 15;
                if (str.startsWith("errorCode: ") && str.length() > 16) {
                    return Integer.parseInt(str.substring(11, 15));
                }
                if (!str.equals("do not have sorceList")) {
                    if (!str.equals("Network error,UnknownHostException")) {
                        if (!str.equals("v3 is timeout")) {
                            if (!str.equals("Current unit is loading!") && !str.equals("current unit is loading")) {
                                if (!str.equals("Network error,I/O exception response null")) {
                                    if (!str.equals("Network error,ConnectException")) {
                                        if (!str.equals("Network error,socket timeout exception")) {
                                            if (!str.equals("Network error,disconnected network exception")) {
                                                if (!str.equals("Network error,timeout exception")) {
                                                    if (!str.startsWith("Network error,please check state code")) {
                                                        if (!str.equals("Network error,I/O exception contents null")) {
                                                            if (!str.equals("Network unknown error")) {
                                                                if (str.equals("Network error,I/O exception")) {
                                                                    i2 = i + 600;
                                                                    i3 = 13;
                                                                } else if (str.equals("web env is not support")) {
                                                                    i2 = i + 600;
                                                                    i3 = 14;
                                                                } else if (str.equals("Network error,unknown")) {
                                                                    i2 = i + 600;
                                                                } else if (str.equals("Network error，sslp exception")) {
                                                                    i2 = i + 600;
                                                                    i3 = 16;
                                                                } else if (str.startsWith("Cast exception, return data")) {
                                                                    i2 = i + 600;
                                                                    i3 = 17;
                                                                } else if (str.equals("REQUEST_TIMEOUT")) {
                                                                    i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                } else if (str.startsWith("The server returns an exception")) {
                                                                    i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                } else {
                                                                    if (!str.equals("APP ALREADY INSTALLED") && !str.equals("Need show campaign list is NULL!")) {
                                                                        if (str.startsWith("load no ad")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("EXCEPTION_UNIT_NOT_FOUND_IN_APP")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("EXCEPTION_UNIT_BIDDING_TYPE_ERROR")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("No video campaign")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("EXCEPTION_RETURN_EMPTY")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("EXCEPTION_APP_PLATFORM_ERROR")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("EXCEPTION_SERVICE_REQUEST_OS_VERSION_REQUIRED")) {
                                                                            i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                        } else if (str.equals("banner res load failed")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.equals("resource load timeout is tpl: false")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.startsWith("resource download failed")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.equals("temp preload success but isReady false")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.equals("temp resource download failed")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.equals("tpl temp resource download failed")) {
                                                                            i2 = i + 800;
                                                                        } else if (str.equals("resource load timeout is tpl: true")) {
                                                                            i2 = i + 800;
                                                                        } else {
                                                                            if (!str.startsWith("https://") && !str.startsWith("http://")) {
                                                                                if (str.equals("mraid resource write fail")) {
                                                                                    i2 = i + 800;
                                                                                } else if (str.startsWith("data save failed:")) {
                                                                                    i2 = i + 800;
                                                                                } else if (str.equals("resource load timeout")) {
                                                                                    i2 = i + 800;
                                                                                } else if (str.startsWith("tpl temp preload failed")) {
                                                                                    i2 = i + 800;
                                                                                }
                                                                            }
                                                                            i2 = i + 800;
                                                                        }
                                                                        i3 = 4;
                                                                    }
                                                                    i2 = i + IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                                                                }
                                                                return i2 + i3;
                                                            }
                                                            i2 = i + 600;
                                                            i3 = 12;
                                                            return i2 + i3;
                                                        }
                                                        i2 = i + 600;
                                                        i3 = 11;
                                                        return i2 + i3;
                                                    }
                                                    i2 = i + 600;
                                                    i3 = 10;
                                                    return i2 + i3;
                                                }
                                                i2 = i + 600;
                                                i3 = 9;
                                                return i2 + i3;
                                            }
                                            i2 = i + 600;
                                            i3 = 8;
                                            return i2 + i3;
                                        }
                                        i2 = i + 600;
                                        i3 = 7;
                                        return i2 + i3;
                                    }
                                    i2 = i + 600;
                                    i3 = 6;
                                    return i2 + i3;
                                }
                                i2 = i + 600;
                                i3 = 5;
                                return i2 + i3;
                            }
                            i2 = i + 600;
                            i3 = 4;
                            return i2 + i3;
                        }
                        i2 = i + 600;
                        i3 = 3;
                        return i2 + i3;
                    }
                    i2 = i + 600;
                    i3 = 2;
                    return i2 + i3;
                }
                i2 = i + 600;
                i3 = 1;
                return i2 + i3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int b(int i, String str) {
        return i + DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
    }
}
