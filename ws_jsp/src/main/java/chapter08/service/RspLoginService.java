package chapter08.service;

import java.sql.SQLException;
import java.util.List;

import chapter08.dao.RspDAO;
import chapter08.dto.RspDTO;

public class RspLoginService {
    public boolean loginCheck(String id, String pw) throws SQLException {
        boolean flag = false;
        RspDAO rspDAO = new RspDAO();
        
        List<RspDTO> list = rspDAO.select();
        
        for (RspDTO user : list) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                flag = true;
                break;
            }
        }
        
        return flag;
    }
}
