package com.robot.admin.util;

/**
 * @author robot
 * @date 2019/12/26 14:47
 */
public class StaticUtil {

    public static int out_time = 24 * 3600 * 1000;

    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer";

    public static final String clientId = "098f6bcd4621d373cade4e832627b4f6";

    public static final String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";

    public static final String name = "user";

    public static final int expiresSecond = 2*60*60*1000;

    //ras 公钥
    public static final String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkBiZpzUAETelvbe8Q8g8BGjCvEC7i+McdFNlevcThgBsEu+qELhj+bGeAWdmRzOq0hTUBdiNU4ydyai4+Ru1btjzYfIncjlGefbsL7JtVquKhsH5C1AVaaJsKZagZMZUFyZV6QVwCmERYFmP3duq1sqSWA/VFO1MZJ9mCUMj1twD8YN7ftZGW3w2G/xSihq9yZS6ANzTGgdO8TDJsEMLb+uE7A5ymsX8RDwguaI/TkoFt3KcW/YNHlLzmpRJ58+QXz01T4QdkGOQhbKvUzyEaYKW3g7stHcfkq/cwla/GI4PrqcBjLh2laHYQZbdm5DwkWexEsb2VF9Jd1b39M8dywIDAQAB";

    //ras 私钥
    public static final String privateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCQGJmnNQARN6W9t7xDyDwEaMK8QLuL4xx0U2V69xOGAGwS76oQuGP5sZ4BZ2ZHM6rSFNQF2I1TjJ3JqLj5G7Vu2PNh8idyOUZ59uwvsm1Wq4qGwfkLUBVpomwplqBkxlQXJlXpBXAKYRFgWY/d26rWypJYD9UU7Uxkn2YJQyPW3APxg3t+1kZbfDYb/FKKGr3JlLoA3NMaB07xMMmwQwtv64TsDnKaxfxEPCC5oj9OSgW3cpxb9g0eUvOalEnnz5BfPTVPhB2QY5CFsq9TPIRpgpbeDuy0dx+Sr9zCVr8Yjg+upwGMuHaVodhBlt2bkPCRZ7ESxvZUX0l3Vvf0zx3LAgMBAAECggEAZAywoyhpo4q/ybqJPYcKJQWYMJ3Bmp9WYm6FR5vGMoSYhY1ix7k/sV9iFhd1LHrzYGqVzHlPp3M7G4nK5SwYDZ8VXiyEtwqNpKGN3JBG2qbAyFBmWzR/qZjdAQNU2qPaPzie7eyYnpxHNF77RVAAjqKYegyEJsOdB0Cl2EiF2ehZ+eCJvrq+SHyT0VN/xelLSNt+b6sOHVfWjDzmgOIDI5EM/KHw/vgxAtVdho7+rzN85FsOFgYmjUT+d52aYxi9WsjJkV2Ez0tC6mf+0XA6YBpdh9lRzwWYLSETrKj81XZ5NvMHRObM9HGJXOpt+tFiGRx7936KHlprLLIIq9BUAQKBgQDpp75SVLSFea+atCsIRAzwXbFCRGwR8a3K5k4F/ZSehQ/9cHeP3lia2VQvW9aIfH6+y7XK9zw0RPtPCgdo+09Ad5Lps2ZpCwad2FAOcw+BiYBrdvgiknw53MDeCCPcih98Kfl5g2SEEBVw9C4fy+JioinHSj6y0Z0Vedx0wrbXgwKBgQCd4E32OIJD7KE9tnLb9BcRMJ8EGGGlBqaize1H2eErt0GDFcod9c33Op9jtQn5cKgaf/Iuu2K7kz8XzT3szT+t8ycHxamkbSYd8THJ9YO35DZkGV5L4tar0PnKzUzvhvExr/7qBGNUTb+LOgjnunEuo/+BQS6ZwwDMnS3hXM0GGQKBgQCni4Mr4lV4CKPlGSBqUvG8QlLjI9EipNxsS+zS2t0BNoUaxNTXMybyErkNJJuXTz5LbiOzoMlo6bYTHSvnGZ3gql2MevoKhL9/3Ca71cHer0yIwsx3bfbqPuOF0ux0Lg8Zp7eebJtdH3NghZe1cSuqcoHmx9RhwXEUf0eX6i/WJQKBgEsMf8MWJcaITDX77ynkJLsFM/JMbM54FOq7nZpUVpfja38W8pe/a4OlGHPbcbxj82V1gPj6Fvs4CfwUkuVoxGa6eclWC0igokgFijeJQG5ATCLVdF/6mzXeB4CCi5opuap3EWTJZTaEJxPWKLmPhZI4X5NgGvj5G/4okdDZvpSxAoGBANQlCHZLJCLkf4M+Yh0M+ud4qnwwybBOfQq5EoSOLxCwHTO4A8TTKBOx6oghm3eYAvPkxYc62QWBBRuhcNGOgOgrx+AbGcVIZUOm4G28IYb2gAqmkHnyvSWggrGgQuomMWWblcoCoC8DJIeIr4ft9CKrgtpoJ3vVoie3K00CQNXG";

    //阿里云accesKeyId
    public static final String aliyunAccessKeyId="LTAI4FoQ88NpNqCR7bNYy4dC";

    //阿里云accessKeySecret
    public static final String aliyunAccessKeySecret="KmkwlDrPBC68bgvZiNtrjonKIYmVT8";

    //验证码生效时间
    public static final int codeExpiryTime = 5 * 60;

    //阿里云短信key
    public static final String aliyunCode="SMS_183766323";

    public static final String default_name="普通会员";



}
