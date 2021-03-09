package br.com.apiwk.repository;

//import br.com.apiwk.configuration.DataConfiguration;
import br.com.apiwk.models.Pessoa;
//import java.sql.*;
//import java.sql.SQLException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;



import org.springframework.data.repository.CrudRepository;

//import com.sun.jdi.connect.spi.Connection;



public interface PessoaRepository extends CrudRepository<Pessoa, String> {
	
	Pessoa findById(long id);
	
	Pessoa findByEstado(String estado);
	
/*
	
	public List<Pessoa> listar(){
		
		
		List<Pessoa> pessoas = New ArrayList<>();
		
		
		Connection con = Connection.getConnetion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		pstm = con.preparedStatement("select * from pessoa where estado = ?");
		rs = pstm.executeQuery();
		
	}
	catch(SQLException ErroSql)
	{
	}

		
		return pessoas;
	}
	
	*/
	
}
