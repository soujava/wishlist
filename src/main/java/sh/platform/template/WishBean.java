package sh.platform.template;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class WishBean {

    @Inject
    private WishRepository repository;

    private Wish bean = new Wish();


    public Wish getBean() {
        return bean;
    }

    public void setBean(Wish bean) {
        this.bean = bean;
    }

    public void add() {
        repository.save(bean);
        this.bean = new Wish();
    }

    public List<Wish> getWishes() {
        return repository.findAll();
    }

    public void remove(String id) {
        repository.deleteById(id);
    }
}
