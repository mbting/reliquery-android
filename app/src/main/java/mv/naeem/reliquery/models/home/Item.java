package mv.naeem.reliquery.models.home;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("vaulted")
    @Expose
    private Boolean vaulted;
    @SerializedName("parts")
    @Expose
    private List<Part> parts = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVaulted() {
        return vaulted;
    }

    public void setVaulted(Boolean vaulted) {
        this.vaulted = vaulted;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}
