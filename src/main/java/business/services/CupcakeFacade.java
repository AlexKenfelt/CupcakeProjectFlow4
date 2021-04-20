package business.services;

import business.entities.Bottom;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.util.List;

public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) {

    }

    public List<Topping> getAllTopping() throws UserException {

        return cupcakeMapper.getAllTopping();
    }

    public List<Bottom> getAllBottom() throws UserException {

        return cupcakeMapper.getAllBottoms();
    }


}
