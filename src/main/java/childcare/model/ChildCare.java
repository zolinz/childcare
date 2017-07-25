package childcare.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChildCare{

    private List<Child> children;

    public ChildCare() {
        children = new ArrayList<Child>();

        Child c1 = new Child();
        c1.setId(1);
        c1.setFirstName("Sebastian");
        c1.setLastName("Kovacs");

        Child c2 = new Child();
        c2.setId(2);
        c2.setFirstName("Kornel");
        c2.setLastName("Kovacs");

        children.add(c1);
        children.add(c2);

    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
