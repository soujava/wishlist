package sh.platform.template;

import jakarta.nosql.mapping.Repository;

import java.util.List;

public interface WishRepository extends Repository<Wish, String> {

    List<Wish> findAll();

}
