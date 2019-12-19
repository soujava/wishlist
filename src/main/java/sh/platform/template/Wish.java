package sh.platform.template;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.Objects;

@Entity
public class Wish {

    @Id
    @Convert(ObjectIdConverter.class)
    private String id;

    @Column
    private String dream;

    public String getId() {
        return id;
    }

    public String getDream() {
        return dream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wish wish = (Wish) o;
        return Objects.equals(id, wish.id) &&
                Objects.equals(dream, wish.dream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dream);
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id='" + id + '\'' +
                ", dream='" + dream + '\'' +
                '}';
    }

    public static Wish of(String dream) {
        Objects.requireNonNull(dream, "dream is required");
        Wish wish = new Wish();
        wish.dream = dream;
        return wish;
    }
}
