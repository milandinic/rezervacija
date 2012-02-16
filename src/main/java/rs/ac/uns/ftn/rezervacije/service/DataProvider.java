package rs.ac.uns.ftn.rezervacije.service;

import java.io.Serializable;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@SuppressWarnings("serial")
public abstract class DataProvider<T extends Serializable> implements IDataProvider<T> {

    public void detach() {
        // TODO Auto-generated method stub

    }

    public IModel<T> model(T object) {
        return new Model<T>(object);
    }
}
