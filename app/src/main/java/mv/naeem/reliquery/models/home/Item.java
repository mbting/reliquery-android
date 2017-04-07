package mv.naeem.reliquery.models.home;

import java.util.List;

public class Item {
    public Integer id;
    public String name;
    public Boolean vaulted;
    public List<ItemPart> parts;

    public Item(Integer id, String name, Boolean vaulted, List<ItemPart> parts) {
        this.id = id;
        this.name = name;
        this.vaulted = vaulted;
        this.parts = parts;
    }
}
