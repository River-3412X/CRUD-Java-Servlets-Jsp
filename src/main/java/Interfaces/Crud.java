
package Interfaces;

import Models.Users;
import java.util.List;

public interface Crud {
    public List<Users> show_all()throws Exception;
    public Users show(int id)throws Exception;
    public int storage(Users usuario)throws Exception;
    public int update(Users usuario)throws Exception;
    public int eliminar(int id)throws Exception;
}
