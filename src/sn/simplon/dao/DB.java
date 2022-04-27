package sn.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    //Pour la connexion
    private Connection cnx;
    //Pour les resultats des requetes de type SELECT
    private ResultSet rs;
    //Pour les requetes preparees
    private PreparedStatement pstm;
    //Pour les resultats des requetes de type mise à jour Insert/Update/Delete
    private int ok;

    private void getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/java_tp_jdbc";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void initPrepar(String sql)
    {
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect()
    {
        rs = null;
        try {
            rs = pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public void CloseConnection()
    {
      try {
          if (cnx != null){
              cnx.close();
          }

      }catch (Exception ex){
          ex.printStackTrace();
      }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}
