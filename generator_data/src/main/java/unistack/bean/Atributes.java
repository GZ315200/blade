package unistack.bean;

/**
 * @author Gyges Zean
 * @date 2018/3/12
 */
public class Atributes {

    private Integer id;

    private String col1;

    private String col2;

    public Atributes(Integer id, String col1, String col2) {
        this.id = id;
        this.col1 = col1;
        this.col2 = col2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atributes{");
        sb.append("id=").append(id);
        sb.append(", col1='").append(col1).append('\'');
        sb.append(", col2='").append(col2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
