package Mabayahomeexam.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A side helper class, used to read the json object of the serveAd request.
 */
public class CategoryReader {
    private String category;

    public CategoryReader(@JsonProperty("category") String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }
}
