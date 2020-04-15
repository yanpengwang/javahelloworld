import java.util.HashMap;

class Key {
    private Integer id;

    public Key(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


     public boolean equals(Object o) {
     if (o == null || !(o instanceof Key))
     { return false; }
     else
     { return this.getId().equals(((Key) o).getId());}
     }

     public int hashCode()
     { return id.hashCode(); }
}


public class WithoutHashCode {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key, String> hm = new HashMap<Key, String>();
        hm.put(k1, "Key with id is 1");
        System.out.println(hm.get(k2));
    }
}