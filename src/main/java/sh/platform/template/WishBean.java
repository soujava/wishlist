package sh.platform.template;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class WishBean {

    @Inject
    private WishRepository repository;

    private String wish = "";

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public void add() {
        repository.save(Wish.of(wish));
        this.wish = "";
    }

    public List<Wish> getWishes() {
        return repository.findAll();
    }

    public void remove(String id) {
        repository.deleteById(id);
    }
}
