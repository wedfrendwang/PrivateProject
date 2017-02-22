package wedfrend.wang.privateproject.table;

import org.litepal.crud.DataSupport;

/**
 * Created by welive on 2017/2/22.
 */

public class Book extends DataSupport {


    private String name;

    private String author;

    private float prices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }
}
