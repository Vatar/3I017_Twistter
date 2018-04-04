package servlet.message;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig

public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2862849723795965104L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		Part filePart=request.getPart("file");//si fichier associer a la clef "file"
		InputStream filecontext=filePart.getInputStream();
		//lire getStream
		//enregistrer le ficher
		//Repondre au client
		
		/*Cote client 
			<form...>....
		*/
	}
	
	
	

}
