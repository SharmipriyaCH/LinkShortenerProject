// Updated for Git tracking issue

import java.util.HashMap;

public class URLShortener {
    private HashMap<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "http://short.ly/";

    public String shortenURL(String longURL) {
        String shortCode = Integer.toHexString(longURL.hashCode());
        urlMap.put(shortCode, longURL);
        return BASE_URL + shortCode;
    }

    public String expandURL(String shortURL) {
        String shortCode = shortURL.replace(BASE_URL, "");
        return urlMap.getOrDefault(shortCode, "URL not found");
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        String originalURL = "https://example.com/long-url-example";
        String shortURL = shortener.shortenURL(originalURL);

        System.out.println("Original URL: " + originalURL);
        System.out.println("Short URL: " + shortURL);
        System.out.println("Expanded URL: " + shortener.expandURL(shortURL));
    }
}
