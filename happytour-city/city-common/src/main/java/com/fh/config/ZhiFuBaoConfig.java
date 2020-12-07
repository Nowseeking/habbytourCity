package com.fh.config;

public class ZhiFuBaoConfig {


    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016110100782928";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDSgMZUs4nwzgjXa5aXNHKKvaw9x4OoBQ3pw6CsRDllRSMfQViATeXF5VDOmPRenKf0Jv5V/OArruBgkzPufeWlSYSx5dqtPIaqeVBwM5wQYt7jq6YHFDiN7TZc2cN6KieQkRD+CUX2xaHuCCeT2M4PqkLXORpf7ntSFnNP29ytBLIqBkL1pnYlUIBt56LWvjfJD8Rgyyx5qpY15HwmBTjWjKY1Hpb0Vk5r+OfVIZY8KXtpTW3KA5pJbDcSibwQmUAE8mCnqaHO22qXoFDUXUN6Raqx+TqF5DJL1T1TyLi3ZAFTpMwRmal1Zh/uXnhRH3Fsgf4Fvj/8X6MoIfr9M/snAgMBAAECggEAdF96xcLH5JeS7bzt8MOu+yKmwTS2hUHeEjjzb6j77g+Nvi67BZuLBp+iz8RhfJiwhVq1SsZVC/FO3DUlBZkWRw1gzZScEx+d90q//HebtLdkL4tqawlzxoq4fhZpafU6EEMSmM55nlZeEiDx+Ftod+KRtzg7a4OFK7l7oE+VLRSltbBlFK92WVJpE6cxUSirkrwZl6yv5zQvud18hqBYw8UNT5xXgHK0WAsrRrMIqyT5Lj3I8yzesU+1ePDavY9Q4kTmZkPrkEfEeKrKuzhF9KFdVcq4G5f/Gqhe4OUcjK4beBfkVTLjS1VY5hmzoxv/CR69+CYM2fQXmqa+U1j+sQKBgQDwA9+E7Eta1/Pt3TrgQ766MC0DFFv/WfRz2121pAG+3dtCszQvePqRlsudhvFPKG3Cw3IZQXZwZo89ZjTdqzoHxzWgjgm0yXBF6aa2Eve9IJw5Q7ztOMjvXadpKFKZ2C11cHSCa3FKmpyIsxqqT2wcCusqghNctqkYKgKLKtFsPwKBgQDghbyCk9dYCLZXIJ3qQpqO1behXrRTLH/37ivdS0+vY0untzyFlzIvbyv7F4v5gf15GpczX79zn5Dg4cDmSuc2I3RD1UvjA73Zkw103mMtf7OldGy+38xaYIczMDsap7a/K164j1HOy82xvwXsrjT2DllPnHt9lrj4OWjD+0lXGQKBgQDr5/KnNJVwSbgBAKQgz5VEbZugXj96QVFLGr8FjJkGoAsliPvu+SrXNG8Xew3tbuBLQU0BU9105uk9QRsPEYAtKvkjwNf7cM7AeMIaTZRguQ+0HUcxptGgq92jNzXQ7rDnsEtj8PTejg7zMY8w/HVXLsgr9MPRKdwT2x666LAEgwKBgGkq+7QGYDZiTlbddlrGu/Lv9MXnwHu9Omv96hoMLtUuo795uyWwPtetMWK6EtzaoMpbRDvSO7GDKq/LzzmQGGFplgo4HQXHOORzVzhI+xfS22lC8bUuy2ACGxJFI0pHCPje7c1xhJZjLIR3v+SvbStcaUU7PTUEprvO2F4ElMPxAoGAe6sFHAS4DIaGto/k55hiVxkWzQT6lsOVhvBYQM95yw3lp4w0p4poXPP8iH0b6gAe5R9U/51VpEMlgHZdy5YMhEYcAE478cz2nJHv0Bd5ma+n7Re1enTV95WzvOaJiDo9yCgOAqwwS6X0svjvR2hI0GMvIoV0LbwvUyGjfDL3098=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA/H+q3j+bzdtFs7oPGBGzmY7FT1z6svkPKL5A6IgYOK3Y+kjX6opVEwubHZTcAUjzuQXi9fGnyBRnRoU+gVzUp960T71HWadmlqNe8A98GYwXX0Jzu134hNC6lhYxaIkJ1vUBYmou4CjTlU75uaFakEM7AhnqwtBKEx0QgaX+aOXphopfZE+QvQwGGnEPj4MPiUsXYMkfSxs259XmCQ4d6h4yFU5PWSIKBi4uC7T5YrG8SFCbiaHzFY6qzd6/04r1P6HMaF3GSi1zxb2W8Zadn+X2IkSwjqrZ/tan5NHXD0AaVEPbuQkU11ngpmBRM8kaoF08E8FZAfQ4GfyB5wmZzQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://y8iter.natappfree.cc/order/updateAlistatus";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9090/Aliok";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

}
