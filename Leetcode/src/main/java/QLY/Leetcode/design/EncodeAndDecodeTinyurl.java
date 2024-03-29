package QLY.Leetcode.design;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
 *535. TinyURL 的加密与解密
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 */
public class EncodeAndDecodeTinyurl {

    HashMap<String , String> map = new HashMap<>();
    Base64.Encoder urlEncoder = Base64.getUrlEncoder();
    Base64.Decoder urlDecoder = Base64.getUrlDecoder();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = String.valueOf(longUrl.hashCode());
        String key = new String(urlEncoder.encode(hash.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        map.put(key, longUrl);

        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyurl encodeAndDecodeTinyurl = new EncodeAndDecodeTinyurl();
        String encode = encodeAndDecodeTinyurl.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = encodeAndDecodeTinyurl.decode(encode);
        System.out.println(decode);
    }
}
