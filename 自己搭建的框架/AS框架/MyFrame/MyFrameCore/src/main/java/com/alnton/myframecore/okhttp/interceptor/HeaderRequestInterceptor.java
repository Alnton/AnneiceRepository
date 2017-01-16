package com.alnton.myframecore.okhttp.interceptor;

        import com.alnton.myframecore.okhttp.OKHttpUtil;

        import java.io.IOException;
        import java.util.concurrent.ConcurrentHashMap;

        import okhttp3.Interceptor;
        import okhttp3.Request;
        import okhttp3.Response;

/**
 * @author 王乾州
 * @explain 对请求体统一添加header拦截器
 * @time 2016/10/26 17:00.
 */
public class HeaderRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (null != OKHttpUtil.instance.headerMap && !OKHttpUtil.instance.headerMap.isEmpty()) {
            Request.Builder builder = originalRequest.newBuilder();
            for (ConcurrentHashMap.Entry<String, String> entry : OKHttpUtil.instance.headerMap.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        return chain.proceed(originalRequest);
    }
}